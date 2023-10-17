package entities;

import java.sql.Date;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)

public class Funcionario extends Pessoa{
    @Id
    private Integer id;
    private String ctps;
    private Date dataNasc;
    
    public Funcionario(String nome, String cpf, String email, String tel, Integer id, String ctps, Date dataNasc) {
        super(nome, cpf, email, tel);
        this.id = id;
        this.ctps = ctps;
        this.dataNasc = dataNasc;
    }
}
