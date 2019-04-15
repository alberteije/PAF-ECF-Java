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
package com.t2ti.plugins.paf.pafd;

import com.t2ti.plugins.util.PafUtil;
import java.util.ArrayList;
import java.util.List;

public class RegistroD {

    private RegistroD1 registroD1;
    private List<RegistroD2> listaRegistroD2;
    private List<RegistroD3> listaRegistroD3;
    private RegistroD9 registroD9;
    private PafUtil util;

    public RegistroD(PafUtil pafUtil) {
        registroD1 = new RegistroD1();
        listaRegistroD2 = new ArrayList<RegistroD2>();
        listaRegistroD3 = new ArrayList<RegistroD3>();
        registroD9 = new RegistroD9();

        registroD9.setTotalRegistrosD2(0);
        registroD9.setTotalRegistrosD3(0);

        this.util = pafUtil;
    }

    public void limpaRegistros() {
        getRegistroD9().setTotalRegistrosD2(0);
        getRegistroD9().setTotalRegistrosD3(0);
    }

    public String writeRegistroD1() {
        return getUtil().fill("D1")
                + getUtil().lFill(getRegistroD1().getCnpj(), 14)
                + getUtil().rFill(getRegistroD1().getInscricaoEstadual(), 14)
                + getUtil().rFill(getRegistroD1().getInscricaoMunicipal(), 14)
                + getUtil().rFill(getRegistroD1().getRazaoSocial(), 50)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroD2() {
        String registro = "";
        for (int i = 0; i < listaRegistroD2.size(); i++) {
            registro += getUtil().fill("D2")
                    + getUtil().lFill(listaRegistroD2.get(i).getCnpjEstabelecimento(), 14)
                    + getUtil().rFill(listaRegistroD2.get(i).getNumeroFabricacao(), 20)
                    + getUtil().rFill(listaRegistroD2.get(i).getMfAdicional(), 1)
                    + getUtil().rFill(listaRegistroD2.get(i).getTipoEcf(), 7)
                    + getUtil().rFill(listaRegistroD2.get(i).getMarcaEcf(), 20)
                    + getUtil().rFill(listaRegistroD2.get(i).getModeloEcf(), 20)
                    + getUtil().lFill(listaRegistroD2.get(i).getCoo(), 6)
                    + getUtil().lFill(listaRegistroD2.get(i).getNumeroDav(), 13)
                    + getUtil().fill(listaRegistroD2.get(i).getDataDav())
                    + getUtil().rFill(listaRegistroD2.get(i).getTituloDav(), 30)
                    + getUtil().lFill(listaRegistroD2.get(i).getValorTotalDav(), 8)
                    + getUtil().lFill(listaRegistroD2.get(i).getCooVinculado(), 6)
                    + getUtil().lFill(listaRegistroD2.get(i).getNumeroSequencial(), 3)
                    + getUtil().rFill(listaRegistroD2.get(i).getNomeAdquirente(), 40)
                    + getUtil().lFill(listaRegistroD2.get(i).getCpfCnpjAdquirente(), 14)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroD9().setTotalRegistrosD2(getRegistroD9().getTotalRegistrosD2() + 1);
        }
        return registro;
    }

    public String writeRegistroD3() {
        String registro = "";
        for (int i = 0; i < listaRegistroD3.size(); i++) {
            registro += getUtil().fill("D3")
                    + getUtil().lFill(listaRegistroD3.get(i).getNumeroDav(), 13)
                    + getUtil().fill(listaRegistroD3.get(i).getDataInclusao())
                    + getUtil().lFill(listaRegistroD3.get(i).getNumeroItem(), 3)
                    + getUtil().rFill(listaRegistroD3.get(i).getCodigoProduto(), 14)
                    + getUtil().rFill(listaRegistroD3.get(i).getDescricaoProduto(), 100)
                    + getUtil().lFill(listaRegistroD3.get(i).getQuantidade(), 7)
                    + getUtil().rFill(listaRegistroD3.get(i).getUnidade(), 3)
                    + getUtil().lFill(listaRegistroD3.get(i).getValorUnitario(), 8)
                    + getUtil().lFill(listaRegistroD3.get(i).getValorDesconto(), 8)
                    + getUtil().lFill(listaRegistroD3.get(i).getValorAcrescimo(), 8)
                    + getUtil().lFill(listaRegistroD3.get(i).getValorTotalLiquido(), 8)
                    + getUtil().rFill(listaRegistroD3.get(i).getSituacaoTributaria(), 1)
                    + getUtil().lFill(listaRegistroD3.get(i).getAliquota(), 4)
                    + getUtil().lFill(listaRegistroD3.get(i).getIndicadorCancelamento(), 1)
                    + getUtil().lFill(listaRegistroD3.get(i).getCasasDecimaisQuantidade(), 1)
                    + getUtil().lFill(listaRegistroD3.get(i).getCasasDecimaisValorUnitario(), 1)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroD9().setTotalRegistrosD3(getRegistroD9().getTotalRegistrosD3() + 1);
        }
        return registro;
    }

    public String writeRegistroD9() {
        return getUtil().fill("D9")
                + getUtil().lFill(getRegistroD9().getCnpj(), 14)
                + getUtil().rFill(getRegistroD9().getInscricaoEstadual(), 14)
                + getUtil().lFill(getRegistroD9().getTotalRegistrosD2(), 6)
                + getUtil().lFill(getRegistroD9().getTotalRegistrosD3(), 6)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroD1
     */
    public RegistroD1 getRegistroD1() {
        return registroD1;
    }

    /**
     * @param registroD1 the registroD1 to set
     */
    public void setRegistroD1(RegistroD1 registroD1) {
        this.registroD1 = registroD1;
    }

    /**
     * @return the listaRegistroD2
     */
    public List<RegistroD2> getListaRegistroD2() {
        return listaRegistroD2;
    }

    /**
     * @param listaRegistroD2 the listaRegistroD2 to set
     */
    public void setListaRegistroD2(List<RegistroD2> listaRegistroD2) {
        this.listaRegistroD2 = listaRegistroD2;
    }

    /**
     * @return the listaRegistroD3
     */
    public List<RegistroD3> getListaRegistroD3() {
        return listaRegistroD3;
    }

    /**
     * @param listaRegistroD3 the listaRegistroD3 to set
     */
    public void setListaRegistroD3(List<RegistroD3> listaRegistroD3) {
        this.listaRegistroD3 = listaRegistroD3;
    }

    /**
     * @return the registroD9
     */
    public RegistroD9 getRegistroD9() {
        return registroD9;
    }

    /**
     * @param registroD9 the registroD9 to set
     */
    public void setRegistroD9(RegistroD9 registroD9) {
        this.registroD9 = registroD9;
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
