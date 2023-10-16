package com.cinema.cinema.enums;

import lombok.Getter;

@Getter
public enum Ingresso {
    MEIA(10.00), INTEIRA(20.00);

    private double valor;

    Ingresso(double valor){
        this.valor = valor;
    }
}
