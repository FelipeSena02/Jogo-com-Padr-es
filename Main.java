package tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        List<Jogador> jogadores = new ArrayList<>();
        System.out.println("Quantos jogadores? (2 a 6)");
        int numJogadores = scanner.nextInt();

        while (numJogadores < 2 || numJogadores > 6) {
            System.out.println("O jogo deve ter entre 2 e 6 jogadores. Quantos jogadores?");
            numJogadores = scanner.nextInt();
        }
        System.out.println("Ótimo! Agora digite os seguintes dados: ");

        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Nome do jogador " + (i + 1) + ":");
            String nome = scanner.next();
            System.out.println("Cor do jogador " + nome + ":");
            String cor = scanner.next();

            System.out.println("Existem os seguintes tipos de jogadores: ");
            System.out.println("1. Jogador Com Sorte");
            System.out.println("2. Jogador Azarado");
            System.out.println("3. Jogador Normal");
            System.out.println("Escolha o tipo do jogador " + nome + " (1, 2 ou 3):");
            int tipo = scanner.nextInt();

            JogadorFactory.criarJogador(tipo, jogadores, nome, cor);
        }

        // Verificação para garantir pelo menos dois jogadores de tipos diferentes
        boolean temTiposDiferentes = false;
        outerLoop:
        for (int i = 0; i < jogadores.size(); i++) {
            for (int j = i + 1; j < jogadores.size(); j++) {
                if (!jogadores.get(i).getClass().equals(jogadores.get(j).getClass())) {
                    temTiposDiferentes = true;
                    break outerLoop;
                }
            }
        }

        if (!temTiposDiferentes) {
            System.out.println("O jogo deve ter pelo menos dois jogadores de tipos diferentes. Reinicie o jogo e escolha tipos diferentes.");
            return;
        }
        List<Casa> casas = new ArrayList<>();
        System.out.println("Quantas casas no tabuleiro?");
        int numCasas = scanner.nextInt();

        for (int i = 0; i < numCasas; i++) {
            System.out.println("Tipo da casa " + (i + 1) + " (Simples, Surpresa, Prisao, Sorte, Azar, Reversa, JogaDeNovo, Troca):");
            String tipo = scanner.next();
            CasaFactory.criarCasa(tipo, i, casas);
        }

        System.out.println("Modo debug? (true/false):");
        boolean modoDebug = scanner.nextBoolean();

        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        tabuleiro.configurarTabuleiro(jogadores, modoDebug, casas);


        tabuleiro.jogar();

        scanner.close();
    }
}
