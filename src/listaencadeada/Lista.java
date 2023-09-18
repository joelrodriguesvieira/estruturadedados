package listaencadeada;

import java.util.Scanner;

public class Lista {
	private No ref;
	
	public Lista() {
		this.ref = null;
	}

	public No getRef() {
		return ref;
	}

	public void setRef(No ref) {
		this.ref = ref;
	}
	
	public void inserirInicio(String valor) {
		// Na criação do novoNo, o 'prox' dele so vai apontar pro 'ref' porque quando se cria a lista
		// o construtor da lista ja começa com o 'ref' apontando para o null.
		// Sendo assim, eu adiciono o novoNo para apontar pro 'ref' e logo após, ele se torna o novo 'ref'
		// porque ele se torna o primeiro da lista
		No novoNo = new No(valor,ref);
		ref = novoNo;
		
		System.out.println("Elemento inserido!");
	}
	
	//testar se a lista é vazia
	public boolean listaVazia() {
		return ref == null;
	}
	
	//imprimir
	public void imprimir() {
		if (listaVazia()) {
			System.out.println("Lista vazia!");
			return;
		} else {
			for (No i = ref; i !=null; i = i.getProx()) {
				System.out.print(i.getInfo() + " ");
			}
		}
		System.out.println("");
	}
	
	//remover
	public void remover(String valor) {
		No anterior = null;
		int cont = 0;
		No no = new No(valor);
		
		for (No i = ref; i != null; i = i.getProx()) {
			cont++;
			if (i.getInfo().equals(no.getInfo())) {
				if (cont == 1) {
					i.setInfo(i.getProx().getInfo());
					i.setProx(i.getProx().getProx());
					System.out.println("Elemento removido!");
					return;
				} else {
					
				}
				anterior.setProx(i.getProx());
				System.out.println("Elemento removido!");
				return;
			}
			anterior = i;
		}
	}
	
}
