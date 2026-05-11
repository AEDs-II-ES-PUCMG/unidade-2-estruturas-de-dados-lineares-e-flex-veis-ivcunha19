import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;
	
	Fila() {
		
		Celula<E> sentinela = new Celula<E>();
		frente = tras = sentinela;
	}
	
	public boolean vazia() {
		
		return (frente == tras);
	}
	
	public void enfileirar(E item) {
		
		Celula<E> novaCelula = new Celula<E>(item);
		
		tras.setProximo(novaCelula);
		tras = tras.getProximo();
	}
	
	public E desenfileirar() {
		
		E item = null;
		Celula<E> primeiro;
		
		item = consultarPrimeiro();
		
		primeiro = frente.getProximo();
		frente.setProximo(primeiro.getProximo());
		
		primeiro.setProximo(null);
			
		// Caso o item desenfileirado seja também o último da fila.
		if (primeiro == tras)
			tras = frente;
		
		return item;
	}
	
	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na fila!");
		}

		return frente.getProximo().getItem();

	}
	
	public void imprimir() {
		
		Celula<E> aux;
		
		if (vazia())
			System.out.println("A fila está vazia!");
		else {
			aux = this.frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		} 	
	}

	public int contaCaracteres(E e){
		int cont = 0;
		Celula<E> atual = frente.getProximo();
		while (atual != null) {
			if (atual.getItem().equals(e)) {
				cont++;
			}
			atual = atual.getProximo();
		}
		return cont;
	}

	/**
	 * Desenfileira os primeiros K elementos da fila atual, respeitando a ordem de chegada,
	 * e retorna esses elementos em uma nova Fila flexível.
	 * Caso a fila original possua menos de K itens, extrai apenas os itens disponíveis.
	 * @param numItens número máximo de itens a extrair
	 * @return Nova fila contendo os itens extraídos
	 */
	public Fila<E> extrairLote(int numItens) {
		Fila<E> novaFila = new Fila<E>();
		for (int i = 0; i < numItens; i++) {
			if (vazia()) {
				break;
			}
			novaFila.enfileirar(desenfileirar());
		}
		return novaFila;
	}
}