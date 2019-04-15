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

public class RegistroN2 {

    private String laudoPaf; // Número do Laudo de Análise Funcional
    private String nomePaf; // Nome do aplicativo indicado no Laudo de Análise Técnica
    private String versaoPaf; // Versão atual do aplicativo indicado no Laudo de Análise Técnica

    /**
     * @return the laudoPaf
     */
    public String getLaudoPaf() {
        return laudoPaf;
    }

    /**
     * @param laudoPaf the laudoPaf to set
     */
    public void setLaudoPaf(String laudoPaf) {
        this.laudoPaf = laudoPaf;
    }

    /**
     * @return the nomePaf
     */
    public String getNomePaf() {
        return nomePaf;
    }

    /**
     * @param nomePaf the nomePaf to set
     */
    public void setNomePaf(String nomePaf) {
        this.nomePaf = nomePaf;
    }

    /**
     * @return the versaoPaf
     */
    public String getVersaoPaf() {
        return versaoPaf;
    }

    /**
     * @param versaoPaf the versaoPaf to set
     */
    public void setVersaoPaf(String versaoPaf) {
        this.versaoPaf = versaoPaf;
    }

}
