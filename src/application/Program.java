package application;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import entities.Adm;
import entities.Aluno;
import entities.Elogio;
import entities.Manifestacoes;
import entities.Pessoa;
import entities.Reclamacao;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Adm admin = new Adm("kamilaqz@hotmail.com", "Kamila", "1234");
		Adm.add(admin);

		// loop do primeiro menu
		int l = 1;
		while (l > 0) {
			System.out.println("\n----------------------------------------------------");
			System.out.println("Bem-vindo(a) a ouvidoria!");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Logar");
			System.out.println("3 - Sair");
			int opt = 0;

			
			/*todos os try-catch neste sistema são para tratar as exceçôes
			 * que podem aparecer caso o usuario não digitar um numero  
			 * inteiro pré-estabelecido quando pedido.
			 */
			try {
				opt = Integer.parseInt(input.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("Digite uma das opções.");
			} catch (NumberFormatException e) {
				System.out.println("Digite uma das opçôes.");
			}

			// cadastro de alunos no sistema atraves do meu metodo ADD		
			if (opt == 1) {
				System.out.print("Qual seu nome? ");
				String nome = input.nextLine();
				System.out.print("Digite seu e-mail: ");
				String email = input.nextLine();
				System.out.print("Digite sua senha: ");
				String senha = input.nextLine();
				Aluno alunos = new Aluno(email, nome, senha);
				Aluno.add(alunos);
				System.out.println("Usuario cadastrado com sucesso!");

				// logar no sistema
			} else if (opt == 2) {
				System.out.println("\n----------------------------------------------------");
				System.out.println("Logar como: ");
				System.out.println("1 - Administrador");
				System.out.println("2 - Aluno");
				int cargo = 0;

				try {
					cargo = Integer.parseInt(input.nextLine());
				} catch (InputMismatchException e) {
					System.out.println("Digite uma das opções.");
				} catch (NumberFormatException e) {
					System.out.println("Digite uma das opçôes.");
				}

				if (cargo == 1) {
					System.out.print("Digite seu e-mail: ");
					String emaillog = input.nextLine();
					System.out.print("Digite sua senha: ");
					String senhalog = input.nextLine();
					Adm admlog = new Adm(emaillog, null, senhalog);

					/*
					 * o metodo contains analisa se o email e a senha inseridas foram cadastradas
					 * atraves do meu metodo equals, que faz a comparação
					 * 
					 */
					if (Pessoa.getListaPessoas().contains(admlog)) {
						System.out.println("Acesso liberado!");

						int j = 1;
						while (j > 0) {
							System.out.println("\n----------------------------------------------------");
							System.out.printf("\nOla, %s. Bem-vindo(a) a ouvidoria!", emaillog);
							System.out.println("\nO que deseja fazer hoje?\n");
							System.out.println("1 - Registrar manifestacao");
							System.out.println("2 - Listar manifestacoes");
							System.out.println("3 - Apagar manifestacao especifica");
							System.out.println("4 - Apagar todas as manifestacoes");
							System.out.println("5 - Sair do menu\n");
							int numero = 0;

							try {
								numero = Integer.parseInt(input.nextLine());
							} catch (NumberFormatException e) {
								System.out.println("Digite uma das opçôes.");
							} catch (NoSuchElementException e) {
								System.out.println("Digite uma das opções.");
							}

							switch (numero) {
							case 1:
								System.out.print("\n1 - Reclamacao");
								System.out.println("\n2 - Elogio");
								System.out.print("Qual sera o tipo da manifestacao? ");
								try {
									int t = Integer.parseInt(input.nextLine());

									if (t == 1) {
										System.out.print("Manifestacao: ");
										String texto = input.nextLine();
										Reclamacao rec = new Reclamacao(texto, null, admlog);
										Manifestacoes.add(rec);
										System.out.println("Reclamacao cadastrada com sucesso!");
									} else if (t == 2) {
										System.out.print("Manifestacao: ");
										String texto = input.nextLine();
										Elogio elo = new Elogio(texto, null, admlog);
										Manifestacoes.add(elo);
										System.out.println("Elogio cadastrado com sucesso!");
									} else {
										System.out.println("Digite uma opcao valida.");
									}
								} catch (InputMismatchException e) {
									System.out.println("Digite uma das opções.");
								} catch (NumberFormatException e) {
									System.err.println("Digite uma das opçôes.");
								}
								break;
							case 2:
								System.out.print("\n1 - Reclamacao");
								System.out.println("\n2 - Elogio");
								System.out.println("3 - Aluno(a) especifico(a)");
								System.out.print("Qual tipo deseja listar? ");
								try {
									int p = Integer.parseInt(input.nextLine());

									/*
									 * opcoes de listar por tipo de manifestacao atravess dos metodos especificos de
									 * listagem onde eu passo os parametros dos tipos ou do aluno a ser pesquisado
									 * 
									 */
									if (p == 1) {
										System.out.println(Manifestacoes.listType("reclamacao"));
									} else if (p == 2) {
										System.out.println(Manifestacoes.listType("elogio"));
									} else if (p == 3) {
										System.out.println(
												"Digite o e-mail do(a) aluno(a) ao qual deseja listar as manifestacoes: ");
										String emailAluno = input.nextLine();
										System.out.println(Manifestacoes.listEspecific(emailAluno));
									} else {
										System.out.println("Digite uma opcao valida.");
									}
								} catch (InputMismatchException e) {
									System.out.println("Digite uma das opções.");
								} catch (NumberFormatException e) {
									System.err.println("Digite uma das opçôes.");
								}
								break;
							case 3:
								// listagem geral das manifestacoes
								System.out.println(Manifestacoes.list());
								if (!Manifestacoes.listaManifestacoes.isEmpty()) {
									System.out.print("Selecione a manifestacao que deseja apagar: ");

									/*este try-catch trata a exceção IndexOutOfBounds, para quando for
									 * digitado um indice que não existe no arraylist.S
									 */
									try {
										int i = Integer.parseInt(input.nextLine());
										
										// metodo que apaga a manifestacao escolhida pelo usuario atraves do indice
										Manifestacoes.removeOne(i);
										System.out.println("Manifestação apagada com sucesso!");
									} catch (IndexOutOfBoundsException e) {
										System.out.println("Digite uma das opções acima.");
									} catch (NumberFormatException e) {
										System.out.println("Digite uma das opções acima.");
									} catch (InputMismatchException e) {
										System.out.println("Digite uma opção válida.");
									}
								} else {
									continue;
								}
								break;
							case 4:
								/*
								 * opcao que apaga todas as manifestacoes de cada tipo ou entao de um aluno
								 * especifico atraves dos metodos RemoveAll
								 */
								System.out.print("\n1 - Reclamacao");
								System.out.println("\n2 - Elogio");
								System.out.println("3 - Aluno(a) especifico(a)");
								System.out.print("Qual tipo deseja apagar tudo? ");
								try {
									int o = Integer.parseInt(input.nextLine());

									if (o == 1) {
										Manifestacoes.removeAllType("reclamacao");
									} else if (o == 2) {
										Manifestacoes.removeAllType("elogio");
									} else if (o == 3) {
										System.out.println(
												"Digite o e-mail do aluno ao qual deseja apagar as manifestacoes: ");
										String emailAluno = input.nextLine();
										Manifestacoes.removeAllEspecific(emailAluno);
									} else {
										System.out.println("Digite uma opcao valida.");
									}
								} catch (InputMismatchException e) {
									System.out.println("Digite uma das opções.");
								} catch (NumberFormatException e) {
									System.err.println("Digite uma das opçôes.");
								}
								break;
							case 5:
								j = 0;
								System.out.println("Saindo...");
								break;
							default:
								System.out.println("Voce digitou uma opcao invalida.");
								break;
							}
						}
						// o adm digitou seus dados errados
					} else {
						System.out.println("Acesso negado. Cadastre-se para fazer login.");
					}

					// menu do aluno
				} else if (cargo == 2) {
					System.out.print("Digite seu e-mail: ");
					String emaillog = input.nextLine();
					System.out.print("Digite sua senha: ");
					String senhalog = input.nextLine();
					Aluno alunolog = new Aluno(emaillog, null, senhalog);
					if (Pessoa.getListaPessoas().contains(alunolog)) {
						System.out.println("Acesso liberado!");

						int k = 1;
						while (k > 0) {
							System.out.println("\n----------------------------------------------------");
							System.out.printf("\nOla, %s. Bem-vindo(a) a ouvidoria!", emaillog);
							System.out.println("\nO que deseja fazer hoje?\n");
							System.out.println("1 - Registrar manifestacao");
							System.out.println("2 - Listar manifestacoes");
							System.out.println("3 - Sair do menu\n");

							try {
								int numero = Integer.parseInt(input.nextLine());

								switch (numero) {
								case 1:
									System.out.print("\n1 - Reclamacao");
									System.out.println("\n2 - Elogio");
									System.out.print("Qual sera o tipo da manifestacao? ");

									try {
										int t = Integer.parseInt(input.nextLine());

										if (t == 1) {
											System.out.print("Manifestacao: ");
											String texto = input.nextLine();
											Reclamacao rec = new Reclamacao(texto, null, alunolog);
											Manifestacoes.add(rec);
											System.out.println("Reclamacao cadastrada com sucesso!");
										} else if (t == 2) {
											System.out.print("Manifestacao: ");
											String texto = input.nextLine();
											Elogio elo = new Elogio(texto, null, alunolog);
											Manifestacoes.add(elo);
											System.out.println("Elogio cadastrado com sucesso!");
										} else {
											System.out.println("Voce digitou uma opcao invalida.");
										}
									} catch (Exception e) {
										System.out.println("Voce digitou uma opcao invalida.");
									}
									break;
								case 2:
									// metodo listEspecific que lista apenas as manifestacoes do aluno logado
									System.out.println(Manifestacoes.listEspecific(emaillog));
									break;
								case 3:
									k = 0;
									System.out.println("Saindo...");
									break;
								default:
									System.out.println("Voce digitou uma opcao invalida");
									break;
								}
							} catch (NumberFormatException e) {
								System.out.println("Digite uma das opçôes.");
							} catch (NoSuchElementException e) {
								System.out.println("Digite uma das opções.");
							}
						}
						// o aluno nao fez cadastro ou entao digitou seus dados errados
					} else {
						System.out.println("Acesso negado. Cadastre-se para fazer login.");
						continue;
					}
				} else {
					System.out.println("Voce digitou uma opcao invalida.");
				}

			} else if (opt == 3) {
				l = 0;
				System.out.println("Saindo... \nAgradecemos por utilizar a ouvidoria!");
			} else {
				System.out.println("Voce digitou uma opcao invalida.");
			}

		}
		input.close();

	}
}
