package com.br.biblioteca.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.biblioteca.entidades.Livro;


public class LivroDAO {
	private Session session;
	
	public LivroDAO(Session session){
		this.session = session;
	}
	public void salva(Livro livro){
		try {
			this.session.beginTransaction();
			this.session.save(livro);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public List<Livro> procuraPorNome(String nomeLivro){
		return (List<Livro>) this.session.createCriteria(Livro.class)
		.add(Restrictions.like("nome", "%" + nomeLivro + "%"))
		.list();
	}
	public Livro procuraPorId(Long id){
		return (Livro) this.session.createCriteria(Livro.class)
		.add(Restrictions.eq("id", id))
		.uniqueResult();
	}
	public void atualiza(Livro livro){
		try {
			this.session.beginTransaction();
			this.session.update(livro);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			if(this.session != null){
				this.session.close();
			}
		}
	}
	public void remove(Livro livro){
		try {
			this.session.beginTransaction();
			this.session.update(livro);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			if(this.session != null){
				this.session.delete(livro);
			}
		}
	}
}