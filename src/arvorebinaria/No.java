package arvorebinaria;

public class No {
	private No direita;
    private No esquerda;
    private int valor;
    private int fb;
    private No pai;

    public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public No(int valor) {
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
        this.pai = null;
    }

    public No(int valor, No direita, No esquerda) {
        this.valor = valor;
        this.direita = direita;
        this.esquerda = esquerda;
        this.pai = null;
    }
    
    public No(int valor, No direita, No esquerda, No pai) {
        this.valor = valor;
        this.direita = direita;
        this.esquerda = esquerda;
        this.pai = pai;
    }

    public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void preOrdem() {
        System.out.print(this.valor + " ");
        if (this.esquerda != null) {
            this.esquerda.preOrdem();
        }
        if (this.direita != null) {
            this.direita.preOrdem();
        }
    }
    
    public void emOrdem() {
    	if (this.esquerda != null) {
    		this.esquerda.emOrdem();
    	}
    	System.out.print(this.valor + " ");
    	if (this.direita != null) {
    		this.direita.emOrdem();
    	}
    }
    
    public void posOrdem() {
    	if (this.esquerda != null) {
    		this.esquerda.posOrdem();
    	}
    	if (this.direita != null) {
    		this.direita.posOrdem();
    	}
    	System.out.print(this.valor + " ");
    }
    
    public boolean isEmpty() {
    	if (this.esquerda == null && this.direita == null) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public int treeHeight() {
    	if (isEmpty()) {
    		return 0;
    	} else {
    		int he = 0;
    		int hd = 0;
    		
    		if (this.esquerda != null) {
    			he = this.esquerda.treeHeight();
    		}
    		if (this.direita != null) {
    			hd = this.direita.treeHeight();
    		}
    		if (he > hd) {
    			return 1 + he;
    		} else {
    			return 1 + hd;
    		}
    	}
    }
    
    public boolean checkValue(int valor) {
    	if (this.valor == valor) {
    		return true;
    	}
    	if (isEmpty()) {
    		return false;
    	}
    	if (this.valor < valor) { 
    		return this.direita.checkValue(valor);
    	} else {
    		return this.esquerda.checkValue(valor);
    	}
    }
    
    public void insert(int valor) {
    	No novo = new No(valor);
    	
    	if (valor >= this.valor) {
    		if (this.direita != null) {
    			this.direita.insert(valor);	
    		} else {
    			this.direita = novo;
    		}
    	} else {
    		if (this.esquerda != null) {
    			this.esquerda.insert(valor);
    		} else {
    			this.esquerda = novo;
    		}
    	}
    }
    
    public boolean search(int valor) {
    	if (this.valor == valor) {
    		return true;
    	} else {
    		boolean checkLeft = false;
    		boolean checkRight = false;
    		
    		if (this.esquerda != null) {
    			checkLeft = this.esquerda.search(valor);
    		}
    		if (this.direita != null) {
    			checkRight = this.direita.search(valor);
    		}
    		return  checkLeft || checkRight;
    	}
    	
    }
    
    public No searchNo(int valor) {
    	No aux = this;
    	
    	while (aux != null) {
    		if (aux.valor == valor) return aux;
    		if (valor < aux.valor) aux = aux.esquerda;
    		if (valor > aux.valor) aux = aux.direita;
    	}
    	return null;
    }
    
    public No searchMin() {
    	No minimo = this;
    	if (this.esquerda != null) {
    		minimo = this.esquerda.searchMin();	
    	} else {
    		return this;
    	}
		return minimo;
    }
    
    public void searchMax() {
    	if (this.direita != null) {
    		this.direita.searchMax();
    	} else {
    		System.out.println(this.valor);
    	}
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
    
    public void remover(No no) {
    	if (this.valor < no.valor) {
    		this.direita.remover(no);
    	} else if (this.valor > no.valor) {
    		this.esquerda.remover(no);
    	} else if (this.valor == no.valor) {
    		if (no.getDireita() == null && no.getEsquerda() == null) {
    			System.out.print("No removido");
    			if (this.getPai() != null) {
    				if (this == this.getPai().getEsquerda()) {
    					this.getPai().setEsquerda(null);
    				} else if (this == this.getPai().getDireita()) {
    					this.getPai().setDireita(null);
    				}
    			}
    		} else if (no.getDireita() != null && no.getEsquerda() == null) {
    			System.out.print("No removido");
    			this.getPai().setDireita(no.getDireita());
    		} else if (no.getDireita() == null & no.getEsquerda() != null) {
    			System.out.print("No removido");
    			this.getPai().setEsquerda(no.getEsquerda());
    		} else {
    			No sucessor = this.sucessor();
    			sucessor.setEsquerda(this.getEsquerda());
    			if (this.getPai().getValor() > sucessor.getValor()) {
    				System.out.print("No removido");
    				this.getPai().setEsquerda(sucessor);
    			} else {
    				System.out.print("No removido");
    				this.getPai().setDireita(sucessor);
    			}
    		}
    	}
    }
}
