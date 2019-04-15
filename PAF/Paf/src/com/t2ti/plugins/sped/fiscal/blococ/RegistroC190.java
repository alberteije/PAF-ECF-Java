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
package com.t2ti.plugins.sped.fiscal.blococ;

public class RegistroC190 {

    private String cstIcms; // Código da Situação Tributária, conforme a Tabela indicada no item 4.3.1
    private String cfop; // Código Fiscal de Operação e Prestação do agrupamento de itens
    private Double aliqIcms; // Alíquota do ICMS
    private Double vlOpr; // Valor da operação correspondente à combinação de CST_ICMS, CFOP, e alíquota do ICMS, incluídas as despesas acessórias (frete, seguros e outras despesas acessórias) e IPI
    private Double vlBcIcms; // Parcela correspondente ao "Valor da base de cálculo do ICMS" referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
    private Double vlIcms; // Parcela correspondente ao "Valor do ICMS" referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
    private Double vlBcIcmsSt; // Parcela correspondente ao "Valor da base de cálculo do ICMS" da substituição tributária referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
    private Double vlIcmsSt; // Parcela correspondente ao valor creditado/debitado do ICMS da substituição tributária, referente à combinação de CST_ICMS, CFOP, e alíquota do ICMS.
    private Double vlRedBc; // Valor não tributado em função da redução da base de cálculo do ICMS, referente à combinação de CST_ICMS, CFOP e alíquota do ICMS.
    private Double vlIpi; // Parcela correspondente ao "Valor do IPI" referente à combinação CST_ICMS, CFOP e alíquota do ICMS.
    private String codObs; // Código da observação do lançamento fiscal (campo 02 do Registro 0460

    /**
     * @return the cstIcms
     */
    public String getCstIcms() {
        return cstIcms;
    }

    /**
     * @param cstIcms the cstIcms to set
     */
    public void setCstIcms(String cstIcms) {
        this.cstIcms = cstIcms;
    }

    /**
     * @return the cfop
     */
    public String getCfop() {
        return cfop;
    }

    /**
     * @param cfop the cfop to set
     */
    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    /**
     * @return the aliqIcms
     */
    public Double getAliqIcms() {
        return aliqIcms;
    }

    /**
     * @param aliqIcms the aliqIcms to set
     */
    public void setAliqIcms(Double aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    /**
     * @return the vlOpr
     */
    public Double getVlOpr() {
        return vlOpr;
    }

    /**
     * @param vlOpr the vlOpr to set
     */
    public void setVlOpr(Double vlOpr) {
        this.vlOpr = vlOpr;
    }

    /**
     * @return the vlBcIcms
     */
    public Double getVlBcIcms() {
        return vlBcIcms;
    }

    /**
     * @param vlBcIcms the vlBcIcms to set
     */
    public void setVlBcIcms(Double vlBcIcms) {
        this.vlBcIcms = vlBcIcms;
    }

    /**
     * @return the vlIcms
     */
    public Double getVlIcms() {
        return vlIcms;
    }

    /**
     * @param vlIcms the vlIcms to set
     */
    public void setVlIcms(Double vlIcms) {
        this.vlIcms = vlIcms;
    }

    /**
     * @return the vlBcIcmsSt
     */
    public Double getVlBcIcmsSt() {
        return vlBcIcmsSt;
    }

    /**
     * @param vlBcIcmsSt the vlBcIcmsSt to set
     */
    public void setVlBcIcmsSt(Double vlBcIcmsSt) {
        this.vlBcIcmsSt = vlBcIcmsSt;
    }

    /**
     * @return the vlIcmsSt
     */
    public Double getVlIcmsSt() {
        return vlIcmsSt;
    }

    /**
     * @param vlIcmsSt the vlIcmsSt to set
     */
    public void setVlIcmsSt(Double vlIcmsSt) {
        this.vlIcmsSt = vlIcmsSt;
    }

    /**
     * @return the vlRedBc
     */
    public Double getVlRedBc() {
        return vlRedBc;
    }

    /**
     * @param vlRedBc the vlRedBc to set
     */
    public void setVlRedBc(Double vlRedBc) {
        this.vlRedBc = vlRedBc;
    }

    /**
     * @return the vlIpi
     */
    public Double getVlIpi() {
        return vlIpi;
    }

    /**
     * @param vlIpi the vlIpi to set
     */
    public void setVlIpi(Double vlIpi) {
        this.vlIpi = vlIpi;
    }

    /**
     * @return the codObs
     */
    public String getCodObs() {
        return codObs;
    }

    /**
     * @param codObs the codObs to set
     */
    public void setCodObs(String codObs) {
        this.codObs = codObs;
    }
}
