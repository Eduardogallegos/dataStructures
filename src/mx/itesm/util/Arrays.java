package mx.itesm.util;

import java.util.Deque;
import java.util.LinkedList;

import mx.itesm.util.IntStack;

public class Arrays {

	public static int findMinimum(int array[]) {
		if (array.length != 0) {
			int less = array[0];
			for (int i = 0; i < array.length; i++) {
				if (less > array[i]) {
					less = array[i];
				}

			}
			return less;
		} else {
			int less = (Integer.MIN_VALUE);
			return less;
		}

	}

	public static int findMaximum(int array[]) {
		if (array.length != 0) {
			int max = array[0];
			for (int i = 0; i < array.length; i++) {
				if (max < array[i]) {
					max = array[i];
				}

			}
			return max;
		} else {
			int max = (Integer.MIN_VALUE);
			return max;
		}

	}

	public static float findAverage(int array[]) {
		if (array.length != 0) {
			float suma = 0;
			for (int i = 0; i < array.length; i++) {
				suma += array[i];
			}
			float promedio = suma / array.length;
			return promedio;
		} else {
			float promedio = Integer.MIN_VALUE;
			return promedio;
		}
	}

	public static float sampleVariance(int array[]) {
		if (array.length != 0) {
			float suma = 0;
			for (int i = 0; i < array.length; i++) {
				suma += array[i];
			}
			float promedio = suma / array.length;
			float suma2 = 0;
			for (int j = 0; j < array.length; j++) {
				suma2 += ((array[j] - promedio) * (array[j] - promedio));
			}
			float varianza = suma2 / array.length;
			return varianza;
		} else {
			float varianza = Integer.MIN_VALUE;
			return varianza;
		}

	}

	public static String toString(int array[]) {
		if (array.length == 0) {
			return "[]";
		}

		String resultado = "[";
		resultado += array[0];
		for (int i = 1; i < array.length; i++) {
			resultado += "," + array[i];
		}
		resultado += "]";
		return resultado;
	}

	/**
	 * Reverses in place the order of the elements in the input array.
	 * 
	 * @param array the array to reverse.
	 */
	public static void reverse(int[] array) {
		IntStack pila = new IntStack(array.length);
		for (int i = 0; i < array.length; i++) {
			pila.push(array[i]);
		}

		for (int i = 0; i < array.length; i++) {

			array[i] = pila.pop();
		}
	}

	public static int indexOfLinear(int[] array, int target) {
		int contador = 0;
		int resultado = -1;
		while (contador < array.length) {
			if (target != array[contador]) {
				contador++;
			} else {
				resultado = contador;
				break;
			}
		}
		return resultado;
	}

	public static int indexOfBinary(int[] array, int target) {
		int min = 0;
		int max = array.length - 1;
		while (max >= min) {
			int pos = (max + min) / 2;
			if (target > array[pos]) {
				min = pos + 1;
			} else if (array[pos] > target) {
				max = pos - 1;
			} else {
				return pos;
			}
		}
		return -1;
	}

	public static void insertionsort(int[] unorderedArray) {
		for (int i = 0; i < unorderedArray.length; i++) {
			for (int j = 0; j < unorderedArray.length; j++) {
				if (unorderedArray[j] > unorderedArray[i] && i > j) {
					int x = unorderedArray[j];
					unorderedArray[j] = unorderedArray[i];
					unorderedArray[i] = x;
				}
			}
		}
	}

	public static void selectionsort(int[] unorderedArray) {
		for (int i = 0; i < unorderedArray.length; i++) {
			for (int j = i; j < unorderedArray.length; j++) {
				if (unorderedArray[i] > unorderedArray[j]) {
					int x = unorderedArray[j];
					unorderedArray[j] = unorderedArray[i];
					unorderedArray[i] = x;
				}
			}
		}
	}

	public static void bubblesort(int[] unorderedArray) {
		for (int j = 0; j < unorderedArray.length; j++) {
			for (int i = 1; i < unorderedArray.length; i++) {
				if (unorderedArray[i - 1] > unorderedArray[i]) {
					int x = unorderedArray[i - 1];
					unorderedArray[i - 1] = unorderedArray[i];
					unorderedArray[i] = x;
				}
			}
		}
	}

	public static void quicksort(int[] uArray, int minIndex, int maxIndex) {
		if (minIndex >= maxIndex) {
			return;
		}
		int div = uArray[minIndex];
		Deque<Integer> before = new LinkedList<Integer>();
		Deque<Integer> after = new LinkedList<Integer>();

		for (int i = minIndex + 1; i <= maxIndex; i++) {
			if (uArray[i] < div) {
				before.push(uArray[i]);
			} else {
				after.push(uArray[i]);
			}
		}
		int numero = minIndex;
		int mid;
		while(before.peek() != null) {
			uArray[numero] = before.pop();
			numero++;
		}
		mid = numero;
		uArray[numero] = div;
		numero ++;
		while(after.peek() != null) {
			uArray[numero] = after.pop();
			numero++;
		}
		quicksort(uArray, minIndex, mid-1);
		quicksort(uArray, mid+1, maxIndex);
	}
}
