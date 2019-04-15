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
@Table(name = "ECF_NOTA_FISCAL_CABECALHO")
public class EcfNotaFiscalCabecalhoVO implements Serializable {

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
    @Column(name = "ID_ECF_FUNCIONARIO")
    private Integer idEcfFuncionario;
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Column(name = "CPF_CNPJ_CLIENTE")
    private String cpfCnpjCliente;
    @Column(name = "CFOP")
    private Integer cfop;
    @Column(name = "NUMERO")
    private String numero;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_EMISSAO")
    private Date dataEmissao;
    @Column(name = "HORA_EMISSAO")
    private String horaEmissao;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "SUBSERIE")
    private String subserie;
    @Column(name = "TOTAL_PRODUTOS")
    private BigDecimal totalProdutos;
    @Column(name = "TOTAL_NF")
    private BigDecimal totalNf;
    @Column(name = "BASE_ICMS")
    private BigDecimal baseIcms;
    @Column(name = "ICMS")
    private BigDecimal icms;
    @Column(name = "ICMS_OUTRAS")
    private BigDecimal icmsOutras;
    @Column(name = "ISSQN")
    private BigDecimal issqn;
    @Column(name = "PIS")
    private BigDecimal pis;
    @Column(name = "COFINS")
    private BigDecimal cofins;
    @Column(name = "IPI")
    private BigDecimal ipi;
    @Column(name = "TAXA_ACRESCIMO")
    private BigDecimal taxaAcrescimo;
    @Column(name = "ACRESCIMO")
    private BigDecimal acrescimo;
    @Column(name = "ACRESCIMO_ITENS")
    private BigDecimal acrescimoItens;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "DESCONTO_ITENS")
    private BigDecimal descontoItens;
    @Column(name = "CANCELADA")
    private String cancelada;
    @Column(name = "TIPO_NOTA")
    private String tipoNota;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SINCRONIZACAO")
    private Date dataSincronizacao;
    @Column(name = "HORA_SINCRONIZACAO")
    private String horaSincronizacao;
    @Transient
    private List<EcfNotaFiscalDetalheVO> listaNotaFiscalDetalhe;

    public EcfNotaFiscalCabecalhoVO() {
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

    public Integer getIdEcfFuncionario() {
        return idEcfFuncionario;
    }

    public void setIdEcfFuncionario(Integer idEcfFuncionario) {
        this.idEcfFuncionario = idEcfFuncionario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSubserie() {
        return subserie;
    }

    public void setSubserie(String subserie) {
        this.subserie = subserie;
    }

    public BigDecimal getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(BigDecimal totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public BigDecimal getTotalNf() {
        return totalNf;
    }

    public void setTotalNf(BigDecimal totalNf) {
        this.totalNf = totalNf;
    }

    public BigDecimal getBaseIcms() {
        return baseIcms;
    }

    public void setBaseIcms(BigDecimal baseIcms) {
        this.baseIcms = baseIcms;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    public BigDecimal getIcmsOutras() {
        return icmsOutras;
    }

    public void setIcmsOutras(BigDecimal icmsOutras) {
        this.icmsOutras = icmsOutras;
    }

    public BigDecimal getIssqn() {
        return issqn;
    }

    public void setIssqn(BigDecimal issqn) {
        this.issqn = issqn;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public void setPis(BigDecimal pis) {
        this.pis = pis;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public void setCofins(BigDecimal cofins) {
        this.cofins = cofins;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public BigDecimal getTaxaAcrescimo() {
        return taxaAcrescimo;
    }

    public void setTaxaAcrescimo(BigDecimal taxaAcrescimo) {
        this.taxaAcrescimo = taxaAcrescimo;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public BigDecimal getAcrescimoItens() {
        return acrescimoItens;
    }

    public void setAcrescimoItens(BigDecimal acrescimoItens) {
        this.acrescimoItens = acrescimoItens;
    }

    public BigDecimal getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(BigDecimal taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getDescontoItens() {
        return descontoItens;
    }

    public void setDescontoItens(BigDecimal descontoItens) {
        this.descontoItens = descontoItens;
    }

    public String getCancelada() {
        return cancelada;
    }

    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
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
        return "com.t2tierp.pafecf.java.EcfNotaFiscalCabecalhoVO[id=" + id + "]";
    }

    public List<EcfNotaFiscalDetalheVO> getListaNotaFiscalDetalhe() {
        return listaNotaFiscalDetalhe;
    }

    public void setListaNotaFiscalDetalhe(List<EcfNotaFiscalDetalheVO> listaNotaFiscalDetalhe) {
        this.listaNotaFiscalDetalhe = listaNotaFiscalDetalhe;
    }

}
