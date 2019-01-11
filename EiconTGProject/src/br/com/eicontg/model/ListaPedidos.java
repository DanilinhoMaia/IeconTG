package br.com.eicontg.model;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos {

	private ArrayList<Pedido> pedidos;
	
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return this.pedidos;
	}
}
