package com.cinema.cinema;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entities.Cliente;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);

        
	}


}
/*public static void ocuparAssento(boolean[] assentos, int numeroAssento) {
        if (numeroAssento >= 1 && numeroAssento <= assentos.length) {
            assentos[numeroAssento - 1] = true;
            System.out.println("Assento " + numeroAssento + " ocupado com sucesso.");
        } else {
            System.out.println("Número de assento inválido.");
        }
    }


    public static boolean verificarAssentoOcupado(boolean[] assentos, int numeroAssento) {
        // Verificar se o número do assento é válido
        if (numeroAssento >= 1 && numeroAssento <= assentos.length) {
                        return assentos[numeroAssento - 1];
        } else {
            System.out.println("Número de assento inválido.");
            return false;
        }
    }*/