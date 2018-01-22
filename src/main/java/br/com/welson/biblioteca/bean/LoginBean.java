package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Usuario;
import br.com.welson.biblioteca.model.util.JpaUtil;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String senha;
    private Usuario user;

    public String entrar(){
        EntityManager manager = JpaUtil.getEntityManager();
        Query query = manager.createQuery("from Usuario where usuario = :usuario and senha = :senha", Usuario.class);
        query.setParameter("usuario", this.usuario);
        query.setParameter("senha", this.senha);
        if(query.getResultList().size() == 1) {
            this.user = (Usuario) query.getResultList().get(0);
            return "/restrito/painel.xhtml?faces-redirect=true";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha incorretos!", "");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return null;
    }

    public String sair() {
        user = new Usuario();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
