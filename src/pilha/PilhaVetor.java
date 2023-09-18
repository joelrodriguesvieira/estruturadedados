package pilha;

public class PilhaVetor {
	int nElems;
	int[] array;
	int max;
	
	public PilhaVetor(int max) {
		nElems = 0;
		this.max = max;
		this.array = new int[max];
	}
	
	public void push(int valor) throws Exception {
		if(this.nElems >= max)
			throw new Exception("pilha cheia");
		array[nElems] = valor;
		nElems++;
	}
	
	public int pop() throws Exception {
		if (nElems <= 0)
			throw new Exception("pilha vazia");
		array[nElems-1] = 0;
		nElems--;
		return this.array[nElems];
	}
	
	public void imprimir() {
		if (nElems <= 0) {
			System.out.println("A pilha está vazia");
		} else {
			for (int i = 0; i < array.length ; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
}
