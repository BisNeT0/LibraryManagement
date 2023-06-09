package br.com.library.model;

public class Book {
	private int id;
	private String titulo;
	private String autor;
	private int ano;
	private String editora;
	private String tipoLivro;
	private String secao;
	
	public Book() {}
	
	public Book(int id, String titulo, String autor, int ano, String editora, String tipoLivro, String secao) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.editora = editora;
		this.tipoLivro = tipoLivro;
		this.secao = secao;
	}
	public Book(int id, String titulo, String autor, int ano, String editora, String tipoLivro) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.editora = editora;
		this.tipoLivro = tipoLivro;
	}
	public Book(String titulo, String autor, int ano, String editora, String tipoLivro) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.editora = editora;
		this.tipoLivro = tipoLivro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + 
				", titulo=" + titulo + 
				", autor=" + autor + 
				", ano=" + ano + 
				", editora=" + 
				editora
				+ ", tipoLivro=" + 
				tipoLivro + 
				", secao=" + 
				secao + "]";
	}
	
	
	
}
