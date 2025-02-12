package tabuleiro;

import java.util.List;

public class JogadorFactory {
    public static Jogador criarJogador(int tipo, List<Jogador> jogadores, String nome, String cor) {
        Jogador jogador = switch (tipo) {
            case 1 -> new JogadorComSorte(nome, cor);
            case 2 -> new JogadorAzarado(nome, cor);
            default -> new JogadorNormal(nome, cor);
        };
        jogadores.add(jogador);
        return jogador;
    }

}
