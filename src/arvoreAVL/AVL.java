package ArvoreAVL;

public class AVL {
	private No raiz;
	private No noCritico;
	
	public AVL() {
		this.raiz = null;
		this.noCritico = null;
	}
	
	public AVL(int valor) {
		No raiz = new No(valor);
		this.raiz = raiz;
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
		atualizarFb(raiz);
	    if (noCritico != null) {
	        if (noCritico.getFb() >= 2) {
	            if (noCritico.getEsquerda().getFb() == -1) {
	                rotacaoEsquerdaDireita(noCritico);
	            } else {
	                rotacaoDireita(noCritico);
	            }
	        }
	        if (noCritico.getFb() <= -2) {
	            if (noCritico.getDireita().getFb() == 1) {
	                rotacaoDireitaEsquerda(noCritico);
	            } else {
	                rotacaoEsquerda(noCritico);
	            }
	        }
	    }
	}
	
	public void remover(int valor) {
		if (this.raiz.getValor() == valor) {
			if (this.raiz.getEsquerda() == null && this.raiz.getDireita() == null) {
				raiz = null;
				return;
			} else if (this.raiz.getEsquerda() != null && this.raiz.getDireita() == null) {
				this.raiz = this.raiz.getEsquerda();
				this.raiz.setPai(null);
				return;
			} else if (this.raiz.getEsquerda() == null && this.raiz.getDireita() != null) {
	            No novaRaiz = this.raiz.sucessor();
	            if (novaRaiz != this.raiz.getDireita()) {
	                novaRaiz.getPai().setEsquerda(novaRaiz.getDireita());
	                if (novaRaiz.getDireita() != null) {
	                    novaRaiz.getDireita().setPai(novaRaiz.getPai());
	                }
	                novaRaiz.setDireita(this.raiz.getDireita());
	                this.raiz.getDireita().setPai(novaRaiz);
	                novaRaiz.setEsquerda(this.raiz.getEsquerda());
	                this.raiz.getEsquerda().setPai(novaRaiz);
	                this.raiz = novaRaiz;
	                return;
	            } else {
	                this.raiz = novaRaiz;
	                this.raiz.setPai(null);
	                return;
	            }
	        } else if (this.raiz.getEsquerda() != null && this.raiz.getDireita() != null) {
	            No novaRaiz = this.raiz.getDireita().searchMin();
	            if (novaRaiz != this.raiz.getDireita()) {
	                novaRaiz.getPai().setEsquerda(novaRaiz.getDireita());
	                if (novaRaiz.getDireita() != null) {
	                    novaRaiz.getDireita().setPai(novaRaiz.getPai());
	                }
	                novaRaiz.setDireita(this.raiz.getDireita());
	                this.raiz.getDireita().setPai(novaRaiz);
	                novaRaiz.setEsquerda(this.raiz.getEsquerda());
	                this.raiz.getEsquerda().setPai(novaRaiz);
	                this.raiz = novaRaiz;
	                return;
	            } else {
	                novaRaiz.setEsquerda(this.raiz.getEsquerda());
	                this.raiz.getEsquerda().setPai(novaRaiz);
	                this.raiz = novaRaiz;
	                return;
	            }
	        }
		}
		this.raiz.remover(valor);
		atualizarFb(raiz);
	    if (noCritico != null) {
	        if (noCritico.getFb() >= 2) {
	            if (noCritico.getEsquerda().getFb() == -1) {
	                rotacaoEsquerdaDireita(noCritico);
	            } else {
	                rotacaoDireita(noCritico);
	            }
	        }
	        if (noCritico.getFb() <= -2) {
	            if (noCritico.getDireita().getFb() == 1) {
	                rotacaoDireitaEsquerda(noCritico);
	            } else {
	                rotacaoEsquerda(noCritico);
	            }
	        }
	    }
	}
	
	//FATOR DE BALANCEAMENTO = AlturaEsquerda - AlturaDireita;
	public void atualizarFb(No no) {
		if (no == null) {
			return;
		}
		int he = 0;
		int hd = 0;
		
		if (no.getEsquerda() != null) {
			he = no.getEsquerda().altura();
		}
		if (no.getDireita() != null) {
			hd = no.getDireita().altura();
		}
		int fb = he - hd;
		no.setFb(fb);
		
		if (fb == 2 || fb == -2) {
			this.noCritico = no;
		}
		
		atualizarFb(no.getEsquerda());
		atualizarFb(no.getDireita());
		
		
	}
	
	public void rotacaoDireita(No noCritico) {
		No pai = noCritico.getPai();
		No novaRaiz = noCritico.getEsquerda();
		No newEsquerda = novaRaiz.getDireita();
		
		novaRaiz.setDireita(noCritico);
		noCritico.setEsquerda(newEsquerda);
		noCritico.setPai(novaRaiz);
		novaRaiz.setPai(pai);

		if (newEsquerda != null) {
			newEsquerda.setPai(noCritico);
		}
		
		if (pai != null) {
			if (pai.getEsquerda() == noCritico) {
				pai.setEsquerda(novaRaiz);
			} else {
				pai.setDireita(novaRaiz);
			}
 		} else {
			this.raiz = novaRaiz;
		}
		atualizarFb(raiz);	
	}
	
	public void rotacaoEsquerda(No noCritico) {
		No pai = noCritico.getPai();
		No novaRaiz = noCritico.getDireita();
		No newDireita = novaRaiz.getEsquerda();
		
		novaRaiz.setEsquerda(noCritico);
		noCritico.setDireita(newDireita);
		noCritico.setPai(novaRaiz);
		novaRaiz.setPai(pai);
		
		if (newDireita != null) {
			newDireita.setPai(noCritico);
		}
		
		if (pai != null) {
			if (pai.getDireita() == noCritico) {
				pai.setDireita(novaRaiz);
			} else {
				pai.setEsquerda(novaRaiz);
			}
		} else {
			this.raiz = novaRaiz;
		}
		atualizarFb(raiz);
	}
	
	public void rotacaoDireitaEsquerda(No noCritico) {
		No noDireita = noCritico.getDireita();
		No novaRaiz = noDireita.getEsquerda();
		No newDireita = novaRaiz.getDireita();
		
		noCritico.setDireita(novaRaiz);
		novaRaiz.setPai(noCritico);
		novaRaiz.setDireita(noDireita);
		noDireita.setPai(novaRaiz);
		
		if (novaRaiz.getDireita() != null) {
			noDireita.setEsquerda(newDireita);
			if (newDireita != null) {
				newDireita.setPai(noDireita);				
			}
		}
		rotacaoEsquerda(noCritico);
	}
	
	public void rotacaoEsquerdaDireita(No noCritico) {
		No noEsquerda = noCritico.getEsquerda();
		No novaRaiz = noEsquerda.getDireita();
		No newEsquerda = novaRaiz.getEsquerda();
		
		noCritico.setEsquerda(novaRaiz);
		novaRaiz.setPai(noCritico);
		novaRaiz.setEsquerda(noEsquerda);
		noEsquerda.setPai(novaRaiz);
		
		if (novaRaiz.getEsquerda() != null) {
			noEsquerda.setDireita(newEsquerda);
			if (newEsquerda != null) {
				newEsquerda.setPai(noEsquerda);
			}
		}
		rotacaoDireita(noCritico);
	}

	public String preOrdem() {
		String str = "";
		if (this.raiz == null) {
			System.out.println();
			System.out.println("Árvore vazia!");
			return str;
		}
		else {
			System.out.println();
			return this.raiz.preOrdem(str);
		}
	}
}
