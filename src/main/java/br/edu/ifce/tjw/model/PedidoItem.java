package br.edu.ifce.tjw.model;

import jakarta.persistence.*;


@Entity
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne()
    @JoinColumn(name = "item_id")
    private Item item;
    private int quantidade;

    public PedidoItem() {
    }

    public PedidoItem(Pedido pedido, Item item, int quantidade) {
        this.pedido = pedido;
        this.item = item;
        this.quantidade = quantidade;
    }
}