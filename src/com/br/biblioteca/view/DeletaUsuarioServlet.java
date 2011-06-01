package com.br.biblioteca.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.biblioteca.biblioteca.Biblioteca;
import com.br.biblioteca.excecoes.DeletarUsuarioException;

@SuppressWarnings("serial")
public class DeletaUsuarioServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deletaUsuario = req.getParameter("deletausuario");
		Long idUsuario = Long.parseLong(deletaUsuario);
		
		Biblioteca biblioteca = new Biblioteca();
		try {
			biblioteca.deleteUsuario(idUsuario);
			RequestDispatcher rd = req.getRequestDispatcher("/usuariodeletado.jsp");
			rd.forward(req, resp);
		} catch (DeletarUsuarioException e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("/usuarioexception.jsp");
			rd.forward(req, resp);
		}
	
	}
}