package br.com.welson.biblioteca.bean;

import br.com.welson.biblioteca.model.Autor;
import br.com.welson.biblioteca.model.Livro;
import br.com.welson.biblioteca.model.Persistence;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CriarLivroBean implements Serializable {

    private Livro livro;

    private List<Autor> autoresPesquisados;

    private String termoPesquisa;

    @PostConstruct
    public void init() {
        livro = new Livro();
        livro.setAutores(new ArrayList<>());
        autoresPesquisados = new ArrayList<>();
    }

    public void pesquisarAutor(){
        autoresPesquisados = Persistence.pesquisar(Autor.class, "nome", termoPesquisa);
        System.out.println("Pesquisou");
        for (Autor autor : autoresPesquisados){
            System.out.println(autor.getNome());
        }
    }

    public void adicionarAutor(Autor autor){
        livro.getAutores().add(autor);
    }

    public void salvar(){
        if(livro.getAutores().size() == 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Adicione autores ao livro", null));
            return;
        }
        Persistence.salvar(livro);
        livro = new Livro();
        livro.setAutores(new ArrayList<>());
        autoresPesquisados = new ArrayList<>();
        termoPesquisa = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Livro salvo com sucesso", null));
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Autor> getAutoresPesquisados() {
        return autoresPesquisados;
    }

    public void setAutoresPesquisados(List<Autor> autoresPesquisados) {
        this.autoresPesquisados = autoresPesquisados;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
}
