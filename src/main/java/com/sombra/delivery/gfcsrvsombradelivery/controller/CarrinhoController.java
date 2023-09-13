package com.sombra.delivery.gfcsrvsombradelivery.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sombra.delivery.gfcsrvsombradelivery.dtos.CarrinhoDTO;
import com.sombra.delivery.gfcsrvsombradelivery.models.Carrinho;
import com.sombra.delivery.gfcsrvsombradelivery.services.CarrinhoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/carrinhos")
public class CarrinhoController {
    
    @Autowired
    private CarrinhoService service;

    @PostMapping
    public ResponseEntity<CarrinhoDTO> create(@Valid @RequestBody CarrinhoDTO carrinho){
        Carrinho car = service.create(carrinho);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(car.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> findAll(){
        List<Carrinho> car = service.findAll();

        return ResponseEntity.ok().body(car);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carrinho> findById(@PathVariable Integer id){
       Carrinho car = service.findById(id);

        return ResponseEntity.ok().body(car);
    }
}
