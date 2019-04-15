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
package com.t2ti.plugins.sped.fiscal.bloco0;

import java.util.ArrayList;
import java.util.List;

public class Registro0001 {

    private Integer indMov; // Indicador de movimento: 0- Bloco com dados informados, 1- Bloco sem dados informados.

    private Registro0005 registro0005; // BLOCO 0 - Registro0005 (FILHO)
    private List<Registro0015> registro0015List; // BLOCO 0 - Lista de Registro0015 (FILHO)
    private Registro0100 registro0100; // BLOCO 0 - Registro0100 (FILHO)
    private List<Registro0150> registro0150List; // BLOCO 0 - Lista de Registro0150 (FILHO)
    private List<Registro0190> registro0190List; // BLOCO 0 - Lista de Registro0190 (FILHO)
    private List<Registro0200> registro0200List; // BLOCO 0 - Lista de Registro0200 (FILHO)
    private List<Registro0300> registro0300List; // BLOCO 0 - Lista de Registro0300 (FILHO)
    private List<Registro0400> registro0400List; // BLOCO 0 - Lista de Registro0400 (FILHO)
    private List<Registro0450> registro0450List; // BLOCO 0 - Lista de Registro0450 (FILHO)
    private List<Registro0460> registro0460List; // BLOCO 0 - Lista de Registro0460 (FILHO)
    private List<Registro0500> registro0500List; // BLOCO 0 - Lista de Registro0500 (FILHO)
    private List<Registro0600> registro0600List; // BLOCO 0 - Lista de Registro0600 (FILHO)

    public Registro0001() {
        registro0005 = new Registro0005();
        registro0015List = new ArrayList<Registro0015>();
        registro0100 = new Registro0100();
        registro0150List = new ArrayList<Registro0150>();
        registro0190List = new ArrayList<Registro0190>();
        registro0200List = new ArrayList<Registro0200>();
        registro0300List = new ArrayList<Registro0300>();
        registro0400List = new ArrayList<Registro0400>();
        registro0450List = new ArrayList<Registro0450>();
        registro0460List = new ArrayList<Registro0460>();
        registro0500List = new ArrayList<Registro0500>();
        registro0600List = new ArrayList<Registro0600>();
    }

    /**
     * @return the indMov
     */
    public Integer getIndMov() {
        return indMov;
    }

    /**
     * @param indMov the indMov to set
     */
    public void setIndMov(Integer indMov) {
        this.indMov = indMov;
    }

    /**
     * @return the registro0005
     */
    public Registro0005 getRegistro0005() {
        return registro0005;
    }

    /**
     * @param registro0005 the registro0005 to set
     */
    public void setRegistro0005(Registro0005 registro0005) {
        this.registro0005 = registro0005;
    }

    /**
     * @return the registro0015List
     */
    public List<Registro0015> getRegistro0015List() {
        return registro0015List;
    }

    /**
     * @param registro0015List the registro0015List to set
     */
    public void setRegistro0015List(List<Registro0015> registro0015List) {
        this.registro0015List = registro0015List;
    }

    /**
     * @return the registro0100
     */
    public Registro0100 getRegistro0100() {
        return registro0100;
    }

    /**
     * @param registro0100 the registro0100 to set
     */
    public void setRegistro0100(Registro0100 registro0100) {
        this.registro0100 = registro0100;
    }

    /**
     * @return the registro0150List
     */
    public List<Registro0150> getRegistro0150List() {
        return registro0150List;
    }

    /**
     * @param registro0150List the registro0150List to set
     */
    public void setRegistro0150List(List<Registro0150> registro0150List) {
        this.registro0150List = registro0150List;
    }

    /**
     * @return the registro0190List
     */
    public List<Registro0190> getRegistro0190List() {
        return registro0190List;
    }

    /**
     * @param registro0190List the registro0190List to set
     */
    public void setRegistro0190List(List<Registro0190> registro0190List) {
        this.registro0190List = registro0190List;
    }

    /**
     * @return the registro0200List
     */
    public List<Registro0200> getRegistro0200List() {
        return registro0200List;
    }

    /**
     * @param registro0200List the registro0200List to set
     */
    public void setRegistro0200List(List<Registro0200> registro0200List) {
        this.registro0200List = registro0200List;
    }

    /**
     * @return the registro0300List
     */
    public List<Registro0300> getRegistro0300List() {
        return registro0300List;
    }

    /**
     * @param registro0300List the registro0300List to set
     */
    public void setRegistro0300List(List<Registro0300> registro0300List) {
        this.registro0300List = registro0300List;
    }

    /**
     * @return the registro0400List
     */
    public List<Registro0400> getRegistro0400List() {
        return registro0400List;
    }

    /**
     * @param registro0400List the registro0400List to set
     */
    public void setRegistro0400List(List<Registro0400> registro0400List) {
        this.registro0400List = registro0400List;
    }

    /**
     * @return the registro0450List
     */
    public List<Registro0450> getRegistro0450List() {
        return registro0450List;
    }

    /**
     * @param registro0450List the registro0450List to set
     */
    public void setRegistro0450List(List<Registro0450> registro0450List) {
        this.registro0450List = registro0450List;
    }

    /**
     * @return the registro0460List
     */
    public List<Registro0460> getRegistro0460List() {
        return registro0460List;
    }

    /**
     * @param registro0460List the registro0460List to set
     */
    public void setRegistro0460List(List<Registro0460> registro0460List) {
        this.registro0460List = registro0460List;
    }

    /**
     * @return the registro0500List
     */
    public List<Registro0500> getRegistro0500List() {
        return registro0500List;
    }

    /**
     * @param registro0500List the registro0500List to set
     */
    public void setRegistro0500List(List<Registro0500> registro0500List) {
        this.registro0500List = registro0500List;
    }

    /**
     * @return the registro0600List
     */
    public List<Registro0600> getRegistro0600List() {
        return registro0600List;
    }

    /**
     * @param registro0600List the registro0600List to set
     */
    public void setRegistro0600List(List<Registro0600> registro0600List) {
        this.registro0600List = registro0600List;
    }
}
