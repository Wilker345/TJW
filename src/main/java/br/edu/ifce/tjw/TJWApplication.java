package br.edu.ifce.tjw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifce.tjw.model.Cliente;
import br.edu.ifce.tjw.model.Endereco;
import br.edu.ifce.tjw.repository.ClienteRepository;
import br.edu.ifce.tjw.repository.EnderecoRepository;
import br.edu.ifce.tjw.repository.LojaRepository;
import br.edu.ifce.tjw.repository.UsuarioRepository;

@SpringBootApplication
public class TJWApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository u;
	
	@Autowired
	private ClienteRepository cl;
	
	@Autowired
	private LojaRepository loja;
	
	@Autowired
	private EnderecoRepository end;
	
	public static void main(String[] args) {
		SpringApplication.run(TJWApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	Cliente c = new Cliente();
	Endereco e = new Endereco();

	
		
		

		
		
	}

}
