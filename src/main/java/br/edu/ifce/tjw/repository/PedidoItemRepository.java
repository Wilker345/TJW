package br.edu.ifce.tjw.repository;

import br.edu.ifce.tjw.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
