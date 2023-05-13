package br.com.viniciussantosdev.movieapi.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "categoria")
    private String categoria;

    @Override
    public int hashCode() {

        return Objects.hash(categoria, id, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Filme other = (Filme) obj;
        return Objects.equals(categoria, other.categoria)
                && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
}
