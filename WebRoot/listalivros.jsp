<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.br.biblioteca.entidades.Livro"%>
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
		<title>Lista de Livros</title>
		<script type="text/javascript" src="js/jquery-1.5.2.min.js">
		</script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.emprestar').click(function() {
					$('#emprestarLivro').show();
					var text = $(this).parent().parent().children(':nth-child(2)').text()
					$('#IDLivro').val(text);
				});
			});
		</script>
	</head>
	<style>
		#emprestarLivro {
			display: none;
		}
		
		button {
				width: 100px;
		}
	</style>
	<body>
		<h1>
			Lista de Livros
		</h1>
		<table>
			<%
				String nome = request.getParameter("pesquisarLivro");
				Biblioteca biblioteca = new Biblioteca();
				List<Livro> livros = biblioteca.pesquisarLivro(nome); 
				
				for (Livro livro : livros) {
			%>
			<tr>
				<td>- ID:</td>
				<td style="width:150px"><%=livro.getId()%></td>
				<td> - Nome: </td>
				<td style="width:220px"><%=livro.getNome()%></td>
				<td> - Autor: </td><td><%=livro.getAutor() %></td>
				<td>
				<%
					if(livro.isEmprestado()){
				%>
					<input type="button" value="Devolver"  class="devolver"/>
				<%
					 }else{
				%>
				<input type="button" value="Emprestar" class="emprestar" /></td>
				<%
					}
				}
				%>
			</tr>
		</table>
		<a href="index.jsp">Voltar</a>
		<div id="emprestarLivro">
			<form method="post" action="adicionaemprestimo">
				<h1>
					Emprestar livro
				</h1>
				<table>
					<tr>
						<td>
							ID do livro:
						</td>
						<td>
							<input type="text" name="IDLivro" readonly id="IDLivro" />
						</td>
					</tr>
					<tr>
						<td>
							Digite o ID do usuário:
						</td>
						<td>
							<input type="text" name="IDUsuario" />
						</td>
					</tr>
					<tr>
						<td>
							Digite a data do empréstimo:
						</td>
						<td>
							<input type="text" name="dataDeEmprestimo" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Enviar" />
							<input type="hidden" name="emprestarlivro" value="emprestarlivro" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>