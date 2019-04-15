/**
 * <p>Title: AlbertEijePDV</p>
 * <p>Description: Classe de controle do DAV</p>
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

import br.com.alberteije.vo.EcfDavDetalheVO;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

public class DavGridController extends GridController implements GridDataLocator {

    private BigDecimal valorTotal = BigDecimal.ZERO;
    private DavGrid grid;
    private Integer item;
    List<EcfDavDetalheVO> listaDav;

    public DavGridController(DavGrid grid) {
        this.grid = grid;
        item = 0;
        listaDav = new ArrayList<EcfDavDetalheVO>();
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        return new VOListResponse(listaDav, false, listaDav.size());
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        BigDecimal valorUnitario = null;
        BigDecimal quantidade = null;
        BigDecimal valorTotalProduto = null;

        EcfDavDetalheVO davDetalhe;
        for (int i = 0; i < newValueObjects.size(); i++) {
            item++;
            davDetalhe = (EcfDavDetalheVO) newValueObjects.get(i);
            davDetalhe.setItem(item);
            valorUnitario = davDetalhe.getProduto().getValorVenda();
            quantidade = davDetalhe.getQuantidade();
            valorTotalProduto = valorUnitario.multiply(quantidade);
            davDetalhe.setValorTotal(valorTotalProduto);
            davDetalhe.setGtinProduto(davDetalhe.getProduto().getGtin());
            davDetalhe.setNomeProduto(davDetalhe.getProduto().getNome());
            davDetalhe.setUnidadeProduto(davDetalhe.getProduto().getUnidadeProduto().getNome());
            davDetalhe.setHashIncremento(-1);
            valorTotal = valorTotal.add(valorTotalProduto);
            //valorTotal.setScale(2, RoundingMode.DOWN);
            listaDav.add(davDetalhe);
        }
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        grid.setValorTotal(formato.format(valorTotal));
        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    @Override
    public void afterInsertGrid(GridControl grid) {
        this.grid.getGrid1().reloadData();
    }

    /*@Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        for (int i = 0; i < oldPersistentObjects.size(); i++) {
            valorTotal = valorTotal.subtract(((EcfDavDetalheVO) oldPersistentObjects.get(i)).getValorTotal());
        }
        BigDecimal valorUnitario = null;
        BigDecimal quantidade = null;
        BigDecimal valorTotalProduto = null;
        for (int i = 0; i < persistentObjects.size(); i++) {
            valorUnitario = ((EcfDavDetalheVO) persistentObjects.get(i)).getProduto().getValorVenda();
            quantidade = ((EcfDavDetalheVO) persistentObjects.get(i)).getQuantidade();
            valorTotalProduto = valorUnitario.multiply(quantidade);
            ((EcfDavDetalheVO) persistentObjects.get(i)).setValorTotal(valorTotalProduto);
            valorTotal = valorTotal.add(valorTotalProduto);
        }
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        grid.setValorTotal(formato.format(valorTotal));

        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }*/

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        for (int i = 0; i < persistentObjects.size(); i++) {
            valorTotal = valorTotal.subtract(((EcfDavDetalheVO) persistentObjects.get(i)).getValorTotal());
        }
        DecimalFormat formato = new DecimalFormat("#,##0.00");
        grid.setValorTotal(formato.format(valorTotal));
        listaDav.get(grid.getGrid1().getSelectedRow()).setCancelado("S");
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    @Override
    public void afterDeleteGrid() {
        this.grid.getGrid1().reloadData();
    }

}
