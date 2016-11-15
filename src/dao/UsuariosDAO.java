package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import model.Usuarios;

@Repository
public class UsuariosDAO {

	@PersistenceContext
	EntityManager manager;

	public void criar(Usuarios usuarios){
		manager.persist(usuarios);
	}
	
	public void atualizar(Usuarios usuarios){
		manager.merge(manager.find(Usuarios.class, usuarios.getId()));
	}
	
	public void excluir(Usuarios usuarios){
		manager.remove(manager.find(Usuarios.class, usuarios.getId()));
	}
	
	public Usuarios selecionar(String id){
		return manager.find(Usuarios.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuarios> selecionarTodos(){
		return manager.createQuery("select * from usuarios").getResultList();
	}
	
	public boolean validar(Usuarios usuarios){
		Usuarios resultado = selecionar(usuarios.getId());
		return (resultado != null && resultado.getSenha().equals(usuarios.getSenha()));
	}
	
}
