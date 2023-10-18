package com.cinema.cinema.enums;

import lombok.Getter;

@Getter
public enum Pipoca {
    PEQUENA(7.00), MEDIA(10.00), GRANDE(15.00);

    private double valor;

    Pipoca(double valor) {
        this.valor = valor;
    }
}
