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
package com.t2ti.pafecf.infra;

import com.t2ti.pafecf.controller.ControllerGenerico;
import com.t2ti.pafecf.controller.ProdutoController;
import com.t2ti.pafecf.controller.R02Controller;
import com.t2ti.pafecf.controller.R06Controller;
import com.t2ti.pafecf.controller.TotalTipoPagamentoController;
import com.t2ti.pafecf.controller.VendaController;
import com.t2ti.pafecf.controller.ViewTotalPagamentoDataController;
import com.t2ti.pafecf.vo.EcfE3VO;
import com.t2ti.pafecf.vo.EcfImpressoraVO;
import com.t2ti.pafecf.vo.EcfTotalTipoPagamentoVO;
import com.t2ti.pafecf.vo.EcfVendaCabecalhoVO;
import com.t2ti.pafecf.vo.EcfVendaDetalheVO;
import com.t2ti.pafecf.vo.ProdutoVO;
import com.t2ti.pafecf.vo.R01VO;
import com.t2ti.pafecf.vo.R02VO;
import com.t2ti.pafecf.vo.R03VO;
import com.t2ti.pafecf.vo.R06VO;
import com.t2ti.pafecf.vo.R07VO;
import com.t2ti.pafecf.vo.Sintegra60aVO;
import com.t2ti.pafecf.vo.Sintegra60mVO;
import com.t2ti.pafecf.vo.ViewTotalPagamentoDataVO;
import jACBrFramework.ACBrEventListener;
import jACBrFramework.ACBrException;
import jACBrFramework.paf.ACBrPAF;
import jACBrFramework.paf.ACBrPAFRegistroA2;
import jACBrFramework.paf.ACBrPAFRegistroE2;
import jACBrFramework.paf.ACBrPAFRegistroE3;
import jACBrFramework.paf.ACBrPAFRegistroN3;
import jACBrFramework.paf.ACBrPAFRegistroP2;
import jACBrFramework.paf.ACBrPAFRegistroR1;
import jACBrFramework.paf.ACBrPAFRegistroR2;
import jACBrFramework.paf.ACBrPAFRegistroR3;
import jACBrFramework.paf.ACBrPAFRegistroR4;
import jACBrFramework.paf.ACBrPAFRegistroR5;
import jACBrFramework.paf.ACBrPAFRegistroR6;
import jACBrFramework.paf.ACBrPAFRegistroR7;
import jACBrFramework.paf.CodigoTipoDocumento;
import jACBrFramework.paf.PAFGetKeyRSAEventObject;
import jACBrFramework.serial.ecf.Aliquota;
import jACBrFramework.serial.ecf.DadosReducaoZClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Paf {

    private static Properties arquivoAuxiliar;

    public static void identificacaoPafEcf() throws Exception {
        R01VO r01 = SessaoUsuario.getR01();
        String md5;

        SessaoUsuario.getAcbrEcf().abreRelatorioGerencial(SessaoUsuario.getConfiguracao().getEcfRelatorioGerencial().getIdentificacaoPaf());
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("IDENTIFICACAO DO PAF-ECF", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NUMERO DO LAUDO...: " + r01.getNumeroLaudoPaf(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("C.N.P.J. .........: " + r01.getCnpjSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("RAZAO SOCIAL......: " + r01.getRazaoSocialSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("ENDERECO..........: " + r01.getEnderecoSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NUMERO............: " + r01.getNumeroSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("COMPLEMENTO.......: " + r01.getComplementoSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("BAIRRO............: " + r01.getBairroSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("CIDADE............: " + r01.getCidadeSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("CEP...............: " + r01.getCepSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("UF................: " + r01.getUfSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TELEFONE..........: " + r01.getTelefoneSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("CONTATO...........: " + r01.getContatoSh(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("************IDENTIFICACAO DO PAF-ECF************", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NOME COMERCIAL....: " + r01.getNomePafEcf(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("VERSAO DO PAF-ECF.: " + r01.getVersaoPafEcf(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("**********PRINCIPAL ARQUIVO EXECUTAVEL**********", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NOME..........: " + r01.getPrincipalExecutavel(), 0);
        md5 = Biblioteca.md5File("PafEcf.jar");
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("MD5...........: " + md5, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("****************DEMAIS ARQUIVOS*****************", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NOME..........: BALCAO.JAR", 0);
        md5 = Biblioteca.md5File("balcao/balcao.jar");
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("MD5...........: " + md5, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("**************NOME DO ARQUIVO TEXTO*************", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NOME..........: ArquivoMD5.txt", 0);
        md5 = Biblioteca.md5File("ArquivoMD5.txt");
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("MD5...........: " + md5, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("VERSAO ER PAF-ECF.: " + r01.getVersaoEr(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("**********RELACAO DOS ECF AUTORIZADOS***********", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("SERIE............: " + r01.getSerieEcf(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().fechaRelatorio();

        gravaR06("RG");
    }

    public static boolean ECFAutorizado() throws ACBrException {
        try {
            File file = new File(Constantes.ARQUIVO_AUXILIAR);
            if (!file.exists()) {
                return false;
            }
            abreArquivoAuxiliar();
            String md5Serie = Biblioteca.md5String(SessaoUsuario.getAcbrEcf().getNumSerie());
            String serieEcf = arquivoAuxiliar.getProperty("ecf.serie");
            //System.out.println(md5Serie);
            if (md5Serie.equals(serieEcf)) {
                return true;
            } else {
                R02VO r02 = new R02Controller().getBean(SessaoUsuario.getAcbrEcf().getNumSerie(), SessaoUsuario.getAcbrEcf().getDataHoraUltimaReducaoZ());
                if (r02 == null) {
                    return false;
                } else {
                    if ((r02.getCrz().intValue() == Integer.valueOf(SessaoUsuario.getAcbrEcf().getNumCRZ()).intValue())
                            && (r02.getCro().intValue() == Integer.valueOf(SessaoUsuario.getAcbrEcf().getNumCRO()).intValue())
                            && (r02.getGrandeTotal().doubleValue() == SessaoUsuario.getAcbrEcf().getGrandeTotal())) {
                        atualizaGT();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (Exception ex) {
            throw new ACBrException(ex.getMessage());
        }
    }

    public static String geraMD5() throws ACBrException {
        try {
            String nomeArquivo;
            String md5ArquivoMd5;
            File file;
            ACBrPAFRegistroN3 n3;

            ACBrPAF acbrPaf = getAcbrPaf();

            acbrPaf.getPaf_N().getRegistroN1().setRazaoSocial(SessaoUsuario.getR01().getRazaoSocialSh());
            acbrPaf.getPaf_N().getRegistroN1().setUf(SessaoUsuario.getR01().getUfSh());
            acbrPaf.getPaf_N().getRegistroN1().setCnpj(SessaoUsuario.getR01().getCnpjSh());
            acbrPaf.getPaf_N().getRegistroN1().setInscEstadual(SessaoUsuario.getR01().getInscricaoEstadualSh());
            acbrPaf.getPaf_N().getRegistroN1().setInscMunicipal(SessaoUsuario.getR01().getInscricaoMunicipalSh());

            acbrPaf.getPaf_N().getRegistroN2().setLaudo(SessaoUsuario.getR01().getNumeroLaudoPaf());
            acbrPaf.getPaf_N().getRegistroN2().setNome(SessaoUsuario.getR01().getNomePafEcf());
            acbrPaf.getPaf_N().getRegistroN2().setVersao(SessaoUsuario.getR01().getVersaoPafEcf());

            acbrPaf.getPaf_N().getRegistrosN3().clear();

            nomeArquivo = SessaoUsuario.getR01().getPrincipalExecutavel();
            file = new File(Constantes.DIRETORIO_APLICACAO + nomeArquivo);
            if (!file.exists()) {
                throw new ACBrException("Arquivo " + nomeArquivo + " não encontrado");
            }
            n3 = new ACBrPAFRegistroN3();
            n3.setNomeArquivo(nomeArquivo);
            n3.setMd5(Biblioteca.md5File(file.getAbsolutePath()));
            acbrPaf.getPaf_N().getRegistrosN3().add(n3);

            nomeArquivo = "Balcao.jar";
            file = new File(Constantes.DIRETORIO_APLICACAO + nomeArquivo);
            if (!file.exists()) {
                throw new ACBrException("Arquivo " + nomeArquivo + " não encontrado");
            }
            n3 = new ACBrPAFRegistroN3();
            n3.setNomeArquivo(nomeArquivo);
            n3.setMd5(Biblioteca.md5File(file.getAbsolutePath()));
            acbrPaf.getPaf_N().getRegistrosN3().add(n3);

            if (!acbrPaf.saveFileTXT_N("ArquivoMD5.txt")) {
                throw new ACBrException("Não foi possível criar o arquivo 'ArquivoMD5.txt'");
            }

            md5ArquivoMd5 = Biblioteca.md5File(Constantes.DIRETORIO_APLICACAO + "ArquivoMD5.txt");

            abreArquivoAuxiliar();
            arquivoAuxiliar.setProperty("md5.arquivos", md5ArquivoMd5);
            salvaArquivoAuxiliar();

            JOptionPane.showMessageDialog(null, "Arquivo armazenado em: " + Constantes.DIRETORIO_APLICACAO + "ArquivoMD5.txt", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);

            return md5ArquivoMd5;
        } catch (Exception ex) {
            throw new ACBrException(ex.getMessage());
        }
    }

    public static void gravaR02R03() throws Exception {
        R02VO r02 = new R02VO();
        r02.setListaR03(new ArrayList<R03VO>());
        R03VO r03;
        String indice;
        String aliquota;
        R02Controller controller = new R02Controller();

        SessaoUsuario.getAcbrEcf().dadosReducaoZ();
        DadosReducaoZClass dadosReducaoZ = SessaoUsuario.getAcbrEcf().getDadosReducaoZClass();

        //Dados para o registro R02
        if (SessaoUsuario.movimento != null) {
            r02.setIdEcfCaixa(SessaoUsuario.movimento.getEcfCaixa().getId());
            r02.setIdOperador(SessaoUsuario.movimento.getEcfOperador().getId());
            r02.setIdImpressora(SessaoUsuario.movimento.getEcfImpressora().getId());
        } else {
            r02.setIdEcfCaixa(0);
            r02.setIdOperador(0);
            r02.setIdImpressora(0);
        }

        r02.setSerieEcf(SessaoUsuario.getAcbrEcf().getNumSerie());
        r02.setCrz(dadosReducaoZ.getCrz() + 1);
        r02.setCoo(dadosReducaoZ.getCoo() + 1);
        r02.setCro(dadosReducaoZ.getCro());
        r02.setDataMovimento(dadosReducaoZ.getDataDoMovimento());
        r02.setDataEmissao(dadosReducaoZ.getDataDaImpressora());
        r02.setHoraEmissao(Biblioteca.formataHora(dadosReducaoZ.getDataDaImpressora()));
        r02.setVendaBruta(BigDecimal.valueOf(dadosReducaoZ.getValorVendaBruta()));
        r02.setGrandeTotal(BigDecimal.valueOf(dadosReducaoZ.getValorGrandeTotal()));

        //Dados para o registro R03
        // Dados ICMS
        for (Aliquota a : dadosReducaoZ.getIcms()) {
            r03 = new R03VO();
            r03.setR02(r02);
            r03.setCrz(dadosReducaoZ.getCrz() + 1);

            indice = Biblioteca.repete("0", 2 - a.getIndice().length()) + a.getIndice();
            aliquota = String.valueOf(a.getAliquota() * 100).replace(".0", "");
            aliquota = Biblioteca.repete("0", 4 - aliquota.length()) + aliquota;

            r03.setTotalizadorParcial(indice + "T" + aliquota);
            r03.setValorAcumulado(BigDecimal.valueOf(a.getTotal()));

            r02.getListaR03().add(r03);
        }

        // Dados ISSQN
        for (Aliquota a : dadosReducaoZ.getIssqn()) {
            r03 = new R03VO();
            r03.setR02(r02);

            indice = Biblioteca.repete("0", 2 - a.getIndice().length()) + a.getIndice();
            aliquota = String.valueOf(a.getAliquota() * 100).replace(".0", "");
            aliquota = Biblioteca.repete("0", 4 - aliquota.length()) + aliquota;

            r03.setTotalizadorParcial(indice + "S" + aliquota);
            r03.setValorAcumulado(BigDecimal.valueOf(a.getTotal()));

            r02.getListaR03().add(r03);
        }

        // Substituição Tributária - ICMS
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("F1");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getSubstituicaoTributariaICMS()));
        r02.getListaR03().add(r03);

        // Isento - ICMS
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("I1");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getIsentoICMS()));
        r02.getListaR03().add(r03);

        // Não-incidência - ICMS
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("N1");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getNaoTributadoICMS()));
        r02.getListaR03().add(r03);

        // Substituição Tributária - ISSQN
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("FS1");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getSubstituicaoTributariaISSQN()));
        r02.getListaR03().add(r03);

        // Isento - ISSQN
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("IS1");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getIsentoISSQN()));
        r02.getListaR03().add(r03);

        // Não-incidência - ISSQN
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("NS1");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getNaoTributadoISSQN()));
        r02.getListaR03().add(r03);

        // Operações Não Fiscais
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("OPNF");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getTotalOperacaoNaoFiscal()));
        r02.getListaR03().add(r03);

        // Desconto - ICMS
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("DT");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getDescontoICMS()));
        r02.getListaR03().add(r03);

        // Desconto - ISSQN
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("DS");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getDescontoISSQN()));
        r02.getListaR03().add(r03);

        // Acréscimo - ICMS
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("AT");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getAcrescimoICMS()));
        r02.getListaR03().add(r03);

        // Acréscimo - ISSQN
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("AS");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getAcrescimoISSQN()));
        r02.getListaR03().add(r03);

        // Cancelamento - ICMS
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("Can-T");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getCancelamentoICMS()));
        r02.getListaR03().add(r03);

        // Cancelamento - ISSQN
        r03 = new R03VO();
        r03.setR02(r02);
        r03.setTotalizadorParcial("Can-S");
        r03.setValorAcumulado(BigDecimal.valueOf(dadosReducaoZ.getCancelamentoISSQN()));
        r02.getListaR03().add(r03);

        controller.salvar(r02);

        grava60M60A(dadosReducaoZ);
    }

    public static void grava60M60A(DadosReducaoZClass dadosReducaoZ) throws Exception {
        ControllerGenerico<Sintegra60mVO> controller = new ControllerGenerico<>();
        Sintegra60mVO sintegra60M = new Sintegra60mVO();
        sintegra60M.setListaSintegra60A(new ArrayList<Sintegra60aVO>());
        Sintegra60aVO sintegra60A;

        sintegra60M.setModeloDocumentoFiscal(SessaoUsuario.getConfiguracao().getEcfImpressora().getModeloDocumentoFiscal());
        sintegra60M.setDataEmissao(dadosReducaoZ.getDataDoMovimento());
        sintegra60M.setNumeroSerieEcf(dadosReducaoZ.getNumeroDeSerie());

        try {
            sintegra60M.setNumeroEquipamento(Integer.valueOf(dadosReducaoZ.getNumeroDoECF()));
        } catch (Exception ex) {
            sintegra60M.setNumeroEquipamento(1);
        }
        try {
            sintegra60M.setCooInicial(Integer.valueOf(dadosReducaoZ.getNumeroCOOInicial()));
        } catch (Exception ex) {
            sintegra60M.setCooInicial(0);
        }
        sintegra60M.setCooFinal(dadosReducaoZ.getCoo() + 1);
        sintegra60M.setCrz(dadosReducaoZ.getCrz() + 1);
        sintegra60M.setCro(dadosReducaoZ.getCro());
        sintegra60M.setValorVendaBruta(BigDecimal.valueOf(dadosReducaoZ.getValorVendaBruta()));
        sintegra60M.setValorGrandeTotal(BigDecimal.valueOf(dadosReducaoZ.getValorGrandeTotal()));

        // Dados ICMS
        for (Aliquota a : dadosReducaoZ.getIcms()) {
            sintegra60A = new Sintegra60aVO();
            sintegra60A.setSintegra60m(sintegra60M);
            sintegra60A.setSituacaoTributaria(String.valueOf(a.getAliquota()).replace(",", ""));
            sintegra60A.setValor(BigDecimal.valueOf(a.getTotal()));

            sintegra60M.getListaSintegra60A().add(sintegra60A);
        }

        // Dados ISSQN
        for (Aliquota a : dadosReducaoZ.getIssqn()) {
            sintegra60A = new Sintegra60aVO();
            sintegra60A.setSintegra60m(sintegra60M);
            sintegra60A.setSituacaoTributaria(String.valueOf(a.getAliquota()).replace(",", ""));
            sintegra60A.setValor(BigDecimal.valueOf(a.getTotal()));

            sintegra60M.getListaSintegra60A().add(sintegra60A);
        }

        // Substituição Tributária - ICMS
        sintegra60A = new Sintegra60aVO();
        sintegra60A.setSintegra60m(sintegra60M);
        sintegra60A.setSituacaoTributaria("F");
        sintegra60A.setValor(BigDecimal.valueOf(dadosReducaoZ.getSubstituicaoTributariaICMS()));
        sintegra60M.getListaSintegra60A().add(sintegra60A);

        // Isento - ICMS
        sintegra60A = new Sintegra60aVO();
        sintegra60A.setSintegra60m(sintegra60M);
        sintegra60A.setSituacaoTributaria("I");
        sintegra60A.setValor(BigDecimal.valueOf(dadosReducaoZ.getIsentoICMS()));
        sintegra60M.getListaSintegra60A().add(sintegra60A);

        // Não-incidência - ICMS
        sintegra60A = new Sintegra60aVO();
        sintegra60A.setSintegra60m(sintegra60M);
        sintegra60A.setSituacaoTributaria("N");
        sintegra60A.setValor(BigDecimal.valueOf(dadosReducaoZ.getNaoTributadoICMS()));
        sintegra60M.getListaSintegra60A().add(sintegra60A);

        // Desconto - ICMS
        sintegra60A = new Sintegra60aVO();
        sintegra60A.setSintegra60m(sintegra60M);
        sintegra60A.setSituacaoTributaria("DESC");
        sintegra60A.setValor(BigDecimal.valueOf(dadosReducaoZ.getDescontoICMS()));
        sintegra60M.getListaSintegra60A().add(sintegra60A);

        // Cancelamento - ICMS
        sintegra60A = new Sintegra60aVO();
        sintegra60A.setSintegra60m(sintegra60M);
        sintegra60A.setSituacaoTributaria("CANC");
        sintegra60A.setValor(BigDecimal.valueOf(dadosReducaoZ.getCancelamentoICMS()));
        sintegra60M.getListaSintegra60A().add(sintegra60A);

        controller.salvar(sintegra60M);
    }

    public static boolean confereGT() {
        try {
            abreArquivoAuxiliar();
            String gtArquivo = arquivoAuxiliar.getProperty("ecf.gt");
            String gtEcf = String.valueOf(SessaoUsuario.getAcbrEcf().getGrandeTotal());
            gtEcf = Biblioteca.md5String(gtEcf);
            //System.out.println(gtEcf);
            if (gtArquivo.equals(gtEcf)) {
                return true;
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return false;
    }

    public static void atualizaGT() {
        try {
            abreArquivoAuxiliar();
            String gtEcf = String.valueOf(SessaoUsuario.getAcbrEcf().getGrandeTotal());
            String numSerie = SessaoUsuario.getAcbrEcf().getNumSerie();
            gtEcf = Biblioteca.md5String(gtEcf);
            numSerie = Biblioteca.md5String(numSerie);
            arquivoAuxiliar.setProperty("ecf.gt", gtEcf);
            arquivoAuxiliar.setProperty("ecf.serie", numSerie);
            salvaArquivoAuxiliar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void parametrosConfiguracao() throws Exception {
        SessaoUsuario.getAcbrEcf().abreRelatorioGerencial(SessaoUsuario.getConfiguracao().getEcfRelatorioGerencial().getParametrosConfiguracao());
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("***********PARAMETROS DE CONFIGURACAO***********", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("CONFIGURACAO:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Funcionalidades:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TIPO DE FUNCIONAMENTO: ......... Em Rede", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TIPO DE FUNCIONAMENTO: ......... Comercializavel", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("INTEGRACAO DO PAF-ECF: ......... Balcao", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Parâmetros Para Nao Concomitancia:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("PRE-VENDA: ................................. SIM", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("DAV POR ECF: ............................... SIM", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("DAV IMPRESSORA NAO FISCAL: ................. SIM", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("DAV-OS: .................................... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Aplicacoes Especiais:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TAB. INDICE TECNICO DE PRODUCAO: ........... SIM", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("POSTO REVENDEDOR DE COMBUSTIVEIS: .......... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Bar, Restaurante e Similar - ECF-Restaurante:NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Bar, Restaurante e Similar - ECF-Comum: .... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("FARMACIA DE MANIPULACAO: ................... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("OFICINA DE CONSERTO: ....................... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TRANSPORTE DE PASSAGEIROS: ................. NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Criterios por Unidade Federada:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("REQUISITO XVIII - Tela Consulta de Preco:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TOTALIZACAO DOS VALORES DA LISTA: .......... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TRANSFORMACAO DAS INFORMACOES EM PRE-VENDA:. NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TRANSFORMACAO DAS INFORMACOES EM DAV: ...... NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("REQUISITO XXII - PAF-ECF Integrado ao ECF:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NAO COINCIDENCIA GT(ECF) x ARQUIVO CRIPTOGRAFADO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("RECOMPOE VALOR DO GT ARQUIVO CRIPTOGRAFADO:  NAO", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("REQUISITO XXXVI - A - PAF-ECF Combustivel:", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Impedir Registro de Venda com Valor Zero ou", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("Negativo: .................................. SIM", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

        SessaoUsuario.getAcbrEcf().fechaRelatorio();

        gravaR06("RG");
    }

    public static void gravaR06(String simbolo) {
        try {
            ControllerGenerico<R06VO> controller = new ControllerGenerico<>();
            R06VO r06 = new R06VO();
            r06.setIdEcfCaixa(SessaoUsuario.movimento.getEcfCaixa().getId());
            r06.setIdOperador(SessaoUsuario.movimento.getEcfOperador().getId());
            r06.setIdImpressora(SessaoUsuario.movimento.getEcfImpressora().getId());
            r06.setSerieEcf(SessaoUsuario.movimento.getEcfImpressora().getSerie());
            r06.setCoo(Integer.valueOf(SessaoUsuario.getAcbrEcf().getNumCOO()));
            r06.setGnf(Integer.valueOf(SessaoUsuario.getAcbrEcf().getNumGNF()));
            r06.setGrg(Integer.valueOf(SessaoUsuario.getAcbrEcf().getNumGRG()));
            if (SessaoUsuario.getAcbrEcf().getMFD()) {
                r06.setCdc(Integer.valueOf(SessaoUsuario.getAcbrEcf().getNumCDC()));
            } else {
                r06.setCdc(0);
            }
            r06.setDenominacao(simbolo);
            r06.setDataEmissao(SessaoUsuario.getAcbrEcf().getDataHora());
            r06.setHoraEmissao(Biblioteca.formataHora(SessaoUsuario.getAcbrEcf().getDataHora()));
            controller.salvar(r06);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }

    public static void geraRegistrosPAF(Date dataInicio, Date dataFim, String pEstoqueTotalOuParcial, String pEstoqueCodigoOuNome, String pEstoqueCriterioUm, String pEstoqueCriterioDois, Date dataMovimento) throws Exception {
        ACBrPAF acbrPaf = getAcbrPaf();

        // U1 - Identificação do Estabelecimento Usuário do PAF-ECF
        geraRegistroU(acbrPaf);

        // A2 - Total Diário de Meios de Pagamento
        geraRegistroA2(acbrPaf, dataInicio, dataFim);

        // P2 - Relação das Mercadorias e Serviços
        geraRegistroP2(acbrPaf);

        // E2 - Relação das Mercadorias em Estoque
        geraRegistroE2(acbrPaf, pEstoqueTotalOuParcial, pEstoqueCodigoOuNome, pEstoqueCriterioUm, pEstoqueCriterioDois);

        // E3 - Identificação do ECF que Emitiu o Documento Base para a Atualização do Estoque
        geraRegistroE3(acbrPaf);

        // D2 - Relação dos DAV Emitidos / D3 - Detalhe do DAV
        geraRegistrosDAV(acbrPaf);

        // R01 a R07
        geraRegistrosR(acbrPaf, dataInicio, dataFim);

        /*
         O arquivo a que se refere o item 5 deverá ser denominado no formato CCCCCCNNNNNNNNNNNNNNDDMMAAAA.txt, sendo:
         a) “CCCCCC” o Código Nacional de Identificação de ECF relativo ao ECF a que se refere o movimento informado;
         b) “NNNNNNNNNNNNNN” os 14 (quatorze) últimos dígitos do número de fabricação do ECF;
         c) “DDMMAAAA” a data (dia/mês/ano) do movimento informado no arquivo.
         */
        String nomeArquivo = SessaoUsuario.getConfiguracao().getEcfImpressora().getCodigo();

        if (SessaoUsuario.getConfiguracao().getEcfImpressora().getSerie().length() > 14) {
            nomeArquivo += SessaoUsuario.getConfiguracao().getEcfImpressora().getSerie().substring(SessaoUsuario.getConfiguracao().getEcfImpressora().getSerie().length() - 14);
        } else {
            nomeArquivo += Biblioteca.repete("0", 14 - SessaoUsuario.getConfiguracao().getEcfImpressora().getSerie().length()) + SessaoUsuario.getConfiguracao().getEcfImpressora().getSerie();
        }

        if (dataMovimento == null) {
            dataMovimento = new Date();
        }
        nomeArquivo += Biblioteca.formataData(dataMovimento).replace("/", "") + ".txt";

        if (!acbrPaf.saveFileTXT_RegistrosECF(nomeArquivo)) {
            throw new ACBrException("Não foi possível criar o arquivo 'Registros PAF'.");
        }

        JOptionPane.showMessageDialog(null, "Arquivo armazenado em: " + Constantes.DIRETORIO_APLICACAO + nomeArquivo, "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void geraRegistroU(ACBrPAF acbrPaf) throws Exception {
        acbrPaf.getPaf_U().getRegistroU1().setCnpj(SessaoUsuario.getConfiguracao().getEcfEmpresa().getCnpj());
        acbrPaf.getPaf_U().getRegistroU1().setInscEstadual(SessaoUsuario.getConfiguracao().getEcfEmpresa().getInscricaoEstadual());
        acbrPaf.getPaf_U().getRegistroU1().setInscMunicipal(SessaoUsuario.getConfiguracao().getEcfEmpresa().getInscricaoMunicipal());
        acbrPaf.getPaf_U().getRegistroU1().setRazaoSocial(SessaoUsuario.getConfiguracao().getEcfEmpresa().getRazaoSocial());
    }

    private static void geraRegistroA2(ACBrPAF acbrPaf, Date dataInicio, Date dataFim) throws Exception {
        ViewTotalPagamentoDataController viewController = new ViewTotalPagamentoDataController();
        List<ViewTotalPagamentoDataVO> listaA2 = viewController.getBeans(dataInicio, dataFim);
        acbrPaf.getPaf_A().limparRegistros();
        String hashRegistro;
        TotalTipoPagamentoController totalTipoPagamentoController = new TotalTipoPagamentoController();
        for (ViewTotalPagamentoDataVO o : listaA2) {
            ACBrPAFRegistroA2 a2 = new ACBrPAFRegistroA2();
            a2.setData(o.getDataVenda());
            a2.setMeioPagamento(o.getDescricao());
            a2.setCodigoTipoDocumento(CodigoTipoDocumento.CUPOM_FISCAL);
            a2.setValor(o.getValorApurado().doubleValue());
            a2.setRegistroValido(true);
            //verifica se houveram alterações no banco de dados
            for (EcfTotalTipoPagamentoVO t : totalTipoPagamentoController.getBeans(o.getDataVenda(), o.getIdTipoPagamento())) {
                hashRegistro = t.getLogss() == null ? "" : t.getLogss();
                t.setLogss("0");
                if (!hashRegistro.equals(Biblioteca.hashRegistro(t))) {
                    a2.setRegistroValido(false);
                    break;
                }
            }

            acbrPaf.getPaf_A().getRegistrosA2().add(a2);
        }
    }

    private static void geraRegistroP2(ACBrPAF acbrPaf) throws Exception {
        ProdutoController controller = new ProdutoController();
        List<ProdutoVO> listaProduto = controller.getBeans(ProdutoVO.class);
        acbrPaf.getPaf_P().limparRegistros();
        String hashRegistro;
        for (ProdutoVO p : listaProduto) {
            ACBrPAFRegistroP2 p2 = new ACBrPAFRegistroP2();
            p2.setRegistroValido(true);
            hashRegistro = p.getLogss() == null ? "" : p.getLogss();
            p.setLogss("0");
            if (!hashRegistro.equals(Biblioteca.hashRegistro(p))) {
                p2.setRegistroValido(false);
            }
            p2.setCodMercadoriaServico(p.getGtin());
            p2.setDescMercadoriaServico(p.getDescricaoPdv());
            p2.setUnidadeMedida(p.getUnidadeProduto().getSigla());
            p2.setIat(p.getIat());
            p2.setIppt(p.getIppt());
            p2.setSt(p.getPafPSt());
            if (p.getTaxaIcms() == null) {
                p2.setAliquota(0);
            } else {
                p2.setAliquota(p.getTaxaIcms().doubleValue());
            }
            p2.setValorUnitario(p.getValorVenda().doubleValue());

            acbrPaf.getPaf_P().getRegistrosP2().add(p2);
        }
    }

    private static void geraRegistroE2(ACBrPAF acbrPaf, String pEstoqueTotalOuParcial, String pEstoqueCodigoOuNome, String pEstoqueCriterioUm, String pEstoqueCriterioDois) throws Exception {
        ProdutoController controller = new ProdutoController();
        List<ProdutoVO> listaProduto = new ArrayList<>();
        if (pEstoqueTotalOuParcial.equals("T")) {
            listaProduto = controller.getBeans(ProdutoVO.class);
        } else {
            if (pEstoqueCodigoOuNome.equals("C")) {
                listaProduto = controller.consultaPorFaixaId(Integer.valueOf(pEstoqueCriterioUm), Integer.valueOf(pEstoqueCriterioDois));
            } else if (pEstoqueCodigoOuNome.equals("N")) {
                listaProduto = controller.consultaPorNome(pEstoqueCriterioUm, pEstoqueCriterioDois);
            }
        }
        String hashRegistro;
        for (ProdutoVO p : listaProduto) {
            ACBrPAFRegistroE2 e2 = new ACBrPAFRegistroE2();
            e2.setRegistroValido(true);
            hashRegistro = p.getLogss() == null ? "" : p.getLogss();
            p.setLogss("0");
            if (!hashRegistro.equals(Biblioteca.hashRegistro(p))) {
                e2.setRegistroValido(false);
            }

            e2.setCodMercadoria(p.getGtin());
            e2.setDescMercadoria(p.getDescricaoPdv());
            e2.setUnidadeMedida(p.getUnidadeProduto().getSigla());
            e2.setQtdeEstoque(p.getQuantidadeEstoque().doubleValue());

            acbrPaf.getPaf_E().getRegistrosE2().add(e2);
        }
    }

    private static void geraRegistroE3(ACBrPAF acbrPaf) throws Exception {
        abreArquivoAuxiliar();
        Date dataEstoque = null;
        try {
            dataEstoque = Biblioteca.stringToDate(arquivoAuxiliar.getProperty("venda.dataEstoque"));
        } catch (Exception ex) {
        }

        if (dataEstoque != null) {
            ControllerGenerico<EcfE3VO> controller = new ControllerGenerico<>();
            EcfE3VO ecfE3VO = controller.getBean(EcfE3VO.class, "dataEstoque", dataEstoque);
            String hashRegistro;
            if (ecfE3VO != null) {
                ACBrPAFRegistroE3 e3 = acbrPaf.getPaf_E().getRegistroE3();
                e3.setRegistroValido(true);
                hashRegistro = ecfE3VO.getLogss() == null ? "" : ecfE3VO.getLogss();
                ecfE3VO.setLogss("0");
                if (!hashRegistro.equals(Biblioteca.hashRegistro(ecfE3VO))) {
                    e3.setRegistroValido(false);
                }

                e3.setNumFabricacao(ecfE3VO.getSerieEcf());
                e3.setMfAdicional(ecfE3VO.getMfAdicional());
                e3.setTipoEcf(ecfE3VO.getTipoEcf());
                e3.setMarcaEcf(ecfE3VO.getMarcaEcf());
                e3.setMarcaEcf(ecfE3VO.getModeloEcf());
                e3.setDataEstoque(ecfE3VO.getDataEstoque());
            }
        }
    }

    private static void geraRegistrosDAV(ACBrPAF acbrPaf) throws Exception {
        // TODO: 

    }

    private static void geraRegistrosR(ACBrPAF acbrPaf, Date dataInicio, Date dataFim) throws Exception {
        // Registro R1 - Identificação do ECF, do Usuário, do PAF-ECF e da Empresa Desenvolvedora
        acbrPaf.getPaf_R().limparRegistros();
        String hashRegistro;
        for (EcfImpressoraVO impressora : SessaoUsuario.getListaImpressora()) {
            ACBrPAFRegistroR1 r1 = new ACBrPAFRegistroR1();
            r1.setRegistroValido(true);
            hashRegistro = SessaoUsuario.getR01().getLogss() == null ? "" : SessaoUsuario.getR01().getLogss();
            SessaoUsuario.getR01().setLogss("0");
            if (!hashRegistro.equals(Biblioteca.hashRegistro(SessaoUsuario.getR01()))) {
                r1.setRegistroValido(false);
            }

            r1.setNumFabricacao(impressora.getSerie());
            r1.setMfAdicional(impressora.getMfd());
            r1.setTipoEcf(impressora.getTipo());
            r1.setMarcaEcf(impressora.getMarca());
            r1.setModeloEcf(impressora.getModelo());
            r1.setVersaoSb(impressora.getVersao());
            r1.setDtInstalacaoSb(impressora.getDataInstalacaoSb());
            r1.setHoraInstalacaoSb(Biblioteca.horaToDate(impressora.getHoraInstalacaoSb()));
            r1.setNumSeqEcf(impressora.getNumero());
            r1.setCnpj(SessaoUsuario.getConfiguracao().getEcfEmpresa().getCnpj());
            r1.setInscEstadual(SessaoUsuario.getConfiguracao().getEcfEmpresa().getInscricaoEstadual());
            r1.setCnpjSh(SessaoUsuario.getR01().getCnpjSh());
            r1.setInscEstadualSh(SessaoUsuario.getR01().getInscricaoEstadualSh());
            r1.setInscMunicipalSh(SessaoUsuario.getR01().getInscricaoMunicipalSh());
            r1.setNomeSh(SessaoUsuario.getR01().getDenominacaoSh());
            r1.setNomePaf(SessaoUsuario.getR01().getNomePafEcf());
            r1.setVersaoPaf(SessaoUsuario.getR01().getVersaoPafEcf());
            r1.setCodigoMd5(SessaoUsuario.getR01().getMd5PafEcf());
            r1.setVersaoRequisitosPaf(SessaoUsuario.getR01().getVersaoEr());
            r1.setDataInicial(dataInicio);
            r1.setDataFim(dataFim);

            acbrPaf.getPaf_R().getRegistrosR1().add(r1);

            // Registro R02 - Relação de Reduções Z / Registro R03 - Detalhe da Redução Z
            R02Controller r02Controller = new R02Controller();
            List<R02VO> listaR02 = r02Controller.getBeans(impressora.getSerie(), dataInicio, dataFim);
            for (R02VO r02VO : listaR02) {
                ACBrPAFRegistroR2 r2 = new ACBrPAFRegistroR2();
                r2.setRegistroValido(true);
                hashRegistro = r02VO.getLogss() == null ? "" : r02VO.getLogss();
                r02VO.setLogss("0");
                if (!hashRegistro.equals(Biblioteca.hashRegistro(r02VO))) {
                    r2.setRegistroValido(false);
                }

                r2.setNumeroUsuario(r02VO.getIdOperador());
                r2.setCrz(r02VO.getCrz());
                r2.setCoo(r02VO.getCoo());
                r2.setCro(r02VO.getCro());
                r2.setDataMovimento(r02VO.getDataMovimento());
                r2.setDataEmissao(r02VO.getDataEmissao());
                r2.setHoraEmissao(Biblioteca.horaToDate(r02VO.getHoraEmissao()));
                r2.setVendaBrutaDiaria(r02VO.getVendaBruta().doubleValue());
                r2.setParametroEcf("");

                // Registro R03 - FILHO
                for (R03VO r03vo : r02VO.getListaR03()) {
                    ACBrPAFRegistroR3 r3 = new ACBrPAFRegistroR3();
                    r3.setRegistroValido(true);
                    hashRegistro = r03vo.getLogss() == null ? "" : r03vo.getLogss();
                    r03vo.setLogss("0");
                    if (!hashRegistro.equals(Biblioteca.hashRegistro(r03vo))) {
                        r3.setRegistroValido(false);
                    }

                    r3.setCodTotalzadorParcial(r03vo.getTotalizadorParcial());
                    r3.setValorAcumulado(r03vo.getValorAcumulado().doubleValue());

                    r2.getRegistrosR3().add(r3);
                }

                r1.getRegistrosR2().add(r2);
            }

            // Registro R04 - Cupom Fiscal, Nota Fiscal de Venda a Consumidor ou Bilhete de Passagem - ECF_VENDA_CABECALHO
            // Registro R05 - Detalhe do Cupom Fiscal, Nota Fiscal de Venda a Consumidor ou Bilhete de Passagem - ECF_VENDA_DETALHE
            // Registro R07 - Detalhe do Cupom Fiscal e do Documento Não Fiscal - Meio de Pagamento
            VendaController vendaController = new VendaController();
            List<EcfVendaCabecalhoVO> listaR04 = vendaController.getBeans(impressora.getSerie(), dataInicio, dataFim);
            for (EcfVendaCabecalhoVO vendaCabecalho : listaR04) {
                ACBrPAFRegistroR4 r4 = new ACBrPAFRegistroR4();
                r4.setRegistroValido(true);
                hashRegistro = vendaCabecalho.getLogss() == null ? "" : vendaCabecalho.getLogss();
                vendaCabecalho.setLogss("0");
                if (!hashRegistro.equals(Biblioteca.hashRegistro(vendaCabecalho))) {
                    r4.setRegistroValido(false);
                }

                if (vendaCabecalho.getEcfFuncionario() != null) {
                    r4.setNumeroUsuario(vendaCabecalho.getEcfFuncionario().getId());
                } else {
                    r4.setNumeroUsuario(0);
                }
                r4.setNumContador(vendaCabecalho.getCcf());
                r4.setCoo(vendaCabecalho.getCoo());
                r4.setDataInicioEmissao(vendaCabecalho.getDataVenda());
                r4.setSubTotalDocumento(vendaCabecalho.getValorVenda().doubleValue());
                r4.setDescontoSobreSubtotal(vendaCabecalho.getDesconto().doubleValue());
                r4.setTipoDesconto("V");
                r4.setAcrescimoSobreSubtotal(vendaCabecalho.getAcrescimo().doubleValue());
                r4.setTipoAcrescimo("V");
                r4.setValorTotalLiquido(vendaCabecalho.getValorFinal().doubleValue());
                r4.setIndCancelamento(vendaCabecalho.getCupomCancelado());
                r4.setValorCancelamento(vendaCabecalho.getValorCancelado().doubleValue());
                r4.setOrdemAplicacaoDescAcres("D");
                r4.setNomeCliente(vendaCabecalho.getNomeCliente());
                r4.setCnpjCpf(vendaCabecalho.getCpfCnpjCliente());

                r1.getRegistrosR4().add(r4);

                // Registro R05 - FILHO
                for (EcfVendaDetalheVO vendaDetalhe : vendaCabecalho.getListaEcfVendaDetalhe()) {
                    ACBrPAFRegistroR5 r5 = new ACBrPAFRegistroR5();
                    r5.setRegistroValido(true);
                    hashRegistro = vendaDetalhe.getLogss() == null ? "" : vendaDetalhe.getLogss();
                    vendaDetalhe.setLogss("0");
                    if (!hashRegistro.equals(Biblioteca.hashRegistro(vendaDetalhe))) {
                        r5.setRegistroValido(false);
                    }

                    r5.setNumItem(vendaDetalhe.getItem());
                    r5.setCodItem(vendaDetalhe.getGtin());
                    r5.setDescricaoItem(vendaDetalhe.getProduto().getDescricaoPdv());
                    r5.setQtdeItem(vendaDetalhe.getQuantidade().doubleValue());
                    r5.setUnidadeMedida(vendaDetalhe.getProduto().getUnidadeProduto().getSigla());
                    r5.setValorUnitario(vendaDetalhe.getValorUnitario().doubleValue());
                    r5.setDescontoItem(vendaDetalhe.getDesconto().doubleValue());
                    r5.setAcrescimoItem(vendaDetalhe.getAcrescimo().doubleValue());
                    r5.setValorTotalLiquidoItem(vendaDetalhe.getTotalItem().doubleValue());
                    r5.setCodTotalizadorParcial(vendaDetalhe.getTotalizadorParcial());
                    r5.setIndCancelamento(vendaDetalhe.getCancelado());
                    if (vendaDetalhe.getCancelado().equals("S")) {
                        r5.setQtdeCancelada(vendaDetalhe.getQuantidade().doubleValue());
                        r5.setValorCancelamento(vendaDetalhe.getTotalItem().doubleValue());
                    } else {
                        r5.setQtdeCancelada(0);
                        r5.setValorCancelamento(0);
                    }
                    r5.setValorCancelamentoAcresc(0);
                    r5.setIat(vendaDetalhe.getProduto().getIat());
                    r5.setIppt(vendaDetalhe.getProduto().getIppt());
                    r5.setNumCasasDecimaisEmQtde(SessaoUsuario.getConfiguracao().getDecimaisQuantidade());
                    r5.setNumCasasDecimaisEmValor(SessaoUsuario.getConfiguracao().getDecimaisValor());

                    r4.getRegistrosR5().add(r5);
                }

                // Registro R07 - FILHO DO R04 - MEIOS DE PAGAMENTO
                for (EcfTotalTipoPagamentoVO tipoPagamento : vendaCabecalho.getListaEcfTotalTipoPagamento()) {
                    ACBrPAFRegistroR7 r7 = new ACBrPAFRegistroR7();
                    r7.setRegistroValido(true);
                    hashRegistro = tipoPagamento.getLogss() == null ? "" : tipoPagamento.getLogss();
                    tipoPagamento.setLogss("0");
                    if (!hashRegistro.equals(Biblioteca.hashRegistro(tipoPagamento))) {
                        r7.setRegistroValido(false);
                    }

                    r7.setCoo(tipoPagamento.getCoo());
                    r7.setCcf(tipoPagamento.getCcf());
                    r7.setGnf(tipoPagamento.getGnf());
                    r7.setMeioPagamento(tipoPagamento.getEcfTipoPagamento().getDescricao());
                    r7.setValorPago(tipoPagamento.getValor().doubleValue());
                    r7.setIndEstorno(tipoPagamento.getEstorno());
                    r7.setValorEstorno(tipoPagamento.getValor().doubleValue());

                    r4.getRegistrosR7().add(r7);
                }
            }

            // Registro R06 - Demais documentos emitidos pelo ECF
            // Registro R07 - Detalhe do Cupom Fiscal e do Documento Não Fiscal - Meio de Pagamento
            R06Controller r06Controller = new R06Controller();
            List<R06VO> listaR06 = r06Controller.getBeans(impressora.getSerie(), dataInicio, dataFim);
            for (R06VO r06vo : listaR06) {
                ACBrPAFRegistroR6 r6 = new ACBrPAFRegistroR6();
                r6.setRegistroValido(true);
                hashRegistro = r06vo.getLogss() == null ? "" : r06vo.getLogss();
                r06vo.setLogss("0");
                if (!hashRegistro.equals(Biblioteca.hashRegistro(r06vo))) {
                    r6.setRegistroValido(false);
                }

                r6.setNumeroUsuario(r06vo.getIdOperador());
                r6.setCoo(r06vo.getCoo());
                r6.setGnf(r06vo.getGnf());
                r6.setGrg(r06vo.getGrg());
                r6.setCdc(r06vo.getCdc());
                r6.setDenominacao(r06vo.getDenominacao());
                r6.setDataFinalEmissao(r06vo.getDataEmissao());
                r6.setHoraFinalEmissao(Biblioteca.horaToDate(r06vo.getHoraEmissao()));

                r1.getRegistrosR6().add(r6);

                for (R07VO r07vo : r06vo.getListaR07()) {
                    ACBrPAFRegistroR7 r7 = new ACBrPAFRegistroR7();
                    r7.setRegistroValido(true);
                    hashRegistro = r07vo.getLogss() == null ? "" : r07vo.getLogss();
                    r07vo.setLogss("0");
                    if (!hashRegistro.equals(Biblioteca.hashRegistro(r07vo))) {
                        r7.setRegistroValido(false);
                    }
                    
                    r7.setCcf(r07vo.getCcf());
                    r7.setMeioPagamento(r07vo.getMeioPagamento());
                    r7.setValorPago(r07vo.getValorPagamento().doubleValue());
                    r7.setIndEstorno(r07vo.getEstorno());
                    r7.setValorEstorno(r07vo.getValorEstorno().doubleValue());

                    r6.getRegistrosR7().add(r7);
                }
            }
        }
    }
    
    public static void geraArquivoMF() throws Exception {
        SessaoUsuario.getAcbrEcf().gerarArquivoMF(Constantes.DIRETORIO_APLICACAO + "ArquivoMF");
        JOptionPane.showMessageDialog(null, "Arquivo armazenado em: " + Constantes.DIRETORIO_APLICACAO + "ArquivoMF", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void geraArquivoMFD() throws Exception {
        SessaoUsuario.getAcbrEcf().gerarArquivoMF(Constantes.DIRETORIO_APLICACAO + "ArquivoMFD");
        JOptionPane.showMessageDialog(null, "Arquivo armazenado em: " + Constantes.DIRETORIO_APLICACAO + "ArquivoMFD", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void abreArquivoAuxiliar() throws Exception {
        arquivoAuxiliar = new Properties();
        arquivoAuxiliar.load(new FileInputStream(new File(Constantes.ARQUIVO_AUXILIAR)));
    }

    private static void salvaArquivoAuxiliar() throws Exception {
        FileOutputStream out = new FileOutputStream(new File(Constantes.ARQUIVO_AUXILIAR));
        arquivoAuxiliar.store(out, "Arquivo auxiliar do PAF");
        out.close();
    }

    public static void gravaIdUltimaVenda() throws Exception {
        abreArquivoAuxiliar();
        arquivoAuxiliar.setProperty("venda.id", SessaoUsuario.vendaAtual.getId().toString());
        salvaArquivoAuxiliar();
    }

    public static Integer recuperaIdUltimaVenda() throws Exception {
        abreArquivoAuxiliar();
        Integer id = Integer.valueOf(arquivoAuxiliar.getProperty("venda.id"));
        return id;
    }

    public static void atualizaEstoque() throws Exception {
        abreArquivoAuxiliar();
        arquivoAuxiliar.setProperty("venda.dataEstoque", Biblioteca.formataData(SessaoUsuario.getAcbrEcf().getDataHora()));
        salvaArquivoAuxiliar();
    }

    private static ACBrPAF getAcbrPaf() throws ACBrException {
        ACBrPAF acbrPaf = new ACBrPAF();
        acbrPaf.setNomeArquivo(Constantes.DIRETORIO_APLICACAO);
        acbrPaf.addOnPAFGetKeyRSA(new ACBrEventListener<PAFGetKeyRSAEventObject>() {

            @Override
            public void notification(PAFGetKeyRSAEventObject e) {
                e.setKey(Constantes.CHAVE_PRIVADA);
            }
        });
        return acbrPaf;
    }

}
