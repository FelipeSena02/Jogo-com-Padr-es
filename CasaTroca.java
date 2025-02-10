package tabuleiro;

import java.util.Scanner;
import java.util.List;

public class CasaTroca extends Casa{
	
	private Scanner scanner = new Scanner(System.in);

    public CasaTroca(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador, List<Jogador> jogadores) {
        System.out.println(jogador.getNome() + " caiu em uma casa de troca. Escolha um item para incrementar seu avatar:");
        System.out.println("1. Boné (+3 moedas, +1 casa por rodada)");
        System.out.println("2. Moletom (+4 moedas, +2 casas por rodada)");
        System.out.println("3. Óculos Escuro (+5 moedas, +3 casas por rodada)");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                jogador.addMoedas(3);
                jogador.setBonus(1);
                System.out.println(jogador.getNome() + " escolheu o Boné.");
                break;
            case 2:
                jogador.addMoedas(4);
                jogador.setBonus(2);
                System.out.println(jogador.getNome() + " escolheu o Moletom.");
                break;
            case 3:
                jogador.addMoedas(5);
                jogador.setBonus(3);
                System.out.println(jogador.getNome() + " escolheu o Óculos Escuro.");
                break;
        }
    }

}
