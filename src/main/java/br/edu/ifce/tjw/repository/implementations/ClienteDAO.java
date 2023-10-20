package br.edu.ifce.tjw.repository.implementations;

import br.edu.ifce.tjw.model.Cliente;
import br.edu.ifce.tjw.repository.interfaces.ClienteCRUD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ClienteDAO implements ClienteCRUD {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Cliente updateCpf(String cpf) {
        return null;
    }

    @Override
    public List<Cliente> getClientesYoungerThan(Date date) {
        return null;
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        return null;
    }
}
