package service;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SecretariasDAO;
import model.Secretarias;

@Service
public class SecretariasService {
private SecretariasDAO dao;

//Changelog
//Luis Andrade @ 26/10/2016 22:19 -- Método Selecionar adicionado

	@Autowired
	public SecretariasService(SecretariasDAO dao){
		this.dao = dao;
	}

	public void criar(Secretarias secretarias) throws IOException{
		dao.criar(secretarias);
	}
	
	public Secretarias selecionar(int idSecretaria) throws IOException {
		dao.selecionar(idSecretaria);
	}

}
