package com.cinema.cinema.entities;

import java.util.ArrayList;

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
    private String classificacao;
    private static int contadorId = 1;
    static ArrayList<Filme> listaFilme = new ArrayList<>();

    public Filme( String titulo, String genero, String classificacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.id = Filme.contadorId;
        Filme.contadorId++;
    }

    public static void filmesEmCartaz(){
        Filme filme01 = new Filme( "O exorcista", "Terror", "16");
        Filme filme02 = new Filme( "A freira", "Terror", "16");
        Filme filme03 = new Filme( "American pie", "Comédia", "18");
        Filme filme04 = new Filme( "Homem aranha - através do Aranhaverso", "Terror", "Livre");

        listaFilme.add(filme01);
        listaFilme.add(filme02);
        listaFilme.add(filme03);
        listaFilme.add(filme04);
    }



}
