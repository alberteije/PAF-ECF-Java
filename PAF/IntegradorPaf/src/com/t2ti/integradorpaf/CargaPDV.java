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
package com.t2ti.integradorpaf;

import com.t2ti.integradorpaf.controller.ImportaController;
import com.t2ti.pafecf.infra.Biblioteca;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class CargaPDV extends javax.swing.JFrame {

    private String pathCargaRemoto;
    private String pathCargaLocal;
    private File diretorio;
    private File[] listaArquivos;
    private File arquivoRemoto;
    private File arquivoLocal;
    private FilenameFilter filtroSemaforo;
    private FilenameFilter filtroTxt;
    private Integer posicaoArquivoLista;

    /**
     * Creates new form CargaPDV
     */
    public CargaPDV() {
        initComponents();
        carregaConfiguracoes();
        iniciaThread();
    }

    private void carregaConfiguracoes() {
        try {
            Properties arquivoConexao = new Properties();
            arquivoConexao.load(new FileInputStream(new File(System.getProperty("user.dir")
                    + System.getProperty("file.separator")
                    + "conexao.properties")));
            pathCargaRemoto = arquivoConexao.getProperty("importa.RemoteApp");
            if (pathCargaRemoto == null) {
                JOptionPane.showMessageDialog(this, "Diretório de integração não definido.");
                System.exit(0);
            } else {
                diretorio = new File(pathCargaRemoto);
                if (!diretorio.exists()) {
                    JOptionPane.showMessageDialog(this, "Diretório de integração não existe.");
                    System.exit(0);
                }
            }

            pathCargaLocal = System.getProperty("user.dir") + System.getProperty("file.separator") + "integracao" + System.getProperty("file.separator");
            File pastaIntegracaoLocal = new File(pathCargaLocal);
            if (!pastaIntegracaoLocal.exists()) {
                pastaIntegracaoLocal.mkdirs();
            }
            filtroSemaforo = new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".semaforo");
                }
            };
            filtroTxt = new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            };
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar as configurações.");
            System.exit(0);
        }
    }

    private void iniciaThread() {
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        listaArquivos = diretorio.listFiles(filtroSemaforo);
                        if (listaArquivos.length == 0) {
                            listaArquivos = diretorio.listFiles(filtroTxt);
                            posicaoArquivoLista = 0;
                            for (File f : listaArquivos) {
                                posicaoArquivoLista++;
                                arquivoRemoto = f;
                                processaCarga();
                                if (Biblioteca.MD5File(arquivoLocal.getAbsolutePath()).equals(Biblioteca.MD5File(arquivoRemoto.getAbsolutePath()))) {
                                    f.delete();
                                }
                            }
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void processaCarga() {
        SwingWorker worker = new SwingWorker<Object, Integer>() {

            @Override
            protected Object doInBackground() throws Exception {
                arquivoLocal = new File(pathCargaLocal + arquivoRemoto.getName());
                Biblioteca.copy(arquivoRemoto, arquivoLocal, true);
                setTitle("Integrador - Processando arquivo(" + arquivoLocal.getName() + ")");
                jProgressBar1.setIndeterminate(false);
                jProgressBar1.setValue(100 * posicaoArquivoLista / listaArquivos.length);
                ImportaController controller = new ImportaController();
                controller.importaDadosPdv(arquivoLocal);

                return null;
            }

            @Override
            protected void done() {
                setTitle("Integrador");
                jProgressBar1.setIndeterminate(true);
            }

        };
        worker.execute();
        try {
            worker.get();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Integrador");
        setPreferredSize(new java.awt.Dimension(500, 80));
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(jProgressBar1, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargaPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaPDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
