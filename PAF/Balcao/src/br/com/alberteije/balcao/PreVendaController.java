/**
 * <p>Title: AlbertEijePDV</p>
 * <p>Description: Classe de controle da Pré-Venda</p>
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
package br.com.alberteije.balcao;

import br.com.alberteije.principal.HibernateUtil;
import br.com.alberteije.vo.EcfPreVendaCabecalhoVO;
import br.com.alberteije.vo.EcfPreVendaDetalheVO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;

public class PreVendaController extends FormController {

    private PreVendaGrid grid;

    public PreVendaController() {
        grid = new PreVendaGrid(this);
        MDIFrame.add(grid);
    }

    public void insertRecord() {
        List<EcfPreVendaDetalheVO> listaPreVendaDetalhe = grid.getGrid1().getVOListTableModel().getDataVector();
        if (listaPreVendaDetalhe.isEmpty()) {
            JOptionPane.showMessageDialog(grid, "Nenhum produto selecionado!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            EcfPreVendaCabecalhoVO preVendaCabecalho = new EcfPreVendaCabecalhoVO();

            Calendar dataAtual = Calendar.getInstance();
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

            String horaAtual = formatoHora.format(dataAtual.getTime());

            double valorTotal = 0.0;

            for (int i = 0; i < listaPreVendaDetalhe.size(); i++) {
                EcfPreVendaDetalheVO preVendaDetalhe = listaPreVendaDetalhe.get(i);
                valorTotal += preVendaDetalhe.getValorTotal();
            }
            preVendaCabecalho.setValor(valorTotal);
            preVendaCabecalho.setDataPv(dataAtual.getTime());
            preVendaCabecalho.setHoraPv(horaAtual);
            preVendaCabecalho.setSituacao("P");

            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();

                session.save(preVendaCabecalho);

                for (int i = 0; i < listaPreVendaDetalhe.size(); i++) {
                    listaPreVendaDetalhe.get(i).setEcfPreVendaCabecalho(preVendaCabecalho);
                    listaPreVendaDetalhe.get(i).setValorUnitario(listaPreVendaDetalhe.get(i).getProduto().getValorVenda().doubleValue());
                    session.save(listaPreVendaDetalhe.get(i));
                }

                session.getTransaction().commit();
                Integer numeroPreVenda = preVendaCabecalho.getId();
                JOptionPane.showMessageDialog(grid, "Pré-Venda cadastrada com sucesso!\nNúmero da pré-venda: " + numeroPreVenda, "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                grid.dispose();
            } catch (Exception e) {
                session.getTransaction().rollback();
                JOptionPane.showMessageDialog(grid, "Erro ao salvar a pré venda!", "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            } finally {
                session.close();
            }
        }
    }
}