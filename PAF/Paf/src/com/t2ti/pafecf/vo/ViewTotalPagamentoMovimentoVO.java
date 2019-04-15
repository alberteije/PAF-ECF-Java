package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [VIEW_TOTAL_PAGAMENTO_MOVIMENTO]</p>
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
@Table(name = "VIEW_TOTAL_PAGAMENTO_MOVIMENTO")
public class ViewTotalPagamentoMovimentoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_ECF_MOVIMENTO")
    private Integer idEcfMovimento;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VALOR_APURADO")
    private BigDecimal valorApurado;

    public ViewTotalPagamentoMovimentoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEcfMovimento() {
        return idEcfMovimento;
    }

    public void setIdEcfMovimento(Integer idEcfMovimento) {
        this.idEcfMovimento = idEcfMovimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorApurado() {
        return valorApurado;
    }

    public void setValorApurado(BigDecimal valorApurado) {
        this.valorApurado = valorApurado;
    }

}
