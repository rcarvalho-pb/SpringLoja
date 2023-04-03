package com.ramon.cursomc.repositories;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
