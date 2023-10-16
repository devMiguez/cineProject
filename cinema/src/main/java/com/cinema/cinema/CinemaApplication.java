package com.cinema.cinema;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cinema.cinema.menus.MenuLoginCliente;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);

        MenuLoginCliente.menuCadastro();
        menuPrincipal();
	}

    public static void menuPrincipal(){
        int numeroDigitado;

        Scanner leiaNumero = new Scanner(System.in);
        System.out.println("Digite [1] para logar como cliente e realizar suas compras!! \nDigite [2] para logar como funcionario!!");
        numeroDigitado = leiaNumero.nextInt();

        switch (numeroDigitado) {
            case 1:
                MenuLoginCliente.menuCadastro();
                break;
        
            default:
                break;
        }


    }
    
}
