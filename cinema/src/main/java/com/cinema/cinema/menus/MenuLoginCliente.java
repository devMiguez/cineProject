package com.cinema.cinema.menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.cinema.cinema.entities.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@Entity
@Table(name = "Clientes")
@EqualsAndHashCode(callSuper = false)
public class MenuLoginCliente extends Cliente {
    @Id
    private Integer id;
    private boolean ativo;
    private static int contadorId = 1;
    private static ArrayList<MenuLoginCliente> listaCliente = new ArrayList<>();

    public MenuLoginCliente(String nome, String cpf, String email, String tel, int idade, String estudante, LocalDate dataCadastro) {
        super(nome, cpf, email, tel, dataCadastro, idade, estudante);
        this.id = MenuLoginCliente.contadorId;
        this.ativo = true;
        MenuLoginCliente.contadorId++;
    }

    public static void menuCadastro() {
        int numeroDigitado;
        Scanner leia = new Scanner(System.in);

        clientesCadastrados();
        do {
            System.out.println("-----------------------------");
            System.out.println("--------MENU-CADASTRO--------");
            System.out.println("-----------------------------");

            System.out.println(
                    "Digite [1] Para se cadastrar \nDigite [2] para ver lista de clientes \nDigite [3] para editar um cliente cadastrado \nDigite [4] para excluir um cliente cadastrado\nDigite [0] para sair do menu de cadastro");
            numeroDigitado = leia.nextInt();

            switch (numeroDigitado) {
                case 1:
                    logarCliente(listaCliente);
                    break;
                case 2:
                    listarCliente(listaCliente);
                    break;
                case 3:
                    editaCliente();
                    break;
                case 4:
                    excluirCliente();
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

    // Método que já define 3 clientes certos a minha lista
    public static void clientesCadastrados() {
        // String data = "2023-01-03";
        // LocalDate data_input = LocalDate.now();
        
        MenuLoginCliente cliente01 = new MenuLoginCliente("joao", "06601927724", "joaovmiguez@gmail.com", "24988181676", 18,
                "sim",  LocalDate.parse("2020-02-02"));
        MenuLoginCliente cliente02 = new MenuLoginCliente("Rodrigo", "98897656678", "rodrigo@gmail.com", "24988181676", 45,
                "sim",  LocalDate.parse("2020-02-02"));
        MenuLoginCliente cliente03 = new MenuLoginCliente("Felipe", "988172675", "felipe@gmail.com", "24788987676", 55, "nao", LocalDate.parse("2020-02-02"));

        listaCliente.add(cliente01);
        listaCliente.add(cliente02);
        listaCliente.add(cliente03);

    }

    public static void logarCliente(ArrayList<MenuLoginCliente> listaCliente) {
        Scanner leiaDados = new Scanner(System.in);

        // Perguntas para cadastro de cliente que serão inseridas no ArrayList
        System.out.println("CADASTRO DE CLIENTE:");
        System.out.println("");
        System.out.println("Digite seu nome:");
        String nome = leiaDados.nextLine();
        //Tratamento pro nome precisar ter mais de 3 dígitos
        while (nome.length() < 3) {
            System.out.println("Digite um nome válido (deve ter mais de 3 caracteres):");
            nome = leiaDados.nextLine();
        }
        System.out.println("");

        System.out.println("Digite seu cpf: ");
        String cpf = leiaDados.nextLine();
        //validação de cpf para so conter números e 11 dígitos
        //(!cpf.matches("[0-9]+")): Este trecho verifica se a variável cpf contém apenas números. A expressão regular [0-9]+ verifica se a string cpf consiste apenas em dígitos de 0 a 9. O método matches retorna true se a string corresponder à expressão regular, caso contrário, retorna false.
        while ((!cpf.matches("[0-9]+")) || (cpf.length() != 11)) {
            System.out.println("Digite um CPF válido (apenas números e 11 dígitos):");
            cpf = leiaDados.nextLine();
        }
        System.out.println("");

        System.out.println("Digite seu email: ");
        String email = leiaDados.nextLine();
        //Tratamento simples para email precisar ter um "@"
        while(!(email.contains("@"))){
            System.out.println("Digite um email válido!! ");
            email = leiaDados.nextLine();
        }
        System.out.println("");

        System.out.println("Digite seu telefone [(XX)XXXXXXXXX]: ");
        String tel = leiaDados.nextLine();
        while((!tel.matches("[0-9]+")) || (tel.length() != 11)){
            System.out.println("Digite um número de telefone válido!");
            tel = leiaDados.nextLine();
        }
        System.out.println("");


        System.out.println("Digite sua idade: ");
        int idade = leiaDados.nextInt();
        System.out.println("");

        System.out.println("Você é estudante? (Responda com 'sim' e 'nao') ");
        leiaDados.nextLine();
        String estudante = leiaDados.nextLine();
        //Tratamento para respostas apenas com "sim" e "não"
        while(!(estudante.equalsIgnoreCase("sim")) && !(estudante.equalsIgnoreCase("nao")) ){
            System.out.println("Dê uma resposta válida!! (responda com 'sim' ou 'nao')");
            estudante = leiaDados.nextLine();
        }
        System.out.println("");

        MenuLoginCliente clienteNovo = new MenuLoginCliente(nome, cpf, email, tel, idade, estudante, dataCadastro);
        listaCliente.add(clienteNovo);
        System.out.println("Cliente logado!!");

    }

    public static void listarCliente(ArrayList<MenuLoginCliente> listaCliente) {
        if (listaCliente.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (MenuLoginCliente cliente : listaCliente) {
                if (cliente.ativo) {
                    System.out.println("Id: " + cliente.getId());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Telefone: " + cliente.getTel());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("Estudande: " + cliente.getEstudante());
                    System.out.println("-----------------------------");
                }
            }
        }
    }

    public static void editaCliente() {
        String dadosNovos;
        int dadosNovosIdade;
        int numeroCliente;
        Scanner leia = new Scanner(System.in);

        listarCliente(listaCliente);// Aqui ele irá mostrar a lista de clientes cadastrados!!

        if (listaCliente.isEmpty()) { // Se a lista estiver vazia (isEmpty) diga que não há clientes cadastrados!!
            System.out.println("Não há clientes cadastrados!!");
        } else {
            System.out.println("Digite o número do cliente que deseja editar: ");
            numeroCliente = leia.nextInt();

            if ((numeroCliente < 1) || (numeroCliente > listaCliente.size())) {
                System.out.println("Número do cliente inválido!!");
            } else {
                leia.nextLine();// Consome a nova linha pendente após a leitura do número do Cliente (não
                                // entendi)
                MenuLoginCliente editarCliente = listaCliente.get(numeroCliente - 1);

                System.out.println("Nome atual: " + editarCliente.getNome());
                dadosNovos = leia.nextLine();
                System.out.println("Novo nome: " + dadosNovos);
                editarCliente.setNome(dadosNovos);

                System.out.println("Cpf atual: " + editarCliente.getCpf());
                dadosNovos = leia.nextLine();
                System.out.println("Novo cpf: " + dadosNovos);
                editarCliente.setCpf(dadosNovos);

                System.out.println("email atual: " + editarCliente.getEmail());
                dadosNovos = leia.nextLine();
                System.out.println("Novo email: " + dadosNovos);
                editarCliente.setEmail(dadosNovos);

                System.out.println("tel atual: " + editarCliente.getTel());
                dadosNovos = leia.nextLine();
                System.out.println("Novo tel: " + dadosNovos);
                editarCliente.setTel(dadosNovos);

                System.out.println("idade atual: " + editarCliente.getIdade());
                dadosNovosIdade = leia.nextInt();
                System.out.println("Nova idade: " + dadosNovos);
                editarCliente.setIdade(dadosNovosIdade);

                System.out.println("estudante atual: " + editarCliente.getEstudante());
                dadosNovos = leia.nextLine();
                System.out.println("Novo estudante: " + dadosNovos);
                editarCliente.setEstudante(dadosNovos);

                System.out.println(" ");
            }

        }

    }

    public static void excluirCliente() {
        int numeroExcluir;
        Scanner sc = new Scanner(System.in);

        listarCliente(listaCliente);
        System.out.println("Qual o número do cliente que deseja excluir? ");
        numeroExcluir = sc.nextInt();

        if ((numeroExcluir < 1) || (numeroExcluir > listaCliente.size())) {
            System.out.println("Número de cliente inválido!! presta atenção!!");
            excluirCliente();
        } else {
            MenuLoginCliente excluirCliente = listaCliente.get(numeroExcluir - 1);

            if (numeroExcluir == excluirCliente.getId()) {
                excluirCliente.setAtivo(false);
            }
        }

    }

}

