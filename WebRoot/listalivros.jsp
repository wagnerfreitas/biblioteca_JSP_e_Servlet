<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.br.biblioteca.entidades.Livro"%>
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
		<title>Lista de Livros</title>
		<script type="text/javascript" src="js/jquery-1.5.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.13.custom.css" />
		
		<script type="text/javascript">
			$(document).ready(function(){
				$('.emprestar').click(function() {
					$('#devolverLivro').hide();
					$('#emprestarLivro').show();
					var text = $(this).parent().parent().children(':nth-child(2)').text()
					$('#IDLivro').val(text);
				});
				
				$('.devolver').click(function() {
					$('#emprestarLivro').hide();
					$('#devolverLivro').show();
					var text = $(this).parent().parent().children(':nth-child(2)').text()
					$('#IDLivro_devolver').val(text);
				});
				$('.calendario').datepicker($.datepicker.regional['fr']);
			});
		</script>
		<style>
			#emprestarLivro {
				display: none;
			}
			#devolverLivro{
				display:none;
			}
		
			.emprestar {
				width: 90px;
			}
			.devolver{
				width: 90px;
			}
		</style>
	</head>
	<body>
		<h1>
			Lista de Livros
		</h1>
		<table>
			<%
				String nome = request.getParameter("pesquisarLivro");
				String id = request.getParameter("IDLivro");
				Biblioteca biblioteca = new Biblioteca();
				List<Livro> livros = biblioteca.pesquisarLivro(nome);
				for (Livro livro : livros) {
			%>
			<tr>
				<td>- ID:</td>
				<td style="width:150px"><%=livro.getId()%></td>
				<td> - Nome: </td>
				<td style="width:220px"><%=livro.getNome()%></td>
				<td> - Autor: </td><td><%=livro.getAutor()%></td>
				<td>
				<%
					if (livro.isEmprestado()) {
				%>
					<input type="button" value="Devolver"  class="devolver"/>
				<%
					} else {
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
							<input type="text" class="calendario" name="dataDeEmprestimo" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="devolverLivro">
			<form method="post" action="devolvelivro">
			<h1>Devolver Livro</h1>
				<table>
					<tr>
						<td>
							ID do Livro: 
						</td>
						<td>
							<input type="text" readonly id="IDLivro_devolver" name="IDEmprestimo" />
						</td>
					</tr>
					<tr>
						<td>
							Digite a Data de Entrega: 
						</td>
						<td>
							<input type="text" class="calendario" name="dataDeEntrega" />
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