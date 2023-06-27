package br.edu.ifms.sicac.controllerrest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.sicac.model.Usuario;
import br.edu.ifms.sicac.service.ServiceUsuario;

@RestController
@RequestMapping("/usuariosHC")
public class UsuariosControllerRest {

	@Autowired
	private ServiceUsuario usuarioService;
	
	@GetMapping
	public List<Usuario> listarTodos() {
		List<Usuario> listaDeUsuarios = usuarioService.findAll();
		return listaDeUsuarios;
	}
	/*ResponseEntity é um componente do Spring para lidar com os elementos de resposta da API
	 * Qual é a diferença de responder com o ResponseEntity ou a lista de notas diretamente?
	 * Na prática não há diferença alguma seguindo esse exemplo. Mas, dessa maneira,
	 * seguimos um padrão, como também, flexibilidade para personalizar a resposta HTTP,
	 * como por exemplo, devolver headers ou outros dados que fazem parte do protocolo HTTP.
	 * como estamos fazendo no método abaixo
	 */
	@GetMapping(value = "/{nome}")
    public ResponseEntity<List<Usuario>> buscarPorNome(@PathVariable(value = "nome") String nome)
    {
		List<Usuario> listaDeUsuarios = usuarioService.buscarPorNome(nome);
		
        if(listaDeUsuarios.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        	return new ResponseEntity<List<Usuario>>(listaDeUsuarios, HttpStatus.OK);
        }
            
    }
	
	/*@RequestBody: ele habilita a deserialização automática do objeto. Então se passarmos para o método um JSON,
	 * esta anotação consegue de forma simples transformar estes dados em um objeto Carro.
	 * 
	 * @Valid: esta anotação verifica se o objeto Carro passado atende todas as validações, feitas na classe.
	 */
	@RequestMapping(value = "/usuario", method =  RequestMethod.POST)
    public HttpStatus Post(@Valid @RequestBody Usuario usuario)
    {
		try {
			usuarioService.save(usuario);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.UNAUTHORIZED;
		}
    }
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
		Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent()){
        	usuarioService.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value = "/usuario/{id}")
    public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Usuario usuario)
    {
        Optional<Usuario> usuarioQueSeraAlteradoOptional = usuarioService.findById(id);
        if(usuarioQueSeraAlteradoOptional.isPresent()){
            Usuario usuarioQueSeraAlterado = usuarioQueSeraAlteradoOptional.get();
            usuarioQueSeraAlterado.setNome(usuario.getNome());
            usuarioService.save(usuarioQueSeraAlterado);
            return new ResponseEntity<Usuario>(usuarioQueSeraAlterado, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}