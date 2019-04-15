/**
 * <p>Title: AlbertEijePDV</p>
 * <p>Description: Classe de controle do Produto</p>
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
import br.com.alberteije.vo.ProdutoVO;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.server.HibernateUtils;

public class ProdutoGridController extends GridController implements GridDataLocator {

    private ProdutoGrid grid;

    public ProdutoGridController() {
        this.grid = new ProdutoGrid(this);
        MDIFrame.add(grid);
        grid.setVisible(true);
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        Session session = null;
        try {
            String sql = "select PRODUTO from br.com.alberteije.vo.ProdutoVO as PRODUTO";
            session = HibernateUtil.getSessionFactory().openSession();

            Response res = HibernateUtils.getAllFromQuery(
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    br.com.alberteije.vo.ProdutoVO.class,
                    sql,
                    new Object[0],
                    new Type[0],
                    "PRODUTO",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("Erro ao pesquisar os produtos");
        } finally {
            session.close();
        }
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        new ProdutoDetalheController(this.grid, 0);
        return false;
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        ProdutoVO produto = (ProdutoVO) grid.getGrid1().getVOListTableModel().getObjectForRow(grid.getGrid1().getSelectedRow());
        new ProdutoDetalheController(this.grid, produto.getId());
    }

}