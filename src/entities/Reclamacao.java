package entities;

public class Reclamacao extends Manifestacoes {

	//classe herdada de Manifestacoes para o tipo especifico RECLAMACAO
	public Reclamacao(String texto, String tipo, Pessoa autor) {
		super(texto, tipo, autor);
		super.setTipo("reclamacao");
	}
}
