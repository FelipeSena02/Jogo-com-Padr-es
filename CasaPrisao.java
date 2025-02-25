package tabuleiro;

import java.util.List;

public class CasaPrisao extends Casa {
	
	public CasaPrisao(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        System.out.println(jogador.getNome() + " caiu em uma casa de prisão.");
        if (jogador.getMoedas() >= 2) {
            jogador.setPodeJogar(false);
            jogador.addMoedas(-2);
            System.out.println(jogador.getNome() + " pagou 2 moedas para sair da prisão.");
        } else {
            jogador.setPrisoes(2);
            System.out.println(jogador.getNome() + " não pode jogar por 2 rodadas.");
        }
    }

}
