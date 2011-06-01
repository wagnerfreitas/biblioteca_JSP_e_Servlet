package com.br.biblioteca.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.biblioteca.entidades.Emprestimo;


public class EmprestimoDAO {
	private Session session;
	
	public EmprestimoDAO(Session session){
		this.session = session;
	}
	public void salva(Emprestimo emprestimo){
		try {
			this.session.beginTransaction();
			this.session.save(emprestimo);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally{
			if(this.session != null){
				this.session.close();
			}
		}
		
	}
	public void atualiza(Emprestimo emprestimo){
		try {
			this.session.beginTransaction();
			this.session.update(emprestimo);
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
	public List<Emprestimo> procuraPorUsuario(String nomeDoUsuario){
		return this.session.createCriteria(Emprestimo.class).list();
	} 
	@SuppressWarnings("unchecked")
	public List<Emprestimo> procuraPorLivro(String nomeDoLivro) {
		List<Emprestimo> emprestimos = this.session
			.createCriteria(Emprestimo.class)
				.add(Restrictions.isNull("dataDeDevolucao"))
			.createCriteria("livro")
				.add(Restrictions.like("nome", "%" + nomeDoLivro + "%"))
			.list();
		return emprestimos;
	}
	public Emprestimo procuraPorIdUsuario(Long id){
		return (Emprestimo) this.session
			.createCriteria(Emprestimo.class)
				.add(Restrictions.isNull("dataDeDevolucao"))
				.add(Restrictions.eq("usuario_id", id))
			.list();	
	}
	public Emprestimo procuraPorId(Long id) {
		return (Emprestimo) this.session
			.createCriteria(Emprestimo.class)
				.add(Restrictions.eq("id", id))
			.uniqueResult();
	} 
}