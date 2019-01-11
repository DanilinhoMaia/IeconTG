package br.com.eicontg.controler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.ValidationException;

import br.com.eicontg.model.ListaPedidos;
import br.com.eicontg.model.Pedido;

public class PedidoController {
	EntityManagerFactory emf;
	EntityManager em;

	public PedidoController() {
		emf = Persistence.createEntityManagerFactory("pedido");
		em = emf.createEntityManager();
		emf.close();
	}

	public void incluirPedidos(ListaPedidos listaPedidos) {

		valida(listaPedidos);

		em.getTransaction().begin();
		for (int i = 0; i < listaPedidos.getPedidos().size(); i++) {
			em.merge(listaPedidos.getPedidos().get(i));
		}
		em.getTransaction().commit();
		emf.close();
	}

	private void valida(ListaPedidos listaPedidos) {
		ArrayList<Pedido> pedidosSalvos = this.consultaPedidos();

		if (listaPedidos.getPedidos().size() > 10) {
			throw new OutOfMemoryError();
		} else {
			for (int i = 0; i < listaPedidos.getPedidos().size(); i++) {
				Pedido p = listaPedidos.getPedidos().get(i);
				if(p.getDataCadastro() == null) {
					listaPedidos.getPedidos().get(i).setDataCadastro(Calendar.getInstance().toString());
				}
				if(p.getQuantidadeProduto() == 0) {
					listaPedidos.getPedidos().get(i).setQuantidadeProduto(1);;
					
				}
				if(5 < p.getQuantidadeProduto() && p.getQuantidadeProduto() <10 ) {
					float valorProduto = (float) (listaPedidos.getPedidos().get(i).getValorProduto() * 0.95);
					listaPedidos.getPedidos().get(i).setValorProduto(valorProduto);
				} else if (p.getQuantidadeProduto() >= 10 ) {
					float valorProduto = (float) (listaPedidos.getPedidos().get(i).getValorProduto() * 0.90);
					listaPedidos.getPedidos().get(i).setValorProduto(valorProduto);
				}
				
				for (int j = 0; j < pedidosSalvos.size(); j++) {
					if (p.getNumControle() == pedidosSalvos.get(j).getNumControle()) {
						throw new OutOfMemoryError();
					}
				}
			}
		}
	}

	public ArrayList<Pedido> consultaPedidos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("SELECT * FROM pedido");
		ArrayList<Pedido> pedidos = (ArrayList<Pedido>) consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return pedidos;
	}
	
	public Pedido consultaPedidoByNumeroPedido(int numPedido){
		ArrayList<Pedido> pedidos = consultaPedidos();
		for (int i = 0; i < pedidos.size(); i++) {
			if(pedidos.get(i).getNumControle() == numPedido) {
				return pedidos.get(i); 
			}
		}
		return null;
	}
	
	public Pedido consultaPedidoByDataCadastro(String dataCadastro){
		ArrayList<Pedido> pedidos = consultaPedidos();
		for (int i = 0; i < pedidos.size(); i++) {
			if(pedidos.get(i).getDataCadastro() == dataCadastro) {
				return pedidos.get(i); 
			}
		}
		return null;
	}
	

}
