package com.sombra.delivery.gfcsrvsombradelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sombra.delivery.gfcsrvsombradelivery.dtos.CarrinhoDTO;
import com.sombra.delivery.gfcsrvsombradelivery.models.Carrinho;
import com.sombra.delivery.gfcsrvsombradelivery.models.Cliente;
import com.sombra.delivery.gfcsrvsombradelivery.models.ItemCarrinho;
import com.sombra.delivery.gfcsrvsombradelivery.models.Produtos;
import com.sombra.delivery.gfcsrvsombradelivery.repositories.CarrinhoRepository;

import jakarta.validation.Valid;

@Service
public class CarrinhoService {
    
    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutosService produtosService;


    public Carrinho create(@Valid CarrinhoDTO carrinhoDto){
        Carrinho carrinho = new Carrinho();

        Cliente cliente = clienteService.findById(carrinhoDto.getCliente());
        carrinho.setCliente(cliente);

        for(int i = 0; i < carrinhoDto.getItens().size(); i++){
            Produtos produtos = produtosService.findById(carrinhoDto.getItens().get(i).getProdutoId());

           

            if (produtos != null) {
                if (produtos.getQuantidade() != 0) {
                    ItemCarrinho itens = new ItemCarrinho();
                    itens.setProdutos(produtos);
                    itens.setQuantidade(carrinhoDto.getItens().get(i).getQuantidade());

                    carrinho.getItens().add(itens);
                }

            }
        }
         return repository.save(carrinho);
       
    }

    public List<Carrinho> findAll() {
        return repository.findAll();
    } 

    public Carrinho findById(Integer id){
        Optional<Carrinho> carrinho = repository.findById(id);

        return carrinho.get();
    }
    
}
