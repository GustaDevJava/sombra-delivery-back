package com.sombra.delivery.gfcsrvsombradelivery.models;

import java.io.Serializable;

import com.sombra.delivery.gfcsrvsombradelivery.models.enuns.TipoProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produtos implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo nome é requerido")
    private String nome;

    @NotEmpty(message = "O campo descricao é requerido")
    private String descricao;

    private TipoProduto tipo;

    @NotNull(message = "O campo preço não pode ser nulo")
    private Double preco;

    private int quantidade;

    public Produtos() {
    }
    
    public Produtos(Integer id, String nome, String descricao, TipoProduto tipo, Double preco,
    int quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public TipoProduto getTipo() {
        return tipo;
    }
    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
