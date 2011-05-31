package com.br.biblioteca.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.biblioteca.entidades.Usuario;

public class UsuarioDAO {
	private Session session;

	public UsuarioDAO(Session session) {
		this.session = session;
	}
	public void salva(Usuario usuario) {
		try {
			this.session.beginTransaction();
			this.session.save(usuario);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}
		finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> procura(String nome) {
		List<Usuario> usuarios = this.session.createCriteria(Usuario.class).add(Restrictions.like("nome", "%" + nome + "%")).list();
		return usuarios; 
	}
	public void remove(Usuario usuario) {
		try {
			this.session.beginTransaction();
			this.session.delete(usuario);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}
	public Usuario procuraPorId(Long id) {
		return (Usuario) this.session
			.createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
			.uniqueResult();
	} 
}