package br.com.library.controller;
	import java.sql.*;
	import java.util.List;
import java.util.function.Function;

import br.com.library.dao.BookDAO;
	import br.com.library.model.Book;
	
	
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


}
