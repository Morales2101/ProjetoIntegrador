package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import model.Reclamacoes;

@Repository
public class ReclamacoesDAO {

	@PersistenceContext
	EntityManager manager;

	public void criar(Reclamacoes reclamacoes) {
		manager.persist(reclamacoes);
	}

	public void excluir(Reclamacoes reclamacoes) {
		manager.remove(manager.find(Reclamacoes.class, reclamacoes.getId()));
	}

	public Reclamacoes selecionar(int id) {
		return manager.find(Reclamacoes.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Reclamacoes> listarReclamacoes() {
		return manager.createQuery("select * from reclamacoes").getResultList();
	}

}
