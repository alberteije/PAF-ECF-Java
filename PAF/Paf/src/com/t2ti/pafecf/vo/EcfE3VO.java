package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_E3]</p>
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
@Table(name = "ECF_E3")
public class EcfE3VO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SERIE_ECF")
    private String serieEcf;
    @Column(name = "MF_ADICIONAL")
    private String mfAdicional;
    @Column(name = "TIPO_ECF")
    private String tipoEcf;
    @Column(name = "MARCA_ECF")
    private String marcaEcf;
    @Column(name = "MODELO_ECF")
    private String modeloEcf;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ESTOQUE")
    private Date dataEstoque;
    @Column(name = "HORA_ESTOQUE")
    private String horaEstoque;
    @Column(name = "LOGSS")
    private String logss;

    public EcfE3VO() {
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

    public String getMfAdicional() {
        return mfAdicional;
    }

    public void setMfAdicional(String mfAdicional) {
        this.mfAdicional = mfAdicional;
    }

    public String getTipoEcf() {
        return tipoEcf;
    }

    public void setTipoEcf(String tipoEcf) {
        this.tipoEcf = tipoEcf;
    }

    public String getMarcaEcf() {
        return marcaEcf;
    }

    public void setMarcaEcf(String marcaEcf) {
        this.marcaEcf = marcaEcf;
    }

    public String getModeloEcf() {
        return modeloEcf;
    }

    public void setModeloEcf(String modeloEcf) {
        this.modeloEcf = modeloEcf;
    }

    public Date getDataEstoque() {
        return dataEstoque;
    }

    public void setDataEstoque(Date dataEstoque) {
        this.dataEstoque = dataEstoque;
    }

    public String getHoraEstoque() {
        return horaEstoque;
    }

    public void setHoraEstoque(String horaEstoque) {
        this.horaEstoque = horaEstoque;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfE3VO[id=" + id + "]";
    }

}
