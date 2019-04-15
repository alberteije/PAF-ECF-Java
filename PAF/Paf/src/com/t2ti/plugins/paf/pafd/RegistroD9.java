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

public class RegistroD9 {

    private String cnpj; // CNPJ do estabelecimento usuário do PAF-ECF
    private String inscricaoEstadual; // Inscrição Estadual do estabelecimento
    private Integer totalRegistrosD2; // Total de registros
    private Integer totalRegistrosD3; // Total de registros

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the inscricaoEstadual
     */
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * @param inscricaoEstadual the inscricaoEstadual to set
     */
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    /**
     * @return the totalRegistrosD2
     */
    public Integer getTotalRegistrosD2() {
        return totalRegistrosD2;
    }

    /**
     * @param totalRegistrosD2 the totalRegistrosD2 to set
     */
    public void setTotalRegistrosD2(Integer totalRegistrosD2) {
        this.totalRegistrosD2 = totalRegistrosD2;
    }

    /**
     * @return the totalRegistrosD3
     */
    public Integer getTotalRegistrosD3() {
        return totalRegistrosD3;
    }

    /**
     * @param totalRegistrosD3 the totalRegistrosD3 to set
     */
    public void setTotalRegistrosD3(Integer totalRegistrosD3) {
        this.totalRegistrosD3 = totalRegistrosD3;
    }
}
