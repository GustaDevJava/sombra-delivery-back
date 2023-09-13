package com.sombra.delivery.gfcsrvsombradelivery.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sombra.delivery.gfcsrvsombradelivery.dtos.ClienteDTO;
import com.sombra.delivery.gfcsrvsombradelivery.models.Cliente;
import com.sombra.delivery.gfcsrvsombradelivery.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> lista = clienteService.findAll();
        List<ClienteDTO> clienteDTOs = new ArrayList<>();

        for(Cliente cliente : lista){
            clienteDTOs.add(new ClienteDTO(cliente));
        }
        return ResponseEntity.ok().body(clienteDTOs);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        ClienteDTO clienteDto = new ClienteDTO(clienteService.findById(id));
        return ResponseEntity.ok().body(clienteDto);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastro( @Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cadastro = clienteService.cadastro(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(cadastro.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO novoCliente, @PathVariable Integer id){
        ClienteDTO clienteDTO = new ClienteDTO(clienteService.update(id, novoCliente)) ;

        return ResponseEntity.ok().body(clienteDTO);
    }
}
