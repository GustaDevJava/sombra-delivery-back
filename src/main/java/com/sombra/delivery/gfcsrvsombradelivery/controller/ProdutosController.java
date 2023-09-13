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

import com.sombra.delivery.gfcsrvsombradelivery.models.Produtos;
import com.sombra.delivery.gfcsrvsombradelivery.services.ProdutosService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    
    @Autowired
    private ProdutosService service;

    @GetMapping
    public ResponseEntity<List<Produtos>> findAll(){
        List<Produtos> produtos = service.findAll();

        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable Integer id){
        Produtos produtos = service.findById(id);

        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<Produtos> create(@RequestBody Produtos produtos){
        Produtos prod = service.create(produtos);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(prod.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
