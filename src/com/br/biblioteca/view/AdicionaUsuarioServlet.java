package com.br.biblioteca.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.biblioteca.biblioteca.Biblioteca;
import com.br.biblioteca.entidades.Usuario;

@SuppressWarnings("serial")
public class AdicionaUsuarioServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("nomeUsuario").trim();
		String email = req.getParameter("email").trim();
		try {
			if (nome.equals("") || email.equals("")) {
				throw new RuntimeException("Nome ou email nulos");
			} else {
				Usuario usuario = new Usuario();
				usuario.setNome(nome);
				usuario.setEmail(email);
				Biblioteca biblioteca = new Biblioteca();
				biblioteca.cadastraUsuario(usuario);
				RequestDispatcher rd = req.getRequestDispatcher("/adicionado.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("/erro.jsp");
			rd.forward(req, resp);
		}
	}
}
