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

@SuppressWarnings("serial")
public class DevolveLivroServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String IDEmprestimo = req.getParameter("IDEmprestimo");
		String dataEmTexto = req.getParameter("dataDeEntrega");
		Calendar dataDeEntrega = null;
		
		Long id = Long.parseLong(IDEmprestimo);
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataDeEntrega = Calendar.getInstance();
			dataDeEntrega.setTime(data);
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data");
		}
		Biblioteca biblioteca = new Biblioteca();
		try {
			biblioteca.recebeLivro(id, dataDeEntrega);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("/adicionado.jsp");
		rd.forward(req, resp);
	}
}
