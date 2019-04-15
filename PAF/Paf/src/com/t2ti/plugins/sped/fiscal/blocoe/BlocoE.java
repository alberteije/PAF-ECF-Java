/**
 * <p>Title: T2TiPDV</p>
 *
 * <p>Description: Sped Fiscal</p>
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
package com.t2ti.plugins.sped.fiscal.blocoe;

import com.t2ti.plugins.util.SpedUtil;
import java.util.List;

public class BlocoE {

    private RegistroE001 registroE001;
    private Integer quantidadeRegistrosE100;
    private Integer quantidadeRegistrosE116;
    private RegistroE990 registroE990;
    private SpedUtil util;

    public BlocoE(SpedUtil spedUtil) {
        registroE001 = new RegistroE001();
        registroE001.setIndMov(1);

        registroE990 = new RegistroE990();

        registroE990.setQtdLinE(0);

        quantidadeRegistrosE100 = 0;
        quantidadeRegistrosE116 = 0;

        this.util = spedUtil;
    }

    public void limpaRegistros() {
        getRegistroE990().setQtdLinE(0);
    }

    public String writeRegistroE001() {
        getRegistroE990().setQtdLinE(getRegistroE990().getQtdLinE() + 1);

        String registro = "";
        registro += getUtil().fill("E001")
                + getUtil().fill(getRegistroE001().getIndMov())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();

        registro += writeRegistroE100(getRegistroE001().getRegistroE100List());
        
        return registro;
    }

    public String writeRegistroE100(List<RegistroE100> listaRegistroE100) {
        String registro = "";
        for (int i = 0; i < listaRegistroE100.size(); i++) {
            registro += getUtil().fill("E100")
                    + getUtil().fill(listaRegistroE100.get(i).getDtIni())
                    + getUtil().fill(listaRegistroE100.get(i).getDtFin())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroE110(listaRegistroE100.get(i).getRegistroE110());

            getRegistroE990().setQtdLinE(getRegistroE990().getQtdLinE() + 1);
            setQuantidadeRegistrosE100((Integer) (getQuantidadeRegistrosE100() + 1));
        }
        return registro;
    }

    public String writeRegistroE110(RegistroE110 registroE110) {
        getRegistroE990().setQtdLinE(getRegistroE990().getQtdLinE() + 1);

        String registro = "";
        registro += getUtil().fill("E110")
                + (registroE110.getVlTotDebitos())
                + (registroE110.getVlAjDebitos())
                + (registroE110.getVlTotAjDebitos())
                + (registroE110.getVlEstornosCred())
                + (registroE110.getVlTotCreditos())
                + (registroE110.getVlAjCreditos())
                + (registroE110.getVlTotAjCreditos())
                + (registroE110.getVlEstornosDeb())
                + (registroE110.getVlSldCredorAnt())
                + (registroE110.getVlSldApurado())
                + (registroE110.getVlTotDed())
                + (registroE110.getVlIcmsRecolher())
                + (registroE110.getVlSldCredorTransportar())
                + (registroE110.getDebEsp())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();

        registro += writeRegistroE116(registroE110.getRegistroE116List());

        return registro;
    }

    public String writeRegistroE116(List<RegistroE116> listaRegistroE116) {
        String registro = "";
        for (int i = 0; i < listaRegistroE116.size(); i++) {
            registro += getUtil().fill("E116")
                    + getUtil().fill(listaRegistroE116.get(i).getCodOr())
                    + getUtil().fill(listaRegistroE116.get(i).getVlOr())
                    + getUtil().fill(listaRegistroE116.get(i).getDtVcto())
                    + getUtil().fill(listaRegistroE116.get(i).getCodRec())
                    + getUtil().fill(listaRegistroE116.get(i).getNumProc())
                    + getUtil().fill(listaRegistroE116.get(i).getIndProc())
                    + getUtil().fill(listaRegistroE116.get(i).getProc())
                    + getUtil().fill(listaRegistroE116.get(i).getTxtCompl())
                    + getUtil().fill(listaRegistroE116.get(i).getMesRef())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroE990().setQtdLinE(getRegistroE990().getQtdLinE() + 1);
            setQuantidadeRegistrosE116((Integer) (getQuantidadeRegistrosE116() + 1));
        }
        return registro;
    }

    public String writeRegistroE990() {
        return getUtil().fill("E990")
                + getUtil().fill(getRegistroE990().getQtdLinE())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroE001
     */
    public RegistroE001 getRegistroE001() {
        return registroE001;
    }

    /**
     * @param registroE001 the registroE001 to set
     */
    public void setRegistroE001(RegistroE001 registroE001) {
        this.registroE001 = registroE001;
    }

    /**
     * @return the quantidadeRegistrosE100
     */
    public Integer getQuantidadeRegistrosE100() {
        return quantidadeRegistrosE100;
    }

    /**
     * @param quantidadeRegistrosE100 the quantidadeRegistrosE100 to set
     */
    public void setQuantidadeRegistrosE100(Integer quantidadeRegistrosE100) {
        this.quantidadeRegistrosE100 = quantidadeRegistrosE100;
    }

    /**
     * @return the quantidadeRegistrosE116
     */
    public Integer getQuantidadeRegistrosE116() {
        return quantidadeRegistrosE116;
    }

    /**
     * @param quantidadeRegistrosE116 the quantidadeRegistrosE116 to set
     */
    public void setQuantidadeRegistrosE116(Integer quantidadeRegistrosE116) {
        this.quantidadeRegistrosE116 = quantidadeRegistrosE116;
    }

    /**
     * @return the registroE990
     */
    public RegistroE990 getRegistroE990() {
        return registroE990;
    }

    /**
     * @param registroE990 the registroE990 to set
     */
    public void setRegistroE990(RegistroE990 registroE990) {
        this.registroE990 = registroE990;
    }

    /**
     * @return the util
     */
    public SpedUtil getUtil() {
        return util;
    }

    /**
     * @param util the util to set
     */
    public void setUtil(SpedUtil util) {
        this.util = util;
    }
}
