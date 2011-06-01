package com.br.biblioteca.excecoes;

@SuppressWarnings("serial")
public class DeletarUsuarioException extends Exception{
	public DeletarUsuarioException(String erro){
		super(erro);
	}
}
