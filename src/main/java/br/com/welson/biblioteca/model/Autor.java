package br.com.welson.biblioteca.model;

import java.util.List;

public class Autor {

    private Long id;
    private String nome;
    private String email;
    private String site;
    private List<Livro> livrosPublicados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Livro> getLivrosPublicados() {
        return livrosPublicados;
    }

    public void setLivrosPublicados(List<Livro> livrosPublicados) {
        this.livrosPublicados = livrosPublicados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Autor autor = (Autor) o;

        return id != null ? id.equals(autor.id) : autor.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
