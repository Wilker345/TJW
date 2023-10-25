package br.edu.ifce.tjw.controller;

import br.edu.ifce.tjw.controller.exception.TupleNotFoundException;
import br.edu.ifce.tjw.model.Cliente;
import br.edu.ifce.tjw.model.dto.cliente.ClienteDTO;
import br.edu.ifce.tjw.service.implementations.RelationalClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    RelationalClienteService clienteService;

    public ClienteController() {
    }

    @Autowired
    ClienteController(RelationalClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping("")
    public List<Cliente> getAll() {
        return clienteService.getAllClientes();
    }
    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable long id) throws TupleNotFoundException {
        return clienteService.getCliente(id);
    }
}
