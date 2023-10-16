package com.cinema.cinema.entities;

import com.cinema.cinema.enums.FormaDePagamento;
import com.cinema.cinema.interfaces.ObjetosDoPedido;
import com.cinema.cinema.menus.MenuLoginCliente;

import lombok.Data;


@Data
public class Pedido implements ObjetosDoPedido{
    private Funcionario funcionario; // <- EMISSOR
    private MenuLoginCliente cliente;
    private Ingresso Ingresso;
    private FormaDePagamento formaDePagamento; // <- ENUM


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
