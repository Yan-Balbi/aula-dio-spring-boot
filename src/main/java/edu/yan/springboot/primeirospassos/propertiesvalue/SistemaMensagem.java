package edu.yan.springboot.primeirospassos.propertiesvalue;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner{
	@Value("${nome}")
	private String nome;
	
	@Value("${email}")
	private String email = "ze@gmail.com";
	
	@Value("${telefones}")
	private List<Long> telefones;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mensagem enviada por: "+nome+" \n Email: "+email+" \n Contato: "+telefones);
		System.out.println("Cadastro aprovado");
	}
	
}
