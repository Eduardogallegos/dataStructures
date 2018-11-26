package mx.itesm.util;

import java.io.Serializable;

public class BinaryNode <E> implements Serializable{
	
	private static final long serialVersionUID = 1;
	private int numeroDeNodos = 0;

	public E value;
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
	
	public E preorderedWay(BinaryNode<E> node) {
		E valor = node.value;
		numeroDeNodos++;
		if(node.leftSon!= null) {
			preorderedWay(node.leftSon);
		}
		if(node.rightSon != null) {
			preorderedWay(node.rightSon);
		}
		return valor;
	}
	
	public E postorderedWay(BinaryNode<E> node) {
		if(node.leftSon!= null) {
			preorderedWay(node.leftSon);
		}
		if(node.rightSon != null) {
			preorderedWay(node.rightSon);
		}
		E valor = node.value;
		return valor;
	}
	
	public E inorderedWay(BinaryNode<E> node) {
		if(node.leftSon!= null) {
			preorderedWay(node.leftSon);
		}
		E valor = node.value;
		if(node.rightSon != null) {
			preorderedWay(node.rightSon);
		}
		return valor;
	}
	
}

