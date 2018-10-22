package mx.itesm.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiniArrayList<E> implements Iterable<E> {

	private class MiniArrayListIterator implements Iterator<E> {

		private int index = 0;
		private boolean estado;
		@Override
		public boolean hasNext() {
			estado = false;
			return index < elements.length;
			
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			estado = true;
			return elements[index++];
		}
		
		@Override
		public void remove() {
			if (estado = false) {
				throw new IllegalStateException();
			}
			
						
		}
	}

	private E[] elements;

	@SafeVarargs
	public MiniArrayList(E... collection) {
		elements = collection;
	}

	public E get(int index) {
		if (index < 0 || index >= elements.length) {
			throw new IndexOutOfBoundsException();
		}

		return elements[index];
	}

	public int size() {
		return elements.length;
	}

	@Override
	public Iterator<E> iterator() {
		return new MiniArrayListIterator();
	}
	
	

}
