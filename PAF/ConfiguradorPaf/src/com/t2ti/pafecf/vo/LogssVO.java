package com.t2ti.pafecf.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [LOGSS]</p>
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
@Table(name = "LOGSS")
public class LogssVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TTP")
    private Integer ttp;
    @Column(name = "PRODUTO")
    private Integer produto;
    @Column(name = "R01")
    private Integer r01;
    @Column(name = "R02")
    private Integer r02;
    @Column(name = "R03")
    private Integer r03;
    @Column(name = "R04")
    private Integer r04;
    @Column(name = "R05")
    private Integer r05;
    @Column(name = "R06")
    private Integer r06;
    @Column(name = "R07")
    private Integer r07;

    public LogssVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTtp() {
        return ttp;
    }

    public void setTtp(Integer ttp) {
        this.ttp = ttp;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getR01() {
        return r01;
    }

    public void setR01(Integer r01) {
        this.r01 = r01;
    }

    public Integer getR02() {
        return r02;
    }

    public void setR02(Integer r02) {
        this.r02 = r02;
    }

    public Integer getR03() {
        return r03;
    }

    public void setR03(Integer r03) {
        this.r03 = r03;
    }

    public Integer getR04() {
        return r04;
    }

    public void setR04(Integer r04) {
        this.r04 = r04;
    }

    public Integer getR05() {
        return r05;
    }

    public void setR05(Integer r05) {
        this.r05 = r05;
    }

    public Integer getR06() {
        return r06;
    }

    public void setR06(Integer r06) {
        this.r06 = r06;
    }

    public Integer getR07() {
        return r07;
    }

    public void setR07(Integer r07) {
        this.r07 = r07;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.LogssVO[id=" + id + "]";
    }

}
