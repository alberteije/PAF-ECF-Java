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
package com.t2ti.plugins.sped.fiscal.bloco0;

import com.t2ti.plugins.util.SpedUtil;
import java.util.List;

public class Bloco0 {

    private Registro0000 registro0000;
    private Registro0001 registro0001;
    private Registro0990 registro0990;
    private Integer quantidadeRegistros0015;
    private Integer quantidadeRegistros0150;
    private Integer quantidadeRegistros0175;
    private Integer quantidadeRegistros0190;
    private Integer quantidadeRegistros0200;
    private Integer quantidadeRegistros0205;
    private Integer quantidadeRegistros0206;
    private Integer quantidadeRegistros0220;
    private Integer quantidadeRegistros0300;
    private Integer quantidadeRegistros0400;
    private Integer quantidadeRegistros0450;
    private Integer quantidadeRegistros0460;
    private Integer quantidadeRegistros0500;
    private Integer quantidadeRegistros0600;
    private SpedUtil util;

    public Bloco0(SpedUtil spedUtil) {
        registro0000 = new Registro0000();
        registro0001 = new Registro0001();
        registro0001.setIndMov(1);

        registro0990 = new Registro0990();

        registro0990.setQtdLin0(0);

        quantidadeRegistros0015 = 0;
        quantidadeRegistros0150 = 0;
        quantidadeRegistros0175 = 0;
        quantidadeRegistros0190 = 0;
        quantidadeRegistros0200 = 0;
        quantidadeRegistros0205 = 0;
        quantidadeRegistros0206 = 0;
        quantidadeRegistros0220 = 0;
        quantidadeRegistros0300 = 0;
        quantidadeRegistros0400 = 0;
        quantidadeRegistros0450 = 0;
        quantidadeRegistros0460 = 0;
        quantidadeRegistros0500 = 0;
        quantidadeRegistros0600 = 0;

        this.util = spedUtil;
    }

    public void limpaRegistros() {
        getRegistro0990().setQtdLin0(0);
    }

    public String writeRegistro0000() {
        getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);

        return getUtil().fill("0000")
                + getUtil().fill(getRegistro0000().getCodVer())
                + getUtil().fill(getRegistro0000().getCodFin())
                + getUtil().fill(getRegistro0000().getDtIni())
                + getUtil().fill(getRegistro0000().getDtFin())
                + getUtil().fill(getRegistro0000().getNome())
                + getUtil().fill(getRegistro0000().getCnpj())
                + getUtil().fill(getRegistro0000().getCpf())
                + getUtil().fill(getRegistro0000().getUf())
                + getUtil().fill(getRegistro0000().getIe())
                + getUtil().fill(getRegistro0000().getCodMun())
                + getUtil().fill(getRegistro0000().getIm())
                + getUtil().fill(getRegistro0000().getSuframa())
                + getUtil().fill(getRegistro0000().getIndPerfil())
                + getUtil().fill(getRegistro0000().getIndAtiv())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistro0001() {
        getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);

        String registro = "";
        registro += getUtil().fill("0001")
                + getUtil().fill(getRegistro0001().getIndMov())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();

        registro += writeRegistro0005(getRegistro0001().getRegistro0005());
        registro += writeRegistro0015(getRegistro0001().getRegistro0015List());
        registro += writeRegistro0100(getRegistro0001().getRegistro0100());
        registro += writeRegistro0150(getRegistro0001().getRegistro0150List());
        registro += writeRegistro0190(getRegistro0001().getRegistro0190List());
        registro += writeRegistro0200(getRegistro0001().getRegistro0200List());
        registro += writeRegistro0300(getRegistro0001().getRegistro0300List());
        registro += writeRegistro0400(getRegistro0001().getRegistro0400List());
        registro += writeRegistro0450(getRegistro0001().getRegistro0450List());
        registro += writeRegistro0460(getRegistro0001().getRegistro0460List());
        registro += writeRegistro0500(getRegistro0001().getRegistro0500List());
        registro += writeRegistro0600(getRegistro0001().getRegistro0600List());

