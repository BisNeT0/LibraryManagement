package br.com.library.controller;
	import java.sql.*;
	import java.util.List;
import java.util.function.Function;

import br.com.library.dao.BookDAO;
	import br.com.library.model.Book;
import br.com.library.model.Loan;
import br.com.library.model.User;
	
	
public class BookController implements Functions {
private BookDAO bookDao = new BookDAO();
	
	public void save(Book bookSave) throws ClassNotFoundException, SQLException {
		bookDao.save(bookSave);
	}
	public void update(Book bookUpdate) throws ClassNotFoundException, SQLException {
		bookDao.update(bookUpdate);
		
	}
	public void delete(int id) throws ClassNotFoundException, SQLException {
		bookDao.delete(id);
		
	}
	public List <Book> getAllBooks() throws ClassNotFoundException, SQLException{
		return bookDao.getAllBooks();
	}

	@Override
	public void save(User xpto) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(User xpto) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void realizarEmprestimo(Loan loanSaver) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void atualizarEmprestimo(Loan loanSaver) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deletarEmprestimo(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Loan> getAllLoan() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
