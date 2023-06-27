package br.edu.ifms.sicac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.sicac.model.ValidacaoHoras;
@Repository
public interface RepositoryValidacaoHoras extends JpaRepository<ValidacaoHoras, Long>{
	public List<ValidacaoHoras> findByStatus(String status);
	List<ValidacaoHoras> findTop10ByStatusContaining(String status);
}