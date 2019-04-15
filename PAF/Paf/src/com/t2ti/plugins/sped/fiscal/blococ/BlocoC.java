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

import com.t2ti.plugins.util.SpedUtil;
import java.util.List;

public class BlocoC {

    private RegistroC001 registroC001;
    private Integer quantidadeRegistrosC100;
    private Integer quantidadeRegistrosC110;
    private Integer quantidadeRegistrosC114;
    private Integer quantidadeRegistrosC190;
    private Integer quantidadeRegistrosC300;
    private Integer quantidadeRegistrosC310;
    private Integer quantidadeRegistrosC320;
    private Integer quantidadeRegistrosC321;
    private Integer quantidadeRegistrosC350;
    private Integer quantidadeRegistrosC370;
    private Integer quantidadeRegistrosC390;
    private Integer quantidadeRegistrosC400;
    private Integer quantidadeRegistrosC405;
    private Integer quantidadeRegistrosC420;
    private Integer quantidadeRegistrosC425;
    private Integer quantidadeRegistrosC460;
    private Integer quantidadeRegistrosC470;
    private Integer quantidadeRegistrosC490;
    private RegistroC990 registroC990;
    private SpedUtil util;

    public BlocoC(SpedUtil spedUtil) {
        registroC001 = new RegistroC001();
        registroC001.setIndMov(1);

        registroC990 = new RegistroC990();

        registroC990.setQtdLinC(0);

        quantidadeRegistrosC100 = 0;
        quantidadeRegistrosC110 = 0;
        quantidadeRegistrosC114 = 0;
        quantidadeRegistrosC190 = 0;
        quantidadeRegistrosC300 = 0;
        quantidadeRegistrosC310 = 0;
        quantidadeRegistrosC320 = 0;
        quantidadeRegistrosC321 = 0;
        quantidadeRegistrosC350 = 0;
        quantidadeRegistrosC370 = 0;
        quantidadeRegistrosC390 = 0;
        quantidadeRegistrosC400 = 0;
        quantidadeRegistrosC405 = 0;
        quantidadeRegistrosC420 = 0;
        quantidadeRegistrosC425 = 0;
        quantidadeRegistrosC460 = 0;
        quantidadeRegistrosC470 = 0;
        quantidadeRegistrosC490 = 0;

        this.util = spedUtil;
    }

    public void limpaRegistros() {

        getRegistroC990().setQtdLinC(0);
    }

    public String writeRegistroC001() {
        getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);

        String registro = "";
        registro += getUtil().fill("C001")
                + getUtil().fill(getRegistroC001().getIndMov())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();

        registro += writeRegistroC100(getRegistroC001().getRegistroC100List());
        registro += writeRegistroC300(getRegistroC001().getRegistroC300List());
        registro += writeRegistroC400(getRegistroC001().getRegistroC400List());

