package listadupla_teste;

public class ListaDupla {
	private No ref;

	public ListaDupla() {
		this.ref = null;

	}

	public No getRef() {
		return ref;
	}

	public void setRef(No ref) {
		this.ref = ref;
	}
	
	public boolean listaVazia() {
		return ref == null;
	}

	public void inserir(int valor) {
		No anterior = null;
		No novoNo = new No(valor,null,ref);
		
		if (listaVazia()) {
			ref = novoNo;
			return;
		}
		for (No j = ref; j != null; j = j.getProx()) {
			if (novoNo.getValor() > j.getValor()) {
				anterior = j;
			} else {
				novoNo.setProx(j);
				novoNo.setAnt(j.getAnt());
				if (j.getAnt() == null) {
					ref = novoNo;
					j.setAnt(novoNo);
					return;
				} else {
					j.getAnt().setProx(novoNo);
					j.setAnt(novoNo);
					return;	
				}
			}
		}
		novoNo.setProx(anterior.getProx());
		novoNo.setAnt(anterior);
		anterior.setProx(novoNo);
	}

	

	public void imprimir() {
		if (listaVazia()) {
			System.out.println("A lista está vazia");
			return;
		} else {
			No anterior = null;
			System.out.println("Lista INICIO -> FIM: ");
			for (No i = ref; i != null; i = i.getProx()) {
				System.out.print(i.getValor() + " ");
				if (i.getProx() == null) {
					anterior = i;
				}

			}
			System.out.println("");
			System.out.println("Lista FIM -> INICIO: ");
			for (No x = anterior; x != null; x = x.getAnt()) {
				System.out.print(x.getValor() + " ");
			}
			
		}
		System.out.println("");

	}

	public void remover(int valor) {
		No removerNo = new No(valor);
		boolean encontrado = false;
		
		No i = ref;
		while (i != null) { 
			if (i.getValor() == removerNo.getValor()) { 
				encontrado = true;
				if (i == ref) {
					ref = i.getProx();
					if (i.getProx() != null) {
						i.getProx().setAnt(null); 
					} else {
						break;
					}
				} else if (i.getProx() == null) {
					i.getAnt().setProx(null);
					break;
				} else {
					i.getAnt().setProx(i.getProx());
					i.getProx().setAnt(i.getAnt());
				}
				if (i.getProx() == null || i.getProx().getValor()> removerNo.getValor()) {
					break;
				}
			}else if (i.getProx() == null || i.getProx().getValor()> removerNo.getValor()) {
				break;
			}
			i = i.getProx();
		}
		if (!encontrado) {
			System.out.println("Elemento " + removerNo.getValor() + " não encontrado!");
		}
	}
	
	public void esvaziarLista() {
		for (No i = ref; i != null; i = i.getProx()) {
			if (i.getAnt() == null) {
				ref = i.getProx();
				if (i.getProx() == null) {
					ref = null;
					return;
				} else {
					i.getProx().setAnt(null);
				}
			} else if (i.getProx() == null) {
				i.getAnt().setProx(null);
				i.setAnt(null);
			} else {
				i.getAnt().setProx(i.getProx());
				i.getProx().setAnt(i.getAnt());
			}
			
		}
	}
}
