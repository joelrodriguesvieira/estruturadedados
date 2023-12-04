package bubblesort;

import java.util.Arrays;
import java.util.Random;

public class TestBubble {
	public static void main(String[] args) {
		Random random = new Random();
//		int tamanhoVetor = 50000;
//		int tamanhoVetor = 100000;
		int tamanhoVetor = 200000;
        int numeroExecucoes = 30;
        int valorMaximo = 10000;

        long tempoTotal = 0;

        for (int i = 0; i < numeroExecucoes; i++) {
            int[] vetor = gerarVetorAleatorio(tamanhoVetor, valorMaximo);

            long inicio = System.currentTimeMillis();

            bubbleSort(vetor);

            long fim = System.currentTimeMillis();
            long tempoExecucao = fim - inicio;

            tempoTotal += tempoExecucao;

        }
        double mediaTempo = (double) tempoTotal / numeroExecucoes / 1000.0; 
        System.out.println("Média do tempo de execução: " + mediaTempo + " segundos");
        
	}
	
    private static int[] gerarVetorAleatorio(int tamanho, int valorMaximo) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(valorMaximo + 1);
        }

        return vetor;
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
	}
}
