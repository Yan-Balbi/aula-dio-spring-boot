package edu.yan.springboot.webapi.exemplos.exemplo3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.yan.springboot.webapi.exemplos.exemplo3.security.config.SegurancaBancoDadosService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class ConfiguracoesDeSeguranca {
	
	@Autowired
	private SegurancaBancoDadosService securityService;
	
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
        		.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> requests
						.requestMatchers("/").permitAll()
						.requestMatchers(/*HttpMethod.POST,*/ "/login").permitAll()
						.requestMatchers("/user").hasAnyRole("ADMIN","USER")
						.requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
                .build();
	}

	/*
	@Bean
	UserDetailsService userDetailsService(AuthenticationManagerBuilder auth) throws Exception{	
		var admin = User.withUsername("admin").password("{noop}admin").roles("ADMIN").build(); // noop é um encoding encrypt
		var user = User.withUsername("user").password("{noop}user").roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	*/



}
