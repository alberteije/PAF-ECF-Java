/**
 * <p>Title: T2TiPDV</p>
 *
 * <p>Description: Janela para controlar as cargas - integração</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2013 T2Ti.COM</p>
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * The author may be contacted at: t2ti.com@gmail.com</p>
 *
 * @author Claudio de Barros (T2Ti.COM)
 * @version 2.0
 */
package com.t2ti.pafecf.view;

import com.t2ti.pafecf.infra.Biblioteca;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class CargaPDV extends javax.swing.JDialog {

    public static String tipo;
    public static String pathVenda, pathCarga = "";

    public CargaPDV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // TODO ProcessaCarga p = new ProcessaCarga(this);
        // TODO new Thread(p).start();

        this.setPreferredSize(new Dimension(500, 60));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Processando Carga");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(jProgressBar1, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    // TODO 
    /*public static Boolean importaCarga(String pRemoteApp) {
        String localApp, linha, compara, logTupla;
        String[] tupla;
        int i = 0;

        localApp = System.getProperty("user.dir") + "\\script\\carga.txt";

        try {
            if (new File(pRemoteApp).exists()) {
                Biblioteca.copy(new File(pRemoteApp), new File(localApp), true);
                File arquivoCarga = new File(localApp);
                FileReader fileReader = new FileReader(arquivoCarga);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((linha = bufferedReader.readLine()) != null) {
                    i++;
                    if (jProgressBar1.getPercentComplete() == 1.0) {
                        i = 0;
                    }
                    jProgressBar1.setValue(i);
                    tupla = linha.split("\\|");
                    logTupla = linha;
                    compara = tupla[0];

                    //TODO: -Verifique se todas as cargas estão corretas. Corrija o que for necessário.

                    if (compara.equals("BANCO")) {
                        if (!(new BancoController().gravaCargaBanco(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("UNIDADE")) {
                        if (!(new UnidadeController().gravaCargaUnidade(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("PRODUTO")) {
                        if (!(new ProdutoController().gravaCargaProduto(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("SITUACAO_CLI")) {
                        if (!(new SituacaoClienteController().gravaCargaSituacaoCliente(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("CLIENTE")) {
                        if (!(new ClienteController().gravaCargaCliente(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("EMPRESA")) {
                        if (!(new EmpresaController().gravaCargaEmpresa(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("CONTADOR")) {
                        if (!(new ContadorController().gravaCargaContador(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("TURNO")) {
                        if (!(new TurnoController().gravaCargaTurno(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("FUNCIONARIO")) {
                        if (!(new VendedorController().gravaCargaFuncionario(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("OPERADOR")) {
                        if (!(new OperadorController().gravaCargaOperador(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("CFOP")) {
                        if (!(new CfopController().gravaCargaCfop(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("FICHA")) {
                        if (!(new FichaTecnicaController().gravaCargaFichaTecnica(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("PROMOCAO")) {
                        //if (!(new ProdutoPromocaoController().gravaCargaProdutoPromocao(linha))) {
                        //    new LogImportacaoController().gravaLogImportacao(logTupla);
                        //}
                    } else if (compara.equals("RESOLUCAO")) {
                        //if (!(new ResolucaoController().gravaCargaResolucao(linha))) {
                        //TLogImportacaoController.GravaLogImportacao(LogTupla);
                        //}
                    } else if (compara.equals("COMPONENTES")) {
                        if (!(new ComponentesController().gravaCargaComponentes(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("IMPRESSORA")) {
                        if (!(new ImpressoraController().gravaCargaImpressora(linha))) {
                            new LogImportacaoController().gravaLogImportacao(logTupla);
                        }
                    } else if (compara.equals("CONFIGURACAO")) {
                        //if (!(new ConfiguracaoController().gravaCargaConfiguracao(linha))) {
                        //    new LogImportacaoController().gravaLogImportacao(logTupla);
                        //}
                    }
                }

                fileReader.close();
                bufferedReader.close();
                new File(pRemoteApp).delete();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public static Boolean exportaCargaVenda(String pRemoteApp) {
        jProgressBar1.setValue(5);

        VendaCabecalhoVO vendaCabecalho = new VendaController().ultimaVenda();

        SimpleDateFormat formataData;
        formataData = new SimpleDateFormat("ddMMyyyyhhmmss");
        String strData = formataData.format(new java.util.Date());

        String identificacao = "E" + Caixa.configuracao.getIdEmpresa() + "X" + Caixa.configuracao.getNomeCaixa() + "V" + vendaCabecalho.getId() + "C" + vendaCabecalho.getCoo() + "D" + strData;
        String arquivo = "VENDA_C" + Caixa.configuracao.getIdCaixa() + "E" + Caixa.configuracao.getIdEmpresa() + "-" + strData + ".txt";
        pathVenda = System.getProperty("user.dir") + "\\script\\" + arquivo;

        try {
            File arquivoCarga = new File(pathVenda);
            arquivoCarga.createNewFile();
            FileWriter fileWriter = new FileWriter(arquivoCarga, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("VCB|'" + identificacao + "'|'" + //   ID                          INTEGER NOT NULL,
                    Caixa.configuracao.getNomeCaixa() + "'|'" + //   NOME_CAIXA                  VARCHAR(30),
                    vendaCabecalho.getId() + "'|'" + //   ID_GERADO_CAIXA             INTEGER,
                    Caixa.configuracao.getIdEmpresa() + "'|'" + //   ID_EMPRESA                  INTEGER,
                    vendaCabecalho.getIdCliente() + "'|'" + //   ID_CLIENTE                  INTEGER,
                    vendaCabecalho.getIdVendedor() + "'|'" + //   ID_ECF_FUNCIONARIO          INTEGER,
                    vendaCabecalho.getIdMovimento() + "'|'" + //   ID_ECF_MOVIMENTO            INTEGER,
                    vendaCabecalho.getIdDav() + "'|'" + //   ID_ECF_DAV                  INTEGER,
                    vendaCabecalho.getIdPreVenda() + "'|'" + //   ID_ECF_PRE_VENDA_CABECALHO  INTEGER,
                    vendaCabecalho.getSerieEcf() + "'|'" + //   SERIE_ECF                   VARCHAR(20),
                    vendaCabecalho.getCfop() + "'|'" + //   CFOP                        INTEGER NOT NULL,
                    vendaCabecalho.getCoo() + "'|'" + //   COO                         INTEGER,
                    vendaCabecalho.getCcf() + "'|'" + //   CCF                         INTEGER,
                    vendaCabecalho.getDataVenda() + "'|'" + //   DATA_VENDA                  DATE,
                    vendaCabecalho.getHoraVenda() + "'|'" + //   HORA_VENDA                  VARCHAR(8),
                    vendaCabecalho.getValorVenda() + "'|'" + //   VALOR_VENDA                 DECIMAL(18,6),
                    vendaCabecalho.getTaxaDesconto() + "'|'" + //   TAXA_DESCONTO               DECIMAL(18,6),
                    vendaCabecalho.getDesconto() + "'|'" + //   DESCONTO                    DECIMAL(18,6),
                    vendaCabecalho.getTaxaAcrescimo() + "'|'" + //   TAXA_ACRESCIMO              DECIMAL(18,6),
                    vendaCabecalho.getAcrescimo() + "'|'" + //   ACRESCIMO                   DECIMAL(18,6),
                    vendaCabecalho.getValorFinal() + "'|'" + //   VALOR_FINAL                 DECIMAL(18,6),
                    vendaCabecalho.getValorRecebido() + "'|'" + //   VALOR_RECEBIDO              DECIMAL(18,6),
                    vendaCabecalho.getTroco() + "'|'" + //   TROCO                       DECIMAL(18,6),
                    vendaCabecalho.getValorCancelado() + "'|'" + //   VALOR_CANCELADO             DECIMAL(18,6),
                    vendaCabecalho.getTotalProdutos() + "'|'" + //   TOTAL_PRODUTOS              DECIMAL(18,6),
                    vendaCabecalho.getTotalDocumento() + "'|'" + //   TOTAL_DOCUMENTO             DECIMAL(18,6),
                    vendaCabecalho.getBaseIcms() + "'|'" + //   BASE_ICMS                   DECIMAL(18,6),
                    vendaCabecalho.getIcms() + "'|'" + //   ICMS                        DECIMAL(18,6),
                    vendaCabecalho.getIcmsOutras() + "'|'" + //   ICMS_OUTRAS                 DECIMAL(18,6),
                    vendaCabecalho.getIssqn() + "'|'" + //   ISSQN                       DECIMAL(18,6),
                    vendaCabecalho.getPis() + "'|'" + //   PIS                         DECIMAL(18,6),
                    vendaCabecalho.getCofins() + "'|'" + //   COFINS                      DECIMAL(18,6),
                    vendaCabecalho.getAcrescimoItens() + "'|'" + //   ACRESCIMO_ITENS             DECIMAL(18,6),
                    vendaCabecalho.getDescontoItens() + "'|'" + //   DESCONTO_ITENS              DECIMAL(18,6),
                    vendaCabecalho.getStatusVenda() + "'|'" + //   STATUS_VENDA                CHAR(1),
                    vendaCabecalho.getNomeCliente() + "'|'" + //   NOME_CLIENTE                VARCHAR(100),
                    vendaCabecalho.getCpfCnpjCliente() + "'|'" + //   CPF_CNPJ_CLIENTE            VARCHAR(14),
                    vendaCabecalho.getCupomCancelado() + "'|'" + //   CUPOM_CANCELADO             CHAR(1),
                    vendaCabecalho.getHashTripa() + "'|'" + //   HASH_TRIPA                  VARCHAR(32),
                    vendaCabecalho.getHashIncremento() + "'|");     //   HASH_INCREMENTO             INTEGER,

            List<VendaDetalheVO> listaVendaDetalhe = new VendaController().vendaDetalhe(vendaCabecalho.getId());
            VendaDetalheVO vendaDetalhe;
            for (int i = 0; i < listaVendaDetalhe.size(); i++) {
                jProgressBar1.setValue(i);
                vendaDetalhe = listaVendaDetalhe.get(i);
                printWriter.println("VDT|'"
                        + identificacao + "I" + vendaDetalhe.getId() + "'|'" + //  ID,
                        vendaDetalhe.getIdProduto() + "'|'" + //  ID_ECF_PRODUTO,    usado para dar baixa estoque
                        vendaDetalhe.getQuantidade() + "'|'" + //  QUANTIDADE,        usado para dar baixa estoque
                        vendaDetalhe.getMovimentaEstoque() + "'|'" + //  MOVIMENTA_ESTOQUE, usado para dar baixa estoque
                        Caixa.configuracao.getNomeCaixa() + "'|'" + //  NOME_CAIXA              VARCHAR(30),
                        vendaDetalhe.getId() + "'|'" + //  ID_GERADO_CAIXA         INTEGER,
                        Caixa.configuracao.getIdEmpresa() + "'|'" + //  ID_EMPRESA              INTEGER,
                        vendaDetalhe.getIdProduto() + "'|'" + //  ID_ECF_PRODUTO          INTEGER,
                        vendaDetalhe.getIdVendaCabecalho() + "'|'" + //  ID_ECF_VENDA_CABECALHO  INTEGER,
                        vendaDetalhe.getSerieEcf() + "'|'" + //  SERIE_ECF               VARCHAR(20),
                        vendaDetalhe.getGtin() + "'|'" + //  GTIN                    VARCHAR(14),
                        vendaDetalhe.getCcf() + "'|'" + //  CCF                     INTEGER,
                        vendaDetalhe.getCoo() + "'|'" + //  COO                     INTEGER,
                        vendaDetalhe.getCfop() + "'|'" + //  CFOP                    INTEGER NOT NULL,
                        vendaDetalhe.getItem() + "'|'" + //  ITEM                    INTEGER,
                        vendaDetalhe.getQuantidade() + "'|'" + //  QUANTIDADE              DECIMAL(18,6),
                        vendaDetalhe.getValorUnitario() + "'|'" + //  VALOR_UNITARIO          DECIMAL(18,6),
                        vendaDetalhe.getValorTotal() + "'|'" + //  VALOR_TOTAL             DECIMAL(18,6),
                        vendaDetalhe.getTotalItem() + "'|'" + //  TOTAL_ITEM              DECIMAL(18,6),
                        vendaDetalhe.getBaseIcms() + "'|'" + //  BASE_ICMS               DECIMAL(18,6),
                        vendaDetalhe.getTaxaIcms() + "'|'" + //  TAXA_ICMS               DECIMAL(18,6),
                        vendaDetalhe.getIcms() + "'|'" + //  ICMS                    DECIMAL(18,6),
                        vendaDetalhe.getTaxaDesconto() + "'|'" + //  TAXA_DESCONTO           DECIMAL(18,6),
                        vendaDetalhe.getDesconto() + "'|'" + //  DESCONTO                DECIMAL(18,6),
                        vendaDetalhe.getTaxaIssqn() + "'|'" + //  TAXA_ISSQN              DECIMAL(18,6),
                        vendaDetalhe.getIssqn() + "'|'" + //  ISSQN                   DECIMAL(18,6),
                        vendaDetalhe.getTaxaPis() + "'|'" + //  TAXA_PIS                DECIMAL(18,6),
                        vendaDetalhe.getPis() + "'|'" + //  PIS                     DECIMAL(18,6),
                        vendaDetalhe.getTaxaCofins() + "'|'" + //  TAXA_COFINS             DECIMAL(18,6),
                        vendaDetalhe.getCofins() + "'|'" + //  COFINS                  DECIMAL(18,6),
                        vendaDetalhe.getTaxaAcrescimo() + "'|'" + //  TAXA_ACRESCIMO          DECIMAL(18,6),
                        vendaDetalhe.getAcrescimo() + "'|'" + //  ACRESCIMO               DECIMAL(18,6),
                        vendaDetalhe.getAcrescimoRateio() + "'|'" + //  ACRESCIMO_RATEIO        DECIMAL(18,6),
                        vendaDetalhe.getDescontoRateio() + "'|'" + //  DESCONTO_RATEIO         DECIMAL(18,6),
                        vendaDetalhe.getTotalizadorParcial() + "'|'" + //  TOTALIZADOR_PARCIAL     VARCHAR(10),
                        vendaDetalhe.getCst() + "'|'" + //  CST                     CHAR(3),
                        vendaDetalhe.getCancelado() + "'|'" + //  CANCELADO               CHAR(1),
                        vendaDetalhe.getMovimentaEstoque() + "'|'" + //  MOVIMENTA_ESTOQUE       CHAR(1),
                        vendaDetalhe.getEcfIcmsSt() + "'|'" + //  ECF_ICMS_ST             VARCHAR(4),
                        vendaDetalhe.getHashTripa() + "'|'" + //  HASH_TRIPA              VARCHAR(32),
                        vendaDetalhe.getHashIncremento() + "'|");       //  HASH_INCREMENTO         INTEGER,                
            }


            List<TotalTipoPagamentoVO> listaTotalTipoPagamento = new TotalTipoPagamentoController().retornaMeiosPagamentoDaUltimaVenda(vendaCabecalho.getId());
            TotalTipoPagamentoVO totalTipoPagamento;
            for (int i = 0; i < listaTotalTipoPagamento.size(); i++) {
                jProgressBar1.setValue(i);
                totalTipoPagamento = listaTotalTipoPagamento.get(i);

                printWriter.println("TTP|'" + // ECF_TOTAL_TIPO_PGTO (
                        identificacao + "T" + totalTipoPagamento.getId()
                        + "P" + totalTipoPagamento.getIdTipoPagamento() + "'|'" + //  ID                      INTEGER NOT NULL,
                        Caixa.configuracao.getNomeCaixa() + "'|'" + //  NOME_CAIXA              VARCHAR(30),
                        totalTipoPagamento.getId() + "'|'" + //  ID_GERADO_CAIXA         INTEGER,
                        Caixa.configuracao.getIdEmpresa() + "'|'" + //  ID_EMPRESA              INTEGER,
                        totalTipoPagamento.getIdVendaCabecalho() + "'|'" + //  ID_ECF_VENDA_CABECALHO  INTEGER,
                        totalTipoPagamento.getIdTipoPagamento() + "'|'" + //  ID_ECF_TIPO_PAGAMENTO   INTEGER,
                        totalTipoPagamento.getSerieEcf() + "'|'" + //  SERIE_ECF               VARCHAR(20),
                        totalTipoPagamento.getCoo() + "'|'" + //  COO                     INTEGER,
                        totalTipoPagamento.getCcf() + "'|'" + //  CCF                     INTEGER,
                        totalTipoPagamento.getGnf() + "'|'" + //  GNF                     INTEGER,
                        totalTipoPagamento.getValor() + "'|'" + //  VALOR                   DECIMAL(18,6),
                        totalTipoPagamento.getNsu() + "'|'" + //  NSU                     VARCHAR(30),
                        totalTipoPagamento.getEstorno() + "'|'" + //  ESTORNO                 CHAR(1),
                        totalTipoPagamento.getNomeRede() + "'|'" + //  REDE                    VARCHAR(10),
                        totalTipoPagamento.getCartaoDc() + "'|'" + //  CARTAO_DC               CHAR(1),
                        totalTipoPagamento.getHashTripa() + "'|'" + //  HASH_TRIPA              VARCHAR(32),
                        totalTipoPagamento.getHashIncremento() + "'|");         //  HASH_INCREMENTO         INTEGER,
            }

            // TODO: -Implemente a geração do contas a receber - CPR
            // TODO: -Implemente a geração das parcelas do contas a receber - PAR

            printWriter.flush();
            printWriter.close();
            Biblioteca.copy(new File(pathVenda), new File(pRemoteApp + arquivo), true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean exportaCargaFechamento(String pRemoteApp) {
        /*            String linha = "FECHAMENTO|"
         + identificacao
         + caixa + "|"
         + pId + "|"
         + pFechamento.getIdMovimento() + "|"
         + pFechamento.getTipoPagamento() + "|"
         + pFechamento.getValor() + "|";
         
         
         ou
         
         
         String linha = "EXCLUIFECHAMENTO|"
         + identificacao
         + caixa + "|"
         + rs.getInt("ID") + "|"
         + rs.getInt("ID_ECF_MOVIMENTO") + "|"
         + rs.getString("TIPO_PAGAMENTO") + "|"
         + rs.getDouble("VALOR") + "|";
         
         ++/
        return true;
    }

    public static Boolean exportaCargaSangria(String pRemoteApp) {
        jProgressBar1.setValue(5);

        SangriaVO sangria = new MovimentoController().ultimaSangria();

        SimpleDateFormat formataData;
        formataData = new SimpleDateFormat("ddMMyyyyhhmmss");
        String strData = formataData.format(new java.util.Date());

        String identificacao = "E" + Caixa.configuracao.getIdEmpresa() + "X" + Caixa.configuracao.getNomeCaixa() + "S" + sangria.getId() + "M" + sangria.getIdMovimento() + "D" + strData;
        String arquivo = "SANGRIA_C" + Caixa.configuracao.getIdCaixa() + "E" + Caixa.configuracao.getIdEmpresa() + "-" + strData + ".txt";
        String pathSangria = System.getProperty("user.dir") + "\\script\\" + arquivo;

        try {
            File arquivoCarga = new File(pathSangria);
            arquivoCarga.createNewFile();
            FileWriter fileWriter = new FileWriter(arquivoCarga, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String linha = "SANGRIA|'"
                    + identificacao + "'|'"
                    + Caixa.configuracao.getNomeCaixa() + "'|'"
                    + sangria.getId() + "'|'"
                    + sangria.getIdMovimento() + "'|'"
                    + sangria.getDataSangria() + "'|'"
                    + sangria.getValor() + "'|";

            printWriter.println(linha);

            printWriter.flush();
            printWriter.close();
            Biblioteca.copy(new File(pathSangria), new File(pRemoteApp + arquivo), true);

            jProgressBar1.setValue(100);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean exportaCargaSuprimento(String pRemoteApp) {
        jProgressBar1.setValue(5);

        SuprimentoVO suprimento = new MovimentoController().ultimoSuprimento();

        SimpleDateFormat formataData;
        formataData = new SimpleDateFormat("ddMMyyyyhhmmss");
        String strData = formataData.format(new java.util.Date());

        String identificacao = "E" + Caixa.configuracao.getIdEmpresa() + "X" + Caixa.configuracao.getNomeCaixa() + "S" + suprimento.getId() + "M" + suprimento.getIdMovimento() + "D" + strData;
        String arquivo = "SUPRIMENTO_C" + Caixa.configuracao.getIdCaixa() + "E" + Caixa.configuracao.getIdEmpresa() + "-" + strData + ".txt";
        String pathSuprimento = System.getProperty("user.dir") + "\\script\\" + arquivo;

        try {
            File arquivoCarga = new File(pathSuprimento);
            arquivoCarga.createNewFile();
            FileWriter fileWriter = new FileWriter(arquivoCarga, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String linha = "SUPRIMENTO|'"
                    + identificacao + "'|'"
                    + Caixa.configuracao.getNomeCaixa() + "'|'"
                    + suprimento.getId() + "'|'"
                    + suprimento.getIdMovimento() + "'|'"
                    + suprimento.getDataSuprimento() + "'|'"
                    + suprimento.getValor() + "'|";

            printWriter.println(linha);

            printWriter.flush();
            printWriter.close();
            Biblioteca.copy(new File(pathSuprimento), new File(pRemoteApp + arquivo), true);

            jProgressBar1.setValue(100);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean exportaCargaMovimento(String pRemoteApp) {
        /*
         String linha = "MOVIMENTO|"
         + identificacao
         + caixa + "|"
         + pId + "|"
         + pMovimento.getIdImpressora() + "|"
         + pMovimento.getIdTurno() + "|"
         + pMovimento.getIdImpressora() + "|"
         + pMovimento.getIdOperador() + "|"
         + pMovimento.getIdCaixa() + "|"
         + pMovimento.getIdGerenteSupervisor() + "|"
         + pMovimento.getDataAbertura() + "|"
         + pMovimento.getHoraAbertura() + "|"
         + pMovimento.getDataFechamento() + "|"
         + pMovimento.getHoraFechamento() + "|"
         + pMovimento.getTotalSuprimento() + "|"
         + pMovimento.getTotalSangria() + "|"
         + pMovimento.getTotalNaoFiscal() + "|"
         + pMovimento.getTotalVenda() + "|"
         + pMovimento.getTotalDesconto() + "|"
         + pMovimento.getTotalAcrescimo() + "|"
         + pMovimento.getTotalFinal() + "|"
         + pMovimento.getTotalRecebido() + "|"
         + pMovimento.getTotalTroco() + "|"
         + pMovimento.getTotalCancelado() + "|"
         + pMovimento.getStatusMovimento() + "|"
         + pMovimento.getSincronizado() + "|";
         ++/
        return true;
    }

    public static Boolean exportaCargaRegistroR(String pRemoteApp) {
        /*                String linha = "R02|"
         + identificacao
         + caixa + "|"
         + pId + "|"
         + rs.getInt("ID_OPERADOR") + "|"
         + rs.getInt("ID_IMPRESSORA") + "|"
         + rs.getInt("ID_ECF_CAIXA") + "|"
         + rs.getInt("CRZ") + "|"
         + rs.getInt("COO") + "|"
         + rs.getInt("CRO") + "|"
         + rs.getDate("DATA_MOVIMENTO") + "|"
         + rs.getDate("DATA_EMISSAO") + "|"
         + rs.getString("HORA_EMISSAO") + "|"
         + rs.getDouble("VENDA_BRUTA") + "|"
         + rs.getDouble("GRANDE_TOTAL") + "|"
         + rs.getString("SINCRONIZADO") + "|"
         + rs.getString("HASH_TRIPA") + "|";
         ++/

        // TODO: -Implemente a integração para os registros R03, R06 e R07

        return true;
    }

    public Boolean exportaCancelamentoVenda(String pRemoteApp) {
        /*
         // TODO: -Tome como base o método exportaCargaVenda
         e implemente os dados necessários quando do cancelamento de um cupom
         * CANCELAVCB - identifica o cancelamento da venda cabeçalho
         * CANCELAVDT - identifica o cancelamento dos detalhes da venda
         * CANCELATTP - identifica o cancelamento dos totais de tipo de pagamento
         * CANCELACPR - identifica o cancelamento da conta a receber
         * CANCELAPAR - identifica o cancelamento da parcela da conta a receber
         * 
         ++/
        return true;
    }
}

class ProcessaCarga implements Runnable {

    javax.swing.JDialog janelaCarga;

    ProcessaCarga(CargaPDV pThis) {
        janelaCarga = pThis;
    }

    @Override
    public void run() {
        if (CargaPDV.tipo.equals("importa")) {
            CargaPDV.importaCarga(Caixa.pathCargaRemoto + "Caixa" + Caixa.configuracao.getIdCaixa() + "\\carga.txt");
        }
        if (CargaPDV.tipo.equals("venda")) {
            CargaPDV.exportaCargaVenda(Caixa.pathCargaRemoto);
        }
        if (CargaPDV.tipo.equals("fechamento")) {
            CargaPDV.exportaCargaFechamento(Caixa.pathCargaRemoto);
        }
        if (CargaPDV.tipo.equals("sangria")) {
            CargaPDV.exportaCargaSangria(Caixa.pathCargaRemoto);
        }
        if (CargaPDV.tipo.equals("suprimento")) {
            CargaPDV.exportaCargaSuprimento(Caixa.pathCargaRemoto);
        }
        if (CargaPDV.tipo.equals("movimento")) {
            CargaPDV.exportaCargaMovimento(Caixa.pathCargaRemoto);
        }
        if (CargaPDV.tipo.equals("registroR")) {
            CargaPDV.exportaCargaRegistroR(Caixa.pathCargaRemoto);
        }
        janelaCarga.dispose();
    }*/
}