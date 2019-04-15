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
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

public class ProdutoDetalheController extends FormController {

    private ProdutoDetalhe produtoDetalhe;
    private ProdutoGrid produtoGrid = null;
    private int pk;

    public ProdutoDetalheController(ProdutoGrid produtoGrid, int pk) {
        this.produtoGrid = produtoGrid;
        this.pk = pk;

        produtoDetalhe = new ProdutoDetalhe(this);
        produtoDetalhe.setParentFrame(this.produtoGrid);
        this.produtoGrid.pushFrame(produtoDetalhe);
        MDIFrame.add(produtoDetalhe);

        if (pk != 0) {
            produtoDetalhe.getForm1().setMode(Consts.READONLY);
            produtoDetalhe.getForm1().reload();

        } else {
            produtoDetalhe.getForm1().setMode(Consts.INSERT);
            valoresPadrao();
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        Session session = null;
        try {
            String sql = "select PRODUTO from br.com.alberteije.vo.ProdutoVO as PRODUTO where PRODUTO.id = " + pk;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ProdutoVO produto = (ProdutoVO) session.createQuery(sql).uniqueResult();
            return new VOResponse(produto);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao cadastrar o produto!");
        } finally {
            session.close();
        }
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ProdutoVO produto = (ProdutoVO) newPersistentObject;

            String sql = "select PRODUTO from br.com.alberteije.vo.ProdutoVO as PRODUTO where PRODUTO.gtin = " + produto.getGtin();

            produto = (ProdutoVO) session.createQuery(sql).uniqueResult();
            if (produto != null){
                return new ErrorResponse("Código de produto já cadastrado!");
            }

            produto = (ProdutoVO) newPersistentObject;
            produto.setDataEstoque(new Date());
            produto.setHashIncremento(-1);
            session.save(produto);
            session.getTransaction().commit();
            return new VOResponse(newPersistentObject);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao cadastrar o produto!");
        } finally {
            session.close();
        }
    }

    @Override
    public void afterInsertData() {
        JOptionPane.showMessageDialog(produtoDetalhe, "Produto cadastrado com sucesso!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        produtoDetalhe.dispose();
        produtoGrid.getGrid1().reloadData();
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ProdutoVO produto = (ProdutoVO) persistentObject;

            String sql = "select PRODUTO from br.com.alberteije.vo.ProdutoVO as PRODUTO where PRODUTO.gtin = " + produto.getGtin() + " and PRODUTO.id <> " + produto.getId();

            produto = (ProdutoVO) session.createQuery(sql).uniqueResult();
            if (produto != null){
                return new ErrorResponse("Código de produto já cadastrado!");
            }

            produto = (ProdutoVO) persistentObject;
            produto.setHashIncremento(-1);
            session.update(produto);
            session.getTransaction().commit();
            return new VOResponse(produto);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao cadastrar o produto!");
        } finally {
            session.close();
        }
    }

    @Override
    public void afterEditData() {
        JOptionPane.showMessageDialog(produtoDetalhe, "Dados do produto salvos com sucesso!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        produtoDetalhe.dispose();
        produtoGrid.getGrid1().reloadData();
    }

    private void valoresPadrao() {
        ProdutoVO produto = (ProdutoVO) produtoDetalhe.getForm1().getVOModel().getValueObject();
        produto.setCodigoInterno("001234");
        produto.setNcm("40129010");
        produto.setTipoItemSped("04");
        produto.setTaxaIcms(BigDecimal.valueOf(7.0));
        produto.setCst("000");
        produto.setCsosn("1900");
        produto.setEcfIcmsSt("07");
        produto.setTotalizadorParcial("04T0700");
        produto.setPafPSt("T");
        produto.setIat("A");
        produto.setIppt("T");
        produtoDetalhe.getForm1().pull();
    }
}
