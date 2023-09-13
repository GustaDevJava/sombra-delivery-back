package com.sombra.delivery.gfcsrvsombradelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sombra.delivery.gfcsrvsombradelivery.models.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{
    
}
