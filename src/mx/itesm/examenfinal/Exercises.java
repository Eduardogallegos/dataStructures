package mx.itesm.examenfinal;

import java.util.LinkedList;
import java.util.Queue;

import mx.itesm.util.BinaryNode;

public class Exercises<E> {
	
	
	/*private 
	@SafeVarargs
	public Exercises(E... collection) {
		elements = collection;
	}*/
	
	
	public static <E> E[] completeTreeToArray(BinaryNode<E> node, int treeSize) {
		if (treeSize <= 0) {
			return null;
		}
		Queue<BinaryNode<E>> nodes = new LinkedList<BinaryNode<E>>();
		nodes.add(node);
		int index = 0;
		E [] elements = null;
		elements [treeSize] = null;
		while (!nodes.isEmpty()) {
			BinaryNode<E> nodeToAdd = nodes.remove();
			elements[index++] = nodeToAdd.value;
			if (node.leftChild != null){
				nodes.add(node.leftChild);
			}
			if (node.rightChild != null) {
				nodes.add(node.rightChild);
			}			 
		}
		return elements;
	}

}