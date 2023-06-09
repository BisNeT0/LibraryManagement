package br.com.library.model;


public class Loan{
	private int id;
	private int user_id;
	private int book_id;
	private String dataEmprestimo;
	private String dataDevolucao;
	
	public Loan() {}
	

	public Loan(int id, int user_id,int book_id,String dataEmprestimo, String dataDevolucao) {
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	
	public Loan(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public String getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public String getDataDevolucao() {
		return dataDevolucao;
	}


	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	@Override
	public String toString() {
		return 
				"DADOS DO EMPRÉSTIMO "+id+":"+"\n\n"
				+ "ID: "+id+"\n"
				+ "ID DO USUÁRIO: "+user_id+"\n"
				+ "ID DO LIVRO: "+book_id+"\n"
				+ "DATA DE EMPRÉSTIMO: "+dataEmprestimo+"\n"
				+ "DATA PARA DEVOLUÇÃO: "+dataDevolucao
				+ "\n--------------------------------------------------------------\n";

	}


	
	


	
}
