package ArvoreAVL;

public class No {
	private int valor;
	private No esquerda;
	private No direita;
	private No pai;
	private int fb;
	
	public No(int valor) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
		this.pai = null;
		this.fb = 0;
	}
	
	public No(int valor, No direita, No esquerda, No pai) {
		this.valor = valor;
		this.direita = direita;
		this.esquerda = esquerda;
		this.pai = pai;
		this.fb = 0;
	}
	
	public No(int valor, No direita, No esquerda) {
		this.valor = valor;
		this.direita = direita;
		this.esquerda = esquerda;
		this.pai = null;
		this.fb = 0;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}
	
	public boolean isEmpty() {
		if (this.esquerda == null && this.direita == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int altura() {
		int he = 0;
		int hd = 0;
		
		if (this.esquerda != null) {
			he = this.esquerda.altura();
		}
		if (this.direita != null) {
			hd = this.direita.altura();
		}
		
		if (he > hd) {
			return he + 1;
		} else {
			return hd + 1;
		}
	}
	
	public No searchMin() {
		if (this.esquerda != null) 
			return this.esquerda.searchMin();
		return this;
	}
	
	public No sucessor() {
		if (this.direita != null) {
			return this.direita.searchMin();
		}
		No sucessor = null;
		No atual = this;
		
	    while (atual != null) {
	        if (this.valor < atual.valor) {
	            sucessor = atual;
	            atual = atual.esquerda;
	        } else if (this.valor > atual.valor) {
	            atual = atual.direita;
	        } else {
	            break;
	        }
	    }
	    return sucessor;
	}
	
	public void remover(int valor) {
    	if (this.valor < valor) {
    		this.direita.remover(valor);
    	} else if (this.valor > valor) {
    		this.esquerda.remover(valor);
    	} else if (this.valor == valor) {
    		if (this.getDireita() == null && this.getEsquerda() == null) {
    			if (this.getPai() != null) {
    				if (this == this.getPai().getEsquerda()) {
    					this.getPai().setEsquerda(null);
    				} else if (this == this.getPai().getDireita()) {
    					this.getPai().setDireita(null);
    				}
    			}
    		} else if (this.getDireita() != null && this.getEsquerda() == null) {
    			this.getPai().setDireita(this.getDireita());
    			this.getDireita().setPai(this.getPai());
    		} else if (this.getDireita() == null & this.getEsquerda() != null) {
    			this.getPai().setEsquerda(this.getEsquerda());
    			this.getEsquerda().setPai(this.getPai());
    		} else {
    			No sucessor = this.sucessor();
    			sucessor.setEsquerda(this.getEsquerda());
    			if (this.getPai().getValor() > sucessor.getValor()) {
    				this.getPai().setEsquerda(sucessor);
    			} else {
    				this.getPai().setDireita(sucessor);
    			}
    			sucessor.setPai(this.getPai());
    		}
    	}   	
    }
    
    public String preOrdem(String str) {
		str = str.concat(this.getValor() + "(" + this.getFb() + ") ");
		if (this.getEsquerda() != null) 
			str = this.getEsquerda().preOrdem(str);
		if (this.getDireita() != null) 
			str = this.getDireita().preOrdem(str);
		return str;
	}
}
