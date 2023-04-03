package com.ramon.cursomc;

import com.ramon.cursomc.domain.*;
import com.ramon.cursomc.domain.enums.TipoCliente;
import com.ramon.cursomc.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public CursomcApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, CidadeRepository cidadeRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
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

        //primeiro salva a categoria, pois ele independe do produto

        produtoRepository.saveAll(List.of(p1, p2, p3));
        categoriaRepository.saveAll(List.of(cat1, cat2));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));
        //primeiro salva o estado, pois ele independe da cidade
        estadoRepository.saveAll(List.of(est1, est2));
        cidadeRepository.saveAll(List.of(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(List.of(e1, e2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(List.of(e1, e2));
    }
}
