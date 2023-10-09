package br.edu.ifce.tjw.service.implementations;

import br.edu.ifce.tjw.model.Cliente;
import br.edu.ifce.tjw.repository.ClienteRepository;
import br.edu.ifce.tjw.service.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RelationalClienteService implements ClienteService {
    private final ClienteRepository clienteRepository;
    @Autowired
    public RelationalClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente postCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }
}
