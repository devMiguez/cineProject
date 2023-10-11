package entities;

import enums.FormaDePagamento;
import menus.ClienteLogin;

public class Pedido {
    private Funcionario funcionario; // <- EMISSOR
    private ClienteLogin cliente;
    private Ingresso Ingresso;
    private FormaDePagamento formaDePagamento; // <- ENUM

}
