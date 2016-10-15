package service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuariosDAO;
import model.Usuarios;

@Service
public class UsuariosService {
	private UsuariosDAO dao;

	@Autowired
	public UsuariosService(UsuariosDAO dao) {
		this.dao = dao;
	}

	public Usuarios cadastrar(Usuarios usuarios) throws IOException {
		return dao.usuarios(usuarios);
	}

	public boolean validacao(Usuarios usuarios) throws IOException {
		return dao.existeUsuarios(usuarios);
		
	}

	public Usuarios listarUsuarios() throws IOException{
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuarios listarUsuarios(String u)  throws IOException{
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}