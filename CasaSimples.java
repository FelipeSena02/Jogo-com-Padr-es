package tabuleiro;

import java.util.List;

public class CasaSimples extends Casa {
	
	public CasaSimples(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        jogador.addMoedas(1);
        System.out.println(jogador.getNome() + " caiu em uma casa simples e ganhou 1 moeda.");
    }

}
