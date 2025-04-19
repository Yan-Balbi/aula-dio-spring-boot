package edu.yan.springboot.primeirospassos.primeirospassos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//o Component é usado para o SpringBoot fazer a gerencia de Objetos
@Component
public class MyApp implements CommandLineRunner{ //commandLineRunner é uma interface que executa uma aplicação assim que ela for iniciada
	//como o Anotator component está sendo usado na calculadora, posso instanciar um objeto sem medo aqui dentro
	
	@Autowired
	private Calculadora calculadora;//o autowired é usado quando eu quero instanciar um novo objeto pelo Container, uma vez que não é recomendável instanciar pelo new.
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(calculadora.somar(2, 2));
	}

}
