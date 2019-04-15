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
package com.t2ti.plugins.sped.fiscal.blocoh;

import com.t2ti.plugins.sped.fiscal.blococ.*;
import com.t2ti.plugins.util.SpedUtil;
import java.util.ArrayList;
import java.util.List;

public class BlocoH {

    private RegistroH001 registroH001;
    private RegistroH990 registroH990;
    private SpedUtil util;

    public BlocoH(SpedUtil spedUtil) {
        registroH001 = new RegistroH001();
        registroH001.setIndMov(0);

        registroH990 = new RegistroH990();

        registroH990.setQtdLinH(0);

        this.util = spedUtil;
    }

    public void limpaRegistros() {
        getRegistroH990().setQtdLinH(0);
    }

    public String writeRegistroH001() {
        getRegistroH990().setQtdLinH(getRegistroH990().getQtdLinH() + 1);

        return getUtil().fill("H001")
                + getUtil().fill(getRegistroH001().getIndMov())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistroH990() {
        return getUtil().fill("H990")
                + getUtil().fill(getRegistroH990().getQtdLinH())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroH001
     */
    public RegistroH001 getRegistroH001() {
        return registroH001;
    }

    /**
     * @param registroH001 the registroH001 to set
     */
    public void setRegistroH001(RegistroH001 registroH001) {
        this.registroH001 = registroH001;
    }

    /**
     * @return the registroH990
     */
    public RegistroH990 getRegistroH990() {
        return registroH990;
    }

    /**
     * @param registroH990 the registroH990 to set
     */
    public void setRegistroH990(RegistroH990 registroH990) {
        this.registroH990 = registroH990;
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
