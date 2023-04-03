package com.ramon.cursomc.repositories;

import com.ramon.cursomc.domain.Pagamento;
import com.ramon.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
