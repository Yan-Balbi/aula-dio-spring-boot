package edu.yan.springboot.primeirospassos.beanvscomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

//eu uso component quando tenho acesso ao código fonte
@Component
public class ConversorJson {
	@Autowired
	private Gson gson;
	
	public ViaCepResponse converter(String json) {
		ViaCepResponse cepResponse = gson.fromJson(json, ViaCepResponse.class);
		return cepResponse;
	}
}
