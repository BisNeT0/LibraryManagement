package br.com.library.view;

import java.sql.SQLException;
import java.util.List;

import br.com.library.controller.BookController;
import br.com.library.controller.UserController;
import br.com.library.model.Book;
import br.com.library.model.Loan;
import br.com.library.model.User;

public class Program {

	public static void main(String[] args) throws Throwable, SQLException {
		UserController userBC = new UserController();
		BookController bookBC = new BookController();
		
		User usuario = new User("Henrique","123.456.789-10","henrique@gmail.com","(75)9 9876-5432");
		userBC.save(usuario);
		
//		User usuario = new User(1,"Thiago","8888888-888","thiago@gmail.com","(75)9 9999 9999");
//		userBC.update(usuario);
		
		Book livro = new Book(1,"Além do bem e do mal","Nietzsche",1886,"Companhia de Bolso","Físico");
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

	}

	
}
