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
import com.t2ti.pafecf.controller.OperadorController;
import com.t2ti.pafecf.vo.EcfConfiguracaoVO;
import com.t2ti.pafecf.vo.EcfImpressoraVO;
import com.t2ti.pafecf.vo.EcfMovimentoVO;
import com.t2ti.pafecf.vo.EcfOperadorVO;
import com.t2ti.pafecf.vo.EcfTipoPagamentoVO;
import com.t2ti.pafecf.vo.EcfVendaCabecalhoVO;
import com.t2ti.pafecf.vo.R01VO;
import jACBrFramework.ACBrException;
import jACBrFramework.serial.ecf.ACBrECF;
import java.util.List;
import javax.swing.JOptionPane;

public class SessaoUsuario implements Tipos {

    private static EcfConfiguracaoVO configuracao;
    private static ACBrECF ecf;
    public static EcfMovimentoVO movimento = null;
    public static int statusCaixa = SC_ABERTO;
    public static int menuAberto = NAO;
    private static R01VO r01;
    public static String md5;
    public static EcfOperadorVO usuario;
    public static boolean abreMenuFiscal = false;
    public static EcfVendaCabecalhoVO vendaAtual;
    private static List<EcfTipoPagamentoVO> listaTipoPagamento;
    private static List<EcfImpressoraVO> listaImpressora;

    private SessaoUsuario() {
    }

    static {
        ControllerGenerico<EcfConfiguracaoVO> controller = new ControllerGenerico<>();
        ControllerGenerico<EcfTipoPagamentoVO> controllerTipoPagamento = new ControllerGenerico<>();
        ControllerGenerico<EcfImpressoraVO> controllerImpressora = new ControllerGenerico<>();
        try {
            configuracao = controller.getBean(1, EcfConfiguracaoVO.class);
            listaTipoPagamento = controllerTipoPagamento.getBeans(EcfTipoPagamentoVO.class);
            listaImpressora = controllerImpressora.getBeans(EcfImpressoraVO.class);
        } catch (Exception ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as configurações do sistema.\n" + ex.getMessage() + "\n" + ex.getCause().getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static EcfConfiguracaoVO getConfiguracao() {
        return configuracao;
    }

    public static ACBrECF getAcbrEcf() {
        if (ecf == null) {
            try {
                ecf = new ACBrECF();
                ecf.setModelo(Integer.valueOf(configuracao.getEcfImpressora().getModeloAcbr()));
                ecf.getDevice().setPorta(configuracao.getPortaEcf());
                ecf.getDevice().setTimeOut(configuracao.getTimeoutEcf());
                ecf.setIntervaloAposComando(configuracao.getIntervaloEcf());
                ecf.setRetentar(false);
                ecf.ativar();
                ecf.carregaAliquotas();
                ecf.carregaFormasPagamento();
            } catch (ACBrException ex) {
                ecf = null;
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao configurar o AcbrECF.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
        return ecf;
    }

    public static R01VO getR01() {
        if (r01 == null) {
            ControllerGenerico<R01VO> controller = new ControllerGenerico<>();
            try {
                r01 = controller.getBean(1, R01VO.class);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os dados de R01.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
        return r01;
    }
    
    public static List<EcfTipoPagamentoVO> getListaTipoPagamento() {
        return listaTipoPagamento;
    }
    
    public static List<EcfImpressoraVO> getListaImpressora() {
        return listaImpressora;
    }

    public static void autenticaUsuario(String login, String senha) {
        try {
            OperadorController controller = new OperadorController();
            usuario = controller.getBean(login, senha);
        } catch (Exception ex) {
        }
    }

    public static EcfOperadorVO autenticaGerenteSupervisor(String login, String senha) {
        try {
            OperadorController controller = new OperadorController();
            EcfOperadorVO operador = controller.getBean(login, senha);
            if (operador.getEcfFuncionario().getNivelAutorizacao().equals("G")
                    || operador.getEcfFuncionario().getNivelAutorizacao().equals("S")) {
                return operador;
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

}
