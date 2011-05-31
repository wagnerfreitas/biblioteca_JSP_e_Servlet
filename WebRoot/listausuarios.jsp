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
		<script type="text/javascript" src="js/jquery-1.5.2.min.js">
</script>
		<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js">
</script>
		<script type="text/javascript" src="js/jquery.ui.datepicker-pt-BR.js">
</script>
		<link rel="stylesheet" type="text/css"
			href="css/ui-lightness/jquery-ui-1.8.13.custom.css" />

		<style type="text/css">
			form{
				width:740px;
			}
			li {
				list-style: none;
				float: left;
			}
			.direita{
				float: right;
			}
		</style>

	</head>
	<body>
		<h1>
			Lista de Usu&aacute;rios
		</h1>
		<%
			String nome = request.getParameter("pesquisarUsuario");
			Biblioteca biblioteca = new Biblioteca();
			List<Usuario> usuarios = biblioteca.pesquisarUsuarios(nome);
			for (Usuario usuario : usuarios) {
		%>
		<div class="form">
			<form method="post" action="deletausuario">
				<ul>
					<li style="display: none"><%=usuario.getId()%></li>
					<li>- Nome:&nbsp;</li>
					<li style="width: 200px"><%=usuario.getNome()%></li>
					<li>- Email:&nbsp;</li>
					<li><%=usuario.getEmail()%></li>
				</ul>
				<ul>
					<li class="direita">
						<input type="hidden" class="deletausuario" name="deletausuario"	value="<%=usuario.getId()%>" />
						<input type="submit" class="enviar" value="Deletar" />
					</li>
				</ul>
			</form>
		</div>
		<br />
		<%
			}
		%>
		<a href="index.jsp">Voltar</a>
	</body>
</html>