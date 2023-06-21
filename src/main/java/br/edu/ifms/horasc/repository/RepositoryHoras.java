package br.edu.ifms.horasc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.horasc.model.Horas;
@Repository
public interface RepositoryHoras extends JpaRepository<Horas, Long>{
	public List<Horas> findByCurso(String curso);
	List<Horas> findTop10ByCursoContaining(String curso);
}