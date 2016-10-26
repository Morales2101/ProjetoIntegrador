package controller;

import model.Usuarios;

import model.*;
import org.junit.*;

/**
 * @author Luis
 *
 */
public class MapeamentoControllerTest {

	Usuarios cidadao, avaliador, superior;
	Secretarias secretaria;
	Reclamacoes reclamacao;
	Anexos anexo, comentario1, comentario2;
	
	@Before
	public void inicializaValores(){
		secretaria = new Secretarias(1,"Secretaria Teste",true);
		
		cidadao = new Usuarios("cidadao","cidadao","Fulano de Tal","011 2456-7890","011 9 8923-4567","Rua dos Bobos, 0",123456,"fulano@provedor.com",1234567890,"Cidadao",0);
		avaliador = new Usuarios("avaliador","avaliador","Avaliador da Secretaria","011 2456-7890","011 9 8923-4567","Rua dos Bobos, 0",123457,"avaliador@prefeitura.gov.br",1234567891,"Avaliador",1);
		superior = new Usuarios("superior","superior","Superior da Secretaria","011 2456-7890","011 9 8923-4567","Rua dos Bobos, 0",123458,"avaliador@prefeitura.gov.br",1234567892,"Superior",1);
		
		reclamacao = new Reclamacoes(1,"Reclamação Teste","25/10/2016 22:43","cidadao","Lorem ipsum dolor sit amet",-40.2456, -24.2345, 1, "avaliador","",false);
		
		anexo = new Anexos(1,1,"cidadao","Teste","","Anexo");
		comentario1 = new Anexos(2,1,"cidadao","","Lorem ipsum 1","Comentario");
		comentario2 = new Anexos(3,1,"cidadao","","Dolor sit amet 2","Comentario");
	}
	
	/* @Test
	public void testaInclusao(){
		assertEquals();
	} */
	
}
