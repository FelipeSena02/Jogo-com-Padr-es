package tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private JogadorFactory jogadorFactory;
    private static final Scanner scanner = new Scanner(System.in); // Scanner global para evitar fechamento

    public Jogo() {
        this.tabuleiro = Tabuleiro.getInstance(); // Singleton
        this.jogadorFactory = new JogadorFactory(); // Factory para criar jogadores
    }


    public void configTabuleiro(int numCasas, boolean modoDebug) {
        tabuleiro.configurarTabuleiro(numCasas, modoDebug);
    }


    public void configJogadores(int numJogadores) {
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Escolha o tipo do jogador " + (i + 1) + ":");
            System.out.println("1 - Normal");
            System.out.println("2 - Sorte");
            System.out.println("3 - Azarado");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número
            int tipo = escolha;


            System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            System.out.print("Digite a cor do jogador " + (i + 1) + ": ");
            String cor = scanner.nextLine();  // Solicitar a cor do jogador

            List<Jogador> jogadores = new ArrayList<>();
            Jogador jogador = jogadorFactory.criarJogador(tipo, jogadores, nome, cor);
            tabuleiro.adicionarJogador(jogador);
        }
    }


    public void printTabuleiro() {
        tabuleiro.exibirEstadoAtual();
    }

    public void start() {
        tabuleiro.jogar();
    }
}
