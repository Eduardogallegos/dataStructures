package mx.itesm.practise;

//import java.util.Deque;

import mx.itesm.util.BinaryNode;
//import java.util.Stack;
import mx.itesm.util.LinkedList;

public class practise {
	
	public static int gdc(int m, int n) {
		if (m > n) {
			return gdc(m - n, n);
		} else if (m < n) {
			return gdc(m, n - m);
		} else {
			return m;
		}
	}

	public static int pow(int base, int exponente) {
		if (exponente == 0) {
			return 1;
		}
		// int x = pow(base, --exponente);
		return base * pow(base, --exponente);
	}

	public static int max(LinkedList<Integer> list) {
		if (list.size() == 0) {
			return Integer.MIN_VALUE;
		}
		int max = list.removeFirst();
		for (int i = 0; i < list.size(); i++) {
			int x = list.removeFirst();
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	public static int consecutiveAddition(int start, int end) {
		if (start > end) {
			return 0;
		}
		return start + consecutiveAddition(++start, end);
	}

	public static String toBinary(int n) {
		if (n == 0) {
			return "";
		}
		int div = n % 2;
		String resultado = Integer.toString(div);
		return resultado + toBinary(n / 2);
	}

	public static boolean isPalindrome(String s) {
		boolean valor = false;
		if (s.length() <= 1) {
			valor = true;
		}
		s.toLowerCase();
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			list.addLast(s.charAt(i));
		}
		if (list.getFirst().equals(list.getLast())) {
			list.removeFirst();
			list.removeLast();
			String e = list.toStringReverse();
			isPalindrome(e);
			// valor = true;
		}
		return valor;

	}

	public static String cleanString(String s) {
		s.toLowerCase();
		String resultado = "";
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (Character.isAlphabetic(x)) {
				resultado += x;
			}
		}
		return resultado.toUpperCase();
	}
	
	public static int mystery(int m, int n) {
		if(m > 0 && n >0) {
			return mystery(m-1, mystery(m,n-1));
		}else if(m>0 && n == 0) {
			return mystery(m-1, 1);
		}else{
			return n+1;
		}
	}
	
	public static void insertInOrder(LinkedList<Integer> list, int element) {
		
		for(int i = 0; i < list.size(); i++) {
			if(element < list.get(i)) {
				list.add(i, element);
				break;
			}
		}
	}
	
	public static void eraseInOrder(LinkedList<Integer> lst, int count, boolean desc) {
		if(count > lst.size()) {
			lst.clear();
		}
		if (desc) {
			for(int i = lst.size()-count; i < lst.size(); i++) {
				lst.remove(i);
			}
		}else {
			for(int i = 0;  i == count; i++) {
				lst.removeFirst();
			}
		}
	}

	public static void moveToBeginning(LinkedList<Integer> lst, int i) {
		if(i < 0 || i >= lst.size()) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		int x = lst.get(i);
		lst.remove(i);
		lst.addFirst(x);
	}
	
	
	public static int treeSize(BinaryNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		return (1 + treeSize(node.leftChild)+ treeSize(node.rightChild));
	}
	
	public static int countOneChild(BinaryNode<Integer> node) {
		if((node.leftChild==null&&node.rightChild!=null)) {
			return 1+countOneChild(node.rightChild);
		}
		else if((node.rightChild==null&&node.leftChild!=null)) {
			return 1+countOneChild(node.leftChild);
		}
		else if(node.leftChild==null&&node.rightChild==null) {
			return 0;
		}
		else {
			return countOneChild(node.rightChild)+ countOneChild(node.leftChild);
		}
	}
	
	
}
