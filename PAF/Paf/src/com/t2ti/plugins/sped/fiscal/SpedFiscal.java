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
package com.t2ti.plugins.sped.fiscal;

import com.t2ti.plugins.sped.fiscal.bloco0.Bloco0;
import com.t2ti.plugins.sped.fiscal.bloco9.Bloco9;
import com.t2ti.plugins.sped.fiscal.bloco9.Registro9900;
import com.t2ti.plugins.sped.fiscal.blococ.BlocoC;
import com.t2ti.plugins.sped.fiscal.blocoe.BlocoE;
import com.t2ti.plugins.sped.fiscal.blocoh.BlocoH;
import com.t2ti.plugins.util.SpedUtil;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class SpedFiscal {

    private Bloco0 bloco0;
    private BlocoC blocoC;
    private BlocoE blocoE;
    private BlocoH blocoH;
    private Bloco9 bloco9;
    private SpedUtil spedUtil;
    private List<String> linhasArquivo;

    public SpedFiscal() {
        spedUtil = new SpedUtil();
        bloco0 = new Bloco0(spedUtil);
        blocoC = new BlocoC(spedUtil);
        blocoE = new BlocoE(spedUtil);
        blocoH = new BlocoH(spedUtil);
        bloco9 = new Bloco9(spedUtil);
        linhasArquivo = new ArrayList<String>();
    }

    public void limpaRegistros() {
        bloco0.limpaRegistros();
        blocoC.limpaRegistros();
        blocoE.limpaRegistros();
        blocoH.limpaRegistros();
        bloco9.limpaRegistros();
    }

    public void geraArquivoTxt(File arquivo) throws Exception {
        getBloco9().getListaRegistro9900().clear();

        //bloco 0
        getLinhasArquivo().add(getBloco0().writeRegistro0000());
        incluiRegistro9900("0000", 1);
        getLinhasArquivo().add(getBloco0().writeRegistro0001());
        incluiRegistro9900("0001", 1);
        incluiRegistro9900("0005", 1);
        if (getBloco0().getQuantidadeRegistros0015() > 0) {
            incluiRegistro9900("0015", getBloco0().getQuantidadeRegistros0015());
        }
        incluiRegistro9900("0100", 1);
        if (getBloco0().getQuantidadeRegistros0150() > 0) {
            incluiRegistro9900("0150", getBloco0().getQuantidadeRegistros0150());
            if (getBloco0().getQuantidadeRegistros0175() > 0) {
                incluiRegistro9900("0175", getBloco0().getQuantidadeRegistros0175());
            }
        }
        if (getBloco0().getQuantidadeRegistros0190() > 0) {
            incluiRegistro9900("0190", getBloco0().getQuantidadeRegistros0190());
        }
        if (getBloco0().getQuantidadeRegistros0200() > 0) {
            incluiRegistro9900("0200", getBloco0().getQuantidadeRegistros0200());
            if (getBloco0().getQuantidadeRegistros0205() > 0) {
                incluiRegistro9900("0205", getBloco0().getQuantidadeRegistros0205());
            }
            if (getBloco0().getQuantidadeRegistros0206() > 0) {
                incluiRegistro9900("0206", getBloco0().getQuantidadeRegistros0206());
            }
            if (getBloco0().getQuantidadeRegistros0220() > 0) {
                incluiRegistro9900("0220", getBloco0().getQuantidadeRegistros0220());
            }
        }
        if (getBloco0().getQuantidadeRegistros0300() > 0) {
            incluiRegistro9900("0300", getBloco0().getQuantidadeRegistros0300());
        }
        if (getBloco0().getQuantidadeRegistros0400() > 0) {
            incluiRegistro9900("0400", getBloco0().getQuantidadeRegistros0400());
        }
        if (getBloco0().getQuantidadeRegistros0450() > 0) {
            incluiRegistro9900("0450", getBloco0().getQuantidadeRegistros0450());
        }
        if (getBloco0().getQuantidadeRegistros0460() > 0) {
            incluiRegistro9900("0460", getBloco0().getQuantidadeRegistros0460());
        }
        if (getBloco0().getQuantidadeRegistros0500() > 0) {
            incluiRegistro9900("0500", getBloco0().getQuantidadeRegistros0500());
        }
        if (getBloco0().getQuantidadeRegistros0600() > 0) {
            incluiRegistro9900("0600", getBloco0().getQuantidadeRegistros0600());
        }
        getLinhasArquivo().add(getBloco0().writeRegistro0990());
        incluiRegistro9900("0990", 1);

        //bloco C
        getLinhasArquivo().add(getBlocoC().writeRegistroC001());
        incluiRegistro9900("C001", 1);
        if (getBlocoC().getQuantidadeRegistrosC100() > 0) {
            incluiRegistro9900("C100", getBlocoC().getQuantidadeRegistrosC100());
            if (getBlocoC().getQuantidadeRegistrosC110() > 0) {
                incluiRegistro9900("C110", getBlocoC().getQuantidadeRegistrosC110());
                if (getBlocoC().getQuantidadeRegistrosC114() > 0) {
                    incluiRegistro9900("C114", getBlocoC().getQuantidadeRegistrosC114());
                }
            }
            if (getBlocoC().getQuantidadeRegistrosC190() > 0) {
                incluiRegistro9900("C190", getBlocoC().getQuantidadeRegistrosC190());
            }
        }
        if (getBlocoC().getQuantidadeRegistrosC300() > 0) {
            incluiRegistro9900("C300", getBlocoC().getQuantidadeRegistrosC300());
            if (getBlocoC().getQuantidadeRegistrosC310() > 0) {
                incluiRegistro9900("C310", getBlocoC().getQuantidadeRegistrosC310());
            }
            if (getBlocoC().getQuantidadeRegistrosC320() > 0) {
                incluiRegistro9900("C320", getBlocoC().getQuantidadeRegistrosC320());
                if (getBlocoC().getQuantidadeRegistrosC321() > 0) {
                    incluiRegistro9900("C321", getBlocoC().getQuantidadeRegistrosC321());
                }
            }
        }
        if (getBlocoC().getQuantidadeRegistrosC350() > 0) {
            incluiRegistro9900("C350", getBlocoC().getQuantidadeRegistrosC350());
            if (getBlocoC().getQuantidadeRegistrosC370() > 0) {
                incluiRegistro9900("C370", getBlocoC().getQuantidadeRegistrosC370());
            }
            if (getBlocoC().getQuantidadeRegistrosC390() > 0) {
                incluiRegistro9900("C390", getBlocoC().getQuantidadeRegistrosC390());
            }
        }
        if (getBlocoC().getQuantidadeRegistrosC400() > 0) {
            incluiRegistro9900("C400", getBlocoC().getQuantidadeRegistrosC400());
            if (getBlocoC().getQuantidadeRegistrosC405() > 0) {
                incluiRegistro9900("C405", getBlocoC().getQuantidadeRegistrosC405());
                if (getBlocoC().getQuantidadeRegistrosC420() > 0) {
                    incluiRegistro9900("C420", getBlocoC().getQuantidadeRegistrosC420());
                    if (getBlocoC().getQuantidadeRegistrosC425() > 0) {
                        incluiRegistro9900("C425", getBlocoC().getQuantidadeRegistrosC425());
                    }
                }
                if (getBlocoC().getQuantidadeRegistrosC460() > 0) {
                    incluiRegistro9900("C460", getBlocoC().getQuantidadeRegistrosC460());
                    if (getBlocoC().getQuantidadeRegistrosC470() > 0) {
                        incluiRegistro9900("C470", getBlocoC().getQuantidadeRegistrosC470());
                    }
                }
                if (getBlocoC().getQuantidadeRegistrosC490() > 0) {
                    incluiRegistro9900("C490", getBlocoC().getQuantidadeRegistrosC490());
                }
            }
        }
        getLinhasArquivo().add(getBlocoC().writeRegistroC990());
        incluiRegistro9900("C990", 1);

        //bloco E
        getLinhasArquivo().add(getBlocoE().writeRegistroE001());
        incluiRegistro9900("E001", 1);
        if (getBlocoE().getQuantidadeRegistrosE100() > 0) {
            incluiRegistro9900("E100", getBlocoE().getQuantidadeRegistrosE100());
            incluiRegistro9900("E110", 1);
            if (getBlocoE().getQuantidadeRegistrosE116() > 0) {
                incluiRegistro9900("E116", getBlocoE().getQuantidadeRegistrosE116());
            }
        }
        getLinhasArquivo().add(getBlocoE().writeRegistroE990());
        incluiRegistro9900("E900", 1);

        //bloco H
        getLinhasArquivo().add(getBlocoH().writeRegistroH001());
        incluiRegistro9900("H001", 1);
        getLinhasArquivo().add(getBlocoH().writeRegistroH990());
        incluiRegistro9900("H900", 1);

        //bloco 9
        getLinhasArquivo().add(getBloco9().writeRegistro9001());
        incluiRegistro9900("9001", 1);

        incluiRegistro9900("9900", getBloco9().getListaRegistro9900().size() + 2);
        incluiRegistro9900("9990", 1);
        incluiRegistro9900("9999", 1);
        getLinhasArquivo().add(getBloco9().writeRegistro9900());
        getLinhasArquivo().add(getBloco9().writeRegistro9990());

        getBloco9().getRegistro9999().setQtdLin(
                getBloco0().getRegistro0990().getQtdLin0()
                + getBlocoC().getRegistroC990().getQtdLinC()
                + getBlocoE().getRegistroE990().getQtdLinE()
                + getBlocoH().getRegistroH990().getQtdLinH()
                + getBloco9().getRegistro9990().getQtdLin9());
        getLinhasArquivo().add(getBloco9().writeRegistro9999());

        FileUtils.writeLines(arquivo, getLinhasArquivo(), "");
    }

    private void incluiRegistro9900(String registro, Integer quantidade) {
        Registro9900 registro9900 = new Registro9900();
        registro9900.setRegBlc(registro);
        registro9900.setQtdRegBlc(quantidade);

        getBloco9().getListaRegistro9900().add(registro9900);
    }

    public String getDelimitador() {
        return getSpedUtil().getDelimitador();
    }

    public void setDelimitador(String delimitador) {
        getSpedUtil().setDelimitador(delimitador);
    }

    public DecimalFormat getFormatoDecimal() {
        return getSpedUtil().getFormatoDecimal();
    }

    public void setFormatoDecimal(DecimalFormat formatoDecimal) {
        getSpedUtil().setFormatoDecimal(formatoDecimal);
    }

    public SimpleDateFormat getFormatoData() {
        return getSpedUtil().getFormatoData();
    }

    public void setFormatoData(SimpleDateFormat formatoData) {
        getSpedUtil().setFormatoData(formatoData);
    }

    /**
     * @return the bloco9
     */
    public Bloco9 getBloco9() {
        return bloco9;
    }

    /**
     * @return the bloco0
     */
    public Bloco0 getBloco0() {
        return bloco0;
    }

    /**
     * @param bloco0 the bloco0 to set
     */
    public void setBloco0(Bloco0 bloco0) {
        this.bloco0 = bloco0;
    }

    /**
     * @return the blocoC
     */
    public BlocoC getBlocoC() {
        return blocoC;
    }

    /**
     * @param blocoC the blocoC to set
     */
    public void setBlocoC(BlocoC blocoC) {
        this.blocoC = blocoC;
    }

    /**
     * @return the blocoE
     */
    public BlocoE getBlocoE() {
        return blocoE;
    }

    /**
     * @param blocoE the blocoE to set
     */
    public void setBlocoE(BlocoE blocoE) {
        this.blocoE = blocoE;
    }

    /**
     * @return the blocoH
     */
    public BlocoH getBlocoH() {
        return blocoH;
    }

    /**
     * @param blocoH the blocoH to set
     */
    public void setBlocoH(BlocoH blocoH) {
        this.blocoH = blocoH;
    }

    /**
     * @param bloco9 the bloco9 to set
     */
    public void setBloco9(Bloco9 bloco9) {
        this.bloco9 = bloco9;
    }

    /**
     * @return the spedUtil
     */
    public SpedUtil getSpedUtil() {
        return spedUtil;
    }

    /**
     * @param spedUtil the spedUtil to set
     */
    public void setSpedUtil(SpedUtil spedUtil) {
        this.spedUtil = spedUtil;
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
