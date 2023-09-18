package pilha;

import listaencadeada.No;

public class PilhaListaEncadeada {
	private No topo;
	
	public PilhaListaEncadeada() {
		this.topo = null;
	}
	
	public boolean isEmpty() {
		return topo == null;
	}
	
	public void push(String info) {
		No novo = new No(info);
		if (isEmpty()) {
			topo = novo;
			return;
		}
		novo.setProx(topo);
		topo = novo;
	}
	
	public void imprimi() {
		if (isEmpty()) {
			System.out.println("A lista está vazia");
		} else {
			for (No i = topo; i != null; i=i.getProx()) {
				System.out.print(i.getInfo() + " ");
			}
			System.out.println();
		}
	}
	
	public void pop() {
		if (isEmpty()) {
			System.out.println("A lista está vazia");
		} else {
			if (topo.getProx() != null) {
				topo = topo.getProx();
				return;
			} else {
				topo = null;
			}
		}
	}
}
