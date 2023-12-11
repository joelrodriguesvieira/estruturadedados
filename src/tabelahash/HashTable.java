package tabelahash;

public class HashTable {
	private int max;
	private Lista[] array;
	
	public HashTable(int m) {
		this.max = m;
		this.array = new Lista[m];
	}
	
	public int funcaoHash(String str) {
	    int hash = 0;
	    int fator = max;
	    for (char character : str.toCharArray()) {
	        hash = (hash + (int) character) % fator;
	    }
	    return hash;
	}
	
	public void insere(String str){
		No no = new No(str);
		int hash = funcaoHash(str);
		if (array[hash] == null) {
			Lista lista = new Lista();
			lista.setRef(no);
			array[hash] = lista;
		} else {
			No ultimo = array[hash].getRef();
	        while (ultimo.getProx() != null) {
	            ultimo = ultimo.getProx();
	        }
	        ultimo.setProx(no);
		}
	}
	
	public void remove(String str) {
		int hash = funcaoHash(str);
		
		if (array[hash] != null) {
			No previous = null;
			boolean elementFound = false;
		
			for (No i = array[hash].getRef(); i != null; i = i.getProx()) {
				if (i.getInfo().equals(str)) {
					elementFound = true;
					if (previous == null) {
						if (i.getProx() != null) {
							array[hash].setRef(i.getProx());							
						} else {
							array[hash].setRef(null);
							array[hash] = null;
						}
	                } else {
	                    previous.setProx(i.getProx());
	                }
	                break;					
				}				 
				previous = i;
			}
			if (!elementFound) {
	            System.out.println("Elemento não encontrado para remoção: " + str);
	        }
		} else {
	        System.out.println("Posição vazia: " + hash);
	    }
	}
	
	public boolean busca(String str) {
		No no = new No(str);
		int hash = funcaoHash(str);
		if (array[hash] != null) {
			for (No i = array[hash].getRef(); i != null; i = i.getProx()) {
				if (i.getInfo().equals(no.getInfo())) {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}
	
	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print("Posição [" + i + "]: ");
			if (array[i] != null && array[i].getRef() != null) {
				for (No j = array[i].getRef(); j != null; j = j.getProx()) {
					System.out.print(j.getInfo() + " -> ");
				}
				System.out.println();
			} else {
				System.out.println("Vazio");
			}
		}
	}
	
}
