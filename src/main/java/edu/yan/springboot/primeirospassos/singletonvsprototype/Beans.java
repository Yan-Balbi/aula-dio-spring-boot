package edu.yan.springboot.primeirospassos.singletonvsprototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {
    @Bean
    @Scope("prototype") //por padrão, o Scope é singleton, mas se eu usar esse parâmetro ele vira prototype
    //o padrão prototype instancia um objeto a cada chamada, diferente do singleton
    public Remetente remetente(){
        System.out.println("CRIANDO UM OBJETO REMETENTE");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@dio.com.br");
        remetente.setNome("Digital Innovation One");
        return remetente;
    }
}
