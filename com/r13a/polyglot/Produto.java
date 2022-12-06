package com.r13a.polyglot;
public class Produto {
    public String nome;
    public Integer quantidade;
    public Double preço;
    
    public Produto(String nome, Integer quantidade, Double preço) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preço = preço;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getPreço() {
        return preço;
    }
    public void setPreço(Double preço) {
        this.preço = preço;
    }
}
