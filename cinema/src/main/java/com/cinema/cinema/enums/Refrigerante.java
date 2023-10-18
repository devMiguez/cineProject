package com.cinema.cinema.enums;

import lombok.Getter;

@Getter
public enum Refrigerante {
    COCACOLA(5.00), PEPSITWIST(4.50), MINEIRINHO(4.99), FLESHA(0.50);

    private double valor;

    Refrigerante(double valor) {
        this.valor = valor;
    }
}
