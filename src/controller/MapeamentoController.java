package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Reclamacoes;
import model.Usuarios;
import service.AnexosService;
import service.ReclamacoesService;
import service.SecretariasService;
import service.UsuariosService;



@Controller
public class MapeamentoController {
	private AnexosService as;
	private ReclamacoesService rs;
	private SecretariasService ss;
	private UsuariosService UsuariosService;

	@Autowired
	public MapeamentoController(AnexosService as, ReclamacoesService rs, SecretariasService ss, UsuariosService UsuariosService) {
		this.as = as;
		this.rs = rs;
		this.ss = ss;
		this.UsuariosService = UsuariosService;
	}

	@RequestMapping("index")
	public String home() {
		return "redirect:listar_reclamacoes";
	}

	@RequestMapping("nova_reclamação")
	public String form(Model model) throws IOException {
		ArrayList<Reclamacoes> tipos = rs.listarReclamacoes();
		model.addAttribute("tipos", tipos);
		return "local/reclamacaocriar";
	}

	@RequestMapping("alterar_reclamacao")
	public String formAlterar(Model model, Reclamacoes reclamacoes) throws IOException{
		ArrayList<Reclamacoes> tipos = rs.listarReclamacoes();
		model.addAttribute("tipos", tipos);
		return "local/reclamacaoalterar";
	}

	@RequestMapping("incluir_reclamacao")
	public String inclusao(@Valid Reclamacoes reclamacoes, BindingResult result, Model model) throws IOException{
		if (result.hasErrors()) {
			ArrayList<Reclamacoes> tipos = rs.listarReclamacoes();
			model.addAttribute("tipos", tipos);
			return "local/reclamacaocriar";
		}
		rs.criar(reclamacoes, null);
		return "redirect:listar_reclamacoes";
	}

	@RequestMapping("listar_usuarios")
	public String listagem(Model model, String chave) throws IOException{
		try {
			if (chave == null || chave.equals("")) {
				model.addAttribute("usuarios", UsuariosService.listarUsuarios());
			} else {
				model.addAttribute("usuarios", UsuariosService.listarUsuarios(chave));
			}
			return "local/locallistar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("limpar_reclamacoes")
	public String limparListagem(Model model) throws IOException{
		model.addAttribute("locais", null);
		return "local/reclamacoeslistar";
	}

	/*@RequestMapping("mostrar_local")
	public String mostrar(Local local, Model model) {
		try {
			ls.mostrar(local);
			return "local/localmostrar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	/*@RequestMapping("remover_local")
	public String remover(Local local, Model model) {
		try {
			ls.remover(local);
			return "redirect:listar_locais";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	/*	@RequestMapping("atualizar_local")
	public String atualizar(Local local, Model model) {

		try {
			ls.atualizar(local);
			return "redirect:listar_locais";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}*/

	@RequestMapping("login")
	public String login() throws IOException{
		return "local/login";
	}

	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuarios usuarios, HttpSession session) throws IOException {
		if (UsuariosService.validacao(usuarios)) {
			session.setAttribute("Login", usuarios);
			return "redirect:listar_reclamacoes";
		}
		return "redirect:login";
	}
	@RequestMapping("sair")
	public String sair(HttpSession session) throws IOException{
		session.invalidate();
		return "redirect:login";
	}

}
