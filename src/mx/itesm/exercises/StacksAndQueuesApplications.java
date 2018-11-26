package mx.itesm.exercises;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StacksAndQueuesApplications<E> {

	public static boolean balancedBrackets(String expr) {
		Deque<Character> stack = new LinkedList<Character>();
		if (expr.length() == 1) {
			return false;
		} else {
			for (int i = 0; i < expr.length(); i++) {
				if (expr.charAt(i) == '{' || expr.charAt(i) == '[' || expr.charAt(i) == '(') {
					stack.push(expr.charAt(i));
				} else if (expr.charAt(i) == '}' || expr.charAt(i) == ']' || expr.charAt(i) == ')') {
					if (stack.isEmpty()) {
						return false;
					}
					char x = stack.pop();
					if ((x == '{' && expr.charAt(i) == '}') || (x == '(' && expr.charAt(i) == ')')
							|| (x == '[' && expr.charAt(i) == ']')) {
					} else {
						return false;
					}
				}
			}

			if (stack.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
		Queue<Integer> q = new LinkedList<Integer>();

		if (q1.isEmpty()) {
			return q2;
		} else if (q2.isEmpty()) {
			return q1;
		}

		while (q1.size() > 0 && q2.size() > 0) {
			if (q1.element() < q2.element()) {
				q.add(q1.element());
				q1.remove();
			} else {
				q.add(q2.element());
				q2.remove();
			}
		}
		q.addAll(q1);
		q.addAll(q2);
		return q;

	}

	public static int postfixEvaluation(String expr) {
		Deque<Integer> stack = new LinkedList<Integer>();
		Queue<String> fila = new LinkedList<String>();
		fila = tokenize(expr);
		int resultado = 0;
		if (stack.size() == 1) {
			return stack.pop();
		} else {
			while (fila.size() > 1) {

				try {
					// Integer.parseInt(fila.remove());
					stack.push(Integer.parseInt(fila.remove()));
				} catch (NumberFormatException e) {
					int b = stack.pop();
					int a = stack.pop();
					if (fila.remove() == "+") {
						resultado = b + a;
						stack.push(resultado);
					} else if (fila.remove() == "-") {
						resultado = b - a;
						stack.push(resultado);
					} else if (fila.remove() == "*") {
						resultado = b * a;
						stack.push(resultado);
					} else if (fila.remove() == "/") {
						resultado = b / a;
						stack.push(resultado);
					} else if (fila.remove() == "%") {
						resultado = b % a;
						stack.push(resultado);
					} else {
						throw new IllegalArgumentException();
					}
				}

			}
			if (stack.size() > 1) {
				throw new IllegalArgumentException();			
			}else {
				return stack.pop();
			}
		}
	}

	public static String convertInfixToPostfix(String expr) {
		throw new UnsupportedOperationException();
	}

	public static java.util.Queue<String> tokenize(String in) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile("(\\s)|(\\d+)|(.)");
		java.util.regex.Matcher m = p.matcher(in);
		java.util.Queue<String> result = new java.util.LinkedList<String>();
		while (m.find()) {
			if (m.group(1) == null) {
				result.add(m.group());
			}
		}
		return result;
	}

	public static boolean hasHigherPrecedence(String stackTop, String operator) {
		return !((stackTop.equals("+") || stackTop.equals("-")) && (operator.equals("*") || operator.equals("/")));
	}
	
	public static String reverseParenthesis(String s) {

		Deque<Character> stack = new LinkedList<Character>();
		Queue<Character> queue = new LinkedList<Character>();

		for (int i = 0; i < s.length(); i++) {
			char element = s.charAt(i);

			if (element == ')') {
				char elementInStack = stack.pop();
				while (elementInStack != '(') {
					queue.add(elementInStack);
					elementInStack = stack.pop();
				}
				while (!queue.isEmpty()) {
					stack.push(queue.remove());
				}
			} else {
				stack.push(element);
			}
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}

		return result;

		/*
		 * Deque<Deque<Character>> collectionOfStacks = new
		 * LinkedList<Deque<Character>>(); String result = "";
		 * 
		 * for (int i = 0; i < s.length(); i++) { char element = s.charAt(i); if
		 * (element == '(') { collectionOfStacks.push(new LinkedList<Character>()); }
		 * else if (element == ')') { Deque<Character> lastStack =
		 * collectionOfStacks.pop(); while(!lastStack.isEmpty()) {
		 * if(collectionOfStacks.isEmpty()) { result += lastStack.pop(); }else {
		 * collectionOfStacks.peek().push(lastStack.pop()); } } } else { if
		 * (collectionOfStacks.isEmpty()) { result += element; } else {
		 * collectionOfStacks.peek().push(element); } } } return result;
		 */
	}
	
}
