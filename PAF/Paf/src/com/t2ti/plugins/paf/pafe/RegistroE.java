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
package com.t2ti.plugins.paf.pafe;

import com.t2ti.plugins.paf.pafd.*;
import com.t2ti.plugins.util.PafUtil;
import java.util.ArrayList;
import java.util.List;

public class RegistroE {

    private RegistroE1 registroE1;
    private List<RegistroE2> listaRegistroE2;
    private RegistroE9 registroE9;

    private PafUtil util;

    public RegistroE(PafUtil pafUtil) {
        registroE1 = new RegistroE1();
        listaRegistroE2  = new ArrayList<RegistroE2>();
        registroE9 = new RegistroE9();

        registroE9.setTotalRegistrosE2(0);

        this.util = pafUtil;
    }

    public void limpaRegistros() {
        getRegistroE9().setTotalRegistrosE2(0);
    }

    public String writeRegistroE1() {
        return getUtil().fill("E1")
                + getUtil().lFill(getRegistroE1().getCnpj(), 14)
                + getUtil().rFill(getRegistroE1().getInscricaoEstadual(), 14)
                + getUtil().rFill(getRegistroE1().getInscricaoMunicipal(), 14)
                + getUtil().rFill(getRegistroE1().getRazaoSocial(), 50)
                + getUtil().rFill(getRegistroE1().getNumeroFabricacao(), 20)
                + getUtil().rFill(getRegistroE1().getMfAdicional(), 1)
                + getUtil().rFill(getRegistroE1().getTipoEcf(), 7)
                + getUtil().rFill(getRegistroE1().getMarcaEcf(), 20)
                + getUtil().rFill(getRegistroE1().getModeloEcf(), 20)
                + getUtil().fill(getRegistroE1().getDataEstoque())
                + getUtil().fill(getRegistroE1().getHoraEstoque())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroE2() {
        String registro = "";
        for (int i = 0; i < listaRegistroE2.size(); i++) {
            registro += getUtil().fill("E2")
                    + getUtil().lFill(listaRegistroE2.get(i).getCnpj(), 14)
                    + getUtil().rFill(listaRegistroE2.get(i).getCodigoMercadoria(), 14)
                    + getUtil().rFill(listaRegistroE2.get(i).getDescricaoMercadoria(), 50)
                    + getUtil().rFill(listaRegistroE2.get(i).getUnidadeMedida(), 6)
                    + getUtil().fill(listaRegistroE2.get(i).getQuantidadeEstoque() < 0 ? "-" : "+")
                    + getUtil().lFill(listaRegistroE2.get(i).getQuantidadeEstoque(), 9)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroE9().setTotalRegistrosE2(getRegistroE9().getTotalRegistrosE2() + 1);
        }
        return registro;
    }

    public String writeRegistroE9() {
        return getUtil().fill("E9")
                + getUtil().lFill(getRegistroE9().getCnpj(), 14)
                + getUtil().rFill(getRegistroE9().getInscricaoEstadual(), 14)
                + getUtil().lFill(getRegistroE9().getTotalRegistrosE2(), 6)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroE1
     */
    public RegistroE1 getRegistroE1() {
        return registroE1;
    }

    /**
     * @param registroE1 the registroE1 to set
     */
    public void setRegistroE1(RegistroE1 registroE1) {
        this.registroE1 = registroE1;
    }

    /**
     * @return the listaRegistroE2
     */
    public List<RegistroE2> getListaRegistroE2() {
        return listaRegistroE2;
    }

    /**
     * @param listaRegistroE2 the listaRegistroE2 to set
     */
    public void setListaRegistroE2(List<RegistroE2> listaRegistroE2) {
        this.listaRegistroE2 = listaRegistroE2;
    }

    /**
     * @return the registroE9
     */
    public RegistroE9 getRegistroE9() {
        return registroE9;
    }

    /**
     * @param registroE9 the registroE9 to set
     */
    public void setRegistroE9(RegistroE9 registroE9) {
        this.registroE9 = registroE9;
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
