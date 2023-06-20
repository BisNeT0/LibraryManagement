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
		
		

		int sair =0,sairUsuario =0,sairLivro =0,sairEmprestimo =0;
		while(sair!=4) {
			
			int menu = Integer.parseInt(JOptionPane.showInputDialog("---------------[ LIBRARY MANAGEMENT 📖 ]--------------- "
					+ "\n1- Usuário "
					+ "\n2- Livro "
					+ "\n3- Empréstimo"
					+ "\n4- SAIR"));
				
			
			switch(menu) {
						
			case 1:
				while(sairUsuario!=3) {
					int opcaoUsuario = Integer.parseInt(JOptionPane.showInputDialog("---------------[USUÁRIO]---------------"
							+ "\n1- Cadastrar Usuário "
							+ "\n2- Listar Usuários "
							+ "\n3- Sair opção Usuário"));
					switch(opcaoUsuario) {
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
						JOptionPane.showMessageDialog(null,"Saindo da opção usuário...");
						sairUsuario = 3;
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opção inválida!");
					}	
				}
			break;	
			case 2:
				while(sairLivro!=5) {
					int opcaoLivro = Integer.parseInt(JOptionPane.showInputDialog("---------------[LIVRO]---------------"
							+ "\n1- Cadastrar Livro "
							+ "\n2- Listar Livros "
							+ "\n3- Procurar por título ou autor "
							+ "\n4- Excluir Livro "
							+ "\n5- Sair opção Livro "));
					switch(opcaoLivro) {
					
					case 1:
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
					case 2:
						for (int i=0;i<1;i++) {
							JOptionPane.showMessageDialog(null, bookBC.getAllBooks());
						}
						break;
					case 3:
						String procuraTituloAutor = JOptionPane.showInputDialog("Digite o título ou autor da obra a ser procurada:\n");
						
						List<Book> tituloAutorList = bookBC.getAllBooks();
						boolean tituloAutorEncontrado = false;
						
						for (Book tituloAutor : tituloAutorList) {
							if (procuraTituloAutor == tituloAutor.getTitulo()||procuraTituloAutor == tituloAutor.getAutor()) {
								tituloAutorEncontrado = true;
								break;
							}
						}
						
						if (tituloAutorEncontrado) {
							JOptionPane.showMessageDialog(null, bookBC.getAllBooks());
						} 
						
						if (!tituloAutorEncontrado) {
							JOptionPane.showMessageDialog(null, "Livro não encontrado!");
						}
						break;
					case 4:
						int exclusaoLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do livro a ser excluído:\n" + bookBC.getAllBooks()));
						
						List<Loan> loanList = loanBC.getAllLoan();
						boolean emprestimoEncontrado = false;
						
						for (Loan emprestimo : loanList) {
							if (exclusaoLivro == emprestimo.getBook_id()) {
								emprestimoEncontrado = true;
								break;
							}
						}
						
						if (emprestimoEncontrado) {
							JOptionPane.showMessageDialog(null, "Não é possível excluir o livro, pois existem empréstimos relacionados a ele!");
						} else {
							List<Book> bookList = bookBC.getAllBooks();
							boolean livroEncontrado = false;
							
							for (Book exclusao : bookList) {
								if (exclusaoLivro == exclusao.getId()) {
									bookBC.delete(exclusaoLivro);
									JOptionPane.showMessageDialog(null, "Livro excluído!");
									livroEncontrado = true;
									break;
								}
							}
							
							if (!livroEncontrado) {
								JOptionPane.showMessageDialog(null, "Livro não encontrado!");
							}
						}
						break;
					case 5:
						JOptionPane.showMessageDialog(null,"Saindo da opção Livro...");
						sairLivro = 5;
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opção inválida!");	
					}
					
				}
			break;
			case 3:
				while(sairEmprestimo!=4) {
					int opcaoEmprestimo = Integer.parseInt(JOptionPane.showInputDialog("---------------[EMPRÉSTIMO]---------------"
							+ "\n1- Realizar Empréstimo "
							+ "\n2- Listar Empréstimos "
							+ "\n3- Realizar Devolução "
							+ "\n4- Sair opção Empréstimo"));
					switch(opcaoEmprestimo) {
					
					case 1:
						novoEmprestimo.setUser_id(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário que realizará o empréstimo:\n"+userBC.getAllUser())));
						novoEmprestimo.setBook_id(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do livro a ser emprestado:\n"+userBC.getAllBooks())));
						LocalDateTime now = LocalDateTime.now();
						String pattern = "dd/MM/yyyy HH:mm:ss";
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
						String formattedDateTime = now.format(formatter);
						novoEmprestimo.setDataEmprestimo(formattedDateTime);
						novoEmprestimo.setDataDevolucao(JOptionPane.showInputDialog("Digite a data para devolução: (dd/MM/yyyy HH:mm:ss)\n")); 
						loanBC.realizarEmprestimo(novoEmprestimo);
						
						break;
					case 2:
						for (int i=0;i<1;i++) {
							JOptionPane.showMessageDialog(null, loanBC.getAllLoan());
						}
						
						break;
					case 3:
						int devolucaoEmprestimo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do empréstimo que será devoldido:\n" + loanBC.getAllLoan()));
						
						for (int i = 0; i < 1; i++) {
							List<Loan> loanList2 = loanBC.getAllLoan();
							boolean emprestimoEncontrado2 = false;
							
							for (Loan emprestimo : loanList2) {
								if (devolucaoEmprestimo == emprestimo.getId()) {
									loanBC.deletarEmprestimo(devolucaoEmprestimo);
									JOptionPane.showMessageDialog(null, "Empréstimo encerrado!");
									emprestimoEncontrado2 = true;
									break;
								}
							}
							
							if (!emprestimoEncontrado2) {
								JOptionPane.showMessageDialog(null, "Empréstimo não encontrado!");
							}
						}
						break;
					case 4:
						JOptionPane.showMessageDialog(null,"Saindo da opção Empréstimo...");
						sairEmprestimo = 4;
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opção inválida!");		
					}
					
				}
			break;
			default:
				JOptionPane.showMessageDialog(null,"Obrigado por usar o nosso sistema. Até mais 👋");
				sair = 4;
				break;
			}
		}

	}

	
}
