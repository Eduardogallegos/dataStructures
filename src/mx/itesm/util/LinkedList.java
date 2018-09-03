package mx.itesm.util;

import java.util.AbstractList;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E> {

	private Node<E> header;
	private int size;

	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	@SafeVarargs
	public LinkedList(E... elements) {
		header = new Node<E>();
		size = 0;
		
		for (E element : elements) {
			addLast(element);
		}
	}

	public void addFirst(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		Node<E> nuevo = new Node<E>(element);
		Node<E> current = header.next;
		nuevo.next = current;
		nuevo.prev = header;
		current.prev = nuevo;
		header.next = nuevo;
		size++;
	}

	public void addLast(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		Node<E> nuevo = new Node<E>(element);
		Node<E> current = header.prev;
		nuevo.next = header;
		nuevo.prev = current;
		current.next = nuevo;
		header.prev = nuevo;
		size++;
	}

	/**
	 * Gets the node at the specified index.
	 * 
	 * @param index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundException if the index is out of range (index < 0 ||
	 *                                  index >= size())
	 */
	private Node<E> node(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index out of range");
		}

		Node<E> currentNode = header.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}

		return currentNode;
	}

	@Override
	public E get(int index) {
		return node(index).t;
	}

	@Override
	public int size() {
		return size;
	}

	public String toStringReverse() {
		Node<E> currentNode = header.prev;
		if (currentNode == header) {
			return "[]";
		}
		String returnValue = "[" + currentNode.t;
		while (currentNode.prev != header) {
			currentNode = currentNode.prev;
			returnValue += ", " + currentNode.t;
		}
		returnValue += "]";
		return returnValue;
	}

	@Override
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		Node<E> nuevo = new Node<E>(element);
		Node<E> current = node(index);
		Node<E> anterior = current.prev;
		nuevo.next = current;
		nuevo.prev = anterior;
		current.prev = nuevo;
		anterior.next = nuevo;
		size++;
	}

	@Override
	public E set(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		Node<E> elementoNuevo = node(index);
		elementoNuevo.t = element;
		return elementoNuevo.t;
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<E> primero = header.next;
		Node<E> nuevoPrimero = primero.next;
		nuevoPrimero.prev = header;
		header.next = nuevoPrimero;
		primero.next = null;
		primero.prev = null;
		size--;
		return nuevoPrimero.t;
	}

	/**
	 * Removes and returns the last element from this list.
	 * 
	 * @return the last element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<E> ultimo = header.prev;
		Node<E> nuevoUltimo = ultimo.prev;
		nuevoUltimo.next = header;
		header.prev = nuevoUltimo;
		ultimo.next = null;
		ultimo.prev = null;
		size--;
		return nuevoUltimo.t;
	}

	@Override
	public E remove(int index) {
		Node<E> nodeToRemove = node(index);
		Node<E> prevNode = nodeToRemove.prev;
		Node<E> nextNode = nodeToRemove.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		size--;
		return nextNode.t;
	}
	
	public E getFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<E> primero = header.next;
		return primero.t;
	}
	
	public E getLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Node<E> ultimo = header.prev;
		return ultimo.t;
	}
	
	

}
