package com.sombra.delivery.gfcsrvsombradelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sombra.delivery.gfcsrvsombradelivery.models.Produtos;
import com.sombra.delivery.gfcsrvsombradelivery.repositories.ProdutosRepository;

@Service
public class ProdutosService {
    
    @Autowired
    private ProdutosRepository repository;

    public List<Produtos> findAll(){
        return repository.findAll();
    }

    public Produtos findById(Integer id){
        Optional<Produtos> produto = repository.findById(id);

        return produto.get();
    }

    public Produtos create(Produtos produtos){
        Produtos newProduto = new Produtos();

        newProduto.setNome(produtos.getNome());
        newProduto.setDescricao(produtos.getDescricao());
        newProduto.setTipo(produtos.getTipo());
        newProduto.setPreco(produtos.getPreco());
        newProduto.setQuantidade(produtos.getQuantidade());

        return repository.save(newProduto);
    }
}
