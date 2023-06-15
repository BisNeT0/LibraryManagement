package br.com.library.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.library.model.Book;

public interface Functions {

	public void save(Book bookSave) throws ClassNotFoundException, SQLException;
	public void update(Book bookUpdate) throws ClassNotFoundException, SQLException;
	public void delete(int id) throws ClassNotFoundException, SQLException;
	

	public List <Book> getAllBooks() throws ClassNotFoundException, SQLException;
	
}
