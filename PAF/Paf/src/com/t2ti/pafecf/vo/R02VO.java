package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [R02]</p>
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
@Table(name = "R02")
@SequenceGenerator(name = "R02", sequenceName = "R02")
public class R02VO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "R02")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ID_OPERADOR")
    private Integer idOperador;
    @Column(name = "ID_IMPRESSORA")
    private Integer idImpressora;
    @Column(name = "ID_ECF_CAIXA")
    private Integer idEcfCaixa;
    @Column(name = "SERIE_ECF")
    private String serieEcf;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "CRO")
    private Integer cro;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_MOVIMENTO")
    private Date dataMovimento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_EMISSAO")
    private Date dataEmissao;
    @Column(name = "HORA_EMISSAO")
    private String horaEmissao;
    @Column(name = "VENDA_BRUTA")
    private BigDecimal vendaBruta;
    @Column(name = "GRANDE_TOTAL")
    private BigDecimal grandeTotal;
    @Column(name = "LOGSS")
    private String logss;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "r02", cascade = CascadeType.ALL)
    private List<R03VO> listaR03;
    
    public R02VO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public Integer getIdImpressora() {
        return idImpressora;
    }

    public void setIdImpressora(Integer idImpressora) {
        this.idImpressora = idImpressora;
    }

    public Integer getIdEcfCaixa() {
        return idEcfCaixa;
    }

    public void setIdEcfCaixa(Integer idEcfCaixa) {
        this.idEcfCaixa = idEcfCaixa;
    }

    public String getSerieEcf() {
        return serieEcf;
    }

    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Integer getCro() {
        return cro;
    }

    public void setCro(Integer cro) {
        this.cro = cro;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    public BigDecimal getVendaBruta() {
        return vendaBruta;
    }

    public void setVendaBruta(BigDecimal vendaBruta) {
        this.vendaBruta = vendaBruta;
    }

    public BigDecimal getGrandeTotal() {
        return grandeTotal;
    }

    public void setGrandeTotal(BigDecimal grandeTotal) {
        this.grandeTotal = grandeTotal;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }

    public List<R03VO> getListaR03() {
        return listaR03;
    }

    public void setListaR03(List<R03VO> listaR03) {
        this.listaR03 = listaR03;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.R02VO[id=" + id + "]";
    }
}
