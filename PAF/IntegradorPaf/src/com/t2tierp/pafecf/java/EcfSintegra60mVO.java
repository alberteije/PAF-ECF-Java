/*
 * The MIT License
 * 
 * Copyright: Copyright (C) 2014 T2Ti.COM
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 *
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.t2tierp.pafecf.java;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "ECF_SINTEGRA_60M")
public class EcfSintegra60mVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME_CAIXA")
    private String nomeCaixa;
    @Column(name = "ID_GERADO_CAIXA")
    private Integer idGeradoCaixa;
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_EMISSAO")
    private Date dataEmissao;
    @Column(name = "NUMERO_SERIE_ECF")
    private String numeroSerieEcf;
    @Column(name = "NUMERO_EQUIPAMENTO")
    private Integer numeroEquipamento;
    @Column(name = "MODELO_DOCUMENTO_FISCAL")
    private String modeloDocumentoFiscal;
    @Column(name = "COO_INICIAL")
    private Integer cooInicial;
    @Column(name = "COO_FINAL")
    private Integer cooFinal;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "CRO")
    private Integer cro;
    @Column(name = "VALOR_VENDA_BRUTA")
    private BigDecimal valorVendaBruta;
    @Column(name = "VALOR_GRANDE_TOTAL")
    private BigDecimal valorGrandeTotal;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SINCRONIZACAO")
    private Date dataSincronizacao;
    @Column(name = "HORA_SINCRONIZACAO")
    private String horaSincronizacao;
    @Transient
    private List<EcfSintegra60aVO> listaSintegra60a;

    public EcfSintegra60mVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCaixa() {
        return nomeCaixa;
    }

    public void setNomeCaixa(String nomeCaixa) {
        this.nomeCaixa = nomeCaixa;
    }

    public Integer getIdGeradoCaixa() {
        return idGeradoCaixa;
    }

    public void setIdGeradoCaixa(Integer idGeradoCaixa) {
        this.idGeradoCaixa = idGeradoCaixa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNumeroSerieEcf() {
        return numeroSerieEcf;
    }

    public void setNumeroSerieEcf(String numeroSerieEcf) {
        this.numeroSerieEcf = numeroSerieEcf;
    }

    public Integer getNumeroEquipamento() {
        return numeroEquipamento;
    }

    public void setNumeroEquipamento(Integer numeroEquipamento) {
        this.numeroEquipamento = numeroEquipamento;
    }

    public String getModeloDocumentoFiscal() {
        return modeloDocumentoFiscal;
    }

    public void setModeloDocumentoFiscal(String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    public Integer getCooInicial() {
        return cooInicial;
    }

    public void setCooInicial(Integer cooInicial) {
        this.cooInicial = cooInicial;
    }

    public Integer getCooFinal() {
        return cooFinal;
    }

    public void setCooFinal(Integer cooFinal) {
        this.cooFinal = cooFinal;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public Integer getCro() {
        return cro;
    }

    public void setCro(Integer cro) {
        this.cro = cro;
    }

    public BigDecimal getValorVendaBruta() {
        return valorVendaBruta;
    }

    public void setValorVendaBruta(BigDecimal valorVendaBruta) {
        this.valorVendaBruta = valorVendaBruta;
    }

    public BigDecimal getValorGrandeTotal() {
        return valorGrandeTotal;
    }

    public void setValorGrandeTotal(BigDecimal valorGrandeTotal) {
        this.valorGrandeTotal = valorGrandeTotal;
    }

    public Date getDataSincronizacao() {
        return dataSincronizacao;
    }

    public void setDataSincronizacao(Date dataSincronizacao) {
        this.dataSincronizacao = dataSincronizacao;
    }

    public String getHoraSincronizacao() {
        return horaSincronizacao;
    }

    public void setHoraSincronizacao(String horaSincronizacao) {
        this.horaSincronizacao = horaSincronizacao;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfSintegra60mVO[id=" + id + "]";
    }

    public List<EcfSintegra60aVO> getListaSintegra60a() {
        return listaSintegra60a;
    }

    public void setListaSintegra60a(List<EcfSintegra60aVO> listaSintegra60a) {
        this.listaSintegra60a = listaSintegra60a;
    }

}
