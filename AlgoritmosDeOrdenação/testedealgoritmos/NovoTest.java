package testedealgoritmos;

import java.util.Arrays;
import java.util.Random;

public class NovoTest {
    public static void main(String[] args) {
        int[] sizes = {50000, 100000, 200000};
        int numTrials = 30;

        for (int size : sizes) {
            long bubbleTime = 0;
            long quickSortTime = 0;
            long mergeSortTime = 0;

            for (int trial = 0; trial < numTrials; trial++) {
                int[] randomArray = generateRandomArray(size);

//                long start = System.currentTimeMillis();
//                bubbleSort(Arrays.copyOf(randomArray, randomArray.length));
//                long end = System.currentTimeMillis();
//                bubbleTime += end - start;

                long start = System.currentTimeMillis();
                int[] array = Arrays.copyOf(randomArray, randomArray.length);
                quickSort(array, 0,array.length-1);
                long end = System.currentTimeMillis();
                quickSortTime += end - start;

//                start = System.currentTimeMillis();
//                mergeSort(Arrays.copyOf(randomArray, randomArray.length));
//                end = System.currentTimeMillis();
//                mergeSortTime += end - start;
            }

            System.out.println("Tamanho do Vetor: " + size);
//            System.out.println("Bubble Sort Average Time: " + bubbleTime / numTrials + " milliseconds");
            System.out.println("QuickSort: " + quickSortTime / numTrials + "s");
//            System.out.println("MergeSort Average Time: " + mergeSortTime / numTrials + " milliseconds");
            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }

        return array;
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
