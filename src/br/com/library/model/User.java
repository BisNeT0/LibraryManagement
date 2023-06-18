package br.com.library.model;

public class User extends Loan{
	private int id;
	private String nome,cpf,email,telefone;
	
	public User() {}

	public User(int id, String nome, String cpf, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	public User(String nome, String cpf, String email, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "DADOS DO USUÁRIO "+id+":"+"\n\n"
				+ "ID: "+id+"\n"
				+ "NOME: "+nome+"\n"
				+ "CPF: "+cpf+"\n"
				+ "E-MAIL: "+email+"\n"
				+ "TELEFONE: "+telefone
				+ "\n---------------------------------------\n";
	}
	
	
}
