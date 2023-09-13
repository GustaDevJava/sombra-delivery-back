package com.sombra.delivery.gfcsrvsombradelivery.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sombra.delivery.gfcsrvsombradelivery.models.Carrinho;
import com.sombra.delivery.gfcsrvsombradelivery.models.enuns.Status;

import jakarta.validation.constraints.NotNull;

public class CarrinhoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    private Status status;

    @NotNull(message = "O campo nome é requerido")
    private Integer cliente;

    private List<ItemCarrinhoDTO> itens = new ArrayList<>();

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(Carrinho carrinho) {
        this.id = carrinho.getId();
        this.status = carrinho.getStatus();
        this.cliente = carrinho.getCliente().getId();
        this.itens = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }

    

    
}
