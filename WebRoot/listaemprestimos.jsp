<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.br.biblioteca.biblioteca.Biblioteca"%>
<%@page import="com.br.biblioteca.entidades.Emprestimo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Lista de Empréstimos</title>
		<script type="text/javascript" src="js/jquery-1.5.2.min.js">
		</script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.devolver').click(function() {
					$('#devolverLivro').show();
					var text = $(this).parent().parent().children(':nth-child(2)').text()
					$('#IDEmprestimo').val(text);
				});
			});
		</script>
		<style type="text/css">
			#devolverLivro{
				display:none;
			}
		</style>
	</head>
	<body>
		<h1>Lista de Empréstimos</h1>
			<table>
				<%
					String nomeDoLivro = request.getParameter("pesquisarEmprestimo");
					Biblioteca biblioteca = new Biblioteca();
					List<Emprestimo> emprestimos = biblioteca.pesquisaEmprestimoPorLivro(nomeDoLivro); 
					
					for(Emprestimo emprestimo : emprestimos){
				%>
				<tr>
					<td>- ID:</td>
					<td style="width:150px"><%=emprestimo.getId()%></td>
					<td> - Nome: </td>
					<td style="width:220px"><%=emprestimo.getUsuario().getNome()%></td>
					<td> - Livro: </td><td><%=emprestimo.getLivro().getNome()%></td>
					<td><input type="button" value="Devolver" class="devolver" /></td>
				<%
					}
				%>		
				</tr>
			</table>
		<a href="index.jsp">Voltar</a>
		
		<div id="devolverLivro">
			<form method="post" action="devolvelivro">
			<h1>Devolver Livro</h1>
				<table>
					<tr>
						<td>
							ID do Empréstimo: 
						</td>
						<td>
							<input type="text" readonly id="IDEmprestimo" name="IDEmprestimo" />
						</td>
					</tr>
					<tr>
						<td>
							Digite a Data de Entrega: 
						</td>
						<td>
							<input type="text" name="dataDeEntrega" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Enviar" /></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>