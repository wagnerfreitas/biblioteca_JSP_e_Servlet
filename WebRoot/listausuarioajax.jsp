<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.br.biblioteca.biblioteca.Biblioteca"%>
<%@page import="com.br.biblioteca.entidades.Usuario"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table id="usuariosList">
	<%
		String nome = request.getParameter("pesquisarUsuario");
		Biblioteca biblioteca = new Biblioteca();
		List<Usuario> usuarios = biblioteca.pesquisarUsuarios(nome);
		for (Usuario usuario : usuarios) {
	%>
	<tr>
		<td>- ID: </td>
		<td><%=usuario.getId()%></td>
		<td>- Nome: </td>
		<td><%=usuario.getNome() %></td>
	</tr>
	<%	
		} 
	%>
</table>
