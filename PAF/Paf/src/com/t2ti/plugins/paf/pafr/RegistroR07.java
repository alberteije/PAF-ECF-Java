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

public class RegistroR07 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String modeloEcf; // Modelo do ECF
    private Integer numeroUsuario; // Nº de ordem do usuário do ECF relativo à respectiva Redução Z
    private Integer coo; // Nº do COO relativo ao respectivo documento
    private Integer ccf; // Número do Contador de Cupom Fiscal relativo ao respectivo Cupom Fiscal emitido
    private Integer gnf; // Número do GNF relativo ao respectivo documento, quando houver
    private String meioPagamento; // Descrição do totalizador parcial de meio de pagamento
    private Double valorPago; // Valor do pagamento efetuado, com duas casas decimais
    private String indicadorEstorno; // Informar "S" ou "N", conforme tenha ocorrido ou não, o estorno do pagamento, ou “P” para estorno parcial do pagamento
    private Double valorEstornado; // Valor do estorno efetuado, com duas casas decimais

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
     * @return the ccf
     */
    public Integer getCcf() {
        return ccf;
    }

    /**
     * @param ccf the ccf to set
     */
    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    /**
     * @return the gnf
     */
    public Integer getGnf() {
        return gnf;
    }

    /**
     * @param gnf the gnf to set
     */
    public void setGnf(Integer gnf) {
        this.gnf = gnf;
    }

    /**
     * @return the meioPagamento
     */
    public String getMeioPagamento() {
        return meioPagamento;
    }

    /**
     * @param meioPagamento the meioPagamento to set
     */
    public void setMeioPagamento(String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    /**
     * @return the valorPago
     */
    public Double getValorPago() {
        return valorPago;
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    /**
     * @return the indicadorEstorno
     */
    public String getIndicadorEstorno() {
        return indicadorEstorno;
    }

    /**
     * @param indicadorEstorno the indicadorEstorno to set
     */
    public void setIndicadorEstorno(String indicadorEstorno) {
        this.indicadorEstorno = indicadorEstorno;
    }

    /**
     * @return the valorEstornado
     */
    public Double getValorEstornado() {
        return valorEstornado;
    }

    /**
     * @param valorEstornado the valorEstornado to set
     */
    public void setValorEstornado(Double valorEstornado) {
        this.valorEstornado = valorEstornado;
    }
}
