package com.t2ti.plugins.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class RegistroEAD {

    public static boolean assinarArquivo(String pNomeArquivo) {
        try {
            File arquivoChavePrivada = new File("priv_key.pem");
            if (!arquivoChavePrivada.exists()) {
                JOptionPane.showMessageDialog(null, "Chave privada não encontrada.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            File arquivoParaAssinar = new File(pNomeArquivo);
            if (!arquivoParaAssinar.exists()) {
                JOptionPane.showMessageDialog(null, "Arquivo solicitado para assinatura não existe.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            if (!arquivoParaAssinar.canWrite()) {
                JOptionPane.showMessageDialog(null, "Arquivo solicitado para assinatura sem permissão de escrita.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            File arquivoAssinatura = new File("assinatura.txt");
            Runtime runtime = Runtime.getRuntime();
            
            Process processo = runtime.exec("openssl.exe dgst -md5 -sign "
                    + arquivoChavePrivada.getAbsolutePath() + " -out "
                    + arquivoAssinatura.getAbsolutePath() + " -hex "
                    + arquivoParaAssinar.getAbsolutePath());
            
            int status = processo.waitFor();
            
            if (status != 0) {
                JOptionPane.showMessageDialog(null, "Ocorreu um problema na assinatura do arquivo.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            StringBuffer dadosAssinatura = new StringBuffer();
            
            FileInputStream assinaturaGerada = new FileInputStream(arquivoAssinatura);
            byte[] bytes = new byte[assinaturaGerada.available()];
            assinaturaGerada.read(bytes);
            dadosAssinatura.append(new String(bytes));
            
            String assinatura = "EAD"
                    + dadosAssinatura.substring(dadosAssinatura.indexOf("=") + 1).trim() + "\r\n";

            FileOutputStream outArquivo = new FileOutputStream(arquivoParaAssinar, true);
            outArquivo.write(assinatura.getBytes());
            outArquivo.flush();
            outArquivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }

}