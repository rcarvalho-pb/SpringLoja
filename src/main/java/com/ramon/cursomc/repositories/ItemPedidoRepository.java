package com.ramon.cursomc.repositories;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.domain.ItemPedido;
import com.ramon.cursomc.domain.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
