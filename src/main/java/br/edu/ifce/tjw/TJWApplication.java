package br.edu.ifce.tjw;

import br.edu.ifce.tjw.model.*;
import br.edu.ifce.tjw.repository.*;
import br.edu.ifce.tjw.service.implementations.RelationalClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class TJWApplication implements CommandLineRunner {
	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Autowired private RelationalClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(TJWApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		EnderecoLoja enderecoLoja = new EnderecoLoja("Rua tal",
				"123", "e tal", "2912824");
		Loja loja = new Loja("Loja 1", enderecoLoja);
		lojaRepository.save(loja);

		Cliente cliente = createCliente();
		clienteService.postCliente(cliente);
		clienteService.updateCpf("11111111");

		Item lapis = new Item("lapis", new BigDecimal("2"));
		Item borracha = new Item("borracha", new BigDecimal("2.5"));
		List<Item> itens = List.of(lapis, borracha);
		itemRepository.saveAll(itens);

		Pedido pedido = new Pedido(cliente);
		pedidoRepository.save(pedido);

		PedidoItem pedidoLapis = new PedidoItem(pedido, lapis, 2);
		PedidoItem pedidoBorracha = new PedidoItem(pedido, borracha, 1);
		List<PedidoItem> itensDoPedido = List.of(pedidoLapis, pedidoBorracha);
		pedidoItemRepository.saveAll(itensDoPedido);

	}

	private static Cliente createCliente() {
		Calendar calendar = Calendar.getInstance();
		Date cadastro = calendar.getTime();
		calendar.set(2002, Calendar.MAY, 27);
		Date nascimento = calendar.getTime();

		Cliente cliente = new Cliente("Carlos", "123456789-12",
				cadastro, nascimento, 21);

		EnderecoCliente enderecoEntrega = new EnderecoCliente("Rua A", "452",
				"antes de BC", "379123", true, cliente);
		EnderecoCliente enderecoAlternativo = new EnderecoCliente("Rua BC", "462",
				"apos A", "379125", false, cliente);
		List<EnderecoCliente> enderecosCliente = List.of(enderecoEntrega, enderecoAlternativo);
		cliente.setEnderecos(enderecosCliente);

		return cliente;
	}

}
