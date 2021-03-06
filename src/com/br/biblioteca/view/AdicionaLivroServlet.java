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
		String nome = req.getParameter("nomeLivro").trim();
		String autor = req.getParameter("autor").trim();
		try {
			if(nome.equals("") || autor.equals("")){
				throw new RuntimeException("Nome ou autor nulos");
			}else{
				Livro livro = new Livro();
				livro.setNome(nome);
				livro.setAutor(autor);
				Biblioteca biblioteca = new Biblioteca();
				biblioteca.cadastraLivro(livro);
				
				RequestDispatcher rd = req.getRequestDispatcher("/adicionado.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("/erro.jsp");
			rd.forward(req, resp);
		}
	}
}