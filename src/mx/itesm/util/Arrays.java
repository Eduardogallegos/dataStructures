package mx.itesm.util;

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
	 * @param array the array to reverse.
	 */
	public static void reverse(int[] array) {
		IntStack pila = new IntStack(array.length);
		for (int i = array.length; i == 0; i--) {
			pila.push(array[i]);
		}
	}

}