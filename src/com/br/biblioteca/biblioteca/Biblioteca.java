package com.br.biblioteca.biblioteca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.br.biblioteca.DAO.BibliotecaUtil;
import com.br.biblioteca.DAO.EmprestimoDAO;
import com.br.biblioteca.DAO.LivroDAO;
import com.br.biblioteca.DAO.UsuarioDAO;

import com.br.biblioteca.entidades.Emprestimo;
import com.br.biblioteca.entidades.Livro;
import com.br.biblioteca.entidades.Usuario;

public class Biblioteca {
	
	private LivroDAO livroDAO;
	private EmprestimoDAO emprestimoDAO;
	private UsuarioDAO usuarioDAO;
	private Session session;
	
	public Biblioteca(){
		session = new BibliotecaUtil().getSession();
		livroDAO = new LivroDAO(session);
		emprestimoDAO = new EmprestimoDAO(session);
		usuarioDAO = new UsuarioDAO(session);
	}
	public void cadastraUsuario(String nome, String email) throws IOException{
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuarioDAO.salva(usuario);
	}	
	public void cadastraLivro(String nome, String autor) throws IOException{
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);
		livroDAO.salva(livro);
	}
	public void emprestaLivro(Livro livro, Usuario usuario, Calendar dataDeEmprestimo) throws SQLException{
		Emprestimo emprestimo = new Emprestimo();
		livro.setEmprestado(true);
		emprestimo.setLivro(livro);
		emprestimo.setUsuario(usuario);
		emprestimo.setDataDeEmprestimo(dataDeEmprestimo);
		emprestimoDAO.salva(emprestimo);
	}	
	public void recebeLivro(Long id, Calendar dataDaDevolucao) throws SQLException{
		Emprestimo emprestimo = emprestimoDAO.procuraPorId(id);
		Livro livro = emprestimo.getLivro();
		livro.setEmprestado(false);
		emprestimo.setDataDeDevolucao(dataDaDevolucao);
		emprestimoDAO.atualiza(emprestimo);
	}
	public List<Usuario> pesquisarUsuarios(String pesquisaPorNome) throws IOException, SQLException{
		return usuarioDAO.procura(pesquisaPorNome);
	}
	public List<Livro> pesquisarLivro(String pesquisaPorNome) throws IOException, SQLException{
		return livroDAO.procuraPorNome(pesquisaPorNome);
	}
	public List<Emprestimo> pesquisaEmprestimoPorLivro(String nomeDoLivro) throws IOException, SQLException{
		return emprestimoDAO.procuraPorLivro(nomeDoLivro);
	}
	public Usuario pesquisaUsuarioPorID(Long id){
		return usuarioDAO.procuraPorId(id);
	}
	public Livro pesquisaLivroPorID(Long id) {
		return livroDAO.procuraPorId(id);
	}
}