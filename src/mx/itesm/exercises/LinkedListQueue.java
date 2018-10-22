package mx.itesm.exercises;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import mx.itesm.util.Node;

public class LinkedListQueue<E> extends AbstractQueue<E> {

	private class LinkedListQueueIterator implements Iterator<E> {
		
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			if(index < size()) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return peek();
		}
		
	}
	
	private Node<E> head;
	public int size;
	
	public LinkedListQueue() {
		head = new Node<E>();
		size = 0;
	}
	
	public LinkedListQueue(Collection<E> coll) {
		head = new Node<E>();
		size = 0;
		
		for (E element : coll) {
			offer(element);
		}
	}
	
	public boolean offer(E value) {
		if (value == null) {
			throw new NullPointerException();
		}
		
		Node<E> newNode = new Node<E>(value);
		Node<E> previousLast = head.prev;
		previousLast.next = newNode;
		newNode.next = head;
		head.prev = newNode;
		newNode.prev = previousLast;
		size++;
		
		return true;
	}
	
	public E peek() {
		if (size == 0) {
			return null;
		}
		
		return head.next.t;
	}
	
	public E poll() {
		if (size == 0) {
			return null;
		}
		
		Node<E> nodeToRemove = head.next;
		Node<E> newFirst = nodeToRemove.next;
		
		head.next = newFirst;
		newFirst.prev = head;
		nodeToRemove.next = null;
		nodeToRemove.prev = null;
		size--;
		
		return nodeToRemove.t;
	}
	
	public Iterator<E> iterator() {
		return new LinkedListQueueIterator();
	}
	
	public int size() {
		return size;
	}
}
