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
package com.t2ti.pafecf.configurador.view;

import com.t2ti.pafecf.configurador.infra.DragController;
import com.t2ti.pafecf.vo.EcfPosicaoComponentesVO;
import com.t2ti.pafecf.vo.EcfResolucaoVO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Caixa extends javax.swing.JFrame {

// Exercício : Verifique se todos os controles da janela estão sendo tratados. Faça as devidas correções.
    public static Component ComponenteAtivo;
    private EcfResolucaoVO resolucao;

//****************************************************************************//
// Construtor                                                                 //
//****************************************************************************//
    @SuppressWarnings("LeakingThisInConstructor")
    public Caixa(java.awt.Dialog parent, boolean modal, EcfResolucaoVO resolucao) {
        //super(parent, modal);
        initComponents();
        
        this.resolucao = resolucao;

        //Exercício: Implemente o controle visual para os menus abaixo. Mostre os panels quando o usuário pressionar sua tecla de função respectiva.
        panelMenuFiscal.setVisible(false);
        panelMenuOperacoes.setVisible(false);
        panelMenuPrincipal.setVisible(false);
        panelSubMenu.setVisible(false);

        jMenuItemCarregarImagemFundo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        jMenuItemEditarPropriedades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        SetaAcimaAction setaAcimaAction = new SetaAcimaAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_MASK), "SetaAcimaAction");
        containerPrincipal.getActionMap().put("SetaAcimaAction", setaAcimaAction);

        SetaAbaixoAction setaAbaixoAction = new SetaAbaixoAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_MASK), "SetaAbaixoAction");
        containerPrincipal.getActionMap().put("SetaAbaixoAction", setaAbaixoAction);

        SetaDireitaAction setaDireitaAction = new SetaDireitaAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.ALT_MASK), "SetaDireitaAction");
        containerPrincipal.getActionMap().put("SetaDireitaAction", setaDireitaAction);

        SetaEsquerdaAction setaEsquerdaAction = new SetaEsquerdaAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.ALT_MASK), "SetaEsquerdaAction");
        containerPrincipal.getActionMap().put("SetaEsquerdaAction", setaEsquerdaAction);

        F12Action f12Action = new F12Action();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "F12Action");
        containerPrincipal.getActionMap().put("F12Action", f12Action);

        ESCAction escAction = new ESCAction();
        containerPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAction");
        containerPrincipal.getActionMap().put("ESCAction", escAction);
        
        DragController mouseController = new DragController();
        // Exercício: Implemente o Drag and Drop para a Bobina
        bobina.addMouseListener(mouseController);
        bobina.addMouseMotionListener(mouseController);
        for (Component componente : containerPrincipal.getComponents()) {
            componente.addMouseListener(mouseController);
            componente.addMouseMotionListener(mouseController);
        }

        // Exercício: Destaque o componente que está com o Foco
        KeyboardFocusManager focusManager =
                KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();
                        if (("focusOwner".equals(prop)) && 
                                ((e.getNewValue()) instanceof Component) && 
                                !((e.getNewValue()) instanceof JMenuItem) && 
                                !((e.getNewValue()) instanceof javax.swing.JRootPane)) 
                        {
                            ComponenteAtivo = (Component) e.getNewValue();
                        }
                    }
                });

        setResolucao(this);
        /*
        this.setPreferredSize(new Dimension(Configuracao.configuracao.getResolucaoVO().getLargura(), Configuracao.configuracao.getResolucaoVO().getAltura()));
        containerPrincipal.setPreferredSize(new Dimension(Configuracao.configuracao.getResolucaoVO().getLargura(), Configuracao.configuracao.getResolucaoVO().getAltura()));
        labelImagemTela.setBounds(0, 0, Configuracao.configuracao.getResolucaoVO().getLargura(), Configuracao.configuracao.getResolucaoVO().getAltura());
        */
        this.pack();
        setLocationRelativeTo(null);
    }

