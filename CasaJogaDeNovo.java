package tabuleiro;

import java.util.List;
import java.util.Random;

public class CasaJogaDeNovo extends Casa{
	
	public CasaJogaDeNovo(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        Random random = new Random();
        int dados = random.nextInt(6) + 1 + random.nextInt(6) + 1;
        jogador.addMoedas(dados);
        System.out.println(jogador.getNome() + " caiu em uma casa de joga de novo e ganhou " + dados + " moedas e vai jogar novamente.");
        jogador.jogarDados();
    }

}
