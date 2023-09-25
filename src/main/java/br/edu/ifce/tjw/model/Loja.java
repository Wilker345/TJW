package br.edu.ifce.tjw.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String unidade;
	@OneToOne(cascade = CascadeType.ALL)
	private EnderecoLoja endereco;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoLoja endereco) {
		this.endereco = endereco;
	}

	public Loja() {
	}
	public Loja(String unidade, EnderecoLoja endereco) {
		this.unidade = unidade;
		this.endereco = endereco;
	}
}
