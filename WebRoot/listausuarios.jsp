<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.br.biblioteca.entidades.Usuario"%>
<%@page import="com.br.biblioteca.biblioteca.Biblioteca"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Lista de Usuários</title>
	</head>
	<body>
		<h1>
			Lista de Usuários
		</h1>
		<table>
			<%
					String nome = request.getParameter("pesquisarUsuario");
					Biblioteca biblioteca = new Biblioteca(); 
					List<Usuario> usuarios =  biblioteca.pesquisarUsuarios(nome);					

					for (Usuario usuario : usuarios) {
						out.println("<tr>");
						out.println("<td>- ID:</td>" + "<td style=\"width:150px\">"
								+ usuario.getId() + "</td>" + "<td> - Nome: </td>"
								+ "<td style=\"width:220px\">" + usuario.getNome()
								+ "</td>" + "<td> - Email: </td>" + "<td>"
								+ usuario.getEmail() + "</td>");
						out.println("</tr>");
					}
			%>
		</table>
		<a href="index.jsp">Voltar</a>
	</body>
</html>