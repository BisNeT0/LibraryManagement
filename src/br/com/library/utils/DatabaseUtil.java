package br.com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtil {
	private Connection conn;
	private Statement stmt;

	public void createUserDatabase() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/dblibrary");
            this.stmt = this.conn.createStatement();
            
            this.stmt.executeUpdate("CREATE TABLE user (id IDENTITY PRIMARY KEY,"+
            						" nome VARCHAR(50),"+
                                    " cpf VARCHAR(11), "+
                                    " email VARCHAR(50),"+
                                    " telefone VARCHAR(50));");
            
            System.out.println("Tabela user criada com sucesso."); 
            
			this.stmt.executeUpdate("CREATE TABLE book (id IDENTITY PRIMARY KEY,"+
                                    " titulo VARCHAR(100),"+
                                    " autor VARCHAR(100),"+
                                    " ano INTEGER," +
                                    " editora VARCHAR(30),"+
                                    " tipoLivro VARCHAR(20),"+
                                    " secao VARCHAR(200));");                      

			System.out.println("Tabela book criada com sucesso.");
            
			this.stmt.close();
            this.conn.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada");
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        	System.out.println("Tabela não encontrada");
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]){
        DatabaseUtil util = new DatabaseUtil();
        util.createUserDatabase();
    }
	
}
