package com.cinema.cinema.enums;

public enum Refrigerante {
    COCACOLA(5.00), PEPSITWIST(4.50), MINEIRINHO(4.99), FLESHA(0.50);

    private double valor;

    Refrigerante(double valor) {
        this.valor = valor;
    }
}
