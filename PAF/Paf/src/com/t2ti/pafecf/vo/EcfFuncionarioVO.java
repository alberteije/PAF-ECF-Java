package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_FUNCIONARIO]</p>
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
@Table(name = "ECF_FUNCIONARIO")
public class EcfFuncionarioVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "COMISSAO_VISTA")
    private BigDecimal comissaoVista;
    @Column(name = "COMISSAO_PRAZO")
    private BigDecimal comissaoPrazo;
    @Column(name = "NIVEL_AUTORIZACAO")
    private String nivelAutorizacao;

    public EcfFuncionarioVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getComissaoVista() {
        return comissaoVista;
    }

    public void setComissaoVista(BigDecimal comissaoVista) {
        this.comissaoVista = comissaoVista;
    }

    public BigDecimal getComissaoPrazo() {
        return comissaoPrazo;
    }

    public void setComissaoPrazo(BigDecimal comissaoPrazo) {
        this.comissaoPrazo = comissaoPrazo;
    }

    public String getNivelAutorizacao() {
        return nivelAutorizacao;
    }

    public void setNivelAutorizacao(String nivelAutorizacao) {
        this.nivelAutorizacao = nivelAutorizacao;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfFuncionarioVO[id=" + id + "]";
    }

}
