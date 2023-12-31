package br.edu.ifce.tjw.repository.interfaces;

import br.edu.ifce.tjw.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
