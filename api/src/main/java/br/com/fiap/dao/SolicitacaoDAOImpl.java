package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Solicitacao;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.interfaces.ISolicitacaoDAO;

public class SolicitacaoDAOImpl implements ISolicitacaoDAO{
	
	private Connection connection;
	
	public SolicitacaoDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}
	
	public void inserir(Solicitacao solicitacao) throws SQLException{
		try {
			String sql = "INSERT INTO solicitacao_energia (endereco_solicitacao, cidade_solicitacao, estado_solicitacao, data_solicitacao, tipo_energia, descricao_solicitacao ,fk_cliente_solicitacao) VALUES(?, ?, ? ,? ,?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, solicitacao.getEndereco());
			statement.setString(2, solicitacao.getCidade());
			statement.setString(3, solicitacao.getEstado());
			statement.setDate(4, (Date) solicitacao.getData());
			statement.setString(5, solicitacao.getTipoEnergia());
			statement.setInt(6, solicitacao.getCliente().getId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Solicitacao> listar() throws SQLException {
		try {
			ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
			String sql = "SELECT * FROM solicitacao_energia";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_solicitacao");
				String endereco = resultSet.getString("endereco_solicitacao");
				String cidade = resultSet.getString("cidade_solicitacao");
				String estado = resultSet.getString("estado_solicitacao"); //acesso pelo label
				Date data = resultSet.getDate("data_solicitacao");
				String email = resultSet.getString("tipo_energia");
				String descricao = resultSet.getString("descricao_solicitacao");
				
				Solicitacao solicitacao = new Solicitacao(id, endereco, cidade, estado, data, email, descricao, null);
				solicitacoes.add(solicitacao);
			}
			return solicitacoes;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar solicitacoes");
		}
		return null;
	}
	
	public Solicitacao buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM solicitacao_energia WHERE id_solicitacao = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int idd = resultSet.getInt("id_solicitacao");
				String endereco = resultSet.getString("endereco_solicitacao");
				String cidade = resultSet.getString("cidade_solicitacao");
				String estado = resultSet.getString("estado_solicitacao"); //acesso pelo label
				Date data = resultSet.getDate("data_solicitacao");
				String email = resultSet.getString("tipo_energia");
				String descricao = resultSet.getString("descricao_solicitacao");
				
				Solicitacao solicitacao = new Solicitacao(idd, endereco, cidade, estado, data, email, descricao, null);
				
				return solicitacao;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizar(Solicitacao solicitacao) throws SQLException { 
		String sql = "UPDATE solicitacao_energia SET endereco_solicitacao = ?, cidade_solicitacao = ?, estado_solicitacao = ?, data_solicitacao = ?, tipo_energia = ?, descricao_solicitacao = ? WHERE id_solicitacao = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, solicitacao.getEndereco());
			ps.setString(2, solicitacao.getCidade());
			ps.setString(3, solicitacao.getEstado());
			ps.setDate(4, (Date) solicitacao.getData());
			ps.setString(5, solicitacao.getTipoEnergia());
			ps.setString(6, solicitacao.getDescricao());
			ps.setInt(7, solicitacao.getId());
			ps.execute();
			System.out.println("Executado!");
			
		} catch (SQLException e) {
			if(connection == null) {
				System.err.println("Conexão nula!");
			}else if(connection != null) {
				System.err.println("Erro na transação UPTDATE! " + e.getStackTrace());
			}
		}
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM solicitacao_energia WHERE id_solicitacao = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			if(connection == null) {
				System.err.println("Conexão nula!");
			}else if(connection != null) {
				System.err.println("Erro na transação DELETE! " + e.getStackTrace());
			}
		}
	}

}
