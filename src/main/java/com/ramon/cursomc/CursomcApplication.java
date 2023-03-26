package com.ramon.cursomc;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.domain.Produto;
import com.ramon.cursomc.repositories.CategoriaRepository;
import com.ramon.cursomc.repositories.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    public CursomcApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.0);
        Produto p2 = new Produto(null, "Impressora",800.0);
        Produto p3 = new Produto(null, "Mouse",80.0);

        cat1.getProdutos().addAll(List.of(p1, p2, p3));
        cat2.getProdutos().addAll(List.of(p2));

        p1.getCategorias().addAll(List.of(cat1));
        p2.getCategorias().addAll(List.of(cat1, cat2));
        p3.getCategorias().addAll(List.of(cat1));

        categoriaRepository.saveAll(List.of(cat1, cat2));
        produtoRepository.saveAll(List.of(p1, p2, p3));
    }
}
