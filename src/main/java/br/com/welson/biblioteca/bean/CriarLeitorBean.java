package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Endereco;
import br.com.welson.biblioteca.model.Leitor;
import br.com.welson.biblioteca.model.Persistence;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CriarLeitorBean implements Serializable {

    private Leitor leitor;

    @PostConstruct
    public void init() {
        leitor = new Leitor();
        leitor.setEndereco(new Endereco());
    }

    public void salvar() {
        Persistence.salvar(leitor);

        leitor = new Leitor();
        leitor.setEndereco(new Endereco());

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Leitor criado com sucesso!", null));
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }
}
