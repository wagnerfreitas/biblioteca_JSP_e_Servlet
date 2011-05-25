package com.br.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String autor;
	private boolean emprestado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	public boolean isEmprestado() {
		return emprestado;
	}
}