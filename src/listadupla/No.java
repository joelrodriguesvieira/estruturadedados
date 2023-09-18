package listadupla_teste;

public class No {
	
	private No ant;
	private int valor;
	private No prox;

	public No(int valor) {
		this.ant = null;
		this.valor = valor;
		this.prox = null;
	}

	public No(int valor,No ant, No prox) {
		this.valor = valor;
		this.ant = ant;
		this.prox = prox;
	}

	public No(int valor, No prox) {
		this.valor = valor;
		this.prox = prox;
		this.ant = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

	public No getAnt() {
		return ant;
	}

	public void setAnt(No ant) {
		this.ant = ant;
	}
}
