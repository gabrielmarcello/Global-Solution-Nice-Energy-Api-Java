package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Estacao;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.interfaces.IEstacaoDAO;

public class EstacaoDAOImpl implements IEstacaoDAO {
	
	private Connection connection;
	
	public EstacaoDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}
	
	public void inserir(Estacao estacao) throws SQLException {
		try {
			String sql = "INSERT INTO estacao_carregamento (nome_estacao, endereco_estacao, bairro_estacao, cep_estacao, cidade_estacao, estado_estacao, contato_estacao, tipo_estacao, horario_funcionamento_estacao, total_carregadores_estacao) VALUES(?, ?, ? ,? ,?, ?, ? ,? ,?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, estacao.getNome());
			statement.setString(2, estacao.getEndereco());
			statement.setString(3, estacao.getBairro());
			statement.setInt(4, estacao.getCep());
			statement.setString(5, estacao.getCidade());
			statement.setString(6, estacao.getEstado());
			statement.setInt(7, estacao.getContato());
			statement.setString(8, estacao.getTipo());
			statement.setString(9, estacao.getHorarioFuncionamento());
			statement.setInt(10, estacao.getTotalCarregadores());
			statement.execute();
			System.out.println("Estacao inserida");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Estacao> listar() throws SQLException {
		try {
			ArrayList<Estacao> estacoes = new ArrayList<Estacao>();
			String sql = "SELECT * FROM estacao_carregamento";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_estacao");
				String nome = resultSet.getString("nome_estacao");
				String endereco = resultSet.getString("endereco_estacao");
				String bairro = resultSet.getString("bairro_estacao");
				int cep_estacao = resultSet.getInt("cep_estacao");
				String cidade = resultSet.getString("cidade_estacao");
				String estado = resultSet.getString("estado_estacao");
				int contato = resultSet.getInt("contato_estacao");
				String tipo = resultSet.getString("tipo_estacao");
				String horarioFuncionamento = resultSet.getString("horario_funcionamento_estacao");
				int totalCarregadores = resultSet.getInt("total_carregadores_estacao");
				
				Estacao estacao = new Estacao(id, nome, endereco, bairro, cep_estacao, cidade, estado, contato, tipo, horarioFuncionamento, totalCarregadores);
				estacoes.add(estacao);
			}
			return estacoes;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar estacoes");
		}
		return null;
	}
	
	public Estacao buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM estacao_carregamento WHERE id_estacao = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Executado");
			
			while(resultSet.next()) {
				int idd = resultSet.getInt("id_estacao");
				String nome = resultSet.getString("nome_estacao");
				String endereco = resultSet.getString("endereco_estacao");
				String bairro = resultSet.getString("bairro_estacao");
				int cep_estacao = resultSet.getInt("cep_estacao");
				String cidade = resultSet.getString("cidade_estacao");
				String estado = resultSet.getString("estado_estacao");
				int contato = resultSet.getInt("contato_estacao");
				String tipo = resultSet.getString("tipo_estacao");
				String horarioFuncionamento = resultSet.getString("horario_funcionamento_estacao");
				int totalCarregadores = resultSet.getInt("total_carregadores_estacao");
				
				Estacao estacao = new Estacao(idd, nome, endereco, bairro, cep_estacao, cidade, estado, contato, tipo, horarioFuncionamento, totalCarregadores);
				
				return estacao;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar estação");
		}
		return null;
	}
	
	public void atualizar(Estacao estacao, int id) throws SQLException { 
		String sql = "UPDATE estacao_carregamento SET nome_estacao = ?, endereco_estacao = ?, bairro_estacao = ?, cep_estacao = ?, cidade_estacao = ?, estado_estacao = ?, contato_estacao = ?, tipo_estacao = ?, horario_funcionamento_estacao = ?, total_carregadores_estacao = ? WHERE id_estacao = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, estacao.getNome());
			ps.setString(2, estacao.getEndereco());
			ps.setString(3, estacao.getBairro());
			ps.setInt(4, estacao.getCep());
			ps.setString(5, estacao.getCidade());
			ps.setString(6, estacao.getEstado());
			ps.setInt(7, estacao.getContato());
			ps.setString(8, estacao.getTipo());
			ps.setString(9, estacao.getHorarioFuncionamento());
			ps.setInt(10, estacao.getTotalCarregadores());
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
		String sql = "DELETE FROM estacao_carregamento WHERE id_estacao = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Executado!");
		} catch (Exception e) {
			if(connection == null) {
				System.err.println("Conexão nula!");
			}else if(connection != null) {
				System.err.println("Erro na transação DELETE! " + e.getStackTrace());
			}
		}
	}

}
