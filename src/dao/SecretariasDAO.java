package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Secretarias;


@Repository
public class SecretariasDAO {
	private Connection conn;

	@Autowired
	public SecretariasDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public Secretarias criar(Secretarias secretarias) throws IOException {
		String sqlInsert = "insert into Secretarias (IdSecret, Ativa, NomeSecret) " + "values(?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sqlInsert);) {
			pst.setInt(1, secretarias.getId());
			pst.setBoolean(2, secretarias.getAtiva());
			pst.setString(3, secretarias.getNome());


			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return secretarias;
	}

	public boolean existeSecretarias(Secretarias secretarias) {

		if (secretarias == null) {
			throw new IllegalArgumentException("Secretaria nao deve ser nulo");
		}

		try {
			PreparedStatement stmt = this.conn
					.prepareStatement("select * from Secretarias where IdSecret = ? and NomeSecret = ?");
			stmt.setInt(1, secretarias.getId());
			stmt.setString(2, secretarias.getNome());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
