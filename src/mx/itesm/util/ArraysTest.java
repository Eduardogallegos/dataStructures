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

}
