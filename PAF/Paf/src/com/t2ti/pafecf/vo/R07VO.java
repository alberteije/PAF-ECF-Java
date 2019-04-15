package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [R07]</p>
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
@Table(name = "R07")
@SequenceGenerator(name = "R07", sequenceName = "R07")
public class R07VO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "R07")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "MEIO_PAGAMENTO")
    private String meioPagamento;
    @Column(name = "VALOR_PAGAMENTO")
    private BigDecimal valorPagamento;
    @Column(name = "ESTORNO")
    private String estorno;
    @Column(name = "VALOR_ESTORNO")
    private BigDecimal valorEstorno;
    @Column(name = "LOGSS")
    private String logss;
    @JoinColumn(name = "ID_R06", referencedColumnName = "ID")
    @ManyToOne
    private R06VO r06;

    public R07VO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public String getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getEstorno() {
        return estorno;
    }

    public void setEstorno(String estorno) {
        this.estorno = estorno;
    }

    public BigDecimal getValorEstorno() {
        return valorEstorno;
    }

    public void setValorEstorno(BigDecimal valorEstorno) {
        this.valorEstorno = valorEstorno;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }

    public R06VO getR06() {
        return r06;
    }

    public void setR06(R06VO r06) {
        this.r06 = r06;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.R07VO[id=" + id + "]";
    }

}
