package com.studentcourseapp.StudentCourseApp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Create Configuration object
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml"); // Load hibernate.cfg.xml

            // Build SessionFactory from configuration
            sessionFactory = cfg.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
