package fila;

public class FilaVetor {
	private int inicio;
    private int nInseridos;
    private int max;
    float vet[];

    public FilaVetor(int max) {
        this.inicio = 0;
        this.nInseridos = 0;
        this.max = max;
        this.vet = new float[max];
    }


	public void inserir(String info) {
        if (this.nInseridos >= max) {
            System.out.println("Fila cheia");
            return;
        }
        int fim = (this.inicio + this.nInseridos)%this.max;
        this.vet[fim] = Float.parseFloat(info);
        nInseridos++;
    }

    public void imprimir() {
        if (this.nInseridos == 0) {
            System.out.println(("Fila vazia"));
        } else {
            int i = 0;
            do {
                System.out.print(this.vet[(this.inicio+i)%this.max] + " ");
                i++;
            } while (i < this.nInseridos);
        System.out.println();
        }

    }
    public void remover() {
        if (this.nInseridos == 0) {
            System.out.println(("Fila vazia"));
        }
        if (this.inicio == this.nInseridos-1) {
            this.inicio = 0;
        } else {
            this.inicio++;
        }
        this.nInseridos--;
    }

}
