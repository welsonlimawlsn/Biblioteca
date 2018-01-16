package br.com.welson.biblioteca.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager () {
        if(factory == null || !factory.isOpen()){
            factory = Persistence.createEntityManagerFactory("Default");
        }
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }
}
