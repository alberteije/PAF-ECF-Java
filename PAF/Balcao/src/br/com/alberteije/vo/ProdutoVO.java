/**
 * <p>Title: AlbertEijePDV</p>
 * <p>Description: VO relacionado à tabela PRODUTO</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2013 Albert Eije</p>
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
 *       The author may be contacted at:
 *           alberteije@gmail.com</p>
 *
 * @author Albert Eije 
 * @version 1.0
 */
package br.com.alberteije.vo;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "ProdutoVO.findAll", query = "SELECT p FROM ProdutoVO p")})
public class ProdutoVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @Column(name = "NOME")
    private String nome;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DESCRICAO_PDV")
    private String descricaoPdv;
    @Column(name = "VALOR_VENDA")
    private BigDecimal valorVenda;
    @Column(name = "QTD_ESTOQUE")
    private BigDecimal qtdEstoque;
    @Column(name = "ESTOQUE_MIN")
    private BigDecimal estoqueMin;
    @Column(name = "ESTOQUE_MAX")
    private BigDecimal estoqueMax;
    @Column(name = "IAT")
    private String iat;
    @Column(name = "IPPT")
    private String ippt;
    @Column(name = "NCM")
    private String ncm;
    @Column(name = "TIPO_ITEM_SPED")
    private String tipoItemSped;
    @Column(name = "DATA_ESTOQUE")
    @Temporal(TemporalType.DATE)
    private Date dataEstoque;
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
    @Column(name = "HASH_TRIPA")
    private String hashTripa;
    @Column(name = "HASH_INCREMENTO")
    private Integer hashIncremento;
    @JoinColumn(name = "ID_UNIDADE_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeProdutoVO unidadeProduto;

    public ProdutoVO() {
    }

    public ProdutoVO(Integer id) {
        this.id = id;
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

    public BigDecimal getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(BigDecimal qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public BigDecimal getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(BigDecimal estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public BigDecimal getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(BigDecimal estoqueMax) {
        this.estoqueMax = estoqueMax;
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

    public Date getDataEstoque() {
        return dataEstoque;
    }

    public void setDataEstoque(Date dataEstoque) {
        this.dataEstoque = dataEstoque;
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

    public String getHashTripa() {
        return hashTripa;
    }

    public void setHashTripa(String hashTripa) {
        this.hashTripa = hashTripa;
    }

    public Integer getHashIncremento() {
        return hashIncremento;
    }

    public void setHashIncremento(Integer hashIncremento) {
        this.hashIncremento = hashIncremento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoVO)) {
            return false;
        }
        ProdutoVO other = (ProdutoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.alberteije.vo.ProdutoVO[id=" + id + "]";
    }

    /**
     * @return the unidadeProduto
     */
    public UnidadeProdutoVO getUnidadeProduto() {
        return unidadeProduto;
    }

    /**
     * @param unidadeProduto the unidadeProduto to set
     */
    public void setUnidadeProduto(UnidadeProdutoVO unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

}
