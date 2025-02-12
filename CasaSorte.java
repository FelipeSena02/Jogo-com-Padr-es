package tabuleiro;

import java.util.List;

public class CasaSorte extends Casa{
	
	public CasaSorte(int numero) {
		super(numero);
	}
	
	@Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        if (!(jogador instanceof JogadorAzarado)) {
            jogador.mover(3);
            jogador.addMoedas(3);
            System.out.println(jogador.getNome() + " caiu em uma casa de sorte e ganhou 3 moedas e avançou 3 casas.");
        }
    }

}
