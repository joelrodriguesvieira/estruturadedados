package quicksort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String args[]) {
		int[] vetor = {100,90,80,-50,-40,-30};
		quickSort(vetor,0,vetor.length -1);
		System.out.println(Arrays.toString(vetor));	
		
	}
	
	static void quickSort(int vetor[],int lb, int ub) {
		if (lb < ub) {
			int posicaoPivo = posicionaPivo(vetor, lb, ub);
			quickSort(vetor, lb, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, ub);

		}
		
	}
	
	public static int posicionaPivo(int[] vetor, int inicio, int fim) {
	    int pivo = vetor[inicio];
	    int down = inicio;
	    int up = fim;
	
	    while (down < up) {
	        while (down <= fim && vetor[down] <= pivo) {
	            down++;
	        }
	
	        while (up >= inicio && vetor[up] > pivo) {
	            up--;
	        }
	
	        if (down < up) {
	            int aux = vetor[down];
	            vetor[down] = vetor[up];
	            vetor[up] = aux;
	        }
	    }
	
	    int aux = vetor[inicio];
	    vetor[inicio] = vetor[up];
	    vetor[up] = aux;
	
	    return up;
	}

}
