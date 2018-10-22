package mx.itesm.main;

import java.util.Iterator;
import mx.itesm.util.*;

public class Main {

	public static void main(String[] args) {
		
		MiniArrayList<Integer> list = new MiniArrayList<Integer>(4, 8, 15, 16, 23, 42);
		
		//1. Vistimaos todos los elementos de list usando un iterador explicito.
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			System.out.print(element + " ");
		}
		
		System.out.println();
		//2. Visitamos todos los elementos usando un for "mejorado" (el de python).
		for(Integer element : list) {
			System.out.print(element + " ");
		}
		
	}
}
