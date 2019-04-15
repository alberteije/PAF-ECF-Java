package com.t2ti.pafecf.vo;

import java.io.Serializable;
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
* <p>Description:  VO relacionado a tabela [R06]</p>
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
@Table(name = "R06")
@SequenceGenerator(name = "R06", sequenceName = "R06")
public class R06VO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "R06")
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
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "GNF")
    private Integer gnf;
    @Column(name = "GRG")
    private Integer grg;
    @Column(name = "CDC")
    private Integer cdc;
    @Column(name = "DENOMINACAO")
    private String denominacao;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_EMISSAO")
    private Date dataEmissao;
    @Column(name = "HORA_EMISSAO")
    private String horaEmissao;
    @Column(name = "LOGSS")
    private String logss;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "r06", cascade = CascadeType.MERGE)
    private List<R07VO> listaR07;
    
    public R06VO() {
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

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Integer getGnf() {
        return gnf;
    }

    public void setGnf(Integer gnf) {
        this.gnf = gnf;
    }

    public Integer getGrg() {
        return grg;
    }

    public void setGrg(Integer grg) {
        this.grg = grg;
    }

    public Integer getCdc() {
        return cdc;
    }

    public void setCdc(Integer cdc) {
        this.cdc = cdc;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
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

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }

    public List<R07VO> getListaR07() {
        return listaR07;
    }

    public void setListaR07(List<R07VO> listaR07) {
        this.listaR07 = listaR07;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.R06VO[id=" + id + "]";
    }
}
