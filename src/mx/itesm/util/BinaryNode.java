package mx.itesm.util;

import java.io.Serializable;

public class BinaryNode <E> implements Serializable{
	
	private static final long serialVersionUID = 1;

	E value;
	public BinaryNode <E> leftSon;
	public BinaryNode <E> rightSon;
	
	public BinaryNode() {
		value = null;
		leftSon = null;
		rightSon = null;
	}
	
	public BinaryNode(E value) {
		this.value = value;
		leftSon = null;
		rightSon = null;
	}
	
	public E get() {
		return value;
	}
	
	public void set (E s) {
		this.value = s;
	}
	
}

