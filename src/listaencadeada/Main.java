package listaencadeada;

public class Main {
	public static void main(String[] args) {
		//Criando Lista encadeada por variaveis
		//Primeiro passo:
		//Criar a classe Nó
		
		//Segundo passo:
		//Criar as quantidades de variaveis que deseja
//		No no3 = new No("3");
//		No no2 = new No("2",no3);
//		No no1 = new No("1", no2);
		
		//Nesse caso, o no1 é o primeiro da lista, que aponta para o no2 e o no2 aponta para o no3
		//que chega ao fim da lista, já que o 'prox' é igual a 'NULL'
		
		//Basta percorrer a lista agora
//		for (No p = no1; p != null; p = p.getProx()) {
//			System.out.print(p.getInfo() + " ");
//		}
		
		
		//Criando Lista encadeada de forma mais dinamica e facil
		//Primeiro passo: Criar a lista
		Lista lista = new Lista();
		
		//Usar o metodo criado
		lista.inserirInicio("3");
		lista.inserirInicio("2");
		lista.inserirInicio("1");
		lista.inserirInicio("4");
		lista.inserirInicio("7");
		lista.imprimir();
		lista.remover("7");
		lista.imprimir();
		lista.remover("3");
		lista.imprimir();
		lista.inserirInicio("9");
		lista.imprimir();

	}
}
