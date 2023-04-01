package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Manifestacoes {
	private String texto, tipo;
	private Pessoa autor;

	public static ArrayList<Manifestacoes> listaManifestacoes = new ArrayList<>();

	public Manifestacoes(String texto, String tipo, Pessoa autor) {
		this.texto = texto;
		this.tipo = tipo;
		this.autor = autor;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	public static ArrayList<Manifestacoes> getListaManifestacoes() {
		return listaManifestacoes;
	}

	public static void setListaManifestacoes(ArrayList<Manifestacoes> listaManifestacoes) {
		Manifestacoes.listaManifestacoes = listaManifestacoes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Manifestação: \nOcorrencia= " + texto + ", Tipo= " + tipo + "\n" + "Autor: " + autor + ";" + "\n";
	}

	/*
	 * metodo que lista e enumera todas as manifestacoes, sem exceçoes
	 *
	 */
	public static String list() {
		if (!Manifestacoes.listaManifestacoes.isEmpty()) {
			String retorno = "";
			for (int i = 0; i < listaManifestacoes.size(); i++) {
				retorno += String.format("%d) %s", (i + 1), listaManifestacoes.get(i));
			}
			return retorno;
		} else {
			return "Nenhuma manifestacao cadastrada.";
		}
	}

	/*
	 * metodo que lista e enumera as manifestacoes por tipo é criada uma lista com
	 * os componentes da pesquisa na pesquisa, eu transformo o arraylist em stream
	 * para realizar o filtro das manifestacoes por tipo. no final, tranformo para
	 * lista o resultado e a enumero
	 * 
	 */
	public static String listType(String tipo) {
		if (!Manifestacoes.listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesPorTipo = Manifestacoes.listaManifestacoes.stream()
					.filter(x -> x.getTipo().equals(tipo)).toList();
			if (!manifestacoesPorTipo.isEmpty()) {
				String retorno = "";
				for (int i = 0; i < manifestacoesPorTipo.size(); i++) {
					retorno += String.format("%d) %s", (i + 1), manifestacoesPorTipo.get(i).toString());
				}
				return retorno;
			} else {
				return "Ainda nao ha manifestacoes para sua busca.";
			}
		} else {
			return "Nenhuma manifestacao cadastrada.";
		}
	}

	/*
	 * metodo que lista e enumera as menifestacoes por aluno especifico, da mesma
	 * forma que o metodo anterior
	 * 
	 */
	public static String listEspecific(String email) {
		if (!Manifestacoes.listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesEspecificas = Manifestacoes.listaManifestacoes.stream()
					.filter(x -> x.getAutor().getEmail().equals(email)).toList();
			if (!manifestacoesEspecificas.isEmpty()) {
				String retorno = "";
				for (int i = 0; i < manifestacoesEspecificas.size(); i++) {
					retorno += String.format("%d) %s", (i + 1), manifestacoesEspecificas.get(i).toString());
				}
				return retorno;
			} else {
				return "Ainda nao ha manifestacoes para sua busca.";
			}
		} else {
			return "Nenhuma manifestacao cadastrada.";
		}
	}

	/*
	 * metodo que adiciona a manifestacao no arraylist
	 * 
	 */
	public static void add(Manifestacoes manifestacao) {
		listaManifestacoes.add(manifestacao);
	}

	/*
	 * metodo que remove manifestacao especifica por indice int
	 */
	public static void removeOne(int i) {
		listaManifestacoes.remove(i - 1);

	}

	/*
	 * meotodo que remove todas as maninfestacoes por tipo (reclamacao ou elogio)
	 * atraves do predicado onde eu busco as manifestacoes com o tipo que passei
	 * como parametro
	 */
	public static void removeAllType(String tipo) {
		if (!Manifestacoes.listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesTipo = Manifestacoes.listaManifestacoes.stream()
					.filter(x -> x.getTipo().equals(tipo)).toList();
			if (!manifestacoesTipo.isEmpty()) {
				Manifestacoes.listaManifestacoes.removeIf(x -> x.getTipo().equals(tipo));
				System.out.println("Manifestações apagadas com sucesso!");
			} else {
				System.out.println("Não há manifestações para este tipo.");
			}

		} else {
			System.out.println("Não há manifestações cadastradas.");
		}
	}

	/*
	 * metodo que remove todas as manifestacoes por aluno especifico atraves do
	 * predicado onde eu busco o email que foi passado como parametro para isso,
	 * criei uma lista apenas para checar a presença do aluno no arraylist
	 */
	public static void removeAllEspecific(String email) {
		if (!Manifestacoes.listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesAluno = Manifestacoes.listaManifestacoes.stream()
					.filter(x -> x.getAutor().getEmail().equals(email)).toList();
			if (!manifestacoesAluno.isEmpty()) {
				Manifestacoes.listaManifestacoes.removeIf(x -> x.getAutor().getEmail().equals(email));
				System.out.println("Manifestacoes do(a) aluno(a) apagadas com sucesso!");
			} else {
				System.out.println("Não há manifestações para este aluno.");
			}

		} else {
			System.out.println("Não há manifestações cadastradas.");
		}
	}
}
