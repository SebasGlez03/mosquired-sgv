/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class JPAUtil {
    
    private static final String PERSISTENCE_UNIT_NAME = "MosquiredPU";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            Map<String, String> properties = new HashMap<>();

            // 1. Obtener valores de Variables de Entorno (o usar valores por defecto)
            // Esto permite que Docker inyecte los valores reales en produccion.

            // Estos son los valores por defecto
            String dbHost = getEnv("DB_HOST", "localhost");
            String dbPort = getEnv("DB_PORT", "3306");
            String dbName = getEnv("DB_NAME", "mosquired_sgv");
            String dbUser = getEnv("DB_USER", "root");
            String dbPass = getEnv("DB_PASS", "root");

            // 2. Construir la URL de conexion JDBC
            String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC&useSSL=false", dbHost, dbPort, dbName);

            // 3. Inyectar las propiedades dinamicamente a JPA
            properties.put("jakarta.persistence.jdbc.url", jdbcUrl);
            properties.put("jakarta.persistence.jdbc.user", dbUser);
            properties.put("jakarta.persistence.jdbc.password", dbPass);

            // Crear la factory con estas propiedades sobreescritas
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
        }
        
        return factory;

    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

    // Metodo auxiliar para leer variables de entorno con fallback
    private static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }

}
