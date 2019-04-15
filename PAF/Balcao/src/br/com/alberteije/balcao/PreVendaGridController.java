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

import br.com.alberteije.vo.EcfPreVendaDetalheVO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

public class PreVendaGridController extends GridController implements GridDataLocator {

    private PreVendaGrid grid;
    private Double valorTotal = 0.0;

    public PreVendaGridController(PreVendaGrid grid) {
        this.grid = grid;
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        List<EcfPreVendaDetalheVO> listaPreVenda = new ArrayList<EcfPreVendaDetalheVO>();
        for (int i = 0; i < grid.getGrid1().getVOListTableModel().getDataVector().size(); i++) {
            listaPreVenda.add((EcfPreVendaDetalheVO) grid.getGrid1().getVOListTableModel().getDataVector().get(i));
        }
        return new VOListResponse(listaPreVenda, false, listaPreVenda.size());
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        Double valorUnitario = null;
        Double quantidade = null;
        Double valorTotalProduto = null;
        for (int i = 0; i < newValueObjects.size(); i++) {
            valorUnitario = ((EcfPreVendaDetalheVO) newValueObjects.get(i)).getProduto().getValorVenda().doubleValue();
            quantidade = ((EcfPreVendaDetalheVO) newValueObjects.get(i)).getQuantidade();
            valorTotalProduto = valorUnitario * quantidade;
            ((EcfPreVendaDetalheVO) newValueObjects.get(i)).setValorTotal(valorTotalProduto);
            valorTotal = valorTotal + valorTotalProduto;
        }
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        grid.setValorTotal(formato.format(valorTotal));
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        for (int i = 0; i < oldPersistentObjects.size(); i++) {
            valorTotal = valorTotal - ((EcfPreVendaDetalheVO) oldPersistentObjects.get(i)).getValorTotal();
        }
        Double valorUnitario = null;
        Double quantidade = null;
        Double valorTotalProduto = null;
        for (int i = 0; i < persistentObjects.size(); i++) {
            valorUnitario = ((EcfPreVendaDetalheVO) persistentObjects.get(i)).getProduto().getValorVenda().doubleValue();
            quantidade = ((EcfPreVendaDetalheVO) persistentObjects.get(i)).getQuantidade();
            valorTotalProduto = valorUnitario * quantidade;
            ((EcfPreVendaDetalheVO) persistentObjects.get(i)).setValorTotal(valorTotalProduto);
            valorTotal = valorTotal + valorTotalProduto;
        }
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        grid.setValorTotal(formato.format(valorTotal));
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        for (int i = 0; i < persistentObjects.size(); i++) {
            valorTotal = valorTotal - ((EcfPreVendaDetalheVO) persistentObjects.get(i)).getValorTotal();
        }
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        grid.setValorTotal(formato.format(valorTotal));
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }
}
