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
@Table(name = "ECF_VENDA_CABECALHO")
public class EcfVendaCabecalhoVO implements Serializable {

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
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Column(name = "ID_ECF_FUNCIONARIO")
    private Integer idEcfFuncionario;
    @Column(name = "ID_ECF_MOVIMENTO")
    private Integer idEcfMovimento;
    @Column(name = "ID_ECF_DAV")
    private Integer idEcfDav;
    @Column(name = "ID_ECF_PRE_VENDA_CABECALHO")
    private Integer idEcfPreVendaCabecalho;
    @Column(name = "SERIE_ECF")
    private String serieEcf;
    @Column(name = "CFOP")
    private Integer cfop;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "CCF")
    private Integer ccf;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_VENDA")
    private Date dataVenda;
    @Column(name = "HORA_VENDA")
    private String horaVenda;
    @Column(name = "VALOR_VENDA")
    private BigDecimal valorVenda;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "TAXA_ACRESCIMO")
    private BigDecimal taxaAcrescimo;
    @Column(name = "ACRESCIMO")
    private BigDecimal acrescimo;
    @Column(name = "VALOR_FINAL")
    private BigDecimal valorFinal;
    @Column(name = "VALOR_RECEBIDO")
    private BigDecimal valorRecebido;
    @Column(name = "TROCO")
    private BigDecimal troco;
    @Column(name = "VALOR_CANCELADO")
    private BigDecimal valorCancelado;
    @Column(name = "TOTAL_PRODUTOS")
    private BigDecimal totalProdutos;
    @Column(name = "TOTAL_DOCUMENTO")
    private BigDecimal totalDocumento;
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
    @Column(name = "ACRESCIMO_ITENS")
    private BigDecimal acrescimoItens;
    @Column(name = "DESCONTO_ITENS")
    private BigDecimal descontoItens;
    @Column(name = "STATUS_VENDA")
    private String statusVenda;
    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;
    @Column(name = "CPF_CNPJ_CLIENTE")
    private String cpfCnpjCliente;
    @Column(name = "CUPOM_CANCELADO")
    private String cupomCancelado;
    @Column(name = "LOGSS")
    private String logss;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SINCRONIZACAO")
    private Date dataSincronizacao;
    @Column(name = "HORA_SINCRONIZACAO")
    private String horaSincronizacao;
    @Transient
    private EcfMovimentoVO ecfMovimento;
    @Transient
    private List<EcfVendaDetalheVO> listaEcfVendaDetalhe;
    @Transient
    private List<EcfTotalTipoPagamentoVO> listaEcfTotalTipoPagamento;

    public EcfVendaCabecalhoVO() {
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEcfFuncionario() {
        return idEcfFuncionario;
    }

    public void setIdEcfFuncionario(Integer idEcfFuncionario) {
        this.idEcfFuncionario = idEcfFuncionario;
    }

    public Integer getIdEcfMovimento() {
        return idEcfMovimento;
    }

    public void setIdEcfMovimento(Integer idEcfMovimento) {
        this.idEcfMovimento = idEcfMovimento;
    }

    public Integer getIdEcfDav() {
        return idEcfDav;
    }

    public void setIdEcfDav(Integer idEcfDav) {
        this.idEcfDav = idEcfDav;
    }

    public Integer getIdEcfPreVendaCabecalho() {
        return idEcfPreVendaCabecalho;
    }

    public void setIdEcfPreVendaCabecalho(Integer idEcfPreVendaCabecalho) {
        this.idEcfPreVendaCabecalho = idEcfPreVendaCabecalho;
    }

    public String getSerieEcf() {
        return serieEcf;
    }

    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
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

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(BigDecimal valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public BigDecimal getValorCancelado() {
        return valorCancelado;
    }

    public void setValorCancelado(BigDecimal valorCancelado) {
        this.valorCancelado = valorCancelado;
    }

    public BigDecimal getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(BigDecimal totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public BigDecimal getTotalDocumento() {
        return totalDocumento;
    }

    public void setTotalDocumento(BigDecimal totalDocumento) {
        this.totalDocumento = totalDocumento;
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

    public BigDecimal getAcrescimoItens() {
        return acrescimoItens;
    }

    public void setAcrescimoItens(BigDecimal acrescimoItens) {
        this.acrescimoItens = acrescimoItens;
    }

    public BigDecimal getDescontoItens() {
        return descontoItens;
    }

    public void setDescontoItens(BigDecimal descontoItens) {
        this.descontoItens = descontoItens;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public String getCupomCancelado() {
        return cupomCancelado;
    }

    public void setCupomCancelado(String cupomCancelado) {
        this.cupomCancelado = cupomCancelado;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
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
        return "com.t2tierp.pafecf.java.EcfVendaCabecalhoVO[id=" + id + "]";
    }

    public EcfMovimentoVO getEcfMovimento() {
        return ecfMovimento;
    }

    public void setEcfMovimento(EcfMovimentoVO ecfMovimento) {
        this.ecfMovimento = ecfMovimento;
    }

    public List<EcfVendaDetalheVO> getListaEcfVendaDetalhe() {
        return listaEcfVendaDetalhe;
    }

    public void setListaEcfVendaDetalhe(List<EcfVendaDetalheVO> listaEcfVendaDetalhe) {
        this.listaEcfVendaDetalhe = listaEcfVendaDetalhe;
    }

    public List<EcfTotalTipoPagamentoVO> getListaEcfTotalTipoPagamento() {
        return listaEcfTotalTipoPagamento;
    }

    public void setListaEcfTotalTipoPagamento(List<EcfTotalTipoPagamentoVO> listaEcfTotalTipoPagamento) {
        this.listaEcfTotalTipoPagamento = listaEcfTotalTipoPagamento;
    }

}
