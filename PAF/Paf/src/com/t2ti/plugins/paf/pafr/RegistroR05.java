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
package com.t2ti.plugins.paf.pafr;

public class RegistroR05 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String modeloEcf; // Modelo do ECF
    private Integer numeroUsuario; // Nº de ordem do usuário do ECF relativo à respectiva Redução Z
    private Integer coo; // Nº do COO relativo ao respectivo documento
    private Integer numeroContador; // Nº do contador do respectivo documento emitido
    private Integer numeroItem; // Número do item registrado no documento
    private String codigoProduto; // Código do produto ou serviço registrado no documento
    private String descricaoProduto; // Descrição do produto ou serviço constante no Cupom Fiscal
    private Double quantidadeProduto; // Quantidade comercializada, sem a separação das casas decimais
    private String unidadeMedida; // Unidade de medida
    private Double valorUnitario; // Valor unitário do produto ou serviço, sem a separação das casas decimais.
    private Double descontoSobreItem; // Valor do desconto incidente sobre o valor do item, com duas casas decimais.
    private Double acrescimoSobreItem; // Valor do acréscimo incidente sobre o valor do item, com duas casas decimais.
    private Double valorTotalLiquido; // Valor total líquido do item, com duas casas decimais.
    private String totalizadorParcial; // Código do totalizador relativo ao produto ou serviço conforme tabela abaixo.
    private String indicadorCancelamento; // Informar "S" ou "N", conforme tenha ocorrido ou não, o cancelamento total do item no documento. Informar "P" quando ocorrer o cancelamento parcial do item.
    private Double quantidadeCancelada; // Quantidade cancelada, no caso de cancelamento parcial de item, sem a separação das casas decimais.
    private Double valorCancelado; // Valor cancelado, no caso de cancelamento parcial de item
    private Double cancelamentoAcrescimoItem; // Valor do cancelamento de acréscimo no item
    private String iat; // Indicador de Arredondamento ou Truncamento relativo à regra de cálculo do valor total líquido do item, sendo “T” para truncamento ou “A” para arredondamento
    private String ippt; // Indicador de Produção Própria ou de Terceiro relativo à mercadoria, sendo “P” para mercadoria de produção própria ou “T” para mercadoria produzida por terceiros
    private Integer casasDecimaisQuantidade; // Parâmetro de número de casas decimais da quantidade
    private Integer casasDecimaisValorUnitario; // Parâmetro de número de casas decimais de valor unitário

    /**
     * @return the numeroFabricacao
     */
    public String getNumeroFabricacao() {
        return numeroFabricacao;
    }

    /**
     * @param numeroFabricacao the numeroFabricacao to set
     */
    public void setNumeroFabricacao(String numeroFabricacao) {
        this.numeroFabricacao = numeroFabricacao;
    }

    /**
     * @return the mfAdicional
     */
    public String getMfAdicional() {
        return mfAdicional;
    }

    /**
     * @param mfAdicional the mfAdicional to set
     */
    public void setMfAdicional(String mfAdicional) {
        this.mfAdicional = mfAdicional;
    }

    /**
     * @return the modeloEcf
     */
    public String getModeloEcf() {
        return modeloEcf;
    }

    /**
     * @param modeloEcf the modeloEcf to set
     */
    public void setModeloEcf(String modeloEcf) {
        this.modeloEcf = modeloEcf;
    }

    /**
     * @return the numeroUsuario
     */
    public Integer getNumeroUsuario() {
        return numeroUsuario;
    }

    /**
     * @param numeroUsuario the numeroUsuario to set
     */
    public void setNumeroUsuario(Integer numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return the coo
     */
    public Integer getCoo() {
        return coo;
    }

    /**
     * @param coo the coo to set
     */
    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    /**
     * @return the numeroContador
     */
    public Integer getNumeroContador() {
        return numeroContador;
    }

    /**
     * @param numeroContador the numeroContador to set
     */
    public void setNumeroContador(Integer numeroContador) {
        this.numeroContador = numeroContador;
    }

    /**
     * @return the numeroItem
     */
    public Integer getNumeroItem() {
        return numeroItem;
    }

    /**
     * @param numeroItem the numeroItem to set
     */
    public void setNumeroItem(Integer numeroItem) {
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
     * @return the quantidadeProduto
     */
    public Double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public void setQuantidadeProduto(Double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    /**
     * @return the unidadeMedida
     */
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
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
     * @return the descontoSobreItem
     */
    public Double getDescontoSobreItem() {
        return descontoSobreItem;
    }

    /**
     * @param descontoSobreItem the descontoSobreItem to set
     */
    public void setDescontoSobreItem(Double descontoSobreItem) {
        this.descontoSobreItem = descontoSobreItem;
    }

    /**
     * @return the acrescimoSobreItem
     */
    public Double getAcrescimoSobreItem() {
        return acrescimoSobreItem;
    }

    /**
     * @param acrescimoSobreItem the acrescimoSobreItem to set
     */
    public void setAcrescimoSobreItem(Double acrescimoSobreItem) {
        this.acrescimoSobreItem = acrescimoSobreItem;
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
     * @return the totalizadorParcial
     */
    public String getTotalizadorParcial() {
        return totalizadorParcial;
    }

    /**
     * @param totalizadorParcial the totalizadorParcial to set
     */
    public void setTotalizadorParcial(String totalizadorParcial) {
        this.totalizadorParcial = totalizadorParcial;
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
     * @return the quantidadeCancelada
     */
    public Double getQuantidadeCancelada() {
        return quantidadeCancelada;
    }

    /**
     * @param quantidadeCancelada the quantidadeCancelada to set
     */
    public void setQuantidadeCancelada(Double quantidadeCancelada) {
        this.quantidadeCancelada = quantidadeCancelada;
    }

    /**
     * @return the valorCancelado
     */
    public Double getValorCancelado() {
        return valorCancelado;
    }

    /**
     * @param valorCancelado the valorCancelado to set
     */
    public void setValorCancelado(Double valorCancelado) {
        this.valorCancelado = valorCancelado;
    }

    /**
     * @return the cancelamentoAcrescimoItem
     */
    public Double getCancelamentoAcrescimoItem() {
        return cancelamentoAcrescimoItem;
    }

    /**
     * @param cancelamentoAcrescimoItem the cancelamentoAcrescimoItem to set
     */
    public void setCancelamentoAcrescimoItem(Double cancelamentoAcrescimoItem) {
        this.cancelamentoAcrescimoItem = cancelamentoAcrescimoItem;
    }

    /**
     * @return the iat
     */
    public String getIat() {
        return iat;
    }

    /**
     * @param iat the iat to set
     */
    public void setIat(String iat) {
        this.iat = iat;
    }

    /**
     * @return the ippt
     */
    public String getIppt() {
        return ippt;
    }

    /**
     * @param ippt the ippt to set
     */
    public void setIppt(String ippt) {
        this.ippt = ippt;
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
