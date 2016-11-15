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
	
	public void remover(Reclamacoes reclamacoes) throws IOException{
		dao.excluir(reclamacoes);
	}
	
	public void selecionar(Reclamacoes reclamacoes){
		dao.selecionar(reclamacoes);
	}
	
	public List<Reclamacoes> listarReclamacoes() throws IOException{
		return dao.listarReclamacoes();
	}

	public void atualizar(Reclamacoes reclamacoes) {
		// TODO Auto-generated method stub
		
	}

}
