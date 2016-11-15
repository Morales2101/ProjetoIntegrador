package controller;

import model.*;
import dao.*;
import service.*;

import org.junit.*;

/**
 * @author Luis
 *
 */
public class MapeamentoControllerTest {
	
	UsuariosDAO usuarioDAO;
	SecretariasDAO secretariaDAO;
	ReclamacoesDAO reclamacaoDAO;
	AnexosDAO anexoDAO;
	
	UsuariosService usuarioService;
	SecretariasService secretariaService;
	ReclamacoesService reclamacaoService;
	AnexosService anexoService;
	
	Usuarios cidadao, avaliador, superior;
	Secretarias secretaria1, secretaria2;
	Reclamacoes reclamacao;
	Anexos anexo, comentario1, comentario2;
	
	@BeforeClass
	public void inicializaValores(){
		
		usuarioDAO = new UsuariosDAO();
		secretariaDAO = new SecretariasDAO();
		reclamacaoDAO = new ReclamacoesDAO();
		anexoDAO = new AnexosDAO();
		
		usuarioService = new UsuariosService(usuarioDAO);
		secretariaService = new SecretariasService(secretariaDAO);
		reclamacaoService = new ReclamacoesService(reclamacaoDAO);
		anexoService = new AnexosService(anexoDAO);
		
		secretaria1 = new Secretarias(1,"Secretaria Teste 1",true);
		secretaria2 = new Secretarias(2,"Secretaria Teste 2",true);
		
		cidadao = new Usuarios("cidadao","cidadao","Fulano de Tal","011 2456-7890","011 9 8923-4567","Rua dos Bobos, 0",123456,"fulano@provedor.com",1234567890,"Cidadao",0);
		avaliador = new Usuarios("avaliador","avaliador","Avaliador da Secretaria","011 2456-7890","011 9 8923-4567","Rua dos Bobos, 0",123457,"avaliador@prefeitura.gov.br",1234567891,"Avaliador",1);
		superior = new Usuarios("superior","superior","Superior da Secretaria","011 2456-7890","011 9 8923-4567","Rua dos Bobos, 0",123458,"avaliador@prefeitura.gov.br",1234567892,"Superior",1);
		
		anexo = new Anexos(1,1,"cidadao","Teste","","Anexo");
		comentario1 = new Anexos(2,1,"cidadao","","Lorem ipsum 1","Comentario");
		comentario2 = new Anexos(3,1,"cidadao","","Dolor sit amet 2","Comentario");
	
	}
	
	/*@Test(timeout=100)
	public void testaInclusaoSecretaria(){
		secretariaService.criar(secretaria1);
		secretariaService.criar(secretaria2);
		
	}
	
	@Test(timeout=100)
	public void testaLeituraSecretaria(){
		
	}*/

	
}
