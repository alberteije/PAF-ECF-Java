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

public class RegistroR03 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String modeloEcf; // Modelo do ECF
    private Integer numeroUsuario; // Nº de ordem do usuário do ECF relativo à respectiva Redução Z
    private Integer crz; // Nº do Contador de Redução Z relativo à respectiva redução
    private String totalizadorParcial; //Código do totalizador conforme tabela abaixo
    private Double valorAcumulado; //Valor acumulado no totalizador, relativo à respectiva Redução Z, com duas casas decimais.

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
     * @return the crz
     */
    public Integer getCrz() {
        return crz;
    }

    /**
     * @param crz the crz to set
     */
    public void setCrz(Integer crz) {
        this.crz = crz;
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
     * @return the valorAcumulado
     */
    public Double getValorAcumulado() {
        return valorAcumulado;
    }

    /**
     * @param valorAcumulado the valorAcumulado to set
     */
    public void setValorAcumulado(Double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }
}
