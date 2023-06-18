package br.com.library.view;

import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.library.controller.BookController;
import br.com.library.controller.LoanController;
import br.com.library.controller.UserController;
import br.com.library.model.Book;
import br.com.library.model.Loan;
import br.com.library.model.User;


public class Program {

	public static void main(String[] args) throws Throwable, SQLException {
		UserController userBC = new UserController();
		BookController bookBC = new BookController();
		LoanController loanBC = new LoanController();
		
		User usuario = new User("Henrique","123.456.789-10","henrique@gmail.com","(75)9 9876-5432");
		userBC.save(usuario);
		User usuario2 = new User("Kaike","109.876.543-21","kaike@gmail.com","(75)9 1098-7654");
		userBC.save(usuario2);
		
//		User usuario = new User(1,"Thiago","8888888-888","thiago@gmail.com","(75)9 9999 9999");
//		userBC.update(usuario);
		
		Book livro = new Book("Além do bem e do mal","Nietzsche",1886,"Companhia de Bolso","Físico","Cientifico");
		bookBC.save(livro);
		Book livro2 = new Book("O Príncipe","Maquiavel",1532,"Edipro","Físico","Não-ficção");
		bookBC.save(livro2);
		
		//userBC.delete(0);
		
		
        LocalDateTime now = LocalDateTime.now();
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDateTime = now.format(formatter);

        String testeEntrega = "22/04/2024 15:45:08";
        
		Loan loan = new Loan(0,1,1,formattedDateTime,testeEntrega);
		loanBC.save(loan);
		
		List<User> listUser = userBC.getAllUser();
		for(User usua:listUser) {
			System.out.println(usua);
			
		}
		List<Book> listBooks = bookBC.getAllBooks();
		for(Book livr:listBooks) {
			System.out.println(livr);
			
		}
		
		List<Loan> listLoan = loanBC.getAllLoan();
		for(Loan loan2:listLoan) {
			
			JOptionPane.showMessageDialog(null, loan2);
			
		}
	}

	
}
