package br.edu.ifms.horasc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.horasc.model.CursoValido;
import br.edu.ifms.horasc.model.Usuario;
@Repository
public interface RepositoryCursoValido extends JpaRepository<CursoValido, Long>{
	public List<CursoValido> findByCategoriaCurso(String categoriaCurso);
	List<CursoValido> findTop10ByCategoriaCursoContaining(String categoriaCurso);
}