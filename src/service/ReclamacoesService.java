package service;

import java.io.IOException;
import java.util.ArrayList;

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
	
	public Reclamacoes criar(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException{
		return dao.criar(reclamacoes, secretaria);
	}
	
	public void remover(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException{
	dao.excluir(reclamacoes);
	}
	
	public ArrayList<Reclamacoes> listarReclamacoes() throws IOException{
		return dao.listarReclamacoes();
	}
	public ArrayList<Reclamacoes> listarReclamacoes(String chave) throws IOException{
		return dao.listarReclamacoes(chave);
	}

	public Reclamacoes mostrar(Reclamacoes reclamacoes, Secretarias secretaria) throws IOException{
		return dao.selecionar(reclamacoes, secretaria);
	}

}
