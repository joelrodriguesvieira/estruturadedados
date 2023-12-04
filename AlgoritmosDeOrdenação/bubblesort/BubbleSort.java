package bubblesort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String args[]) {
		int[] vetor = {15,12,0,-5,111,-45,14};	
		bubbleSort(vetor);
	}
	
	
	static void bubbleSort(int vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - i - 1; j++) {
				if (vetor[j] > vetor[j+1]) {
					int valor = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = valor;
				}
			}
		}
		System.out.println(Arrays.toString(vetor));
	}
}
