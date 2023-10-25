package br.edu.ifce.tjw.service.implementations;

import br.edu.ifce.tjw.controller.exception.TupleNotFoundException;
import br.edu.ifce.tjw.model.Cliente;
import br.edu.ifce.tjw.model.dto.cliente.ClienteDTO;
import br.edu.ifce.tjw.model.mapper.cliente.ClienteMapper;
import br.edu.ifce.tjw.repository.interfaces.ClienteRepository;
import br.edu.ifce.tjw.service.interfaces.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RelationalClienteService implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    @Autowired
    public RelationalClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    public ClienteDTO getCliente(long id) throws TupleNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new TupleNotFoundException("Cliente", "Não existe instância com id==" + id);
        } else {
            return clienteMapper.toDTO(cliente.get());
        }
    }
    public Cliente postCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }
    public Cliente updateCliente(long id, Cliente updatedCliente) throws EntityNotFoundException {
        Cliente cliente = clienteRepository.getReferenceById(id);
        cliente.setNome(updatedCliente.getNome());
        return cliente;
    }
    public void deleteCliente(long id) throws EntityNotFoundException {
        Cliente cliente = clienteRepository.getReferenceById(id);
        clienteRepository.delete(cliente);
    }
    @Transactional
    public void updateCpf(String cpf) {
        clienteRepository.updateCpf(cpf);
    }

}
