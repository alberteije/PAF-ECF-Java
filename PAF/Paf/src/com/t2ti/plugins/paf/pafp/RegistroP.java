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
package com.t2ti.plugins.paf.pafp;

import com.t2ti.plugins.util.PafUtil;
import java.util.ArrayList;
import java.util.List;

public class RegistroP {

    private RegistroP1 registroP1;
    private List<RegistroP2> listaRegistroP2;
    private RegistroP9 registroP9;

    private PafUtil util;

    public RegistroP(PafUtil pafUtil) {
        registroP1 = new RegistroP1();
        listaRegistroP2  = new ArrayList<RegistroP2>();
        registroP9 = new RegistroP9();

        registroP9.setTotalRegistrosP2(0);

        this.util = pafUtil;
    }

    public void limpaRegistros() {
        getRegistroP9().setTotalRegistrosP2(0);
    }

    public String writeRegistroP1() {
        return getUtil().fill("P1")
                + getUtil().lFill(getRegistroP1().getCnpj(), 14)
                + getUtil().rFill(getRegistroP1().getInscricaoEstadual(), 14)
                + getUtil().rFill(getRegistroP1().getInscricaoMunicipal(), 14)
                + getUtil().rFill(getRegistroP1().getRazaoSocial(), 50)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroP2() {
        String registro = "";
        for (int i = 0; i < listaRegistroP2.size(); i++) {
            registro += getUtil().fill("P2")
                    + getUtil().lFill(listaRegistroP2.get(i).getCnpj(), 14)
                    + getUtil().rFill(listaRegistroP2.get(i).getCodigoMercadoria(), 14)
                    + getUtil().rFill(listaRegistroP2.get(i).getDescricaoMercadoria(), 50)
                    + getUtil().rFill(listaRegistroP2.get(i).getUnidadeMedida(), 6)
                    + getUtil().rFill(listaRegistroP2.get(i).getIat(), 1)
                    + getUtil().rFill(listaRegistroP2.get(i).getIppt(), 1)
                    + getUtil().rFill(listaRegistroP2.get(i).getSituacaoTributaria(), 1)
                    + getUtil().lFill(listaRegistroP2.get(i).getAliquota(), 4)
                    + getUtil().lFill(listaRegistroP2.get(i).getValorUnitario(), 12)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroP9().setTotalRegistrosP2(getRegistroP9().getTotalRegistrosP2() + 1);
        }
        return registro;
    }

    public String writeRegistroP9() {
        return getUtil().fill("P9")
                + getUtil().lFill(getRegistroP9().getCnpj(), 14)
                + getUtil().rFill(getRegistroP9().getInscricaoEstadual(), 14)
                + getUtil().lFill(getRegistroP9().getTotalRegistrosP2(), 6)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroP1
     */
    public RegistroP1 getRegistroP1() {
        return registroP1;
    }

    /**
     * @param registroP1 the registroP1 to set
     */
    public void setRegistroP1(RegistroP1 registroP1) {
        this.registroP1 = registroP1;
    }

    /**
     * @return the listaRegistroP2
     */
    public List<RegistroP2> getListaRegistroP2() {
        return listaRegistroP2;
    }

    /**
     * @param listaRegistroP2 the listaRegistroP2 to set
     */
    public void setListaRegistroP2(List<RegistroP2> listaRegistroP2) {
        this.listaRegistroP2 = listaRegistroP2;
    }

    /**
     * @return the registroP9
     */
    public RegistroP9 getRegistroP9() {
        return registroP9;
    }

    /**
     * @param registroP9 the registroP9 to set
     */
    public void setRegistroP9(RegistroP9 registroP9) {
        this.registroP9 = registroP9;
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