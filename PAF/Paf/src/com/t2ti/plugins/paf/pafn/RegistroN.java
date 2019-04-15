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
package com.t2ti.plugins.paf.pafn;

import com.t2ti.plugins.util.PafUtil;
import java.util.ArrayList;
import java.util.List;

public class RegistroN {

    private RegistroN1 registroN1;
    private RegistroN2 registroN2;
    private List<RegistroN3> listaRegistroN3;
    private RegistroN9 registroN9;

    private PafUtil util;

    public RegistroN(PafUtil pafUtil) {
        registroN1 = new RegistroN1();
        registroN2 = new RegistroN2();
        listaRegistroN3  = new ArrayList<RegistroN3>();
        registroN9 = new RegistroN9();

        registroN9.setTotalRegistrosN3(0);

        this.util = pafUtil;
    }

    public void limpaRegistros() {
        getRegistroN9().setTotalRegistrosN3(0);
    }

    public String writeRegistroN1() {
        return getUtil().fill("N1")
                + getUtil().lFill(getRegistroN1().getCnpj(), 14)
                + getUtil().rFill(getRegistroN1().getInscricaoEstadual(), 14)
                + getUtil().rFill(getRegistroN1().getInscricaoMunicipal(), 14)
                + getUtil().rFill(getRegistroN1().getRazaoSocial(), 50)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroN2() {
        return getUtil().fill("N2")
                + getUtil().rFill(getRegistroN2().getLaudoPaf(), 10)
                + getUtil().rFill(getRegistroN2().getNomePaf(), 50)
                + getUtil().rFill(getRegistroN2().getVersaoPaf(), 10)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroN3() {
        String registro = "";
        for (int i = 0; i < listaRegistroN3.size(); i++) {
            registro += getUtil().fill("N3")
                    + getUtil().lFill(listaRegistroN3.get(i).getNomeArquivo(), 50)
                    + getUtil().rFill(listaRegistroN3.get(i).getCodigoMd5(), 32)
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroN9().setTotalRegistrosN3(getRegistroN9().getTotalRegistrosN3() + 1);
        }
        return registro;
    }

    public String writeRegistroN9() {
        return getUtil().fill("N9")
                + getUtil().lFill(getRegistroN9().getCnpj(), 14)
                + getUtil().rFill(getRegistroN9().getInscricaoEstadual(), 14)
                + getUtil().lFill(getRegistroN9().getTotalRegistrosN3(), 6)
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroN1
     */
    public RegistroN1 getRegistroN1() {
        return registroN1;
    }

    /**
     * @param registroN1 the registroN1 to set
     */
    public void setRegistroN1(RegistroN1 registroN1) {
        this.registroN1 = registroN1;
    }

    /**
     * @return the registroN2
     */
    public RegistroN2 getRegistroN2() {
        return registroN2;
    }

    /**
     * @param registroN2 the registroN2 to set
     */
    public void setRegistroN2(RegistroN2 registroN2) {
        this.registroN2 = registroN2;
    }

    /**
     * @return the listaRegistroN3
     */
    public List<RegistroN3> getListaRegistroN3() {
        return listaRegistroN3;
    }

    /**
     * @param listaRegistroN3 the listaRegistroN3 to set
     */
    public void setListaRegistroN3(List<RegistroN3> listaRegistroN3) {
        this.listaRegistroN3 = listaRegistroN3;
    }

    /**
     * @return the registroN9
     */
    public RegistroN9 getRegistroN9() {
        return registroN9;
    }

    /**
     * @param registroN9 the registroN9 to set
     */
    public void setRegistroN9(RegistroN9 registroN9) {
        this.registroN9 = registroN9;
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
