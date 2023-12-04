package mergesort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[] ) {
		int[] vetor = {100,0,14,-5,99,1,-16};
		int[] aux = new int[vetor.length];
		sort(vetor,aux,0,vetor.length-1);
		
		System.out.println(Arrays.toString(vetor));	

	}
	
	static void merge(int vetor[], int aux[], int low, int mid ,int high) {
		int i = low;
		int j = mid + 1;
		
		for (int k = 0; k < vetor.length; k++) {
			aux[k] = vetor[k];
		}
		
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				vetor[k] = aux[j++];
			} else if (j > high) {
				vetor[k] = aux[i++];
			} else if (aux[j] < aux[i]) {
				vetor[k] = aux[j++];
			} else {
				vetor[k] = aux[i++];
			}
		}
	}
	
	static void sort(int vetor[], int aux[], int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		
		sort(vetor, aux, low, mid);
		sort(vetor, aux, mid+1, high);
		merge(vetor, aux, low,mid,high);
		
	}
}
