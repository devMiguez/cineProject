package com.cinema.cinema.entities;

import com.cinema.cinema.enums.FormaDePagamento;
import com.cinema.cinema.enums.Pipoca;
import com.cinema.cinema.enums.Refrigerante;
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

    public Pedido(){

    }

    @Override
    public void escolherFilme() {
        int numeroFilmeEscolhido;

        //Chamando o método da classe Filme que preenche a lista de filmes
        Filme.filmesEmCartaz();

        do {
            //Título
            System.out.println("----------------");
            System.out.println("FILMES EM CARTAZ");
            System.out.println("----------------");
    
            //For para exibição dos filmes que estão na lista de filmes
            for(Filme filme : Filme.listaFilme){
                System.out.println(filme.getId() + ": " + filme.getTitulo());
            }
            
            //Parte para o cliente escolher o filme
            Scanner leiaEntrada = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Escolha o número do filme que deseja assistir: ");
            numeroFilmeEscolhido = leiaEntrada.nextInt();
    
            Filme filmeEscolhido = null; //Variável declarada para definir que inicialmente não foi encontrado nenhum filme correspondente, após o cliente escolher o filme e verificar se o filme existe ele será atribuido essa variável, dando a ela um valor que inicialmente é nulo;
            for (Filme filme : Filme.listaFilme) {
                if (filme.getId() == numeroFilmeEscolhido) {
                    filmeEscolhido = filme;
                    break;
                }
            }
    
            // Se o filme foi encontrado, você pode usá-lo no pedido
            if (filmeEscolhido != null) {
                System.out.println("Você escolheu o filme: " + filmeEscolhido.getTitulo());
            } else {
                System.out.println("Filme não encontrado, digite um número de filme existente!!");
            }
        } while (numeroFilmeEscolhido > Filme.listaFilme.size());

    }

    @Override
    public void escolherHorario() {

    }

    @Override
    public void escolherAssento() {

    }

    @Override
    public void escolherTipoIngresso() {
        String escolhaIngresso;

        //Título
        System.out.println("----------------");
        System.out.println("COMPRA DE INGRESSO");
        System.out.println("----------------");
        System.out.println("MEIA : " + Ingresso.MEIA.getValor());
        System.out.println("INTEIRA: " + Ingresso.INTEIRA.getValor());
        System.out.println(" ");

        Scanner leiaDados = new Scanner(System.in);
        System.out.println("Escolha o tipo de ingresso!!\nDigite [M] para meia.\nDigite [I] para inteira");
        escolhaIngresso = leiaDados.nextLine().toLowerCase();

        switch (escolhaIngresso) {
            case "m":
                boolean meiaConcedida = false; // Inicializa como falso e só vai ser verdadeiro se algum cliente atender aos requisitos da meia entrada
                for (MenuLoginCliente cliente : MenuLoginCliente.listaCliente) {
                    if (cliente.getIdade() < 18 && cliente.getEstudante().equalsIgnoreCase("sim")) {
                        meiaConcedida = true;
                        break;
                    }
                }
                
                if (meiaConcedida) {
                    System.out.println("Meia entrada concedida!!");
                    System.out.println("INGRESSO: " + Ingresso.MEIA);
                } else {
                    System.out.println("Meia entrada negada!!");
                    System.out.println("INGRESSO: " + Ingresso.INTEIRA);
                }
                break;
            case "i":
                System.out.println("INGRESSO: " + Ingresso.INTEIRA);
                break;
            default:
                break;
        }

    }

    @Override
    public void escolherPipoca() {
        String escolherPipoca;

        System.out.println("----------------");
        System.out.println("COMPRA DE PIPOCA");
        System.out.println("----------------");
        System.out.println("PEQUENA : " + Pipoca.PEQUENA.getValor());
        System.out.println("MÉDIA: " + Pipoca.MEDIA.getValor());
        System.out.println("GRANDE: " + Pipoca.GRANDE.getValor());
        System.out.println(" ");

        System.out.println("Qual tamanho você deseja?");
        System.out.println("Digite [p] para pequena\nDigite [m] para média\nDigite [g] para grande\nDigite [n] se não deseja comprar pipoca");
        Scanner leiaCompra = new Scanner(System.in);
        escolherPipoca = leiaCompra.nextLine().toLowerCase();

        switch (escolherPipoca) {
            case "p":
                System.out.println("Pipoca pequena comprada!!");
                break;
            case "m":
                System.out.println("Pipoca média comprada!!");
                break;
            case "g":
                System.out.println("Pipoca grande comprada!!");
                break;
            case "n":
                System.out.println("Pipoca não comprada!!");
            default:
                break;
        }


    }

    @Override
    public void escolherRefrigerante() {
        String escolherRefrigerante;

        System.out.println("----------------");
        System.out.println("COMPRA DE REFRIGERANTE");
        System.out.println("----------------");
        System.out.println("COCA-COLA : " + Refrigerante.COCACOLA.getValor());
        System.out.println("PEPSITWIST: " + Refrigerante.PEPSITWIST.getValor());
        System.out.println("MINEIRINHO: " + Refrigerante.MINEIRINHO.getValor());
        System.out.println("FLESHA: " + Refrigerante.FLESHA.getValor());
        System.out.println(" ");

        System.out.println("Qual refrigerante você deseja comprar!!");
        System.out.println("Digite [c] para COCA-COLA\nDigite [p] para PEPSITWIST\nDigite [m] para MINEIRINHO\nDigite [f] para FLESHA\nDigite [n] se não que comprar refrigerante");
        Scanner leiaCompra = new Scanner(System.in);
        escolherRefrigerante = leiaCompra.nextLine().toLowerCase();

        switch (escolherRefrigerante) {
            case "c":
                System.out.println("Coca cola comprada!!");
                break;
            case "p":
                System.out.println("Pepsi-twist comprada!!");
                break;
            case "m":
                System.out.println("Mineirinho comprado!!");
                break;
            case "f":
                System.out.println("Flesha comprado!!");
                break;
            case "n":
                System.out.println("Refrigerante não comprado");
                break;
            default:
                break;
        }
    }


}
