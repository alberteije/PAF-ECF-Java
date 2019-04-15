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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [CONTAS_PAGAR_RECEBER]</p>
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
@Table(name = "CONTAS_PAGAR_RECEBER")
public class ContasPagarReceberVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_PLANO_CONTAS")
    private Integer idPlanoContas;
    @Column(name = "ID_TIPO_DOCUMENTO")
    private Integer idTipoDocumento;
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;
    @Temporal(TemporalType.DATE)
    @Column(name = "PRIMEIRO_VENCIMENTO")
    private Date primeiroVencimento;
    @Column(name = "NATUREZA_LANCAMENTO")
    private String naturezaLancamento;
    @Column(name = "QUANTIDADE_PARCELA")
    private Integer quantidadeParcela;
    @Column(name = "CODIGO_TIPO_PAGAMENTO")
    private String codigoTipoPagamento;
    @JoinColumn(name = "ID_ECF_VENDA_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfVendaCabecalhoVO ecfVendaCabecalho;

    public ContasPagarReceberVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPlanoContas() {
        return idPlanoContas;
    }

    public void setIdPlanoContas(Integer idPlanoContas) {
        this.idPlanoContas = idPlanoContas;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getPrimeiroVencimento() {
        return primeiroVencimento;
    }

    public void setPrimeiroVencimento(Date primeiroVencimento) {
        this.primeiroVencimento = primeiroVencimento;
    }

    public String getNaturezaLancamento() {
        return naturezaLancamento;
    }

    public void setNaturezaLancamento(String naturezaLancamento) {
        this.naturezaLancamento = naturezaLancamento;
    }

    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }

    public String getCodigoTipoPagamento() {
        return codigoTipoPagamento;
    }

    public void setCodigoTipoPagamento(String codigoTipoPagamento) {
        this.codigoTipoPagamento = codigoTipoPagamento;
    }

    public EcfVendaCabecalhoVO getEcfVendaCabecalho() {
        return ecfVendaCabecalho;
    }

    public void setEcfVendaCabecalho(EcfVendaCabecalhoVO ecfVendaCabecalho) {
        this.ecfVendaCabecalho = ecfVendaCabecalho;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.ContasPagarReceberVO[id=" + id + "]";
    }

}
