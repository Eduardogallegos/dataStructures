package mx.itesm.main;

import mx.itesm.util.IntegerNode;

public class Main {

	public static void main(String[] args) {
		IntegerNode sentinel = new IntegerNode();
		IntegerNode cinco = new IntegerNode(5);
		sentinel.next = cinco;
		sentinel.prev = cinco;
		cinco.next = sentinel;
		cinco.prev = sentinel;
	}

}
