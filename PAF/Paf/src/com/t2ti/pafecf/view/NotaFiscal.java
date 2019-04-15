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
package com.t2ti.pafecf.view;

import com.t2ti.pafecf.controller.ControllerGenerico;
import com.t2ti.pafecf.controller.ProdutoController;
import com.t2ti.pafecf.infra.Biblioteca;
import com.t2ti.pafecf.infra.MenuFiscalAction;
import com.t2ti.pafecf.infra.SessaoUsuario;
import com.t2ti.pafecf.infra.TableModelGenerico;
import com.t2ti.pafecf.infra.Tipos;
import com.t2ti.pafecf.vo.ClienteVO;
import com.t2ti.pafecf.vo.EcfFuncionarioVO;
import com.t2ti.pafecf.vo.NotaFiscalCabecalhoVO;
import com.t2ti.pafecf.vo.NotaFiscalDetalheVO;
import com.t2ti.pafecf.vo.ProdutoVO;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class NotaFiscal extends javax.swing.JDialog {

    private ClienteVO cliente;
    private BigDecimal valorTotal;
    private BigDecimal subTotal;
    private NotaFiscalCabecalhoVO notaFiscal;
    private int item;
    private List<EcfFuncionarioVO> listaFuncionario;
    private ProdutoController produtoController;
    private TableModelGenerico<NotaFiscalDetalheVO> tableModelNotaFiscalDetalhe;

    public NotaFiscal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        valorTotal = BigDecimal.ZERO;
        subTotal = BigDecimal.ZERO;
        item = 0;
        produtoController = new ProdutoController();
        notaFiscal = new NotaFiscalCabecalhoVO();
        notaFiscal.setListaNotaFiscalDetalhe(new ArrayList<NotaFiscalDetalheVO>());
        importaVendedores();
        configuraGridDetalhe();
        configuraEdits();

        try {
            int rgb = Integer.valueOf(SessaoUsuario.getConfiguracao().getCorJanelasInternas());

            panelPrincipal.setBackground(new Color(rgb));
            panelComponentes.setBackground(new Color(rgb));
            panelDadosNota.setBackground(new Color(rgb));
            panelGridProdutos.setBackground(new Color(rgb));
            panelBotoes.setBackground(new Color(rgb));
        } catch (Exception ex) {
        }

        CancelaAction cancelaAction = new CancelaAction();
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        panelPrincipal.getActionMap().put("cancelaAction", cancelaAction);

        ConfirmaAction confirmaAction = new ConfirmaAction();
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "confirmaAction");
        panelPrincipal.getActionMap().put("confirmaAction", confirmaAction);

        CancelaItemAction cancelaItemAction = new CancelaItemAction();
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "cancelaItemAction");
        panelPrincipal.getActionMap().put("cancelaItemAction", cancelaItemAction);

        ClienteAction clienteAction = new ClienteAction();
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "clienteAction");
        panelPrincipal.getActionMap().put("clienteAction", clienteAction);

        ProdutoAction produtoAction = new ProdutoAction();
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "produtoAction");
        panelPrincipal.getActionMap().put("produtoAction", produtoAction);

        //troca TAB por ENTER
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        gridProdutos.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        MenuFiscalAction menuFiscalAction = new MenuFiscalAction(this);
        panelBotoes.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "menuFiscal");
        panelBotoes.getActionMap().put("menuFiscal", menuFiscalAction);

        this.setPreferredSize(new Dimension(750, 600));
        this.pack();
    }

    private void configuraEdits() {
        try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            DefaultFormatterFactory formatterData = new DefaultFormatterFactory(mascaraData);
            editDataEmissao.setFormatterFactory(formatterData);

            MaskFormatter mascaraHora = new MaskFormatter("##:##:##");
            DefaultFormatterFactory formatterHora = new DefaultFormatterFactory(mascaraHora);
            editHoraEmissao.setFormatterFactory(formatterHora);

            MaskFormatter mascaraNumero = new MaskFormatter("######");
            DefaultFormatterFactory formatterNumero = new DefaultFormatterFactory(mascaraNumero);
            editNumero.setFormatterFactory(formatterNumero);
            editNumero.setValue("0000000");

            editQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            editQuantidade.setText("1,000");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelDadosNota = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editNumero = new javax.swing.JFormattedTextField();
        comboVendedor = new javax.swing.JComboBox();
        editDataEmissao = new javax.swing.JFormattedTextField();
        editHoraEmissao = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        editNomeDestinatario = new javax.swing.JTextField();
        editCpfCnpj = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editCodigoProduto = new javax.swing.JTextField();
        editQuantidade = new javax.swing.JTextField();
        panelBotoes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        panelGridProdutos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridProdutos = new javax.swing.JTable();
        panelResumo = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emissão de Nota Fiscal");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaMesclar01.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelDadosNota.setBackground(new Color(255,255,255,0));
        panelDadosNota.setBorder(javax.swing.BorderFactory.createTitledBorder("Digitação de Notas Fiscais:"));
        panelDadosNota.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Vendedor / Funcionario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Data Emissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Hora Emissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editNumero, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(comboVendedor, gridBagConstraints);

        editDataEmissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editDataEmissaoFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editDataEmissao, gridBagConstraints);

        editHoraEmissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editHoraEmissaoFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editHoraEmissao, gridBagConstraints);

        jLabel6.setText("Nome Destinatário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel6, gridBagConstraints);

        jLabel8.setText("CPF/CNPJ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel8, gridBagConstraints);

        editNomeDestinatario.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editNomeDestinatario, gridBagConstraints);

        editCpfCnpj.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editCpfCnpj, gridBagConstraints);

        jLabel7.setText("Código Produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel7, gridBagConstraints);

        jLabel9.setText("Quantidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDadosNota.add(jLabel9, gridBagConstraints);

        editCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                editCodigoProdutoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editCodigoProduto, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelDadosNota.add(editQuantidade, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelDadosNota, gridBagConstraints);

        panelBotoes.setBackground(new Color(255,255,255,0));
        panelBotoes.setLayout(new java.awt.GridBagLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoCliente.png"))); // NOI18N
        jLabel12.setText("F1 - Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(jLabel12, gridBagConstraints);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoCancelaItem.png"))); // NOI18N
        jLabel13.setText("F8 - Cancela Item");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(jLabel13, gridBagConstraints);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        jLabel15.setText("F12 - Gravar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(jLabel15, gridBagConstraints);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoCancelar.png"))); // NOI18N
        jLabel16.setText("ESC - Sair");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(jLabel16, gridBagConstraints);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/21botaoPesquisa.png"))); // NOI18N
        jLabel21.setText("F6 - Produto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(jLabel21, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        panelComponentes.add(panelBotoes, gridBagConstraints);

        panelGridProdutos.setBackground(new Color(255,255,255,0));
        panelGridProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos Lançados:"));
        panelGridProdutos.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(452, 150));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 150));

        gridProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(gridProdutos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGridProdutos.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelGridProdutos, gridBagConstraints);

        panelResumo.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumo da Operação:"));
        panelResumo.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("SubTotal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelResumo.add(jLabel10, gridBagConstraints);

        labelSubTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSubTotal.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelResumo.add(labelSubTotal, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelResumo.add(jLabel19, gridBagConstraints);

        labelTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTotal.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelResumo.add(labelTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelResumo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelPrincipal.add(panelComponentes, gridBagConstraints);

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editCodigoProdutoFocusLost
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                insereItem();
            }
        });
    }//GEN-LAST:event_editCodigoProdutoFocusLost

    private void editHoraEmissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editHoraEmissaoFocusGained
        Date dataAtual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        editHoraEmissao.setText(formatoHora.format(dataAtual));
    }//GEN-LAST:event_editHoraEmissaoFocusGained

    private void editDataEmissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editDataEmissaoFocusGained
        Date dataAtual = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        editDataEmissao.setText(formatoData.format(dataAtual));
    }//GEN-LAST:event_editDataEmissaoFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboVendedor;
    private javax.swing.JTextField editCodigoProduto;
    private javax.swing.JFormattedTextField editCpfCnpj;
    private javax.swing.JFormattedTextField editDataEmissao;
    private javax.swing.JFormattedTextField editHoraEmissao;
    private javax.swing.JTextField editNomeDestinatario;
    private javax.swing.JFormattedTextField editNumero;
    private javax.swing.JTextField editQuantidade;
    private javax.swing.JTable gridProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelDadosNota;
    private javax.swing.JPanel panelGridProdutos;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelResumo;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            gravaNota();
        }
    }

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class CancelaItemAction extends AbstractAction {

        public CancelaItemAction() {
        }

        public void actionPerformed(ActionEvent e) {
            cancelaItem();
        }
    }

    private class ClienteAction extends AbstractAction {

        public ClienteAction() {
        }

        public void actionPerformed(ActionEvent e) {
            identificaCliente();
        }
    }

    private class ProdutoAction extends AbstractAction {

        public ProdutoAction() {
        }

        public void actionPerformed(ActionEvent e) {
            importaProduto();
        }
    }

    private void importaVendedores() {
        try {
            ControllerGenerico<EcfFuncionarioVO> vendedorController = new ControllerGenerico<>();
            listaFuncionario = vendedorController.getBeans(EcfFuncionarioVO.class);
            for (int i = 0; i < listaFuncionario.size(); i++) {
                comboVendedor.addItem(listaFuncionario.get(i).getNome());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar os dados dos funcionarios!\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void identificaCliente() {
        ImportaCliente janelaImportaCliente = new ImportaCliente(this, true);
        janelaImportaCliente.setLocationRelativeTo(null);
        janelaImportaCliente.setVisible(true);
        if (!janelaImportaCliente.cancelado) {
            cliente = janelaImportaCliente.getCliente();
            if (cliente != null) {
                editNomeDestinatario.setText(cliente.getNome());
                editCpfCnpj.setText(cliente.getCpfCnpj());
            }
        }
    }

    private void importaProduto() {
        editCodigoProduto.requestFocus();
        ImportaProduto janelaImportaProduto = new ImportaProduto(null, true);
        janelaImportaProduto.setLocationRelativeTo(null);
        janelaImportaProduto.setVisible(true);
        if (!janelaImportaProduto.cancelado) {
            editCodigoProduto.setText(janelaImportaProduto.getGTIN());
            editCodigoProduto.requestFocus();
        }
    }

    private void atualizaTotais() {
        subTotal = BigDecimal.ZERO;
        for (int i = 0; i < notaFiscal.getListaNotaFiscalDetalhe().size(); i++) {
            subTotal = Biblioteca.soma(subTotal, notaFiscal.getListaNotaFiscalDetalhe().get(i).getValorTotal());
        }

        valorTotal = subTotal;

        labelSubTotal.setText(Biblioteca.formatoDecimal("V", subTotal.doubleValue()));
        labelTotal.setText(Biblioteca.formatoDecimal("V", valorTotal.doubleValue()));
    }

    private void insereItem() {
        if (!editCodigoProduto.getText().trim().equals("")) {
            ProdutoVO produto = produtoController.consultaPorTipo(editCodigoProduto.getText().trim(), Tipos.PESQUISA_GTIN);
            if (produto != null) {
                if (verificaQuantidade(produto.getUnidadeProduto().getPodeFracionar())) {
                    NotaFiscalDetalheVO notaDetalhe = new NotaFiscalDetalheVO();
                    item++;
                    notaDetalhe.setNotaFiscalCabecalho(notaFiscal);
                    notaDetalhe.setProduto(produto);
                    notaDetalhe.setValorUnitario(produto.getValorVenda());
                    notaDetalhe.setItem(item);

                    BigDecimal quantidade = BigDecimal.valueOf(Double.valueOf(editQuantidade.getText().replace(",", ".")));
                    BigDecimal valorTotalItem = Biblioteca.multiplica(quantidade, notaDetalhe.getValorUnitario());
                    notaDetalhe.setQuantidade(quantidade);
                    notaDetalhe.setValorTotal(valorTotalItem);

                    notaDetalhe.setTaxaIcms(produto.getTaxaIcms());
                    notaDetalhe.setTaxaIssqn(produto.getTaxaIssqn());
                    notaDetalhe.setTaxaPis(produto.getTaxaPis());
                    notaDetalhe.setTaxaCofins(produto.getTaxaCofins());
                    notaDetalhe.setTaxaIpi(produto.getTaxaIpi());
                    notaDetalhe.setTaxaAcrescimo(BigDecimal.ZERO);
                    notaDetalhe.setAcrescimo(BigDecimal.ZERO);
                    notaDetalhe.setTaxaDesconto(BigDecimal.ZERO);
                    notaDetalhe.setDesconto(BigDecimal.ZERO);
                    notaDetalhe.setCfop(SessaoUsuario.getConfiguracao().getCfopNf2());
                    notaDetalhe.setCst(produto.getCst());
                    notaDetalhe.setBaseIcms(produto.getTaxaIcms());
                    notaDetalhe.setIcms(BigDecimal.ZERO);
                    notaDetalhe.setIcmsOutras(BigDecimal.ZERO);
                    notaDetalhe.setIcmsIsento(BigDecimal.ZERO);
                    notaDetalhe.setIssqn(BigDecimal.ZERO);
                    notaDetalhe.setCofins(BigDecimal.ZERO);
                    notaDetalhe.setPis(BigDecimal.ZERO);
                    notaDetalhe.setIpi(BigDecimal.ZERO);
                    notaDetalhe.setCancelado("N");
                    notaDetalhe.setEcfIcmsSt(produto.getEcfIcmsSt());
                    if (produto.getIppt().equals("T")) {
                        notaDetalhe.setMovimentaEstoque("S");
                    } else {
                        notaDetalhe.setMovimentaEstoque("N");
                    }

                    notaFiscal.getListaNotaFiscalDetalhe().add(notaDetalhe);
                    editCodigoProduto.setText("");
                    editQuantidade.setText("1,000");
                    editCodigoProduto.requestFocus();
                    atualizaTotais();
                    atualizaGridDetalhe();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Código do produto não encontrado!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                editCodigoProduto.requestFocus();
            }
        }
    }

    private boolean verificaQuantidade(String podeFracionar) {
        try {
            if (podeFracionar.equals("N")) {
                String strQtde = editQuantidade.getText().replace(",", ".");
                double qtde = Double.valueOf(strQtde);
                if (qtde % 1 != 0) {
                    JOptionPane.showMessageDialog(this, "Este produto não pode ser vendido em quantidade fracionada!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void gravaNota() {
        try {
            ControllerGenerico<NotaFiscalCabecalhoVO> notaController = new ControllerGenerico<>();
            NotaFiscalCabecalhoVO nota = notaController.getBean(NotaFiscalCabecalhoVO.class, "numero", editNumero.getValue());
            if (nota != null) {
                JOptionPane.showMessageDialog(this, "Este número de nota já foi gravado!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                editNumero.requestFocus();
            } else if (validaInformacoes()) {
                notaFiscal.setTotalNf(valorTotal);
                notaFiscal.setTotalProdutos(valorTotal);
                notaFiscal.setCancelada("N");
                notaFiscal.setTipoNota("2");
                notaFiscal.setSerie("D");
                notaFiscal.setSubserie("");
                notaFiscal.setTaxaAcrescimo(BigDecimal.ZERO);
                notaFiscal.setAcrescimo(BigDecimal.ZERO);
                notaFiscal.setAcrescimoItens(BigDecimal.ZERO);
                notaFiscal.setTaxaDesconto(BigDecimal.ZERO);
                notaFiscal.setDesconto(BigDecimal.ZERO);
                notaFiscal.setDescontoItens(BigDecimal.ZERO);
                if (cliente.getUf().equals(SessaoUsuario.getConfiguracao().getEcfEmpresa().getUf())) {
                    notaFiscal.setCfop(5102);
                } else {
                    notaFiscal.setCfop(SessaoUsuario.getConfiguracao().getCfopNf2());
                }
                notaFiscal.setCliente(cliente);
                notaFiscal.setCpfCnpjCliente(editCpfCnpj.getText());
                notaFiscal.setEcfFuncionario(listaFuncionario.get(comboVendedor.getSelectedIndex()));
                notaFiscal.setNumero(editNumero.getText());
                notaFiscal.setBaseIcms(BigDecimal.ZERO);
                notaFiscal.setIcms(BigDecimal.ZERO);
                notaFiscal.setIcmsOutras(BigDecimal.ZERO);
                notaFiscal.setIssqn(BigDecimal.ZERO);
                notaFiscal.setPis(BigDecimal.ZERO);
                notaFiscal.setCofins(BigDecimal.ZERO);
                notaFiscal.setIpi(BigDecimal.ZERO);

                notaController.salvar(notaFiscal);

                JOptionPane.showMessageDialog(this, "Nota Fiscal gravada com sucesso!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gravar a nota.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validaInformacoes() {
        try {
            if (notaFiscal.getListaNotaFiscalDetalhe().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há itens na lista!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "É necessário identificar um cliente!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            if (editNumero.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Informe o número da nota!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                editNumero.requestFocus();
                return false;
            }
            if (editDataEmissao.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Informe a data de emissão", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                editDataEmissao.requestFocus();
                return false;
            } else {
                if (Biblioteca.isDataValida(editDataEmissao.getText())) {
                    notaFiscal.setDataEmissao(Biblioteca.stringToDate(editDataEmissao.getText()));
                } else {
                    JOptionPane.showMessageDialog(this, "Data de emissão inválida", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (editHoraEmissao.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Informe a hora de emissão!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
                editHoraEmissao.requestFocus();
                return false;
            } else {
                notaFiscal.setHoraEmissao(editHoraEmissao.getText());
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void atualizaGridDetalhe() {
        tableModelNotaFiscalDetalhe.setValues(notaFiscal.getListaNotaFiscalDetalhe());
    }

    private void configuraGridDetalhe() {
        tableModelNotaFiscalDetalhe = new TableModelGenerico<>(new NotaFiscalDetalheVO());
        gridProdutos.setModel(tableModelNotaFiscalDetalhe);
        gridProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void cancelaItem() {
        if (gridProdutos.getSelectedRow() != -1) {
            String[] opcoesResposta = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(this, "Cancelar o item selecionado?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesResposta, null);
            if (escolha == JOptionPane.YES_OPTION) {
                notaFiscal.getListaNotaFiscalDetalhe().remove(gridProdutos.getSelectedRow());
                atualizaGridDetalhe();
                atualizaTotais();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            gridProdutos.requestFocus();
        }
    }

}
