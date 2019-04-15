package com.t2ti.pafecf.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_POSICAO_COMPONENTES]</p>
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
@Table(name = "ECF_POSICAO_COMPONENTES")
public class EcfPosicaoComponentesVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "ALTURA")
    private Integer altura;
    @Column(name = "LARGURA")
    private Integer largura;
    @Column(name = "TOPO")
    private Integer topo;
    @Column(name = "ESQUERDA")
    private Integer esquerda;
    @Column(name = "TAMANHO_FONTE")
    private Integer tamanhoFonte;
    @Column(name = "TEXTO")
    private String texto;
    @JoinColumn(name = "ID_ECF_RESOLUCAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfResolucaoVO ecfResolucao;

    public EcfPosicaoComponentesVO() {
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

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getTopo() {
        return topo;
    }

    public void setTopo(Integer topo) {
        this.topo = topo;
    }

    public Integer getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Integer esquerda) {
        this.esquerda = esquerda;
    }

    public Integer getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(Integer tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public EcfResolucaoVO getEcfResolucao() {
        return ecfResolucao;
    }

    public void setEcfResolucao(EcfResolucaoVO ecfResolucao) {
        this.ecfResolucao = ecfResolucao;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfPosicaoComponentesVO[id=" + id + "]";
    }

}
