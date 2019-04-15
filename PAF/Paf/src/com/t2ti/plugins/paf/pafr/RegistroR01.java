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

public class RegistroR01 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String tipoEcf; // Tipo de ECF
    private String marcaEcf; // Marca do ECF
    private String modeloEcf; // Modelo do ECF
    private String versaoSb; // Versão atual do Software Básico do ECF gravada na MF
    private Date dataInstalacaoSb; // Data de instalação da versão atual do Software Básico gravada naMemória Fiscal do ECF
    private String horaInstalacaoSb; // Horário de instalação da versão atual do Software Básico gravada na Memória Fiscal do ECF
    private Integer numeroSequencialEcf; // Nº de ordem seqüencial do ECF no estabelecimento usuário
    private String cnpjUsuario; // CNPJ do estabelecimento usuário do ECF
    private String inscricaoEstadualUsuario; // Inscrição Estadual do estabelecimento usuário
    private String cnpjSoftwareHouse; // CNPJ da empresa desenvolvedora do PAF-ECF
    private String inscricaoEstadualSoftwareHouse; // Inscrição Estadual da empresa desenvolvedora do PAF-ECF, se houver
    private String inscricaoMunicipalSoftwareHouse; // Inscrição Municipal da empresa desenvolvedora do PAF-ECF, se houver
    private String nomeSoftwareHouse; // Denominação da empresa desenvolvedora do PAF-ECF
    private String nomePaf; // Nome Comercial do PAF-ECF
    private String versaoPaf; // Versão atual do PAF-ECF
    private String codigoMd5; // Código MD-5 da Lista de Arquivos Autenticados do PAF-ECF
    private Date dataInicial; // Data do início do período informado no arquivo
    private Date dataFinal; // Data do fim do período informado no arquivo
    private String versaoEspecificacaoRequisitos; // Versão da Especificação de Requisitos do PAF-ECF

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
     * @return the versaoSb
     */
    public String getVersaoSb() {
        return versaoSb;
    }

    /**
     * @param versaoSb the versaoSb to set
     */
    public void setVersaoSb(String versaoSb) {
        this.versaoSb = versaoSb;
    }

    /**
     * @return the dataInstalacaoSb
     */
    public Date getDataInstalacaoSb() {
        return dataInstalacaoSb;
    }

    /**
     * @param dataInstalacaoSb the dataInstalacaoSb to set
     */
    public void setDataInstalacaoSb(Date dataInstalacaoSb) {
        this.dataInstalacaoSb = dataInstalacaoSb;
    }

    /**
     * @return the horaInstalacaoSb
     */
    public String getHoraInstalacaoSb() {
        return horaInstalacaoSb;
    }

    /**
     * @param horaInstalacaoSb the horaInstalacaoSb to set
     */
    public void setHoraInstalacaoSb(String horaInstalacaoSb) {
        this.horaInstalacaoSb = horaInstalacaoSb;
    }

    /**
     * @return the numeroSequencialEcf
     */
    public Integer getNumeroSequencialEcf() {
        return numeroSequencialEcf;
    }

    /**
     * @param numeroSequencialEcf the numeroSequencialEcf to set
     */
    public void setNumeroSequencialEcf(Integer numeroSequencialEcf) {
        this.numeroSequencialEcf = numeroSequencialEcf;
    }

    /**
     * @return the cnpjUsuario
     */
    public String getCnpjUsuario() {
        return cnpjUsuario;
    }

    /**
     * @param cnpjUsuario the cnpjUsuario to set
     */
    public void setCnpjUsuario(String cnpjUsuario) {
        this.cnpjUsuario = cnpjUsuario;
    }

    /**
     * @return the inscricaoEstadualUsuario
     */
    public String getInscricaoEstadualUsuario() {
        return inscricaoEstadualUsuario;
    }

    /**
     * @param inscricaoEstadualUsuario the inscricaoEstadualUsuario to set
     */
    public void setInscricaoEstadualUsuario(String inscricaoEstadualUsuario) {
        this.inscricaoEstadualUsuario = inscricaoEstadualUsuario;
    }

    /**
     * @return the cnpjSoftwareHouse
     */
    public String getCnpjSoftwareHouse() {
        return cnpjSoftwareHouse;
    }

    /**
     * @param cnpjSoftwareHouse the cnpjSoftwareHouse to set
     */
    public void setCnpjSoftwareHouse(String cnpjSoftwareHouse) {
        this.cnpjSoftwareHouse = cnpjSoftwareHouse;
    }

    /**
     * @return the inscricaoEstadualSoftwareHouse
     */
    public String getInscricaoEstadualSoftwareHouse() {
        return inscricaoEstadualSoftwareHouse;
    }

    /**
     * @param inscricaoEstadualSoftwareHouse the inscricaoEstadualSoftwareHouse
     * to set
     */
    public void setInscricaoEstadualSoftwareHouse(String inscricaoEstadualSoftwareHouse) {
        this.inscricaoEstadualSoftwareHouse = inscricaoEstadualSoftwareHouse;
    }

    /**
     * @return the inscricaoMunicipalSoftwareHouse
     */
    public String getInscricaoMunicipalSoftwareHouse() {
        return inscricaoMunicipalSoftwareHouse;
    }

    /**
     * @param inscricaoMunicipalSoftwareHouse the
     * inscricaoMunicipalSoftwareHouse to set
     */
    public void setInscricaoMunicipalSoftwareHouse(String inscricaoMunicipalSoftwareHouse) {
        this.inscricaoMunicipalSoftwareHouse = inscricaoMunicipalSoftwareHouse;
    }

    /**
     * @return the nomeSoftwareHouse
     */
    public String getNomeSoftwareHouse() {
        return nomeSoftwareHouse;
    }

    /**
     * @param nomeSoftwareHouse the nomeSoftwareHouse to set
     */
    public void setNomeSoftwareHouse(String nomeSoftwareHouse) {
        this.nomeSoftwareHouse = nomeSoftwareHouse;
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

    /**
     * @return the codigoMd5
     */
    public String getCodigoMd5() {
        return codigoMd5;
    }

    /**
     * @param codigoMd5 the codigoMd5 to set
     */
    public void setCodigoMd5(String codigoMd5) {
        this.codigoMd5 = codigoMd5;
    }

    /**
     * @return the dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the versaoEspecificacaoRequisitos
     */
    public String getVersaoEspecificacaoRequisitos() {
        return versaoEspecificacaoRequisitos;
    }

    /**
     * @param versaoEspecificacaoRequisitos the versaoEspecificacaoRequisitos to
     * set
     */
    public void setVersaoEspecificacaoRequisitos(String versaoEspecificacaoRequisitos) {
        this.versaoEspecificacaoRequisitos = versaoEspecificacaoRequisitos;
    }
}