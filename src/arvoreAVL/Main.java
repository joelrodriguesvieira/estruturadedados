package arvoreAVL;

public class Main {
	public static void main(String[] args) {
		AVL arvoreAVL = new AVL(10);
		
		arvoreAVL.insercao(20);
		arvoreAVL.insercao(8);
		arvoreAVL.insercao(9);
		System.out.println(arvoreAVL.preOrdem());
	}
}
