package br.com.library.controller;

import java.sql.*;
import java.util.List;

import br.com.library.dao.UserDAO;
import br.com.library.model.Book;
import br.com.library.model.User;

public class UserController implements Functions{
private UserDAO dao = new UserDAO();
    
    public void save(User xpto) throws ClassNotFoundException, SQLException{
        dao.save(xpto);
    }
    
    public void update(User xpto) throws ClassNotFoundException, SQLException{
        dao.update(xpto);
    }
    
    public void delete(int id) throws ClassNotFoundException, SQLException{
        dao.delete(id);
    }
    
    public List<User> getAllUser() throws ClassNotFoundException, SQLException{
        return dao.getAllUser();
    }

	@Override
	public void save(Book bookSave) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book bookUpdate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
