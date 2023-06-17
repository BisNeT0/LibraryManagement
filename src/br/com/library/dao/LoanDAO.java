package br.com.library.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import br.com.library.model.Loan;

public class LoanDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pmstmt;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/dblibrary");
	}

	private void createStatement() throws SQLException {
		this.stmt = this.conn.createStatement();
	}

	private void createPreparedStatemente(String query) throws SQLException {
		this.pmstmt = this.conn.prepareStatement(query);
	}

	private void disconnect() throws SQLException {
		if (this.stmt != null)
			this.stmt.close();
		if (this.pmstmt != null)
			this.pmstmt.close();
		if (this.conn != null)
			this.conn.close();
	}

	public void save(Loan loanSaver) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "INSERT INTO loan ("+
				 "user_id,"+
				 "book_id,"+
				 "data_emprestimo," +
				 "data_devolucao)" +
				 "VALUES (?,?,?,?)";
		createPreparedStatemente(query);
		this.pmstmt.setInt(1, loanSaver.getUser_id());
		this.pmstmt.setInt(2, loanSaver.getBook_id());
		this.pmstmt.setString(3, loanSaver.getDataEmprestimo());
		this.pmstmt.setString(4, loanSaver.getDataDevolucao());
		this.pmstmt.execute();
		this.disconnect();
	}
	
	public void update(Loan loanSaver) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "UPDATE loan SET"
				+ "user_id = ?,"
				+ "book_id = ?,"
				+ "data_emprestimo = ?,"
				+ "data_devolucao = ?"
				+ "WHERE loan_id = ?";
		this.pmstmt.setInt(1, loanSaver.getUser_id());
		this.pmstmt.setInt(2, loanSaver.getBook_id());
		this.pmstmt.setString(3, loanSaver.getDataEmprestimo());
		this.pmstmt.setString(4, loanSaver.getDataDevolucao());
		this.pmstmt.setInt(5, loanSaver.getId());
		this.pmstmt.execute();
		this.disconnect();
	}
	public void delete(int id) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "DELETE FROM loan WHERE id = ?";
		this.pmstmt.setInt(1, id);
		this.pmstmt.execute();
		this.disconnect();
	}
	public List<Loan> getAllLoan() throws ClassNotFoundException, SQLException{
		this.connect();
		this.createStatement();
		List <Loan> loan  = new ArrayList();
		String query = "SELECT * FROM loan";
		ResultSet rs = this.stmt.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt("loan_id");
			int user_id = rs.getInt("user_id");
			int book_id = rs.getInt("book_id");		 
			String data_emprestimo = rs.getString("data_emprestimo");
			String data_devolucao = rs.getString("data_devolucao");
			Loan emprestimo  = new Loan(id,user_id,book_id,data_emprestimo,data_devolucao);
			
			loan.add(emprestimo);
			
			this.disconnect();
		}
		return loan;
	}

}
