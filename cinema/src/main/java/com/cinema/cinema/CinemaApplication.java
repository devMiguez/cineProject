package com.cinema.cinema;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cinema.cinema.entities.Pedido;
import com.cinema.cinema.menus.MenuLoginCliente;
import com.cinema.cinema.menus.MenuLoginFuncionario;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);


        menuPrincipal();
    }

    public static void menuPrincipal() {
        int numeroDigitado;

        Scanner leiaNumero = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("---CINE SENAI---");
        System.out.println("----------------");
        System.out.println("Digite [1] entrar no cinema e realizar suas compras!! \nDigite [2] para logar como funcionario!!");
        numeroDigitado = leiaNumero.nextInt();

        switch (numeroDigitado) {
            case 1:
                MenuLoginCliente.menuCadastro();
                Pedido clientePedido = new Pedido();
                clientePedido.escolherFilme();
                clientePedido.escolherTipoIngresso();
                clientePedido.escolherPipoca();
                clientePedido.escolherRefrigerante();
                break;
            case 2:
                MenuLoginFuncionario.menuCadastro();
                break;
            default:
                break;
        }
        /*
         * ordem de uso
         * 1 - cliente ou funcionario (switch case?)
         * 2 - cliente - vai para cadastro cliente
         * 3 -chama pedido
         * 4 -dentro do pedido (filme, horario, assento)
         * 5 - escolher pipoca (adiciona valor)
         * 6 - escolher refrigerante (adiciona valor)
         * 7-escolher tipo de ingresso (adiciona valor)
         * 8 - revisar pedido e soma de valores
         * 
         * 
         * 
         * 
         */

    }

}
