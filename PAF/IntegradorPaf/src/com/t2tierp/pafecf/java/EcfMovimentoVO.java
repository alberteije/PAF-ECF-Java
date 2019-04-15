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
@Table(name = "ECF_MOVIMENTO")
public class EcfMovimentoVO implements Serializable {

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
    @Column(name = "ID_ECF_EMPRESA")
    private Integer idEcfEmpresa;
    @Column(name = "ID_ECF_TURNO")
    private Integer idEcfTurno;
    @Column(name = "ID_ECF_IMPRESSORA")
    private Integer idEcfImpressora;
    @Column(name = "ID_ECF_OPERADOR")
    private Integer idEcfOperador;
    @Column(name = "ID_ECF_CAIXA")
    private Integer idEcfCaixa;
    @Column(name = "ID_GERENTE_SUPERVISOR")
    private Integer idGerenteSupervisor;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ABERTURA")
    private Date dataAbertura;
    @Column(name = "HORA_ABERTURA")
    private String horaAbertura;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_FECHAMENTO")
    private Date dataFechamento;
    @Column(name = "HORA_FECHAMENTO")
    private String horaFechamento;
    @Column(name = "TOTAL_SUPRIMENTO")
    private BigDecimal totalSuprimento;
    @Column(name = "TOTAL_SANGRIA")
    private BigDecimal totalSangria;
    @Column(name = "TOTAL_NAO_FISCAL")
    private BigDecimal totalNaoFiscal;
    @Column(name = "TOTAL_VENDA")
    private BigDecimal totalVenda;
    @Column(name = "TOTAL_DESCONTO")
    private BigDecimal totalDesconto;
    @Column(name = "TOTAL_ACRESCIMO")
    private BigDecimal totalAcrescimo;
    @Column(name = "TOTAL_FINAL")
    private BigDecimal totalFinal;
    @Column(name = "TOTAL_RECEBIDO")
    private BigDecimal totalRecebido;
    @Column(name = "TOTAL_TROCO")
    private BigDecimal totalTroco;
    @Column(name = "TOTAL_CANCELADO")
    private BigDecimal totalCancelado;
    @Column(name = "STATUS_MOVIMENTO")
    private String statusMovimento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SINCRONIZACAO")
    private Date dataSincronizacao;
    @Column(name = "HORA_SINCRONIZACAO")
    private String horaSincronizacao;
    @Transient
    private List<EcfFechamentoVO> listaEcfFechamento;
    @Transient
    private List<EcfSangriaVO> listaEcfSangria;
    @Transient
    private List<EcfSuprimentoVO> listaEcfSuprimento;

    public EcfMovimentoVO() {
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

    public Integer getIdEcfEmpresa() {
        return idEcfEmpresa;
    }

    public void setIdEcfEmpresa(Integer idEcfEmpresa) {
        this.idEcfEmpresa = idEcfEmpresa;
    }

    public Integer getIdEcfTurno() {
        return idEcfTurno;
    }

    public void setIdEcfTurno(Integer idEcfTurno) {
        this.idEcfTurno = idEcfTurno;
    }

    public Integer getIdEcfImpressora() {
        return idEcfImpressora;
    }

    public void setIdEcfImpressora(Integer idEcfImpressora) {
        this.idEcfImpressora = idEcfImpressora;
    }

    public Integer getIdEcfOperador() {
        return idEcfOperador;
    }

    public void setIdEcfOperador(Integer idEcfOperador) {
        this.idEcfOperador = idEcfOperador;
    }

    public Integer getIdEcfCaixa() {
        return idEcfCaixa;
    }

    public void setIdEcfCaixa(Integer idEcfCaixa) {
        this.idEcfCaixa = idEcfCaixa;
    }

    public Integer getIdGerenteSupervisor() {
        return idGerenteSupervisor;
    }

    public void setIdGerenteSupervisor(Integer idGerenteSupervisor) {
        this.idGerenteSupervisor = idGerenteSupervisor;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public BigDecimal getTotalSuprimento() {
        return totalSuprimento;
    }

    public void setTotalSuprimento(BigDecimal totalSuprimento) {
        this.totalSuprimento = totalSuprimento;
    }

    public BigDecimal getTotalSangria() {
        return totalSangria;
    }

    public void setTotalSangria(BigDecimal totalSangria) {
        this.totalSangria = totalSangria;
    }

    public BigDecimal getTotalNaoFiscal() {
        return totalNaoFiscal;
    }

    public void setTotalNaoFiscal(BigDecimal totalNaoFiscal) {
        this.totalNaoFiscal = totalNaoFiscal;
    }

    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    public BigDecimal getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public BigDecimal getTotalAcrescimo() {
        return totalAcrescimo;
    }

    public void setTotalAcrescimo(BigDecimal totalAcrescimo) {
        this.totalAcrescimo = totalAcrescimo;
    }

    public BigDecimal getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(BigDecimal totalFinal) {
        this.totalFinal = totalFinal;
    }

    public BigDecimal getTotalRecebido() {
        return totalRecebido;
    }

    public void setTotalRecebido(BigDecimal totalRecebido) {
        this.totalRecebido = totalRecebido;
    }

    public BigDecimal getTotalTroco() {
        return totalTroco;
    }

    public void setTotalTroco(BigDecimal totalTroco) {
        this.totalTroco = totalTroco;
    }

    public BigDecimal getTotalCancelado() {
        return totalCancelado;
    }

    public void setTotalCancelado(BigDecimal totalCancelado) {
        this.totalCancelado = totalCancelado;
    }

    public String getStatusMovimento() {
        return statusMovimento;
    }

    public void setStatusMovimento(String statusMovimento) {
        this.statusMovimento = statusMovimento;
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
        return "com.t2tierp.pafecf.java.EcfMovimentoVO[id=" + id + "]";
    }

    public List<EcfFechamentoVO> getListaEcfFechamento() {
        return listaEcfFechamento;
    }

    public void setListaEcfFechamento(List<EcfFechamentoVO> listaEcfFechamento) {
        this.listaEcfFechamento = listaEcfFechamento;
    }

    public List<EcfSangriaVO> getListaEcfSangria() {
        return listaEcfSangria;
    }

    public void setListaEcfSangria(List<EcfSangriaVO> listaEcfSangria) {
        this.listaEcfSangria = listaEcfSangria;
    }

    public List<EcfSuprimentoVO> getListaEcfSuprimento() {
        return listaEcfSuprimento;
    }

    public void setListaEcfSuprimento(List<EcfSuprimentoVO> listaEcfSuprimento) {
        this.listaEcfSuprimento = listaEcfSuprimento;
    }

}
