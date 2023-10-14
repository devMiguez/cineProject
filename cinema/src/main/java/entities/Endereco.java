package entities;

import lombok.Data;

@Data
public class Endereco {

    // dados a serem puxados do guiacep
    public String cep;
    public String localidade;
    public String numero;
    public String complemento;
    public String bairro;
    public String cidade;


}
