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
package com.t2ti.plugins.sped.fiscal.blococ;

import java.util.ArrayList;
import java.util.List;

public class RegistroC420 {

    private String codTotPar; // Código do totalizador, conforme Tabela 4.4.6
    private Double vlrAcumTot; // Valor acumulado no totalizador, relativo à respectiva Redução Z.
    private Integer nrTot; // Número do totalizador quando ocorrer mais de uma situação com a mesma carga tributária efetiva.
    private String descrNrTot; // Descrição da situação tributária relativa ao totalizador parcial, quando houver mais de um com a mesma carga tributária efetiva.
    private List<RegistroC425> registroC425List; // BLOCO C - Lista de RegistroC425 (FILHO)

    public RegistroC420() {
        registroC425List = new ArrayList<RegistroC425>();
    }

    /**
     * @return the codTotPar
     */
    public String getCodTotPar() {
        return codTotPar;
    }

    /**
     * @param codTotPar the codTotPar to set
     */
    public void setCodTotPar(String codTotPar) {
        this.codTotPar = codTotPar;
    }

    /**
     * @return the vlrAcumTot
     */
    public Double getVlrAcumTot() {
        return vlrAcumTot;
    }

    /**
     * @param vlrAcumTot the vlrAcumTot to set
     */
    public void setVlrAcumTot(Double vlrAcumTot) {
        this.vlrAcumTot = vlrAcumTot;
    }

    /**
     * @return the nrTot
     */
    public Integer getNrTot() {
        return nrTot;
    }

    /**
     * @param nrTot the nrTot to set
     */
    public void setNrTot(Integer nrTot) {
        this.nrTot = nrTot;
    }

    /**
     * @return the descrNrTot
     */
    public String getDescrNrTot() {
        return descrNrTot;
    }

    /**
     * @param descrNrTot the descrNrTot to set
     */
    public void setDescrNrTot(String descrNrTot) {
        this.descrNrTot = descrNrTot;
    }

    /**
     * @return the registroC425List
     */
    public List<RegistroC425> getRegistroC425List() {
        return registroC425List;
    }

    /**
     * @param registroC425List the registroC425List to set
     */
    public void setRegistroC425List(List<RegistroC425> registroC425List) {
        this.registroC425List = registroC425List;
    }
}
