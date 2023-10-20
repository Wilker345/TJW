package br.edu.ifce.tjw.model.mapper.cliente;

import br.edu.ifce.tjw.model.Cliente;
import br.edu.ifce.tjw.model.dto.cliente.ClienteDTO;
import br.edu.ifce.tjw.model.mapper.GenericMapper;
import org.springframework.stereotype.Component;


@Component
public class ClienteMapper implements GenericMapper<Cliente, ClienteDTO> {

    @Override
    public Cliente toModel(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getDataCadastro(),
                clienteDTO.getDataNascimento(),
                clienteDTO.getIdade());

        cliente.setTelefones(clienteDTO.getTelefones());
        cliente.setPedidos(clienteDTO.getPedidos());
        cliente.setEnderecos(clienteDTO.getEnderecos());

        return cliente;
    }

    @Override
    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataCadastro(),
                cliente.getDataNascimento(),
                cliente.getIdade());

        clienteDTO.setId(cliente.getId());
        clienteDTO.setTelefones(cliente.getTelefones());
        clienteDTO.setPedidos(cliente.getPedidos());
        clienteDTO.setEnderecos(cliente.getEnderecos());

        return clienteDTO;
    }
}
