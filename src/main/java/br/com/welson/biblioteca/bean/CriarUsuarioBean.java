package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Endereco;
import br.com.welson.biblioteca.model.Usuario;
import br.com.welson.biblioteca.model.util.JpaUtil;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Named
@RequestScoped
public class CriarUsuarioBean implements Serializable {

    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuario.setEndereco(new Endereco());
    }

    public void salvar() {
        //Por enquando
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(usuario);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
