package entities;

public class Elogio extends Manifestacoes {
	
	//classe herdada de Manifestacoes para o tipo especifico ELOGIO
	public Elogio(String texto, String tipo, Pessoa autor) {
		super(texto, tipo, autor);
		super.setTipo("elogio");
	}
}
