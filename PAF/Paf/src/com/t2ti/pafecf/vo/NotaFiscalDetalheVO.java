package com.t2ti.pafecf.vo;

import com.t2ti.pafecf.infra.ColunaGrid;
import java.io.Serializable;
import java.math.BigDecimal;
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


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [NOTA_FISCAL_DETALHE]</p>
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
@Table(name = "NOTA_FISCAL_DETALHE")
@SequenceGenerator(name = "NOTA_FISCAL_DETALHE", sequenceName = "NOTA_FISCAL_DETALHE")
public class NotaFiscalDetalheVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTA_FISCAL_DETALHE")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CFOP")
    private Integer cfop;
    @Column(name = "ITEM")
    private Integer item;
    @Column(name = "QUANTIDADE")
    @ColunaGrid(nome = "Quantidade")
    private BigDecimal quantidade;
    @Column(name = "VALOR_UNITARIO")
    @ColunaGrid(nome = "Valor Unitário")
    private BigDecimal valorUnitario;
    @Column(name = "VALOR_TOTAL")
    @ColunaGrid(nome = "Valor Total")
    private BigDecimal valorTotal;
    @Column(name = "BASE_ICMS")
    private BigDecimal baseIcms;
    @Column(name = "TAXA_ICMS")
    private BigDecimal taxaIcms;
    @Column(name = "ICMS")
    private BigDecimal icms;
    @Column(name = "ICMS_OUTRAS")
    private BigDecimal icmsOutras;
    @Column(name = "ICMS_ISENTO")
    private BigDecimal icmsIsento;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "TAXA_ISSQN")
    private BigDecimal taxaIssqn;
    @Column(name = "ISSQN")
    private BigDecimal issqn;
    @Column(name = "TAXA_PIS")
    private BigDecimal taxaPis;
    @Column(name = "PIS")
    private BigDecimal pis;
    @Column(name = "TAXA_COFINS")
    private BigDecimal taxaCofins;
    @Column(name = "COFINS")
    private BigDecimal cofins;
    @Column(name = "TAXA_ACRESCIMO")
    private BigDecimal taxaAcrescimo;
    @Column(name = "ACRESCIMO")
    private BigDecimal acrescimo;
    @Column(name = "TAXA_IPI")
    private BigDecimal taxaIpi;
    @Column(name = "IPI")
    private BigDecimal ipi;
    @Column(name = "CANCELADO")
    private String cancelado;
    @Column(name = "CST")
    private String cst;
    @Column(name = "MOVIMENTA_ESTOQUE")
    private String movimentaEstoque;
    @Column(name = "ECF_ICMS_ST")
    private String ecfIcmsSt;
    @JoinColumn(name = "ID_NF_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NotaFiscalCabecalhoVO notaFiscalCabecalho;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @ColunaGrid(nome = "Nome Produto", metodoGet = "getProduto.getDescricaoPdv")
    private ProdutoVO produto;

    public NotaFiscalDetalheVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getBaseIcms() {
        return baseIcms;
    }

    public void setBaseIcms(BigDecimal baseIcms) {
        this.baseIcms = baseIcms;
    }

    public BigDecimal getTaxaIcms() {
        return taxaIcms;
    }

    public void setTaxaIcms(BigDecimal taxaIcms) {
        this.taxaIcms = taxaIcms;
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

    public BigDecimal getIcmsIsento() {
        return icmsIsento;
    }

    public void setIcmsIsento(BigDecimal icmsIsento) {
        this.icmsIsento = icmsIsento;
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

    public BigDecimal getTaxaIssqn() {
        return taxaIssqn;
    }

    public void setTaxaIssqn(BigDecimal taxaIssqn) {
        this.taxaIssqn = taxaIssqn;
    }

    public BigDecimal getIssqn() {
        return issqn;
    }

    public void setIssqn(BigDecimal issqn) {
        this.issqn = issqn;
    }

    public BigDecimal getTaxaPis() {
        return taxaPis;
    }

    public void setTaxaPis(BigDecimal taxaPis) {
        this.taxaPis = taxaPis;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public void setPis(BigDecimal pis) {
        this.pis = pis;
    }

    public BigDecimal getTaxaCofins() {
        return taxaCofins;
    }

    public void setTaxaCofins(BigDecimal taxaCofins) {
        this.taxaCofins = taxaCofins;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public void setCofins(BigDecimal cofins) {
        this.cofins = cofins;
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

    public BigDecimal getTaxaIpi() {
        return taxaIpi;
    }

    public void setTaxaIpi(BigDecimal taxaIpi) {
        this.taxaIpi = taxaIpi;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public String getCancelado() {
        return cancelado;
    }

    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getMovimentaEstoque() {
        return movimentaEstoque;
    }

    public void setMovimentaEstoque(String movimentaEstoque) {
        this.movimentaEstoque = movimentaEstoque;
    }

    public String getEcfIcmsSt() {
        return ecfIcmsSt;
    }

    public void setEcfIcmsSt(String ecfIcmsSt) {
        this.ecfIcmsSt = ecfIcmsSt;
    }

    public NotaFiscalCabecalhoVO getNotaFiscalCabecalho() {
        return notaFiscalCabecalho;
    }

    public void setNotaFiscalCabecalho(NotaFiscalCabecalhoVO notaFiscalCabecalho) {
        this.notaFiscalCabecalho = notaFiscalCabecalho;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.NotaFiscalDetalheVO[id=" + id + "]";
    }

}
