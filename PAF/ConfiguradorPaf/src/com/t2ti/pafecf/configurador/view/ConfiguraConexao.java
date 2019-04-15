/*
 * The MIT License
 *
 * Copyright 2014 Claudio.
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
package com.t2ti.pafecf.configurador.view;

import com.t2ti.pafecf.configurador.infra.Biblioteca;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ConfiguraConexao extends java.awt.Dialog {

    private File file;

    /**
     * Creates new form ConfiguraConexao
     */
    public ConfiguraConexao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        file = new File(Biblioteca.ARQUIVO_CONEXAO_BD);
        carregaDados();
    }

    private void testaConexao(String tipo) {
        try {
            if (salvaConfiguracoes(tipo)) {
                try {
                    if (Biblioteca.verificaConexaoBanco(tipo)) {
                        JOptionPane.showMessageDialog(this, "Conexão realizada com sucesso.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException | RuntimeException ex) {
                    mensagemErro(ex);
                }
            }
        } catch (Exception ex) {
            mensagemErro(ex);
        }
    }

    private void mensagemErro(Exception ex) {
        JOptionPane.showMessageDialog(this, "Não foi possível realizar a conexão com o banco de dados.\n" + ex.getMessage() + "\n" + ex.getCause().getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
    }

    private void carregaDados() {
        Properties arquivoConexao = carregaConfiguracoes();
        txtUrl.setText(arquivoConexao.getProperty("sgbd.url"));
        txtUsuario.setText(arquivoConexao.getProperty("sgbd.user"));
        txtSenha.setText(arquivoConexao.getProperty("sgbd.password"));

        txtUrlretaguarda.setText(arquivoConexao.getProperty("sgbd.retaguarda.url"));
        txtUsuarioRetaguarda.setText(arquivoConexao.getProperty("sgbd.retaguarda.user"));
        txtSenhaRetaguarda.setText(arquivoConexao.getProperty("sgbd.retaguarda.password"));

    }

    private boolean salvaConfiguracoes(String tipo) {
        String url = "";
        String usuario = "";
        char[] senha = new char[0];
        if (tipo.equals("Local")) {
            url = txtUrl.getText().trim();
            usuario = txtUsuario.getText().trim();
            senha = txtSenha.getPassword();
        } else if (tipo.equals("Retaguarda")) {
            url = txtUrlretaguarda.getText().trim();
            usuario = txtUsuarioRetaguarda.getText().trim();
            senha = txtSenhaRetaguarda.getPassword();
        }
        
        if (url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a URL de conexão.", "Informação do Sistema", JOptionPane.WARNING_MESSAGE);
        } else if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do usuário.", "Informação do Sistema", JOptionPane.WARNING_MESSAGE);
        } else if (senha.length == 0) {
            JOptionPane.showMessageDialog(this, "Informe a senha.", "Informação do Sistema", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (tipo.equals("Local")) {
                    Properties arquivoConexao = carregaConfiguracoes();
                    arquivoConexao.setProperty("sgbd.driver", getDriver("Local"));
                    arquivoConexao.setProperty("sgbd.url", txtUrl.getText());
                    arquivoConexao.setProperty("sgbd.user", txtUsuario.getText());
                    arquivoConexao.setProperty("sgbd.password", new String(txtSenha.getPassword()));

                    FileOutputStream out = new FileOutputStream(file);
                    arquivoConexao.store(out, "Arquivo de conexao");
                    out.close();
                    return true;
                } else if (tipo.equals("Retaguarda")) {
                    Properties arquivoConexao = carregaConfiguracoes();
                    arquivoConexao.setProperty("sgbd.retaguarda.driver", getDriver("Retaguarda"));
                    arquivoConexao.setProperty("sgbd.retaguarda.url", txtUrlretaguarda.getText());
                    arquivoConexao.setProperty("sgbd.retaguarda.user", txtUsuarioRetaguarda.getText());
                    arquivoConexao.setProperty("sgbd.retaguarda.password", new String(txtSenhaRetaguarda.getPassword()));

                    FileOutputStream out = new FileOutputStream(file);
                    arquivoConexao.store(out, "Arquivo de conexao");
                    out.close();
                    return true;
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar as configurações.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private Properties carregaConfiguracoes() {
        Properties properties = new Properties();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            properties.load(new FileInputStream(file));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao abrir as configurações.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return properties;
    }

    private String getDriver(String tipo) {
        String sgbd = "";
        if (tipo.equals("Local")) {
            sgbd = comboSgdbLocal.getSelectedItem().toString();
        } else if (tipo.equals("Retaguarda")) {
            sgbd = comboSgdbRetaguarda.getSelectedItem().toString();
        }
        
        if (sgbd.equals("Firebird")) {
            return "org.firebirdsql.jdbc.FBDriver";
        } else if (sgbd.equals("PostgreSQL")) {
            return "org.postgresql.Driver";
        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboSgdbLocal = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        botaoTestaConexaoLocal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboSgdbRetaguarda = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUrlretaguarda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUsuarioRetaguarda = new javax.swing.JTextField();
        txtSenhaRetaguarda = new javax.swing.JPasswordField();
        botaoTestaConexaoRetaguarda = new javax.swing.JButton();
        botaoTestaConexaoRetaguarda1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 350));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("SGBD:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        comboSgdbLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Firebird", "PostgreSQL" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(comboSgdbLocal, gridBagConstraints);

        jLabel2.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("URL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(txtUrl, gridBagConstraints);

        jLabel4.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(txtUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(txtSenha, gridBagConstraints);

        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jButton3, gridBagConstraints);

        botaoTestaConexaoLocal.setText("Testar Conexão");
        botaoTestaConexaoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTestaConexaoLocalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(botaoTestaConexaoLocal, gridBagConstraints);

        jTabbedPane1.addTab("Conexão Local", jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("SGBD:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jLabel5, gridBagConstraints);

        comboSgdbRetaguarda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PostgreSQL", "Firebird" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(comboSgdbRetaguarda, gridBagConstraints);

        jLabel6.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jLabel6, gridBagConstraints);

        jLabel7.setText("URL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(txtUrlretaguarda, gridBagConstraints);

        jLabel8.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(txtUsuarioRetaguarda, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(txtSenhaRetaguarda, gridBagConstraints);

        botaoTestaConexaoRetaguarda.setText("Testar Conexão");
        botaoTestaConexaoRetaguarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTestaConexaoRetaguardaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(botaoTestaConexaoRetaguarda, gridBagConstraints);

        botaoTestaConexaoRetaguarda1.setText("Fechar");
        botaoTestaConexaoRetaguarda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTestaConexaoRetaguarda1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(botaoTestaConexaoRetaguarda1, gridBagConstraints);

        jTabbedPane1.addTab("Conexão Retaguarda", jPanel2);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Conexão Retaguarda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        closeDialog(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void botaoTestaConexaoRetaguardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTestaConexaoRetaguardaActionPerformed
        testaConexao("Retaguarda");
    }//GEN-LAST:event_botaoTestaConexaoRetaguardaActionPerformed

    private void botaoTestaConexaoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTestaConexaoLocalActionPerformed
        testaConexao("Local");
    }//GEN-LAST:event_botaoTestaConexaoLocalActionPerformed

    private void botaoTestaConexaoRetaguarda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTestaConexaoRetaguarda1ActionPerformed
        closeDialog(null);
    }//GEN-LAST:event_botaoTestaConexaoRetaguarda1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoTestaConexaoLocal;
    private javax.swing.JButton botaoTestaConexaoRetaguarda;
    private javax.swing.JButton botaoTestaConexaoRetaguarda1;
    private javax.swing.JComboBox comboSgdbLocal;
    private javax.swing.JComboBox comboSgdbRetaguarda;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaRetaguarda;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextField txtUrlretaguarda;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioRetaguarda;
    // End of variables declaration//GEN-END:variables
}
