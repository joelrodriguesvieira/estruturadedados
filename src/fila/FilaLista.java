package fila;

import listaencadeada.No;

public class FilaLista {
	private No inicio;
    private No fim;

    public FilaLista() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void inserir(String info) {
        No novo = new No(info);
        if (fim != null) {
            fim.setProx(novo);
        }
        fim = novo;
        if (inicio == null) {
            inicio = novo;
        }
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("fila vazia!");
        } else {
            for (No i = inicio; i != null; i = i.getProx()) {
                System.out.print(i.getInfo() + " ");
            }
            System.out.println();
        }
    }

    public void remover() {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
        inicio = inicio.getProx();
    }
}
