package br.edu.ifg;

public class Produto {
    private float valor;
    private int quantidade;
    private String nome;
    private String tipo;

    public Produto(float valor, int quantidade, String nome, String tipo) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.nome = nome;
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
