package edu.yan.springboot.primeirospassos.configurationproperties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner{
	@Autowired
	private Remetente remetente;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Configuration properties exemplo");
		System.out.println("Mensagem enviada por: "+remetente.getNome()+" \n Email: "+remetente.getEmail()+" \n Contato: "+remetente.getTelefones());
		System.out.println("Cadastro aprovado");
	}
	
}
