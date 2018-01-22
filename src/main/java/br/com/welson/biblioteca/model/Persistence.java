package br.com.welson.biblioteca.model;

import br.com.welson.biblioteca.model.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class Persistence {

    private static EntityManager manager;
    private static EntityTransaction transaction;

    public static void salvar(Object o) {
        abrir();
        manager.persist(o);
        fechar();
    }

    public static <T> List<T> pesquisar(Class<T> obj, String campo, String termo) {
        abrir();
        Query query = manager.createQuery("from " + obj.getSimpleName() + " where " + campo + " like :termo", obj);
        query.setParameter("termo", "%" + termo + "%");
        List<T> resultList = query.getResultList();
        fechar();
        return resultList;
    }

    public static void excluir(Object o) {
        abrir();
        o = manager.merge(o);
        manager.remove(o);
        fechar();
    }

    public static <T> List<T> listAll(Class<T> tClass) {
        abrir();
        List<T> resultList = manager.createQuery("from " + tClass.getSimpleName(), tClass).getResultList();
        fechar();
        return resultList;
    }

    public static <T> T recuperarPorId(Long id, Class<T> tClass) {
        abrir();
        T object = manager.find(tClass, id);
        fechar();
        return object;
    }

    public static void merge(Object o) {
        abrir();
        manager.merge(o);
        fechar();
    }

    private static void abrir(){
        manager = JpaUtil.getEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }

    private static void fechar(){
        transaction.commit();
        manager.close();
        JpaUtil.close();
    }
}
