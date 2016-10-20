package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import model.Reclamacoes;
import model.Secretarias;

@Repository
public class ReclamacoesDAO {
	private Connection conn;

	@Autowired
	public ReclamacoesDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public Reclamacoes criar(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException {
		String sqlInsert = "insert into Reclamacoes (Id, Titulo, DataHora, IdCidadao, Descricao, Latitude, Longitude, Secretaria, IdAvaliador, Resposta, Aprovado) values(?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sqlInsert);){
			pst.setInt(1, reclamacoes.getId());
			pst.setString(2, reclamacoes.getTitulo());
			pst.setString(3, reclamacoes.getDataHora());
			pst.setString(4, reclamacoes.getIdCidadao());
			pst.setString(5, reclamacoes.getDescricao());
			pst.setDouble(6, reclamacoes.getLatitude());
			pst.setDouble(7, reclamacoes.getLongitude());
			pst.setInt(8, secretaria.getId());
			pst.setInt(9, reclamacoes.getIdAvaliador());
			pst.setString(10, reclamacoes.getResposta());
			pst.setBoolean(11, reclamacoes.isAprovado());
			String query = "select last_insert_id()";
			try (PreparedStatement pst2 = conn.prepareStatement(query); ResultSet rs = pst2.executeQuery();) {
				if (rs.next()) {
					reclamacoes.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return reclamacoes;
	}
	
	public void excluir(Reclamacoes reclamacoes) throws IOException {
		String sqlDelete = "delete from Reclamacoes where IdReclam=?";
		try (PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			pst.setInt(1, reclamacoes.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	public Reclamacoes selecionar(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException {
		String query = "Id, Titulo, DataHora, IdCidadao, Descricao, Latitude, Longitude, Secretaria, IdAvaliador, Resposta, Aprovado";
		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setInt(1, reclamacoes.getId());
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					reclamacoes.setTitulo(rs.getString("Titulo"));
					reclamacoes.setDataHora(rs.getString("DataHora"));
					reclamacoes.setIdCidadao(rs.getString("IdCidadao"));
					reclamacoes.setDescricao(rs.getString("Descricao"));
					reclamacoes.setLatitude(rs.getDouble("Latitude"));
					reclamacoes.setLongitude(rs.getDouble("Longitude"));
					secretaria.setId(rs.getInt("Secretaria"));
					reclamacoes.setIdAvaliador(rs.getInt("IdAvaliador"));
					reclamacoes.setResposta(rs.getString("Resposta"));
					reclamacoes.setAprovado(rs.getBoolean("Aprovado"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return reclamacoes;
	}
	
	public ArrayList<Reclamacoes> listarReclamacoes() throws IOException {
		String query = "Id, Titulo, DataHora, IdCidadao, Descricao, Latitude, Longitude, Secretaria, IdAvaliador, Resposta, Aprovado";
		ArrayList<Reclamacoes> lista = new ArrayList<>();
		try (PreparedStatement pst = conn.prepareStatement(query); ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				Reclamacoes reclamacoes = new Reclamacoes();
				Secretarias secretaria = new Secretarias();
				reclamacoes.setId(rs.getInt("Id"));
				reclamacoes.setTitulo(rs.getString("Titulo"));
				reclamacoes.setDataHora(rs.getString("DataHora"));
				reclamacoes.setIdCidadao(rs.getString("IdCidadao"));
				reclamacoes.setDescricao(rs.getString("Descricao"));
				reclamacoes.setLatitude(rs.getDouble("Latitude"));
				reclamacoes.setLongitude(rs.getDouble("Longitude"));
				secretaria.setId(rs.getInt("Secretaria"));
				reclamacoes.setIdAvaliador(rs.getInt("IdAvaliador"));
				reclamacoes.setResposta(rs.getString("Resposta"));
				reclamacoes.setAprovado(rs.getBoolean("Aprovado"));
				lista.add(reclamacoes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

	public ArrayList<Reclamacoes> listarReclamacoes(String chave) throws IOException {
		String query = "Id, Titulo, DataHora, IdCidadao, Descricao, Latitude, Longitude, Secretaria, IdAvaliador, Resposta, Aprovado";	
		ArrayList<Reclamacoes> lista = new ArrayList<>();
		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, "%" + chave + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Reclamacoes reclamacoes = new Reclamacoes();
					Secretarias secretaria = new Secretarias();
					reclamacoes.setTitulo(rs.getString("Titulo"));
					reclamacoes.setDataHora(rs.getString("DataHora"));
					reclamacoes.setIdCidadao(rs.getString("IdCidadao"));
					reclamacoes.setDescricao(rs.getString("Descricao"));
					reclamacoes.setLatitude(rs.getDouble("Latitude"));
					reclamacoes.setLongitude(rs.getDouble("Longitude"));
					secretaria.setId(rs.getInt("Secretaria"));
					reclamacoes.setIdAvaliador(rs.getInt("IdAvaliador"));
					reclamacoes.setResposta(rs.getString("Resposta"));
					reclamacoes.setAprovado(rs.getBoolean("Aprovado"));
					lista.add(reclamacoes);
					lista.add(reclamacoes);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}

	
	
	
}


