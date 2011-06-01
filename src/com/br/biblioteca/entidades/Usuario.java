package com.br.biblioteca.entidades;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String email;
	private boolean usuarioAtivo;
	
	@OneToMany
	private Collection<Usuario> usuario;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isUsuarioAtivo() {
		return usuarioAtivo;
	}
	public void setUsuarioAtivo(boolean usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
	}
	public Collection<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(Collection<Usuario> usuario) {
		this.usuario = usuario;
	}
}