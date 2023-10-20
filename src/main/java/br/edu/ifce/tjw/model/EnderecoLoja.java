package br.edu.ifce.tjw.model;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class EnderecoLoja extends Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "endereco")
    private Loja loja;

    public EnderecoLoja(String logradouro, String numero, String complemento, String cep) {
        super(logradouro, numero, complemento, cep);
    }

    public EnderecoLoja() {

    }
}
