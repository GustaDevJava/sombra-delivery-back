package com.sombra.delivery.gfcsrvsombradelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sombra.delivery.gfcsrvsombradelivery.dtos.ClienteDTO;
import com.sombra.delivery.gfcsrvsombradelivery.models.Cliente;
import com.sombra.delivery.gfcsrvsombradelivery.models.Condominio;
import com.sombra.delivery.gfcsrvsombradelivery.models.Endereco;
import com.sombra.delivery.gfcsrvsombradelivery.repositories.ClienteRepository;
import com.sombra.delivery.gfcsrvsombradelivery.repositories.EnderecoRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        Optional<Cliente>  cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public Cliente cadastro(ClienteDTO clienteDTO){
        Cliente cadastro = new Cliente();

        cadastro.setNome(clienteDTO.getNome());
        cadastro.setCpf(clienteDTO.getCpf());
        cadastro.setDataNascimento(clienteDTO.getDataNascimento());
        cadastro.setTelefone(clienteDTO.getTelefone());
        
        if(clienteDTO.getEndereco().getRua() != null){
            
            Endereco endereco = new Endereco();
            endereco.setRua(clienteDTO.getEndereco().getRua());
            endereco.setNumero(clienteDTO.getEndereco().getNumero());
            endereco.setComplemento(clienteDTO.getEndereco().getComplemento());
            endereco.setCep(clienteDTO.getEndereco().getCep());
            cadastro.setEndereco(endereco);
        }

        if(clienteDTO.getCondominio().getApartamento() != null){
            Condominio condominio = new Condominio();
            condominio.setBloco(clienteDTO.getCondominio().getBloco());
            condominio.setApartamento(clienteDTO.getCondominio().getApartamento());
            condominio.setAndar(clienteDTO.getCondominio().getAndar());
            cadastro.setCondominio(condominio);
        }

        
       

        return clienteRepository.save(cadastro);
    }

    public Cliente update(Integer id, ClienteDTO upCliente){
        Optional<Cliente> cadCliente = clienteRepository.findById(id);
        
        cadCliente.get().setNome(upCliente.getNome());
        cadCliente.get().setCpf(upCliente.getCpf());
        cadCliente.get().setDataNascimento(upCliente.getDataNascimento());
        cadCliente.get().setTelefone(upCliente.getTelefone());
        
        if(upCliente.getEndereco().getRua() != null){

            Optional<Endereco> endereco = enderecoRepository.findById(cadCliente.get().getEndereco().getId());
            endereco.get().setRua(upCliente.getEndereco().getRua());
            endereco.get().setNumero(upCliente.getEndereco().getNumero());
            endereco.get().setComplemento(upCliente.getEndereco().getComplemento());
            endereco.get().setCep(upCliente.getEndereco().getCep());
            cadCliente.get().setEndereco(endereco.get());
            enderecoRepository.save(endereco.get());
        }

        if(upCliente.getCondominio().getApartamento() != null){
            Condominio condominio = new Condominio();
            condominio.setBloco(upCliente.getCondominio().getBloco());
            condominio.setApartamento(upCliente.getCondominio().getApartamento());
            condominio.setAndar(upCliente.getCondominio().getAndar());
            cadCliente.get().setCondominio(condominio);
        }

        
        
        return clienteRepository.save(cadCliente.get());
        
    }

    
}
