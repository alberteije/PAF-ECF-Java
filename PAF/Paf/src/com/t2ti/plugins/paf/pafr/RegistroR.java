/**
 * <p>Title: T2TiPDV</p>
 *
 * <p>Description: Arquivos Paf - Ato Cotepe 06/08</p>
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
package com.t2ti.plugins.paf.pafr;

import com.t2ti.plugins.util.PafUtil;
import java.util.ArrayList;
import java.util.List;

public class RegistroR {

    private RegistroR01 registroR01;
    private List<RegistroR02> listaRegistroR02;
    private List<RegistroR03> listaRegistroR03;
    private List<RegistroR04> listaRegistroR04;
    private List<RegistroR05> listaRegistroR05;
    private List<RegistroR06> listaRegistroR06;
    private List<RegistroR07> listaRegistroR07;

    private PafUtil util;

    public RegistroR(PafUtil pafUtil) {
        registroR01 = new RegistroR01();
        listaRegistroR02  = new ArrayList<RegistroR02>();
        listaRegistroR03  = new ArrayList<RegistroR03>();
        listaRegistroR04  = new ArrayList<RegistroR04>();
        listaRegistroR05  = new ArrayList<RegistroR05>();
        listaRegistroR06  = new ArrayList<RegistroR06>();
        listaRegistroR07  = new ArrayList<RegistroR07>();

        this.util = pafUtil;
    }

    public void limpaRegistros() {
    }

    public String writeRegistroR01() {
        return getUtil().fill("R01")
                + getUtil().rFill(getRegistroR01().getNumeroFabricacao(), 20)
                + getUtil().rFill(getRegistroR01().getMfAdicional(), 1)
                + getUtil().rFill(getRegistroR01().getTipoEcf(), 7)
                + getUtil().rFill(getRegistroR01().getMarcaEcf(), 20)
                + getUtil().rFill(getRegistroR01().getModeloEcf(), 20)
                + getUtil().rFill(getRegistroR01().getVersaoSb(), 10)
                + getUtil().fill(getRegistroR01().getDataInstalacaoSb())
                + getUtil().fill(getRegistroR01().getHoraInstalacaoSb())
                + getUtil().lFill(getRegistroR01().getNumeroSequencialEcf(), 3)
                + getUtil().lFill(getRegistroR01().getCnpjUsuario(), 14)
                + getUtil().rFill(getRegistroR01().getInscricaoEstadualUsuario(), 14)
                + getUtil().lFill(getRegistroR01().getCnpjSoftwareHouse(), 14)
                + getUtil().rFill(getRegistroR01().getInscricaoEstadualSoftwareHouse(), 14)
                + getUtil().rFill(getRegistroR01().getInscricaoMunicipalSoftwareHouse(), 14)
                + getUtil().rFill(getRegistroR01().getNomeSoftwareHouse(), 40)
                + getUtil().rFill(getRegistroR01().getNomePaf(), 40)
                + getUtil().rFill(getRegistroR01().getVersaoPaf(), 10)
                + getUtil().rFill(getRegistroR01().getCodigoMd5(), 32)
                + getUtil().fill(getRegistroR01().getDataInicial())
                + getUtil().fill(getRegistroR01().getDataFinal())
                + getUtil().rFill(getRegistroR01().getVersaoEspecificacaoRequisitos(), 4)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroR02() {
        String registro = "";
        for (int i = 0; i < listaRegistroR02.size(); i++) {
            registro += getUtil().fill("R02")
                    + getUtil().rFill(listaRegistroR02.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroR02.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroR02.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroR02.get(i).getNumeroUsuario(), 2)
                    + getUtil().lFill(listaRegistroR02.get(i).getCrz(), 6)
                    + getUtil().lFill(listaRegistroR02.get(i).getCoo(), 6)
                    + getUtil().lFill(listaRegistroR02.get(i).getCro(), 6)
                    + getUtil().fill(listaRegistroR02.get(i).getDataMovimento())
                    + getUtil().fill(listaRegistroR02.get(i).getDataEmissao())
                    + getUtil().fill(listaRegistroR02.get(i).getHoraEmissao())
                    + getUtil().lFill(listaRegistroR02.get(i).getVendaBrutaDiaria(), 14)
                    + getUtil().rFill(listaRegistroR02.get(i).getParametroEcfDescontoIssqn(), 1)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
        }
        return registro;
    }

    public String writeRegistroR03() {
        String registro = "";
        for (int i = 0; i < listaRegistroR03.size(); i++) {
            registro += getUtil().fill("R03")
                    + getUtil().rFill(listaRegistroR03.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroR03.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroR03.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroR03.get(i).getNumeroUsuario(), 2)
                    + getUtil().lFill(listaRegistroR03.get(i).getCrz(), 6)
                    + getUtil().rFill(listaRegistroR03.get(i).getTotalizadorParcial(), 7)
                    + getUtil().lFill(listaRegistroR03.get(i).getValorAcumulado(), 13)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
        }
        return registro;
    }

    public String writeRegistroR04() {
        String registro = "";
        for (int i = 0; i < listaRegistroR04.size(); i++) {
            registro += getUtil().fill("R04")
                    + getUtil().rFill(listaRegistroR04.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroR04.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroR04.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroR04.get(i).getNumeroUsuario(), 2)
                    + getUtil().lFill(listaRegistroR04.get(i).getNumeroContador(), 6)
                    + getUtil().lFill(listaRegistroR04.get(i).getCoo(), 6)
                    + getUtil().fill(listaRegistroR04.get(i).getDataInicio())
                    + getUtil().lFill(listaRegistroR04.get(i).getSubtotalDocumento(), 14)
                    + getUtil().lFill(listaRegistroR04.get(i).getDescontoSubtotal(), 13)
                    + getUtil().rFill(listaRegistroR04.get(i).getIndicadorTipoDesconto(), 1)
                    + getUtil().lFill(listaRegistroR04.get(i).getAcrescimoSubtotal(), 13)
                    + getUtil().rFill(listaRegistroR04.get(i).getIndicadorTipoAcrescimo(), 1)
                    + getUtil().lFill(listaRegistroR04.get(i).getValorTotalLiquido(), 14)
                    + getUtil().rFill(listaRegistroR04.get(i).getIndicadorCancelamento(), 1)
                    + getUtil().lFill(listaRegistroR04.get(i).getCancelamentoSubtotal(), 13)
                    + getUtil().rFill(listaRegistroR04.get(i).getOrdemAplicacaoDescontoAcrescimo(), 1)
                    + getUtil().rFill(listaRegistroR04.get(i).getNomeCliente(), 40)
                    + getUtil().lFill(listaRegistroR04.get(i).getCnpjCpfAdquirente(), 14)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
        }
        return registro;
    }
    
    public String writeRegistroR05() {
        String registro = "";
        for (int i = 0; i < listaRegistroR05.size(); i++) {
            registro += getUtil().fill("R05")
                    + getUtil().rFill(listaRegistroR05.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroR05.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroR05.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroR05.get(i).getNumeroUsuario(), 2)
                    + getUtil().lFill(listaRegistroR05.get(i).getCoo(), 6)
                    + getUtil().lFill(listaRegistroR05.get(i).getNumeroContador(), 6)
                    + getUtil().lFill(listaRegistroR05.get(i).getNumeroItem(), 3)
                    + getUtil().rFill(listaRegistroR05.get(i).getCodigoProduto(), 14)
                    + getUtil().rFill(listaRegistroR05.get(i).getDescricaoProduto(), 100)
                    + getUtil().lFill(listaRegistroR05.get(i).getQuantidadeProduto(), 7)
                    + getUtil().rFill(listaRegistroR05.get(i).getUnidadeMedida(), 3)
                    + getUtil().lFill(listaRegistroR05.get(i).getValorUnitario(), 8)
                    + getUtil().lFill(listaRegistroR05.get(i).getDescontoSobreItem(), 8)
                    + getUtil().lFill(listaRegistroR05.get(i).getAcrescimoSobreItem(), 8)
                    + getUtil().lFill(listaRegistroR05.get(i).getValorTotalLiquido(), 14)
                    + getUtil().rFill(listaRegistroR05.get(i).getTotalizadorParcial(), 7)
                    + getUtil().rFill(listaRegistroR05.get(i).getIndicadorCancelamento(), 1)
                    + getUtil().lFill(listaRegistroR05.get(i).getQuantidadeCancelada(), 7)
                    + getUtil().lFill(listaRegistroR05.get(i).getValorCancelado(), 13)
                    + getUtil().lFill(listaRegistroR05.get(i).getCancelamentoAcrescimoItem(), 13)
                    + getUtil().rFill(listaRegistroR05.get(i).getIat(), 1)
                    + getUtil().rFill(listaRegistroR05.get(i).getIppt(), 1)
                    + getUtil().lFill(listaRegistroR05.get(i).getCasasDecimaisQuantidade(), 1)
                    + getUtil().lFill(listaRegistroR05.get(i).getCasasDecimaisValorUnitario(), 1)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
        }
        return registro;
    }

    public String writeRegistroR06() {
        String registro = "";
        for (int i = 0; i < listaRegistroR06.size(); i++) {
            registro += getUtil().fill("R06")
                    + getUtil().rFill(listaRegistroR06.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroR06.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroR06.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroR06.get(i).getNumeroUsuario(), 2)
                    + getUtil().lFill(listaRegistroR06.get(i).getCoo(), 6)
                    + getUtil().lFill(listaRegistroR06.get(i).getGnf(), 6)
                    + getUtil().lFill(listaRegistroR06.get(i).getGrg(), 6)
                    + getUtil().lFill(listaRegistroR06.get(i).getCdc(), 4)
                    + getUtil().rFill(listaRegistroR06.get(i).getDenominacao(), 2)
                    + getUtil().fill(listaRegistroR06.get(i).getDataFinalEmissao())
                    + getUtil().fill(listaRegistroR06.get(i).getHoraFinalEmissao())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
        }
        return registro;
    }

    public String writeRegistroR07() {
        String registro = "";
        for (int i = 0; i < listaRegistroR07.size(); i++) {
            registro += getUtil().fill("R07")
                    + getUtil().rFill(listaRegistroR07.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroR07.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroR07.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroR07.get(i).getNumeroUsuario(), 2)
                    + getUtil().lFill(listaRegistroR07.get(i).getCoo(), 6)
                    + getUtil().lFill(listaRegistroR07.get(i).getCcf(), 6)
                    + getUtil().lFill(listaRegistroR07.get(i).getGnf(), 6)
                    + getUtil().rFill(listaRegistroR07.get(i).getMeioPagamento(), 15)
                    + getUtil().lFill(listaRegistroR07.get(i).getValorPago(), 13)
                    + getUtil().rFill(listaRegistroR07.get(i).getIndicadorEstorno(), 1)
                    + getUtil().lFill(listaRegistroR07.get(i).getValorEstornado(), 13)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
        }
        return registro;
    }

    /**
     * @return the registroR01
     */
    public RegistroR01 getRegistroR01() {
        return registroR01;
    }

    /**
     * @param registroR01 the registroR01 to set
     */
    public void setRegistroR01(RegistroR01 registroR01) {
        this.registroR01 = registroR01;
    }

    /**
     * @return the listaRegistroR02
     */
    public List<RegistroR02> getListaRegistroR02() {
        return listaRegistroR02;
    }

    /**
     * @param listaRegistroR02 the listaRegistroR02 to set
     */
    public void setListaRegistroR02(List<RegistroR02> listaRegistroR02) {
        this.listaRegistroR02 = listaRegistroR02;
    }

    /**
     * @return the listaRegistroR03
     */
    public List<RegistroR03> getListaRegistroR03() {
        return listaRegistroR03;
    }

    /**
     * @param listaRegistroR03 the listaRegistroR03 to set
     */
    public void setListaRegistroR03(List<RegistroR03> listaRegistroR03) {
        this.listaRegistroR03 = listaRegistroR03;
    }

    /**
     * @return the listaRegistroR04
     */
    public List<RegistroR04> getListaRegistroR04() {
        return listaRegistroR04;
    }

    /**
     * @param listaRegistroR04 the listaRegistroR04 to set
     */
    public void setListaRegistroR04(List<RegistroR04> listaRegistroR04) {
        this.listaRegistroR04 = listaRegistroR04;
    }

    /**
     * @return the listaRegistroR05
     */
    public List<RegistroR05> getListaRegistroR05() {
        return listaRegistroR05;
    }

    /**
     * @param listaRegistroR05 the listaRegistroR05 to set
     */
    public void setListaRegistroR05(List<RegistroR05> listaRegistroR05) {
        this.listaRegistroR05 = listaRegistroR05;
    }

    /**
     * @return the listaRegistroR06
     */
    public List<RegistroR06> getListaRegistroR06() {
        return listaRegistroR06;
    }

    /**
     * @param listaRegistroR06 the listaRegistroR06 to set
     */
    public void setListaRegistroR06(List<RegistroR06> listaRegistroR06) {
        this.listaRegistroR06 = listaRegistroR06;
    }

    /**
     * @return the listaRegistroR07
     */
    public List<RegistroR07> getListaRegistroR07() {
        return listaRegistroR07;
    }

    /**
     * @param listaRegistroR07 the listaRegistroR07 to set
     */
    public void setListaRegistroR07(List<RegistroR07> listaRegistroR07) {
        this.listaRegistroR07 = listaRegistroR07;
    }

    /**
     * @return the util
     */
    public PafUtil getUtil() {
        return util;
    }

    /**
     * @param util the util to set
     */
    public void setUtil(PafUtil util) {
        this.util = util;
    }


}