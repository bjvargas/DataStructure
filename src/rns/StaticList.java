package rns;

/**
 * Implementação de uma lista linear com armazenamento estático, baseado em
 * array.
 */
public class StaticList<E> implements List<E> {
	private E[] elements;
	private int numElements;

	/**
	 * Constrói uma lista com um tamanho máximo.
	 * 
	 * @param maxSize O tamanho máximo da lista
	 */
	public StaticList(int maxSize) {
		elements = (E[]) new Object[maxSize];
		numElements = 0;
	}

	/**
	 * Primeira Tarefa. M�todo de chamada para a contagem de elementos dentro da
	 * lista.
	 */
	public int contaElementos(E el) throws IllegalArgumentException {
		if (isEmpty())
			throw new IllegalArgumentException();

		return this.contaElementos(elements, el, 0, 0);
	}

	/**
	 * M�todo privado para complemento da primeira tarefa. Realiza a contagem de
	 * maneita recursiva do elemento informado dentro da lista.
	 * 
	 * @param lista    informada em hardCode na classe Principal.
	 * @param elemento que estamos buscando
	 * @param posicao  posicao do MAP.
	 * @param contador quantidade de ocorrencias.
	 * @return o valor.
	 */
	private int contaElementos(E[] lista, E elemento, int posicao, int contador) {
		E valor = lista[posicao];

		if (valor == elemento) {
			contador = contador + 1;
		}
		if (numElements() == posicao + 1) {
			return contador;
		}

		return this.contaElementos(lista, elemento, (posicao = posicao + 1), contador);
	}

	public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException {
		// verifica se há espaço na lista
		if (isFull())
			throw new OverflowException();

		// verifica se a posição é válida
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();

		// desloca para a direita os elementos necessários,
		// abrindo espaço para o novo
		for (int i = numElements - 1; i >= pos; i--)
			elements[i + 1] = elements[i];

		// armazena o novo elemento e ajusta o total
		elements[pos] = element;
		numElements++;
	}

	public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
		if (isEmpty())
			throw new UnderflowException();

		// verifica se a posição é válida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		// guarda uma refer�ncia temporária ao elemento removido
		E element = elements[pos];

		// desloca para a esquerda os elementos necessários,
		// sobrescrevendo a posição do que está sendo removido
		for (int i = pos; i < numElements - 1; i++)
			elements[i] = elements[i + 1];

		// define para null a posição antes ocupada pelo último,
		// para que a coleta de lixo possa atuar, e ajusta o total
		elements[numElements - 1] = null;
		numElements--;

		return element;
	}

	public E get(int pos) throws IndexOutOfBoundsException {
		// verifica se a posição é válida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		return elements[pos];
	}

	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;

		// se chegar até aqui, é porque não encontrou
		return -1;
	}

	/**
	 * Retorna uma representação String da lista.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}
}