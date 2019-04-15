package com.t2ti.pafecf.vo;

import com.t2ti.pafecf.infra.ColunaGrid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [PRODUTO]</p>
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
@Table(name = "PRODUTO")
public class ProdutoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @ColunaGrid(nome = "GTIN")
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @ColunaGrid(nome = "Nome")
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DESCRICAO_PDV")
    private String descricaoPdv;
    @ColunaGrid(nome = "Valor")
    @Column(name = "VALOR_VENDA")
    private BigDecimal valorVenda;
    @ColunaGrid(nome = "Qtde Estoque")
    @Column(name = "QUANTIDADE_ESTOQUE")
    private BigDecimal quantidadeEstoque;
    @Column(name = "ESTOQUE_MINIMO")
    private BigDecimal estoqueMinimo;
    @Column(name = "ESTOQUE_MAXIMO")
    private BigDecimal estoqueMaximo;
    @Column(name = "IAT")
    private String iat;
    @Column(name = "IPPT")
    private String ippt;
    @Column(name = "NCM")
    private String ncm;
    @Column(name = "TIPO_ITEM_SPED")
    private String tipoItemSped;
    @Column(name = "TAXA_IPI")
    private BigDecimal taxaIpi;
    @Column(name = "TAXA_ISSQN")
    private BigDecimal taxaIssqn;
    @Column(name = "TAXA_PIS")
    private BigDecimal taxaPis;
    @Column(name = "TAXA_COFINS")
    private BigDecimal taxaCofins;
    @Column(name = "TAXA_ICMS")
    private BigDecimal taxaIcms;
    @Column(name = "CST")
    private String cst;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "TOTALIZADOR_PARCIAL")
    private String totalizadorParcial;
    @Column(name = "ECF_ICMS_ST")
    private String ecfIcmsSt;
    @Column(name = "CODIGO_BALANCA")
    private Integer codigoBalanca;
    @Column(name = "PAF_P_ST")
    private String pafPSt;
    @Column(name = "LOGSS")
    private String logss;
    @JoinColumn(name = "ID_UNIDADE_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeProdutoVO unidadeProduto;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "produto")
    private List<FichaTecnicaVO> listaFichaTecnica;
    
    public ProdutoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoPdv() {
        return descricaoPdv;
    }

    public void setDescricaoPdv(String descricaoPdv) {
        this.descricaoPdv = descricaoPdv;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getIppt() {
        return ippt;
    }

    public void setIppt(String ippt) {
        this.ippt = ippt;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getTipoItemSped() {
        return tipoItemSped;
    }

    public void setTipoItemSped(String tipoItemSped) {
        this.tipoItemSped = tipoItemSped;
    }

    public BigDecimal getTaxaIpi() {
        return taxaIpi;
    }

    public void setTaxaIpi(BigDecimal taxaIpi) {
        this.taxaIpi = taxaIpi;
    }

    public BigDecimal getTaxaIssqn() {
        return taxaIssqn;
    }

    public void setTaxaIssqn(BigDecimal taxaIssqn) {
        this.taxaIssqn = taxaIssqn;
    }

    public BigDecimal getTaxaPis() {
        return taxaPis;
    }

    public void setTaxaPis(BigDecimal taxaPis) {
        this.taxaPis = taxaPis;
    }

    public BigDecimal getTaxaCofins() {
        return taxaCofins;
    }

    public void setTaxaCofins(BigDecimal taxaCofins) {
        this.taxaCofins = taxaCofins;
    }

    public BigDecimal getTaxaIcms() {
        return taxaIcms;
    }

    public void setTaxaIcms(BigDecimal taxaIcms) {
        this.taxaIcms = taxaIcms;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getTotalizadorParcial() {
        return totalizadorParcial;
    }

    public void setTotalizadorParcial(String totalizadorParcial) {
        this.totalizadorParcial = totalizadorParcial;
    }

    public String getEcfIcmsSt() {
        return ecfIcmsSt;
    }

    public void setEcfIcmsSt(String ecfIcmsSt) {
        this.ecfIcmsSt = ecfIcmsSt;
    }

    public Integer getCodigoBalanca() {
        return codigoBalanca;
    }

    public void setCodigoBalanca(Integer codigoBalanca) {
        this.codigoBalanca = codigoBalanca;
    }

    public String getPafPSt() {
        return pafPSt;
    }

    public void setPafPSt(String pafPSt) {
        this.pafPSt = pafPSt;
    }

    public UnidadeProdutoVO getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(UnidadeProdutoVO unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public String getLogss() {
        return logss;
    }

    public void setLogss(String logss) {
        this.logss = logss;
    }

    public List<FichaTecnicaVO> getListaFichaTecnica() {
        return listaFichaTecnica;
    }

    public void setListaFichaTecnica(List<FichaTecnicaVO> listaFichaTecnica) {
        this.listaFichaTecnica = listaFichaTecnica;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.ProdutoVO[id=" + id + "]";
    }
}
