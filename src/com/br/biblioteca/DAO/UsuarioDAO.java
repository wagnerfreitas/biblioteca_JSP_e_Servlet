package com.br.biblioteca.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.biblioteca.entidades.Usuario;

public class UsuarioDAO {
	private Session session;

	public UsuarioDAO(Session session) {
		this.session = session;
	}
	public void salva(Usuario usuario) {
		this.session.beginTransaction();
		this.session.save(usuario);
		this.session.getTransaction().commit();
		this.session.close();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> procura(String nome) {
		return (List<Usuario>) this.session.createCriteria(Usuario.class).add(Restrictions.like("nome", "%" + nome + "%")).list();
	}
	public void remove(Usuario usuario) {
		this.session.delete(usuario);
	}
}