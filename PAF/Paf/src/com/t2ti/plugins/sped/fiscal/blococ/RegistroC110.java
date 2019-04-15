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

import java.util.ArrayList;
import java.util.List;

public class RegistroC110 {

    private String codInf;       /// Código da informação complementar do documento fiscal (campo 02 do Registro 0450)
    private String txtCompl;    /// Descrição complementar do código de referência.
    
    private List<RegistroC114> registroC114List; // BLOCO C - Lista de RegistroC114 (FILHO)

    public RegistroC110() {
        registroC114List = new ArrayList<RegistroC114>();
    }

    /**
     * @return the codInf
     */
    public String getCodInf() {
        return codInf;
    }

    /**
     * @param codInf the codInf to set
     */
    public void setCodInf(String codInf) {
        this.codInf = codInf;
    }

    /**
     * @return the txtCompl
     */
    public String getTxtCompl() {
        return txtCompl;
    }

    /**
     * @param txtCompl the txtCompl to set
     */
    public void setTxtCompl(String txtCompl) {
        this.txtCompl = txtCompl;
    }

    /**
     * @return the registroC114List
     */
    public List<RegistroC114> getRegistroC114List() {
        return registroC114List;
    }

    /**
     * @param registroC114List the registroC114List to set
     */
    public void setRegistroC114List(List<RegistroC114> registroC114List) {
        this.registroC114List = registroC114List;
    }
}
