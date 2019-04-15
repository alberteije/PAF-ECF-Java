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
package com.t2ti.plugins.paf;

import com.t2ti.plugins.paf.pafn.RegistroN;
import com.t2ti.plugins.util.PafUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class PafN {

    private RegistroN registroN;
    private PafUtil pafUtil;
    private List<String> linhasArquivo;

    public PafN() {
        pafUtil = new PafUtil();
        registroN = new RegistroN(pafUtil);
        linhasArquivo = new ArrayList<String>();
    }

    public void limpaRegistros() {
        getRegistroN().limpaRegistros();
    }

    public void geraArquivoTxt(File arquivo) throws Exception {

        getLinhasArquivo().add(getRegistroN().writeRegistroN1());
        getLinhasArquivo().add(getRegistroN().writeRegistroN2());
        getLinhasArquivo().add(getRegistroN().writeRegistroN3());
        getLinhasArquivo().add(getRegistroN().writeRegistroN9());

        FileUtils.writeLines(arquivo, getLinhasArquivo(), "");
    }

    /**
     * @return the registroN
     */
    public RegistroN getRegistroN() {
        return registroN;
    }

    /**
     * @param registroN the registroN to set
     */
    public void setRegistroN(RegistroN registroN) {
        this.registroN = registroN;
    }

    /**
     * @return the pafUtil
     */
    public PafUtil getPafUtil() {
        return pafUtil;
    }

    /**
     * @param pafUtil the pafUtil to set
     */
    public void setPafUtil(PafUtil pafUtil) {
        this.pafUtil = pafUtil;
    }

    /**
     * @return the linhasArquivo
     */
    public List<String> getLinhasArquivo() {
        return linhasArquivo;
    }

    /**
     * @param linhasArquivo the linhasArquivo to set
     */
    public void setLinhasArquivo(List<String> linhasArquivo) {
        this.linhasArquivo = linhasArquivo;
    }
}
