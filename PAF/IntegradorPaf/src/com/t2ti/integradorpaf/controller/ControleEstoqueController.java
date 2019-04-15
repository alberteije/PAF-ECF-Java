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
package com.t2ti.integradorpaf.controller;

import com.t2ti.pafecf.integrador.bd.AcessoBanco;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ControleEstoqueController {

    private AcessoBanco acessoBanco;
    private EntityManager em;

    public ControleEstoqueController() {
        acessoBanco = new AcessoBanco();
    }

    private void abreConexao() {
        try {
            em = acessoBanco.conexaoRetaguarda();
        } catch (Exception ex) {
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro ao conectar ao banco de dados.\n" + ex.getMessage() + "\n" + ex.getCause().getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fechaConexao() {
        try {
            acessoBanco.desconectarRetaguarda();
        } catch (Exception ex) {
            //ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro ao confirmar a transação no banco de dados.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizaEstoque(BigDecimal quantidade, Integer idProduto) throws Exception {
        abreConexao();
        Query query = em.createNativeQuery("update PRODUTO set QUANTIDADE_ESTOQUE = QUANTIDADE_ESTOQUE - " + quantidade.doubleValue() + " where ID = " + idProduto);
        query.executeUpdate();
        fechaConexao();
    }
}
