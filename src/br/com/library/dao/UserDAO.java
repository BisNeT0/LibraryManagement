package br.com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.library.model.User;


public class UserDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    private void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/dblibrary");
    }
    
    private void createStatement() throws SQLException{
         this.stmt = this.conn.createStatement();
    }
    
    private void createPreparedStatement(String query) throws SQLException{
         this.pstmt = this.conn.prepareStatement(query);
    }
    
    private void disconnect() throws SQLException{
        if(this.pstmt != null)
            this.pstmt.close();
        if(this.stmt != null)
            this.stmt.close();
        if(this.conn != null)
            this.conn.close();
    }
        
    public void save(User userSave) throws ClassNotFoundException, SQLException{
       this.connect();
       String query = "INSERT INTO user "
               + "(nome, cpf, email, telefone) "
               + "VALUES (?,?,?,?)";
       this.createPreparedStatement(query);
       this.pstmt.setString(1, userSave.getNome());
       this.pstmt.setString(2, userSave.getCpf());
       this.pstmt.setString(3, userSave.getEmail());
       this.pstmt.setString(4, userSave.getTelefone());
       this.pstmt.execute();
       this.disconnect();
    }
    
    public void update(User userUpdate) throws SQLException, ClassNotFoundException{
        this.connect();
       String query = "UPDATE user "
               + "set nome =?, cpf=?, email=?, telefone=? "
               + "WHERE id = ?";
       this.createPreparedStatement(query);
       this.pstmt.setString(1, userUpdate.getNome());
       this.pstmt.setString(2, userUpdate.getCpf());
       this.pstmt.setString(3, userUpdate.getEmail());
       this.pstmt.setString(4, userUpdate.getTelefone());
       this.pstmt.setInt(5,userUpdate.getId());
       this.pstmt.execute();
       this.disconnect();
       
    }
    
    public void delete(int id) throws ClassNotFoundException, SQLException{
       this.connect();
       String query = "DELETE FROM user "
               + "WHERE id = ?";
       this.createPreparedStatement(query);
       this.pstmt.setInt(1, id);
       this.pstmt.execute();
       this.disconnect();
    }
    
    public List<User> getAllUser()throws ClassNotFoundException, SQLException{
        this.connect();
        this.createStatement();
        List<User> usuario = new ArrayList();
        String query = "SELECT * FROM user;";
        ResultSet rs = this.stmt.executeQuery(query);
        while(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            User user = new User(id, nome, cpf, email, telefone);
            usuario.add(user);
            
        }
        this.disconnect();
        return usuario;
    }
}
