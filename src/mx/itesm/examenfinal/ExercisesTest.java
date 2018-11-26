package mx.itesm.examenfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.itesm.util.BinaryNode;

public class ExercisesTest {

	private BinaryNode<Integer> heapTree1;
	private Integer[] arrayTree1;
	
	private BinaryNode<Integer> heapTree2;
	private Integer[] arrayTree2;
	
	@BeforeEach
	void setup() {
		heapTree1 = new BinaryNode<Integer>(15);
		BinaryNode<Integer> nodeA = new BinaryNode<Integer>(11);
		BinaryNode<Integer> nodeB = new BinaryNode<Integer>(10);
		BinaryNode<Integer> nodeC = new BinaryNode<Integer>(7);
		BinaryNode<Integer> nodeD = new BinaryNode<Integer>(5);
		BinaryNode<Integer> nodeE = new BinaryNode<Integer>(9);
		BinaryNode<Integer> nodeF = new BinaryNode<Integer>(2);
		BinaryNode<Integer> nodeG = new BinaryNode<Integer>(6);
		BinaryNode<Integer> nodeH = new BinaryNode<Integer>(4);
		BinaryNode<Integer> nodeI = new BinaryNode<Integer>(3);
		BinaryNode<Integer> nodeJ = new BinaryNode<Integer>(1);
		BinaryNode<Integer> nodeK = new BinaryNode<Integer>(8);
		nodeC.leftChild = nodeG;
		nodeC.rightChild = nodeH;
		nodeD.leftChild = nodeI;
		nodeD.rightChild = nodeJ;
		nodeE.leftChild = nodeK;
		nodeA.leftChild = nodeC;
		nodeA.rightChild = nodeD;
		nodeB.leftChild = nodeE;
		nodeB.rightChild = nodeF;
		heapTree1.leftChild = nodeA;
		heapTree1.rightChild = nodeB;
		
		arrayTree1 = new Integer[12];
		arrayTree1[0] = (int) heapTree1.value;
		arrayTree1[1] = (int) nodeA.value;
		arrayTree1[2] = (int) nodeB.value;
		arrayTree1[3] = (int) nodeC.value;
		arrayTree1[4] = (int) nodeD.value;
		arrayTree1[5] = (int) nodeE.value;
		arrayTree1[6] = (int) nodeF.value;
		arrayTree1[7] = (int) nodeG.value;
		arrayTree1[8] = (int) nodeH.value;
		arrayTree1[9] = (int) nodeI.value;
		arrayTree1[10] = (int) nodeJ.value;
		arrayTree1[11] = (int) nodeK.value;
		
		heapTree2 = new BinaryNode<Integer>(7);
		BinaryNode<Integer> nodeL = new BinaryNode<Integer>(4);
		BinaryNode<Integer> nodeM = new BinaryNode<Integer>(9);
		BinaryNode<Integer> nodeN = new BinaryNode<Integer>(2);
		BinaryNode<Integer> nodeO = new BinaryNode<Integer>(5);
		BinaryNode<Integer> nodeP = new BinaryNode<Integer>(8);
		nodeL.leftChild = nodeN;
		nodeL.rightChild = nodeO;
		nodeM.leftChild = nodeP;
		heapTree2.leftChild = nodeL;
		heapTree2.rightChild = nodeM;
		
		arrayTree2 = new Integer[6];
		arrayTree2[0] = (int) heapTree2.value;
		arrayTree2[1] = (int) nodeL.value;
		arrayTree2[2] = (int) nodeM.value;
		arrayTree2[3] = (int) nodeN.value;
		arrayTree2[4] = (int) nodeO.value;
		arrayTree2[5] = (int) nodeP.value;
	}
	
	@Test
	void testCompleteTreeToArray() {
		assertArrayEquals(arrayTree1, Exercises.completeTreeToArray(heapTree1, 12));
		assertArrayEquals(arrayTree2, Exercises.completeTreeToArray(heapTree2, 6));
	}
}
