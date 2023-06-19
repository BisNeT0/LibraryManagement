package br.com.library.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.library.model.Book;
import br.com.library.model.Loan;
import br.com.library.model.User;

public interface Functions {
	//---------------------------------Book-----------------------------//

	public void save(Book bookSave) throws ClassNotFoundException, SQLException;
	public void update(Book bookUpdate) throws ClassNotFoundException, SQLException;
	public List <Book> getAllBooks() throws ClassNotFoundException, SQLException;
	//---------------------------------User-----------------------------//
	public void save(User xpto) throws ClassNotFoundException, SQLException;
    public void update(User xpto) throws ClassNotFoundException, SQLException;
    public List<User> getAllUser() throws ClassNotFoundException, SQLException;
    
    public void delete(int id) throws ClassNotFoundException, SQLException;
    //---------------------------------Loan-----------------------------//
    public void realizarEmprestimo(Loan loanSaver) throws ClassNotFoundException, SQLException;
    
    public void atualizarEmprestimo(Loan loanSaver) throws ClassNotFoundException, SQLException;
    
    public void deletarEmprestimo(int id) throws ClassNotFoundException, SQLException;
    
    public List<Loan> getAllLoan() throws ClassNotFoundException, SQLException;
}

