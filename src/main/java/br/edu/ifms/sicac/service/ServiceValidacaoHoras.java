package br.edu.ifms.sicac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.sicac.model.Horas;
import br.edu.ifms.sicac.model.ValidacaoHoras;
import br.edu.ifms.sicac.repository.RepositoryValidacaoHoras;

@Service
public class ServiceValidacaoHoras {
	@Autowired
	private RepositoryValidacaoHoras repositoryValidacaoHoras;
	
	public List<ValidacaoHoras> findAll(){
		return repositoryValidacaoHoras.findAll();
	}
	public void deleteById(Long id) {
		repositoryValidacaoHoras.deleteById(id);
	}
	public void save(ValidacaoHoras validacaoHoras) {
		repositoryValidacaoHoras.saveAndFlush(validacaoHoras);
	}
	public Optional<ValidacaoHoras> findById(Long id) {
		return repositoryValidacaoHoras.findById(id);
	}
}