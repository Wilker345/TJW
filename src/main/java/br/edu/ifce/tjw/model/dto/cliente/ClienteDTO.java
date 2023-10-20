package br.edu.ifce.tjw.model.dto.cliente;

import br.edu.ifce.tjw.model.EnderecoCliente;
import br.edu.ifce.tjw.model.Pedido;
import br.edu.ifce.tjw.model.Telefone;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataCadastro;
    private Date dataNascimento;
    private int idade;
    @JsonManagedReference
    private List<Telefone> telefones;
    @JsonManagedReference
    private List<Pedido> pedidos;
    @JsonManagedReference
    private List<EnderecoCliente> enderecos;

    public ClienteDTO(String nome, String cpf, Date dataCadastro, Date dataNascimento, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<EnderecoCliente> getEnderecos() {
        return enderecos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setEnderecos(List<EnderecoCliente> enderecos) {
        this.enderecos = enderecos;
    }
}
