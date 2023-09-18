package listaencadeada;

public class No {
	//A classe Nó é oque compõe cada elemento da lista encadeada, sendo esse 'Nó' o tipo da variável
	//Cada Nó tem sua informação e o outro nó que aponta para o Nó seguinte
	private String info;
	private No prox;
	
	//Criar dois construtores passando um parametro, sendo um deles apenas a informação
	//e o 'prox' com valor 'null', com o intuito de dizer que a lista já está no final
	//NOTA: SE O PROX APONTA P NULL SIGNIFICA QUE AQUELE NÓ COMPLETO, É O ULTIMO DA LISTA
	public No(String info) {
		this.info = info;
		this.prox = null;
	}
	
	//Criar outro construtor passando os dois parametros
	public No(String info, No prox) {
		this.info = info;
		this.prox = prox;
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
