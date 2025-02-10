package tabuleiro;

import java.util.List;

public class CasaAzar extends Casa{
	
	public CasaAzar(int numero) {
		super(numero);
	}
	
	@Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        if (!(jogador instanceof JogadorComSorte)) {
            jogador.addMoedas(-3);
            System.out.println(jogador.getNome() + " caiu em uma casa de azar e perdeu 3 moedas.");
        }
    }

}
