package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import model.Secretarias;


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
}
