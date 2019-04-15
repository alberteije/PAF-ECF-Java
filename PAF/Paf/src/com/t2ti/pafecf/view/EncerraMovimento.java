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
import com.t2ti.pafecf.controller.EcfFechamentoController;
import com.t2ti.pafecf.controller.ViewTotalPagamentoMovimentoController;
import com.t2ti.pafecf.infra.Biblioteca;
import com.t2ti.pafecf.infra.MenuFiscalAction;
import com.t2ti.pafecf.infra.MonetarioDocument;
import com.t2ti.pafecf.infra.Paf;
import com.t2ti.pafecf.infra.SessaoUsuario;
import static com.t2ti.pafecf.infra.SessaoUsuario.movimento;
import com.t2ti.pafecf.infra.TableModelGenerico;
import com.t2ti.pafecf.vo.EcfFechamentoVO;
import com.t2ti.pafecf.vo.EcfMovimentoVO;
import com.t2ti.pafecf.vo.EcfOperadorVO;
import com.t2ti.pafecf.vo.ViewTotalPagamentoMovimentoVO;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

public class EncerraMovimento extends javax.swing.JDialog {

    private TableModelGenerico<EcfFechamentoVO> tableModel;
    private EcfFechamentoController controller;
    public boolean movimentoEncerrado = false;

    public EncerraMovimento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        controller = new EcfFechamentoController();

        try {
            int rgb = Integer.valueOf(SessaoUsuario.getConfiguracao().getCorJanelasInternas());

            panelPrincipal.setBackground(new Color(rgb));
            panelBotoes.setBackground(new Color(rgb));
            panelComponentes.setBackground(new Color(rgb));
            panelGerente.setBackground(new Color(rgb));
            panelDadosMovimento.setBackground(new Color(rgb));
            panelOperador.setBackground(new Color(rgb));
        } catch (Exception ex) {
        }

        telaPadrao();

        totalizaFechamento();

        labelTurno.setText(SessaoUsuario.movimento.getEcfTurno().getDescricao());
        labelTerminal.setText(SessaoUsuario.movimento.getEcfCaixa().getNome());
        labelOperador.setText(SessaoUsuario.movimento.getEcfOperador().getLogin());
        labelImpressora.setText(SessaoUsuario.movimento.getEcfImpressora().getIdentificacao());

        editValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editValor.setDocument(new MonetarioDocument());
        editValor.setText("0");

        editTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);

        ConfirmaAction confirmaAction = new ConfirmaAction();
        botaoConfirma.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "confirmaAction");
        botaoConfirma.getActionMap().put("confirmaAction", confirmaAction);

        //troca TAB por ENTER
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        MenuFiscalAction menuFiscalAction = new MenuFiscalAction(this);
        editLoginGerente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "menuFiscal");
        editLoginGerente.getActionMap().put("menuFiscal", menuFiscalAction);

        this.setPreferredSize(new Dimension(600, 500));
        this.pack();
    }

    private void telaPadrao() {
        DefaultComboBoxModel box = new DefaultComboBoxModel();

        for (int i = 0; i < SessaoUsuario.getListaTipoPagamento().size(); i++) {
            box.addElement(SessaoUsuario.getListaTipoPagamento().get(i).getDescricao());
        }

        comboTipoPagamento.setModel(box);

        tableModel = new TableModelGenerico<>(new EcfFechamentoVO());
        gridFechamento.setModel(tableModel);
        gridFechamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelDadosMovimento = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelTurno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelTerminal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelOperador = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelImpressora = new javax.swing.JLabel();
        panelGerente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editLoginGerente = new javax.swing.JTextField();
        editSenhaGerente = new javax.swing.JPasswordField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        panelOperador = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        editSenhaOperador = new javax.swing.JPasswordField();
        panelOperador1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridFechamento = new javax.swing.JTable();
        panelOperador2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboTipoPagamento = new javax.swing.JComboBox();
        botaoAdicionar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        editTotal = new javax.swing.JFormattedTextField();
        editValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Encerra Movimento de Caixa");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaMonitor04.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setPreferredSize(new java.awt.Dimension(600, 500));
        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelDadosMovimento.setBackground(new Color(255,255,255,0));
        panelDadosMovimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do movimento aberto:"));
        panelDadosMovimento.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Turno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(jLabel4, gridBagConstraints);

        labelTurno.setText("jLabel6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(labelTurno, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Terminal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(jLabel7, gridBagConstraints);

        labelTerminal.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(labelTerminal, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Operador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(jLabel9, gridBagConstraints);

        labelOperador.setText("jLabel10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(labelOperador, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Impressora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(jLabel11, gridBagConstraints);

        labelImpressora.setText("jLabel12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDadosMovimento.add(labelImpressora, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelDadosMovimento, gridBagConstraints);
        panelDadosMovimento.getAccessibleContext().setAccessibleName("");

        panelGerente.setBackground(new Color(255,255,255,0));
        panelGerente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Gerente:"));
        panelGerente.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelGerente.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelGerente.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        panelGerente.add(editLoginGerente, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGerente.add(editSenhaGerente, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelGerente, gridBagConstraints);

        panelBotoes.setBackground(new Color(255,255,255,0));
        panelBotoes.setLayout(new java.awt.GridBagLayout());

        botaoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        botaoConfirma.setText("Confirma (F12)");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        panelBotoes.add(botaoConfirma, gridBagConstraints);

        botaoCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoCancelar.png"))); // NOI18N
        botaoCancela.setText("Cancela (ESC)");
        botaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 5);
        panelBotoes.add(botaoCancela, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        panelComponentes.add(panelBotoes, gridBagConstraints);

        panelOperador.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Senha Operador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOperador.add(jLabel5, gridBagConstraints);

        editSenhaOperador.setPreferredSize(new java.awt.Dimension(111, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOperador.add(editSenhaOperador, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelOperador, gridBagConstraints);

        panelOperador1.setLayout(new java.awt.GridBagLayout());

        gridFechamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(gridFechamento);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelOperador1.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelOperador1, gridBagConstraints);

        panelOperador2.setLayout(new java.awt.GridBagLayout());

        jLabel12.setText("Valor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelOperador2.add(jLabel12, gridBagConstraints);

        jLabel13.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelOperador2.add(jLabel13, gridBagConstraints);

        jLabel14.setText("Tipo de Pagamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOperador2.add(jLabel14, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOperador2.add(comboTipoPagamento, gridBagConstraints);

        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/arrowright_green16.png"))); // NOI18N
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        panelOperador2.add(botaoAdicionar, gridBagConstraints);

        botaoRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/arrowleft_green16.png"))); // NOI18N
        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        panelOperador2.add(botaoRemover, gridBagConstraints);

        editTotal.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOperador2.add(editTotal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOperador2.add(editValor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelOperador2, gridBagConstraints);

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

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        confirma();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        adiciona();
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        remove();
    }//GEN-LAST:event_botaoRemoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JButton botaoRemover;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboTipoPagamento;
    private javax.swing.JTextField editLoginGerente;
    private javax.swing.JPasswordField editSenhaGerente;
    private javax.swing.JPasswordField editSenhaOperador;
    private javax.swing.JFormattedTextField editTotal;
    private javax.swing.JFormattedTextField editValor;
    private javax.swing.JTable gridFechamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImpressora;
    private javax.swing.JLabel labelOperador;
    private javax.swing.JLabel labelTerminal;
    private javax.swing.JLabel labelTurno;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelDadosMovimento;
    private javax.swing.JPanel panelGerente;
    private javax.swing.JPanel panelOperador;
    private javax.swing.JPanel panelOperador1;
    private javax.swing.JPanel panelOperador2;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            confirma();
        }
    }

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private void confirma() {
        SessaoUsuario.autenticaUsuario(labelOperador.getText(), new String(editSenhaOperador.getPassword()));
        if (SessaoUsuario.usuario != null) {
            EcfOperadorVO gerente = SessaoUsuario.autenticaGerenteSupervisor(editLoginGerente.getText(), new String(editSenhaGerente.getPassword()));
            if (gerente != null) {

                try {
                    ControllerGenerico<EcfMovimentoVO> movimentoController = new ControllerGenerico();
                    Date dataAtual = SessaoUsuario.getAcbrEcf().getDataHora();

                    SessaoUsuario.movimento.setDataFechamento(dataAtual);
                    SessaoUsuario.movimento.setHoraFechamento(Biblioteca.formataHora(dataAtual));
                    SessaoUsuario.movimento.setStatusMovimento("F");

                    movimentoController.atualizar(movimento);

                    imprimeFechamento();

                    movimentoEncerrado = true;
                    JOptionPane.showMessageDialog(this, "Movimento encerrado com sucesso.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao encerrar o movimento.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Gerente ou Supervisor: dados incorretos ou nível de acesso não permitido.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Operador: dados incorretos!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void totalizaFechamento() {
        try {
            BigDecimal total = BigDecimal.ZERO;
            tableModel.setValues(controller.getBeans(SessaoUsuario.movimento));

            for (EcfFechamentoVO f : tableModel.getValues()) {
                total = Biblioteca.soma(total, f.getValor());
            }

            editTotal.setText(Biblioteca.formatoDecimal("V", total.doubleValue()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao totalizar o fechamento!\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adiciona() {
        try {
            BigDecimal valor = BigDecimal.valueOf(Double.parseDouble(editValor.getText().replace(".", "").replace(",", ".")));
            if (valor.compareTo(BigDecimal.ZERO) == 1) {
                boolean tipoPagamentoIncluso = false;
                for (EcfFechamentoVO f : tableModel.getValues()) {
                    if (f.getTipoPagamento().equals(comboTipoPagamento.getSelectedItem().toString())) {
                        tipoPagamentoIncluso = true;
                    }
                }
                if (!tipoPagamentoIncluso) {
                    EcfFechamentoVO fechamento = new EcfFechamentoVO();
                    fechamento.setEcfMovimento(SessaoUsuario.movimento);
                    fechamento.setTipoPagamento(comboTipoPagamento.getSelectedItem().toString());
                    fechamento.setValor(valor);

                    controller.salvar(fechamento);

                    totalizaFechamento();
                } else {
                    JOptionPane.showMessageDialog(this, "Tipo de pagamento já incluso.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
                editValor.setText("0");
                comboTipoPagamento.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Valor não pode ser menor ou igual a zero.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao incluir o fechamento!\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void remove() {
        if (gridFechamento.getSelectedRow() != -1) {
            try {
                controller.excluir(tableModel.getRow(gridFechamento.getSelectedRow()), tableModel.getRow(gridFechamento.getSelectedRow()).getId());
                totalizaFechamento();
                comboTipoPagamento.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o fechamento!\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void imprimeFechamento() throws Exception {
        String calculado, declarado, diferenca, meio;
        BigDecimal valorCalculado, valorDeclarado, valorDiferenca, totCalculado, totDeclarado, totDiferenca;
        String suprimento, sangria, naoFiscal, totalVenda, desconto, acrescimo, recebido, troco, cancelado, totalFinal;

        SessaoUsuario.getAcbrEcf().abreRelatorioGerencial(SessaoUsuario.getConfiguracao().getEcfRelatorioGerencial().getX());
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("             FECHAMENTO DE CAIXA                ", 0);
        SessaoUsuario.getAcbrEcf().pulaLinhas(1);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("DATA DE ABERTURA  : " + Biblioteca.formataData(SessaoUsuario.movimento.getDataAbertura()), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("HORA DE ABERTURA  : " + SessaoUsuario.movimento.getHoraAbertura(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("DATA DE FECHAMENTO: " + Biblioteca.formataData(SessaoUsuario.movimento.getDataFechamento()), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("HORA DE FECHAMENTO: " + SessaoUsuario.movimento.getHoraFechamento(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(SessaoUsuario.movimento.getEcfCaixa().getNome() + "  OPERADOR: " + SessaoUsuario.movimento.getEcfOperador().getLogin(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("MOVIMENTO: " + SessaoUsuario.movimento.getId(), 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
        SessaoUsuario.getAcbrEcf().pulaLinhas(1);

        suprimento = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalSuprimento().doubleValue());
        suprimento = Biblioteca.repete("", 13 - suprimento.length()) + suprimento;
        sangria = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalSangria().doubleValue());
        sangria = Biblioteca.repete("", 13 - sangria.length()) + sangria;
        naoFiscal = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalNaoFiscal().doubleValue());
        naoFiscal = Biblioteca.repete("", 13 - naoFiscal.length()) + naoFiscal;
        totalVenda = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalVenda().doubleValue());
        totalVenda = Biblioteca.repete("", 13 - totalVenda.length()) + totalVenda;
        desconto = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalDesconto().doubleValue());
        desconto = Biblioteca.repete("", 13 - desconto.length()) + desconto;
        acrescimo = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalAcrescimo().doubleValue());
        acrescimo = Biblioteca.repete("", 13 - acrescimo.length()) + acrescimo;
        recebido = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalRecebido().doubleValue());
        recebido = Biblioteca.repete("", 13 - recebido.length()) + recebido;
        troco = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalTroco().doubleValue());
        troco = Biblioteca.repete("", 13 - troco.length()) + troco;
        cancelado = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalCancelado().doubleValue());
        cancelado = Biblioteca.repete("", 13 - cancelado.length()) + cancelado;
        totalFinal = Biblioteca.formatoDecimal("V", SessaoUsuario.movimento.getTotalFinal().doubleValue());
        totalFinal = Biblioteca.repete("", 13 - totalFinal.length()) + totalFinal;

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("SUPRIMENTO...: " + suprimento, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("SANGRIA......: " + sangria, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("NAO FISCAL...: " + naoFiscal, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TOTAL VENDA..: " + totalVenda, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("DESCONTO.....: " + desconto, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("ACRESCIMO....: " + acrescimo, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("RECEBIDO.....: " + recebido, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TROCO........: " + troco, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("CANCELADO....: " + cancelado, 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TOTAL FINAL..: " + totalFinal, 0);
        SessaoUsuario.getAcbrEcf().pulaLinhas(3);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("                 CALCULADO  DECLARADO  DIFERENCA", 0);

        totCalculado = BigDecimal.ZERO;
        totDeclarado = BigDecimal.ZERO;
        totDiferenca = BigDecimal.ZERO;

        for (EcfFechamentoVO f : tableModel.getValues()) {
            try {
                ViewTotalPagamentoMovimentoController controllerView = new ViewTotalPagamentoMovimentoController();
                ViewTotalPagamentoMovimentoVO totalPagamentoMovimento = controllerView.getBean(SessaoUsuario.movimento.getId(), f.getTipoPagamento());
                
                if (totalPagamentoMovimento != null) {
                    valorCalculado = totalPagamentoMovimento.getValorApurado();
                } else {
                    valorCalculado = BigDecimal.ZERO;
                }
            } catch (Exception ex) {
                valorCalculado = BigDecimal.ZERO;
            }

            calculado = Biblioteca.formatoDecimal("V", valorCalculado.doubleValue());
            calculado = Biblioteca.repete("", 11 - calculado.length()) + calculado;

            valorDeclarado = f.getValor();
            declarado = Biblioteca.formatoDecimal("V", valorDeclarado.doubleValue());
            declarado = Biblioteca.repete("", 11 - declarado.length()) + declarado;

            valorDiferenca = Biblioteca.subtrai(valorCalculado, valorDeclarado);
            diferenca = Biblioteca.formatoDecimal("V", valorDiferenca.doubleValue());
            diferenca = Biblioteca.repete("", 11 - diferenca.length()) + diferenca;

            meio = f.getTipoPagamento();
            meio = Biblioteca.repete("", 15 - meio.length()) + meio;

            totCalculado = Biblioteca.soma(totCalculado, valorCalculado);
            totDeclarado = Biblioteca.soma(totDeclarado, valorDeclarado);
            totDiferenca = Biblioteca.soma(totDiferenca, valorDiferenca);

            SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial(meio + calculado + declarado + diferenca, 0);

        }

        calculado = Biblioteca.formatoDecimal("V", totCalculado.doubleValue());
        calculado = Biblioteca.repete("", 11 - calculado.length()) + calculado;
        declarado = Biblioteca.formatoDecimal("V", totDeclarado.doubleValue());
        declarado = Biblioteca.repete("", 11 - declarado.length()) + declarado;
        diferenca = Biblioteca.formatoDecimal("V", totDiferenca.doubleValue());
        diferenca = Biblioteca.repete("", 11 - diferenca.length()) + diferenca;

        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("TOTAL.........:" + calculado + declarado + diferenca, 0);
        SessaoUsuario.getAcbrEcf().pulaLinhas(4);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("    ________________________________________    ", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("                 VISTO DO CAIXA                 ", 0);
        SessaoUsuario.getAcbrEcf().pulaLinhas(3);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("    ________________________________________    ", 0);
        SessaoUsuario.getAcbrEcf().linhaRelatorioGerencial("               VISTO DO SUPERVISOR              ", 0);
        
        SessaoUsuario.getAcbrEcf().fechaRelatorio();
        Paf.gravaR06("RG");
    }
}
