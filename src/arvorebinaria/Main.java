package arvorebinaria;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		No novo = new No(20);
	    No esquerdadireita = new No(6);
		No esquerda2 = new No(1);
		No direitaesquerda = new No(12);
	    No direitadireita = new No(17);
	    No esquerda1 = new No(5,esquerdadireita,esquerda2);
	    No direita1 = new No(15,direitadireita,direitaesquerda);
	    No raiz = new No(10,direita1,esquerda1);
	    direita1.setPai(raiz);
	    esquerda1.setPai(raiz);
	    esquerda2.setPai(esquerda1);
	    esquerdadireita.setPai(esquerda1);
	    direitadireita.setPai(direita1);
	    direitaesquerda.setPai(direita1);
	    raiz.emOrdem();
	    raiz.remover(direita1);
	    raiz.emOrdem();
	}

}
