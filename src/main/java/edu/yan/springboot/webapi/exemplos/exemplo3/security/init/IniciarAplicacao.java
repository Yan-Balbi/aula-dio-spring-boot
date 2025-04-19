package edu.yan.springboot.webapi.exemplos.exemplo3.security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.yan.springboot.webapi.exemplos.exemplo3.security.model.Usuario;
import edu.yan.springboot.webapi.exemplos.exemplo3.security.repository.UsuarioRepository;	

@Component
public class IniciarAplicacao implements CommandLineRunner{
	
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injetando o PasswordEncoder (que é o BCryptPasswordEncoder)

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = usuarioRepository.findByUsuario("admin");
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setNome("admin");
            usuario.setUsuario("admin");
            usuario.setSenha("admin"); // Usando o PasswordEncoder
            usuario.getRoles().add("ADMIN");
            usuarioRepository.save(usuario);
        }

        usuario = usuarioRepository.findByUsuario("user");
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setNome("user");
            usuario.setUsuario("user");
            usuario.setSenha("user"); // Usando o PasswordEncoder
            usuario.getRoles().add("USER");
            usuarioRepository.save(usuario);
        }
    }
	
}
