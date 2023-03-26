package com.ramon.cursomc.service;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.repositories.CategoriaRepository;
import com.ramon.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria find(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não Encontrado! Id: %s, Tipo: %s.".formatted(id, Categoria.class.getName())));
    }
}
