package tabuleiro;

import java.util.List;

public class CasaReversa extends Casa{
	
	public CasaReversa(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        Jogador jogadorMaisAtras = null;
        for (Jogador j : jogadores) {
            if (!j.equals(jogador) && (jogadorMaisAtras == null || j.getPosicao() < jogadorMaisAtras.getPosicao())) {
                jogadorMaisAtras = j;
            }
        }
        if (jogadorMaisAtras != null && jogador.getPosicao() > jogadorMaisAtras.getPosicao()) {
            int tempPosicao = jogador.getPosicao();
            jogador.setPosicao(jogadorMaisAtras.getPosicao());
            jogadorMaisAtras.setPosicao(tempPosicao);
            System.out.println(jogador.getNome() + " trocou de lugar com " + jogadorMaisAtras.getNome());
        } else {
            System.out.println(jogador.getNome() + " já é o último, então não troca de lugar.");
        }
    }

}
