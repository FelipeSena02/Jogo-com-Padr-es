package tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro {
    private static Tabuleiro instanciaUnica; // Singleton
    private List<Jogador> jogadores;
    private List<Casa> casas;
    private boolean modoDebug;
    private int ultimaCasa;
    private static final Scanner scanner = new Scanner(System.in); // Scanner global para evitar fechamento

    private Tabuleiro() {
        this.jogadores = new ArrayList<>();
        this.casas = new ArrayList<>();
    }

    // Método Singleton com sincronização para evitar múltiplas instâncias
    public static synchronized Tabuleiro getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Tabuleiro();
        }
        return instanciaUnica;
    }

    // Configuração do tabuleiro (chamado pelo Facade `Jogo`)
    public void configurarTabuleiro(int numCasas, boolean modoDebug) {
        this.modoDebug = modoDebug;
        this.ultimaCasa = numCasas;
        this.casas.clear();

        for (int i = 0; i < numCasas; i++) {
            String tipo = definirTipoDeCasa(i); // Define o tipo de casa antes de criar
            CasaFactory.criarCasa(tipo, i, casas);
        }
    }

    // Método auxiliar para definir o tipo de casa com base na posição
    private String definirTipoDeCasa(int numero) {
        if (numero == 0) return "simples"; // Primeira casa sempre simples
        if (numero == ultimaCasa - 1) return "troca"; // Última casa especial
        if (numero % 5 == 0) return "sorte"; // Exemplo: múltiplos de 5 são sorte
        if (numero % 7 == 0) return "azar"; // Exemplo: múltiplos de 7 são azar
        return "simples"; // Padrão
    }

    // Adiciona jogadores ao tabuleiro
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    // Método que gerencia o jogo
    public void jogar() {
        while (!verificarVencedor()) {
            for (Jogador jogador : jogadores) {
                if (jogador.getPrisoes() > 0) {
                    jogador.setPrisoes(jogador.getPrisoes() - 1);
                    System.out.println(jogador.getNome() + " está preso e não pode jogar nesta rodada.");
                    continue;
                }

                if (jogador.podeJogar()) {
                    System.out.println("Vez de " + jogador.getNome() + " (" + jogador.getCor() + ")");
                    int casasMovimento;

                    if (modoDebug) {
                        System.out.print("Insira o número da casa para " + jogador.getNome() + ": ");
                        casasMovimento = scanner.nextInt() - jogador.getPosicao();
                    } else {
                        casasMovimento = jogador.jogarDados();
                        System.out.println(jogador.getNome() + " jogou os dados e tirou " + casasMovimento);
                    }

                    int novaPosicao = jogador.getPosicao() + casasMovimento;

                    // Ajustar para não ultrapassar a última casa
                    if (novaPosicao >= ultimaCasa) {
                        novaPosicao = ultimaCasa;
                        System.out.println(jogador.getNome() + " chegou ao final!");
                    }

                    jogador.setPosicao(novaPosicao);
                    casas.get(novaPosicao).aplicarRegra(jogador, jogadores);
                } else {
                    jogador.setPodeJogar(true);
                }

                exibirEstadoAtual();
            }
        }
    }

    // Exibe o estado atual do jogo
    public void exibirEstadoAtual() {
        System.out.println("\n📌 Estado Atual do Jogo:");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + " está na casa " + jogador.getPosicao() + " com " + jogador.getMoedas() + " moedas.");
        }
        System.out.println("----------------------------");
    }

    // Verifica se há um vencedor
    private boolean verificarVencedor() {
        for (Jogador jogador : jogadores) {
            if (jogador.getPosicao() >= ultimaCasa) {
                System.out.println("\n🏆 " + jogador.getNome() + " venceu o jogo!\n");
                return true;
            }
        }
        return false;
    }
}
