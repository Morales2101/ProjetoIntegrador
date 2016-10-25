package service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AnexosDAO;
import model.Anexos;

@Service
public class AnexosService {
	private AnexosDAO dao;
	
	@Autowired
	public AnexosService(AnexosDAO dao){
		this.dao = dao;
	}
	
	public void criar(Anexos anexos) throws IOException{
		dao.criar(anexos);
	} 
	
	public void atualizar(Anexos anexos) throws IOException{
		dao.atualizar(anexos);
	}
	
	public void excluir(Anexos anexos) throws IOException{
		dao.excluir(anexos);
	}
	
}
