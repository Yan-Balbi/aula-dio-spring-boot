package edu.yan.springboot.persistencia.introducaojpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.yan.springboot.persistencia.introducaojpa.Dao.UsuarioDao;
import edu.yan.springboot.persistencia.introducaojpa.Model.UsuarioModel;

@Component
public class StartApp implements CommandLineRunner{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UsuarioModel usuarioModel1 = new UsuarioModel();
		usuarioModel1.setNome("Jose");
		usuarioModel1.setNomeDeUsuario("US3R");
		usuarioModel1.setEmail("user1@gmail.com");
		usuarioModel1.setSenha("psswd");
		
		UsuarioModel usuarioModel2 = new UsuarioModel();
		usuarioModel2.setNome("Rivaldo");
		usuarioModel2.setNomeDeUsuario("Cleri");
		usuarioModel2.setEmail("user2@gmail.com");
		usuarioModel2.setSenha("psswd");
		
		UsuarioModel usuarioModel3 = new UsuarioModel();
		usuarioModel3.setNome("Geraldo");
		usuarioModel3.setNomeDeUsuario("G3veraldo");
		usuarioModel3.setEmail("user3@gmail.com");
		usuarioModel3.setSenha("psswd");
		
		usuarioDao.save(usuarioModel1);
		usuarioDao.save(usuarioModel2);
		usuarioDao.save(usuarioModel3);
		
		for(UsuarioModel usuario: usuarioDao.findAll()) {
			System.out.println("Nome: "+usuario.getNome()+"\nNome de Usuario: "+usuario.getNomeDeUsuario()+"\nEmail: "+usuario.getEmail()+"\n");
		
		}
		System.out.println("Procurando por ocorrências com 2");
		List<UsuarioModel>usuariosCom1 = usuarioDao.filtrarPorNome("aldo");
		usuariosCom1.forEach(user -> System.out.println("Usuário: "+user.getNome()));
	}

}
