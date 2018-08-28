package mx.itesm.main;

import mx.itesm.util.LinkedList;

public class Main {

	/*
	 * public static String toString(IntegerNode header) { IntegerNode currentNode =
	 * header.next;
	 * 
	 * if (currentNode == header) { return "[]"; }
	 * 
	 * String returnValue = "[" + currentNode.value; while (currentNode.next !=
	 * header) { currentNode = currentNode.next; returnValue += ", " +
	 * currentNode.value; }
	 * 
	 * returnValue += "]"; return returnValue; }
	 * 
	 * public static void main(String[] args) { IntegerNode sentinel = new
	 * IntegerNode(); IntegerNode cinco = new IntegerNode(5); IntegerNode cuatro =
	 * new IntegerNode(4); sentinel.next = cinco; sentinel.prev = cinco; cinco.next
	 * = sentinel; cinco.prev = sentinel; IntegerNode current = sentinel.next;
	 * cuatro.next = current; cuatro.prev = sentinel; current.prev = cuatro;
	 * sentinel.next = cuatro;
	 * 
	 * addFirst(sentinel, 7); addFirst(sentinel, 1);
	 * System.out.println(toString(sentinel));
	 * 
	 * }
	 * 
	 * public static void addFirst(IntegerNode header, int value) { IntegerNode
	 * nuevo = new IntegerNode(value); IntegerNode current = header.next; nuevo.next
	 * = current; nuevo.prev = header; current.prev = nuevo; header.next = nuevo; }
	 */
	public static void main(String[] args) {
		LinkedList<Integer> integerList = new LinkedList<Integer>();
		integerList.addFirst(7);
		integerList.addFirst(3);
		integerList.addLast(8);
		integerList.addLast(6);
		integerList.addLast(4);
		integerList.addLast(5);
		System.out.println(integerList);
		System.out.println(integerList.toStringReverse());
		integerList.add(2, 29);
		System.out.println(integerList);
		integerList.set(2,9);
		System.out.println(integerList);
		integerList.removeFirst();
		System.out.println(integerList);
		integerList.removeLast();
		System.out.println(integerList);
		integerList.remove(2);
		System.out.println(integerList);
	}
}