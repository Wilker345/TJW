package br.edu.ifce.tjw.repository.interfaces;

import br.edu.ifce.tjw.model.Cliente;
import java.util.Date;
import java.util.List;


public interface ClienteCRUD {

    Cliente updateCpf(String cpf);
    List<Cliente> getClientesYoungerThan(Date date);
    Cliente getClienteByCpf(String cpf);
}
