package com.t2ti.plugins.util;

import com.t2ti.pafecf.infra.Biblioteca;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PafUtil {

    private String delimitador;
    private SimpleDateFormat formatoData;
    private DecimalFormat formatoDecimal;
    private String crlf;

    public PafUtil() {
        delimitador = "";
        formatoData = new SimpleDateFormat("yyyyMMdd");
        formatoDecimal = new DecimalFormat("000");
        crlf = System.getProperty("line.separator");
    }

    public String fill(String valor) {
        return valor == null ? "" : valor.trim();
    }

    public String fill(Date valor) {
        return valor == null ? "00000000" : formatoData.format(valor);
    }
    
    public String lFill(String valor, Integer quantidade) {
        return valor == null ? Biblioteca.repete(" ", quantidade) : Biblioteca.repete(" ", quantidade - valor.trim().length()) + valor.trim();
    }

    public String rFill(String valor, Integer quantidade) {
        return valor == null ? Biblioteca.repete(" ", quantidade) : valor.trim() + Biblioteca.repete(" ", quantidade - valor.trim().length());
    }

    public String lFill(Integer valor, Integer quantidade) {
        return valor == null ? Biblioteca.repete("0", quantidade) : Biblioteca.repete("0", quantidade - valor.toString().length()) + valor;
    }

    public String rFill(Integer valor, Integer quantidade) {
        return valor == null ? Biblioteca.repete("0", quantidade) : valor + Biblioteca.repete("0", quantidade - valor.toString().length());
    }
    
    public String lFill(Double valor, Integer quantidade) {
        return valor == null ? Biblioteca.repete("0", quantidade) : Biblioteca.repete("0", quantidade - formatoDecimal.format(valor).length()) + formatoDecimal.format(valor);
    }

    public String rFill(Double valor, Integer quantidade) {
        return valor == null ? Biblioteca.repete("0", quantidade) : formatoDecimal.format(valor) + Biblioteca.repete("0", quantidade - formatoDecimal.format(valor).length());
    }
    
    public String fill(BigDecimal valor) {
        return valor == null ? delimitador : delimitador + formatoDecimal.format(valor);
    }
    
    /**
     * @return the delimitador
     */
    public String getDelimitador() {
        return delimitador;
    }

    /**
     * @param delimitador the delimitador to set
     */
    public void setDelimitador(String delimitador) {
        this.delimitador = delimitador;
    }

    /**
     * @return the formatoData
     */
    public SimpleDateFormat getFormatoData() {
        return formatoData;
    }

    /**
     * @param formatoData the formatoData to set
     */
    public void setFormatoData(SimpleDateFormat formatoData) {
        this.formatoData = formatoData;
    }

    /**
     * @return the crlf
     */
    public String getCrlf() {
        return crlf;
    }

    /**
     * @param crlf the crlf to set
     */
    public void setCrlf(String crlf) {
        this.crlf = crlf;
    }

    /**
     * @return the formatoDecimal
     */
    public DecimalFormat getFormatoDecimal() {
        return formatoDecimal;
    }

    /**
     * @param formatoDecimal the formatoDecimal to set
     */
    public void setFormatoDecimal(DecimalFormat formatoDecimal) {
        this.formatoDecimal = formatoDecimal;
    }
}