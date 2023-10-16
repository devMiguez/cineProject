package com.cinema.cinema.entities;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "Funcionario")
@EqualsAndHashCode(callSuper = false)
public class FuncionarioLogin extends Funcionario {
    @Id
    private Integer id;
    private boolean ativo;
    private static int contadorId = 1;
    private static ArrayList<FuncionarioLogin> listaFunc = new ArrayList<>();

 
    public FuncionarioLogin(String nome, String cpf, String email, String tel, Integer id, String ctps, Date dataNasc,  LocalDate dataCadastro) {
        super(nome, cpf, email, tel, id, ctps, dataNasc, dataCadastro);
        id = FuncionarioLogin.contadorId;
        this.ativo = true;
        FuncionarioLogin.contadorId++;
    }

    public static void menuCadastro() {
        int numeroDigitado;
        Scanner leia = new Scanner(System.in);

        funcCadastrados();
        do {
            System.out.println("-----------------------------");
            System.out.println("--------MENU-CADASTRO--------");
            System.out.println("-----------------------------");

            System.out.println(
                    "Digite [1] Para se cadastrar \nDigite [2] para ver lista de funcionários \nDigite [3] para editar um funcionário cadastrado \nDigite [4] para excluir um funcionário cadastrado\nDigite [0] para sair do menu de cadastro");
            numeroDigitado = leia.nextInt();

            switch (numeroDigitado) {
                case 1:
                    logarFunc(listaFunc);
                    break;
                case 2:
                    listarFunc(listaFunc);
                    break;
                case 3:
                    editaFunc();
                    break;
                case 4:
                    excluirFunc();
                    break;
                case 0:
                    System.out.println("Saindo :(");
                    break;
                default:
                    System.out.println("Digite um número válido!!");
                    break;
            }
        } while (numeroDigitado != 0);

    }

    // Método que já define 3 funcionários certos a minha lista
    public static void funcCadastrados() {
        // String data = "2023-01-03";
        // LocalDate data_input = LocalDate.now();
        
        FuncionarioLogin funcionario01 = new FuncionarioLogin("joao", "06601927724", "joaovmiguez@gmail.com", "24988181676", 01, "010101", dataNasc, LocalDate.parse("2020-02-02"));
        FuncionarioLogin funcionario02 = new FuncionarioLogin("Rodrigo", "98897656678", "rodrigo@gmail.com", "24988181676", 02,
                "020202",  dataNasc, LocalDate.parse("2020-02-02"));
        FuncionarioLogin funcionario03 = new FuncionarioLogin("Felipe", "988172675", "felipe@gmail.com", "24788987676", 03, "030303", dataNasc, LocalDate.parse("2020-02-02"));

        listaFunc.add(funcionario01);
        listaFunc.add(funcionario02);
        listaFunc.add(funcionario03);

    }

    public static void logarFunc(ArrayList<FuncionarioLogin> listaFunc) {
        Scanner leiaDados = new Scanner(System.in);

        // Perguntas para cadastro de funcionários que serão inseridas no ArrayList
        System.out.println("CADASTRO DE FUNCIONARIO:");
        System.out.println("");
        System.out.println("Digite o nome:");
        String nome = leiaDados.nextLine();
        //Tratamento pro nome precisar ter mais de 3 dígitos
        while (nome.length() < 3) {
            System.out.println("Digite um nome válido (deve ter mais de 3 caracteres):");
            nome = leiaDados.nextLine();
        }
        System.out.println("");

        System.out.println("Digite o cpf: ");
        String cpf = leiaDados.nextLine();
        //validação de cpf para so conter números e 11 dígitos
        //(!cpf.matches("[0-9]+")): Este trecho verifica se a variável cpf contém apenas números. A expressão regular [0-9]+ verifica se a string cpf consiste apenas em dígitos de 0 a 9. O método matches retorna true se a string corresponder à expressão regular, caso contrário, retorna false.
        while ((!cpf.matches("[0-9]+")) || (cpf.length() != 11)) {
            System.out.println("Digite um CPF válido (apenas números e 11 dígitos):");
            cpf = leiaDados.nextLine();
        }
        System.out.println("");

        System.out.println("Digite o email do funcionário: ");
        String email = leiaDados.nextLine();
        //Tratamento simples para email precisar ter um "@"
        while(!(email.contains("@"))){
            System.out.println("Digite um email válido!! ");
            email = leiaDados.nextLine();
        }
        System.out.println("");

        System.out.println("Digite o telefone [(XX)XXXXXXXXX]: ");
        String tel = leiaDados.nextLine();
        while((!tel.matches("[0-9]+")) || (tel.length() != 11)){
            System.out.println("Digite um número de telefone válido!");
            tel = leiaDados.nextLine();
        }
        System.out.println("");


        System.out.println("Digite a idade: ");
        int idade = leiaDados.nextInt();
        System.out.println("");


        FuncionarioLogin funcNovo = new FuncionarioLogin(nome, cpf, email, tel, null, tel, dataNasc, dataCadastro);
        listaFunc.add(funcNovo);   //ID seia null????
        System.out.println("Funcionário logado!!");

    }

