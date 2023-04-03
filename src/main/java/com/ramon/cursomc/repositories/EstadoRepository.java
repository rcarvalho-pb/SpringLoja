package com.ramon.cursomc.repositories;

import com.ramon.cursomc.domain.Cidade;
import com.ramon.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
