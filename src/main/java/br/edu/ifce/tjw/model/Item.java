package br.edu.ifce.tjw.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    // em centavos
    private BigDecimal valor;
    @OneToMany(mappedBy = "item")
    private List<PedidoItem> pedidos;

    public Item(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<PedidoItem> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoItem> pedidos) {
        this.pedidos = pedidos;
    }
}
