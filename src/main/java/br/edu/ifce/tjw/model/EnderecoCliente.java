package br.edu.ifce.tjw.model;

import jakarta.persistence.*;

@Entity
public class EnderecoCliente extends Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean ehEnderecoDeEntrega;
    @ManyToOne
    private Cliente cliente;
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EnderecoCliente() {

    }

    public EnderecoCliente(String logradouro, String numero, String complemento,
                           String cep, boolean ehEnderecoDeEntrega, Cliente cliente) {
        super(logradouro, numero, complemento, cep);
        this.ehEnderecoDeEntrega = ehEnderecoDeEntrega;
        this.cliente = cliente;
    }
}
