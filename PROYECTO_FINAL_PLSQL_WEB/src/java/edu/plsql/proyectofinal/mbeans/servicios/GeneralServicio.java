/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.plsql.proyectofinal.mbeans.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dpinedar@ucentral.edu.co
 */
public class GeneralServicio {

    private final String ARCHIVO_CARGA = System.getProperty("user.dir") + File.separatorChar + "carga.sql";

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CURSOPLSQLPU");

    public void ejecutarCargaBaseDatos() throws Exception {

        StringBuilder sql = ejecutarCarga(ARCHIVO_CARGA);
        System.out.println("LOG= " + sql);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Connection connection = em.unwrap(Connection.class);
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
            prepareStatement.executeUpdate();
            em.getTransaction().commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new Exception(ex);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private StringBuilder ejecutarCarga(String sqlScriptFile) throws Exception {
        boolean isScriptExecuted = false;
        String line;
        final StringBuilder outcome = new StringBuilder();
        try {
            final BufferedReader in = new BufferedReader(new FileReader(sqlScriptFile));
            while ((line = in.readLine()) != null) {
                outcome.append(line).append("\n");
            }
            in.close();
            isScriptExecuted = true;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            if (!isScriptExecuted) {
                System.out.println("NO SE GENERO LA LECTURA DEL ARCHIVO CORRECTAMENTE.");
            }
        }
        return outcome;
    }

}
