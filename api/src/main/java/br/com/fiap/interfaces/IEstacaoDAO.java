package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Estacao;

public interface IEstacaoDAO {

	public void inserir(Estacao estacao) throws SQLException;
	public ArrayList<Estacao> listar() throws SQLException;
	public Estacao buscarPorId(int cpf) throws SQLException;
	public void atualizar(Estacao estacao, int id) throws SQLException;
	public void deletar(int id) throws SQLException;
	
}
