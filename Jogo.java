package tabuleiro;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private JogadorFactory jogadorFactory;

    public Jogo() {
        this.tabuleiro = Tabuleiro.getInstance(); // Singleton
        this.jogadorFactory = new JogadorFactory(); // Factory para criar jogadores
    }

    // Configura o tabuleiro com um número de casas
    public void configTabuleiro(int numCasas) {
        tabuleiro.configurarCasas(numCasas);
    }

    // Configura os jogadores do jogo
    public void config(int numJogadores) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Escolha o tipo do jogador (1 - Normal, 2 - Sorte, 3 - Azarado): ");
            int tipo = scanner.nextInt();
            Jogador jogador = jogadorFactory.criarJogador(tipo, "Jogador " + (i + 1));
            tabuleiro.adicionarJogador(jogador);
        }
    }

    // Mostra o tabuleiro antes de começar
    public void printTabuleiro() {
        tabuleiro.mostrarTabuleiro();
    }

    // Inicia o jogo
    public void start() {
        while (!tabuleiro.jogoFinalizado()) {
            tabuleiro.jogarRodada();
        }
        tabuleiro.mostrarResultadoFinal();
    }
}

