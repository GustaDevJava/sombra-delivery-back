package com.sombra.delivery.gfcsrvsombradelivery.dtos;

import java.io.Serializable;

import com.sombra.delivery.gfcsrvsombradelivery.models.ItemCarrinho;

public class ItemCarrinhoDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer produtoId;
    private int quantidade;
    
    public ItemCarrinhoDTO() {
    }

    public ItemCarrinhoDTO(ItemCarrinho itemCarrinho) {
        this.id = itemCarrinho.getId();
        this.produtoId = itemCarrinho.getProdutos().getId();
        this.quantidade = itemCarrinho.getQuantidade();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
