package com.t2ti.pafecf.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_RELATORIO_GERENCIAL]</p>
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
@Table(name = "ECF_RELATORIO_GERENCIAL")
public class EcfRelatorioGerencialVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "X")
    private Integer x;
    @Column(name = "MEIOS_PAGAMENTO")
    private Integer meiosPagamento;
    @Column(name = "DAV_EMITIDOS")
    private Integer davEmitidos;
    @Column(name = "IDENTIFICACAO_PAF")
    private Integer identificacaoPaf;
    @Column(name = "PARAMETROS_CONFIGURACAO")
    private Integer parametrosConfiguracao;
    @Column(name = "OUTROS")
    private Integer outros;
    @JoinColumn(name = "ID_ECF_CONFIGURACAO", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private EcfConfiguracaoVO ecfConfiguracao;

    public EcfRelatorioGerencialVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getMeiosPagamento() {
        return meiosPagamento;
    }

    public void setMeiosPagamento(Integer meiosPagamento) {
        this.meiosPagamento = meiosPagamento;
    }

    public Integer getDavEmitidos() {
        return davEmitidos;
    }

    public void setDavEmitidos(Integer davEmitidos) {
        this.davEmitidos = davEmitidos;
    }

    public Integer getIdentificacaoPaf() {
        return identificacaoPaf;
    }

    public void setIdentificacaoPaf(Integer identificacaoPaf) {
        this.identificacaoPaf = identificacaoPaf;
    }

    public Integer getParametrosConfiguracao() {
        return parametrosConfiguracao;
    }

    public void setParametrosConfiguracao(Integer parametrosConfiguracao) {
        this.parametrosConfiguracao = parametrosConfiguracao;
    }

    public Integer getOutros() {
        return outros;
    }

    public void setOutros(Integer outros) {
        this.outros = outros;
    }

    public EcfConfiguracaoVO getEcfConfiguracao() {
        return ecfConfiguracao;
    }

    public void setEcfConfiguracao(EcfConfiguracaoVO ecfConfiguracao) {
        this.ecfConfiguracao = ecfConfiguracao;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfRelatorioGerencialVO[id=" + id + "]";
    }

}
