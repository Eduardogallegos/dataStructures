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

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (listCapacity == listSize) {
			listCapacity *= 2;
			E[] tempData = (E[]) new Object[listCapacity];
			for (int i = 0; i < listSize; i++) {
				tempData[i] = data[i];
			}
			data = tempData;
		}

		for (int i = listSize; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = element;
		listSize++;
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
		listSize--;
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

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		listSize = 0;
		listCapacity = 10;

		data = (E[]) new Object[listCapacity];
	}

	public void trimToSize() {
		listCapacity = listSize;

	}
}
