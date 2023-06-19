package br.com.library.view;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
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
		User novoUsuario = new User();
		Book novoLivro = new Book();
		Loan novoEmprestimo = new Loan();
		
		
		
//		User usuario = new User(1,"Thiago","8888888-888","thiago@gmail.com","(75)9 9999 9999");
//		userBC.update(usuario);
		
		

		int sair =0;
		while(sair!=8) {
			
			int menu = Integer.parseInt(JOptionPane.showInputDialog("---------------[MENU]--------------- "
					+ "\n1- Cadastrar Usuário "
					+ "\n2- Listar Usuários "
					+ "\n3- Cadastrar Livro "
					+ "\n4- Listar Livros "
					+ "\n5- Realizar Empréstimo "
					+ "\n6- Listar Empréstimos "
					+ "\n7- Realizar Devolução "
					+ "\n8- SAIR"));
			
			switch(menu) {
			case 1:
				int n = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos usuários deseja cadastrar"));
				
				for(int i=0;i<n;i++) {
					novoUsuario.setNome(JOptionPane.showInputDialog("Digite o nome do usuário: \n"));
					novoUsuario.setCpf(JOptionPane.showInputDialog("Digite o CPF do usuário: \n"));
					novoUsuario.setEmail(JOptionPane.showInputDialog("Digite o e-mail do usuário: \n"));
					novoUsuario.setTelefone(JOptionPane.showInputDialog("Digite o telefone do usuário: \n"));
					userBC.save(novoUsuario);
				}
				break;
				
			case 2:
				
				for (int i=0;i<1;i++) {
					JOptionPane.showMessageDialog(null, userBC.getAllUser());
				}
				break;
			
			case 3:
				int m = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos livros deseja cadastrar"));
				
				for(int i=0;i<m;i++) {
					novoLivro.setTitulo(JOptionPane.showInputDialog("Digite o título do livro: \n"));
					novoLivro.setAutor(JOptionPane.showInputDialog("Digite o nome do autor do livro: \n"));
					novoLivro.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do livro: \n")));
					novoLivro.setEditora(JOptionPane.showInputDialog("Digite o nome da editora do livro: \n"));
					novoLivro.setTipoLivro(JOptionPane.showInputDialog("Digite o tipo do livro: \n"));
					novoLivro.setSecao(JOptionPane.showInputDialog("Digite a seção do livro: \n"));
					bookBC.save(novoLivro);
				}
				break;
			
			case 4:
				for (int i=0;i<1;i++) {
					JOptionPane.showMessageDialog(null, bookBC.getAllBooks());
				}
				break;
				
			case 5:
				novoEmprestimo.setUser_id(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que realizará o empréstimo:\n"+userBC.getAllUser())));
				novoEmprestimo.setBook_id(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do livro a ser emprestado:\n"+userBC.getAllBooks())));
				LocalDateTime now = LocalDateTime.now();
		        String pattern = "dd/MM/yyyy HH:mm:ss";
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		        String formattedDateTime = now.format(formatter);
		        novoEmprestimo.setDataEmprestimo(formattedDateTime);
		        novoEmprestimo.setDataDevolucao(JOptionPane.showInputDialog("Digite a data para devolução: (dd/MM/yyyy HH:mm:ss)\n")); 
		        loanBC.save(novoEmprestimo);
		        break;

			case 6:
				for (int i=0;i<1;i++) {
					JOptionPane.showMessageDialog(null, loanBC.getAllLoan());
				}
				break;
			case 7:
				
				int devolucaoEmprestimo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do empréstimo que será devoldido:\n" + loanBC.getAllLoan()));

				for (int i = 0; i < 1; i++) {
				    List<Loan> loanList = loanBC.getAllLoan();
				    boolean emprestimoEncontrado = false;

				    for (Loan emprestimo : loanList) {
				        if (devolucaoEmprestimo == emprestimo.getId()) {
				            loanBC.delete(devolucaoEmprestimo);
				            JOptionPane.showMessageDialog(null, "Empréstimo encerrado!");
				            emprestimoEncontrado = true;
				            break;
				        }
				    }

				    if (!emprestimoEncontrado) {
				        JOptionPane.showMessageDialog(null, "Empréstimo não encontrado!");
				    }
				}
				break;
			default:
				JOptionPane.showMessageDialog(null,"Obrigado por usar o nosso sistema. Até mais 👋");
				sair = 8;
				break;
			}
		}

	}

	
}
