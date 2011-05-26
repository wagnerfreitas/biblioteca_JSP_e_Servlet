<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Biblioteca</title>
		<style>
			#geral {
				width: 600px;
				margin: 0 auto;
				text-align: center;
			}
			
			#adicionarUsuario,#pesquisarUsuario,#adicionarLivro,#pesquisarLivro,#pesquisarEmprestimo {
				display: none;
			}
			
			button {
				width: 100px;
			}
			
			.celulaDivisoria {
				width: 70px;
			}
			
			#tabela{
				border-bottom:1px dotted red;
			}
			
		</style>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/jquery-1.5.2.min.js">	</script>
		<script type="text/javascript">
			var adicionarUsuario = function() {
				$('form').hide();
				$('form#adicionarUsuario').show();
			}
			var adicionarLivro = function() {
				$('form').hide();
				$('form#adicionarLivro').show();
			}
			var pesquisarUsuario = function() {
				$('form').hide();
				$('form#pesquisarUsuario').show();
			}
			var pesquisarLivro = function() {
				$('form').hide();
				$('form#pesquisarLivro').show();
			}
			var pesquisarEmprestimo = function() {
				$('form').hide();
				$('form#pesquisarEmprestimo').show();
			}
		</script>
	</head>

	<body>
		<div id="geral">
			<h1>
				Biblioteca
			</h1>
			O que deseja fazer?
			<table id="tabela">
				<tr>
					<td>
						Adicionar novo usuário:
					</td>
					<td>
						<button onclick="adicionarUsuario()">
							Adicionar
						</button>
					</td>
					<td class="celulaDivisoria">
					</td>
					<td width="150px">
						Adicionar novo livro:
					</td>
					<td>
						<button onclick="adicionarLivro()">
							Adicionar
						</button>
					</td>
				</tr>
				<tr>
					<td>
						Pesquisar usu&aacute;rio:
					</td>
					<td>
						<button onclick="pesquisarUsuario()">
							Pesquisar
						</button>
					</td>
					<td class="celulaDivisoria">
					</td>
					<td>
						Pesquisar livro:
					</td>
					<td>
						<button onclick="pesquisarLivro()">
							Pesquisar
						</button>
					</td>
				</tr>
				<tr>
					<td>
						Pesquisar empr&eacute;stimos:
					</td>
					<td>
						<button onclick="pesquisarEmprestimo()">
							Pesquisar
						</button>
					</td>
					<td class="celulaDivisoria">
					</td>
				</tr>
			</table>

			<form id="adicionarUsuario" method="post" action="adicionausuario">
				<h1>
					Usuário
				</h1>
				<table>
					<tr>
						<td>
							Nome:
						</td>
						<td>
							<input type="text" name="nomeUsuario" />
						</td>
					</tr>
					<tr>
						<td>
							Email:
						</td>
						<td>
							<input type="text" name="email" />
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
			<form id="adicionarLivro" method="post" action="adicionalivro">
				<h1>
					Livro
				</h1>
				<table>
					<tr>
						<td>
							Nome:
						</td>
						<td>
							<input type="text" name="nomeLivro" />
						</td>
					</tr>
					<tr>
						<td>
							Autor:
						</td>
						<td>
							<input type="text" name="autor" />
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
			<form id="pesquisarUsuario" method="post" action="listausuarios.jsp">
				<h1>Pesquisar</h1>
				<table>
					<tr>
						<td>
							Digite o nome do usuário:
						</td>
						<td>
							<input type="text" name="pesquisarUsuario" />
						</td>
						<td>
							<input type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
			</form>
			<form id="pesquisarLivro" method="post" action="listalivros.jsp">
				<h1>
					Pesquisar
				</h1>
				<table>
					<tr>
						<td>
							Digite o nome do livro:
						</td>
						<td>
							<input type="text" name="pesquisarLivro" />
						</td>
						<td>
							<input type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
			</form>
			<form id="pesquisarEmprestimo" method="post" action="listaemprestimos.jsp">
				<h1>Pesquisar</h1>
				<table>
					<tr>
						<td>
							Pesquisar empréstimo por livro:
						</td>
						<td>
							<input type="text" name="pesquisarEmprestimo" />
						</td>
						<td>
							<input type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>