package entities;

import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Cliente extends Pessoa{
    @Id 
    private Integer id;
    private boolean ativo;
    private String idade;
    private String estudante;
    private static int contadorId = 1;
    private static ArrayList<Cliente> listaCliente = new ArrayList<>();


    public Cliente(String nome, String cpf, String email, String tel, String idade, String estudante) {
        super(nome, cpf, email, tel);
        this.id = Cliente.contadorId;
        this.ativo = true;
        Cliente.contadorId++;
        this.idade = idade;
        this.estudante = estudante;
    }

    //Método que já define 3 clientes certos a minha lista
    public static void clientesCadastrados(){
        Cliente cliente01 = new Cliente("joao", "06601927724", "joaovmiguez@gmail.com", "24988181676", "18", "sim");
        Cliente cliente02 = new Cliente("Rodrigo", "98897656678", "rodrigo@gmail.com", "24988181676", "45", "sim");
        Cliente cliente03 = new Cliente("Felipe", "988172675", "felipe@gmail.com", "24788987676", "55", "nao");

        listaCliente.add(cliente01);
        listaCliente.add(cliente02);
        listaCliente.add(cliente03);
    }

    public static void cadastraCliente(){
        Scanner leiaDados = new Scanner(System.in);

        //Perguntas para cadastro de cliente que serão inseridas no ArrayList
        System.out.println("CADASTRO DE CLIENTE:");
        System.out.println("");
        System.out.println("Digite seu nome:");
        String nome = leiaDados.nextLine();
        System.out.println("Digite seu cpf: ");
        String cpf = leiaDados.nextLine();
        System.out.println("Digite seu email: ");
        String email = leiaDados.nextLine();
        System.out.println("Digite seu telefone: ");
        String tel = leiaDados.nextLine();
        System.out.println("Digite sua idade: ");
        String idade = leiaDados.nextLine();
        System.out.println("estudante (responda com 'sim' ou 'nao'): ");
        String estudante = leiaDados.nextLine();


        Cliente clienteNovo = new Cliente(nome, cpf, email, tel, idade, estudante);
        listaCliente.add(clienteNovo);
        System.out.println("Cliente cadastrado!!");

        //Pergunta ao usuário se deseja cadastrar outro cliente
        while(true){
            System.out.println("Deseja cadastrar outro cliente? (Digite [1] para sim, [2] para não)");
            int resposta = leiaDados.nextInt();
            if(resposta == 1){
                cadastraCliente();//Chama o método novamente para cadastrar outro cliente
            }else if(resposta == 2){
                System.out.println("Ok!!");
                break;//Sai do loop
            }else{
                System.out.println("Digite uma resposta válida!!");
            }
        }

        //Pergunta ao usuário se deseja editar um usuário cadastrado!!
        while(true){
            System.out.println("Deseja editar um cliente cadastrado? (Digite [1] para sim, [2] para não)");
            int desejaEditar = leiaDados.nextInt();
            switch(desejaEditar) {
                case 1:
                    editaCliente();
                    break;
                case 2:
                    System.out.println("Ok!!");
                    break;
                default:
                    System.out.println("Digite um número válido!!!");
                    break;
            }
            break;
        }

        //Pergunta ao usuário se ele deseja excluir um cliente
        while(true){
            System.out.println("Deseja excluir um cliente cadastrado? (Digite [1] para sim, [2] para não)");
            int desejaExcluir = leiaDados.nextInt();
            switch(desejaExcluir) {
                case 1:
                    excluirCliente();
                    break;
                case 2:
                    System.out.println("Ok!!");
                    break;
                default:
                    System.out.println("Digite um número válido!!!");
                    break;
            }
            break;
        }
        

    }

    public static void listarCliente(){
        if (listaCliente.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : listaCliente) {
                if(cliente.ativo){
                    System.out.println("Id: " + cliente.getId());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Telefone: " + cliente.getTel());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("Estudante: " + cliente.getEstudante());
                    System.out.println("-----------------------------");
                }
            }
        }
    }

    public static void editaCliente(){
        String dadosNovos;
        int numeroCliente;
        Scanner leia = new Scanner(System.in);

        listarCliente();//Aqui ele irá mostrar a lista de clientes cadastrados!!

        if(listaCliente.isEmpty()){ // Se a lista estiver vazia (isEmpty) diga que não há clientes cadastrados!!
            System.out.println("Não há clientes cadastrados!!");
        }else{
            System.out.println("Digite o número do cliente que deseja editar: ");
            numeroCliente = leia.nextInt();

            if((numeroCliente < 1) || (numeroCliente > listaCliente.size())){
                System.out.println("Número do cliente inválido!!");
            }else{
                leia.nextLine();//Consome a nova linha pendente após a leitura do número do Cliente (não entendi)
                Cliente editarCliente = listaCliente.get(numeroCliente - 1);

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

                System.out.println("Idade atual: " + editarCliente.getIdade());
                dadosNovos = leia.nextLine();
                System.out.println("Nova idade: " + dadosNovos);
                editarCliente.setIdade(dadosNovos);

                System.out.println("Estudante atual: " + editarCliente.getEstudante());
                dadosNovos = leia.nextLine();
                System.out.println("Novo estudante: " + dadosNovos);
                editarCliente.setEstudante(dadosNovos);

                System.out.println(" ");
            }

        }


    }

    public static void excluirCliente(){
        int numeroExcluir;
        Scanner sc = new Scanner(System.in);

        listarCliente();
        System.out.println("Qual o número do cliente que deseja excluir? ");
        numeroExcluir = sc.nextInt();

        if((numeroExcluir < 1) || (numeroExcluir > listaCliente.size())){
            System.out.println("Número de cliente inválido!! presta atenção!!");
            excluirCliente();
        }else{
            Cliente excluirCliente = listaCliente.get(numeroExcluir - 1);

            if(numeroExcluir == excluirCliente.getId()){
                excluirCliente.setAtivo(false);
            }
        }

    }

}

