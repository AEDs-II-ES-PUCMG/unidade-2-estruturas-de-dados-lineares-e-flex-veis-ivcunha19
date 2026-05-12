import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lista<E> implements Iterable<E> {

    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;

    public Lista() {
        Celula<E> sentinela = new Celula<>();
        primeiro = ultimo = sentinela;
        tamanho = 0;
    }

    public boolean vazia() {
        return primeiro == ultimo;
    }

    public int tamanho() {
        return tamanho;
    }

    public void inserirFinal(E item) {
        Celula<E> nova = new Celula<>(item);
        ultimo.setProximo(nova);
        ultimo = nova;
        tamanho++;
    }

    public void inserirInicio(E item) {
        Celula<E> nova = new Celula<>(item, primeiro.getProximo());
        if (vazia()) ultimo = nova;
        primeiro.setProximo(nova);
        tamanho++;
    }

    public E removerInicio() {
        if (vazia()) throw new NoSuchElementException("Lista vazia!");
        Celula<E> atual = primeiro.getProximo();
        primeiro.setProximo(atual.getProximo());
        if (atual == ultimo) ultimo = primeiro;
        atual.setProximo(null);
        tamanho--;
        return atual.getItem();
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("A lista está vazia!");
        } else {
            Celula<E> aux = primeiro.getProximo();
            while (aux != null) {
                System.out.println(aux.getItem());
                aux = aux.getProximo();
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Celula<E> atual = primeiro.getProximo();

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E item = atual.getItem();
                atual = atual.getProximo();
                return item;
            }
        };
    }

    // Tarefa 1
    public E buscarPor(Comparator<E> criterioDeBusca, E item) {
        // TODO: Percorrer sequencialmente a lista e retornar o primeiro elemento
        //       equivalente a item segundo o criterioDeBusca (compare == 0).
        //       Retornar null caso nenhum elemento seja encontrado.
        Celula<E> busca = primeiro.getProximo();
        Celula<E> escolhida = null;
        while (busca != null) {
            if (criterioDeBusca.compare(item, busca.getItem()) == 0) {
                escolhida = busca;
            }
            busca = busca.getProximo();
        }
        return escolhida.getItem();
    }

    // Tarefa 2
    public double somarMultiplicacoes() {
        // TODO: Para cada elemento, extrair o valor (extratorValor) e o fator (extratorFator),
        //       multiplicá-los e acumular no somatório final.
        //       Lançar IllegalStateException se a lista estiver vazia.
        double extratorValor = 0;
        double somatorioFinal = 0;
        int extratorFator = 0;

        if(this.vazia()){
            throw new IllegalStateException("Lista vazia");
        }
        Celula <E> busca = primeiro.getProximo();
        while (busca != null) {
            ItemDePedido atual = (ItemDePedido)busca.getItem();
            extratorValor = atual.getPrecoVenda();
            extratorFator = atual.getQuantidade();
            somatorioFinal += (extratorFator * extratorValor);
            busca = busca.getProximo();
        }
        return somatorioFinal;
    }

    // Tarefa 3
    public Lista<E> filtrar(Predicate<E> condicional) {
        // TODO: Criar e retornar uma nova lista contendo apenas os elementos
        //       para os quais condicional.test() retorna true.
        //       Lançar IllegalStateException se a lista estiver vazia.
        if(this.vazia()){
            throw new IllegalStateException("Lista vazia");
        }
        Lista<E> novaLista = new Lista<E>();
        Celula<E> aux = primeiro.getProximo();
        while (aux != null) {
            E e = aux.getItem();
            if(condicional.test(e)){
                novaLista.inserirFinal(e);
            }
            aux.getProximo();
        }
        return novaLista;   


    }
}
