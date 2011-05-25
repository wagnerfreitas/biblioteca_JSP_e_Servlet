package com.br.biblioteca.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.br.biblioteca.entidades.Emprestimo;
import com.br.biblioteca.entidades.Livro;
import com.br.biblioteca.entidades.Usuario;


public class BibliotecaUtil {
	private static SessionFactory factory;
	static{
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Usuario.class);	
		cfg.addAnnotatedClass(Emprestimo.class);
		cfg.addAnnotatedClass(Livro.class);
		factory = cfg.buildSessionFactory(); 
	}
	public Session getSession(){
		return factory.openSession();
	}
}