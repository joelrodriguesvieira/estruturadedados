package tabelahash;

public class Main {

	public static void main(String[] args) {
		// - Teste as seguintes situações:
		// • buscar um elemento existente que seja o primeiro da lista
		// • buscar um elemento existente que seja o último da lista e não seja o primeiro
		// • buscar um elemento que nunca foi inserido
		// • buscar um elemento que já foi inserido e removido
		// • remover todos os elementos de uma posição da tabela e voltar a inserir elementos novamente
		
		// Realizando inserções:
		HashTable hash = new HashTable(53);
		hash.insere("joel");hash.insere("joel");hash.insere("preto");hash.insere("mae");hash.insere("aniversario");hash.insere("pedreiro");
		hash.insere("filho");hash.insere("amanhecer");hash.insere("louco");hash.insere("mc");hash.insere("anime");hash.insere("vovo");
		hash.insere("abacaxi");hash.insere("melodia");hash.insere("inverno");hash.insere("luminoso");hash.insere("espiral");hash.insere("clandestino");
		hash.insere("efervescente");hash.insere("nefasto");hash.insere("quimera");hash.insere("harmonia");hash.insere("estelar");hash.insere("anacronico");
		hash.insere("efemero");hash.insere("sinuoso");hash.insere("inusitado");hash.insere("voraz");hash.insere("paradoxo");hash.insere("excentrico");
		hash.insere("jubilo");hash.insere("sutil");hash.insere("galaxia");hash.insere("obsoleto");hash.insere("serenidade");
		hash.insere("eficaz");hash.insere("alvorada");hash.insere("sagaz");hash.insere("clandestino");hash.insere("reverie");hash.insere("eflorescer");
		hash.insere("sonambulo");hash.insere("nostalgia");hash.insere("fugaz");hash.insere("eter");hash.insere("aquarela");hash.insere("efusivo");
		hash.insere("labirinto");hash.insere("plenitude");hash.insere("crepusculo");hash.insere("exotico");hash.insere("efervescente");
		hash.print();
		System.out.println();
		
		// • buscar um elemento existente que seja o primeiro da lista
		System.out.println("Busca por 'clandestino': " );
		System.out.println(hash.busca("clandestino"));

		// • buscar um elemento existente que seja o último da lista e não seja o primeiro
		System.out.println("Busca por 'sinuoso': " );
		System.out.println(hash.busca("sinuoso"));
		
		// • buscar um elemento que nunca foi inserido
		System.out.println("Busca por 'paralelepípedo': ");
		System.out.println(hash.busca("paralelepípedo"));
		
		// • buscar um elemento que já foi inserido e removido
		hash.insere("playstation");
		hash.remove("playstation");
		System.out.println("Busca por 'playstation': ");
		System.out.println(hash.busca("playstation"));
		
		// • remover todos os elementos de uma posição da tabela e voltar a inserir elementos novamente
		System.out.println("Remover todos os elementos da posição 8 (nostalgia -> eter)");
		hash.remove("nostalgia");
		hash.remove("eter");
		hash.print();
		System.out.println();
		hash.insere("nostalgia");
		hash.insere("eter");
		hash.print();
	}

}
