/**
 * <p>Title: T2TiPDV</p>
 *
 * <p>Description: Sped Fiscal</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2013 T2Ti.COM</p>
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * The author may be contacted at: t2ti.com@gmail.com</p>
 *
 * @author Claudio de Barros (T2Ti.COM)
 * @version 2.0
 */
package com.t2ti.plugins.sped.fiscal.blocoe;

import java.util.ArrayList;
import java.util.List;

public class RegistroE110 {

    private Double vlTotDebitos; // Valor total dos débitos por "Saídas e prestações com débito do imposto"
    private Double vlAjDebitos; // Valor total dos ajustes a débito decorrentes do documento fiscal.
    private Double vlTotAjDebitos; // Valor total de "Ajustes a débito"
    private Double vlEstornosCred; // Valor total de Ajustes “Estornos de créditos”
    private Double vlTotCreditos; // Valor total dos créditos por "Entradas e aquisições com crédito do imposto"
    private Double vlAjCreditos; // Valor total dos ajustes a crédito decorrentes do documento fiscal.
    private Double vlTotAjCreditos; // Valor total de "Ajustes a crédito"
    private Double vlEstornosDeb; // Valor total de Ajustes “Estornos de Débitos”
    private Double vlSldCredorAnt; // Valor total de "Saldo credor do período anterior"
    private Double vlSldApurado; // Valor total de "Saldo devedor (02+03+04+05-06-07-08-09-10) antes das deduções"
    private Double vlTotDed; // Valor total de "Deduções"
    private Double vlIcmsRecolher; // Valor total de "ICMS a recolher (11-12)
    private Double vlSldCredorTransportar; // Valor total de "Saldo credor a transportar para o período seguinte”
    private Double debEsp; // Valores recolhidos ou a recolher, extra-apuração.
    private List<RegistroE116> registroE116List; // BLOCO E - Lista de RegistroE116 (FILHO)

    public RegistroE110() {
        registroE116List = new ArrayList<RegistroE116>();
    }

    /**
     * @return the vlTotDebitos
     */
    public Double getVlTotDebitos() {
        return vlTotDebitos;
    }

    /**
     * @param vlTotDebitos the vlTotDebitos to set
     */
    public void setVlTotDebitos(Double vlTotDebitos) {
        this.vlTotDebitos = vlTotDebitos;
    }

    /**
     * @return the vlAjDebitos
     */
    public Double getVlAjDebitos() {
        return vlAjDebitos;
    }

    /**
     * @param vlAjDebitos the vlAjDebitos to set
     */
    public void setVlAjDebitos(Double vlAjDebitos) {
        this.vlAjDebitos = vlAjDebitos;
    }

    /**
     * @return the vlTotAjDebitos
     */
    public Double getVlTotAjDebitos() {
        return vlTotAjDebitos;
    }

    /**
     * @param vlTotAjDebitos the vlTotAjDebitos to set
     */
    public void setVlTotAjDebitos(Double vlTotAjDebitos) {
        this.vlTotAjDebitos = vlTotAjDebitos;
    }

    /**
     * @return the vlEstornosCred
     */
    public Double getVlEstornosCred() {
        return vlEstornosCred;
    }

    /**
     * @param vlEstornosCred the vlEstornosCred to set
     */
    public void setVlEstornosCred(Double vlEstornosCred) {
        this.vlEstornosCred = vlEstornosCred;
    }

    /**
     * @return the vlTotCreditos
     */
    public Double getVlTotCreditos() {
        return vlTotCreditos;
    }

    /**
     * @param vlTotCreditos the vlTotCreditos to set
     */
    public void setVlTotCreditos(Double vlTotCreditos) {
        this.vlTotCreditos = vlTotCreditos;
    }

    /**
     * @return the vlAjCreditos
     */
    public Double getVlAjCreditos() {
        return vlAjCreditos;
    }

    /**
     * @param vlAjCreditos the vlAjCreditos to set
     */
    public void setVlAjCreditos(Double vlAjCreditos) {
        this.vlAjCreditos = vlAjCreditos;
    }

    /**
     * @return the vlTotAjCreditos
     */
    public Double getVlTotAjCreditos() {
        return vlTotAjCreditos;
    }

    /**
     * @param vlTotAjCreditos the vlTotAjCreditos to set
     */
    public void setVlTotAjCreditos(Double vlTotAjCreditos) {
        this.vlTotAjCreditos = vlTotAjCreditos;
    }

    /**
     * @return the vlEstornosDeb
     */
    public Double getVlEstornosDeb() {
        return vlEstornosDeb;
    }

    /**
     * @param vlEstornosDeb the vlEstornosDeb to set
     */
    public void setVlEstornosDeb(Double vlEstornosDeb) {
        this.vlEstornosDeb = vlEstornosDeb;
    }

    /**
     * @return the vlSldCredorAnt
     */
    public Double getVlSldCredorAnt() {
        return vlSldCredorAnt;
    }

    /**
     * @param vlSldCredorAnt the vlSldCredorAnt to set
     */
    public void setVlSldCredorAnt(Double vlSldCredorAnt) {
        this.vlSldCredorAnt = vlSldCredorAnt;
    }

    /**
     * @return the vlSldApurado
     */
    public Double getVlSldApurado() {
        return vlSldApurado;
    }

    /**
     * @param vlSldApurado the vlSldApurado to set
     */
    public void setVlSldApurado(Double vlSldApurado) {
        this.vlSldApurado = vlSldApurado;
    }

    /**
     * @return the vlTotDed
     */
    public Double getVlTotDed() {
        return vlTotDed;
    }

    /**
     * @param vlTotDed the vlTotDed to set
     */
    public void setVlTotDed(Double vlTotDed) {
        this.vlTotDed = vlTotDed;
    }

    /**
     * @return the vlIcmsRecolher
     */
    public Double getVlIcmsRecolher() {
        return vlIcmsRecolher;
    }

    /**
     * @param vlIcmsRecolher the vlIcmsRecolher to set
     */
    public void setVlIcmsRecolher(Double vlIcmsRecolher) {
        this.vlIcmsRecolher = vlIcmsRecolher;
    }

    /**
     * @return the vlSldCredorTransportar
     */
    public Double getVlSldCredorTransportar() {
        return vlSldCredorTransportar;
    }

    /**
     * @param vlSldCredorTransportar the vlSldCredorTransportar to set
     */
    public void setVlSldCredorTransportar(Double vlSldCredorTransportar) {
        this.vlSldCredorTransportar = vlSldCredorTransportar;
    }

    /**
     * @return the debEsp
     */
    public Double getDebEsp() {
        return debEsp;
    }

    /**
     * @param debEsp the debEsp to set
     */
    public void setDebEsp(Double debEsp) {
        this.debEsp = debEsp;
    }

    /**
     * @return the registroE116List
     */
    public List<RegistroE116> getRegistroE116List() {
        return registroE116List;
    }

    /**
     * @param registroE116List the registroE116List to set
     */
    public void setRegistroE116List(List<RegistroE116> registroE116List) {
        this.registroE116List = registroE116List;
    }
}
