package br.edu.ifms.horasc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.horasc.model.Usuario;
import br.edu.ifms.horasc.model.Horas;
import br.edu.ifms.horasc.model.CursoValido;
import br.edu.ifms.horasc.service.ServiceUsuario;
import br.edu.ifms.horasc.service.ServiceHoras;
import br.edu.ifms.horasc.service.ServiceCursoValido;

@Controller
public class ControllerCursoValido {
	@Autowired
	private ServiceCursoValido serviceCursoValido;
	// --------------------------------------------------------------
	// Aqui começam as rotas dos Cursos Validos 
	// --------------------------------------------------------------
	
	
	@GetMapping("/listaCursoValido")
	public ModelAndView listaCursoValido() {
		ModelAndView mv = new ModelAndView("listaCursoValido");
		mv.addObject("cursosValidos", serviceCursoValido.findAll());		
		return mv;
	}
	
	@GetMapping("/addCursoValido")
	public ModelAndView addCursoValido() {		
		ModelAndView mv = new ModelAndView("addCursoValido");
		mv.addObject(new CursoValido());		
		return mv;
	}
	
	@PostMapping("/addCursoValido")
	public String saveCursoValido(CursoValido cursoValido, RedirectAttributes attributes ) {
		serviceCursoValido.save(cursoValido);
		attributes.addFlashAttribute("mensagem", "Curso valido salvo com sucesso!!");
		return "redirect:/listaCursoValido";
	}
	
	@GetMapping("/deleteCursoValido/{id}")
	public String deleteCursoValido (@PathVariable ("id") Long id) {
		if (serviceCursoValido.cursoValidoHoras(id).size()==0)
			serviceCursoValido.deleteById(id);		
		return "redirect:/listaCursoValido";
	}
	
	@GetMapping("/editCursoValido/{id}")
	public ModelAndView editCursoValido (@PathVariable ("id") Long id) {
		ModelAndView mv = new ModelAndView("addCursoValido");
		mv.addObject("cursosValidos", serviceCursoValido.findById(id));
		return mv;
	}
}
