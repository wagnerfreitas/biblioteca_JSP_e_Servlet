package com.br.biblioteca.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.biblioteca.entidades.Livro;


public class LivroDAO {
	private Session session;
	
	public LivroDAO(Session session){
		this.session = session;
	}
	public void salva(Livro livro){
		this.session.beginTransaction();
		this.session.save(livro);
		this.session.getTransaction().commit();
		this.session.close();
	}
	@SuppressWarnings("unchecked")
	public List<Livro> procuraPorNome(String nomeLivro){
		return (List<Livro>) this.session.createCriteria(Livro.class)
		.add(Restrictions.like("nome", "%" + nomeLivro + "%"))
		.list();
	}
	public Livro procuraPorId(Long id){
		return (Livro) this.session.createCriteria(Livro.class).add(Restrictions.eq("id", id));
	}
	public void update(Livro livro){
		this.session.beginTransaction();
		this.session.update(livro);
		this.session.getTransaction().commit();
		this.session.close();
	}
	public void remove(Livro livro){
		this.session.delete(livro);
	}
}