package entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String tel;
    public static LocalDate dataCadastro;

    public Pessoa(String nome, String cpf, String email, String tel, LocalDate dataCadastro ) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tel = tel;
        this.dataCadastro = dataCadastro;
    }
}
