package br.edu.ifms.horasc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.horasc.model.Horas;
import br.edu.ifms.horasc.model.CursoValido;
import br.edu.ifms.horasc.repository.RepositoryCursoValido;



@Service
public class ServiceCursoValido {
	
	@Autowired
	private RepositoryCursoValido cursosValidos;
	
	public List<CursoValido> findAll(){
		return cursosValidos.findAll();
	}
	public void deleteById(Long id) {
		cursosValidos.deleteById(id);
	}
	public void save(CursoValido cursoValido) {
		cursosValidos.saveAndFlush(cursoValido);
	}
	public Optional<CursoValido> findById(Long id) {
		return cursosValidos.findById(id);
	}
	
	public List<Horas> cursoValidoHoras(Long id){
		List<Horas> m = cursosValidos.findById(id).get().getHoras();
		return m;
	}

}
