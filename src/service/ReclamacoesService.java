package service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReclamacoesDAO;
import model.Reclamacoes;
import model.Secretarias;

@Service
public class ReclamacoesService {
	private ReclamacoesDAO dao;
		
	@Autowired
	public ReclamacoesService(ReclamacoesDAO dao){
		this.dao = dao;
	}
	
	public void criar(Reclamacoes reclamacoes) throws IOException{
		dao.criar(reclamacoes);
	}
	
	public void remover(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException{
	dao.excluir(reclamacoes);
	}
	
	public List<Reclamacoes> listarReclamacoes() throws IOException{
		return dao.listarReclamacoes();
	}

	public Reclamacoes mostrar(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException{
		return dao.selecionar(reclamacoes, secretaria);
	}

}
