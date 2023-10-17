package com.cinema.cinema.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Filmes")
public class Filme {
    @Id
    private Integer id;
    private String titulo;
    private String genero;
    private int classificacao;

    public Filme(Integer id, String titulo, String genero, int classificacao) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
    }

}
