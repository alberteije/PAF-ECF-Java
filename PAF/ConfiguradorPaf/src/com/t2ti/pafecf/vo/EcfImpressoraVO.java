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
* <p>Description:  VO relacionado a tabela [ECF_IMPRESSORA]</p>
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
@Table(name = "ECF_IMPRESSORA")
public class EcfImpressoraVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "IDENTIFICACAO")
    private String identificacao;
    @Column(name = "MC")
    private String mc;
    @Column(name = "MD")
    private String md;
    @Column(name = "VR")
    private String vr;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "MODELO_ACBR")
    private String modeloAcbr;
    @Column(name = "MODELO_DOCUMENTO_FISCAL")
    private String modeloDocumentoFiscal;
    @Column(name = "VERSAO")
    private String versao;
    @Column(name = "LE")
    private String le;
    @Column(name = "LEF")
    private String lef;
    @Column(name = "MFD")
    private String mfd;
    @Column(name = "LACRE_NA_MFD")
    private String lacreNaMfd;
    @Column(name = "DOCTO")
    private String docto;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_INSTALACAO_SB")
    private Date dataInstalacaoSb;
    @Column(name = "HORA_INSTALACAO_SB")
    private String horaInstalacaoSb;

    public EcfImpressoraVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getVr() {
        return vr;
    }

    public void setVr(String vr) {
        this.vr = vr;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModeloAcbr() {
        return modeloAcbr;
    }

    public void setModeloAcbr(String modeloAcbr) {
        this.modeloAcbr = modeloAcbr;
    }

    public String getModeloDocumentoFiscal() {
        return modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getLe() {
        return le;
    }

    public void setLe(String le) {
        this.le = le;
    }

    public String getLef() {
        return lef;
    }

    public void setLef(String lef) {
        this.lef = lef;
    }

    public String getMfd() {
        return mfd;
    }

    public void setMfd(String mfd) {
        this.mfd = mfd;
    }

    public String getLacreNaMfd() {
        return lacreNaMfd;
    }

    public void setLacreNaMfd(String lacreNaMfd) {
        this.lacreNaMfd = lacreNaMfd;
    }

    public String getDocto() {
        return docto;
    }

    public void setDocto(String docto) {
        this.docto = docto;
    }

    public Date getDataInstalacaoSb() {
        return dataInstalacaoSb;
    }

    public void setDataInstalacaoSb(Date dataInstalacaoSb) {
        this.dataInstalacaoSb = dataInstalacaoSb;
    }

    public String getHoraInstalacaoSb() {
        return horaInstalacaoSb;
    }

    public void setHoraInstalacaoSb(String horaInstalacaoSb) {
        this.horaInstalacaoSb = horaInstalacaoSb;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfImpressoraVO[id=" + id + "]";
    }

}
