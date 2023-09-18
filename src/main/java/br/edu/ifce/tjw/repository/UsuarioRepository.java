package br.edu.ifce.tjw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifce.tjw.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
