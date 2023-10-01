package arvoreAVL;

public class AVL {
	private No raiz;
	private No noCritico;
	
	public AVL(int valor) {
		No raiz = new No(valor);
		this.raiz = raiz;
		this.noCritico = null;
	}
	
	public AVL(No raiz) {
		this.raiz = null;
		this.noCritico = null;
	}
	
	public No getRaiz() {
		return raiz;
	}
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	public No getNoCritico() {
		return noCritico;
	}
	public void setNoCritico(No noCritico) {
		this.noCritico = noCritico;
	}
	
	public String preOrdem() {
		String str = "";
		if (this.raiz == null) {
			return str;
		}
		else{
			return this.raiz.preOrdem(str);
		}

	}

	public void insercao(int valor) {
		No novoNo = new No(valor);
		if (raiz == null) {
			raiz = novoNo;
			return;
		}
		No atual = raiz;
		while (true) {
			if (novoNo.getValor() > atual.getValor()) {
				if (atual.getDireita() == null) {
					atual.setDireita(novoNo);
					novoNo.setPai(atual);
					break;
				} else {
					atual = atual.getDireita();
				}
			} else {
				if (atual.getEsquerda() == null) {
					atual.setEsquerda(novoNo);
					novoNo.setPai(atual);
					break;
				} else {
					atual = atual.getEsquerda();
				}
			}
		}
		atualizarFB(raiz);
	}

	public void remover(int valor) {
		No removeNo = new No(valor);
		if (raiz.getValor() == removeNo.getValor()) {
			raiz = null;
			System.out.println("Nó removido!");
			return;
		} else if (raiz.getEsquerda() == null && raiz.getDireita() == null){
			System.out.println("Está árvore só possui a raiz. Não foi possível remover nenhum nó");
			return;
		}
		if (removeNo.getValor() > raiz.getValor()) {
			raiz.getDireita().remover(removeNo);
		} else {
			raiz.getEsquerda().remover(removeNo);
		}
		atualizarFB(raiz);
	}

	//FATOR DE BALANCEAMENTO = AlturaEsquerda - AlturaDireita;
	public void atualizarFB(No raiz) {
		int fb = 0;
		No atual = raiz;
		while (true) {
			if (atual.getDireita() == null && atual.getEsquerda() == null) { 
				fb = 0;
				atual.setFb(fb);
				break;
			} else if (atual.getDireita() != null && atual.getEsquerda() == null) {
				fb = 0 - atual.getDireita().altura();
				atual.setFb(fb);
				atual = atual.getDireita();
			} else if (atual.getEsquerda() != null && atual.getDireita() == null) {
				fb = atual.getEsquerda().altura() - 0;
				atual.setFb(fb);
				atual = atual.getEsquerda();
			} else {
				fb = atual.getEsquerda().altura() - atual.getDireita().altura();
				atual.setFb(fb);
				atualizarFB(atual.getEsquerda());
		        atualizarFB(atual.getDireita());
			}
		}	
	}

	public No encontrarNoCritico() {
		No atual = raiz;
		while (true) {
			if (atual.getDireita() != null) {
				atualizarFB(atual.getDireita());
				if (atual.getDireita().getFb() > 1 || atual.getDireita().getFb() < -1) {
					return atual.getDireita();
				} else {
					atual = atual.getDireita();
				}
			} else if (atual.getEsquerda() != null) {
				atualizarFB(atual.getEsquerda());
				if (atual.getEsquerda().getFb() > 1 || atual.getEsquerda().getFb() < -1) {
					return atual.getEsquerda();
				} else {
					atual = atual.getEsquerda();
				}
			} else {
				break;
			}
		}
		return null;

	}
	
}
