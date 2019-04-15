/**
 * <p>Title: T2TiPDV</p>
 *
 * <p>Description: Biblioteca de funções</p>
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
 * The author may be contacted at: alberteije@gmail.com</p>
 *
 * @author T2Ti.COM
 * @version 1.0
 */
package com.t2ti.pafecf.infra;

import java.io.*;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Biblioteca {

    public static String repete(String string, int quantidade) {
        StringBuffer retorno = new StringBuffer();
        for (int j = 0; j < quantidade; j++) {
            retorno.append(string);
        }
        return retorno.toString();
    }

    public static boolean validaCpfCnpj(String s_aux) {
        if (s_aux.length() == 11) {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
                d1 = d1 + (11 - n_Count) * digitoCPF;
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }

            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
            resto = (d2 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            return nDigVerific.equals(nDigResult);
        } else if (s_aux.length() == 14) {
            int soma = 0, aux, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();

            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }

    public static String MD5String(String text)
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

    public static String MD5File(String arquivo)
            throws NoSuchAlgorithmException, FileNotFoundException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        File f = new File(arquivo);
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return output.toUpperCase();
        } catch (IOException e) {
            throw new RuntimeException("Impossível processar o arquivo.", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    public static void removeLineFromFile(String file, String lineToRemove) {
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                System.out.println("Arquivo não localizado!");
                return;
            }
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp2");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                if (!line.equals(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Não foi possível apagar o arquivo");
                return;
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Não foi possível renomear o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void addLineFromFile(String file, String lineToAdd) {
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                System.out.println("Arquivo não localizado!");
                return;
            }
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                pw.println(line);
                pw.flush();
            }
            pw.println(lineToAdd);
            pw.flush();
            pw.close();
            br.close();
            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Não foi possível apagar o arquivo");
                return;
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Não foi possível renomear o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Método que verifica se uma data no formato dd/mm/aaaa é valida.
     *
     * @param data a ser validada
     * @return true se a data é valida, false se a data é inválida
     */
    public static boolean isDataValida(String strData) {
        try {
            if ((strData.length() != 10)) {
                return false;
            }
            Calendar dataValida = Calendar.getInstance();
            dataValida.setLenient(false);
            int dia = Integer.valueOf(strData.substring(0, 2));
            int mes = Integer.valueOf(strData.substring(3, 5));
            int ano = Integer.valueOf(strData.substring(6, 10));

            dataValida.set(Calendar.DAY_OF_MONTH, dia);
            dataValida.set(Calendar.MONTH, mes - 1);
            dataValida.set(Calendar.YEAR, ano);

            dataValida.getTime();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna uma strig formatada de acordo com a configuração do sistema
     *
     * @param tipo Q para quantidade ou V para valor
     * @return string formatada
     */
    public static String formatoDecimal(String tipo, double valor) {

        String mascara = "0.";
        if (tipo.equals("Q")) {
            for (int i = 0; i < 2; i++) {
                mascara += "0";
            }
        } else if (tipo.equals("V")) {
            for (int i = 0; i < 2; i++) {
                mascara += "0";
            }
        }
        DecimalFormat formato = new DecimalFormat(mascara);
        return formato.format(valor);
    }

    /**
     * Copia arquivos de um local para o outro
     *
     * @param origem - Arquivo de origem
     * @param destino - Arquivo de destino
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException
     */
    public static void copy(File origem, File destino, boolean overwrite) throws IOException {
        if (destino.exists() && !overwrite) {
            System.err.println(destino.getName() + " já existe, ignorando...");
            return;
        }
        FileInputStream fisOrigem = new FileInputStream(origem);
        FileOutputStream fisDestino = new FileOutputStream(destino);
        FileChannel fcOrigem = fisOrigem.getChannel();
        FileChannel fcDestino = fisDestino.getChannel();
        fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
        fisOrigem.close();
        fisDestino.close();
    }
}
