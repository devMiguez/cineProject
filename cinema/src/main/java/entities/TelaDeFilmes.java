package entities;

import lombok.Data;
import java.util.Scanner;

@Data
public class TelaDeFilmes {
    
    private Scanner scanner;

    public TelaDeFilmes() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println(" Vamos escolher o seu filme!");
        System.out.println("-----------------------------");

        // Exibe os filmes disponíveis e permite que o usuário escolha um filme
        Filme filmeEscolhido = escolherFilme();

        // Exibe as salas disponíveis e permite que o usuário escolha uma sala
        Sala salaEscolhida = escolherSala();

        // Exibe os horários disponíveis e permite que o usuário escolha um horário
        Horario horarioEscolhido = escolherHorario();

        // Exibe as informações finais da reserva
        exibirReserva(filmeEscolhido, salaEscolhida, horarioEscolhido);

        scanner.close();
    }

    private Filme escolherFilme() {
        Filme filmeEscolhido = null;
        while (filmeEscolhido == null) {
            System.out.println("Escolha um filme digitando seu respectivo número:");
            System.out.println("(1) O exorcista");
            System.out.println("(2) A freira 2");
            System.out.println("(3) Som da liberdade");
            System.out.print("Digite o número do filme: ");
            int escolhaFilme = scanner.nextInt();

            switch (escolhaFilme) {
                case 1:
                    filmeEscolhido = new Filme("O exorcista");
                    break;
                case 2:
                    filmeEscolhido = new Filme("A freira 2");
                    break;
                case 3:
                    filmeEscolhido = new Filme("Som da liberdade");
                    break;
                default:
                    System.out.println ( );
                    System.out.println("Opção de filme inválida. Tente novamente.");
                    System.out.println ( );
            }
        }
        return filmeEscolhido;
    }

    private Sala escolherSala() {
        Sala salaEscolhida = null;
        while (salaEscolhida  == null) {
            System.out.println("Escolha uma sala:");
            System.out.println("(1) Sala A");
            System.out.println("(2) Sala B");
            System.out.println("(3) Sala C");
            System.out.print("Digite o número da sala: ");
            int escolhaSala = scanner.nextInt();

        switch (escolhaSala) {
            case 1:
                return new Sala("Sala A");
            case 2:
                return new Sala("Sala B");
            case 3:
                return new Sala("Sala C");
            default:
                System.out.println ( );
                System.out.println("Opção de sala inválida. Tente novamente.");
                System.out.println ( );
        }
    }

        return salaEscolhida;
}

    private Horario escolherHorario() {
        Horario horarioEscolhido = null;
        while (horarioEscolhido  == null) {
        System.out.println("Escolha um horário:");
        System.out.println("(1) 14:00");
        System.out.println("(2) 17:00");
        System.out.println("(3) 19:00");
        System.out.print("Digite o número do horário: ");
        int escolhaHorario = scanner.nextInt();

        switch (escolhaHorario) {
            case 1:
                return new Horario("14:00");
            case 2:
                return new Horario("17:00");
            case 3:
                return new Horario("19:00");
            default:
                System.out.println ( );
                System.out.println("Opção de horário inválida. Tente novamente");
                System.out.println ( );
        }
    }
        return horarioEscolhido;
}    

    private void exibirReserva(Filme filme, Sala sala, Horario horario) {
        System.out.println (  );
        System.out.println (  );
        System.out.println("Você escolheu o filme: " + filme.getTitulo());
        System.out.println("Você escolheu a sala: " + sala.getNome());
        System.out.println("Você escolheu o horário: " + horario.getHorario());
        System.out.println ( );
        System.out.println ( );
        System.out.println ( );
        System.out.println ( );
        System.out.println("Aproveite o filme!");
        System.out.println ( );
    }
}

class Filme {
    private final String titulo;

    public Filme(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Sala {
    private final String nome;

    public Sala(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Horario {
    private final String horario;

    public Horario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
}