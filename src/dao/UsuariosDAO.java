package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Usuarios;

@Repository
public class UsuariosDAO {
	private Connection conn;

	@Autowired
	public UsuariosDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public Usuarios usuarios(Usuarios usuarios) throws IOException {
		String sqlInsert = "insert into Usuarios (IdUsuario, Senha, Nome, Telefone, Celular, Endereco, Email, CPF, SecretUsuar, TipoUsuario) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sqlInsert);) {
			pst.setString(1, usuarios.getId());
			pst.setString(2, usuarios.getNome());
			pst.setString(3, usuarios.getSenha());
			pst.setString(4, usuarios.getTelefone());
			pst.setString(5, usuarios.getCelular());
			pst.setString(6, usuarios.getEndereco());
			pst.setInt(7, usuarios.getMatricula());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return usuarios;
	}

	public boolean existeUsuarios(Usuarios usuarios) {

		if (usuarios == null) {
			throw new IllegalArgumentException("Usuário nao deve ser nulo");
		}

		try {
			PreparedStatement stmt = this.conn
					.prepareStatement("select * from usuarios where IdUsuario = ? and Senha = ?");
			stmt.setString(1, usuarios.getId());
			stmt.setString(2, usuarios.getSenha());
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
