package entities;

import lombok.Data;

@Data
public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String tel;

    public Pessoa(String nome, String cpf, String email, String tel) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tel = tel;
    }
}
