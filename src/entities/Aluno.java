package entities;

public class Aluno extends Pessoa {

	//classe herdada de Pessoa para alunos, setada para "false" para Adm
	public Aluno(String email, String nome, String senha) {
		super(email, nome, senha);
	}
	
}

