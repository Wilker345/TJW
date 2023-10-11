package br.edu.ifce.tjw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifce.tjw.model.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente,Long>{
    @Modifying
    @Query("UPDATE Cliente c SET c.cpf = :cpf")
    void updateCpf(String cpf);
    @Query("SELECT c from Cliente c WHERE c.dataNascimento > :date")
    List<Cliente> getClientesYoungerThan(Date date);
    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Cliente getClienteByCpf(String cpf);
}
