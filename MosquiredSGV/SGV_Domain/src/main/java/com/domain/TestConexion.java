/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.domain;

import com.domain.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class TestConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Intentando conectar a la base de datos...");
        
        try {
            EntityManager em = JPAUtil.getEntityManager();
            System.out.println("Conexion Exitosa!");
            
            em.getTransaction().begin();
            System.out.println("Tablas verificadas/creadas segun la configuracion hbm2ddl.");
            em.getTransaction().commit();
            
            em.close();
            JPAUtil.shutdown();
        } catch (Exception e) {
            System.err.println("Error conectando: " + e.getMessage());
            e.printStackTrace();
        }

    }
    
}
