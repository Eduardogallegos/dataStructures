package mx.itesm.examenfinal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

import mx.itesm.util.BinaryNode;

public class MiniBinarySearchTree<E extends Comparable<E>> extends AbstractSet<E> {

	private BinaryNode<E> root = null;
	private int size = 0;

	@Override
	public Iterator<E> iterator() {
		List<E> result = new LinkedList<E>();
		inorderTraversal(root, result);
		return result.iterator();
	}

	@Override
	public int size() {
		return size;
	}

	public int height() {
		return height(root);
	}

	public int diameter() {
		return diameter(root);
	}

	public boolean isFull() {
		return isFull(root);
	}

	/**
	 * Adds a new element to this binary search tree. If root is null, then element
	 * becomes the tree's root. If root is not null, then the tree is traversed
	 * comparing values. When a leaf is reached, a new node is inserted.
	 */
	public boolean add(E element) {
		if (root == null) {
			root = new BinaryNode<E>(element);
			size++;
			return true;
		} else {
			BinaryNode<E> currentNode = root;
			while (true) {
				if (element.compareTo(currentNode.value) == 0) {
					return false;
				} else if (element.compareTo(currentNode.value) < 0) {
					if (currentNode.leftChild == null) {
						currentNode.leftChild = new BinaryNode<E>(element);
						size++;
						return true;
					} else {
						currentNode = currentNode.leftChild;
					}
				} else {
					if (currentNode.rightChild == null) {
						currentNode.rightChild = new BinaryNode<E>(element);
						size++;
						return true;
					} else {
						currentNode = currentNode.rightChild;
					}
				}
			}
		}
	}

	private void inorderTraversal(BinaryNode<E> node, List<E> result) {
		if (node == null) {
			return;
		}
		if (node.leftChild != null) {
			inorderTraversal(node.leftChild, result);
		}
		result.add(node.value);
		if (node.rightChild != null) {
			inorderTraversal(node.rightChild, result);
		}
	}

	private int height(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		}
		int x = Math.max(height(node.leftChild), height(node.rightChild));
		return (1 + x);
	}

	private int diameter(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		}
		if (node.leftChild == null && node.rightChild == null) {
			return 1;
		}
		int y = 1 + height(node.leftChild) + height(node.rightChild);
		int[] x = { diameter(node.leftChild), diameter(node.rightChild), y };
		if (x[0] >= x[1] && x[0] >= x[2]) {
			return x[0];
		} else if (x[1] >= x[0] && x[1] >= x[2]) {
			return x[1];
		} else {
			return x[2];
		}
	}

	private boolean isFull(BinaryNode<E> node) {
		if(node == null) {
			return true;
		}
		isFull(node.leftChild);
		isFull(node.rightChild);
		if ((node.leftChild != null && node.rightChild == null)
				|| (node.leftChild == null && node.rightChild != null)) {
			return false;
		}
		
		return true;
	}

}