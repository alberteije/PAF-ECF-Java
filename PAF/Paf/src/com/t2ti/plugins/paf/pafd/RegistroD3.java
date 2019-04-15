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
package com.t2ti.plugins.paf.pafd;

import java.util.Date;

public class RegistroD3 {

    private String numeroDav; // Número do DAV emitido
    private Date dataInclusao;
    private String numeroItem;
    private String codigoProduto;
    private String descricaoProduto;
    private Double quantidade;
    private String unidade;
    private Double valorUnitario;
    private Double valorDesconto;
    private Double valorAcrescimo;
    private Double valorTotalLiquido;
    private String situacaoTributaria;
    private Double aliquota;
    private String indicadorCancelamento;
    private Integer casasDecimaisQuantidade;
    private Integer casasDecimaisValorUnitario;

    /**
     * @return the numeroDav
     */
    public String getNumeroDav() {
        return numeroDav;
    }

    /**
     * @param numeroDav the numeroDav to set
     */
    public void setNumeroDav(String numeroDav) {
        this.numeroDav = numeroDav;
    }

    /**
     * @return the dataInclusao
     */
    public Date getDataInclusao() {
        return dataInclusao;
    }

    /**
     * @param dataInclusao the dataInclusao to set
     */
    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    /**
     * @return the numeroItem
     */
    public String getNumeroItem() {
        return numeroItem;
    }

    /**
     * @param numeroItem the numeroItem to set
     */
    public void setNumeroItem(String numeroItem) {
        this.numeroItem = numeroItem;
    }

    /**
     * @return the codigoProduto
     */
    public String getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorDesconto
     */
    public Double getValorDesconto() {
        return valorDesconto;
    }

    /**
     * @param valorDesconto the valorDesconto to set
     */
    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    /**
     * @return the valorAcrescimo
     */
    public Double getValorAcrescimo() {
        return valorAcrescimo;
    }

    /**
     * @param valorAcrescimo the valorAcrescimo to set
     */
    public void setValorAcrescimo(Double valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    /**
     * @return the valorTotalLiquido
     */
    public Double getValorTotalLiquido() {
        return valorTotalLiquido;
    }

    /**
     * @param valorTotalLiquido the valorTotalLiquido to set
     */
    public void setValorTotalLiquido(Double valorTotalLiquido) {
        this.valorTotalLiquido = valorTotalLiquido;
    }

    /**
     * @return the situacaoTributaria
     */
    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    /**
     * @param situacaoTributaria the situacaoTributaria to set
     */
    public void setSituacaoTributaria(String situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    /**
     * @return the aliquota
     */
    public Double getAliquota() {
        return aliquota;
    }

    /**
     * @param aliquota the aliquota to set
     */
    public void setAliquota(Double aliquota) {
        this.aliquota = aliquota;
    }

    /**
     * @return the indicadorCancelamento
     */
    public String getIndicadorCancelamento() {
        return indicadorCancelamento;
    }

    /**
     * @param indicadorCancelamento the indicadorCancelamento to set
     */
    public void setIndicadorCancelamento(String indicadorCancelamento) {
        this.indicadorCancelamento = indicadorCancelamento;
    }

    /**
     * @return the casasDecimaisQuantidade
     */
    public Integer getCasasDecimaisQuantidade() {
        return casasDecimaisQuantidade;
    }

    /**
     * @param casasDecimaisQuantidade the casasDecimaisQuantidade to set
     */
    public void setCasasDecimaisQuantidade(Integer casasDecimaisQuantidade) {
        this.casasDecimaisQuantidade = casasDecimaisQuantidade;
    }

    /**
     * @return the casasDecimaisValorUnitario
     */
    public Integer getCasasDecimaisValorUnitario() {
        return casasDecimaisValorUnitario;
    }

    /**
     * @param casasDecimaisValorUnitario the casasDecimaisValorUnitario to set
     */
    public void setCasasDecimaisValorUnitario(Integer casasDecimaisValorUnitario) {
        this.casasDecimaisValorUnitario = casasDecimaisValorUnitario;
    }
}
