package com.cinema.cinema.entities;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String tel;
    //adicionados  , data cadastro
    public static LocalDate dataCadastro;

    public Pessoa(String nome, String cpf, String email, String tel, LocalDate dataCadastro ) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tel = tel;
        this.dataCadastro = dataCadastro;
    }
}
