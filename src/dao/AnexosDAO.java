package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Anexos;


//ARRUMAR, POIS ESTÁ DIFERENTE DO BANCO DE DADOS
@Repository
public class AnexosDAO {
	private Connection conn;
	
	@Autowired
	public AnexosDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}
	
	public Anexos criar(Anexos anexos) throws IOException {
		String sqlInsert = "insert into Anexos (Id, IdReclam, IdPai, IdCidadao, Tipo, Anexo, Comentario, Aprovado) "
				+ "values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sqlInsert);) {
			pst.setInt(1, anexos.getId());
			pst.setInt(2, anexos.getIdReclam());
			pst.setString(3, anexos.getIdCidadao());
			pst.setString(4, anexos.getAnexo());
			pst.setString(5, anexos.getComentario());
			pst.setString(6, anexos.getTipo());
			pst.execute();
			String query = "select last_insert_id()";
			try (PreparedStatement pst2 = conn.prepareStatement(query); ResultSet rs = pst2.executeQuery();) {
				if (rs.next()) {
					anexos.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return anexos;
	}

	public void atualizar(Anexos anexos) throws IOException {
		String sqlUpdate = "update Anexos set Id=?, IdReclam=?, IdPai=?, IdCidadao=?, Tipo=?, Anexo=?, Comentario=?, Aprovado=?";
		try (PreparedStatement pst = conn.prepareStatement(sqlUpdate);) {
			pst.setInt(1, anexos.getId());
			pst.setInt(2, anexos.getIdReclam());
			pst.setString(3, anexos.getIdCidadao());
			pst.setString(4, anexos.getAnexo());
			pst.setString(5, anexos.getComentario());
			pst.setString(6, anexos.getTipo());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	public void excluir(Anexos anexos) throws IOException {
		String sqlDelete = "delete from Anexos where Id=?";
		try (PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			pst.setInt(1, anexos.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
}
