package entities;

public class Adm extends Pessoa {
	
	//classe herdada da classe Pessoas para a criação dos objetos "adm", já setados como "true"
	public Adm(String email, String nome, String senha) {
		super(email, nome, senha);
		super.setAdm();
	}
}
