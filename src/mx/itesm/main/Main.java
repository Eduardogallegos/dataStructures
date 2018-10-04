package mx.itesm.main;

import mx.itesm.recursion.Fibonacci;;

public class Main {

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		for(int i = 0; i < 100; i++) {
			System.out.println(i + ".-" + fib.getNumber(i));
		}
	}
}