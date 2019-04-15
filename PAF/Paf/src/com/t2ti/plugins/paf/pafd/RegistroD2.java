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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroD2 {

    private String cnpjEstabelecimento; // CNPJ do estabelecimento usuário do PAF-ECF
    private String numeroFabricacao; // Nº de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String tipoEcf; // Tipo do ECF
    private String marcaEcf; // Marca do ECF
    private String modeloEcf; // Modelo do ECF
    private String coo; // Contador de Ordem de Operação do documento onde o DAV foi impresso pelo ECF
    private String numeroDav; // Número do DAV emitido
    private Date dataDav; // Data de emissão do DAV
    private String tituloDav; // Título atribuído ao DAV de acordo com sua função. Ex
    private Double valorTotalDav; // Valor total do DAV emitido, com duas casas decimais
    private String cooVinculado; // Contador de Ordem de Operação do Documento Fiscal Vinculado
    private String numeroSequencial; // Número sequencial do ECF emissor do documento fiscal vinculado
    private String nomeAdquirente; // Nome do Cliente
    private String cpfCnpjAdquirente; // CPF ou CNPJ do adquirente

    /**
     * @return the cnpjEstabelecimento
     */
    public String getCnpjEstabelecimento() {
        return cnpjEstabelecimento;
    }

    /**
     * @param cnpjEstabelecimento the cnpjEstabelecimento to set
     */
    public void setCnpjEstabelecimento(String cnpjEstabelecimento) {
        this.cnpjEstabelecimento = cnpjEstabelecimento;
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
     * @return the coo
     */
    public String getCoo() {
        return coo;
    }

    /**
     * @param coo the coo to set
     */
    public void setCoo(String coo) {
        this.coo = coo;
    }

    /**
     * @return the numeroDav
     */
    public String getNumeroDav() {
        return numeroDav;
    }

    /**
     * @param numeroDav the numeroDav to set
     */
    public void setNumeroDav(String numeroDav) {
        this.numeroDav = numeroDav;
    }

    /**
     * @return the dataDav
     */
    public Date getDataDav() {
        return dataDav;
    }

    /**
     * @param dataDav the dataDav to set
     */
    public void setDataDav(Date dataDav) {
        this.dataDav = dataDav;
    }

    /**
     * @return the tituloDav
     */
    public String getTituloDav() {
        return tituloDav;
    }

    /**
     * @param tituloDav the tituloDav to set
     */
    public void setTituloDav(String tituloDav) {
        this.tituloDav = tituloDav;
    }

    /**
     * @return the valorTotalDav
     */
    public Double getValorTotalDav() {
        return valorTotalDav;
    }

    /**
     * @param valorTotalDav the valorTotalDav to set
     */
    public void setValorTotalDav(Double valorTotalDav) {
        this.valorTotalDav = valorTotalDav;
    }

    /**
     * @return the cooVinculado
     */
    public String getCooVinculado() {
        return cooVinculado;
    }

    /**
     * @param cooVinculado the cooVinculado to set
     */
    public void setCooVinculado(String cooVinculado) {
        this.cooVinculado = cooVinculado;
    }

    /**
     * @return the numeroSequencial
     */
    public String getNumeroSequencial() {
        return numeroSequencial;
    }

    /**
     * @param numeroSequencial the numeroSequencial to set
     */
    public void setNumeroSequencial(String numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    /**
     * @return the nomeAdquirente
     */
    public String getNomeAdquirente() {
        return nomeAdquirente;
    }

    /**
     * @param nomeAdquirente the nomeAdquirente to set
     */
    public void setNomeAdquirente(String nomeAdquirente) {
        this.nomeAdquirente = nomeAdquirente;
    }

    /**
     * @return the cpfCnpjAdquirente
     */
    public String getCpfCnpjAdquirente() {
        return cpfCnpjAdquirente;
    }

    /**
     * @param cpfCnpjAdquirente the cpfCnpjAdquirente to set
     */
    public void setCpfCnpjAdquirente(String cpfCnpjAdquirente) {
        this.cpfCnpjAdquirente = cpfCnpjAdquirente;
    }

}
