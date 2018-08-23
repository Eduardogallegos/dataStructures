package mx.itesm.util;

import java.util.AbstractList;

public class LinkedList<E> extends AbstractList<E> {

	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
	}
	
	public void addFirst(E element) {
		Node <E> nuevo = new Node <E> (element);
		Node <E> current = header.next;
		nuevo.next = current;
		nuevo.prev = header;
		current.prev = nuevo;
		header.next = nuevo;
		size += 1;
	}
	
	public void addLast(E element) {
		Node <E> nuevo = new Node <E> (element);
		Node <E> current = header.prev;
		nuevo.next = header;
		nuevo.prev = current;
		current.next = nuevo;
		header.prev = nuevo;
		size += 1;
	}
	
	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
