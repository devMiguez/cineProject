package com.cinema.cinema.entities;

import lombok.Getter;

@Getter
public enum Ingresso {

    // TIPO INGRESSO (MEIA OU INTEIRA - ENUM)
    // SESSÃO

    MEIA(10.00), INTEIRA(20.00);

    private double valor;

    Ingresso(double valor) {
        this.valor = valor;
    }
}
