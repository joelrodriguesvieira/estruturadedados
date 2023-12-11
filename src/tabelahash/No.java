package tabelahash;

public class No {
	private String info;
	private No prox;
	
	public No(String info) {
		this.info = info;
		this.prox = null;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public No getProx() {
		return prox;
	}
	public void setProx(No prox) {
		this.prox = prox;
	}
	
	
}
