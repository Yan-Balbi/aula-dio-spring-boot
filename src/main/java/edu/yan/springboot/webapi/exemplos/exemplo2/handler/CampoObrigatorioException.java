package edu.yan.springboot.webapi.exemplos.exemplo2.handler;

public class CampoObrigatorioException extends BusinessException{
	public CampoObrigatorioException(String campo) {
		super("O campo "+campo+"é obrigatorio");
	}
}
