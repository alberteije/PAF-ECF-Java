package com.t2ti.pafecf.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ECF_RESOLUCAO]</p>
*
* <p>The MIT License</p>
*
* <p>Copyright: Copyright (C) 2010 T2Ti.COM
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
*        The author may be contacted at:
*            t2ti.com@gmail.com</p>
*
* @author Claudio de Barros (t2ti.com@gmail.com)
* @version 2.0
*/
@Entity
@Table(name = "ECF_RESOLUCAO")
public class EcfResolucaoVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RESOLUCAO_TELA")
    private String resolucaoTela;
    @Column(name = "LARGURA")
    private Integer largura;
    @Column(name = "ALTURA")
    private Integer altura;
    @Column(name = "IMAGEM_TELA")
    private String imagemTela;
    @Column(name = "IMAGEM_MENU")
    private String imagemMenu;
    @Column(name = "IMAGEM_SUBMENU")
    private String imagemSubmenu;
    @Column(name = "HOTTRACK_COLOR")
    private String hottrackColor;
    @Column(name = "ITEM_STYLE_FONT_NAME")
    private String itemStyleFontName;
    @Column(name = "ITEM_STYLE_FONT_COLOR")
    private String itemStyleFontColor;
    @Column(name = "ITEM_SEL_STYLE_COLOR")
    private String itemSelStyleColor;
    @Column(name = "LABEL_TOTAL_GERAL_FONT_COLOR")
    private String labelTotalGeralFontColor;
    @Column(name = "ITEM_STYLE_FONT_STYLE")
    private String itemStyleFontStyle;
    @Column(name = "EDITS_COLOR")
    private String editsColor;
    @Column(name = "EDITS_FONT_COLOR")
    private String editsFontColor;
    @Column(name = "EDITS_DISABLED_COLOR")
    private String editsDisabledColor;
    @Column(name = "EDITS_FONT_NAME")
    private String editsFontName;
    @Column(name = "EDITS_FONT_STYLE")
    private String editsFontStyle;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="ecfResolucao", cascade=CascadeType.ALL)
    private List<EcfPosicaoComponentesVO> listaEcfPosicaoComponente;

    public EcfResolucaoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResolucaoTela() {
        return resolucaoTela;
    }

    public void setResolucaoTela(String resolucaoTela) {
        this.resolucaoTela = resolucaoTela;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getImagemTela() {
        return imagemTela;
    }

    public void setImagemTela(String imagemTela) {
        this.imagemTela = imagemTela;
    }

    public String getImagemMenu() {
        return imagemMenu;
    }

    public void setImagemMenu(String imagemMenu) {
        this.imagemMenu = imagemMenu;
    }

    public String getImagemSubmenu() {
        return imagemSubmenu;
    }

    public void setImagemSubmenu(String imagemSubmenu) {
        this.imagemSubmenu = imagemSubmenu;
    }

    public String getHottrackColor() {
        return hottrackColor;
    }

    public void setHottrackColor(String hottrackColor) {
        this.hottrackColor = hottrackColor;
    }

    public String getItemStyleFontName() {
        return itemStyleFontName;
    }

    public void setItemStyleFontName(String itemStyleFontName) {
        this.itemStyleFontName = itemStyleFontName;
    }

    public String getItemStyleFontColor() {
        return itemStyleFontColor;
    }

    public void setItemStyleFontColor(String itemStyleFontColor) {
        this.itemStyleFontColor = itemStyleFontColor;
    }

    public String getItemSelStyleColor() {
        return itemSelStyleColor;
    }

    public void setItemSelStyleColor(String itemSelStyleColor) {
        this.itemSelStyleColor = itemSelStyleColor;
    }

    public String getLabelTotalGeralFontColor() {
        return labelTotalGeralFontColor;
    }

    public void setLabelTotalGeralFontColor(String labelTotalGeralFontColor) {
        this.labelTotalGeralFontColor = labelTotalGeralFontColor;
    }

    public String getItemStyleFontStyle() {
        return itemStyleFontStyle;
    }

    public void setItemStyleFontStyle(String itemStyleFontStyle) {
        this.itemStyleFontStyle = itemStyleFontStyle;
    }

    public String getEditsColor() {
        return editsColor;
    }

    public void setEditsColor(String editsColor) {
        this.editsColor = editsColor;
    }

    public String getEditsFontColor() {
        return editsFontColor;
    }

    public void setEditsFontColor(String editsFontColor) {
        this.editsFontColor = editsFontColor;
    }

    public String getEditsDisabledColor() {
        return editsDisabledColor;
    }

    public void setEditsDisabledColor(String editsDisabledColor) {
        this.editsDisabledColor = editsDisabledColor;
    }

    public String getEditsFontName() {
        return editsFontName;
    }

    public void setEditsFontName(String editsFontName) {
        this.editsFontName = editsFontName;
    }

    public String getEditsFontStyle() {
        return editsFontStyle;
    }

    public void setEditsFontStyle(String editsFontStyle) {
        this.editsFontStyle = editsFontStyle;
    }

    public List<EcfPosicaoComponentesVO> getListaEcfPosicaoComponente() {
        return listaEcfPosicaoComponente;
    }

    public void setListaEcfPosicaoComponente(List<EcfPosicaoComponentesVO> listaEcfPosicaoComponente) {
        this.listaEcfPosicaoComponente = listaEcfPosicaoComponente;
    }

    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.EcfResolucaoVO[id=" + id + "]";
    }

}
