package controller;


import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Usuarios;
import service.UsuariosService;

@Transactional
@Controller
public class LoginController {
	private final UsuariosService us;
	
	@Autowired
	public LoginController(UsuariosService us){
		this.us = us;
	}

	@RequestMapping("loginForm")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("fazer_login")
	public String efetuaLogin(Usuarios usuarios, HttpSession session, Model model){

		try {
			if(us.validar(usuarios)){
				session.setAttribute("usuarioLogado", usuarios);
				return "redirect:listar_reclamacoes";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "erro";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
}
