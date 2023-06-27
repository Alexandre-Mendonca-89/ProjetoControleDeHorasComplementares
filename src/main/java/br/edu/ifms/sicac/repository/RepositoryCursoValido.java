package br.edu.ifms.sicac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.sicac.model.CursoValido;
import br.edu.ifms.sicac.model.Usuario;
@Repository
public interface RepositoryCursoValido extends JpaRepository<CursoValido, Long>{
	public List<CursoValido> findByCategoriaCurso(String categoriaCurso);
	List<CursoValido> findTop10ByCategoriaCursoContaining(String categoriaCurso);
}