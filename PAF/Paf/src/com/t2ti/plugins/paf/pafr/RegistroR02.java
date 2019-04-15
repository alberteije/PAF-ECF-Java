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

public class RegistroR02 {

    private String numeroFabricacao; // Número de fabricação do ECF
    private String mfAdicional; // Letra indicativa de MF adicional
    private String modeloEcf; // Modelo do ECF
    private Integer numeroUsuario; // Nº de ordem do usuário do ECF relativo à respectiva Redução Z
    private Integer crz; // Nº do Contador de Redução Z relativo à respectiva redução
    private Integer coo; // Nº do Contador de Ordem de Operação relativo à respectiva Redução Z
    private Integer cro; // Nº do Contador de Reinício de Operação relativo à respectiva Redução Z
    private Date dataMovimento; // Data das operações relativas à respectiva Redução Z
    private Date dataEmissao; // Data de emissão da Redução Z
    private String horaEmissao; // Hora de emissão da Redução Z
    private Double vendaBrutaDiaria; // Valor acumulado neste totalizador relativo à respectiva Redução Z, com duas casas decimais.
    private String parametroEcfDescontoIssqn; // Parâmetro do ECF para incidência de desconto sobre itens sujeitos ao ISSQN conforme item 7.2.1.4

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
     * @return the cro
     */
    public Integer getCro() {
        return cro;
    }

    /**
     * @param cro the cro to set
     */
    public void setCro(Integer cro) {
        this.cro = cro;
    }

    /**
     * @return the dataMovimento
     */
    public Date getDataMovimento() {
        return dataMovimento;
    }

    /**
     * @param dataMovimento the dataMovimento to set
     */
    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the horaEmissao
     */
    public String getHoraEmissao() {
        return horaEmissao;
    }

    /**
     * @param horaEmissao the horaEmissao to set
     */
    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    /**
     * @return the vendaBrutaDiaria
     */
    public Double getVendaBrutaDiaria() {
        return vendaBrutaDiaria;
    }

    /**
     * @param vendaBrutaDiaria the vendaBrutaDiaria to set
     */
    public void setVendaBrutaDiaria(Double vendaBrutaDiaria) {
        this.vendaBrutaDiaria = vendaBrutaDiaria;
    }

    /**
     * @return the parametroEcfDescontoIssqn
     */
    public String getParametroEcfDescontoIssqn() {
        return parametroEcfDescontoIssqn;
    }

    /**
     * @param parametroEcfDescontoIssqn the parametroEcfDescontoIssqn to set
     */
    public void setParametroEcfDescontoIssqn(String parametroEcfDescontoIssqn) {
        this.parametroEcfDescontoIssqn = parametroEcfDescontoIssqn;
    }
}
