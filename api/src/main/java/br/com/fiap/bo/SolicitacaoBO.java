package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Solicitacao;
import br.com.fiap.dao.SolicitacaoDAOImpl;

public class SolicitacaoBO {
	
	SolicitacaoDAOImpl solicitacaoDAO = null;
	
	public void inserirBO(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {
		SolicitacaoDAOImpl solicitacaoDAO = new SolicitacaoDAOImpl();
		
		solicitacaoDAO.inserir(solicitacao);
	}
	
	public void atualizarBO(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
		SolicitacaoDAOImpl solicitacaoDAO = new SolicitacaoDAOImpl();
		
		solicitacaoDAO.atualizar(solicitacao);
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		SolicitacaoDAOImpl solicitacaoDAO = new SolicitacaoDAOImpl();
		
		solicitacaoDAO.deletar(id);
	}
	
	public ArrayList<Solicitacao> listarBO() throws ClassNotFoundException, SQLException{
		
		SolicitacaoDAOImpl solicitacaoDAO = new SolicitacaoDAOImpl();
		return(ArrayList<Solicitacao>) solicitacaoDAO.listar();
	}
	
	public Solicitacao buscarPorId(int id) throws ClassNotFoundException, SQLException {
		SolicitacaoDAOImpl solicitacaoDAO = new SolicitacaoDAOImpl();
		
		return solicitacaoDAO.buscarPorId(id);
	}
}
