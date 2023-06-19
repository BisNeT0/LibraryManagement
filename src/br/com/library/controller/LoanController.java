package br.com.library.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.library.dao.LoanDAO;
import br.com.library.model.Book;
import br.com.library.model.Loan;
import br.com.library.model.User;

public class LoanController implements Functions{
	private LoanDAO dao = new LoanDAO();
    public void realizarEmprestimo(Loan loanSaver) throws ClassNotFoundException, SQLException{
        dao.saveLoan(loanSaver);
    }
    
    public void atualizarEmprestimo(Loan loanSaver) throws ClassNotFoundException, SQLException{
        dao.update(loanSaver);
    }
    
    public void deletarEmprestimo(int id) throws ClassNotFoundException, SQLException{
        dao.delete(id);
    }
    
    public List<Loan> getAllLoan() throws ClassNotFoundException, SQLException{
        return dao.getAllLoan();
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
	public void delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
}
