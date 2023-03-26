package com.ramon.cursomc.resources;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoriaService.buscar(id));
    }

    @GetMapping(value = "instantiate")
    public void instantiate(){
        Categoria cat1 = new Categoria();
        cat1.setNome("Informática");
        Categoria cat2 = new Categoria();
        cat2.setNome("Escritorio");
        categoriaService.save(cat1);
        categoriaService.save(cat2);
    }

}
