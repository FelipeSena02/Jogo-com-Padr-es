package tabuleiro;

import java.util.List;
import java.util.Random;

public class CasaSurpresa extends Casa {
	
	private Random random = new Random();
	
	public CasaSurpresa(int numero) {
        super(numero);
    }

	@Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        System.out.println(jogador.getNome() + " caiu em uma casa surpresa.");
        int tipo = random.nextInt(3);
        switch (tipo) {
            case 0:
                jogador.setTipo(new JogadorComSorte(jogador.getNome(), jogador.getCor()));
                break;
            case 1:
                jogador.setTipo(new JogadorAzarado(jogador.getNome(), jogador.getCor()));
                break;
            case 2:
                jogador.setTipo(new JogadorNormal(jogador.getNome(), jogador.getCor()));
                break;
        }
    }

}
