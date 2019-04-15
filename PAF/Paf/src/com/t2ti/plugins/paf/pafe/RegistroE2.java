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
package com.t2ti.plugins.paf.pafe;

public class RegistroE2 {

    private String cnpj; // CNPJ do estabelecimento usuário do PAF-ECF
    private String codigoMercadoria; // Código da mercadoria ou produto cadastrado na tabela a que se refere o requisito XI
    private String descricaoMercadoria; // Descrição da mercadoria ou produto cadastrada na tabela a que se refere o requisito XI
    private String unidadeMedida; // Unidade de medida cadastrada na tabela a que se refere o requisito XI
    private String mensuracaoEstoque; // Unidade de medida cadastrada na tabela a que se refere o requisito XI
    private Double quantidadeEstoque; // Quantidade da mercadoria ou produto constante no estoque, com duas casas decimais.

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
     * @return the mensuracaoEstoque
     */
    public String getMensuracaoEstoque() {
        return mensuracaoEstoque;
    }

    /**
     * @param mensuracaoEstoque the mensuracaoEstoque to set
     */
    public void setMensuracaoEstoque(String mensuracaoEstoque) {
        this.mensuracaoEstoque = mensuracaoEstoque;
    }

    /**
     * @return the quantidadeEstoque
     */
    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
