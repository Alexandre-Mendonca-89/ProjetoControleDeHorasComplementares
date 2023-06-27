package br.edu.ifms.sicac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.sicac.model.Horas;
import br.edu.ifms.sicac.model.Usuario;
import br.edu.ifms.sicac.repository.RepositoryUsuario;

@Service
public class ServiceUsuario {
	@Autowired
	private RepositoryUsuario usuarios;
	
	public List<Usuario> findAll(){
		return usuarios.findAll();
	}
	
	public List<Usuario> buscarPorNome(String nome){
		return usuarios.findTop10ByNomeContaining(nome);
	}
	
	public void deleteById(Long id) {
		usuarios.deleteById(id);
	}
	
	public void delete(Usuario usuario) {
		usuarios.delete(usuario);
	}
	
	public void save(Usuario usuario) {
		usuarios.saveAndFlush(usuario);
	}
	public Optional<Usuario> findById(Long id) {
		return usuarios.findById(id);
	}
	public List<Horas> usuarioHoras(Long id){
		List<Horas> m = usuarios.findById(id).get().getHoras();
		return m;
	}
	public double usuarioHorasTotal(Long id){
		List<Horas> m = usuarios.findById(id).get().getHoras();
		double total = 0;
		for (Horas horas : m) {
			total += horas.getHoraContemplada();			
		}
		return total;
	}
	public List<Usuario> buscarNome(Usuario usuario){
		return usuarios.findByNome(usuario.getNome());
	}
}