package com.codegnan.app.javawebapp11082026.dao;

import com.codegnan.app.javawebapp11082026.entity.Credentials;
import com.codegnan.app.javawebapp11082026.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseUtility {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            System.out.println("Setting up SessionFactory...");
            standardServiceRegistry = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();

            Metadata metadata = new MetadataSources(standardServiceRegistry)
                    .addAnnotatedClasses(User.class, Credentials.class)
                    .getMetadataBuilder()
                    .build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();

            System.out.println("SessionFactory setup successful...");
        }

        return sessionFactory;
    }

    public static void shutdown() {
        if (standardServiceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }
}