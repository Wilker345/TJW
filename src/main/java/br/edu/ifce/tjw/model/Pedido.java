package br.edu.ifce.tjw.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    @JoinTable(
            name="pedido_item",
            joinColumns = @JoinColumn(name="pedido_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    )
    private List<Item> itens;

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
