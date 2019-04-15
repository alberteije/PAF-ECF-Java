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
package com.t2ti.plugins.paf.pafr;

import java.util.Date;

public class RegistroR06 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String modeloEcf; // Modelo do ECF
    private Integer numeroUsuario; // Nº de ordem do usuário do ECF relativo à respectiva Redução Z
    private Integer coo; // Nº do COO relativo ao respectivo documento
    private Integer gnf; // Número do GNF relativo ao respectivo documento, quando houver
    private Integer grg; // Número do GRG relativo ao respectivo documento (vide item 7.6.1.2)
    private Integer cdc; // Número do CDC relativo ao respectivo documento (vide item 7.6.1.3)
    private String denominacao; // Símbolo referente à denominação do documento fiscal, conforme tabela abaixo
    private Date dataFinalEmissao; // Data final de emissão (impressa no rodapé do documento)
    private String horaFinalEmissao; // Hora final de emissão (impressa no rodapé do documento)

    /**
     * @return the numeroFabricacao
     */
    public String getNumeroFabricacao() {
        return numeroFabricacao;
    }

    /**
     * @param numeroFabricacao the numeroFabricacao to set
     */
    public void setNumeroFabricacao(String numeroFabricacao) {
        this.numeroFabricacao = numeroFabricacao;
    }

    /**
     * @return the mfAdicional
     */
    public String getMfAdicional() {
        return mfAdicional;
    }

    /**
     * @param mfAdicional the mfAdicional to set
     */
    public void setMfAdicional(String mfAdicional) {
        this.mfAdicional = mfAdicional;
    }

    /**
     * @return the modeloEcf
     */
    public String getModeloEcf() {
        return modeloEcf;
    }

    /**
     * @param modeloEcf the modeloEcf to set
     */
    public void setModeloEcf(String modeloEcf) {
        this.modeloEcf = modeloEcf;
    }

    /**
     * @return the numeroUsuario
     */
    public Integer getNumeroUsuario() {
        return numeroUsuario;
    }

    /**
     * @param numeroUsuario the numeroUsuario to set
     */
    public void setNumeroUsuario(Integer numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return the coo
     */
    public Integer getCoo() {
        return coo;
    }

    /**
     * @param coo the coo to set
     */
    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    /**
     * @return the gnf
     */
    public Integer getGnf() {
        return gnf;
    }

    /**
     * @param gnf the gnf to set
     */
    public void setGnf(Integer gnf) {
        this.gnf = gnf;
    }

    /**
     * @return the grg
     */
    public Integer getGrg() {
        return grg;
    }

    /**
     * @param grg the grg to set
     */
    public void setGrg(Integer grg) {
        this.grg = grg;
    }

    /**
     * @return the cdc
     */
    public Integer getCdc() {
        return cdc;
    }

    /**
     * @param cdc the cdc to set
     */
    public void setCdc(Integer cdc) {
        this.cdc = cdc;
    }

    /**
     * @return the denominacao
     */
    public String getDenominacao() {
        return denominacao;
    }

    /**
     * @param denominacao the denominacao to set
     */
    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    /**
     * @return the dataFinalEmissao
     */
    public Date getDataFinalEmissao() {
        return dataFinalEmissao;
    }

    /**
     * @param dataFinalEmissao the dataFinalEmissao to set
     */
    public void setDataFinalEmissao(Date dataFinalEmissao) {
        this.dataFinalEmissao = dataFinalEmissao;
    }

    /**
     * @return the horaFinalEmissao
     */
    public String getHoraFinalEmissao() {
        return horaFinalEmissao;
    }

    /**
     * @param horaFinalEmissao the horaFinalEmissao to set
     */
    public void setHoraFinalEmissao(String horaFinalEmissao) {
        this.horaFinalEmissao = horaFinalEmissao;
    }
}
