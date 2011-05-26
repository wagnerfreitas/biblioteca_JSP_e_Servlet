package com.br.biblioteca.DAO;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.br.biblioteca.entidades.Emprestimo;
import com.br.biblioteca.entidades.Livro;
import com.br.biblioteca.entidades.Usuario;


public class GeraTabelas {
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Emprestimo.class);
		cfg.addAnnotatedClass(Livro.class);
		cfg.addAnnotatedClass(Usuario.class);
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
}