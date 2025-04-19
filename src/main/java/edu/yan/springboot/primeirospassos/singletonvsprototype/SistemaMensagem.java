package edu.yan.springboot.primeirospassos.singletonvsprototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem {
	@Autowired
	private Remetente noreply;
	
	@Autowired
	private Remetente tech;
	
	public void enviarConfirmacaoCadastro() {
		System.out.println(noreply);
		System.out.println("Cadastro aprovado");
	}
	
	public void enviarMensagemBoasVindas() {
		tech.setEmail("email@exemplo.com");
		System.out.println(tech);
		System.out.println("Bem vindo à tech");
	}
	
}
