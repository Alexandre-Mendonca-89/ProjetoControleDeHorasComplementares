package br.edu.ifms.sicac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.sicac.model.Horas;
@Repository
public interface RepositoryHoras extends JpaRepository<Horas, Long>{
	public List<Horas> findByCurso(String curso);
	List<Horas> findTop10ByCursoContaining(String curso);
}