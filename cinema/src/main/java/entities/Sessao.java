package entities;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Sessao {
    private Sala sala; // NUMERO SALA
    private Filme filme;
    private LocalTime horario; // SESSÃO
    private boolean[][] assento = new boolean[10][10];

    public Sessao(Sala sala, Filme filme, LocalTime horario, boolean[][] assento) {
        this.sala = sala;
        this.filme = filme;
        this.horario = horario;
        this.assento = assento;
    }

    public void mapaDeAssento() {

    }

}
