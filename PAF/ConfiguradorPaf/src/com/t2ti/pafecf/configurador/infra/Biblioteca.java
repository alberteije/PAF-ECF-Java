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
package com.t2ti.pafecf.configurador.infra;

import com.t2ti.pafecf.configurador.bd.AcessoBanco;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Biblioteca {

    public static final String ARQUIVO_CONEXAO_BD = System.getProperty("user.dir") + System.getProperty("file.separator") + "conexao.properties";
    public static final String ARQUIVO_AUXILIAR = System.getProperty("user.dir") + System.getProperty("file.separator") + "arquivoauxiliar.properties";

    public static String md5String(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static boolean verificaConexaoBanco(String tipo) throws IOException {
        AcessoBanco bd = new AcessoBanco();
        if (tipo.equals("Local")) {
            bd.conexaoLocal();
            return true;
        } else if (tipo.equals("Retaguarda")) {
            bd.conexaoRetaguarda();
            return true;
        }
        return false;
    }

    public static String primeiraMaiuscula(String texto) {
        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }
    
    public static String hashRegistro(Object bean) throws Exception {
        Field fields[] = bean.getClass().getDeclaredFields();
        String hash = "";
        Method metodo = bean.getClass().getDeclaredMethod("setLogss", String.class);
        metodo.invoke(bean, "0");
        for (Field f : fields) {
            if (!f.getName().equals("serialVersionUID")) {
                metodo = bean.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                if (f.getType() == Integer.class
                        || f.getType() == String.class
                        || f.getType() == BigDecimal.class
                        || f.getType() == Double.class) {
                    hash += metodo.invoke(bean);
                } else if (f.getType() == Date.class) {
                    Date pData = (Date) metodo.invoke(bean);
                    if (pData != null) {
                        hash += formataData(pData);
                    } else {
                        hash += "null";
                    }
                } else {
                    if (f.getType() != List.class) {
                        Object obj = metodo.invoke(bean);
                        if (obj != null) {
                            metodo = obj.getClass().getDeclaredMethod("getId");
                            hash += metodo.invoke(obj);
                        } else {
                            hash += "null";
                        }
                    }
                }
            }
        }
        return md5String(hash);
    }

    public static String formataData(Date dataFormatar) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataFormatar);
    }
    
}
