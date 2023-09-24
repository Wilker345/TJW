package br.edu.ifce.tjw.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class PedidoItem {
    @EmbeddedId
    private PedidoItemPK id;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @MapsId("pedidoId")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "item_id")
    @MapsId("itemId")
    private Item item;
    private int quantidade;

    public PedidoItem(Pedido pedido, Item item, int quantidade) {
        this.pedido = pedido;
        this.item = item;
        this.quantidade = quantidade;
    }
}

@Embeddable
class PedidoItemPK implements Serializable {
    @Column(name = "pedido_id")
    long pedidoId;
    @Column(name = "item_id")
    long itemId;
}