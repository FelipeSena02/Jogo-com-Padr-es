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

        System.out.println("Escolha os tipos de jogadores: ");
        System.out.println("1. Jogador Com Sorte");
        System.out.println("2. Jogador Azarado");
        System.out.println("3. Jogador Normal");

        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Nome do jogador " + (i + 1) + ":");
            String nome = scanner.next();
            System.out.println("Cor do jogador " + nome + ":");
            String cor = scanner.next();

            System.out.println("Escolha o tipo do jogador " + nome + " (1, 2 ou 3):");
            int tipo = scanner.nextInt();

            Jogador jogador;
            switch (tipo) {
                case 1:
                    jogador = new JogadorComSorte(nome, cor);
                    break;
                case 2:
                    jogador = new JogadorAzarado(nome, cor);
                    break;
                case 3:
                default:
                    jogador = new JogadorNormal(nome, cor);
                    break;
            }
            jogadores.add(jogador);
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
            switch (tipo.toLowerCase()) {
                case "simples":
                    casas.add(new CasaSimples(i));
                    break;
                case "surpresa":
                    casas.add(new CasaSurpresa(i));
                    break;
                case "prisao":
                    casas.add(new CasaPrisao(i));
                    break;
                case "sorte":
                    casas.add(new CasaSorte(i));
                    break;
                case "azar":
                    casas.add(new CasaAzar(i));
                    break;
                case "reversa":
                    casas.add(new CasaReversa(i));
                    break;
                case "jogadenovo":
                    casas.add(new CasaJogaDeNovo(i));
                    break;
                case "troca":
                    casas.add(new CasaTroca(i));
                    break;
                default:
                    System.out.println("Tipo de casa inválido. Adicionando casa Simples.");
                    casas.add(new CasaSimples(i));
                    break;
            }
        }

        System.out.println("Modo debug? (true/false):");
        boolean modoDebug = scanner.nextBoolean();

        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        tabuleiro.configurarTabuleiro(jogadores, modoDebug, casas);


        tabuleiro.jogar();

        scanner.close();
    }
}
