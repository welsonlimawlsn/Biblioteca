package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Persistence;
import br.com.welson.biblioteca.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class EditarUsuarioBean implements Serializable {

    private Usuario usuario;

    public void init() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        usuario = user;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
    }

    public void alterar() {
        if (usuario.getSenha().equals(Persistence.recuperarPorId(usuario.getId(), Usuario.class).getSenha())) {
            Persistence.merge(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração salva com sucesso!", null));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta!", null));
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
