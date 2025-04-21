package edu.yan.springboot.designpatternsspringboot.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "edu.yan.springboot.designpatternsspringboot.gof.service")

//OBS: esse projeto não roda se o SpringSecurity estiver ativado por isso eu comento a importanção dele no pom.xml

public class Aplicacao {
	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class, args);
	}
}
