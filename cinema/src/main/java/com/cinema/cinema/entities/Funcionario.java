package com.cinema.cinema.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "Funcionarios")
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends Pessoa {
    @Id
    private Integer id;
    private String ctps;
    public static Date dataNasc; // mudei para public static para poder funcionar na tela login de func
    // private String endereco -puxar do Pessoa

    public Funcionario(String nome, String cpf, String email, String tel, Integer id, String ctps, Date dataNasc,LocalDate dataCadastro) {
        super(nome, cpf, email, tel, dataCadastro);
        this.id = id;
        this.ctps = ctps;
        this.dataNasc = dataNasc;
    }
}