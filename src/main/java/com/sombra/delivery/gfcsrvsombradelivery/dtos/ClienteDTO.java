package com.sombra.delivery.gfcsrvsombradelivery.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.sombra.delivery.gfcsrvsombradelivery.models.Cliente;
import com.sombra.delivery.gfcsrvsombradelivery.models.Condominio;
import com.sombra.delivery.gfcsrvsombradelivery.models.Endereco;

import jakarta.validation.constraints.NotEmpty;


public class ClienteDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo nome é requerido")
    private String nome;

    @NotEmpty(message = "O campo cpf é requerido")
    @CPF
    private String cpf;


    private String dataNascimento;

    @NotEmpty(message = "O campo telefone é requerido")
    private String telefone;

    
    private Endereco endereco;
    private Condominio condominio;
    
    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.condominio = cliente.getCondominio();
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Condominio getCondominio() {
        return condominio;
    }
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
