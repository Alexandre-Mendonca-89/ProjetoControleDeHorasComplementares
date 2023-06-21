package br.edu.ifms.horasc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.horasc.model.Horas;
import br.edu.ifms.horasc.repository.RepositoryHoras;

@Service
public class ServiceHoras {
	@Autowired
	private RepositoryHoras repositoryHoras;
	
	public List<Horas> findAll(){
		return repositoryHoras.findAll();
	}
	public void deleteById(Long id) {
		repositoryHoras.deleteById(id);
	}
	public void save(Horas hora) {
		repositoryHoras.saveAndFlush(hora);
	}
	public Optional<Horas> findById(Long id) {
		return repositoryHoras.findById(id);
	}
}