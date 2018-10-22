package mx.itesm.exercises;

import java.util.LinkedList;
import java.util.List;

public class Exam2 {
	public static int max(List<Integer> list) {
		if(list.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		Integer pivote = list.get(0);
		List<Integer> mayor = new LinkedList<Integer>();
		
		for (int i = 1; i < list.size(); i++) {
			int r = list.get(i).compareTo(pivote);
			if (r > 0) {
				mayor.add(list.get(i));
			} 
		}

		return max(mayor);
		
	}
	
	public static int maxSymbolDepth(String exp, char opening, char closing) {
		throw new UnsupportedOperationException();
	}
	
	public static String toBinary(int n) {
		String x = "";
		if (n <= 0) {
			return x;
		}
		int residuo = n%2;
		x = residuo + x;
		n = n/2;
		return toBinary(n);
		
	}
	
}
