package org.example.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.example.models.Capital;
import org.example.models.Country;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {

    public static EntityManagerFactory createEntityManagerFactory(){

        Properties properties = new Properties();

        properties.put(Environment.DRIVER,"org.postgresql.Driver");
        properties.put(Environment.URL,"jdbc:postgresql://localhost:1111/postgres");
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Capital.class);

        return  configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);

    }
}
