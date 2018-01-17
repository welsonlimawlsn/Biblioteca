package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Endereco;
import br.com.welson.biblioteca.model.Persistence;
import br.com.welson.biblioteca.model.Usuario;
import br.com.welson.biblioteca.model.util.JpaUtil;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        Persistence.salvar(usuario);

        usuario = new Usuario();
        usuario.setEndereco(new Endereco());

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário criado com sucesso!", null));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
