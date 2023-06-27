package br.edu.ifms.sicac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.sicac.model.CursoValido;
import br.edu.ifms.sicac.model.Horas;
import br.edu.ifms.sicac.repository.RepositoryCursoValido;



@Service
public class ServiceCursoValido {
	
	@Autowired
	private RepositoryCursoValido repositoryCursosValidos;
	
	public List<CursoValido> findAll(){
		return repositoryCursosValidos.findAll();
	}
	public void deleteById(Long id) {
		repositoryCursosValidos.deleteById(id);
	}
	public void save(CursoValido cursoValido) {
		repositoryCursosValidos.saveAndFlush(cursoValido);
	}
	public Optional<CursoValido> findById(Long id) {
		return repositoryCursosValidos.findById(id);
	}
	
	public List<Horas> cursoValidoHoras(Long id){
		List<Horas> m = repositoryCursosValidos.findById(id).get().getHoras();
		return m;
	}

}
