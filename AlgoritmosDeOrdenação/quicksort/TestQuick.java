package quicksort;

import java.util.Random;

public class TestQuick {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
//		int tamanhoVetor = 50000;
//		int tamanhoVetor = 100000;
		int tamanhoVetor = 200000;
        int numeroExecucoes = 30;
        int valorMaximo = 10000;

        long tempoTotal = 0;

        for (int i = 0; i < numeroExecucoes; i++) {
            int[] vetor = gerarVetorAleatorio(tamanhoVetor, valorMaximo);

            long inicio = System.currentTimeMillis();

            quickSort.quickSort(vetor,0,vetor.length-1);

            long fim = System.currentTimeMillis();
            long tempoExecucao = fim - inicio;

            tempoTotal += tempoExecucao;

            System.out.println("Execução " + (i + 1) + ": " + tempoExecucao + " ms");
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

}
