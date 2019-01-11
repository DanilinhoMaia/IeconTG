package br.com.eicontg.model;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.xml.ws.RequestWrapper;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int numControle;
	private String dataCadastro;
	private String nomeProduto;
	private float valorProduto;
	private int quantidadeProduto;
	private int codigoCliente;

	public int getId() {
	return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String toString() {
		return "ok!";
	}
	
	public int getNumControle() {
		return numControle;
	}

	public void setNumControle(int numControle) {
		this.numControle = numControle;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
