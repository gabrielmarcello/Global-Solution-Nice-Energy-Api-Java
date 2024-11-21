package br.com.fiap.beans;

public class Estacao {
	
	private int id;
	private String nome;
	private String endereco;
	private String bairro;
	private int cep;
	private String cidade;
	private String estado;
	private int contato;
	private String tipo;
	private String horarioFuncionamento;
	private int totalCarregadores;
	
	public Estacao(int id, String nome, String endereco, String bairro, int cep, String cidade, String estado, int contato, String tipo, String horarioFuncionamento, int totalCarregadores) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.contato = contato;
		this.tipo = tipo;
		this.horarioFuncionamento = horarioFuncionamento;
		this.totalCarregadores = totalCarregadores;
	}
	
	public Estacao(String nome, String endereco, String bairro, int cep, String cidade, String estado, int contato, String tipo, String horarioFuncionamento, int totalCarregadores) {
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.contato = contato;
		this.tipo = tipo;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
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

	public int getContato() {
		return contato;
	}

	public void setContato(int contato) {
		this.contato = contato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public int getTotalCarregadores() {
		return totalCarregadores;
	}

	public void setTotalCarregadores(int totalCarregadores) {
		this.totalCarregadores = totalCarregadores;
	}

	@Override
	public String toString() {
		return "Estacao [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cep=" + cep
				+ ", cidade=" + cidade + ", estado=" + estado + ", contato=" + contato + ", tipo=" + tipo
				+ ", horarioFuncionamento=" + horarioFuncionamento + ", totalCarregadores=" + totalCarregadores + "]";
	}
	
	

}
