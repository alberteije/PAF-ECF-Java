package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_MOVIMENTO]</p>
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
@Table(name = "ECF_MOVIMENTO")
@SequenceGenerator(name = "ECF_MOVIMENTO", sequenceName = "ECF_MOVIMENTO")
public class EcfMovimentoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ECF_MOVIMENTO")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
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
    @JoinColumn(name = "ID_ECF_CAIXA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfCaixaVO ecfCaixa;
    @JoinColumn(name = "ID_ECF_OPERADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfOperadorVO ecfOperador;
    @JoinColumn(name = "ID_ECF_TURNO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfTurnoVO ecfTurno;
    @JoinColumn(name = "ID_ECF_IMPRESSORA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfImpressoraVO ecfImpressora;
    @JoinColumn(name = "ID_ECF_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfEmpresaVO ecfEmpresa;

    public EcfMovimentoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public EcfCaixaVO getEcfCaixa() {
        return ecfCaixa;
    }

    public void setEcfCaixa(EcfCaixaVO ecfCaixa) {
        this.ecfCaixa = ecfCaixa;
    }

    public EcfOperadorVO getEcfOperador() {
        return ecfOperador;
    }

    public void setEcfOperador(EcfOperadorVO ecfOperador) {
        this.ecfOperador = ecfOperador;
    }

    public EcfTurnoVO getEcfTurno() {
        return ecfTurno;
    }

    public void setEcfTurno(EcfTurnoVO ecfTurno) {
        this.ecfTurno = ecfTurno;
    }

    public EcfImpressoraVO getEcfImpressora() {
        return ecfImpressora;
    }

    public void setEcfImpressora(EcfImpressoraVO ecfImpressora) {
        this.ecfImpressora = ecfImpressora;
    }

    public EcfEmpresaVO getEcfEmpresa() {
        return ecfEmpresa;
    }

    public void setEcfEmpresa(EcfEmpresaVO ecfEmpresa) {
        this.ecfEmpresa = ecfEmpresa;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfMovimentoVO[id=" + id + "]";
    }

}
