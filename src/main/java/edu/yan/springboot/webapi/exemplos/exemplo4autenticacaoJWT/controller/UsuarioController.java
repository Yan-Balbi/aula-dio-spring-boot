package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.model.Usuario;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public void inserirUsuario(@RequestBody Usuario usuario) {
		usuarioService.createUsuario(usuario);;
	}
}
