package mx.itesm.util;

public class Node<T> {

	public T t;
	public Node<T> next;
	public Node<T> prev;

	public Node() {
		t = null;
		next = this;
		prev = this;
	}

	public Node(T t) {
		this.t = t;
		next = this;
		prev = this;
	}

}
