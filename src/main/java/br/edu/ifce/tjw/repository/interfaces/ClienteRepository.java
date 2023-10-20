package br.edu.ifce.tjw.repository.interfaces;

import br.edu.ifce.tjw.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("UPDATE Cliente c SET c.cpf = :cpf")
    @Modifying
    void updateCpf(String cpf);
    @Query("SELECT c FROM Cliente c WHERE c.dataNascimento > :date")
    List<Cliente> getClientesYoungerThan(Date date);
    @Query("SELECT c FROM Cliente c WHERE c.cpf =: cpf")
    Cliente getClienteByCpf(String cpf);
}
