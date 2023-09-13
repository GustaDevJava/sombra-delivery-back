package com.sombra.delivery.gfcsrvsombradelivery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sombra.delivery.gfcsrvsombradelivery.models.Endereco;
import com.sombra.delivery.gfcsrvsombradelivery.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;

    public Endereco alteraEndereco(Endereco endereco, Integer id){
        Optional<Endereco> enderecoCad = repository.findById(id);

            enderecoCad.get().setRua(endereco.getRua());
            enderecoCad.get().setNumero(endereco.getNumero());
            enderecoCad.get().setComplemento(endereco.getComplemento());
            enderecoCad.get().setCep(endereco.getCep());

            return repository.save(enderecoCad.get());
    }
}
