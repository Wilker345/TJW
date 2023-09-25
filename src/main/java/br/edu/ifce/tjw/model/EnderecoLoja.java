package br.edu.ifce.tjw.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class EnderecoLoja extends Endereco {
    @OneToOne(mappedBy = "endereco")
    private Loja loja;

    public EnderecoLoja(String logradouro, String numero, String complemento, String cep) {
        super(logradouro, numero, complemento, cep);
    }

    public EnderecoLoja() {

    }
}
