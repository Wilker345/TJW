package br.edu.ifce.tjw;

import br.edu.ifce.tjw.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifce.tjw.repository.ClienteRepository;
import br.edu.ifce.tjw.repository.EnderecoRepository;
import br.edu.ifce.tjw.repository.LojaRepository;
import br.edu.ifce.tjw.repository.UsuarioRepository;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TJWApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TJWApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date cadastro = new Date("1695556372");
		Date nascimento = new Date("1022511172");
		Cliente cliente = new Cliente("Carlos", "123456789-12",
				cadastro, nascimento, 21);

		Endereco endereco = new Endereco("rua tal", "1234",
				"e tal", "23838139");
		//itens
		Item lapis = new Item("lapis", 200);
		Item borracha = new Item("borracha", 250);

		//pedido
		Pedido pedido = new Pedido(cliente);
		PedidoItem pedidoLapis = new PedidoItem(pedido, lapis, 2);
		PedidoItem pedidoBorracha = new PedidoItem(pedido, borracha, 1);
		List<PedidoItem> itens = List.of(pedidoLapis, pedidoBorracha);
		pedido.setItens(itens);
	}

}
