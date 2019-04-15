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

import java.util.Date;

public class RegistroR04 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String modeloEcf; // Modelo do ECF
    private Integer numeroUsuario; // Nº de ordem do usuário do ECF relativo à respectiva Redução Z
    private Integer numeroContador; // Nº do contador do respectivo documento emitido
    private Integer coo; // Nº do COO relativo ao respectivo documento
    private Date dataInicio; // Data de início da emissão do documento impressa no cabeçalho do documento
    private Double subtotalDocumento; // Valor total do documento, com duas casas decimais.
    private Double descontoSubtotal; // Valor do desconto ou Percentual aplicado sobre o valor do subtotal do documento, com duas casas decimais.
    private String indicadorTipoDesconto; // Informar “V” para valor monetário ou “P” para percentual
    private Double acrescimoSubtotal; // Valor do acréscimo ou Percentual aplicado sobre o valor do subtotal do documento, com duas casas decimais
    private String indicadorTipoAcrescimo; // Informar “V” para valor monetário ou “P” para percentual
    private Double valorTotalLiquido; // Valor total do Cupom Fiscal após desconto/acréscimo, com duas casas decimais.
    private String indicadorCancelamento; // Informar "S" ou "N", conforme tenha ocorrido ou não, o cancelamento do documento.
    private Double cancelamentoSubtotal; // Valor do cancelamento de acréscimo no subtotal
    private String ordemAplicacaoDescontoAcrescimo; // Indicador de ordem de aplicação de desconto/acréscimo em Subtotal. ‘D’ ou ‘A’ caso tenha ocorrido primeiro desconto ou acréscimo, respectivamente
    private String nomeCliente; // Nome do Cliente
    private String cnpjCpfAdquirente; // CPF ou CNPJ do adquirente

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
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the subtotalDocumento
     */
    public Double getSubtotalDocumento() {
        return subtotalDocumento;
    }

    /**
     * @param subtotalDocumento the subtotalDocumento to set
     */
    public void setSubtotalDocumento(Double subtotalDocumento) {
        this.subtotalDocumento = subtotalDocumento;
    }

    /**
     * @return the descontoSubtotal
     */
    public Double getDescontoSubtotal() {
        return descontoSubtotal;
    }

    /**
     * @param descontoSubtotal the descontoSubtotal to set
     */
    public void setDescontoSubtotal(Double descontoSubtotal) {
        this.descontoSubtotal = descontoSubtotal;
    }

    /**
     * @return the indicadorTipoDesconto
     */
    public String getIndicadorTipoDesconto() {
        return indicadorTipoDesconto;
    }

    /**
     * @param indicadorTipoDesconto the indicadorTipoDesconto to set
     */
    public void setIndicadorTipoDesconto(String indicadorTipoDesconto) {
        this.indicadorTipoDesconto = indicadorTipoDesconto;
    }

    /**
     * @return the acrescimoSubtotal
     */
    public Double getAcrescimoSubtotal() {
        return acrescimoSubtotal;
    }

    /**
     * @param acrescimoSubtotal the acrescimoSubtotal to set
     */
    public void setAcrescimoSubtotal(Double acrescimoSubtotal) {
        this.acrescimoSubtotal = acrescimoSubtotal;
    }

    /**
     * @return the indicadorTipoAcrescimo
     */
    public String getIndicadorTipoAcrescimo() {
        return indicadorTipoAcrescimo;
    }

    /**
     * @param indicadorTipoAcrescimo the indicadorTipoAcrescimo to set
     */
    public void setIndicadorTipoAcrescimo(String indicadorTipoAcrescimo) {
        this.indicadorTipoAcrescimo = indicadorTipoAcrescimo;
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
     * @return the cancelamentoSubtotal
     */
    public Double getCancelamentoSubtotal() {
        return cancelamentoSubtotal;
    }

    /**
     * @param cancelamentoSubtotal the cancelamentoSubtotal to set
     */
    public void setCancelamentoSubtotal(Double cancelamentoSubtotal) {
        this.cancelamentoSubtotal = cancelamentoSubtotal;
    }

    /**
     * @return the ordemAplicacaoDescontoAcrescimo
     */
    public String getOrdemAplicacaoDescontoAcrescimo() {
        return ordemAplicacaoDescontoAcrescimo;
    }

    /**
     * @param ordemAplicacaoDescontoAcrescimo the
     * ordemAplicacaoDescontoAcrescimo to set
     */
    public void setOrdemAplicacaoDescontoAcrescimo(String ordemAplicacaoDescontoAcrescimo) {
        this.ordemAplicacaoDescontoAcrescimo = ordemAplicacaoDescontoAcrescimo;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the cnpjCpfAdquirente
     */
    public String getCnpjCpfAdquirente() {
        return cnpjCpfAdquirente;
    }

    /**
     * @param cnpjCpfAdquirente the cnpjCpfAdquirente to set
     */
    public void setCnpjCpfAdquirente(String cnpjCpfAdquirente) {
        this.cnpjCpfAdquirente = cnpjCpfAdquirente;
    }
}
