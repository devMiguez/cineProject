package entities;

import lombok.Data;

@Data
public class Assento {
    private int numero;
    private boolean ocupado;

    public Assento(int numero) {
        this.numero = numero;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return ocupado ? "|x|" : String.valueOf(numero);
    }
}

@Data
 class Sala {
    private String nome;
    private Assento[] assentos;

    public Sala(String nome, int numeroAssentos) {
        this.nome = nome;
        this.assentos = new Assento[numeroAssentos];
        for (int i = 0; i < numeroAssentos; i++) {
            this.assentos[i] = new Assento(i + 1);
        }
    }

    public Assento[] getAssentos() {
        return assentos;
    }

    public void ocuparAssento(int numeroAssento) {
        if (numeroAssento >= 1 && numeroAssento <= assentos.length) {
            assentos[numeroAssento - 1].setOcupado(true);
        } else {
            System.out.println("Número de assento inválido.");
        }
    }
}
