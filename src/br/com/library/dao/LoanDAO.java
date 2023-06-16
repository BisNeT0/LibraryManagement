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
				 "id_user,"+
				 "id_book,"+
				 "data_emprestimo," +
				 "data_devolucao," +
				 "VALUES (?,?,?,?)";
		createPreparedStatemente(query);
		this.pmstmt.setString(1, loanSaver.getDataEmprestimo().toString());
		this.pmstmt.setString(2, loanSaver.getDataDevolucao().toString());
		this.pmstmt.execute();
		this.disconnect();
	}
	
	public void update(Loan loanSaver) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "UPDATE loan SET"
				+ "id_user = ?,"
				+ "id_book = ?,"
				+ "data_emprestimo = ?,"
				+ "data_devolucao = ?"
				+ "WHERE loan_id = ?";
		this.pmstmt.setString(1, loanSaver.getDataEmprestimo().toString());
		this.pmstmt.setString(1, loanSaver.getDataDevolucao().toString());
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
			int id_user = rs.getInt("id_user");
			int id_book = rs.getInt("id_book");		 
//			SimpleDateFormat stf1 = new SimpleDateFormat("dd/MM/yyyy");
//			SimpleDateFormat stf2 = new SimpleDateFormat("dd/MM/yyyy");
//			String data_emprestimo = stf1.toString();
//			String data_devolucao = stf2.toString();
			Date data_emprestimo = rs.getDate("data_emprestimo");
			Date data_devolucao = rs.getDate("data_devolucao");
			Loan emprestimo  = new Loan(id_user,id_book,data_emprestimo,data_devolucao);
			loan.add(emprestimo);
			
			this.disconnect();
		}
		return loan;
	}

}
