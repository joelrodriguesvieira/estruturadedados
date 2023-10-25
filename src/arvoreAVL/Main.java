package ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AVL arvoreAVL = new AVL(15);
//		arvoreAVL.insercao(20);
//		arvoreAVL.insercao(7);
//		arvoreAVL.insercao(9);
//		arvoreAVL.insercao(25);
//		arvoreAVL.insercao(5);
//		arvoreAVL.insercao(6);
//		arvoreAVL.insercao(3);
//		arvoreAVL.insercao(23);
//		arvoreAVL.insercao(24);
//		System.out.println(arvoreAVL.preOrdem());
//		AVL arvoreAVL = new AVL(5);
//		arvoreAVL.insercao(3);
//		arvoreAVL.insercao(7);
//		arvoreAVL.insercao(1);
//		arvoreAVL.insercao(4);
//		arvoreAVL.insercao(9);
//		arvoreAVL.insercao(6);
//		System.out.println(arvoreAVL.preOrdem());
//		AVL arvoreAVL = new AVL(11);
//		arvoreAVL.insercao(8);
//		arvoreAVL.insercao(15);
//		arvoreAVL.insercao(9);
//		arvoreAVL.insercao(4);
//		arvoreAVL.insercao(2);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.remover(11);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.remover(15);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.remover(2);
//		arvoreAVL.insercao(5);
//		arvoreAVL.remover(9);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.remover(5);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.remover(8);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.remover(4);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.insercao(15);
//		System.out.println(arvoreAVL.preOrdem());
//		arvoreAVL.insercao(10);
//		arvoreAVL.insercao(20);
//		arvoreAVL.insercao(5);
//		System.out.println(arvoreAVL.preOrdem());
		AVL arvore = new AVL(5);
		arvore.insercao(3);
		arvore.insercao(7);
		arvore.insercao(2);
		arvore.insercao(4);
		arvore.insercao(1);
		System.out.println(arvore.preOrdem());
		arvore.insercao(6);
		arvore.remover(4);
		System.out.println(arvore.preOrdem());
		arvore.remover(1);
		arvore.remover(2);
		System.out.println(arvore.preOrdem());
		arvore.remover(5);
		arvore.remover(3);
		arvore.remover(7);
		arvore.remover(6);
		System.out.println(arvore.preOrdem());
		arvore.insercao(10);
		System.out.println(arvore.preOrdem());
		arvore.insercao(15);
		arvore.insercao(7);
		System.out.println(arvore.preOrdem());


	}

}
