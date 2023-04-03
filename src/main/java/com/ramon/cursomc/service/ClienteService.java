package com.ramon.cursomc.service;

import com.ramon.cursomc.domain.Categoria;
import com.ramon.cursomc.domain.Cliente;
import com.ramon.cursomc.repositories.CategoriaRepository;
import com.ramon.cursomc.repositories.ClienteRepository;
import com.ramon.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente find(Integer id) {
        return clienteRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não Encontrado! Id: %s, Tipo: %s.".formatted(id, Categoria.class.getName())));
    }
}
