package com.cinema.cinema;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entities.ClienteLogin;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);

        ClienteLogin.menuCadastro();

        Scanner scanner = new Scanner(System.in);
        System.out.println();
       
        scanner.close();
	}


}
