package listacircular;

import listadupla.No;

public class ListaCircular {
	private No ref;
	
	public ListaCircular() {
		this.ref = null;
	}

	public No getRef() {
		return ref;
	}

	public void setRef(No ref) {
		this.ref = ref;
	}
	
	public boolean isEmpty() {
		if (ref == null) 
			return true;
		 else 
			return false;
	}
	
    public void inserir(int valor) {
    	No novoNo = new No(valor);
    	if(this.isEmpty()) {
	    	novoNo.setProx(novoNo);
	    	this.ref = novoNo;
	    	return;
    	}
    	novoNo.setProx(this.ref.getProx());
    	this.ref.setProx(novoNo);
    	return;
 
    }
	
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("Lista Circular vazia!");
            return;
        }
        No p = this.ref.getProx();
        for (; p != this.ref ; p = p.getProx()) {
        	System.out.print(p.getValor() + " ");
        }
        System.out.println(p.getValor() + " ");
    }
    
    public void remover(int valor) {
    	if (isEmpty()) {
            System.out.println("Lista Circular vazia!");
            return;
        }
    	No atual = ref;
    	No anterior = null;
    	
    	// Encontrar o nó com o valor a ser removido
    	do {
    		if (atual.getValor() == valor) {
    			break;
    		}
    		anterior = atual;
    		atual = atual.getProx();
    	} while (atual != ref);
    	
    	// Se não encontrou
    	if (atual == ref && atual.getValor() != valor) {
    		System.out.println("Valor não encontrado na lista.");
            return;
    	}
    	
    	if (atual == ref) {
    		if (ref.getProx() == ref) {
    			ref = null;
    		} else {
    			ref = ref.getProx();
    			anterior.setProx(ref);
    		}
    	} else {
    		anterior.setProx(atual.getProx());
    	}
    }

}
