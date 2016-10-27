package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import model.Secretarias;

// Changelog
// Luis Andrade @ 26/10/2016 22:19 -- Método Selecionar adicionado; import list removido.

@Repository
public class SecretariasDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	
	public void criar(Secretarias secretarias) {
		manager.persist(secretarias);
	}
		
	//N�O SEI SE EST� REALMENTE CERTO
	public void existeSecretarias(Secretarias secretarias) {
		manager.merge(manager.find(Secretarias.class, secretarias.getId()));
	}
	
	public Secretarias selecionar(int idSecretaria){
		return manager.find(Secretarias.class, idSecretaria);
	}
}
