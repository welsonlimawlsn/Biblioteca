package br.com.welson.biblioteca.model;

import br.com.welson.biblioteca.model.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Persistence {
    public static void salvar(Object o) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(o);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }
}
