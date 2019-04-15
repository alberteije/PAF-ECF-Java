package com.t2ti.pafecf.vo;

import com.t2ti.pafecf.infra.ColunaGrid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_TOTAL_TIPO_PAGAMENTO]</p>
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
@Table(name = "ECF_TOTAL_TIPO_PAGAMENTO")
@SequenceGenerator(name = "ECF_TOTAL_TIPO_PAGAMENTO", sequenceName = "ECF_TOTAL_TIPO_PAGAMENTO")
public class EcfTotalTipoPagamentoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ECF_TOTAL_TIPO_PAGAMENTO")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_VENDA")
    private Date dataVenda;
    @Column(name = "SERIE_ECF")
    private String serieEcf;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "GNF")
    private Integer gnf;
    @Column(name = "NSU")
    private String nsu;
    @Column(name = "ESTORNO")
    private String estorno;
    @Column(name = "REDE")
    private String rede;
    @Column(name = "CARTAO_DC")
    private String cartaoDc;
    @Column(name = "LOGSS")
    private String logss;
    @ColunaGrid(nome = "Descrição", metodoGet = "getEcfTipoPagamento.getDescricao")
    @JoinColumn(name = "ID_ECF_TIPO_PAGAMENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfTipoPagamentoVO ecfTipoPagamento;
    @JoinColumn(name = "ID_ECF_VENDA_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfVendaCabecalhoVO ecfVendaCabecalho;
    @ColunaGrid(nome = "Valor")
    @Column(name = "VALOR")
    private BigDecimal valor;

    public EcfTotalTipoPagamentoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
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

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public Integer getGnf() {
        return gnf;
    }

    public void setGnf(Integer gnf) {
        this.gnf = gnf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getEstorno() {
        return estorno;
    }

    public void setEstorno(String estorno) {
        this.estorno = estorno;
    }

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
    }

    public String getCartaoDc() {
        return cartaoDc;
    }

    public void setCartaoDc(String cartaoDc) {
        this.cartaoDc = cartaoDc;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }

    public EcfTipoPagamentoVO getEcfTipoPagamento() {
        return ecfTipoPagamento;
    }

    public void setEcfTipoPagamento(EcfTipoPagamentoVO ecfTipoPagamento) {
        this.ecfTipoPagamento = ecfTipoPagamento;
    }

    public EcfVendaCabecalhoVO getEcfVendaCabecalho() {
        return ecfVendaCabecalho;
    }

    public void setEcfVendaCabecalho(EcfVendaCabecalhoVO ecfVendaCabecalho) {
        this.ecfVendaCabecalho = ecfVendaCabecalho;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfTotalTipoPagamentoVO[id=" + id + "]";
    }

}
