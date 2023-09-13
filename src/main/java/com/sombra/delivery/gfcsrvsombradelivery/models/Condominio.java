package com.sombra.delivery.gfcsrvsombradelivery.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Condominio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(generator = "endereco", strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_condominio")
    private Integer id;
    private String bloco;
    private String apartamento;
    private String andar;
    
    public Condominio() {
    }

    public Condominio(Integer id, String bloco, String apartamento, String andar) {
        this.id = id;
        this.bloco = bloco;
        this.apartamento = apartamento;
        this.andar = andar;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBloco() {
        return bloco;
    }
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
    public String getApartamento() {
        return apartamento;
    }
    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }
    public String getAndar() {
        return andar;
    }
    public void setAndar(String andar) {
        this.andar = andar;
    }
    

    
}
