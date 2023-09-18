package listacircular;

public class Listacircular {
	private No ref;
	
	public Listacircular() {
		this.ref = null;
	}
	
	public boolean listaVazia() {
		return ref == null;
	}
	
	public void insereOrdenado(int dado) {
		No novoNo = new No(dado);
		
		if (listaVazia()) {
			novoNo.setProx(novoNo);
			ref = novoNo;
		} else {
			No atual = ref.getProx();
			while (atual != ref) {
				if (dado <= atual.getDado()) {
					novoNo.setProx(atual.getProx());
					atual.setProx(novoNo);
				} else {
					novoNo.setProx(atual.getProx());
					atual.setProx(novoNo);
				}
			}
//		} else if (dado <= ref.getDado()) {
//			novoNo.setProx(ref.getProx());
//			ref.setProx(novoNo);
//		} else {
//			No atual = ref.getProx();
//			while (atual != ref && dado > atual.getProx().getDado()) {
//				atual = atual.getProx();
//			}
//			novoNo.setProx(atual.getProx());
//			atual.setProx(novoNo);
		}
		
	}
	
	public void imprimir() {
		if (listaVazia()) {
			System.out.println("A lista está vazia");
			return;
		}
		No atual = ref;
		for (; ; ) { // Loop infinito que será interrompido manualmente
	        System.out.print(atual.getDado() + " ");
	        atual = atual.getProx();
	        if (atual == ref) {
	            break; // Interrompe o loop quando voltamos ao nó de referência
	        }
	    }
	}
}
