package tabuleiro;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();

        System.out.print("Digite o número de casas do tabuleiro: ");
        int numCasas = scanner.nextInt();

        System.out.print("Modo Debug? (true/false): ");
        boolean modoDebug = scanner.nextBoolean();

        System.out.print("Digite o número de jogadores (mínimo 2, máximo 6): ");
        int numJogadores = scanner.nextInt();

        while (numJogadores < 2 || numJogadores > 6) {
            System.out.println("O jogo deve ter entre 2 e 6 jogadores.");
            System.out.print("Digite novamente: ");
            numJogadores = scanner.nextInt();
        }


        jogo.configTabuleiro(numCasas, modoDebug);
        jogo.configJogadores(numJogadores);
        jogo.printTabuleiro();
        jogo.start();

        scanner.close();
    }
}
