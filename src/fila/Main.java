package fila;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilaLista lista = new FilaLista();

//      lista.inserir("a");
//      lista.inserir("b");
//      lista.inserir("c");
//      lista.imprimir();
//
//      lista.remover();
//      lista.remover();
//      lista.imprimir();
//
//      lista.inserir("a2");
//      lista.imprimir();

      FilaVetor vetor = new FilaVetor(5);

      vetor.inserir("1");
      vetor.inserir("2");
      vetor.inserir("5");
      vetor.imprimir();
      vetor.remover();
      vetor.remover();
      vetor.remover();
      vetor.imprimir();
  }
}