        return registro;
    }

    public String writeRegistroC100(List<RegistroC100> listaRegistroC100) {
        String registro = "";
        for (int i = 0; i < listaRegistroC100.size(); i++) {
            registro += getUtil().fill("C100")
                    + getUtil().fill(listaRegistroC100.get(i).getIndOper())
                    + getUtil().fill(listaRegistroC100.get(i).getIndEmit())
                    + getUtil().fill(listaRegistroC100.get(i).getCodPart())
                    + getUtil().fill(listaRegistroC100.get(i).getCodMod())
                    + getUtil().fill(listaRegistroC100.get(i).getCodSit())
                    + getUtil().fill(listaRegistroC100.get(i).getSer())
                    + getUtil().fill(listaRegistroC100.get(i).getNumDoc())
                    + getUtil().fill(listaRegistroC100.get(i).getChvNfe())
                    + getUtil().fill(listaRegistroC100.get(i).getDtDoc())
                    + getUtil().fill(listaRegistroC100.get(i).getDtES())
                    + getUtil().fill(listaRegistroC100.get(i).getVlDoc())
                    + getUtil().fill(listaRegistroC100.get(i).getIndPgto())
                    + getUtil().fill(listaRegistroC100.get(i).getVlDesc())
                    + getUtil().fill(listaRegistroC100.get(i).getVlAbatNt())
                    + getUtil().fill(listaRegistroC100.get(i).getVlMerc())
                    + getUtil().fill(listaRegistroC100.get(i).getIndFrt())
                    + getUtil().fill(listaRegistroC100.get(i).getVlFrt())
                    + getUtil().fill(listaRegistroC100.get(i).getVlSeg())
                    + getUtil().fill(listaRegistroC100.get(i).getVlOutDa())
                    + getUtil().fill(listaRegistroC100.get(i).getVlBcIcms())
                    + getUtil().fill(listaRegistroC100.get(i).getVlIcms())
                    + getUtil().fill(listaRegistroC100.get(i).getVlBcIcmsSt())
                    + getUtil().fill(listaRegistroC100.get(i).getVlIcmsSt())
                    + getUtil().fill(listaRegistroC100.get(i).getVlIpi())
                    + getUtil().fill(listaRegistroC100.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC100.get(i).getVlCofins())
                    + getUtil().fill(listaRegistroC100.get(i).getVlPisSt())
                    + getUtil().fill(listaRegistroC100.get(i).getVlCofinsSt())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC110(listaRegistroC100.get(i).getRegistroC110List());
            registro += writeRegistroC190(listaRegistroC100.get(i).getRegistroC190List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC100((Integer) (getQuantidadeRegistrosC100() + 1));
        }
        return registro;
    }

    public String writeRegistroC110(List<RegistroC110> listaRegistroC110) {
        String registro = "";
        for (int i = 0; i < listaRegistroC110.size(); i++) {
            registro += getUtil().fill("C110")
                    + getUtil().fill(listaRegistroC110.get(i).getCodInf())
                    + getUtil().fill(listaRegistroC110.get(i).getTxtCompl())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC114(listaRegistroC110.get(i).getRegistroC114List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC110((Integer) (getQuantidadeRegistrosC110() + 1));
        }
        return registro;
    }

    public String writeRegistroC114(List<RegistroC114> listaRegistroC114) {
        String registro = "";
        for (int i = 0; i < listaRegistroC114.size(); i++) {
            registro += getUtil().fill("C114")
                    + getUtil().fill(listaRegistroC114.get(i).getCodMod())
                    + getUtil().fill(listaRegistroC114.get(i).getEcfFab())
                    + getUtil().fill(listaRegistroC114.get(i).getEcfCx())
                    + getUtil().fill(listaRegistroC114.get(i).getNumDoc())
                    + getUtil().fill(listaRegistroC114.get(i).getDtDoc())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC114((Integer) (getQuantidadeRegistrosC114() + 1));
        }
        return registro;
    }

    public String writeRegistroC190(List<RegistroC190> listaRegistroC190) {
        String registro = "";
        for (int i = 0; i < listaRegistroC190.size(); i++) {
            registro += getUtil().fill("C190")
                    + getUtil().fill(listaRegistroC190.get(i).getCstIcms())
                    + getUtil().fill(listaRegistroC190.get(i).getCfop())
                    + getUtil().fill(listaRegistroC190.get(i).getAliqIcms())
                    + getUtil().fill(listaRegistroC190.get(i).getVlOpr())
                    + getUtil().fill(listaRegistroC190.get(i).getVlBcIcms())
                    + getUtil().fill(listaRegistroC190.get(i).getVlIcms())
                    + getUtil().fill(listaRegistroC190.get(i).getVlBcIcmsSt())
                    + getUtil().fill(listaRegistroC190.get(i).getVlIcmsSt())
                    + getUtil().fill(listaRegistroC190.get(i).getVlRedBc())
                    + getUtil().fill(listaRegistroC190.get(i).getVlIpi())
                    + getUtil().fill(listaRegistroC190.get(i).getCodObs())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC190((Integer) (getQuantidadeRegistrosC190() + 1));
        }
        return registro;
    }

    public String writeRegistroC300(List<RegistroC300> listaRegistroC300) {
        String registro = "";
        for (int i = 0; i < listaRegistroC300.size(); i++) {
            registro += getUtil().fill("C300")
                    + getUtil().fill(listaRegistroC300.get(i).getCodMod())
                    + getUtil().fill(listaRegistroC300.get(i).getSer())
                    + getUtil().fill(listaRegistroC300.get(i).getSub())
                    + getUtil().fill(listaRegistroC300.get(i).getNumDocIni())
                    + getUtil().fill(listaRegistroC300.get(i).getNumDocFin())
                    + getUtil().fill(listaRegistroC300.get(i).getDtDoc())
                    + getUtil().fill(listaRegistroC300.get(i).getVlDoc())
                    + getUtil().fill(listaRegistroC300.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC300.get(i).getVlCofins())
                    + getUtil().fill(listaRegistroC300.get(i).getCodCta())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC310(listaRegistroC300.get(i).getRegistroC310List());
            registro += writeRegistroC320(listaRegistroC300.get(i).getRegistroC320List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC300((Integer) (getQuantidadeRegistrosC300() + 1));
        }
        return registro;
    }

    public String writeRegistroC310(List<RegistroC310> listaRegistroC310) {
        String registro = "";
        for (int i = 0; i < listaRegistroC310.size(); i++) {
            registro += getUtil().fill("C310")
                    + getUtil().fill(listaRegistroC310.get(i).getNumDocCanc())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC310((Integer) (getQuantidadeRegistrosC310() + 1));
        }
        return registro;
    }

    public String writeRegistroC320(List<RegistroC320> listaRegistroC320) {
        String registro = "";
        for (int i = 0; i < listaRegistroC320.size(); i++) {
            registro += getUtil().fill("C320")
                    + getUtil().fill(listaRegistroC320.get(i).getCstIcms())
                    + getUtil().fill(listaRegistroC320.get(i).getCfop())
                    + getUtil().fill(listaRegistroC320.get(i).getAliqIcms())
                    + getUtil().fill(listaRegistroC320.get(i).getVlOpr())
                    + getUtil().fill(listaRegistroC320.get(i).getVlBcIcms())
                    + getUtil().fill(listaRegistroC320.get(i).getVlIcms())
                    + getUtil().fill(listaRegistroC320.get(i).getVlRedBc())
                    + getUtil().fill(listaRegistroC320.get(i).getCodObs())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC321(listaRegistroC320.get(i).getRegistroC321List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC320((Integer) (getQuantidadeRegistrosC320() + 1));
        }
        return registro;
    }

    public String writeRegistroC321(List<RegistroC321> listaRegistroC321) {
        String registro = "";
        for (int i = 0; i < listaRegistroC321.size(); i++) {
            registro += getUtil().fill("C321")
                    + getUtil().fill(listaRegistroC321.get(i).getCodItem())
                    + getUtil().fill(listaRegistroC321.get(i).getQtd())
                    + getUtil().fill(listaRegistroC321.get(i).getUnid())
                    + getUtil().fill(listaRegistroC321.get(i).getVlItem())
                    + getUtil().fill(listaRegistroC321.get(i).getVlDesc())
                    + getUtil().fill(listaRegistroC321.get(i).getVlBcIcms())
                    + getUtil().fill(listaRegistroC321.get(i).getVlIcms())
                    + getUtil().fill(listaRegistroC321.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC321.get(i).getVlCofins())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC321((Integer) (getQuantidadeRegistrosC321() + 1));
        }
        return registro;
    }

    public String writeRegistroC350(List<RegistroC350> listaRegistroC350) {
        String registro = "";
        for (int i = 0; i < listaRegistroC350.size(); i++) {
            registro += getUtil().fill("C350")
                    + getUtil().fill(listaRegistroC350.get(i).getSer())
                    + getUtil().fill(listaRegistroC350.get(i).getSubSer())
                    + getUtil().fill(listaRegistroC350.get(i).getNumDoc())
                    + getUtil().fill(listaRegistroC350.get(i).getDtDoc())
                    + getUtil().fill(listaRegistroC350.get(i).getCnpjCpf())
                    + getUtil().fill(listaRegistroC350.get(i).getVlMerc())
                    + getUtil().fill(listaRegistroC350.get(i).getVlDoc())
                    + getUtil().fill(listaRegistroC350.get(i).getVlDesc())
                    + getUtil().fill(listaRegistroC350.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC350.get(i).getVlCofins())
                    + getUtil().fill(listaRegistroC350.get(i).getCodCta())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC370(listaRegistroC350.get(i).getRegistroC370List());
            registro += writeRegistroC390(listaRegistroC350.get(i).getRegistroC390List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC350((Integer) (getQuantidadeRegistrosC350() + 1));
        }
        return registro;
    }

    public String writeRegistroC370(List<RegistroC370> listaRegistroC370) {
        String registro = "";
        for (int i = 0; i < listaRegistroC370.size(); i++) {
            registro += getUtil().fill("C370")
                    + getUtil().fill(listaRegistroC370.get(i).getNumItem())
                    + getUtil().fill(listaRegistroC370.get(i).getCodItem())
                    + getUtil().fill(listaRegistroC370.get(i).getQtd())
                    + getUtil().fill(listaRegistroC370.get(i).getUnid())
                    + getUtil().fill(listaRegistroC370.get(i).getVlItem())
                    + getUtil().fill(listaRegistroC370.get(i).getVlDesc())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC370((Integer) (getQuantidadeRegistrosC370() + 1));
        }
        return registro;
    }

    public String writeRegistroC390(List<RegistroC390> listaRegistroC390) {
        String registro = "";
        for (int i = 0; i < listaRegistroC390.size(); i++) {
            registro += getUtil().fill("C390")
                    + getUtil().fill(listaRegistroC390.get(i).getCstIcms())
                    + getUtil().fill(listaRegistroC390.get(i).getCfop())
                    + getUtil().fill(listaRegistroC390.get(i).getAliqIcms())
                    + getUtil().fill(listaRegistroC390.get(i).getVlOpr())
                    + getUtil().fill(listaRegistroC390.get(i).getVlBcIcms())
                    + getUtil().fill(listaRegistroC390.get(i).getVlIcms())
                    + getUtil().fill(listaRegistroC390.get(i).getVlRedBc())
                    + getUtil().fill(listaRegistroC390.get(i).getCodObs())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC390((Integer) (getQuantidadeRegistrosC390() + 1));
        }
        return registro;
    }

    public String writeRegistroC400(List<RegistroC400> listaRegistroC400) {
        String registro = "";
        for (int i = 0; i < listaRegistroC400.size(); i++) {
            registro += getUtil().fill("C400")
                    + getUtil().fill(listaRegistroC400.get(i).getCodMod())
                    + getUtil().fill(listaRegistroC400.get(i).getEcfMod())
                    + getUtil().fill(listaRegistroC400.get(i).getEcfFab())
                    + getUtil().fill(listaRegistroC400.get(i).getEcfCx())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC405(listaRegistroC400.get(i).getRegistroC405List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC400((Integer) (getQuantidadeRegistrosC400() + 1));
        }
        return registro;
    }

    public String writeRegistroC405(List<RegistroC405> listaRegistroC405) {
        String registro = "";
        for (int i = 0; i < listaRegistroC405.size(); i++) {
            registro += getUtil().fill("C405")
                    + getUtil().fill(listaRegistroC405.get(i).getDtDoc())
                    + getUtil().fill(listaRegistroC405.get(i).getCro())
                    + getUtil().fill(listaRegistroC405.get(i).getCrz())
                    + getUtil().fill(listaRegistroC405.get(i).getNumCooFin())
                    + getUtil().fill(listaRegistroC405.get(i).getGtFin())
                    + getUtil().fill(listaRegistroC405.get(i).getVlBrt())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC420(listaRegistroC405.get(i).getRegistroC420List());
            registro += writeRegistroC460(listaRegistroC405.get(i).getRegistroC460List());
            registro += writeRegistroC490(listaRegistroC405.get(i).getRegistroC490List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC405((Integer) (getQuantidadeRegistrosC405() + 1));
        }
        return registro;
    }

    public String writeRegistroC420(List<RegistroC420> listaRegistroC420) {
        String registro = "";
        for (int i = 0; i < listaRegistroC420.size(); i++) {
            registro += getUtil().fill("C420")
                    + getUtil().fill(listaRegistroC420.get(i).getCodTotPar())
                    + getUtil().fill(listaRegistroC420.get(i).getVlrAcumTot())
                    + getUtil().fill(listaRegistroC420.get(i).getNrTot())
                    + getUtil().fill(listaRegistroC420.get(i).getDescrNrTot())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC425(listaRegistroC420.get(i).getRegistroC425List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC420((Integer) (getQuantidadeRegistrosC420() + 1));
        }
        return registro;
    }

    public String writeRegistroC425(List<RegistroC425> listaRegistroC425) {
        String registro = "";
        for (int i = 0; i < listaRegistroC425.size(); i++) {
            registro += getUtil().fill("C425")
                    + getUtil().fill(listaRegistroC425.get(i).getCodItem())
                    + getUtil().fill(listaRegistroC425.get(i).getQtd())
                    + getUtil().fill(listaRegistroC425.get(i).getUnid())
                    + getUtil().fill(listaRegistroC425.get(i).getVlItem())
                    + getUtil().fill(listaRegistroC425.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC425.get(i).getVlCofins())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC425((Integer) (getQuantidadeRegistrosC425() + 1));
        }
        return registro;
    }

    public String writeRegistroC460(List<RegistroC460> listaRegistroC460) {
        String registro = "";
        for (int i = 0; i < listaRegistroC460.size(); i++) {
            registro += getUtil().fill("C460")
                    + getUtil().fill(listaRegistroC460.get(i).getCodMod())
                    + getUtil().fill(listaRegistroC460.get(i).getCodSit())
                    + getUtil().fill(listaRegistroC460.get(i).getNumDoc())
                    + getUtil().fill(listaRegistroC460.get(i).getDtDoc())
                    + getUtil().fill(listaRegistroC460.get(i).getVlDoc())
                    + getUtil().fill(listaRegistroC460.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC460.get(i).getVlCofins())
                    + getUtil().fill(listaRegistroC460.get(i).getCpfCnpj())
                    + getUtil().fill(listaRegistroC460.get(i).getNomAdq())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            registro += writeRegistroC470(listaRegistroC460.get(i).getRegistroC470List());

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC460((Integer) (getQuantidadeRegistrosC460() + 1));
        }
        return registro;
    }

    public String writeRegistroC470(List<RegistroC470> listaRegistroC470) {
        String registro = "";
        for (int i = 0; i < listaRegistroC470.size(); i++) {
            registro += getUtil().fill("C470")
                    + getUtil().fill(listaRegistroC470.get(i).getCodItem())
                    + getUtil().fill(listaRegistroC470.get(i).getQtd())
                    + getUtil().fill(listaRegistroC470.get(i).getQtdCanc())
                    + getUtil().fill(listaRegistroC470.get(i).getUnid())
                    + getUtil().fill(listaRegistroC470.get(i).getVlItem())
                    + getUtil().fill(listaRegistroC470.get(i).getCstIcms())
                    + getUtil().fill(listaRegistroC470.get(i).getCfop())
                    + getUtil().fill(listaRegistroC470.get(i).getAliqIcms())
                    + getUtil().fill(listaRegistroC470.get(i).getVlPis())
                    + getUtil().fill(listaRegistroC470.get(i).getVlCofins())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC470((Integer) (getQuantidadeRegistrosC470() + 1));
        }
        return registro;
    }

    public String writeRegistroC490(List<RegistroC490> listaRegistroC490) {
        String registro = "";
        for (int i = 0; i < listaRegistroC490.size(); i++) {
            registro += getUtil().fill("C490")
                    + getUtil().fill(listaRegistroC490.get(i).getCstIcms())
                    + getUtil().fill(listaRegistroC490.get(i).getCfop())
                    + getUtil().fill(listaRegistroC490.get(i).getAliqIcms())
                    + getUtil().fill(listaRegistroC490.get(i).getVlOpr())
                    + getUtil().fill(listaRegistroC490.get(i).getVlBcIcms())
                    + getUtil().fill(listaRegistroC490.get(i).getVlIcms())
                    + getUtil().fill(listaRegistroC490.get(i).getCodObs())
                    + getUtil().getDelimitador()
                    + getUtil().getCrlf();

            getRegistroC990().setQtdLinC(getRegistroC990().getQtdLinC() + 1);
            setQuantidadeRegistrosC490((Integer) (getQuantidadeRegistrosC490() + 1));
        }
        return registro;
    }

    public String writeRegistroC990() {
        return getUtil().fill("C990")
                + getUtil().fill(getRegistroC990().getQtdLinC())
                + getUtil().getDelimitador()
                + getUtil().getCrlf();
    }

    /**
     * @return the registroC001
     */
    public RegistroC001 getRegistroC001() {
        return registroC001;
    }

    /**
     * @param registroC001 the registroC001 to set
     */
    public void setRegistroC001(RegistroC001 registroC001) {
        this.registroC001 = registroC001;
    }

    /**
     * @return the quantidadeRegistrosC100
     */
    public Integer getQuantidadeRegistrosC100() {
        return quantidadeRegistrosC100;
    }

    /**
     * @param quantidadeRegistrosC100 the quantidadeRegistrosC100 to set
     */
    public void setQuantidadeRegistrosC100(Integer quantidadeRegistrosC100) {
        this.quantidadeRegistrosC100 = quantidadeRegistrosC100;
    }

    /**
     * @return the quantidadeRegistrosC114
     */
    public Integer getQuantidadeRegistrosC114() {
        return quantidadeRegistrosC114;
    }

    /**
     * @param quantidadeRegistrosC114 the quantidadeRegistrosC114 to set
     */
    public void setQuantidadeRegistrosC114(Integer quantidadeRegistrosC114) {
        this.quantidadeRegistrosC114 = quantidadeRegistrosC114;
    }

    /**
     * @return the quantidadeRegistrosC190
     */
    public Integer getQuantidadeRegistrosC190() {
        return quantidadeRegistrosC190;
    }

    /**
     * @param quantidadeRegistrosC190 the quantidadeRegistrosC190 to set
     */
    public void setQuantidadeRegistrosC190(Integer quantidadeRegistrosC190) {
        this.quantidadeRegistrosC190 = quantidadeRegistrosC190;
    }

    /**
     * @return the quantidadeRegistrosC300
     */
    public Integer getQuantidadeRegistrosC300() {
        return quantidadeRegistrosC300;
    }

    /**
     * @param quantidadeRegistrosC300 the quantidadeRegistrosC300 to set
     */
    public void setQuantidadeRegistrosC300(Integer quantidadeRegistrosC300) {
        this.quantidadeRegistrosC300 = quantidadeRegistrosC300;
    }

    /**
     * @return the quantidadeRegistrosC310
     */
    public Integer getQuantidadeRegistrosC310() {
        return quantidadeRegistrosC310;
    }

    /**
     * @param quantidadeRegistrosC310 the quantidadeRegistrosC310 to set
     */
    public void setQuantidadeRegistrosC310(Integer quantidadeRegistrosC310) {
        this.quantidadeRegistrosC310 = quantidadeRegistrosC310;
    }

    /**
     * @return the quantidadeRegistrosC320
     */
    public Integer getQuantidadeRegistrosC320() {
        return quantidadeRegistrosC320;
    }

    /**
     * @param quantidadeRegistrosC320 the quantidadeRegistrosC320 to set
     */
    public void setQuantidadeRegistrosC320(Integer quantidadeRegistrosC320) {
        this.quantidadeRegistrosC320 = quantidadeRegistrosC320;
    }

    /**
     * @return the quantidadeRegistrosC321
     */
    public Integer getQuantidadeRegistrosC321() {
        return quantidadeRegistrosC321;
    }

    /**
     * @param quantidadeRegistrosC321 the quantidadeRegistrosC321 to set
     */
    public void setQuantidadeRegistrosC321(Integer quantidadeRegistrosC321) {
        this.quantidadeRegistrosC321 = quantidadeRegistrosC321;
    }

    /**
     * @return the quantidadeRegistrosC350
     */
    public Integer getQuantidadeRegistrosC350() {
        return quantidadeRegistrosC350;
    }

    /**
     * @param quantidadeRegistrosC350 the quantidadeRegistrosC350 to set
     */
    public void setQuantidadeRegistrosC350(Integer quantidadeRegistrosC350) {
        this.quantidadeRegistrosC350 = quantidadeRegistrosC350;
    }

    /**
     * @return the quantidadeRegistrosC370
     */
    public Integer getQuantidadeRegistrosC370() {
        return quantidadeRegistrosC370;
    }

    /**
     * @param quantidadeRegistrosC370 the quantidadeRegistrosC370 to set
     */
    public void setQuantidadeRegistrosC370(Integer quantidadeRegistrosC370) {
        this.quantidadeRegistrosC370 = quantidadeRegistrosC370;
    }

    /**
     * @return the quantidadeRegistrosC390
     */
    public Integer getQuantidadeRegistrosC390() {
        return quantidadeRegistrosC390;
    }

    /**
     * @param quantidadeRegistrosC390 the quantidadeRegistrosC390 to set
     */
    public void setQuantidadeRegistrosC390(Integer quantidadeRegistrosC390) {
        this.quantidadeRegistrosC390 = quantidadeRegistrosC390;
    }

    /**
     * @return the quantidadeRegistrosC400
     */
    public Integer getQuantidadeRegistrosC400() {
        return quantidadeRegistrosC400;
    }

    /**
     * @param quantidadeRegistrosC400 the quantidadeRegistrosC400 to set
     */
    public void setQuantidadeRegistrosC400(Integer quantidadeRegistrosC400) {
        this.quantidadeRegistrosC400 = quantidadeRegistrosC400;
    }

    /**
     * @return the quantidadeRegistrosC405
     */
    public Integer getQuantidadeRegistrosC405() {
        return quantidadeRegistrosC405;
    }

    /**
     * @param quantidadeRegistrosC405 the quantidadeRegistrosC405 to set
     */
    public void setQuantidadeRegistrosC405(Integer quantidadeRegistrosC405) {
        this.quantidadeRegistrosC405 = quantidadeRegistrosC405;
    }

    /**
     * @return the quantidadeRegistrosC420
     */
    public Integer getQuantidadeRegistrosC420() {
        return quantidadeRegistrosC420;
    }

    /**
     * @param quantidadeRegistrosC420 the quantidadeRegistrosC420 to set
     */
    public void setQuantidadeRegistrosC420(Integer quantidadeRegistrosC420) {
        this.quantidadeRegistrosC420 = quantidadeRegistrosC420;
    }

    /**
     * @return the quantidadeRegistrosC425
     */
    public Integer getQuantidadeRegistrosC425() {
        return quantidadeRegistrosC425;
    }

    /**
     * @param quantidadeRegistrosC425 the quantidadeRegistrosC425 to set
     */
    public void setQuantidadeRegistrosC425(Integer quantidadeRegistrosC425) {
        this.quantidadeRegistrosC425 = quantidadeRegistrosC425;
    }

    /**
     * @return the quantidadeRegistrosC460
     */
    public Integer getQuantidadeRegistrosC460() {
        return quantidadeRegistrosC460;
    }

    /**
     * @param quantidadeRegistrosC460 the quantidadeRegistrosC460 to set
     */
    public void setQuantidadeRegistrosC460(Integer quantidadeRegistrosC460) {
        this.quantidadeRegistrosC460 = quantidadeRegistrosC460;
    }

    /**
     * @return the quantidadeRegistrosC470
     */
    public Integer getQuantidadeRegistrosC470() {
        return quantidadeRegistrosC470;
    }

    /**
     * @param quantidadeRegistrosC470 the quantidadeRegistrosC470 to set
     */
    public void setQuantidadeRegistrosC470(Integer quantidadeRegistrosC470) {
        this.quantidadeRegistrosC470 = quantidadeRegistrosC470;
    }

    /**
     * @return the quantidadeRegistrosC490
     */
    public Integer getQuantidadeRegistrosC490() {
        return quantidadeRegistrosC490;
    }

    /**
     * @param quantidadeRegistrosC490 the quantidadeRegistrosC490 to set
     */
    public void setQuantidadeRegistrosC490(Integer quantidadeRegistrosC490) {
        this.quantidadeRegistrosC490 = quantidadeRegistrosC490;
    }

    /**
     * @return the registroC990
     */
    public RegistroC990 getRegistroC990() {
        return registroC990;
    }

    /**
     * @param registroC990 the registroC990 to set
     */
    public void setRegistroC990(RegistroC990 registroC990) {
        this.registroC990 = registroC990;
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
     * @return the quantidadeRegistrosC110
     */
    public Integer getQuantidadeRegistrosC110() {
        return quantidadeRegistrosC110;
    }

    /**
     * @param quantidadeRegistrosC110 the quantidadeRegistrosC110 to set
     */
    public void setQuantidadeRegistrosC110(Integer quantidadeRegistrosC110) {
        this.quantidadeRegistrosC110 = quantidadeRegistrosC110;
    }
}
