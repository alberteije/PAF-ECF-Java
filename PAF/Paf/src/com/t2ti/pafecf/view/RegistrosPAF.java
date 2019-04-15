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

import com.t2ti.pafecf.infra.Biblioteca;
import com.t2ti.pafecf.infra.Paf;
import com.t2ti.pafecf.infra.SessaoUsuario;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.HashSet;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class RegistrosPAF extends javax.swing.JDialog {

    public RegistrosPAF(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            int rgb = Integer.valueOf(SessaoUsuario.getConfiguracao().getCorJanelasInternas());

            panelPrincipal.setBackground(new Color(rgb));
            panelComponentes.setBackground(new Color(rgb));
            panelFiltro.setBackground(new Color(rgb));
            panelCodigo.setBackground(new Color(rgb));
            panelBotoes.setBackground(new Color(rgb));
            panelDescricao.setBackground(new Color(rgb));
            panelPeriodo.setBackground(new Color(rgb));
            jPanel2.setBackground(new Color(rgb));
        } catch (Exception ex) {
        }

        defineFormatoData();

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

        this.setPreferredSize(new Dimension(530, 400));
        jPanel2.setVisible(false);
        this.pack();
    }

    private void defineFormatoData() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            DefaultFormatterFactory formatter = new DefaultFormatterFactory(mascara);
            dataInicial.setFormatterFactory(formatter);
            dataFinal.setFormatterFactory(formatter);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelFiltro = new javax.swing.JPanel();
        radioEstoqueTotal = new javax.swing.JRadioButton();
        radioEstoqueParcial = new javax.swing.JRadioButton();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        radioCodigoProduto = new javax.swing.JRadioButton();
        radioDescricaoMercadoria = new javax.swing.JRadioButton();
        panelDescricao = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editParte01 = new javax.swing.JTextField();
        editParte02 = new javax.swing.JTextField();
        panelCodigo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editPrimeiroCodigo = new javax.swing.JFormattedTextField();
        editUltimoCodigo = new javax.swing.JFormattedTextField();
        panelPeriodo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registros PAF-ECF");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setPreferredSize(new java.awt.Dimension(530, 300));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaRegistradora01.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelFiltro.setBackground(new Color(255,255,255,0));
        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Sub Categoria:"));
        panelFiltro.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(radioEstoqueTotal);
        radioEstoqueTotal.setSelected(true);
        radioEstoqueTotal.setText("a) Estoque Total");
        radioEstoqueTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEstoqueTotalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioEstoqueTotal, gridBagConstraints);

        buttonGroup1.add(radioEstoqueParcial);
        radioEstoqueParcial.setText("b) Estoque Parcial");
        radioEstoqueParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEstoqueParcialActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioEstoqueParcial, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelFiltro, gridBagConstraints);

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

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Filtro:"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        buttonGroup2.add(radioCodigoProduto);
        radioCodigoProduto.setSelected(true);
        radioCodigoProduto.setText("Código do Produto");
        radioCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCodigoProdutoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(radioCodigoProduto, gridBagConstraints);

        buttonGroup2.add(radioDescricaoMercadoria);
        radioDescricaoMercadoria.setText("Descrição da Mercadoria");
        radioDescricaoMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDescricaoMercadoriaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(radioDescricaoMercadoria, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel2.add(jPanel1, gridBagConstraints);

        panelDescricao.setBackground(new Color(255,255,255,0));
        panelDescricao.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Parte 01:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDescricao.add(jLabel4, gridBagConstraints);

        jLabel5.setText("ou Parte 02:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDescricao.add(jLabel5, gridBagConstraints);

        editParte01.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDescricao.add(editParte01, gridBagConstraints);

        editParte02.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelDescricao.add(editParte02, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(panelDescricao, gridBagConstraints);

        panelCodigo.setBackground(new Color(255,255,255,0));
        panelCodigo.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Primeiro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCodigo.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Último:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCodigo.add(jLabel3, gridBagConstraints);

        editPrimeiroCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCodigo.add(editPrimeiroCodigo, gridBagConstraints);

        editUltimoCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCodigo.add(editUltimoCodigo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(panelCodigo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(jPanel2, gridBagConstraints);

        panelPeriodo.setBackground(new Color(255,255,255,0));
        panelPeriodo.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Data inicial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Data final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelPeriodo.add(dataInicial, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelPeriodo.add(dataFinal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelPeriodo, gridBagConstraints);

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

    private void radioEstoqueTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEstoqueTotalActionPerformed
        jPanel2.setVisible(false);
    }//GEN-LAST:event_radioEstoqueTotalActionPerformed

    private void radioEstoqueParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEstoqueParcialActionPerformed
        jPanel2.setVisible(true);
    }//GEN-LAST:event_radioEstoqueParcialActionPerformed

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        validaInformacoes();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed

    private void radioCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCodigoProdutoActionPerformed
        editPrimeiroCodigo.setEnabled(true);
        editUltimoCodigo.setEnabled(true);
        editParte01.setEnabled(false);
        editParte02.setEnabled(false);
    }//GEN-LAST:event_radioCodigoProdutoActionPerformed

    private void radioDescricaoMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDescricaoMercadoriaActionPerformed
        editPrimeiroCodigo.setEnabled(false);
        editUltimoCodigo.setEnabled(false);
        editParte01.setEnabled(true);
        editParte02.setEnabled(true);
    }//GEN-LAST:event_radioDescricaoMercadoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JTextField editParte01;
    private javax.swing.JTextField editParte02;
    private javax.swing.JFormattedTextField editPrimeiroCodigo;
    private javax.swing.JFormattedTextField editUltimoCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelDescricao;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelPeriodo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioCodigoProduto;
    private javax.swing.JRadioButton radioDescricaoMercadoria;
    private javax.swing.JRadioButton radioEstoqueParcial;
    private javax.swing.JRadioButton radioEstoqueTotal;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            validaInformacoes();
        }
    }

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public boolean validaPeriodo() {
        try {
            dataInicial.commitEdit();
            dataFinal.commitEdit();
            if (!Biblioteca.isDataValida(dataInicial.getText())) {
                JOptionPane.showMessageDialog(this, "Data inicial inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                dataInicial.requestFocus();
            } else if (!Biblioteca.isDataValida(dataFinal.getText())) {
                JOptionPane.showMessageDialog(this, "Data final inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                dataFinal.requestFocus();
            } else {
                return true;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Problemas com os valores informados!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void validaInformacoes() {
        if (validaPeriodo()) {
            if (radioEstoqueParcial.isSelected()) {
                if (radioCodigoProduto.isSelected()) {
                    try {
                        editPrimeiroCodigo.commitEdit();
                        editUltimoCodigo.commitEdit();

                        if ((Long) editPrimeiroCodigo.getValue() <= 0) {
                            JOptionPane.showMessageDialog(this, "Primeiro código inválido!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            editPrimeiroCodigo.requestFocus();
                        } else if ((Long) editUltimoCodigo.getValue() <= 0) {
                            JOptionPane.showMessageDialog(this, "Último código inválido!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            editUltimoCodigo.requestFocus();
                        } else if ((Long) editUltimoCodigo.getValue() < (Long) editPrimeiroCodigo.getValue()) {
                            JOptionPane.showMessageDialog(this, "Último código menor que o primeiro código!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                            editUltimoCodigo.requestFocus();
                        } else {
                            confirma();
                        }
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(this, "Problemas com os valores informados!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                        editPrimeiroCodigo.requestFocus();
                    }
                } else if (radioDescricaoMercadoria.isSelected()) {
                    if (editParte01.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(this, "Informe a primeira descrição", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                        editParte01.requestFocus();
                    } else {
                        confirma();
                    }
                }
            } else {
                confirma();
            }
        }
    }

    private void confirma() {
        String[] opcoes = {"Sim", "Não"};
        int escolha = JOptionPane.showOptionDialog(null, "Deseja gerar o arquivo Registros PAF-ECF?", "Pergunta do Sistema",
                JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opcoes, null);
        if (escolha == JOptionPane.YES_OPTION) {
            try {

                if (radioEstoqueTotal.isSelected()) {
                    //estoque total
                    Paf.geraRegistrosPAF(Biblioteca.stringToDate(dataInicial.getText()), Biblioteca.stringToDate(dataFinal.getText()), "T", "", "", "", null);
                } else if (radioEstoqueParcial.isSelected()) {
                    //estoque parcial
                    if (radioCodigoProduto.isSelected()) {
                        Paf.geraRegistrosPAF(Biblioteca.stringToDate(dataInicial.getText()), Biblioteca.stringToDate(dataFinal.getText()), "P", "C", editPrimeiroCodigo.getText().trim(), editUltimoCodigo.getText().trim(), null);
                    } else {
                        Paf.geraRegistrosPAF(Biblioteca.stringToDate(dataInicial.getText()), Biblioteca.stringToDate(dataFinal.getText()), "P", "N", editParte01.getText().trim(), editParte02.getText().trim(), null);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao gerar o arquivo Registros PAF-ECF" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