    public static void listarFunc(ArrayList<FuncionarioLogin> listaFunc) {
        if (listaFunc.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de funcionários:");
            for (FuncionarioLogin funcionario : listaFunc) {
                if (funcionario.ativo) {
                    System.out.println("Id: " + funcionario.getId());
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("CPF: " + funcionario.getCpf());
                    System.out.println("Email: " + funcionario.getEmail());
                    System.out.println("Telefone: " + funcionario.getTel());
                    System.out.println("ctps: " + funcionario.getCtps());
                    System.out.println("-----------------------------");
                }
            }
        }
    }

    public static void editaFunc() {
        String dadosNovos;
        int dadosNovosIdade;
        int numeroFunc;
        Scanner leia = new Scanner(System.in);

        listarFunc(listaFunc);// Aqui ele irá mostrar a lista de funcionarios cadastrados!!

        if (listaFunc.isEmpty()) { // Se a lista estiver vazia (isEmpty) diga que não há funcionários cadastrados!!
            System.out.println("Não há funcionários cadastrados!!");
        } else {
            System.out.println("Digite o número do funcionário que deseja editar: ");
            numeroFunc = leia.nextInt();

            if ((numeroFunc < 1) || (numeroFunc > listaFunc.size())) {
                System.out.println("Número do funcionário inválido!!");
            } else {
                leia.nextLine();// Consome a nova linha pendente após a leitura do número do Funcionario (não
                                // entendi)
                FuncionarioLogin editarFuncLogin = listaFunc.get(numeroFunc - 1);

                System.out.println("Nome atual: " + editarFuncLogin.getNome());
                dadosNovos = leia.nextLine();
                System.out.println("Novo nome: " + dadosNovos);
                editarFuncLogin.setNome(dadosNovos);

                System.out.println("Cpf atual: " + editarFuncLogin.getCpf());
                dadosNovos = leia.nextLine();
                System.out.println("Novo cpf: " + dadosNovos);
                editarFuncLogin.setCpf(dadosNovos);

                System.out.println("email atual: " + editarFuncLogin.getEmail());
                dadosNovos = leia.nextLine();
                System.out.println("Novo email: " + dadosNovos);
                editarFuncLogin.setEmail(dadosNovos);

                System.out.println("tel atual: " + editarFuncLogin.getTel());
                dadosNovos = leia.nextLine();
                System.out.println("Novo tel: " + dadosNovos);
                editarFuncLogin.setTel(dadosNovos);

                System.out.println(" ");
            }

        }

    }

    public static void excluirFunc() {
        int numeroExcluir;
        Scanner sc = new Scanner(System.in);

        listarFunc(listaFunc);
        System.out.println("Qual o número do funcionario que deseja excluir? ");
        numeroExcluir = sc.nextInt();

        if ((numeroExcluir < 1) || (numeroExcluir > listaFunc.size())) {
            System.out.println("Número de funcionário inválido!! presta atenção!!");
            excluirFunc();
        } else {
            FuncionarioLogin excluirFunc = listaFunc.get(numeroExcluir - 1);

            if (numeroExcluir == excluirFunc.getId()) {
                excluirFunc.setAtivo(false);
            }
        }

    }

}