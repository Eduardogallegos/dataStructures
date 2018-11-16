package mx.itesm.util;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayQueue<E> extends AbstractQueue<E> {

	private class CircularArrayQueueIterator implements Iterator<E> {

		private int currentIndex = headIndex;

		@Override
		public boolean hasNext() {
			if(currentIndex == tailIndex && size == capacity) {
				return false;
			}
			return currentIndex != tailIndex;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			currentIndex++;
			return data[currentIndex];
		}
	}

	public static final int MAX_DEFAULT_CAPACITY = 10;
	private E[] data;
	private int size;
	private int capacity;
	private int headIndex = 0;
	private int tailIndex = 0;

	public CircularArrayQueue() {
		this(MAX_DEFAULT_CAPACITY);
		// utiliza el constructor que use un parametro
	}

	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity) {
		size = 0;
		this.capacity = capacity;
		this.data = (E[]) new Object[capacity];
	}

	private boolean isFull() {
		return size == capacity;
	}

	@Override
	public boolean offer(E element) {
		// Si la fila esta llena, no agrego nada y regreso false
		if (isFull()) {
			return false;
		}
		// Si la fila tiene espacio:
		// Agrego element al final de la fila
		// incremento el tamanio y regreso true
		if (tailIndex >= capacity) {
			tailIndex -= capacity;
		}
		data[tailIndex] = element;
		size++;
		tailIndex++;
		return true;
		// Cuidado: cuando llegamos al final del arreglo y todavia tenemos espacio
		// tenemos que continuar guardando al inicio del mismo
		// Recuerden que es una fila circular.
	}

	@Override
	public E peek() {
		// Si la fila esta vacia, regresamos null
		if(size == 0) {
			return null;
		}
		// Si la fila tiene al menos un elemento, regresamos
		// el valor al inicio de la misma
		return data[headIndex];
	}

	@Override
	public E poll() {
		// Si la fila esta vacia, regresamos null
		if(size == 0) {
			return null;
		}
		// Si la fila tiene al menos un elemento, quitamos y
		// Regresamos el valor al inicio de la misma.
		// Disminuimos el tamaño de la fila en 1
		
		E resultado = data[headIndex];
		size--;
		headIndex++;
		if(headIndex == capacity) {
			headIndex = 0;
		}
		return resultado;
		// Cuidado: puede darse el caso que el indice de inicio de la fila
		// pase del final del arreglo al inicio del arreglo
	}

	@Override
	public Iterator<E> iterator() {
		// Regresa una instancia de un iterador sobre los elementos de
		// la fila circular basada en arreglos
		return new CircularArrayQueueIterator();
	}

	@Override
	public int size() {
		return size;
	}

}
