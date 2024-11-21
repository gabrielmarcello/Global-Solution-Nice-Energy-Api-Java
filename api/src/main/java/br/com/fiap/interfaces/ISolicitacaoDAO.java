package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Solicitacao;

public interface ISolicitacaoDAO {
	
	public void inserir(Solicitacao solicitacao) throws SQLException;
	public ArrayList<Solicitacao> listar() throws SQLException;
	public Solicitacao buscarPorId(int id) throws SQLException;
	public void atualizar(Solicitacao solicitacao) throws SQLException;
	public void deletar(int id) throws SQLException;

}
