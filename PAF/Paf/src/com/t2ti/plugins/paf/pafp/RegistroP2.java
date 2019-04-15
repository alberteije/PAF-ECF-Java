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
package com.t2ti.plugins.paf.pafp;

public class RegistroP2 {

    private String cnpj; // CNPJ do estabelecimento usuário do PAF-ECF
    private String codigoMercadoria; // Código da mercadoria ou produto cadastrado na tabela a que se refere o requisito XI
    private String descricaoMercadoria; // Descrição da mercadoria ou produto cadastrada na tabela a que se refere o requisito XI
    private String unidadeMedida; // Unidade de medida cadastrada na tabela a que se refere o requisito XI
    private String iat; // Indicador de Arredondamento ou Truncamento, conforme item 7.2.1.3
    private String ippt; // Indicador de Produção Própria ou de Terceiro, conforme item 7.2.1.4
    private String situacaoTributaria; // Código da Situação Tributaria conforme tabela constante no item 7.2.1.5
    private Double Aliquota; //Alíquota, conforme item 7.2.1.6
    private Double valorUnitario; //Valor unitário com duas casas decimais

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the codigoMercadoria
     */
    public String getCodigoMercadoria() {
        return codigoMercadoria;
    }

    /**
     * @param codigoMercadoria the codigoMercadoria to set
     */
    public void setCodigoMercadoria(String codigoMercadoria) {
        this.codigoMercadoria = codigoMercadoria;
    }

    /**
     * @return the descricaoMercadoria
     */
    public String getDescricaoMercadoria() {
        return descricaoMercadoria;
    }

    /**
     * @param descricaoMercadoria the descricaoMercadoria to set
     */
    public void setDescricaoMercadoria(String descricaoMercadoria) {
        this.descricaoMercadoria = descricaoMercadoria;
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
     * @return the Aliquota
     */
    public Double getAliquota() {
        return Aliquota;
    }

    /**
     * @param Aliquota the Aliquota to set
     */
    public void setAliquota(Double Aliquota) {
        this.Aliquota = Aliquota;
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

}
