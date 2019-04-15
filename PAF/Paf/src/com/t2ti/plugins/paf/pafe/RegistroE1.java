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
package com.t2ti.plugins.paf.pafe;

import java.util.Date;

public class RegistroE1 {

    private String cnpj; // CNPJ do estabelecimento usuário do PAF-ECF
    private String inscricaoEstadual; // Inscrição Estadual do estabelecimento
    private String inscricaoMunicipal; // Inscrição Municipal do estabelecimento
    private String razaoSocial; // Razão Social do estabelecimento
    private String numeroFabricacao; //Número de fabricação do ECF responsável pela atualização do estoque
    private String mfAdicional; //Número de fabricação do ECF responsável pela atualização do estoque
    private String tipoEcf; //Tipo de ECF
    private String marcaEcf; //Marca do ECF
    private String modeloEcf; //Modelo do ECF
    private Date dataEstoque; //Data da atualização do estoque
    private String horaEstoque; //Hora da atualização do estoque

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
     * @return the inscricaoMunicipal
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal the inscricaoMunicipal to set
     */
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

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
     * @return the tipoEcf
     */
    public String getTipoEcf() {
        return tipoEcf;
    }

    /**
     * @param tipoEcf the tipoEcf to set
     */
    public void setTipoEcf(String tipoEcf) {
        this.tipoEcf = tipoEcf;
    }

    /**
     * @return the marcaEcf
     */
    public String getMarcaEcf() {
        return marcaEcf;
    }

    /**
     * @param marcaEcf the marcaEcf to set
     */
    public void setMarcaEcf(String marcaEcf) {
        this.marcaEcf = marcaEcf;
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
     * @return the dataEstoque
     */
    public Date getDataEstoque() {
        return dataEstoque;
    }

    /**
     * @param dataEstoque the dataEstoque to set
     */
    public void setDataEstoque(Date dataEstoque) {
        this.dataEstoque = dataEstoque;
    }

    /**
     * @return the horaEstoque
     */
    public String getHoraEstoque() {
        return horaEstoque;
    }

    /**
     * @param horaEstoque the horaEstoque to set
     */
    public void setHoraEstoque(String horaEstoque) {
        this.horaEstoque = horaEstoque;
    }
}
