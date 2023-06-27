package br.edu.ifms.sicac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.sicac.model.CursoValido;
import br.edu.ifms.sicac.model.ValidacaoHoras;
import br.edu.ifms.sicac.model.Usuario;
import br.edu.ifms.sicac.service.ServiceCursoValido;
import br.edu.ifms.sicac.service.ServiceHoras;
import br.edu.ifms.sicac.service.ServiceValidacaoHoras;
import br.edu.ifms.sicac.service.ServiceUsuario;

@Controller
public class ControllerValidacaoHoras {
	@Autowired
	private ServiceValidacaoHoras serviceValidacaoHoras;
	@Autowired
	private ServiceUsuario serviceUsuario;
	@Autowired
	private ServiceCursoValido serviceCursoValido;
	@Autowired
	private ServiceHoras serviceHoras;
	// --------------------------------------------------------------
	// Aqui começam as rotas das ValidacaoHoras
	// --------------------------------------------------------------
	
	@GetMapping("/listaValidacaoHoras")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listaValidacaoHoras");
		mv.addObject("validacaoHoras", serviceValidacaoHoras.findAll());
		return mv;
	}
	@GetMapping("/addValidacaoHoras")
	public ModelAndView addValidacaoHoras() {		
		ModelAndView mv = new ModelAndView("addValidacaoHoras");
		mv.addObject(new ValidacaoHoras());	
		mv.addObject("usuarios", serviceUsuario.findAll());
		mv.addObject("cursosValidos", serviceCursoValido.findAll());
		mv.addObject("horas", serviceHoras.findAll());
		return mv;
	}
	
	@PostMapping("/addValidacaoHoras")
	public String saveValidacaoHoras(ValidacaoHoras validacaoHoras,  RedirectAttributes attributes) {
		serviceValidacaoHoras.save(validacaoHoras);
		attributes.addFlashAttribute("mensagem", "Validacao de Horas salva com sucesso!!");
		return "redirect:/listaValidacaoHoras";
	}
	
	@GetMapping("/deleteValidacaoHoras/{id}")
	public String deleteValidacaoHoras (@PathVariable ("id") Long id) {
		serviceValidacaoHoras.deleteById(id);		
		return "redirect:/listaValidacaoHoras";
	}
	
	@GetMapping("/editValidacaoHoras/{id}")
	public ModelAndView editValidacaoHoras (@PathVariable ("id") Long id) {
		ModelAndView mv = new ModelAndView("addValidacaoHoras");
		mv.addObject("validacaoHoras", serviceValidacaoHoras.findById(id));
		//mv.addObject("usuarios", serviceHoras.findById(id).get().getUsuario());
		//mv.addObject("cursoValido", serviceHoras.findById(id).get().getCursoValido());
		mv.addObject("usuarios", serviceUsuario.findAll());
		mv.addObject("cursosValidos", serviceCursoValido.findAll());
		mv.addObject("horas", serviceHoras.findAll());
		
		return mv;
	}
}