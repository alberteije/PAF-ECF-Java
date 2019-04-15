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
 * <p>
 * Title: T2Ti ERP</p>
 * <p>
 * Description: VO relacionado a tabela [R03]</p>
 *
 * <p>
 * The MIT License</p>
 *
 * <p>
 * Copyright: Copyright (C) 2010 T2Ti.COM
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
* @author Claudio de Barros (t2ti.com@gmail.com)
 * @version 2.0
 */
@Entity
@Table(name = "R03")
@SequenceGenerator(name = "R03", sequenceName = "R03")
public class R03VO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "R03")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SERIE_ECF")
    private String serieEcf;
    @Column(name = "TOTALIZADOR_PARCIAL")
    private String totalizadorParcial;
    @Column(name = "VALOR_ACUMULADO")
    private BigDecimal valorAcumulado;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "LOGSS")
    private String logss;
    @JoinColumn(name = "ID_R02", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private R02VO r02;

    public R03VO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieEcf() {
        return serieEcf;
    }

    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    public String getTotalizadorParcial() {
        return totalizadorParcial;
    }

    public void setTotalizadorParcial(String totalizadorParcial) {
        this.totalizadorParcial = totalizadorParcial;
    }

    public BigDecimal getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(BigDecimal valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }

    public R02VO getR02() {
        return r02;
    }

    public void setR02(R02VO r02) {
        this.r02 = r02;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.R03VO[id=" + id + "]";
    }

}
