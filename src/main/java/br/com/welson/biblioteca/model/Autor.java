package br.com.welson.biblioteca.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tab_autor")
public class Autor {

    private Long id;
    private String nome;
    private String email;
    private String site;
    private List<Livro> livrosPublicados;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(length = 100)
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "autor_livros",
        joinColumns = @JoinColumn(name = "id_autor"),
        inverseJoinColumns = @JoinColumn(name = "id_livro"))
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
