package edu.yan.springboot.webapi.exemplos.exemplo2.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class DocumentacaoSwagger {
	
    @Bean
    public OpenAPI customOpenAPI() { //o bean aqui é genérico porque estou configurando uma instância de uma classe que não foi criada por mim e nem anotada com @Component, @Service, etc.
        //não possui nenhum bean específico(@Service, @Repository, @Controller ou @Component)
    	return new OpenAPI()
            .info(new Info()
                .title("API - Primeiros Passos")
                .description("Documentação da API de exemplo com Spring Boot 3 e Springdoc OpenAPI")
                .version("1.0")
                .contact(new Contact()
                    .name("Yan")
                    .email("yanbalbi@gmail.com")
                    .url("https://github.com/Yan-Balbi"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://springdoc.org"))
            );
    }
	
}
