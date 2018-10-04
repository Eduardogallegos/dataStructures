package mx.itesm.recursion;

public class RecursiveAlgorithms {

	public static int iterativeFactorial(int n) {
		int fact = 1;
		while (n >= 1) {
			fact *= n;
			n--;
		}
		return fact;
	}

	public static int factorial(int n) {

		if (n <= 0) {
			return 1;
		}
		return n * factorial(n - 1);

	}
	
	public static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
}
