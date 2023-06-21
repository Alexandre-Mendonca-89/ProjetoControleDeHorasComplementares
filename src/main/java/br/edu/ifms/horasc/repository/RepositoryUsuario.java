package br.edu.ifms.horasc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.horasc.model.Usuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long>{
	public List<Usuario> findByNome(String nome);
	List<Usuario> findTop10ByNomeContaining(String nome);
}