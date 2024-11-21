package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Estacao;
import br.com.fiap.dao.ClienteDAOImpl;
import br.com.fiap.dao.EstacaoDAOImpl;

public class EstacaoBO {

	EstacaoDAOImpl estacaoDAO = null;
	
	
	public void inserirBO(Estacao estacao) throws ClassNotFoundException, SQLException {
		
		EstacaoDAOImpl estacaoDAO = new EstacaoDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		estacaoDAO.inserir(estacao);
	}
	
	public void atualizarBO(Estacao estacao, int id) throws ClassNotFoundException, SQLException {
		
		EstacaoDAOImpl estacaoDAO = new EstacaoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		estacaoDAO.atualizar(estacao ,id);
		
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		
		EstacaoDAOImpl estacaoDAO = new EstacaoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		estacaoDAO.deletar(id);
	}
	
	public ArrayList<Estacao> listarBO() throws ClassNotFoundException, SQLException{
		
		EstacaoDAOImpl estacaoDAO = new EstacaoDAOImpl();
		return (ArrayList<Estacao>) estacaoDAO.listar();
		
	}
	
	public Estacao buscarPorIdBO(int id) throws ClassNotFoundException, SQLException{
		
		EstacaoDAOImpl estacaoDAO = new EstacaoDAOImpl();
		
		return estacaoDAO.buscarPorId(id);
	}
	
}
