package com.cinema.cinema.entities;

import com.cinema.cinema.enums.FormaDePagamento;

public class Pedido {
    private Funcionario funcionario; // <- EMISSOR
    private ClienteLogin cliente;
    private Ingresso Ingresso;
    private FormaDePagamento formaDePagamento; // <- ENUM

}
