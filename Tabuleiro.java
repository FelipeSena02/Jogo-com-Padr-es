package tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
	private List<Jogador> jogadores;
    private List<Casa> casas;
    private boolean modoDebug;

    public Tabuleiro(List<Jogador> jogadores, boolean modoDebug, List<Casa> casas) {
        this.jogadores = jogadores;
        this.modoDebug = modoDebug;
        this.casas = casas;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        while (!verificarVencedor()) {
            for (Jogador jogador : jogadores) {
                if (jogador.getPrisoes() > 0) {
                    jogador.setPrisoes(jogador.getPrisoes() - 1);
                    System.out.println(jogador.getNome() + " está preso e não pode jogar nesta rodada.");
                    continue;
                }
                if (jogador.podeJogar()) {
                    System.out.println("Vez de " + jogador.getNome() + " (" + jogador.getCor() + ")");
                    int casasMovimento;
                    if (modoDebug) {
                        System.out.println("Insira o número da casa que " + jogador.getNome() + " deve ir: ");
                        casasMovimento = scanner.nextInt() - jogador.getPosicao();
                    } else {
                        casasMovimento = jogador.jogarDados();
                        System.out.println(jogador.getNome() + " jogou os dados e tirou " + casasMovimento);
                    }
                    jogador.mover(casasMovimento);
                    if (jogador.getPosicao() < casas.size()) {
                        casas.get(jogador.getPosicao()).aplicarRegra(jogador, jogadores);
                    } 
                } else {
                    jogador.setPodeJogar(true);
                }
                mostrarPosicoes();
            }
        }
        scanner.close();
    }

    private void mostrarPosicoes() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    private boolean verificarVencedor() {
        for (Jogador jogador : jogadores) {
            if (jogador.getPosicao() >= casas.size() - 1) {
                System.out.println(jogador.getNome() + " venceu o jogo!");
                return true;
            }
        }
        return false;
    }

}
