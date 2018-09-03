package mx.itesm.exercises;

import java.util.Random;

import mx.itesm.util.LinkedList;

public class LinkedListApplications {

	// Metodo que analiza los elementos de una palabra para determinar si es
	// palindromo o no
	public static boolean isPalindrome(String word) {
		LinkedList<Character> list = new LinkedList<Character>();
		String words = word.toLowerCase();
		for (int i = 0; i < words.length(); i++) {
			list.addLast(words.charAt(i));
		}
		boolean valor = false;
		/*
		 * while (list.size() >= 2) { if (list.getFirst().equals(list.getLast())) {
		 * list.removeFirst(); list.removeLast(); valor = true; } }
		 */
		if (list.size() <= 1) {
			valor = true;
		} else {
			for (int j = 0; j < list.size(); j++) {
				if (list.getFirst().equals(list.getLast())) {
					list.removeFirst();
					list.removeLast();
					valor = true;
				}
			}
		}
		return valor;
	}

	//Método que desordena las letras de una palabra en orden aleatorio.
	
	public static LinkedList<Character> jumbleLetters(String word) {
		LinkedList<Character> list = new LinkedList<Character>();

		for (int i = 0; i < word.length(); i++) {
			list.addLast(word.charAt(i));
		}
		LinkedList<Character> finalList = new LinkedList<Character>();
		Random random = new Random();
		for (int i = 0; i < list.size(); i++) {
			int aleatorio = random.nextInt(2);
			if (aleatorio != 0) {
				finalList.addLast(list.get(i));
			} else {
				finalList.addFirst(list.get(i));
			}
		}
		return finalList;
	}

	//Método que resuelve el problema de Josefo
	public static String sortingHat(LinkedList<String> students, int n) {
		if (students.size() == 0) {
			throw new IllegalArgumentException();
		} else if (n < 2 || n > 7) {
			throw new IllegalArgumentException();
		}
		// System.out.println(students.toString());
		int index = 0;
		int contador = 1;
		while (students.size() != 1) {
			/*
			 * if (index < students.size()) { students.remove(index); } else if (index >=
			 * students.size() - 1) { index = (index - students.size());
			 */
			while (contador != n) {
				contador++;
				if (index >= students.size() - 1) {
					index = (index - students.size());
				}
				index++;
			}
			contador = 1;
			students.remove(index);
			//System.out.println(students.toString());
			//System.out.println(index);
		}

		return students.toString();
	}

}
