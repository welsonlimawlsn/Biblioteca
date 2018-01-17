package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Autor;
import br.com.welson.biblioteca.model.Persistence;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CriarAutorBean implements Serializable {

    private Autor autor;

    @PostConstruct
    public void init(){
        autor = new Autor();
    }

    public void salvar() {
        Persistence.salvar(autor);
        autor = new Autor();
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "Autor criado com sucesso!", null
                )
        );
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
