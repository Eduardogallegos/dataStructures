package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraysTest {

	@Test
	public void testReverse() {
		int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] array1ReversedTest = { 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.reverse(array1);
		assertTrue(array1.length == array1ReversedTest.length);
		for (int i = 0; i < array1.length; i++) {
			assertEquals(array1[i], array1ReversedTest[i]);
		}

		int[] array2 = {};
		int[] array2ReversedTest = {};
		Arrays.reverse(array2);
		assertTrue(array2.length == array2ReversedTest.length);
		for (int i = 0; i < array2.length; i++) {
			assertEquals(array2[i], array2ReversedTest[i]);
		}
	}
	
	@Test
	public void testIndexOfLinear() {
		int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < array1.length; i++) {
			assertEquals(i, Arrays.indexOfLinear(array1, i));
		}
		assertEquals(-1, Arrays.indexOfLinear(array1, 8));
		assertEquals(-1, Arrays.indexOfLinear(array1, 503));
		assertEquals(-1, Arrays.indexOfLinear(array1, -50));
		
		int[] array2 = { -43, -24, -9, 0, 13, 43, 99, 99, 102, 329 };
		assertEquals(2, Arrays.indexOfLinear(array2, -9));
		assertEquals(6, Arrays.indexOfLinear(array2, 99));
		assertEquals(9, Arrays.indexOfLinear(array2, 329));
		assertEquals(-1, Arrays.indexOfLinear(array2, -30));
		assertEquals(-1, Arrays.indexOfLinear(array2, 50));
	}
	
	@Test
	public void testIndexOfBinary() {
		int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < array1.length; i++) {
			assertEquals(i, Arrays.indexOfBinary(array1, i));
		}
		assertEquals(-1, Arrays.indexOfBinary(array1, 8));
		assertEquals(-1, Arrays.indexOfBinary(array1, 503));
		assertEquals(-1, Arrays.indexOfBinary(array1, -50));
		
		int[] array2 = { -43, -24, -9, 0, 13, 43, 99, 102, 329 };
		assertEquals(2, Arrays.indexOfBinary(array2, -9));
		assertEquals(6, Arrays.indexOfBinary(array2, 99));
		assertEquals(8, Arrays.indexOfBinary(array2, 329));
		assertEquals(-1, Arrays.indexOfBinary(array2, -30));
		assertEquals(-1, Arrays.indexOfBinary(array2, 50));
	}
	
	@Test
	public void  testSelectionsort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.selectionsort(array1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.selectionsort(array2);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.selectionsort(array3);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.selectionsort(array4);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.selectionsort(array5);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}
	
	@Test
	public void  testInsertionsort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.insertionsort(array1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.insertionsort(array2);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.insertionsort(array3);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.insertionsort(array4);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.insertionsort(array5);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}
	
	@Test
	public void  testBubblesort() {
		int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.bubblesort(array1);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array1));
		
		int[] array2 = { 209, -32, -43, 0, 20, 12, -11, 111, 32, 0, 1 };
		Arrays.bubblesort(array2);
		assertEquals("[-43, -32, -11, 0, 0, 1, 12, 20, 32, 111, 209]", java.util.Arrays.toString(array2));
		
		int[] array3 = { 2, 1, 1, 1, 1, 0, 0, 0, -1, -1 };
		Arrays.bubblesort(array3);
		assertEquals("[-1, -1, 0, 0, 0, 1, 1, 1, 1, 2]", java.util.Arrays.toString(array3));
		
		int[] array4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.bubblesort(array4);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", java.util.Arrays.toString(array4));
		
		int[] array5 = { };
		Arrays.bubblesort(array5);
		assertEquals("[]", java.util.Arrays.toString(array5));
	}

}
