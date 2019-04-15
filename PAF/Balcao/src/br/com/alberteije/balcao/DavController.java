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

import br.com.alberteije.principal.HibernateUtil;
import br.com.alberteije.vo.EcfDavCabecalhoVO;
import br.com.alberteije.vo.EcfDavDetalheVO;
import br.com.alberteije.vo.EcfEmpresaVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.hibernate.Session;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

public class DavController extends FormController {

    private DavGrid grid;
    private EcfDavCabecalhoVO davCabecalho;

    public DavController() {
        grid = new DavGrid(this);
        MDIFrame.add(grid);
        grid.getForm1().setMode(Consts.INSERT);
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        davCabecalho = (EcfDavCabecalhoVO) newPersistentObject;

        Calendar dataAtual = Calendar.getInstance();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        String horaAtual = formatoHora.format(dataAtual.getTime());

        BigDecimal valorTotal = BigDecimal.ZERO;
        List<EcfDavDetalheVO> listaDavDetalhe = grid.getGrid1().getVOListTableModel().getDataVector();
        if (listaDavDetalhe.isEmpty()) {
            return new ErrorResponse("Nenhum item na lista!");
        }
        for (int i = 0; i < listaDavDetalhe.size(); i++) {
            if (listaDavDetalhe.get(i).getCancelado() == null) {
                listaDavDetalhe.get(i).setCancelado("N");
                valorTotal = valorTotal.add(listaDavDetalhe.get(i).getValorTotal());
                valorTotal.setScale(2, RoundingMode.DOWN);
            }
        }
        davCabecalho.setValor(valorTotal);
        davCabecalho.setDataEmissao(dataAtual.getTime());
        davCabecalho.setHoraEmissao(horaAtual);
        davCabecalho.setSituacao("P");
        davCabecalho.setIdPessoa(0);
        davCabecalho.setTaxaAcrescimo(BigDecimal.ZERO);
        davCabecalho.setAcrescimo(BigDecimal.ZERO);
        davCabecalho.setTaxaDesconto(BigDecimal.ZERO);
        davCabecalho.setDesconto(BigDecimal.ZERO);
        davCabecalho.setSubtotal(BigDecimal.ZERO);
        davCabecalho.setHashIncremento(-1);

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "select NUMERO_DAV from DAV_CABECALHO where ID = (select max(ID) from DAV_CABECALHO)";

            String numeroUltimoDav = (String) session.createSQLQuery(sql).uniqueResult();
            if (numeroUltimoDav != null) {
                if (numeroUltimoDav.equals("9999999999")) {
                    davCabecalho.setNumeroDav("0000000001");
                } else {
                    int numeroNovoDav = Integer.valueOf(numeroUltimoDav) + 1;
                    DecimalFormat formatoDav = new DecimalFormat("0000000000");
                    davCabecalho.setNumeroDav(formatoDav.format(numeroNovoDav));
                }
            } else {
                davCabecalho.setNumeroDav("0000000001");
            }

            session.save(davCabecalho);
            EcfDavDetalheVO davDetalhe;
            for (int i = 0; i < listaDavDetalhe.size(); i++) {
                davDetalhe = listaDavDetalhe.get(i);
                davDetalhe.setEcfDavCabecalhoVO(davCabecalho);
                davDetalhe.setValorUnitario(davDetalhe.getProduto().getValorVenda());
                davDetalhe.setNumeroDav(davCabecalho.getNumeroDav());
                davDetalhe.setDataEmissao(davCabecalho.getDataEmissao());
                davDetalhe.setTotalizadorParcial(davDetalhe.getProduto().getTotalizadorParcial());
                davDetalhe.setMesclaProduto("N");
                session.save(davDetalhe);
            }

            session.getTransaction().commit();

            return new VOResponse(newPersistentObject);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao gerar o DAV");
        } finally {
            session.close();
        }
    }

    @Override
    public void afterInsertData() {
        String[] opcoes = {"Sim", "Não"};
        int escolha = JOptionPane.showOptionDialog(grid, "DAV salvo com sucesso!\nNúmero do DAV: " + davCabecalho.getNumeroDav() + "\nID do DAV: " + davCabecalho.getId() + "\nDeseja imprimir?", "Aviso do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
        if (escolha == JOptionPane.YES_OPTION) {
            imprimeDav();
        }
        grid.dispose();
    }

    public void imprimeDav() {
        EcfDavCabecalhoVO davCabecalho = (EcfDavCabecalhoVO) this.grid.getForm1().getVOModel().getValueObject();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            EcfEmpresaVO empresa = (EcfEmpresaVO) session.load(EcfEmpresaVO.class, 1);

            HashMap parametros = new HashMap();
            parametros.put("NOME_EMPRESA", empresa.getRazaoSocial());
            parametros.put("CNPJ_EMPRESA", empresa.getCnpj());
            parametros.put("CODIGO_DAV", davCabecalho.getId());

            JasperPrint jp = JasperFillManager.fillReport("./relatorios/DAV.jasper", parametros, session.connection());
            JasperPrintManager.printPage(jp, 0, false);

            //JasperViewer jv = new JasperViewer(jp);
            //jv.viewReport(jp, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}