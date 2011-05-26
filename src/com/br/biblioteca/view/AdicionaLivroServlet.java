package com.br.biblioteca.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.biblioteca.biblioteca.Biblioteca;
import com.br.biblioteca.entidades.Livro;

@SuppressWarnings("serial")
public class AdicionaLivroServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Livro livro = new Livro();
		String nome = req.getParameter("nomeLivro");
		String autor = req.getParameter("autor");
		livro.setNome(nome);
		livro.setAutor(autor);
		
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.cadastraLivro(nome, autor);
		
		RequestDispatcher rd = req.getRequestDispatcher("/adicionado.jsp");
		rd.forward(req, resp);
	}
}