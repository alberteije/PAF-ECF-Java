package com.t2ti.pafecf.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_TIPO_PAGAMENTO]</p>
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
@Table(name = "ECF_TIPO_PAGAMENTO")
public class EcfTipoPagamentoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "TEF")
    private String tef;
    @Column(name = "IMPRIME_VINCULADO")
    private String imprimeVinculado;
    @Column(name = "PERMITE_TROCO")
    private String permiteTroco;
    @Column(name = "TEF_TIPO_GP")
    private String tefTipoGp;
    @Column(name = "GERA_PARCELAS")
    private String geraParcelas;

    public EcfTipoPagamentoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTef() {
        return tef;
    }

    public void setTef(String tef) {
        this.tef = tef;
    }

    public String getImprimeVinculado() {
        return imprimeVinculado;
    }

    public void setImprimeVinculado(String imprimeVinculado) {
        this.imprimeVinculado = imprimeVinculado;
    }

    public String getPermiteTroco() {
        return permiteTroco;
    }

    public void setPermiteTroco(String permiteTroco) {
        this.permiteTroco = permiteTroco;
    }

    public String getTefTipoGp() {
        return tefTipoGp;
    }

    public void setTefTipoGp(String tefTipoGp) {
        this.tefTipoGp = tefTipoGp;
    }

    public String getGeraParcelas() {
        return geraParcelas;
    }

    public void setGeraParcelas(String geraParcelas) {
        this.geraParcelas = geraParcelas;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfTipoPagamentoVO[id=" + id + "]";
    }
}
