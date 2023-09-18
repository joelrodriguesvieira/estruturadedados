package listadupla_teste;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDupla lista = new ListaDupla();
		
		// Adicionando elementos na lista, afim de realizar os testes
		lista.inserir(5);lista.inserir(1);lista.inserir(10);lista.inserir(0);
		lista.inserir(1);lista.inserir(-4);	lista.inserir(40);lista.inserir(3);lista.inserir(-2);lista.inserir(1);

//		a)remoção do inicio (1,0)
		lista.imprimir();
		System.out.println("-----------APÓS A REMOÇÃO INICIAL-------------");
		System.out.println("Remover: 4");
		lista.remover(-4);
		lista.imprimir();
		
//		b)remoção do final (1,0)
		System.out.println("\n============LISTA ANTES=================");
		lista.imprimir();
		System.out.println("-----------APÓS A REMOÇÃO FINAL-------------");
		System.out.println("Remover: 40");		
		lista.remover(40);
		lista.imprimir();
		
//		c)remoção do meio (1,0)
		System.out.println("\n============LISTA ANTES=================");
		lista.imprimir();
		System.out.println("-------APÓS A REMOÇÃO MEIO-------------");
		System.out.println("Remover: 0");		
		lista.remover(0);
		lista.imprimir();
		
//		d)remoção de elementos que possuem cópias (2,0)
		System.out.println("\n============LISTA ANTES=================");
		lista.imprimir();
		System.out.println("-------APÓS A REMOÇÃO DE CÓPIAS-----------");
		System.out.println("Remover: 1");		
		lista.remover(1);
		lista.imprimir();
//		e)remoção de elementos inexistentes (1,0)
		System.out.println("\n============LISTA ANTES=================");
		lista.imprimir();
		System.out.println("--APÓS REMOÇÃO ELEMENTOS INEXISTENTES--");
		System.out.println("Remover: 1000");
		lista.remover(1000);
//		g)imprimir lista vazia (1,0)
		System.out.println("\n============LISTA ANTES=================");
		System.out.println("IMPRIMIR LISTA VAZIA: ");
		lista.esvaziarLista();
		lista.imprimir();
//		h)esvaziar lista e voltar a preenchê-la (2,0)
		System.out.println("\n============LISTA ANTES=================");
		lista.inserir(10);lista.inserir(3);lista.inserir(-2);lista.inserir(12);
		lista.imprimir();
		System.out.println("-------------ESVAZIAR---------------");
		lista.esvaziarLista();
		lista.imprimir();
		System.out.println("------------------------------------");
		System.out.println("AGORA SERÁ O MOMENTO DE INSERIR!");
		lista.inserir(2);lista.inserir(-5);lista.inserir(-1);lista.inserir(15);
		System.out.println("LISTA FINAL APÓS INSERÇÃO!: ");
		lista.imprimir();
	}

}
