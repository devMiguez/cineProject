package entities;


import java.util.Scanner;


public class TelaDeFilmes {
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((scanner == null) ? 0 : scanner.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TelaDeFilmes other = (TelaDeFilmes) obj;
        if (scanner == null) {
            if (other.scanner != null)
                return false;
        } else if (!scanner.equals(other.scanner))
            return false;
        return true;
    }


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
        Sala salaEscolhida = escolherSala(filmeEscolhido);

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
                    System.out.println();
                    System.out.println("Opção de filme inválida. Tente novamente.");
                    System.out.println();
            }
        }
        return filmeEscolhido;
    }

    private Sala escolherSala(Filme filme) {
        Sala salaEscolhida = null;
        while (salaEscolhida == null) {
            System.out.println("Escolha uma sala para o filme " + ((Filme) filme).getTitulo() + ":");
            System.out.println("(1) Sala A");
            System.out.println("(2) Sala B");
            System.out.println("(3) Sala C");
            System.out.print("Digite o número da sala: ");
            int escolhaSala = scanner.nextInt();

            switch (escolhaSala) {
                case 1:
                    salaEscolhida = new Sala("Sala A", 80);
                    break;
                case 2:
                    salaEscolhida = new Sala("Sala B", 80);
                    break;
                case 3:
                    salaEscolhida = new Sala("Sala C", 80);
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção de sala inválida. Tente novamente.");
                    System.out.println();
            }
        }
        return salaEscolhida;
    }

    private Horario escolherHorario() {
        Horario horarioEscolhido = null;
        while (horarioEscolhido == null) {
            System.out.println("Escolha um horário:");
            System.out.println("(1) 14:00");
            System.out.println("(2) 17:00");
            System.out.println("(3) 19:00");
            System.out.print("Digite o número do horário: ");
            int escolhaHorario = scanner.nextInt();

            switch (escolhaHorario) {
                case 1:
                    horarioEscolhido = new Horario("14:00");
                    break;
                case 2:
                    horarioEscolhido = new Horario("17:00");
                    break;
                case 3:
                    horarioEscolhido = new Horario("19:00");
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção de horário inválida. Tente novamente");
                    System.out.println();
            }
        }
        return horarioEscolhido;
    }

    private void exibirReserva(Filme filme, Sala sala, Horario horario) {
        System.out.println();
        System.out.println("Você escolheu o filme: " + filme.getTitulo());
        System.out.println("Você escolheu a sala: " + sala.getNome());
        System.out.println("Você escolheu o horário: " + horario.getHorario());
        System.out.println("Assentos disponíveis para o filme " + filme.getTitulo() + ":");
        exibirEstadoAssentos(sala);

        // Simulando a ocupação de alguns assentos
        sala.ocuparAssento(2);
        sala.ocuparAssento(5);

        System.out.println("\nAssentos após a ocupação:");
        exibirEstadoAssentos(sala);
        System.out.println("\nAproveite o filme!");
    }

    
        void exibirEstadoAssentos(Sala sala){
        for (Assento assento : sala.getAssentos()) {
            System.out.print(assento + " ");
            }
       
        }
    }        