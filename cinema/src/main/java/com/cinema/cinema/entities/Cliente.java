package com.cinema.cinema.entities;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class Cliente extends Pessoa {
    private int idade;
    private String estudante;

    public Cliente(String nome, String cpf, String email, String tel, LocalDate dataCadastro, int idade,
            String estudante) {
        super(nome, cpf, email, tel, dataCadastro);
        this.idade = idade;
        this.estudante = estudante;
    }

}
