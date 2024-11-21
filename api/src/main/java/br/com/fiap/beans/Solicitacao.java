package br.com.fiap.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Solicitacao {
	
	private int id;
	private String endereco;
	private String cidade;
	private String estado;
	private Date data;
	private String tipoEnergia;
	private String descricao;
	private Cliente cliente;
	
	public Solicitacao(int id, String endereco, String cidade, String estado, Date data, String tipoEnergia, String descricao, Cliente cliente) {
		this.id = id;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.data = data;
		this.tipoEnergia = tipoEnergia;
		this.descricao = descricao;
		this.cliente = cliente;
	}
	
	public Solicitacao(String endereco, String cidade, String estado, Date data, String tipoEnergia, String descricao, Cliente cliente) {
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.data = data;
		this.tipoEnergia = tipoEnergia;
		this.descricao = descricao;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipoEnergia() {
		return tipoEnergia;
	}

	public void setTipoEnergia(String tipoEnergia) {
		this.tipoEnergia = tipoEnergia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado
				+ ", data=" + data + ", tipoEnergia=" + tipoEnergia + ", descricao=" + descricao + ", cliente="
				+ cliente + "]";
	}

}
