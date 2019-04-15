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

public class LeituraMemoriaFiscal extends javax.swing.JDialog {

    public LeituraMemoriaFiscal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        defineFormatoData();

        try {
            int rgb = Integer.valueOf(SessaoUsuario.getConfiguracao().getCorJanelasInternas());

            panelPrincipal.setBackground(new Color(rgb));
            panelComponentes.setBackground(new Color(rgb));
            panelFiltro.setBackground(new Color(rgb));
            panelPeriodo.setBackground(new Color(rgb));
            panelCRZ.setBackground(new Color(rgb));
            panelBotoes.setBackground(new Color(rgb));
            panelOpcao.setBackground(new Color(rgb));
        } catch (Exception ex) {
        }

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

        this.setPreferredSize(new Dimension(530, 300));
        this.pack();
    }

    private void defineFormatoData() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            DefaultFormatterFactory formatter = new DefaultFormatterFactory(mascara);
            dataInicial.setFormatterFactory(formatter);
            dataFinal.setFormatterFactory(formatter);
        } catch (ParseException ex) {
            //ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelFiltro = new javax.swing.JPanel();
        radioPeriodo = new javax.swing.JRadioButton();
        radioCRZ = new javax.swing.JRadioButton();
        panelPeriodo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        panelCRZ = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        primeiroCRZ = new javax.swing.JFormattedTextField();
        ultimoCRZ = new javax.swing.JFormattedTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        panelOpcao = new javax.swing.JPanel();
        radioCompleta = new javax.swing.JRadioButton();
        radioSimplificada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LMFC - Leitura da Memória Fiscal Completa e Simplificada");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaRegistradora01.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelFiltro.setBackground(new Color(255,255,255,0));
        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Filtro:"));
        panelFiltro.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(radioPeriodo);
        radioPeriodo.setSelected(true);
        radioPeriodo.setText("Período de Data");
        radioPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPeriodoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioPeriodo, gridBagConstraints);

        buttonGroup1.add(radioCRZ);
        radioCRZ.setText("Intervalo de CRZ");
        radioCRZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCRZActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioCRZ, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelFiltro, gridBagConstraints);

        panelPeriodo.setBackground(new Color(255,255,255,0));
        panelPeriodo.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Data inicial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Data final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelPeriodo.add(dataInicial, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelPeriodo.add(dataFinal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelPeriodo, gridBagConstraints);

        panelCRZ.setBackground(new Color(255,255,255,0));
        panelCRZ.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Primeiro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCRZ.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Último:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelCRZ.add(jLabel5, gridBagConstraints);

        primeiroCRZ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        primeiroCRZ.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelCRZ.add(primeiroCRZ, gridBagConstraints);

        ultimoCRZ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ultimoCRZ.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCRZ.add(ultimoCRZ, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelCRZ, gridBagConstraints);

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

        panelOpcao.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Leitura:"));
        panelOpcao.setLayout(new java.awt.GridBagLayout());

        buttonGroup3.add(radioCompleta);
        radioCompleta.setSelected(true);
        radioCompleta.setText("Completa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelOpcao.add(radioCompleta, gridBagConstraints);

        buttonGroup3.add(radioSimplificada);
        radioSimplificada.setText("Simplificada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelOpcao.add(radioSimplificada, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelOpcao, gridBagConstraints);

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

    private void radioPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPeriodoActionPerformed
        primeiroCRZ.setEnabled(false);
        ultimoCRZ.setEnabled(false);
        dataInicial.setEnabled(true);
        dataFinal.setEnabled(true);
    }//GEN-LAST:event_radioPeriodoActionPerformed

    private void radioCRZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCRZActionPerformed
        primeiroCRZ.setEnabled(true);
        ultimoCRZ.setEnabled(true);
        dataInicial.setEnabled(false);
        dataFinal.setEnabled(false);
    }//GEN-LAST:event_radioCRZActionPerformed

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        validaPeriodo();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCRZ;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelOpcao;
    private javax.swing.JPanel panelPeriodo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JFormattedTextField primeiroCRZ;
    private javax.swing.JRadioButton radioCRZ;
    private javax.swing.JRadioButton radioCompleta;
    private javax.swing.JRadioButton radioPeriodo;
    private javax.swing.JRadioButton radioSimplificada;
    private javax.swing.JFormattedTextField ultimoCRZ;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            validaPeriodo();
        }
    }

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public void validaPeriodo() {
        if (radioPeriodo.isSelected()) {
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
                    confirma();
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Problemas com os valores informados!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        } else if (radioCRZ.isSelected()) {
            try {
                primeiroCRZ.commitEdit();
                ultimoCRZ.commitEdit();

                if ((Long) primeiroCRZ.getValue() <= 0) {
                    JOptionPane.showMessageDialog(this, "Primeiro CRZ inválido!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    primeiroCRZ.requestFocus();
                } else if ((Long) ultimoCRZ.getValue() <= 0) {
                    JOptionPane.showMessageDialog(this, "Último CRZ inválido!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    ultimoCRZ.requestFocus();
                } else if ((Long) ultimoCRZ.getValue() < (Long) primeiroCRZ.getValue()) {
                    JOptionPane.showMessageDialog(this, "Último CRZ menor que o primeiro CRZ!!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                    ultimoCRZ.requestFocus();
                } else {
                    confirma();
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Problemas com os valores informados!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                primeiroCRZ.requestFocus();
            }
        }
    }

    private void confirma() {
        try {
            String[] opcoes = {"Sim", "Não"};
            if (radioCompleta.isSelected()) {
                int escolha = JOptionPane.showOptionDialog(null, "Deseja imprimir a LMFC - Leitura Memória Fiscal Completa?", "Pergunta do Sistema",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, opcoes, null);
                if (escolha == JOptionPane.YES_OPTION) {
                    if (radioPeriodo.isSelected()) {
                        SessaoUsuario.getAcbrEcf().leituraMemoriaFiscal(Biblioteca.stringToDate(dataInicial.getText()), Biblioteca.stringToDate(dataFinal.getText()), false);
                    } //por reducao
                    else if (radioCRZ.isSelected()) {
                         int primeiro = ((Long) primeiroCRZ.getValue()).intValue();
                         int ultimo = ((Long) ultimoCRZ.getValue()).intValue();
                         SessaoUsuario.getAcbrEcf().leituraMemoriaFiscal(primeiro, ultimo, false);
                    }
                }
            } else if (radioSimplificada.isSelected()) {
                int escolha = JOptionPane.showOptionDialog(null, "Deseja imprimir a LMFS - Leitura Memória Fiscal Simplificada?", "Pergunta do Sistema",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, opcoes, null);
                if (escolha == JOptionPane.YES_OPTION) {
                    if (radioPeriodo.isSelected()) {
                        SessaoUsuario.getAcbrEcf().leituraMemoriaFiscal(Biblioteca.stringToDate(dataInicial.getText()), Biblioteca.stringToDate(dataFinal.getText()), true);
                    } //por reducao
                    else if (radioCRZ.isSelected()) {
                         int primeiro = ((Long) primeiroCRZ.getValue()).intValue();
                         int ultimo = ((Long) ultimoCRZ.getValue()).intValue();
                         SessaoUsuario.getAcbrEcf().leituraMemoriaFiscal(primeiro, ultimo, true);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro na Leitura da Memória Fiscal.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }
}
