package entities;

import java.util.ArrayList;

//classe mãe onde todas as pessoas (aluno ou adm) são criadas
public abstract class Pessoa {
	private String nome, email, senha;
	private boolean adm;

	public Pessoa(String email, String nome, String senha) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.adm = false;
	}

	// arraylist de pessoas
	private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

	public boolean isAdm() {
		return adm;
	}

	// setAdm para true para a criação da classe Adm
	public void setAdm() {
		this.adm = true;
	}

	public static ArrayList<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public static void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
		Pessoa.listaPessoas = listaPessoas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static void add(Pessoa pessoas) {
		listaPessoas.add(pessoas);
	}

	/*
	 * metodo equals que verifica um atributo do objeto (no caso email e senha) ja
	 * esta inserido no arraylist
	 * 
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa qualquer = (Pessoa) obj;
			return this.email.equals(qualquer.getEmail()) && this.senha.equals(qualquer.getSenha());
		} else {
			return false;
		}
	}

	public boolean equalsEmail(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa qualquer = (Pessoa) obj;
			return this.email.equals(qualquer.getEmail());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return email + " (adm= " + adm + ")";
	}

}
