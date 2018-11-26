package mx.itesm.practise;

import static org.junit.jupiter.api.Assertions.*;

import mx.itesm.util.BinaryNode;
//import java.util.LinkedList;
import mx.itesm.util.LinkedList;
import org.junit.jupiter.api.Test;

class practiseTest {

	@Test
	public void testGdc() {
		int a = 1;
		assertTrue(a == practise.gdc(4, 1));
	}

	@Test
	public void testPow() {
		int a = 390625;
		assertEquals(a, practise.pow(5, 8));
		int b = 1;
		assertEquals(b, practise.pow(5, 0));
	}

	@Test
	public void testMax() {
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.addFirst(9);
		a.addFirst(5);
		a.addFirst(20);
		a.addFirst(10);
		a.addFirst(-1);
		a.addFirst(0);
		assertTrue(20 == practise.max(a));
		a.clear();
		assertTrue(Integer.MIN_VALUE == practise.max(a));
	}

	@Test
	public void testConsecutiveAddition() {
		int a = 68;
		assertTrue(a == practise.consecutiveAddition(5, 12));
		int b = 0;
		assertTrue(b == practise.consecutiveAddition(5, 2));
		int c = 5;
		assertTrue(c == practise.consecutiveAddition(5, 5));
	}

	@Test
	public void testToBinary() {
		String a = "11111";
		assertTrue(a.equals(practise.toBinary(31)));
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(true == practise.isPalindrome("ana"));
	}

	@Test
	public void testCleanString() {
		String x = "HOLA";
		assertEquals(x, practise.cleanString("hO4la2."));
		String y = "";
		assertEquals(y, practise.cleanString("(&$42."));
	}

	@Test
	public void testMystery() {
		int x = 125;
		assertEquals(x, practise.mystery(3, 4));
	}

	@Test
	public void testInsertInOrder() {
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.addLast(1);
		a.addLast(8);
		a.addLast(11);
		int[] x = { 1, 8, 10, 11 };
		practise.insertInOrder(a, 10);
		// System.out.println(a);
		for (int i = 0; i < x.length; i++) {
			assertTrue(x[i] == a.get(i));

		}

	}

	@Test
	public void testEraseInOrder() {
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.addLast(1);
		a.addLast(5);
		a.addLast(8);
		a.addLast(11);
		a.addLast(19);
		a.addLast(20);
		LinkedList<Integer> b = new LinkedList<Integer>();
		b.addLast(1);
		b.addLast(5);
		b.addLast(8);
		b.addLast(11);
		b.addLast(19);
		b.addLast(20);
		LinkedList<Integer> c = new LinkedList<Integer>();
		c.addLast(1);
		c.addLast(5);
		c.addLast(8);
		int[] x = { 1, 5, 8 };
		int[] y = { 11, 19, 20 };
		practise.eraseInOrder(a, 3, true);
		practise.eraseInOrder(b, 3, false);
		practise.eraseInOrder(c, 6, false);
		for (int i = 0; i < x.length; i++) {
			assertTrue(x[i] == a.get(i));
			assertTrue(y[i] == b.get(i));
		}
		assertTrue(c.size() == 0);
		System.out.println(b);
	}

	@Test
	public void testMoveToBeginning() {
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.addLast(1);
		a.addLast(5);
		a.addLast(8);
		a.addLast(11);
		a.addLast(19);
		a.addLast(20);
		practise.moveToBeginning(a, 2);
		int[] x = { 8, 1, 5, 11, 19, 20 };
		for (int i = 0; i < x.length; i++) {
			assertTrue(x[i] == a.get(i));
		}
	}

	@Test
	public void testTreeSize() {
		BinaryNode<Integer> root = new BinaryNode<Integer>(4);
		BinaryNode<Integer> node1 = new BinaryNode<Integer>(1);
		BinaryNode<Integer> node2 = new BinaryNode<Integer>(2);
		BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
		BinaryNode<Integer> node5 = new BinaryNode<Integer>(5); 
		BinaryNode<Integer> node6 = new BinaryNode<Integer>(6); 
		BinaryNode<Integer> node7 = new BinaryNode <Integer>(7);
		BinaryNode<Integer> node8 = new BinaryNode<Integer>(8);
		root.leftSon = node2;
		root.rightSon = node5;
		node2.leftSon = node1;
		node2.rightSon = node3;
		node5.rightSon = node7;
		node7.leftSon = node6;
		node7.rightSon = node8;
		assertEquals(8, practise.treeSize(root));
		assertEquals(1, practise.countOneChild(root));
	}
}
