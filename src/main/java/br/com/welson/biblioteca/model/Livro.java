package br.com.welson.biblioteca.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tab_livro")
public class Livro {

    private Long id;
    private String titulo;
    private Integer quantidadePaginas;
    private List<Autor> autores;
    private Integer anoPublicacao;
    private Integer numeroEdicao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 100, nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(nullable = false)
    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @Column(nullable = false)
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(Integer numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return id != null ? id.equals(livro.id) : livro.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
