package ArvoreAVL;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL arvoreAVL = new AVL();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Inserir");
            System.out.println("2. Remover");
            System.out.println("3. Visualizar");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    arvoreAVL.insercao(valorInserir);
                    System.out.println("Valor inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvoreAVL.remover(valorRemover);
                    break;

                case 3:
                    System.out.println("Árvore AVL:");
                    System.out.println(arvoreAVL.preOrdem());
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        scanner.close();

	}

}
