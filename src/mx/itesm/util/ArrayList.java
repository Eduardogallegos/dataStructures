package mx.itesm.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> {

	private int listCapacity;
	private int listSize;
	private E[] data;

	@SuppressWarnings("unchecked")
	public ArrayList(E... elements) {
		listCapacity = 10;
		listSize = 0;

		data = (E[]) new Object[listCapacity];
		for (E element : elements) {
			add(element);
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}

	@Override
	public int size() {
		return listSize;
	}

	public int capacity() {
		return listCapacity;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		E x = data[index];
		data[index] = element;
		return x;
	}

	@Override
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (capacity() >= size() + 1) {
			if (index == 0) {
				for (int i = 1; i < size(); i++) {
					data[i] = data[i - 1];
				}
			} else {
				for (int i = index; i < size(); i++) {
					data[i] = data[i - 1];
				}
			}
			data[index] = element;
			listSize++;
		} else {
			listCapacity = listCapacity * 2;
			for (int i = index; i < size(); i++) {
				data[i] = data[i - 1];
			}
			data[index] = element;
			listSize++;
		}
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		E x = data[index];
		for (int i = index; i < size(); i++) {
			data[i] = data[i + 1];
		}
		listSize --;
		return x;
	}

	public E getFirst() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		return data[0];
	}

	public E getLast() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		return data[size() - 1];
	}

	@Override
	public void clear() {
		for (int i = 0; i < size(); i++) {
			data[i] = null;
		}
	}

	public void trimToSize() {
		throw new UnsupportedOperationException();
	}
}
