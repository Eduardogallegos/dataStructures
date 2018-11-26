package mx.itesm.util;

import java.io.Serializable;

public class BinaryNode <E> implements Serializable{
	
	private static final long serialVersionUID = 1;
	private int numeroDeNodos = 0;

	public E value;
	public BinaryNode <E> leftChild;
	public BinaryNode <E> rightChild;
	
	public BinaryNode() {
		value = null;
		leftChild = null;
		rightChild = null;
	}
	
	public BinaryNode(E value) {
		this.value = value;
		leftChild = null;
		rightChild = null;
	}
	
	public E get() {
		return value;
	}
	
	public void set (E s) {
		this.value = s;
	}
	
	public E preorderedWay(BinaryNode<E> node) {
		E valor = node.value;
		numeroDeNodos++;
		if(node.leftChild!= null) {
			preorderedWay(node.leftChild);
		}
		if(node.rightChild != null) {
			preorderedWay(node.rightChild);
		}
		return valor;
	}
	
	public E postorderedWay(BinaryNode<E> node) {
		if(node.leftChild!= null) {
			preorderedWay(node.leftChild);
		}
		if(node.rightChild != null) {
			preorderedWay(node.rightChild);
		}
		E valor = node.value;
		return valor;
	}
	
	public E inorderedWay(BinaryNode<E> node) {
		if(node.leftChild!= null) {
			preorderedWay(node.leftChild);
		}
		E valor = node.value;
		if(node.rightChild != null) {
			preorderedWay(node.rightChild);
		}
		return valor;
	}
	
}

