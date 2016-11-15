package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import model.Reclamacoes;
import model.Secretarias;
import model.Usuarios;
import service.AnexosService;
import service.ReclamacoesService;
import service.SecretariasService;
import service.UsuariosService;

@Transactional
@Controller
public class MapeamentoController {
	private AnexosService as;
	private ReclamacoesService rs;
	private SecretariasService ss;
	private UsuariosService us;

	@Autowired
	public MapeamentoController(AnexosService as, ReclamacoesService rs, SecretariasService ss, UsuariosService us) {
		this.as = as;
		this.rs = rs;
		this.ss = ss;
		this.us = us;
	}

	@RequestMapping("index")
	public String home() {
		return "redirect:listarReclamacoes";
	}

	@RequestMapping("novaReclamação")
	public String form(Model model) throws IOException {
		List<Reclamacoes> tipos = rs.listarReclamacoes();
		model.addAttribute("tipos", tipos);
		return "reclamacaoCriar";
	}


	@RequestMapping("incluirReclamacao")
	public String inclusao(@Valid Reclamacoes reclamacoes, BindingResult result, Model model) throws IOException{
		if (result.hasErrors()) {
			List<Reclamacoes> tipos = rs.listarReclamacoes();
			model.addAttribute("tipos", tipos);
			return "reclamacaoCriar";
		}
		rs.criar(reclamacoes);
		return "redirect:listarReclamacoes";
	}

	@RequestMapping("removerReclamacao")
	public String remover(Reclamacoes reclamacoes, Model model) {
		try {
			rs.remover(reclamacoes);
			return "redirect:listarReclamacoes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	
	@RequestMapping("atualizarReclamacao")
	public String atualizar(Reclamacoes reclamacoes, Model model, @RequestParam("file") MultipartFile file) {
		try {
			rs.atualizar(reclamacoes);
			rs.gravarImagem(servletContext, reclamacoes, file);
			return "redirect:listar_locais";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
}
