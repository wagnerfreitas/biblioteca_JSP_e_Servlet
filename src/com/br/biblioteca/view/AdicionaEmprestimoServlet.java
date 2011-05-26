package com.br.biblioteca.view;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.biblioteca.biblioteca.Biblioteca;
import com.br.biblioteca.entidades.Livro;
import com.br.biblioteca.entidades.Usuario;

@SuppressWarnings("serial")
public class AdicionaEmprestimoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idLivro = req.getParameter("IDLivro");
		String idUsuario = req.getParameter("IDUsuario");
		String dataEmTexto = req.getParameter("dataDeEmprestimo");
		Calendar dataDeEmprestimo = null;
		
		Long livro_id = Long.parseLong(idLivro);
		Long usuario_id = Long.parseLong(idUsuario);
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataDeEmprestimo = Calendar.getInstance();
			dataDeEmprestimo.setTime(data);
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data");
		}
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuario = biblioteca.pesquisaUsuarioPorID(usuario_id);
		Livro livro = biblioteca.pesquisaLivroPorID(livro_id);
		try {
			biblioteca.emprestaLivro(livro, usuario, dataDeEmprestimo);
		} catch (SQLException e) {
			System.out.println("Erro ao emprestar livro");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/adicionado.jsp");
		rd.forward(req, resp);
	}
}