package service;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SecretariasDAO;
import model.Secretarias;

@Service
public class SecretariasService {
private SecretariasDAO dao;

	@Autowired
	public SecretariasService(SecretariasDAO dao){
		this.dao = dao;
	}

	public Secretarias criar(Secretarias secretaria) throws IOException{
		return dao.criar(secretaria);
	}

}
