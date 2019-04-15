/*
 * The MIT License
 *
 * Copyright: Copyright (C) 2014 T2Ti.COM
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 * 
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.t2ti.pafecf.infra;

import com.t2ti.pafecf.controller.ControllerGenerico;
import com.t2ti.pafecf.view.EncerraMovimento;
import com.t2ti.pafecf.vo.EcfMovimentoVO;
import com.t2ti.pafecf.vo.EcfVendaDetalheVO;
import jACBrFramework.ACBrException;
import jACBrFramework.serial.ecf.EstadoECF;
import java.util.Date;

public class Ecf {

    public static void suprimento(double valor) throws ACBrException {
        SessaoUsuario.getAcbrEcf().suprimento(valor, "SUPRIMENTO", SessaoUsuario.getConfiguracao().getDescricaoSuprimento(), "DINHEIRO", 0);
    }

    public static void sangria(double valor) throws ACBrException {
        SessaoUsuario.getAcbrEcf().sangria(valor, "SANGRIA", SessaoUsuario.getConfiguracao().getDescricaoSangria(), "DINHEIRO", 0);
    }

    public static void cancelaCupom() throws ACBrException {
        SessaoUsuario.getAcbrEcf().cancelaCupom();
    }

    public static void reducaoZ() throws Exception {
        if (impressoraOk()) {
            Date dataMovimento = SessaoUsuario.getAcbrEcf().getDataMovimento();
            Date dataEcf = SessaoUsuario.getAcbrEcf().getDataHora();
            int estado = SessaoUsuario.getAcbrEcf().getEstado();

            if (estado != EstadoECF.REQUER_Z) {
                if (SessaoUsuario.movimento != null) {
                    EncerraMovimento encerraMovimento = new EncerraMovimento(null, true);
                    encerraMovimento.setLocationRelativeTo(null);
                    encerraMovimento.setVisible(true);
                    if (!encerraMovimento.movimentoEncerrado) {
                        throw new ACBrException("É Necessário Encerrar o Movimento Para Emitir a Redução Z!");
                    }
                }
            }

            Paf.gravaR02R03();
            Paf.geraRegistrosPAF(dataMovimento, dataMovimento, "T", "", "", "", dataMovimento);

            SessaoUsuario.getAcbrEcf().reducaoZ();

            if (SessaoUsuario.movimento != null) {
                SessaoUsuario.movimento.setDataFechamento(dataEcf);
                SessaoUsuario.movimento.setHoraFechamento(Biblioteca.formataHora(dataEcf));
                SessaoUsuario.movimento.setStatusMovimento("F");
                new ControllerGenerico<EcfMovimentoVO>().atualizar(SessaoUsuario.movimento);
                SessaoUsuario.movimento = null;
            }
        } else {
            throw new ACBrException("Estado da impressora não permite redução Z.");
        }
    }

    public static void leituraX() throws ACBrException {
        SessaoUsuario.getAcbrEcf().leituraX();
    }

    public static void abreCupom(String CPFouCNPJ, String nome, String endereco) throws ACBrException {
        SessaoUsuario.getAcbrEcf().abreCupom(CPFouCNPJ, nome, endereco, false);
    }

    public static void abreCupom(String CPFouCNPJ, String nome, String endereco, boolean modoPreVenda) throws ACBrException {
        SessaoUsuario.getAcbrEcf().abreCupom(CPFouCNPJ, nome, endereco, modoPreVenda);
    }

    public static void abreCupom(String CPFouCNPJ) throws ACBrException {
        SessaoUsuario.getAcbrEcf().abreCupom(CPFouCNPJ, "", "", false);
    }

    public static void abreCupom() throws ACBrException {
        SessaoUsuario.getAcbrEcf().abreCupom();
    }

    public static void vendeItem(EcfVendaDetalheVO vendaDetalhe) throws ACBrException {
        SessaoUsuario.getAcbrEcf().vendeItem(vendaDetalhe.getGtin(),
                vendaDetalhe.getProduto().getDescricaoPdv(),
                vendaDetalhe.getEcfIcmsSt(),
                vendaDetalhe.getQuantidade().doubleValue(),
                vendaDetalhe.getValorUnitario().doubleValue(),
                0.0,
                vendaDetalhe.getProduto().getUnidadeProduto().getSigla(),
                "",
                "", 0);
    }

    public static void efetuaFormaPagamento(String codigo, double valor) throws ACBrException {
        SessaoUsuario.getAcbrEcf().efetuaPagamento(codigo, valor, "", false);
    }

    public static void subTotalizaCupom(Double AscDesc) throws ACBrException {
        SessaoUsuario.getAcbrEcf().subtotalizaCupom(AscDesc, "");
    }

    public static void fechaCupom(String observacao) throws ACBrException {
        SessaoUsuario.getAcbrEcf().fechaCupom(observacao);
    }

    public static void cancelaItem(Integer item) throws ACBrException {
        SessaoUsuario.getAcbrEcf().cancelaItemVendido(item);
    }

    public static boolean impressoraOk() {
        try {
            int estado = SessaoUsuario.getAcbrEcf().getEstado();
            if (estado == EstadoECF.NAO_INICIALIZADA
                    || estado == EstadoECF.DESCONHECIDO
                    || estado == EstadoECF.BLOQUEADA) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
