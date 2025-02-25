package tabuleiro;

import java.util.Random;

public abstract class Jogador {
	protected String nome;
    protected String cor;
    protected int posicao;
    protected int moedas;
    protected int bonus;
    protected boolean podeJogar;
    protected int rodadasPreso;

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.posicao = 0;
        this.moedas = 0;
        this.bonus = 0;
        this.podeJogar = true;
    }

    public void mover(int casas) {
        this.posicao += casas + this.bonus;
        System.out.println(this.nome + " se moveu para a casa " + this.posicao);
    }

    public void addMoedas(int quantidade) {
        this.moedas += quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getPosicao() {
        return posicao;
    }
    
    public void setPrisoes(int rodadas) {
        this.rodadasPreso = rodadas;
    }
    
    public int getPrisoes() {
        return this.rodadasPreso;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setPodeJogar(boolean podeJogar) {
        this.podeJogar = podeJogar;
    }

    public boolean podeJogar() {
        return podeJogar;
    }
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    public void setTipo(Jogador novoTipo) {
        this.nome = novoTipo.getNome();
        this.cor = novoTipo.getCor();
        this.posicao = novoTipo.getPosicao();
        this.moedas = novoTipo.getMoedas();
        this.podeJogar = novoTipo.podeJogar();
    }

    @Override
    public String toString() {
        return nome + " na casa " + posicao + " com " + moedas + " moedas";
    }

    public abstract int jogarDados();
}
