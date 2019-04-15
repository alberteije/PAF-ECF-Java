/*
 * The MIT License
 *
 * Copyright: Copyright (C) 2014 T2Ti.COM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 * 
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.t2ti.integradorpaf.controller;

import com.t2ti.pafecf.integrador.bd.AcessoBanco;
import com.t2tierp.infra.java.IntegracaoPdvVO;
import com.t2tierp.pafecf.java.EcfFechamentoVO;
import com.t2tierp.pafecf.java.EcfMovimentoVO;
import com.t2tierp.pafecf.java.EcfNotaFiscalCabecalhoVO;
import com.t2tierp.pafecf.java.EcfNotaFiscalDetalheVO;
import com.t2tierp.pafecf.java.EcfR02VO;
import com.t2tierp.pafecf.java.EcfR03VO;
import com.t2tierp.pafecf.java.EcfR06VO;
import com.t2tierp.pafecf.java.EcfSangriaVO;
import com.t2tierp.pafecf.java.EcfSintegra60aVO;
import com.t2tierp.pafecf.java.EcfSintegra60mVO;
import com.t2tierp.pafecf.java.EcfSuprimentoVO;
import com.t2tierp.pafecf.java.EcfTotalTipoPagamentoVO;
import com.t2tierp.pafecf.java.EcfVendaCabecalhoVO;
import com.t2tierp.pafecf.java.EcfVendaDetalheVO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ImportaController {

    private EntityManager em;
    private AcessoBanco acessoBanco;
    private Date dataIntegracao;
    private String horaIntegracao;
    private Gson gson;
    private String nomeCaixa;

    public ImportaController() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gson = gsonBuilder.create();
        dataIntegracao = new Date();
        horaIntegracao = new SimpleDateFormat("HH:mm:ss").format(dataIntegracao);
        acessoBanco = new AcessoBanco();
    }

    private void abreConexao() {
        try {
            em = acessoBanco.conexaoRetaguarda();
        } catch (Exception ex) {
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro ao conectar ao banco de dados.\n" + ex.getMessage() + "\n" + ex.getCause().getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fechaConexao() {
        try {
            acessoBanco.desconectarRetaguarda();
        } catch (Exception ex) {
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro ao confirmar a transação no banco de dados.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void importaDadosPdv(File arquivo) throws Exception {
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader buffer = new BufferedReader(fileReader);
        String identificador = arquivo.getName();
        nomeCaixa = identificador.split("_")[1];
        int contador = 0;
        String jsonString = buffer.readLine();
        abreConexao();
        while (jsonString != null) {
            contador++;
            IntegracaoPdvVO integracaoPdvVO = null;
            try {
                Query query = em.createQuery("SELECT i FROM IntegracaoPdvVO i WHERE i.identifica = :identificador");
                query.setParameter("identificador", identificador + "_" + contador);
                integracaoPdvVO = (IntegracaoPdvVO) query.getSingleResult();
            } catch (NoResultException e) {
            }
            if (integracaoPdvVO == null) {
                try {
                    if (identificador.startsWith("VENDA")) {
                        importaVenda(jsonString);
                    } else if (identificador.startsWith("NF")) {
                        importaNotaFiscal(jsonString);
                    } else if (identificador.startsWith("MOVIMENTO")) {
                        importaMovimento(jsonString);
                    } else if (identificador.startsWith("R02")) {
                        importaR02(jsonString);
                    } else if (identificador.startsWith("R06")) {
                        importaR06(jsonString);
                    } else if (identificador.startsWith("SINTEGRA60M")) {
                        importaSintegra60m(jsonString);
                    }
                } catch (Exception ex) {
                    em.getTransaction().rollback();
                    em.getTransaction().begin();
                    if (ex.getCause() != null) {
                        if (ex.getCause().getCause() == null) {
                            gravaLogImportacao(jsonString, ex.getMessage() + "|" + ex.getCause().getMessage());
                        } else {
                            gravaLogImportacao(jsonString, ex.getMessage() + "|" + ex.getCause().getMessage() + "|" + ex.getCause().getCause().getMessage());
                        }
                    } else {
                        gravaLogImportacao(jsonString, ex.getMessage());
                    }
                }
                gravaIntegracaoPdv(identificador + "_" + contador);
                em.getTransaction().commit();
                em.getTransaction().begin();
            }
            jsonString = buffer.readLine();
        }
        fechaConexao();
    }

    private void importaVenda(String jsonString) throws Exception {
        EcfVendaCabecalhoVO vendaCabecalho = gson.fromJson(jsonString, EcfVendaCabecalhoVO.class);
        vendaCabecalho.setIdGeradoCaixa(vendaCabecalho.getId());
        vendaCabecalho.setId(null);
        vendaCabecalho.setNomeCaixa(nomeCaixa);
        vendaCabecalho.setDataSincronizacao(dataIntegracao);
        vendaCabecalho.setHoraSincronizacao(horaIntegracao);

        em.persist(vendaCabecalho);

        ControleEstoqueController estoqueController = new ControleEstoqueController();
        for (EcfVendaDetalheVO vendaDetalhe : vendaCabecalho.getListaEcfVendaDetalhe()) {
            vendaDetalhe.setIdGeradoCaixa(vendaDetalhe.getId());
            vendaDetalhe.setId(null);
            vendaDetalhe.setIdEcfProduto(vendaDetalhe.getProduto().getId());
            vendaDetalhe.setIdEcfVendaCabecalho(vendaCabecalho.getIdGeradoCaixa());
            vendaDetalhe.setNomeCaixa(nomeCaixa);
            vendaDetalhe.setDataSincronizacao(dataIntegracao);
            vendaDetalhe.setHoraSincronizacao(horaIntegracao);
            

            em.persist(vendaDetalhe);
            
            if (vendaDetalhe.getMovimentaEstoque().equals("S")) {
                estoqueController.atualizaEstoque(vendaDetalhe.getQuantidade(), vendaDetalhe.getIdEcfProduto());
            }
        }

        for (EcfTotalTipoPagamentoVO totalTipoPagamento : vendaCabecalho.getListaEcfTotalTipoPagamento()) {
            totalTipoPagamento.setIdGeradoCaixa(totalTipoPagamento.getId());
            totalTipoPagamento.setId(null);
            totalTipoPagamento.setNomeCaixa(nomeCaixa);
            totalTipoPagamento.setDataSincronizacao(dataIntegracao);
            totalTipoPagamento.setHoraSincronizacao(horaIntegracao);

            em.persist(totalTipoPagamento);
        }
        
    }

    private void importaNotaFiscal(String jsonString) throws Exception {
        EcfNotaFiscalCabecalhoVO notaFiscalCabecalho = gson.fromJson(jsonString, EcfNotaFiscalCabecalhoVO.class);
        notaFiscalCabecalho.setIdGeradoCaixa(notaFiscalCabecalho.getId());
        notaFiscalCabecalho.setId(null);
        notaFiscalCabecalho.setNomeCaixa(nomeCaixa);
        notaFiscalCabecalho.setDataSincronizacao(dataIntegracao);
        notaFiscalCabecalho.setHoraSincronizacao(horaIntegracao);

        em.persist(notaFiscalCabecalho);

        for (EcfNotaFiscalDetalheVO notaDetalhe : notaFiscalCabecalho.getListaNotaFiscalDetalhe()) {
            notaDetalhe.setIdGeradoCaixa(notaDetalhe.getId());
            notaDetalhe.setId(null);
            notaDetalhe.setNomeCaixa(nomeCaixa);
            notaDetalhe.setDataSincronizacao(dataIntegracao);
            notaDetalhe.setHoraSincronizacao(horaIntegracao);

            em.persist(notaDetalhe);
        }
    }

    private void importaMovimento(String jsonString) throws Exception {
        EcfMovimentoVO movimento = gson.fromJson(jsonString, EcfMovimentoVO.class);
        movimento.setIdGeradoCaixa(movimento.getId());
        movimento.setId(null);
        movimento.setNomeCaixa(nomeCaixa);
        movimento.setDataSincronizacao(dataIntegracao);
        movimento.setHoraSincronizacao(horaIntegracao);

        em.persist(movimento);

        for (EcfSuprimentoVO suprimento : movimento.getListaEcfSuprimento()) {
            suprimento.setIdGeradoCaixa(suprimento.getId());
            suprimento.setId(null);
            suprimento.setNomeCaixa(nomeCaixa);
            suprimento.setDataSincronizacao(dataIntegracao);
            suprimento.setHoraSincronizacao(horaIntegracao);

            em.persist(suprimento);
        }

        for (EcfSangriaVO sangria : movimento.getListaEcfSangria()) {
            sangria.setIdGeradoCaixa(sangria.getId());
            sangria.setId(null);
            sangria.setNomeCaixa(nomeCaixa);
            sangria.setDataSincronizacao(dataIntegracao);
            sangria.setHoraSincronizacao(horaIntegracao);

            em.persist(sangria);
        }

        for (EcfFechamentoVO fechamento : movimento.getListaEcfFechamento()) {
            fechamento.setIdGeradoCaixa(fechamento.getId());
            fechamento.setId(null);
            fechamento.setNomeCaixa(nomeCaixa);
            fechamento.setDataSincronizacao(dataIntegracao);
            fechamento.setHoraSincronizacao(horaIntegracao);

            em.persist(fechamento);
        }
    }

    private void importaR02(String jsonString) throws Exception {
        EcfR02VO r02 = gson.fromJson(jsonString, EcfR02VO.class);
        r02.setIdGeradoCaixa(r02.getId());
        r02.setId(null);
        r02.setNomeCaixa(nomeCaixa);
        r02.setDataSincronizacao(dataIntegracao);
        r02.setHoraSincronizacao(horaIntegracao);

        em.persist(r02);

        for (EcfR03VO r03 : r02.getListaR03()) {
            r03.setIdGeradoCaixa(r03.getId());
            r03.setId(null);
            r03.setNomeCaixa(nomeCaixa);
            r03.setDataSincronizacao(dataIntegracao);
            r03.setHoraSincronizacao(horaIntegracao);

            em.persist(r03);
        }
    }

    private void importaR06(String jsonString) throws Exception {
        EcfR06VO r06 = gson.fromJson(jsonString, EcfR06VO.class);
        r06.setIdGeradoCaixa(r06.getId());
        r06.setId(null);
        r06.setNomeCaixa(nomeCaixa);
        r06.setDataSincronizacao(dataIntegracao);
        r06.setHoraSincronizacao(horaIntegracao);

        em.persist(r06);
    }

    private void importaSintegra60m(String jsonString) throws Exception {
        EcfSintegra60mVO sintegra60m = gson.fromJson(jsonString, EcfSintegra60mVO.class);
        sintegra60m.setIdGeradoCaixa(sintegra60m.getId());
        sintegra60m.setId(null);
        sintegra60m.setNomeCaixa(nomeCaixa);
        sintegra60m.setDataSincronizacao(dataIntegracao);
        sintegra60m.setHoraSincronizacao(horaIntegracao);

        em.persist(sintegra60m);

        for (EcfSintegra60aVO sintegra60a : sintegra60m.getListaSintegra60a()) {
            sintegra60a.setIdGeradoCaixa(sintegra60a.getId());
            sintegra60a.setId(null);
            sintegra60a.setNomeCaixa(nomeCaixa);
            sintegra60a.setDataSincronizacao(dataIntegracao);
            sintegra60a.setHoraSincronizacao(horaIntegracao);

            em.persist(sintegra60a);
        }
    }

    private void gravaIntegracaoPdv(String identificador) throws Exception {
        IntegracaoPdvVO integracaoPdv = new IntegracaoPdvVO();
        integracaoPdv.setIdentifica(identificador);
        integracaoPdv.setDataIntegracao(dataIntegracao);
        integracaoPdv.setHoraIntegracao(horaIntegracao);

        em.persist(integracaoPdv);
    }

    private void gravaLogImportacao(String jsonString, String erro) {
        try {
            LogImportacaoController logImportacaoController = new LogImportacaoController();
            logImportacaoController.gravaLogImportacao(jsonString, erro, dataIntegracao, horaIntegracao);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
