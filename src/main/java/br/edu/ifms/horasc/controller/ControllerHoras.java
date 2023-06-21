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
public class ControllerHoras {
	@Autowired
	private ServiceHoras serviceHoras;
	@Autowired
	private ServiceUsuario serviceUsuario;
	@Autowired
	private ServiceCursoValido serviceCursoValido;
	// --------------------------------------------------------------
	// Aqui começam as rotas das Horas
	// --------------------------------------------------------------
	
	@GetMapping("/listaHoras")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listaHoras");
		mv.addObject("horas", serviceHoras.findAll());
		return mv;
	}
	
	@GetMapping("/addHoras")
	public ModelAndView addHoras() {		
		ModelAndView mv = new ModelAndView("addHoras");
		mv.addObject(new Horas());	
		mv.addObject("usuarios", serviceUsuario.findAll());
		mv.addObject("cursosValidos", serviceCursoValido.findAll());
		return mv;
	}
	
	@PostMapping("/addHoras")
	public String saveHoras(Horas horas,  RedirectAttributes attributes) {
		serviceHoras.save(horas);
		attributes.addFlashAttribute("mensagem", "Horas salva com sucesso!!");
		return "redirect:/listaHoras";
	}
	
	@GetMapping("/deleteHoras/{id}")
	public String deleteHoras (@PathVariable ("id") Long id) {
		serviceHoras.deleteById(id);		
		return "redirect:/listaHoras";
	}
	@GetMapping("/editHoras/{id}")
	public ModelAndView editHoras (@PathVariable ("id") Long id) {
		ModelAndView mv = new ModelAndView("addHoras");
		mv.addObject("hora", serviceHoras.findById(id));
		//mv.addObject("usuarios", serviceHoras.findById(id).get().getUsuario());
		//mv.addObject("cursoValido", serviceHoras.findById(id).get().getCursoValido());
		mv.addObject("usuarios", serviceUsuario.findAll());
		mv.addObject("cursosValidos", serviceCursoValido.findAll());
		
		return mv;
	}
	
	@GetMapping("/buscaNome")
	public ModelAndView addBuscaNome() {
		ModelAndView mv = new ModelAndView("buscaNome");
		mv.addObject(new Usuario());
		return mv;
	}
	@PostMapping("/buscaNome")
	public ModelAndView buscaNome(Usuario usuario) {
		ModelAndView mv = new ModelAndView("buscaNome");
		mv.addObject("usuarios", serviceUsuario.buscarNome(usuario));
		return mv;
	}
}