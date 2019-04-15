package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_CONFIGURACAO]</p>
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
@Table(name = "ECF_CONFIGURACAO")
public class EcfConfiguracaoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MENSAGEM_CUPOM")
    private String mensagemCupom;
    @Column(name = "PORTA_ECF")
    private String portaEcf;
    @Column(name = "IP_SERVIDOR")
    private String ipServidor;
    @Column(name = "IP_SITEF")
    private String ipSitef;
    @Column(name = "TIPO_TEF")
    private String tipoTef;
    @Column(name = "TITULO_TELA_CAIXA")
    private String tituloTelaCaixa;
    @Column(name = "CAMINHO_IMAGENS_PRODUTOS")
    private String caminhoImagensProdutos;
    @Column(name = "CAMINHO_IMAGENS_MARKETING")
    private String caminhoImagensMarketing;
    @Column(name = "CAMINHO_IMAGENS_LAYOUT")
    private String caminhoImagensLayout;
    @Column(name = "COR_JANELAS_INTERNAS")
    private String corJanelasInternas;
    @Column(name = "MARKETING_ATIVO")
    private String marketingAtivo;
    @Column(name = "CFOP_ECF")
    private Integer cfopEcf;
    @Column(name = "CFOP_NF2")
    private Integer cfopNf2;
    @Column(name = "TIMEOUT_ECF")
    private Integer timeoutEcf;
    @Column(name = "INTERVALO_ECF")
    private Integer intervaloEcf;
    @Column(name = "DESCRICAO_SUPRIMENTO")
    private String descricaoSuprimento;
    @Column(name = "DESCRICAO_SANGRIA")
    private String descricaoSangria;
    @Column(name = "TEF_TIPO_GP")
    private Integer tefTipoGp;
    @Column(name = "TEF_TEMPO_ESPERA")
    private Integer tefTempoEspera;
    @Column(name = "TEF_ESPERA_STS")
    private Integer tefEsperaSts;
    @Column(name = "TEF_NUMERO_VIAS")
    private Integer tefNumeroVias;
    @Column(name = "DECIMAIS_QUANTIDADE")
    private Integer decimaisQuantidade;
    @Column(name = "DECIMAIS_VALOR")
    private Integer decimaisValor;
    @Column(name = "BITS_POR_SEGUNDO")
    private Integer bitsPorSegundo;
    @Column(name = "QUANTIDADE_MAXIMA_CARTOES")
    private Integer quantidadeMaximaCartoes;
    @Column(name = "PESQUISA_PARTE")
    private String pesquisaParte;
    @Column(name = "ULTIMA_EXCLUSAO")
    private Integer ultimaExclusao;
    @Column(name = "LAUDO")
    private String laudo;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ATUALIZACAO_ESTOQUE")
    private Date dataAtualizacaoEstoque;
    @Column(name = "PEDE_CPF_CUPOM")
    private String pedeCpfCupom;
    @Column(name = "TIPO_INTEGRACAO")
    private Integer tipoIntegracao;
    @Column(name = "TIMER_INTEGRACAO")
    private Integer timerIntegracao;
    @Column(name = "GAVETA_SINAL_INVERTIDO")
    private String gavetaSinalInvertido;
    @Column(name = "GAVETA_UTILIZACAO")
    private Integer gavetaUtilizacao;
    @Column(name = "QUANTIDADE_MAXIMA_PARCELA")
    private Integer quantidadeMaximaParcela;
    @Column(name = "IMPRIME_PARCELA")
    private String imprimeParcela;
    @Column(name = "USA_TECLADO_REDUZIDO")
    private String usaTecladoReduzido;
    @Column(name = "PERMITE_LANCAR_NF_MANUAL")
    private String permiteLancarNfManual;
    @JoinColumn(name = "ID_ECF_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfEmpresaVO ecfEmpresa;
    @JoinColumn(name = "ID_ECF_CAIXA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfCaixaVO ecfCaixa;
    @JoinColumn(name = "ID_ECF_RESOLUCAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfResolucaoVO ecfResolucao;
    @JoinColumn(name = "ID_ECF_IMPRESSORA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfImpressoraVO ecfImpressora;

    public EcfConfiguracaoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensagemCupom() {
        return mensagemCupom;
    }

    public void setMensagemCupom(String mensagemCupom) {
        this.mensagemCupom = mensagemCupom;
    }

    public String getPortaEcf() {
        return portaEcf;
    }

    public void setPortaEcf(String portaEcf) {
        this.portaEcf = portaEcf;
    }

    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public String getIpSitef() {
        return ipSitef;
    }

    public void setIpSitef(String ipSitef) {
        this.ipSitef = ipSitef;
    }

    public String getTipoTef() {
        return tipoTef;
    }

    public void setTipoTef(String tipoTef) {
        this.tipoTef = tipoTef;
    }

    public String getTituloTelaCaixa() {
        return tituloTelaCaixa;
    }

    public void setTituloTelaCaixa(String tituloTelaCaixa) {
        this.tituloTelaCaixa = tituloTelaCaixa;
    }

    public String getCaminhoImagensProdutos() {
        return caminhoImagensProdutos;
    }

    public void setCaminhoImagensProdutos(String caminhoImagensProdutos) {
        this.caminhoImagensProdutos = caminhoImagensProdutos;
    }

    public String getCaminhoImagensMarketing() {
        return caminhoImagensMarketing;
    }

    public void setCaminhoImagensMarketing(String caminhoImagensMarketing) {
        this.caminhoImagensMarketing = caminhoImagensMarketing;
    }

    public String getCaminhoImagensLayout() {
        return caminhoImagensLayout;
    }

    public void setCaminhoImagensLayout(String caminhoImagensLayout) {
        this.caminhoImagensLayout = caminhoImagensLayout;
    }

    public String getCorJanelasInternas() {
        return corJanelasInternas;
    }

    public void setCorJanelasInternas(String corJanelasInternas) {
        this.corJanelasInternas = corJanelasInternas;
    }

    public String getMarketingAtivo() {
        return marketingAtivo;
    }

    public void setMarketingAtivo(String marketingAtivo) {
        this.marketingAtivo = marketingAtivo;
    }

    public Integer getCfopEcf() {
        return cfopEcf;
    }

    public void setCfopEcf(Integer cfopEcf) {
        this.cfopEcf = cfopEcf;
    }

    public Integer getCfopNf2() {
        return cfopNf2;
    }

    public void setCfopNf2(Integer cfopNf2) {
        this.cfopNf2 = cfopNf2;
    }

    public Integer getTimeoutEcf() {
        return timeoutEcf;
    }

    public void setTimeoutEcf(Integer timeoutEcf) {
        this.timeoutEcf = timeoutEcf;
    }

    public Integer getIntervaloEcf() {
        return intervaloEcf;
    }

    public void setIntervaloEcf(Integer intervaloEcf) {
        this.intervaloEcf = intervaloEcf;
    }

    public String getDescricaoSuprimento() {
        return descricaoSuprimento;
    }

    public void setDescricaoSuprimento(String descricaoSuprimento) {
        this.descricaoSuprimento = descricaoSuprimento;
    }

    public String getDescricaoSangria() {
        return descricaoSangria;
    }

    public void setDescricaoSangria(String descricaoSangria) {
        this.descricaoSangria = descricaoSangria;
    }

    public Integer getTefTipoGp() {
        return tefTipoGp;
    }

    public void setTefTipoGp(Integer tefTipoGp) {
        this.tefTipoGp = tefTipoGp;
    }

    public Integer getTefTempoEspera() {
        return tefTempoEspera;
    }

    public void setTefTempoEspera(Integer tefTempoEspera) {
        this.tefTempoEspera = tefTempoEspera;
    }

    public Integer getTefEsperaSts() {
        return tefEsperaSts;
    }

    public void setTefEsperaSts(Integer tefEsperaSts) {
        this.tefEsperaSts = tefEsperaSts;
    }

    public Integer getTefNumeroVias() {
        return tefNumeroVias;
    }

    public void setTefNumeroVias(Integer tefNumeroVias) {
        this.tefNumeroVias = tefNumeroVias;
    }

    public Integer getDecimaisQuantidade() {
        return decimaisQuantidade;
    }

    public void setDecimaisQuantidade(Integer decimaisQuantidade) {
        this.decimaisQuantidade = decimaisQuantidade;
    }

    public Integer getDecimaisValor() {
        return decimaisValor;
    }

    public void setDecimaisValor(Integer decimaisValor) {
        this.decimaisValor = decimaisValor;
    }

    public Integer getBitsPorSegundo() {
        return bitsPorSegundo;
    }

    public void setBitsPorSegundo(Integer bitsPorSegundo) {
        this.bitsPorSegundo = bitsPorSegundo;
    }

    public Integer getQuantidadeMaximaCartoes() {
        return quantidadeMaximaCartoes;
    }

    public void setQuantidadeMaximaCartoes(Integer quantidadeMaximaCartoes) {
        this.quantidadeMaximaCartoes = quantidadeMaximaCartoes;
    }

    public String getPesquisaParte() {
        return pesquisaParte;
    }

    public void setPesquisaParte(String pesquisaParte) {
        this.pesquisaParte = pesquisaParte;
    }

    public Integer getUltimaExclusao() {
        return ultimaExclusao;
    }

    public void setUltimaExclusao(Integer ultimaExclusao) {
        this.ultimaExclusao = ultimaExclusao;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public Date getDataAtualizacaoEstoque() {
        return dataAtualizacaoEstoque;
    }

    public void setDataAtualizacaoEstoque(Date dataAtualizacaoEstoque) {
        this.dataAtualizacaoEstoque = dataAtualizacaoEstoque;
    }

    public String getPedeCpfCupom() {
        return pedeCpfCupom;
    }

    public void setPedeCpfCupom(String pedeCpfCupom) {
        this.pedeCpfCupom = pedeCpfCupom;
    }

    public Integer getTipoIntegracao() {
        return tipoIntegracao;
    }

    public void setTipoIntegracao(Integer tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }

    public Integer getTimerIntegracao() {
        return timerIntegracao;
    }

    public void setTimerIntegracao(Integer timerIntegracao) {
        this.timerIntegracao = timerIntegracao;
    }

    public String getGavetaSinalInvertido() {
        return gavetaSinalInvertido;
    }

    public void setGavetaSinalInvertido(String gavetaSinalInvertido) {
        this.gavetaSinalInvertido = gavetaSinalInvertido;
    }

    public Integer getGavetaUtilizacao() {
        return gavetaUtilizacao;
    }

    public void setGavetaUtilizacao(Integer gavetaUtilizacao) {
        this.gavetaUtilizacao = gavetaUtilizacao;
    }

    public Integer getQuantidadeMaximaParcela() {
        return quantidadeMaximaParcela;
    }

    public void setQuantidadeMaximaParcela(Integer quantidadeMaximaParcela) {
        this.quantidadeMaximaParcela = quantidadeMaximaParcela;
    }

    public String getImprimeParcela() {
        return imprimeParcela;
    }

    public void setImprimeParcela(String imprimeParcela) {
        this.imprimeParcela = imprimeParcela;
    }

    public String getUsaTecladoReduzido() {
        return usaTecladoReduzido;
    }

    public void setUsaTecladoReduzido(String usaTecladoReduzido) {
        this.usaTecladoReduzido = usaTecladoReduzido;
    }

    public String getPermiteLancarNfManual() {
        return permiteLancarNfManual;
    }

    public void setPermiteLancarNfManual(String permiteLancarNfManual) {
        this.permiteLancarNfManual = permiteLancarNfManual;
    }

    public EcfEmpresaVO getEcfEmpresa() {
        return ecfEmpresa;
    }

    public void setEcfEmpresa(EcfEmpresaVO ecfEmpresa) {
        this.ecfEmpresa = ecfEmpresa;
    }

    public EcfCaixaVO getEcfCaixa() {
        return ecfCaixa;
    }

    public void setEcfCaixa(EcfCaixaVO ecfCaixa) {
        this.ecfCaixa = ecfCaixa;
    }

    public EcfResolucaoVO getEcfResolucao() {
        return ecfResolucao;
    }

    public void setEcfResolucao(EcfResolucaoVO ecfResolucao) {
        this.ecfResolucao = ecfResolucao;
    }

    public EcfImpressoraVO getEcfImpressora() {
        return ecfImpressora;
    }

    public void setEcfImpressora(EcfImpressoraVO ecfImpressora) {
        this.ecfImpressora = ecfImpressora;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfConfiguracaoVO[id=" + id + "]";
    }

}
