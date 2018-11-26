package mx.itesm.exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import mx.itesm.util.BinaryNode;

public class AnimalGame implements Serializable {

	private static final long serialVersionUID = 1;
	public static Scanner sc = new Scanner(System.in);
	static BinaryNode<String> pregunta1 = new BinaryNode<String>("¿Es un animal doméstico?");
	
	public AnimalGame() {
		pregunta1.leftChild = new BinaryNode<String>("Es un (una) Perro?");
		pregunta1.rightChild = new BinaryNode<String>("Es un (una) Cocodrilo?");
	}

	public AnimalGame(BinaryNode<String> ois) {
		pregunta1 = ois;
	}

	public static boolean esAnimal(BinaryNode<String> nodo) {
		return nodo.leftChild == null && nodo.rightChild == null;
	}

	public static void add(BinaryNode<String> nodo) {
		BinaryNode<String> nodoAntiguo = new BinaryNode<String>(nodo.get());
		System.out.println("Déjame aprender");
		System.out.println("* Escribe el nombre del animal que pensaste: ");
		String nuevoHijo = sc.nextLine();
		System.out.println("* Escribe una afirmación que sea verdadera para un (una) " + nuevoHijo
				+ " pero que sea falsa para " + nodoAntiguo.get());
		String pregunta = sc.nextLine();
		nodo.set("¿" + pregunta + "?");
		nodo.leftChild = new BinaryNode<String>("Es un (una)" + nuevoHijo + "?");
		nodo.rightChild = nodoAntiguo;
	}

	public static void preguntar(BinaryNode<String> nodo) {

		System.out.println(nodo.get() + "(s/n): ");
		// Scanner sc = new Scanner(System.in);
		String respuesta = sc.nextLine();
		boolean x = esAnimal(nodo);
		if (!x) {
			if (respuesta.equals("s")) {
				preguntar(nodo.leftChild);
			} else if (respuesta.equals("n")) {
				preguntar(nodo.rightChild);
			}
		}
		if (x) {
			if (respuesta.equals("s")) {
				System.out.println("¡¡¡Adiviné!!!");
			} else if (respuesta.equals("n")) {
				add(nodo);
			}
		}
	}

	public static void main(String[] args) {
		// BinaryNode<String> pregunta1 = new BinaryNode<String>("¿Es un animal
		// doméstico?");
		// AnimalGame juego;
		
		System.out.println("Piensa en un animal.");
		System.out.println("Yo trataré de adivinar cuál es haciéndote varias preguntas.");
		try (FileInputStream fis = new FileInputStream("datos.bin");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			// Se requiere hacer un cast porque readObject() regresa un Object.
			@SuppressWarnings("unchecked")
			BinaryNode<String> x = (BinaryNode<String>) ois.readObject();
			pregunta1 = x;
			//new AnimalGame();
			preguntar(pregunta1);
		} catch (Exception e) {
			new AnimalGame();
			preguntar(pregunta1);
		}

		// preguntar(juego);
		boolean quieresJugar = true;
		// Scanner sc = new Scanner(System.in);
		while (quieresJugar) {
			System.out.println();
			System.out.println("¿Deseas volver a jugar? (s/n): ");
			String deseo = sc.nextLine();
			if (deseo.equals("n")) {
				System.out.println("Adiós");
				quieresJugar = false;
			} else {
				preguntar(pregunta1);
			}
		}

		sc.close();
		try (FileOutputStream fos = new FileOutputStream("datos.bin");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// Objeto que se desea hacer persistente.
			BinaryNode<String> x = pregunta1;
			oos.writeObject(x);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * System.out.println(pregunta1.get() + "(s/n)"); Scanner sc = new
		 * Scanner(System.in); String respuesta = sc.nextLine(); if
		 * (respuesta.equals("s")) { System.out.println(pregunta1.leftSon.get()); }else
		 * if(respuesta.equals("n")) { System.out.println(pregunta1.rightSon.get());
		 * }else { System.out.println("Contesta bien, puños"); }
		 */
	}

}

