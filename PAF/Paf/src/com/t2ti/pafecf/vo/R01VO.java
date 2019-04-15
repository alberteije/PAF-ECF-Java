package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [R01]</p>
*
* <p>The MIT License</p>
*
* <p>Copyright: Copyright (C) 2010 T2Ti.COM
*
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
*
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
* OTHER DEALINGS IN THE SOFTWARE.
*
*        The author may be contacted at:
*            t2ti.com@gmail.com</p>
*
* @author Claudio de Barros (t2ti.com@gmail.com)
* @version 2.0
*/
@Entity
@Table(name = "R01")
public class R01VO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SERIE_ECF")
    private String serieEcf;
    @Column(name = "CNPJ_EMPRESA")
    private String cnpjEmpresa;
    @Column(name = "CNPJ_SH")
    private String cnpjSh;
    @Column(name = "INSCRICAO_ESTADUAL_SH")
    private String inscricaoEstadualSh;
    @Column(name = "INSCRICAO_MUNICIPAL_SH")
    private String inscricaoMunicipalSh;
    @Column(name = "DENOMINACAO_SH")
    private String denominacaoSh;
    @Column(name = "NOME_PAF_ECF")
    private String nomePafEcf;
    @Column(name = "VERSAO_PAF_ECF")
    private String versaoPafEcf;
    @Column(name = "MD5_PAF_ECF")
    private String md5PafEcf;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_INICIAL")
    private Date dataInicial;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_FINAL")
    private Date dataFinal;
    @Column(name = "VERSAO_ER")
    private String versaoEr;
    @Column(name = "NUMERO_LAUDO_PAF")
    private String numeroLaudoPaf;
    @Column(name = "RAZAO_SOCIAL_SH")
    private String razaoSocialSh;
    @Column(name = "ENDERECO_SH")
    private String enderecoSh;
    @Column(name = "NUMERO_SH")
    private String numeroSh;
    @Column(name = "COMPLEMENTO_SH")
    private String complementoSh;
    @Column(name = "BAIRRO_SH")
    private String bairroSh;
    @Column(name = "CIDADE_SH")
    private String cidadeSh;
    @Column(name = "CEP_SH")
    private String cepSh;
    @Column(name = "UF_SH")
    private String ufSh;
    @Column(name = "TELEFONE_SH")
    private String telefoneSh;
    @Column(name = "CONTATO_SH")
    private String contatoSh;
    @Column(name = "PRINCIPAL_EXECUTAVEL")
    private String principalExecutavel;
    @Column(name = "LOGSS")
    private String logss;

    public R01VO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieEcf() {
        return serieEcf;
    }

    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getCnpjSh() {
        return cnpjSh;
    }

    public void setCnpjSh(String cnpjSh) {
        this.cnpjSh = cnpjSh;
    }

    public String getInscricaoEstadualSh() {
        return inscricaoEstadualSh;
    }

    public void setInscricaoEstadualSh(String inscricaoEstadualSh) {
        this.inscricaoEstadualSh = inscricaoEstadualSh;
    }

    public String getInscricaoMunicipalSh() {
        return inscricaoMunicipalSh;
    }

    public void setInscricaoMunicipalSh(String inscricaoMunicipalSh) {
        this.inscricaoMunicipalSh = inscricaoMunicipalSh;
    }

    public String getDenominacaoSh() {
        return denominacaoSh;
    }

    public void setDenominacaoSh(String denominacaoSh) {
        this.denominacaoSh = denominacaoSh;
    }

    public String getNomePafEcf() {
        return nomePafEcf;
    }

    public void setNomePafEcf(String nomePafEcf) {
        this.nomePafEcf = nomePafEcf;
    }

    public String getVersaoPafEcf() {
        return versaoPafEcf;
    }

    public void setVersaoPafEcf(String versaoPafEcf) {
        this.versaoPafEcf = versaoPafEcf;
    }

    public String getMd5PafEcf() {
        return md5PafEcf;
    }

    public void setMd5PafEcf(String md5PafEcf) {
        this.md5PafEcf = md5PafEcf;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getVersaoEr() {
        return versaoEr;
    }

    public void setVersaoEr(String versaoEr) {
        this.versaoEr = versaoEr;
    }

    public String getNumeroLaudoPaf() {
        return numeroLaudoPaf;
    }

    public void setNumeroLaudoPaf(String numeroLaudoPaf) {
        this.numeroLaudoPaf = numeroLaudoPaf;
    }

    public String getRazaoSocialSh() {
        return razaoSocialSh;
    }

    public void setRazaoSocialSh(String razaoSocialSh) {
        this.razaoSocialSh = razaoSocialSh;
    }

    public String getEnderecoSh() {
        return enderecoSh;
    }

    public void setEnderecoSh(String enderecoSh) {
        this.enderecoSh = enderecoSh;
    }

    public String getNumeroSh() {
        return numeroSh;
    }

    public void setNumeroSh(String numeroSh) {
        this.numeroSh = numeroSh;
    }

    public String getComplementoSh() {
        return complementoSh;
    }

    public void setComplementoSh(String complementoSh) {
        this.complementoSh = complementoSh;
    }

    public String getBairroSh() {
        return bairroSh;
    }

    public void setBairroSh(String bairroSh) {
        this.bairroSh = bairroSh;
    }

    public String getCidadeSh() {
        return cidadeSh;
    }

    public void setCidadeSh(String cidadeSh) {
        this.cidadeSh = cidadeSh;
    }

    public String getCepSh() {
        return cepSh;
    }

    public void setCepSh(String cepSh) {
        this.cepSh = cepSh;
    }

    public String getUfSh() {
        return ufSh;
    }

    public void setUfSh(String ufSh) {
        this.ufSh = ufSh;
    }

    public String getTelefoneSh() {
        return telefoneSh;
    }

    public void setTelefoneSh(String telefoneSh) {
        this.telefoneSh = telefoneSh;
    }

    public String getContatoSh() {
        return contatoSh;
    }

    public void setContatoSh(String contatoSh) {
        this.contatoSh = contatoSh;
    }

    public String getPrincipalExecutavel() {
        return principalExecutavel;
    }

    public void setPrincipalExecutavel(String principalExecutavel) {
        this.principalExecutavel = principalExecutavel;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.R01VO[id=" + id + "]";
    }

}
