package br.com.library.model;

import java.util.Date;

public class Loan{
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private int id_user;
	private int id_book;
	
	public Loan() {}
	public Loan(int id_user,int id_book,Date dataEmprestimo, Date dataDevolucao) {
		this.id_user = id_user;
		this.id_book = id_book;
		this.dataDevolucao = dataDevolucao;
		this.dataEmprestimo = dataDevolucao;
	}
	public Loan(int id_user, int id_book) {
		this.id_user = id_user;
		this.id_book = id_book;
	}
	
	public Loan(Date dataEmprestimo, Date dataDevolucao) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	@Override
	public String toString() {
		return "Loan [dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", id_user=" + id_user
				+ ", id_book=" + id_book + "]";
	}
	
}
