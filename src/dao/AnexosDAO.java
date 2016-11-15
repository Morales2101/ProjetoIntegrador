package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import model.Anexos;

@Repository
public class AnexosDAO {

	@PersistenceContext
	EntityManager manager;

	public void criar(Anexos anexos) {
		manager.persist(anexos);
	}

	public void editar(Anexos anexos) {
		manager.merge(manager.find(Anexos.class, anexos.getId()));
	}

	public void excluir(Anexos anexos) {
		manager.remove(manager.find(Anexos.class, anexos.getId()));
	}

	public Anexos selecionar(int id) {
		return manager.find(Anexos.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Anexos> selecionarTodos() {
		return manager.createQuery("select * from anexos").getResultList();
	}
}
