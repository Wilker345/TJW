package br.edu.ifce.tjw.repository.interfaces;

import br.edu.ifce.tjw.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
