package br.edu.ifce.tjw;

import br.edu.ifce.tjw.model.*;
import br.edu.ifce.tjw.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
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

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired PedidoItemRepository pedidoItemRepository;
	public static void main(String[] args) {
		SpringApplication.run(TJWApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date cadastro = new Date();
		Date nascimento = new Date(2002, Calendar.MAY, 27);
		Cliente cliente = new Cliente("Carlos", "123456789-12",
				cadastro, nascimento, 21);

		Endereco endereco = new Endereco("rua tal", "1234",
				"e tal", "23838139");

		clienteRepository.save(cliente);
		// itens
		Item lapis = new Item("lapis", 200);
		Item borracha = new Item("borracha", 250);
		List<Item> itens = List.of(lapis, borracha);
		itemRepository.saveAll(itens);

		// pedido
		Pedido pedido = new Pedido(cliente);
		pedidoRepository.save(pedido);

		PedidoItem pedidoLapis = new PedidoItem(pedido, lapis, 2);
		PedidoItem pedidoBorracha = new PedidoItem(pedido, borracha, 1);
		List<PedidoItem> itensDoPedido = List.of(pedidoLapis, pedidoBorracha);
		pedidoItemRepository.saveAll(itensDoPedido);

		pedido.setItens(itensDoPedido);
		pedidoRepository.save(pedido);

	}

}
