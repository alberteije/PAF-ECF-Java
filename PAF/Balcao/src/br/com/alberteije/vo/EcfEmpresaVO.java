/**
 * <p>Title: AlbertEijePDV</p>
 * <p>Description: VO relacionado à tabela EMPRESA</p>
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
@Table(name = "empresa")
@NamedQueries({
    @NamedQuery(name = "EcfEmpresaVO.findAll", query = "SELECT e FROM EcfEmpresaVO e")})
public class EcfEmpresaVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;
    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;
    @Column(name = "INSCRICAO_MUNICIPAL")
    private String inscricaoMunicipal;
    @Column(name = "MATRIZ_FILIAL")
    private Character matrizFilial;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "CODIGO_IBGE_CIDADE")
    private Integer codigoIbgeCidade;
    @Column(name = "CODIGO_IBGE_UF")
    private Integer codigoIbgeUf;
    @Column(name = "UF")
    private String uf;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "FONE")
    private String fone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "CONTATO")
    private String contato;
    @Column(name = "SUFRAMA")
    private String suframa;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "INSCRICAO_ESTADUAL_ST")
    private String inscricaoEstadualSt;
    @Column(name = "INSCRICAO_JUNTA_COMERCIAL")
    private String inscricaoJuntaComercial;
    @Column(name = "DATA_INSC_JUNTA_COMERCIAL")
    @Temporal(TemporalType.DATE)
    private Date dataInscJuntaComercial;
    @Column(name = "DATA_INICIO_ATIVIDADES")
    @Temporal(TemporalType.DATE)
    private Date dataInicioAtividades;
    @Lob
    @Column(name = "IMAGEM_LOGOTIPO")
    private String imagemLogotipo;
    @Column(name = "CRT")
    private Character crt;
    @Column(name = "TIPO_REGIME")
    private Character tipoRegime;
    @Column(name = "ALIQUOTA_PIS")
    private BigDecimal aliquotaPis;
    @Column(name = "ALIQUOTA_COFINS")
    private BigDecimal aliquotaCofins;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfEmpresaVO ecfEmpresaVO;

    public EcfEmpresaVO() {
    }

    public EcfEmpresaVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public Character getMatrizFilial() {
        return matrizFilial;
    }

    public void setMatrizFilial(Character matrizFilial) {
        this.matrizFilial = matrizFilial;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCodigoIbgeCidade() {
        return codigoIbgeCidade;
    }

    public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
        this.codigoIbgeCidade = codigoIbgeCidade;
    }

    public Integer getCodigoIbgeUf() {
        return codigoIbgeUf;
    }

    public void setCodigoIbgeUf(Integer codigoIbgeUf) {
        this.codigoIbgeUf = codigoIbgeUf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSuframa() {
        return suframa;
    }

    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInscricaoEstadualSt() {
        return inscricaoEstadualSt;
    }

    public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
        this.inscricaoEstadualSt = inscricaoEstadualSt;
    }

    public String getInscricaoJuntaComercial() {
        return inscricaoJuntaComercial;
    }

    public void setInscricaoJuntaComercial(String inscricaoJuntaComercial) {
        this.inscricaoJuntaComercial = inscricaoJuntaComercial;
    }

    public Date getDataInscJuntaComercial() {
        return dataInscJuntaComercial;
    }

    public void setDataInscJuntaComercial(Date dataInscJuntaComercial) {
        this.dataInscJuntaComercial = dataInscJuntaComercial;
    }

    public Date getDataInicioAtividades() {
        return dataInicioAtividades;
    }

    public void setDataInicioAtividades(Date dataInicioAtividades) {
        this.dataInicioAtividades = dataInicioAtividades;
    }

    public String getImagemLogotipo() {
        return imagemLogotipo;
    }

    public void setImagemLogotipo(String imagemLogotipo) {
        this.imagemLogotipo = imagemLogotipo;
    }

    public Character getCrt() {
        return crt;
    }

    public void setCrt(Character crt) {
        this.crt = crt;
    }

    public Character getTipoRegime() {
        return tipoRegime;
    }

    public void setTipoRegime(Character tipoRegime) {
        this.tipoRegime = tipoRegime;
    }

    public BigDecimal getAliquotaPis() {
        return aliquotaPis;
    }

    public void setAliquotaPis(BigDecimal aliquotaPis) {
        this.aliquotaPis = aliquotaPis;
    }

    public BigDecimal getAliquotaCofins() {
        return aliquotaCofins;
    }

    public void setAliquotaCofins(BigDecimal aliquotaCofins) {
        this.aliquotaCofins = aliquotaCofins;
    }

    public EcfEmpresaVO getEcfEmpresaVO() {
        return ecfEmpresaVO;
    }

    public void setEcfEmpresaVO(EcfEmpresaVO ecfEmpresaVO) {
        this.ecfEmpresaVO = ecfEmpresaVO;
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
        if (!(object instanceof EcfEmpresaVO)) {
            return false;
        }
        EcfEmpresaVO other = (EcfEmpresaVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.alberteije.vo.EcfEmpresaVO[id=" + id + "]";
    }

}