// ***************************************************************************//
// Actions vinculadas ao pressionamento de teclas                             //
// ***************************************************************************//
    private class SetaAcimaAction extends AbstractAction {

        public SetaAcimaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            if (ComponenteAtivo.getName().equals("Bobina")) {
                panelBobina.setLocation(panelBobina.getBounds().x, panelBobina.getBounds().y - 1);
            } else {
                ComponenteAtivo.setLocation(ComponenteAtivo.getBounds().x, ComponenteAtivo.getBounds().y - 1);
            }
        }
    }

    private class SetaAbaixoAction extends AbstractAction {

        public SetaAbaixoAction() {
        }

        public void actionPerformed(ActionEvent e) {
            if (ComponenteAtivo.getName().equals("Bobina")) {
                panelBobina.setLocation(panelBobina.getBounds().x, panelBobina.getBounds().y + 1);
            } else {
                ComponenteAtivo.setLocation(ComponenteAtivo.getBounds().x, ComponenteAtivo.getBounds().y + 1);
            }
        }
    }

    private class SetaDireitaAction extends AbstractAction {

        public SetaDireitaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            if (ComponenteAtivo.getName().equals("Bobina")) {
                panelBobina.setLocation(panelBobina.getBounds().x + 1, panelBobina.getBounds().y);
            } else {
                ComponenteAtivo.setLocation(ComponenteAtivo.getBounds().x + 1, ComponenteAtivo.getBounds().y);
            }
        }
    }

    private class SetaEsquerdaAction extends AbstractAction {

        public SetaEsquerdaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            if (ComponenteAtivo.getName().equals("Bobina")) {
                panelBobina.setLocation(panelBobina.getBounds().x - 1, panelBobina.getBounds().y);
            } else {
                ComponenteAtivo.setLocation(ComponenteAtivo.getBounds().x - 1, ComponenteAtivo.getBounds().y);
            }
        }
    }

    private class F12Action extends AbstractAction {

        public F12Action() {
        }

        public void actionPerformed(ActionEvent e) {
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Deseja salvar as alterações antes de fechar a janela?", "Pergunta do Sistema",
                    JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
            if (escolha == JOptionPane.YES_OPTION) {
                GravarAlteracoes();
            }
            dispose();
        }
    }

    private class ESCAction extends AbstractAction {

        public ESCAction() {
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemCarregarImagemFundo = new javax.swing.JMenuItem();
        jMenuItemEditarPropriedades = new javax.swing.JMenuItem();
        containerPrincipal = new javax.swing.JLayeredPane();
        labelTitulo = new javax.swing.JLabel();
        labelOperador = new javax.swing.JLabel();
        labelCaixa = new javax.swing.JLabel();
        panelSubMenu = new javax.swing.JPanel();
        panelCard = new javax.swing.JPanel();
        panelSubMenuGerente = new javax.swing.JScrollPane();
        listaSubMenuGerente = new javax.swing.JList();
        panelSubMenuSupervisor = new javax.swing.JScrollPane();
        listaSubMenuSupervisor = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        panelMenuPrincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMenuPrincipal = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        panelMenuOperacoes = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaMenuOperacoes = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        panelMenuFiscal = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaMenuFiscal = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        panelBobina = new javax.swing.JScrollPane();
        bobina = new javax.swing.JList();
        editCodigo = new javax.swing.JFormattedTextField();
        editQuantidade = new javax.swing.JFormattedTextField();
        editSubTotal = new javax.swing.JFormattedTextField();
        editTotalItem = new javax.swing.JFormattedTextField();
        labelImagemProduto = new javax.swing.JLabel();
        labelDescricaoProduto = new javax.swing.JLabel();
        labelTotalGeral = new javax.swing.JLabel();
        labelMensagens = new javax.swing.JLabel();
        editUnitario = new javax.swing.JFormattedTextField();
        panelBotoes = new javax.swing.JLabel();
        labelImagemTela = new javax.swing.JLabel();

        jPopupMenu1.setName("JPopupMenu"); // NOI18N

        jMenuItemCarregarImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgBotoes/view_16.png"))); // NOI18N
        jMenuItemCarregarImagemFundo.setText("Carregar Imagem de Fundo");
        jMenuItemCarregarImagemFundo.setName("jMenuItemCarregarImagemFundo"); // NOI18N
        jMenuItemCarregarImagemFundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarregarImagemFundoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemCarregarImagemFundo);

        jMenuItemEditarPropriedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgBotoes/tree_16.png"))); // NOI18N
        jMenuItemEditarPropriedades.setText("Editar Propriedades");
        jMenuItemEditarPropriedades.setName("jMenuItemEditarPropriedades"); // NOI18N
        jMenuItemEditarPropriedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarPropriedadesActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEditarPropriedades);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        containerPrincipal.setName("containerPrincipal"); // NOI18N
        containerPrincipal.setPreferredSize(new java.awt.Dimension(1024, 738));

        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("T2Ti PDV - T2Ti Tecnologia da Informação Ltda. (61) 3042.5277");
        labelTitulo.setToolTipText("Título da janela");
        labelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelTitulo.setComponentPopupMenu(jPopupMenu1);
        labelTitulo.setName("labelTitulo"); // NOI18N
        labelTitulo.setRequestFocusEnabled(false);
        containerPrincipal.add(labelTitulo);
        labelTitulo.setBounds(300, 10, 710, 20);

        labelOperador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelOperador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelOperador.setText("Operador");
        labelOperador.setToolTipText("Nome do Operador");
        labelOperador.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelOperador.setComponentPopupMenu(jPopupMenu1);
        labelOperador.setName("labelOperador"); // NOI18N
        labelOperador.setNextFocusableComponent(labelTitulo);
        containerPrincipal.add(labelOperador);
        labelOperador.setBounds(754, 60, 230, 14);

        labelCaixa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCaixa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCaixa.setText("Caixa");
        labelCaixa.setToolTipText("Nome do Terminal de Caixa");
        labelCaixa.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelCaixa.setComponentPopupMenu(jPopupMenu1);
        labelCaixa.setName("labelCaixa"); // NOI18N
        labelCaixa.setNextFocusableComponent(labelOperador);
        containerPrincipal.add(labelCaixa);
        labelCaixa.setBounds(754, 80, 230, 14);

        panelSubMenu.setBackground(new Color(255,255,255,0));
        panelSubMenu.setName("panelSubMenu"); // NOI18N
        panelSubMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCard.setLayout(new java.awt.CardLayout());

        panelSubMenuGerente.setBorder(null);
        panelSubMenuGerente.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaSubMenuGerente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listaSubMenuGerente.setForeground(new java.awt.Color(153, 0, 0));
        listaSubMenuGerente.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        panelSubMenuGerente.setViewportView(listaSubMenuGerente);

        panelCard.add(panelSubMenuGerente, "cardGerente");

        panelSubMenuSupervisor.setBorder(null);
        panelSubMenuSupervisor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaSubMenuSupervisor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listaSubMenuSupervisor.setForeground(new java.awt.Color(153, 0, 0));
        listaSubMenuSupervisor.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        panelSubMenuSupervisor.setViewportView(listaSubMenuSupervisor);

        panelCard.add(panelSubMenuSupervisor, "cardSupervisor");

        panelSubMenu.add(panelCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 22, 450, 180));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/SubMenu.png"))); // NOI18N
        panelSubMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containerPrincipal.add(panelSubMenu);
        panelSubMenu.setBounds(10, 280, 467, 212);

        panelMenuPrincipal.setBackground(new Color(255,255,255,0));
        panelMenuPrincipal.setName("panelMenuPrincipal"); // NOI18N
        panelMenuPrincipal.setPreferredSize(new java.awt.Dimension(213, 200));
        panelMenuPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menu Principal");
        panelMenuPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 190, -1));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenuPrincipal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listaMenuPrincipal.setForeground(new java.awt.Color(102, 102, 102));
        listaMenuPrincipal.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaMenuPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMenuPrincipal.setAutoscrolls(false);
        jScrollPane2.setViewportView(listaMenuPrincipal);

        panelMenuPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 200, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/Menu.png"))); // NOI18N
        panelMenuPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containerPrincipal.add(panelMenuPrincipal);
        panelMenuPrincipal.setBounds(685, 40, 213, 200);

        panelMenuOperacoes.setBackground(new Color(255,255,255,0));
        panelMenuOperacoes.setName("panelMenuOperacoes"); // NOI18N
        panelMenuOperacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Menu Operações");
        panelMenuOperacoes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 190, -1));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenuOperacoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listaMenuOperacoes.setForeground(new java.awt.Color(102, 102, 102));
        listaMenuOperacoes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaMenuOperacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMenuOperacoes.setAutoscrolls(false);
        jScrollPane4.setViewportView(listaMenuOperacoes);

        panelMenuOperacoes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 200, 160));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/Menu.png"))); // NOI18N
        panelMenuOperacoes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containerPrincipal.add(panelMenuOperacoes);
        panelMenuOperacoes.setBounds(715, 40, 213, 200);

        panelMenuFiscal.setBackground(new Color(255,255,255,0));
        panelMenuFiscal.setName("panelMenuFiscal"); // NOI18N
        panelMenuFiscal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Menu Fiscal");
        panelMenuFiscal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 190, -1));

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenuFiscal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listaMenuFiscal.setForeground(new java.awt.Color(102, 102, 102));
        listaMenuFiscal.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaMenuFiscal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMenuFiscal.setAutoscrolls(false);
        listaMenuFiscal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane5.setViewportView(listaMenuFiscal);

        panelMenuFiscal.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 35, 200, 160));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/Menu.png"))); // NOI18N
        panelMenuFiscal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        containerPrincipal.add(panelMenuFiscal);
        panelMenuFiscal.setBounds(745, 40, 213, 200);

        panelBobina.setBorder(null);
        panelBobina.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelBobina.setName("panelBobina"); // NOI18N

        bobina.setBackground(java.awt.SystemColor.control);
        bobina.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        bobina.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "------------------------------------------------", "               ** CUPOM FISCAL **               ", "------------------------------------------------", "ITEM CÓDIGO         DESCRIÇÃO                   ", "QTD.     UN      VL.UNIT.(R$) ST    VL.ITEM(R$)", "------------------------------------------------" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        bobina.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bobina.setComponentPopupMenu(jPopupMenu1);
        bobina.setName("Bobina"); // NOI18N
        panelBobina.setViewportView(bobina);

        containerPrincipal.add(panelBobina);
        panelBobina.setBounds(40, 240, 405, 360);

        editCodigo.setBackground(new java.awt.Color(204, 204, 204));
        editCodigo.setBorder(null);
        editCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editCodigo.setText("1234567891012");
        editCodigo.setToolTipText("Código do Item");
        editCodigo.setComponentPopupMenu(jPopupMenu1);
        editCodigo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        editCodigo.setName("editCodigo"); // NOI18N
        containerPrincipal.add(editCodigo);
        editCodigo.setBounds(490, 262, 200, 30);

        editQuantidade.setBackground(new java.awt.Color(204, 204, 204));
        editQuantidade.setBorder(null);
        editQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editQuantidade.setText("0,000");
        editQuantidade.setToolTipText("Quantidade do Item");
        editQuantidade.setComponentPopupMenu(jPopupMenu1);
        editQuantidade.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        editQuantidade.setName("editQuantidade"); // NOI18N
        containerPrincipal.add(editQuantidade);
        editQuantidade.setBounds(490, 362, 200, 30);

        editSubTotal.setBackground(new java.awt.Color(204, 204, 204));
        editSubTotal.setBorder(null);
        editSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editSubTotal.setText("0,00");
        editSubTotal.setToolTipText("Valor Subtotal");
        editSubTotal.setComponentPopupMenu(jPopupMenu1);
        editSubTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        editSubTotal.setName("editSubTotal"); // NOI18N
        editSubTotal.setNextFocusableComponent(labelTotalGeral);
        containerPrincipal.add(editSubTotal);
        editSubTotal.setBounds(730, 562, 250, 30);

        editTotalItem.setBackground(new java.awt.Color(204, 204, 204));
        editTotalItem.setBorder(null);
        editTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editTotalItem.setText("0,00");
        editTotalItem.setToolTipText("Valor Total do Item");
        editTotalItem.setComponentPopupMenu(jPopupMenu1);
        editTotalItem.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        editTotalItem.setName("editTotalItem"); // NOI18N
        editTotalItem.setNextFocusableComponent(editSubTotal);
        containerPrincipal.add(editTotalItem);
        editTotalItem.setBounds(490, 562, 200, 30);

        labelImagemProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/padrao.png"))); // NOI18N
        labelImagemProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelImagemProduto.setComponentPopupMenu(jPopupMenu1);
        labelImagemProduto.setName("imageProduto"); // NOI18N
        labelImagemProduto.setNextFocusableComponent(labelDescricaoProduto);
        containerPrincipal.add(labelImagemProduto);
        labelImagemProduto.setBounds(730, 250, 250, 250);

        labelDescricaoProduto.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        labelDescricaoProduto.setForeground(new java.awt.Color(255, 255, 255));
        labelDescricaoProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescricaoProduto.setText("Produto para venda");
        labelDescricaoProduto.setToolTipText("Descrição do Produto");
        labelDescricaoProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelDescricaoProduto.setComponentPopupMenu(jPopupMenu1);
        labelDescricaoProduto.setName("labelDescricaoProduto"); // NOI18N
        labelDescricaoProduto.setNextFocusableComponent(labelCaixa);
        labelDescricaoProduto.setVerifyInputWhenFocusTarget(false);
        containerPrincipal.add(labelDescricaoProduto);
        labelDescricaoProduto.setBounds(40, 110, 945, 83);

        labelTotalGeral.setFont(new java.awt.Font("Verdana", 1, 27)); // NOI18N
        labelTotalGeral.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalGeral.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalGeral.setText("2.785.565,44");
        labelTotalGeral.setToolTipText("Total Geral da Venda");
        labelTotalGeral.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelTotalGeral.setComponentPopupMenu(jPopupMenu1);
        labelTotalGeral.setName("labelTotalGeral"); // NOI18N
        labelTotalGeral.setNextFocusableComponent(labelMensagens);
        containerPrincipal.add(labelTotalGeral);
        labelTotalGeral.setBounds(40, 652, 400, 40);

        labelMensagens.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelMensagens.setForeground(new java.awt.Color(255, 255, 0));
        labelMensagens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensagens.setText("<html><center>Todas as mensagens do sistema devem ser direcionadas para cá</center></html>");
        labelMensagens.setToolTipText("Mensagens do Sistema");
        labelMensagens.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        labelMensagens.setComponentPopupMenu(jPopupMenu1);
        labelMensagens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelMensagens.setName("labelMensagens"); // NOI18N
        labelMensagens.setNextFocusableComponent(labelImagemProduto);
        labelMensagens.setPreferredSize(new java.awt.Dimension(772, 20));
        containerPrincipal.add(labelMensagens);
        labelMensagens.setBounds(485, 650, 500, 45);
        labelMensagens.getAccessibleContext().setAccessibleName("<html>Todas as mensagens do sistema devem ser direcionadas para cá</html>");

        editUnitario.setBackground(new java.awt.Color(204, 204, 204));
        editUnitario.setBorder(null);
        editUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editUnitario.setText("0,00");
        editUnitario.setToolTipText("Valor Unitário do Item");
        editUnitario.setComponentPopupMenu(jPopupMenu1);
        editUnitario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        editUnitario.setName("editUnitario"); // NOI18N
        containerPrincipal.add(editUnitario);
        editUnitario.setBounds(490, 462, 200, 30);

        panelBotoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/PanelBotoes.png"))); // NOI18N
        panelBotoes.setToolTipText("Panel dos Botões");
        panelBotoes.setComponentPopupMenu(jPopupMenu1);
        panelBotoes.setName("panelBotoes"); // NOI18N
        containerPrincipal.add(panelBotoes);
        panelBotoes.setBounds(17, 703, 988, 56);

        labelImagemTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLayout/Tela1024x768.jpg"))); // NOI18N
        labelImagemTela.setFocusable(false);
        labelImagemTela.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        labelImagemTela.setName("labelImagemTela"); // NOI18N
        labelImagemTela.setRequestFocusEnabled(false);
        containerPrincipal.add(labelImagemTela);
        labelImagemTela.setBounds(0, 0, 1024, 768);

        getContentPane().add(containerPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCarregarImagemFundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarregarImagemFundoActionPerformed
        try {
            JFileChooser abrir = new JFileChooser();
            int retorno = abrir.showOpenDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                labelImagemTela.setIcon(new ImageIcon(abrir.getSelectedFile().getAbsolutePath()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jMenuItemCarregarImagemFundoActionPerformed

    private void jMenuItemEditarPropriedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarPropriedadesActionPerformed
        
        // Exercício: Procure descobrir se tem como alterar as propriedades Bounds do controle selecionado
        // Exercício: Busque outras soluções para Property Editor na Internet
        // Exercício: Veja se é possível utilizar o próprio Property Editor do NetBeans
        // Exercício: Crie o seu próprio Editor de Propriedades carregando as propriedades que o usuário pode mexer e no nosso idioma
        
        try {
            ObjectInspectorJFrame objectInspectorJFrame = new ObjectInspectorJFrame(ComponenteAtivo);
            objectInspectorJFrame.setVisible(true);
            objectInspectorJFrame.setBounds(0, 0, 400, 600);
            objectInspectorJFrame.setState(java.awt.Frame.NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemEditarPropriedadesActionPerformed

    private void setResolucao(Container container) {
        String nomeFonte = "";
        int estiloFonte = 0;
        //
        List<EcfPosicaoComponentesVO> listaPosicoes = resolucao.getListaEcfPosicaoComponente();
        EcfPosicaoComponentesVO posicaoComponente;
        String nomeComponente = "";

        for (Component componente : container.getComponents()) {
            nomeComponente = componente.getName();
            if (nomeComponente != null) {
                for (int i = 0; i < listaPosicoes.size(); i++) {
                    posicaoComponente = listaPosicoes.get(i);
                    if (posicaoComponente.getNome().equals(nomeComponente)) {
                        ((JComponent) componente).setBounds(posicaoComponente.getEsquerda(), posicaoComponente.getTopo(), posicaoComponente.getLargura(), posicaoComponente.getAltura());
                        if (posicaoComponente.getTamanhoFonte() > 0) {
                            nomeFonte = ((JComponent) componente).getFont().getName();
                            estiloFonte = ((JComponent) componente).getFont().getStyle();
                            ((JComponent) componente).setFont(new Font(nomeFonte, estiloFonte, posicaoComponente.getTamanhoFonte()));
                        }
                        if (componente instanceof JLabel) {
                            //((JLabel) componente).setText(posicaoComponente.getTextoComponente());
                        }
                        break;
                    }
                }
            }
            setResolucao((Container) componente);
        }
    }
    
    public void GravarAlteracoes() {
            List<EcfPosicaoComponentesVO>  listaPosicoes = new ArrayList<>();
            
            for (Component componente : containerPrincipal.getComponents()) 
            {
                EcfPosicaoComponentesVO posicaoComponente = new EcfPosicaoComponentesVO();

                posicaoComponente.setEcfResolucao(resolucao);
                posicaoComponente.setNome(componente.getName());
                posicaoComponente.setAltura(componente.getHeight());
                posicaoComponente.setEsquerda(componente.getX());
                posicaoComponente.setTopo(componente.getY());
                posicaoComponente.setLargura(componente.getWidth());

                if (componente instanceof JLabel) {
                    posicaoComponente.setTamanhoFonte(((JLabel)componente).getFont().getSize());
                    posicaoComponente.setTexto(((JLabel)componente).getText());
                } else {
                    posicaoComponente.setTamanhoFonte(0);
                }
                
                listaPosicoes.add(posicaoComponente);
            }

            //Exercício: grave as alterações realizadas no banco de dados.
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList bobina;
    private javax.swing.JLayeredPane containerPrincipal;
    private javax.swing.JFormattedTextField editCodigo;
    private javax.swing.JFormattedTextField editQuantidade;
    private javax.swing.JFormattedTextField editSubTotal;
    private javax.swing.JFormattedTextField editTotalItem;
    private javax.swing.JFormattedTextField editUnitario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItemCarregarImagemFundo;
    private javax.swing.JMenuItem jMenuItemEditarPropriedades;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelCaixa;
    private javax.swing.JLabel labelDescricaoProduto;
    public static javax.swing.JLabel labelImagemProduto;
    private javax.swing.JLabel labelImagemTela;
    private static javax.swing.JLabel labelMensagens;
    private javax.swing.JLabel labelOperador;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTotalGeral;
    private javax.swing.JList listaMenuFiscal;
    private javax.swing.JList listaMenuOperacoes;
    private javax.swing.JList listaMenuPrincipal;
    private javax.swing.JList listaSubMenuGerente;
    private javax.swing.JList listaSubMenuSupervisor;
    private javax.swing.JScrollPane panelBobina;
    private javax.swing.JLabel panelBotoes;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelMenuFiscal;
    private javax.swing.JPanel panelMenuOperacoes;
    private javax.swing.JPanel panelMenuPrincipal;
    private javax.swing.JPanel panelSubMenu;
    private javax.swing.JScrollPane panelSubMenuGerente;
    private javax.swing.JScrollPane panelSubMenuSupervisor;
    // End of variables declaration//GEN-END:variables
}
