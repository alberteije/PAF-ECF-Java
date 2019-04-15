package com.t2ti.plugins.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpedUtil {

    private String delimitador;
    private SimpleDateFormat formatoData;
    private DecimalFormat formatoDecimal;
    private String crlf;

    public SpedUtil() {
        delimitador = "|";
        formatoData = new SimpleDateFormat("ddMMyyyy");
        formatoDecimal = new DecimalFormat("0.00");
        crlf = System.getProperty("line.separator");
    }

    public String fill(String valor) {
        return valor == null ? delimitador : delimitador + valor.trim();
    }

    public String fill(Date valor) {
        return valor == null ? delimitador : delimitador + formatoData.format(valor);
    }

    public String fill(Integer valor) {
        return valor == null ? delimitador : delimitador + valor;
    }

    public String fill(BigDecimal valor) {
        return valor == null ? delimitador : delimitador + formatoDecimal.format(valor);
    }

    public String fill(Double valor) {
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