        return registro;
    }

    public String writeRegistro0005(Registro0005 registro0005) {
        getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);

        return getUtil().fill("0005")
                + getUtil().fill(registro0005.getFantasia())
                + getUtil().fill(registro0005.getCep())
                + getUtil().fill(registro0005.getEndereco())
                + getUtil().fill(registro0005.getNum())
                + getUtil().fill(registro0005.getCompl())
                + getUtil().fill(registro0005.getBairro())
                + getUtil().fill(registro0005.getFone())
                + getUtil().fill(registro0005.getFax())
                + getUtil().fill(registro0005.getEmail())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistro0015(List<Registro0015> listaRegistro0015) {
        String registro = "";
        for (int i = 0; i < listaRegistro0015.size(); i++) {
            registro += getUtil().fill("0015")
                    + getUtil().fill(listaRegistro0015.get(i).getUfSt())
                    + getUtil().fill(listaRegistro0015.get(i).getIeSt())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0015((Integer) (getQuantidadeRegistros0015() + 1));
        }
        return registro;
    }

    public String writeRegistro0100(Registro0100 registro0100) {
        getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);

        return getUtil().fill("0100")
                + getUtil().fill(registro0100.getNome())
                + getUtil().fill(registro0100.getCpf())
                + getUtil().fill(registro0100.getCrc())
                + getUtil().fill(registro0100.getCnpj())
                + getUtil().fill(registro0100.getCep())
                + getUtil().fill(registro0100.getEndereco())
                + getUtil().fill(registro0100.getNum())
                + getUtil().fill(registro0100.getCompl())
                + getUtil().fill(registro0100.getBairro())
                + getUtil().fill(registro0100.getFone())
                + getUtil().fill(registro0100.getFax())
                + getUtil().fill(registro0100.getEmail())
                + getUtil().fill(registro0100.getCodMun())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistro0150(List<Registro0150> listaRegistro0150) {
        String registro = "";
        for (int i = 0; i < listaRegistro0150.size(); i++) {
            registro += getUtil().fill("0150")
                    + getUtil().fill(listaRegistro0150.get(i).getCodPart())
                    + getUtil().fill(listaRegistro0150.get(i).getNome())
                    + getUtil().fill(listaRegistro0150.get(i).getCodPais())
                    + getUtil().fill(listaRegistro0150.get(i).getCnpj())
                    + getUtil().fill(listaRegistro0150.get(i).getCpf())
                    + getUtil().fill(listaRegistro0150.get(i).getIe())
                    + getUtil().fill(listaRegistro0150.get(i).getCodMun())
                    + getUtil().fill(listaRegistro0150.get(i).getSuframa())
                    + getUtil().fill(listaRegistro0150.get(i).getEndereco())
                    + getUtil().fill(listaRegistro0150.get(i).getNum())
                    + getUtil().fill(listaRegistro0150.get(i).getCompl())
                    + getUtil().fill(listaRegistro0150.get(i).getBairro())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistro0175(listaRegistro0150.get(i).getRegistro0175List());

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0150((Integer) (getQuantidadeRegistros0150() + 1));
        }
        return registro;
    }

    public String writeRegistro0175(List<Registro0175> listaRegistro0175) {
        String registro = "";
        for (int i = 0; i < listaRegistro0175.size(); i++) {
            registro += getUtil().fill("0175")
                    + getUtil().fill(listaRegistro0175.get(i).getDtAlt())
                    + getUtil().fill(listaRegistro0175.get(i).getNrCampo())
                    + getUtil().fill(listaRegistro0175.get(i).getContAnt())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0175((Integer) (getQuantidadeRegistros0175() + 1));
        }
        return registro;
    }

    public String writeRegistro0190(List<Registro0190> listaRegistro0190) {
        String registro = "";
        for (int i = 0; i < listaRegistro0190.size(); i++) {
            registro += getUtil().fill("0190")
                    + getUtil().fill(listaRegistro0190.get(i).getUnid())
                    + getUtil().fill(listaRegistro0190.get(i).getDescr())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0190((Integer) (getQuantidadeRegistros0190() + 1));
        }
        return registro;
    }

    public String writeRegistro0200(List<Registro0200> listaRegistro0200) {
        String registro = "";
        for (int i = 0; i < listaRegistro0200.size(); i++) {
            registro += getUtil().fill("0200")
                    + getUtil().fill(listaRegistro0200.get(i).getCodItem())
                    + getUtil().fill(listaRegistro0200.get(i).getDescrItem())
                    + getUtil().fill(listaRegistro0200.get(i).getCodBarra())
                    + getUtil().fill(listaRegistro0200.get(i).getCodAntItem())
                    + getUtil().fill(listaRegistro0200.get(i).getUnidInv())
                    + getUtil().fill(listaRegistro0200.get(i).getTipoItem())
                    + getUtil().fill(listaRegistro0200.get(i).getCodNcm())
                    + getUtil().fill(listaRegistro0200.get(i).getExIpi())
                    + getUtil().fill(listaRegistro0200.get(i).getCodGen())
                    + getUtil().fill(listaRegistro0200.get(i).getCodLst())
                    + getUtil().fill(listaRegistro0200.get(i).getAliqIcms())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistro0205(listaRegistro0200.get(i).getRegistro0205List());
            registro += writeRegistro0206(listaRegistro0200.get(i).getRegistro0206List());
            registro += writeRegistro0220(listaRegistro0200.get(i).getRegistro0220List());

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0200((Integer) (getQuantidadeRegistros0200() + 1));
        }
        return registro;
    }

    public String writeRegistro0205(List<Registro0205> listaRegistro0205) {
        String registro = "";
        for (int i = 0; i < listaRegistro0205.size(); i++) {
            registro += getUtil().fill("0205")
                    + getUtil().fill(listaRegistro0205.get(i).getDescrAntItem())
                    + getUtil().fill(listaRegistro0205.get(i).getDtIni())
                    + getUtil().fill(listaRegistro0205.get(i).getDtFin())
                    + getUtil().fill(listaRegistro0205.get(i).getCodAntItem())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0205((Integer) (getQuantidadeRegistros0205() + 1));
        }
        return registro;
    }

    public String writeRegistro0206(List<Registro0206> listaRegistro0206) {
        String registro = "";
        for (int i = 0; i < listaRegistro0206.size(); i++) {
            registro += getUtil().fill("0206")
                    + getUtil().fill(listaRegistro0206.get(i).getCodComb())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0206((Integer) (getQuantidadeRegistros0206() + 1));
        }
        return registro;
    }

    public String writeRegistro0220(List<Registro0220> listaRegistro0220) {
        String registro = "";
        for (int i = 0; i < listaRegistro0220.size(); i++) {
            registro += getUtil().fill("0220")
                    + getUtil().fill(listaRegistro0220.get(i).getUnidConv())
                    + getUtil().fill(listaRegistro0220.get(i).getFatConv())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0220((Integer) (getQuantidadeRegistros0220() + 1));
        }
        return registro;
    }

    public String writeRegistro0300(List<Registro0300> listaRegistro0300) {
        String registro = "";
        for (int i = 0; i < listaRegistro0300.size(); i++) {
            registro += getUtil().fill("0300")
                    + getUtil().fill(listaRegistro0300.get(i).getCodIndBem())
                    + getUtil().fill(listaRegistro0300.get(i).getIdentMerc())
                    + getUtil().fill(listaRegistro0300.get(i).getDescrItem())
                    + getUtil().fill(listaRegistro0300.get(i).getCodPrnc())
                    + getUtil().fill(listaRegistro0300.get(i).getCodCta())
                    + getUtil().fill(listaRegistro0300.get(i).getNrParc())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistro0305(listaRegistro0300.get(i).getRegistro0305());

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0300((Integer) (getQuantidadeRegistros0300() + 1));
        }
        return registro;
    }

    public String writeRegistro0305(Registro0305 registro0305) {
        getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);

        return getUtil().fill("0305")
                + getUtil().fill(registro0305.getCodCcus())
                + getUtil().fill(registro0305.getFunc())
                + getUtil().fill(registro0305.getVidaUtil())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    public String writeRegistro0400(List<Registro0400> listaRegistro0400) {
        String registro = "";
        for (int i = 0; i < listaRegistro0400.size(); i++) {
            registro += getUtil().fill("0400")
                    + getUtil().fill(listaRegistro0400.get(i).getCodNat())
                    + getUtil().fill(listaRegistro0400.get(i).getDescrNat())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0400((Integer) (getQuantidadeRegistros0400() + 1));
        }
        return registro;
    }

    public String writeRegistro0450(List<Registro0450> listaRegistro0450) {
        String registro = "";
        for (int i = 0; i < listaRegistro0450.size(); i++) {
            registro += getUtil().fill("0450")
                    + getUtil().fill(listaRegistro0450.get(i).getCodInf())
                    + getUtil().fill(listaRegistro0450.get(i).getTxt())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0450((Integer) (getQuantidadeRegistros0450() + 1));
        }
        return registro;
    }

    public String writeRegistro0460(List<Registro0460> listaRegistro0460) {
        String registro = "";
        for (int i = 0; i < listaRegistro0460.size(); i++) {
            registro += getUtil().fill("0460")
                    + getUtil().fill(listaRegistro0460.get(i).getCodObs())
                    + getUtil().fill(listaRegistro0460.get(i).getTxt())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0460((Integer) (getQuantidadeRegistros0460() + 1));
        }
        return registro;
    }

    public String writeRegistro0500(List<Registro0500> listaRegistro0500) {
        String registro = "";
        for (int i = 0; i < listaRegistro0500.size(); i++) {
            registro += getUtil().fill("0500")
                    + getUtil().fill(listaRegistro0500.get(i).getDtAlt())
                    + getUtil().fill(listaRegistro0500.get(i).getCodNatCc())
                    + getUtil().fill(listaRegistro0500.get(i).getIndCta())
                    + getUtil().fill(listaRegistro0500.get(i).getNivel())
                    + getUtil().fill(listaRegistro0500.get(i).getCodCta())
                    + getUtil().fill(listaRegistro0500.get(i).getNomeCta())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
            
            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0500((Integer) (getQuantidadeRegistros0500() + 1));
        }
        return registro;
    }

    public String writeRegistro0600(List<Registro0600> listaRegistro0600) {
        String registro = "";
        for (int i = 0; i < listaRegistro0600.size(); i++) {
            registro += getUtil().fill("0600")
                    + getUtil().fill(listaRegistro0600.get(i).getDtAlt())
                    + getUtil().fill(listaRegistro0600.get(i).getCodCcus())
                    + getUtil().fill(listaRegistro0600.get(i).getCcus())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();
            
            getRegistro0990().setQtdLin0(getRegistro0990().getQtdLin0() + 1);
            setQuantidadeRegistros0600((Integer) (getQuantidadeRegistros0600() + 1));
        }
        return registro;
    }

    public String writeRegistro0990() {
        return getUtil().fill("0990")
                + getUtil().fill(getRegistro0990().getQtdLin0())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registro0000
     */
    public Registro0000 getRegistro0000() {
        return registro0000;
    }

    /**
     * @param registro0000 the registro0000 to set
     */
    public void setRegistro0000(Registro0000 registro0000) {
        this.registro0000 = registro0000;
    }

    /**
     * @return the registro0001
     */
    public Registro0001 getRegistro0001() {
        return registro0001;
    }

    /**
     * @param registro0001 the registro0001 to set
     */
    public void setRegistro0001(Registro0001 registro0001) {
        this.registro0001 = registro0001;
    }

    /**
     * @return the registro0990
     */
    public Registro0990 getRegistro0990() {
        return registro0990;
    }

    /**
     * @param registro0990 the registro0990 to set
     */
    public void setRegistro0990(Registro0990 registro0990) {
        this.registro0990 = registro0990;
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

    /**
     * @return the quantidadeRegistros0015
     */
    public Integer getQuantidadeRegistros0015() {
        return quantidadeRegistros0015;
    }

    /**
     * @param quantidadeRegistros0015 the quantidadeRegistros0015 to set
     */
    public void setQuantidadeRegistros0015(Integer quantidadeRegistros0015) {
        this.quantidadeRegistros0015 = quantidadeRegistros0015;
    }

    /**
     * @return the quantidadeRegistros0150
     */
    public Integer getQuantidadeRegistros0150() {
        return quantidadeRegistros0150;
    }

    /**
     * @param quantidadeRegistros0150 the quantidadeRegistros0150 to set
     */
    public void setQuantidadeRegistros0150(Integer quantidadeRegistros0150) {
        this.quantidadeRegistros0150 = quantidadeRegistros0150;
    }

    /**
     * @return the quantidadeRegistros0175
     */
    public Integer getQuantidadeRegistros0175() {
        return quantidadeRegistros0175;
    }

    /**
     * @param quantidadeRegistros0175 the quantidadeRegistros0175 to set
     */
    public void setQuantidadeRegistros0175(Integer quantidadeRegistros0175) {
        this.quantidadeRegistros0175 = quantidadeRegistros0175;
    }

    /**
     * @return the quantidadeRegistros0190
     */
    public Integer getQuantidadeRegistros0190() {
        return quantidadeRegistros0190;
    }

    /**
     * @param quantidadeRegistros0190 the quantidadeRegistros0190 to set
     */
    public void setQuantidadeRegistros0190(Integer quantidadeRegistros0190) {
        this.quantidadeRegistros0190 = quantidadeRegistros0190;
    }

    /**
     * @return the quantidadeRegistros0200
     */
    public Integer getQuantidadeRegistros0200() {
        return quantidadeRegistros0200;
    }

    /**
     * @param quantidadeRegistros0200 the quantidadeRegistros0200 to set
     */
    public void setQuantidadeRegistros0200(Integer quantidadeRegistros0200) {
        this.quantidadeRegistros0200 = quantidadeRegistros0200;
    }

    /**
     * @return the quantidadeRegistros0205
     */
    public Integer getQuantidadeRegistros0205() {
        return quantidadeRegistros0205;
    }

    /**
     * @param quantidadeRegistros0205 the quantidadeRegistros0205 to set
     */
    public void setQuantidadeRegistros0205(Integer quantidadeRegistros0205) {
        this.quantidadeRegistros0205 = quantidadeRegistros0205;
    }

    /**
     * @return the quantidadeRegistros0206
     */
    public Integer getQuantidadeRegistros0206() {
        return quantidadeRegistros0206;
    }

    /**
     * @param quantidadeRegistros0206 the quantidadeRegistros0206 to set
     */
    public void setQuantidadeRegistros0206(Integer quantidadeRegistros0206) {
        this.quantidadeRegistros0206 = quantidadeRegistros0206;
    }

    /**
     * @return the quantidadeRegistros0220
     */
    public Integer getQuantidadeRegistros0220() {
        return quantidadeRegistros0220;
    }

    /**
     * @param quantidadeRegistros0220 the quantidadeRegistros0220 to set
     */
    public void setQuantidadeRegistros0220(Integer quantidadeRegistros0220) {
        this.quantidadeRegistros0220 = quantidadeRegistros0220;
    }

    /**
     * @return the quantidadeRegistros0300
     */
    public Integer getQuantidadeRegistros0300() {
        return quantidadeRegistros0300;
    }

    /**
     * @param quantidadeRegistros0300 the quantidadeRegistros0300 to set
     */
    public void setQuantidadeRegistros0300(Integer quantidadeRegistros0300) {
        this.quantidadeRegistros0300 = quantidadeRegistros0300;
    }

    /**
     * @return the quantidadeRegistros0400
     */
    public Integer getQuantidadeRegistros0400() {
        return quantidadeRegistros0400;
    }

    /**
     * @param quantidadeRegistros0400 the quantidadeRegistros0400 to set
     */
    public void setQuantidadeRegistros0400(Integer quantidadeRegistros0400) {
        this.quantidadeRegistros0400 = quantidadeRegistros0400;
    }

    /**
     * @return the quantidadeRegistros0450
     */
    public Integer getQuantidadeRegistros0450() {
        return quantidadeRegistros0450;
    }

    /**
     * @param quantidadeRegistros0450 the quantidadeRegistros0450 to set
     */
    public void setQuantidadeRegistros0450(Integer quantidadeRegistros0450) {
        this.quantidadeRegistros0450 = quantidadeRegistros0450;
    }

    /**
     * @return the quantidadeRegistros0460
     */
    public Integer getQuantidadeRegistros0460() {
        return quantidadeRegistros0460;
    }

    /**
     * @param quantidadeRegistros0460 the quantidadeRegistros0460 to set
     */
    public void setQuantidadeRegistros0460(Integer quantidadeRegistros0460) {
        this.quantidadeRegistros0460 = quantidadeRegistros0460;
    }

    /**
     * @return the quantidadeRegistros0500
     */
    public Integer getQuantidadeRegistros0500() {
        return quantidadeRegistros0500;
    }

    /**
     * @param quantidadeRegistros0500 the quantidadeRegistros0500 to set
     */
    public void setQuantidadeRegistros0500(Integer quantidadeRegistros0500) {
        this.quantidadeRegistros0500 = quantidadeRegistros0500;
    }

    /**
     * @return the quantidadeRegistros0600
     */
    public Integer getQuantidadeRegistros0600() {
        return quantidadeRegistros0600;
    }

    /**
     * @param quantidadeRegistros0600 the quantidadeRegistros0600 to set
     */
    public void setQuantidadeRegistros0600(Integer quantidadeRegistros0600) {
        this.quantidadeRegistros0600 = quantidadeRegistros0600;
    }
}
