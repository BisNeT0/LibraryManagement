package br.com.library.view;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
		
//		User usuario = new User(1,"Thiago","8888888-888","thiago@gmail.com","(75)9 9999 9999");
//		userBC.update(usuario);
		
		Book livro = new Book("Além do bem e do mal","Nietzsche",1886,"Companhia de Bolso","Físico","Cientifico");
		bookBC.save(livro);
		
		//userBC.delete(0);
		
		
		List<User> listUser = userBC.getAllUser();
		for(User usuario2:listUser) {
			System.out.println(usuario2);

		}
		List<Book> listBooks = bookBC.getAllBooks();
		for(Book livro2:listBooks) {
			System.out.println(livro2);
			
		}
        // Obtém a data e hora atual
        LocalDateTime now = LocalDateTime.now();

        // Define o padrão desejado
        String pattern = "dd/MM/yyyy HH:mm:ss";

        // Cria um DateTimeFormatter com o padrão especificado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // Formata a data e hora atual usando o formatter
        String formattedDateTime = now.format(formatter);

        // Imprime a data e hora formatada
        //System.out.println(formattedDateTime);

		Loan loan = new Loan(0,0,formattedDateTime);
		loanBC.save(loan);
		
		List<Loan> loanList = loanBC.getAllLoan();
		for(Loan loan2:loanList) {
			System.out.println(loan2);
			
		}
	}

	
}
