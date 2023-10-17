package com.cinema.cinema.entities;

import com.cinema.cinema.enums.FormaDePagamento;
import com.cinema.cinema.interfaces.ObjetosDoPedido;
import com.cinema.cinema.menus.MenuLoginCliente;
import java.util.Scanner;

import lombok.Data;

@Data
public class Pedido implements ObjetosDoPedido {
    private Funcionario funcionario; // <- EMISSOR
    private MenuLoginCliente cliente;
    private Ingresso ingresso;
    private FormaDePagamento formaDePagamento; // <- ENUM

    public Pedido(Funcionario funcionario, MenuLoginCliente cliente, Ingresso ingresso,
            FormaDePagamento formaDePagamento) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.ingresso = ingresso;
        this.formaDePagamento = formaDePagamento;
    }

    @Override
    public void escolherFilme() {

    }

    @Override
    public void escolherHorario() {

    }

    @Override
    public void escolherAssento() {

    }

    @Override
    public void escolherPipoca() {

    }

    @Override
    public void escolherRefrigerante() {

    }

    @Override
    public void escolherTipoIngresso() {

    }

}
