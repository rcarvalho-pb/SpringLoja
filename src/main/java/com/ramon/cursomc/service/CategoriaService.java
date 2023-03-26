package com.ramon.cursomc.service;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.repositories.CategoriaRepository;
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

    public Categoria buscar(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
