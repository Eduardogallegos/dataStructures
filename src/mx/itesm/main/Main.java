package mx.itesm.main;

import mx.itesm.util.IntegerNode;

public class Main {
	
	public static String toString(IntegerNode header) {
		IntegerNode currentNode = header.next;
		
		if (currentNode == header) {
			return "[]";
		}
		
		String returnValue = "[" + currentNode.value;
		while (currentNode.next != header) {
			currentNode = currentNode.next;
			returnValue += ", " + currentNode.value;
		}
		
		returnValue += "]";
		return returnValue;
	}

	public static void main(String[] args) {
		IntegerNode sentinel = new IntegerNode();
		IntegerNode cinco = new IntegerNode(5);
		IntegerNode cuatro = new IntegerNode(4);
		sentinel.next = cinco;
		sentinel.prev = cinco;
		cinco.next = sentinel;
		cinco.prev = sentinel;
		IntegerNode current = sentinel.next;
		cuatro.next = current;
		cuatro.prev = sentinel;
		current.prev = cuatro;
		sentinel.next = cuatro;
		
		addFirst(sentinel,7);
		addFirst(sentinel,1);
		
		System.out.println(toString(sentinel));
		
	}
	
	public static void addFirst (IntegerNode header, int value) {
		IntegerNode nuevo = new IntegerNode(value);
		IntegerNode current = header.next;
		nuevo.next = current;
		nuevo.prev = header;
		current.prev = nuevo;
		header.next = nuevo;
	}

}
