package br.edu.ifce.tjw.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    // em centavos
    private int valor;
    @OneToMany(mappedBy = "item")
    private List<PedidoItem> pedidos;

    public Item(String nome, int valor) {
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<PedidoItem> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoItem> pedidos) {
        this.pedidos = pedidos;
    }
}
