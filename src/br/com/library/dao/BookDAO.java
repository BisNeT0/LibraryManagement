package br.com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.library.model.Book;

public class BookDAO {
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

	public void save(Book bookSaver) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "INSERT INTO book (" + "titulo," + "autor," + "ano," + "editora," + "tipoLivro," + "secao)"
				+ "VALUES (?,?,?,?,?,?)";
		createPreparedStatemente(query);
		this.pmstmt.setString(1, bookSaver.getTitulo());
		this.pmstmt.setString(2, bookSaver.getAutor());
		this.pmstmt.setInt(3, bookSaver.getAno());
		this.pmstmt.setString(4, bookSaver.getEditora());
		this.pmstmt.setString(5, bookSaver.getTipoLivro());
		this.pmstmt.setString(6, bookSaver.getSecao());
		this.pmstmt.execute();
		this.disconnect();
	}

	public void update(Book bookUpdate) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "UPDATE book SET" + "titulo = ?," + "autor = ?," + "ano = ?," + "editora = ?," + "tipoLivro = ?,"
				+ "secao = ?" + "WHERE book_id = ?";
		this.createPreparedStatemente(query);
		this.pmstmt.setString(1, bookUpdate.getTitulo());
		this.pmstmt.setString(2, bookUpdate.getAutor());
		this.pmstmt.setInt(3, bookUpdate.getAno());
		this.pmstmt.setString(4, bookUpdate.getEditora());
		this.pmstmt.setString(5, bookUpdate.getTipoLivro());
		this.pmstmt.setString(6, bookUpdate.getSecao());
		this.pmstmt.setInt(7, bookUpdate.getId());
		this.pmstmt.execute();
		this.disconnect();

	}

	public void delete(int id) throws ClassNotFoundException, SQLException {
		this.connect();
		String query = "DELETE FROM book WHERE book_id = ?";
		this.createPreparedStatemente(query);
		this.pmstmt.setInt(1, id);
		this.pmstmt.execute();
		this.disconnect();

	}

	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
		this.connect();
		this.createStatement();

		List<Book> livro = new ArrayList();
		String query = "SELECT * FROM book";
		ResultSet rs = this.stmt.executeQuery(query);
		while (rs.next()) {
			int id = rs.getInt("book_id");
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			int ano = rs.getInt("ano");
			String editora = rs.getString("editora");
			String tipoLivro = rs.getString("tipoLivro");
			String secao = rs.getString("secao");

			Book book = new Book(id, titulo, autor, ano, editora, tipoLivro, secao);
			livro.add(book);
		}
		this.disconnect();
		return livro;

	}

}
