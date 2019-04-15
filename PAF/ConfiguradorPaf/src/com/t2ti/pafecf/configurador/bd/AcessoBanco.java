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
package com.t2ti.pafecf.configurador.bd;

import com.t2ti.pafecf.configurador.infra.Biblioteca;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcessoBanco {

    EntityManager emLocal;
    EntityManager emRetaguarda;

    private EntityManagerFactory getFactoryLocal() throws IOException {
        Map cfg = new HashMap<>();
        Properties arquivoConexao = new Properties();
        arquivoConexao.load(new FileInputStream(new File(Biblioteca.ARQUIVO_CONEXAO_BD)));

        cfg.put("javax.persistence.jdbc.driver", arquivoConexao.getProperty("sgbd.driver"));
        cfg.put("javax.persistence.jdbc.url", arquivoConexao.getProperty("sgbd.url"));
        cfg.put("javax.persistence.jdbc.user", arquivoConexao.getProperty("sgbd.user"));
        cfg.put("javax.persistence.jdbc.password", arquivoConexao.getProperty("sgbd.password"));

        return Persistence.createEntityManagerFactory("t2tipdv", cfg);
    }

    private EntityManagerFactory getFactoryRetaguarda() throws IOException {
        Map cfg = new HashMap<>();
        Properties arquivoConexao = new Properties();
        arquivoConexao.load(new FileInputStream(new File(Biblioteca.ARQUIVO_CONEXAO_BD)));

        cfg.put("javax.persistence.jdbc.driver", arquivoConexao.getProperty("sgbd.retaguarda.driver"));
        cfg.put("javax.persistence.jdbc.url", arquivoConexao.getProperty("sgbd.retaguarda.url"));
        cfg.put("javax.persistence.jdbc.user", arquivoConexao.getProperty("sgbd.retaguarda.user"));
        cfg.put("javax.persistence.jdbc.password", arquivoConexao.getProperty("sgbd.retaguarda.password"));

        return Persistence.createEntityManagerFactory("t2tierp", cfg);
    }

    public EntityManager conexaoLocal() throws IOException {
        try {
            emLocal = getFactoryLocal().createEntityManager();
            emLocal.getTransaction().begin();
            return emLocal;
        } catch (IOException e) {
            throw new IOException("Não foi possível acessar o arquivo de configuração!");
        }
    }

    public void desconectarLocal() throws Exception {
        if (emLocal != null && emLocal.isOpen()) {
            try {
                emLocal.getTransaction().commit();
            } catch (Exception e) {
                emLocal.getTransaction().rollback();
                throw new Exception(e.getMessage(), e.getCause());
            } finally {
                emLocal.close();
            }
        }
    }
    
    public EntityManager conexaoRetaguarda() throws IOException {
        try {
            emRetaguarda = getFactoryRetaguarda().createEntityManager();
            emRetaguarda.getTransaction().begin();
            return emRetaguarda;
        } catch (IOException e) {
            throw new IOException("Não foi possível acessar o arquivo de configuração!");
        }
    }

    public void desconectarRetaguarda() throws Exception {
        if (emRetaguarda != null && emRetaguarda.isOpen()) {
            try {
                emRetaguarda.getTransaction().commit();
            } catch (Exception e) {
                emRetaguarda.getTransaction().rollback();
                throw new Exception(e.getMessage(), e.getCause());
            } finally {
                emRetaguarda.close();
            }
        }
    }
    
}
