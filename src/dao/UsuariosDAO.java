package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import model.Usuarios;

@Repository
public class UsuariosDAO {

	@PersistenceContext
	EntityManager manager;

	public void criar(Usuarios usuarios) {
		manager.persist(usuarios);
	}

	//N�O SEI SE EST� CERTO
	public void existeUsuarios(Usuarios usuarios) {
		manager.merge(manager.find(Usuarios.class, usuarios.getId()));
	}

	public boolean validar(Usuarios usuarios) {
		// TODO Auto-generated method stub
		return false;
	}
}