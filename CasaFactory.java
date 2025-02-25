package tabuleiro;

import java.util.List;

public class CasaFactory {

    public static void criarCasa(String tipo, int numero, List<Casa> casas){

        switch (tipo.toLowerCase()) {
            case "simples":
                casas.add(new CasaSimples(numero));
                break;
            case "surpresa":
                casas.add(new CasaSurpresa(numero));
                break;
            case "prisao":
                casas.add(new CasaPrisao(numero));
                break;
            case "sorte":
                casas.add(new CasaSorte(numero));
                break;
            case "azar":
                casas.add(new CasaAzar(numero));
                break;
            case "reversa":
                casas.add(new CasaReversa(numero));
                break;
            case "jogadenovo":
                casas.add(new CasaJogaDeNovo(numero));
                break;
            case "troca":
                casas.add(new CasaTroca(numero));
                break;
            default:
                System.out.println("Tipo de casa inválido. Adicionando casa Simples.");
                casas.add(new CasaSimples(numero));
                break;
        }

    }
}
