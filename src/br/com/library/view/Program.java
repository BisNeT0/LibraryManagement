package br.com.library.view;

import java.sql.SQLException;
import java.util.List;

import br.com.library.controller.UserController;
import br.com.library.model.User;

public class Program {

	public static void main(String[] args) throws Throwable, SQLException {
		UserController userBC = new UserController();
		
		User usuario = new User("Henrique","123123123","henrique@gmail.com","(75)9 9999 9999");
		userBC.save(usuario);
		
		//User usuario = new User(1,"Thiago","8888888-888","thiago@gmail.com","(75)9 9999 9999");
		//userBC.update(usuario);
		
		//userBC.delete(0);
		
		
		List<User> listUser = userBC.obterTodosUsuarios();
		for(User usuario2:listUser) {
			System.out.println(usuario2);

		}
	}

	
}
