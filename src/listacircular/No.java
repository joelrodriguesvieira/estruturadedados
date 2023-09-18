package listacircular;

public class No {
	private int dado;
	private No prox;
	
	public No(int dado) {
		this.dado = dado;
		this.prox = this;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
	
	
}
