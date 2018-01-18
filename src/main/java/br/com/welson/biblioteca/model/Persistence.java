package br.com.welson.biblioteca.model;

import br.com.welson.biblioteca.model.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

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

    public static <T> List<T> pesquisar(Class<T> obj, String campo, String termo) {
        EntityManager manager = JpaUtil.getEntityManager();
        Query query = manager.createQuery("from " + obj.getSimpleName() + " where " + campo + " like :termo", obj);
        query.setParameter("termo", "%" + termo + "%");
        List<T> resultList = query.getResultList();
        manager.close();
        JpaUtil.close();
        return resultList;
    }
}
