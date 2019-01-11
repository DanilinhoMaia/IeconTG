package br.com.eicontg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.eicontg.controler.PedidoController;
import br.com.eicontg.model.ListaPedidos;
import br.com.eicontg.model.Pedido;

public class PedidoControllerTest {
	
	private PedidoController pController = new PedidoController();
	
	@Before
	public void PedidoControllerTest(){
		
	}
	
	@Test
	public void testIncluirPedidos() {
		ListaPedidos pedidos = new ListaPedidos(); 	
		pedidos.getPedidos().add(new Pedido());
		pController.incluirPedidos(pedidos);
		
		ArrayList<Pedido> pedidosConsulta = pController.consultaPedidos();
		assertEquals(true, pedidosConsulta.size()>0);
	}

	@Test
	public void testConsultaPedidos() {
		ArrayList<Pedido> pedidos = pController.consultaPedidos();
		assertEquals(true, pedidos.size()>0);
	}

	@Test
	public void testConsultaPedidoByNumeroPedido() {
		//implementar
	}

	@Test
	public void testConsultaPedidoByDataCadastro() {
		//implementar
	}

}
