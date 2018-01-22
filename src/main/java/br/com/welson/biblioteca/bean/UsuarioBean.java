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
import java.util.List;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarioList;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuario.setEndereco(new Endereco());
        usuarioList = Persistence.listAll(Usuario.class);
    }

    public void salvar() {
        //Por enquando
        Persistence.salvar(usuario);
        usuarioList.add(usuario);

        usuario = new Usuario();
        usuario.setEndereco(new Endereco());

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário criado com sucesso!", null));
    }

    public void excluir(Usuario usuario) {
        Persistence.excluir(usuario);
        usuarioList.remove(usuario);
    }

    public String alterar(Usuario usuario){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
        return "editarUsuario.xhtml?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
