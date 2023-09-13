package com.sombra.delivery.gfcsrvsombradelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sombra.delivery.gfcsrvsombradelivery.models.ItemCarrinho;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Integer>{
}
