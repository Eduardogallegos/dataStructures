package mx.itesm.util;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Sorting {

	public static <T extends Comparable<T>> List<T> insertionsort(List<T> unorderedList) {
		// Copiamos los valores de unorderedList y los guardamos en una nueva lista.
		List<T> unorderedSection = new LinkedList<T>(unorderedList);
		List<T> orderedSection = new LinkedList<T>();
		while (!unorderedSection.isEmpty()) {
			T element = unorderedSection.remove(0);
			int index = 0;
			while (index < orderedSection.size() && element.compareTo(orderedSection.get(index)) >= 0) {
				index++;
			}
			orderedSection.add(index, element);
		}
		return orderedSection;
	}

	public static <T extends Comparable<T>> List<T> selectionsort(List<T> unorderedList) {
		List<T> uSection = new LinkedList<T>(unorderedList);
		List<T> oSection = new LinkedList<T>();
		int seccion = uSection.size();

		for (int i = 0; i < seccion; i++) {
			T menor = uSection.get(0);
			int contador = 0;
			for (int j = 1; j < uSection.size(); j++) {
				int r = menor.compareTo(uSection.get(j));
				if (r > 0) {
					contador = j;
					menor = uSection.get(j);
				}
			}
			oSection.add(i, uSection.remove(contador));
		}
		return oSection;
	}

	public static List<Integer> bucketsort(List<Integer> unorderedList) {
		List<Integer> uSection = new LinkedList<Integer>(unorderedList);
		List<Integer> listaOrdenada = new LinkedList<Integer>();
		List<Integer> list0 = new LinkedList<Integer>();
		List<Integer> list1 = new LinkedList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		List<Integer> list3 = new LinkedList<Integer>();
		List<Integer> list4 = new LinkedList<Integer>();
		List<Integer> list5 = new LinkedList<Integer>();
		List<Integer> list6 = new LinkedList<Integer>();
		List<Integer> list7 = new LinkedList<Integer>();
		List<Integer> list8 = new LinkedList<Integer>();
		List<Integer> list9 = new LinkedList<Integer>();

		for (int i = 0; i < uSection.size(); i++) {
			int numero = uSection.get(i);
			if (numero < 10) {
				list0.add(numero);
			} else if (numero < 20) {
				list1.add(numero);
			} else if (numero < 30) {
				list2.add(numero);
			} else if (numero < 40) {
				list3.add(numero);
			} else if (numero < 50) {
				list4.add(numero);
			} else if (numero < 60) {
				list5.add(numero);
			} else if (numero < 70) {
				list6.add(numero);
			} else if (numero < 80) {
				list7.add(numero);
			} else if (numero < 90) {
				list8.add(numero);
			} else {
				list9.add(numero);
			}
		}

		Collections.sort(list0);
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.sort(list3);
		Collections.sort(list4);
		Collections.sort(list5);
		Collections.sort(list6);
		Collections.sort(list7);
		Collections.sort(list8);
		Collections.sort(list9);

		while (!list0.isEmpty()) {
			listaOrdenada.add(list0.remove(0));
		}
		while (!list1.isEmpty()) {
			listaOrdenada.add(list1.remove(0));
		}
		while (!list2.isEmpty()) {
			listaOrdenada.add(list2.remove(0));
		}
		while (!list3.isEmpty()) {
			listaOrdenada.add(list3.remove(0));
		}
		while (!list4.isEmpty()) {
			listaOrdenada.add(list4.remove(0));
		}
		while (!list5.isEmpty()) {
			listaOrdenada.add(list5.remove(0));
		}
		while (!list6.isEmpty()) {
			listaOrdenada.add(list6.remove(0));
		}
		while (!list7.isEmpty()) {
			listaOrdenada.add(list7.remove(0));
		}
		while (!list8.isEmpty()) {
			listaOrdenada.add(list8.remove(0));
		}
		while (!list9.isEmpty()) {
			listaOrdenada.add(list9.remove(0));
		}

		return listaOrdenada;
	}

	public static <T extends Comparable<T>> List<T> bogosort(List<T> unorderedList) {
		List<T> x = new LinkedList<T>(unorderedList);
		boolean sorted = false;
		while (!sorted) {
			for (int i = 0; i < x.size() - 1; i++) {
				if (x.get(i).compareTo(x.get(i + 1)) > 0) {
					Collections.shuffle(x);
					i = -1;
				}
			}
			break;
		}
		return x;
	}

	public static <T extends Comparable<T>> List<T> quicksort(List<T> unorderedList) {
		if (unorderedList.isEmpty()) {
			return unorderedList;
		}

		T pivote = unorderedList.get(0);
		List<T> menor = new LinkedList<T>();
		List<T> mayor = new LinkedList<T>();
		List<T> copy = new LinkedList<T>();

		for (int i = 1; i < unorderedList.size(); i++) {
			int r = unorderedList.get(i).compareTo(pivote);
			if (r < 0) {
				menor.add(unorderedList.get(i));
			} else {
				mayor.add(unorderedList.get(i));
			}
		}

		menor = quicksort(menor);
		mayor = quicksort(mayor);

		while (!menor.isEmpty()) {
			copy.add(menor.remove(0));
		}

		copy.add(pivote);

		while (!mayor.isEmpty()) {
			copy.add(mayor.remove(0));
		}

		return copy;
	}
}
