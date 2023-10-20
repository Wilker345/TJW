package br.edu.ifce.tjw.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

/**
 * @author cjunior
 *
 */
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Transient
	private int idade;
	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference
	private List<Telefone> telefones;

	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference
	private List<Pedido> pedidos;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EnderecoCliente> enderecos;

	public Cliente(String nome, String cpf, Date dataCadastro, Date dataNascimento, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataCadastro = dataCadastro;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<EnderecoCliente> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoCliente> enderecos) {
		this.enderecos = enderecos;
	}
}
