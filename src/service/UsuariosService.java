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

	public boolean validar(Usuarios usuarios) throws IOException{
		return dao.validar(usuarios);
	}

	public Object listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object listarUsuarios(String chave) {
		// TODO Auto-generated method stub
		return null;
	}
	
}