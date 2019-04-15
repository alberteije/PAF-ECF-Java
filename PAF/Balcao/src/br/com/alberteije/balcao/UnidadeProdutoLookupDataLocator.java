/**
 * <p>Title: AlbertEijePDV</p>
 * <p>Description: Classe de lookup da Unidade</p>
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
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.lookup.client.LookupServerDataLocator;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.util.server.HibernateUtils;

public class UnidadeProdutoLookupDataLocator extends LookupServerDataLocator {

    public UnidadeProdutoLookupDataLocator() {
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType) {
        try {
            String sql = "select UNIDADE_PRODUTO from br.com.alberteije.vo.UnidadeProdutoVO as UNIDADE_PRODUTO";
            Session session = HibernateUtil.getSessionFactory().openSession();

            Response res = HibernateUtils.getAllFromQuery(
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    br.com.alberteije.vo.UnidadeProdutoVO.class,
                    sql,
                    new Object[0],
                    new Type[0],
                    "UNIDADE_PRODUTO",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Response validateCode(String code) {
        try {
            String sql = "select UNIDADE_PRODUTO from br.com.alberteije.vo.UnidadeProdutoVO as UNIDADE_PRODUTO where UNIDADE_PRODUTO.id =" + code;
            Session session = HibernateUtil.getSessionFactory().openSession();

            return new VOListResponse(session.createQuery(sql).list(), false, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("Erro ao validar!");
        }
    }

}