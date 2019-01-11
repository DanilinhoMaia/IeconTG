package br.com.eicontg.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.eicontg.model.ListaPedidos;
import br.com.eicontg.model.Pedido;

/**
 * Servlet implementation class PedidoServlet
 */
public class PedidoServlet extends HttpServlet {
	       
    /**
	 * 
	 */
	private static final long serialVersionUID = 6152378397838872513L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String whatToDo = request.getParameter("whatToDo");
		if(whatToDo == "inclusao") {
		incluirPedido(request, response);
		}
		else if(whatToDo == "consulta") {
			consultarPedido(request, response);
		}
	}

	private void incluirPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonPedido = request.getParameter("jsonPedido");
		Gson gson = new Gson();
		ListaPedidos listaPedidos = gson.fromJson(jsonPedido, ListaPedidos.class);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><h1>Pedido incluido<h1><html>");
		out.close();
	}
	
	private ArrayList<Pedido> consultarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String consulta = request.getParameter("consulta");
		ArrayList<Pedido> pedidosRetorno = new ArrayList<Pedido>();
		PedidoController pedidoController = new PedidoController(); 
		
		if(consulta=="bynumeropedido") {		
			int numPedido = Integer.parseInt(request.getParameter("numeropedido"));
			pedidosRetorno.add(pedidoController.consultaPedidoByNumeroPedido(numPedido));
		}
		else if(consulta== "bydatacadastro") {
			String dataPedido = request.getParameter("datapedido");
			pedidosRetorno.add(pedidoController.consultaPedidoByDataCadastro(dataPedido));
		}
		else if (consulta == "todos") {
			pedidosRetorno = pedidoController.consultaPedidos();
		}
		
			return pedidosRetorno;	
		}
		

}
