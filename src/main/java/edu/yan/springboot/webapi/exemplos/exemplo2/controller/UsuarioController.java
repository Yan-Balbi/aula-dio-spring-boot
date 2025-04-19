package edu.yan.springboot.webapi.exemplos.exemplo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yan.springboot.webapi.exemplos.exemplo2.model.Usuario;
import edu.yan.springboot.webapi.exemplos.exemplo2.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping()
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{nome}")
	public Usuario getUsuario(@PathVariable("nome") String nome){
		return usuarioRepository.findByUsername(nome);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable("id") Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	@PostMapping()
	public void postUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.salvar(usuario);
	}
	
	@PutMapping()
	public void putUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.atualizar(usuario);
	}
	
}
