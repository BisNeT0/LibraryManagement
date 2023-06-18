package br.com.library.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.library.dao.LoanDAO;
import br.com.library.model.Book;
import br.com.library.model.Loan;
import br.com.library.model.User;

public class LoanController {
	private LoanDAO dao = new LoanDAO();
    public void save(Loan loanSaver) throws ClassNotFoundException, SQLException{
        dao.saveLoan(loanSaver);
    }
    
    public void update(Loan loanSaver) throws ClassNotFoundException, SQLException{
        dao.update(loanSaver);
    }
    
    public void delete(int id) throws ClassNotFoundException, SQLException{
        dao.delete(id);
    }
    
    public List<Loan> getAllLoan() throws ClassNotFoundException, SQLException{
        return dao.getAllLoan();
    }
}
