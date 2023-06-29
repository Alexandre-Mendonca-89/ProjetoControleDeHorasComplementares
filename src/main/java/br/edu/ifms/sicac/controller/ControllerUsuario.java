package br.edu.ifms.sicac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.sicac.model.CursoValido;
import br.edu.ifms.sicac.model.Horas;
import br.edu.ifms.sicac.model.Usuario;
import br.edu.ifms.sicac.service.ServiceCursoValido;
import br.edu.ifms.sicac.service.ServiceHoras;
import br.edu.ifms.sicac.service.ServiceUsuario;

@Controller
public class ControllerUsuario {
	@Autowired
	private ServiceHoras serviceHoras;
	@Autowired
	private ServiceUsuario serviceUsuario;
	@Autowired
	private ServiceCursoValido serviceCursoValido;
	
	@GetMapping("/")
	public ModelAndView principal() {
		ModelAndView mv = new ModelAndView("/home/index");
		return mv;		
	}
	
	// --------------------------------------------------------------
	// Aqui começam as rotas dos Usuarios 
	// --------------------------------------------------------------
	
	@GetMapping("/listaUsuario")
	
	public ModelAndView listaUsuario() {
		ModelAndView mv = new ModelAndView("administrador/listaUsuario");
		mv.addObject("usuarios", serviceUsuario.findAll());		
		return mv;
	}
	
	@GetMapping("/addUsuario")
	public ModelAndView add() {		
		ModelAndView mv = new ModelAndView("administrador/addUsuario");
		mv.addObject(new Usuario());		
		return mv;
	}
	
	@PostMapping("/addUsuario")
	public String save(Usuario usuario, RedirectAttributes attributes) {
		serviceUsuario.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!!");
		return "redirect:/listaUsuario";
	}
	
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable ("id") Long id) {
		if (serviceUsuario.usuarioHoras(id).size()==0)
			serviceUsuario.deleteById(id);		
		return "redirect:/administrador/listaUsuario";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit (@PathVariable ("id") Long id) {
		ModelAndView mv = new ModelAndView("/administrador/addUsuario");
		mv.addObject("usuario", serviceUsuario.findById(id));
		return mv;
	}
	
	@GetMapping("/usuarioHoras/{id}")
	public ModelAndView usuarioHoras (@PathVariable ("id") Long id) {
		ModelAndView mv = new ModelAndView("/administrador/usuarioHoras");
		mv.addObject("horas", serviceUsuario.usuarioHoras(id));
		mv.addObject("total", serviceUsuario.usuarioHorasTotal(id));
		return mv;
	}
}
