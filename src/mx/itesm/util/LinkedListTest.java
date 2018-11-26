package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LinkedListTest {
	
	private LinkedList<String> stringList;
	private LinkedList<Integer> integerList;
	private LinkedList<Float> floatList;
	
	@BeforeEach
    void setUp() throws Exception {
        stringList = new LinkedList<String>("Katniss", "Peeta", "Gale", "Haymitch", "Primrose", "Effie");
        integerList = new LinkedList<Integer>(0,1,1,1, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);
        floatList = new LinkedList<Float>();
    }
    
	@Test
	void testSize() {
		assertEquals(6, stringList.size());
        assertEquals(12, integerList.size());
        assertEquals(0, floatList.size());
	}

	@Test
	void testGet() {
		assertEquals("Katniss", stringList.get(0));
        assertEquals("Effie", stringList.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(6));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(-1));

        assertEquals(5, (int) integerList.get(5));
        assertEquals(55, (int) integerList.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(12));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(-1));
        
        assertThrows(IndexOutOfBoundsException.class, () -> floatList.get(0));
	}

	@Test
	void testSet() {
		assertEquals("Effie", stringList.set(5, "Cinna"));
        assertEquals("Haymitch", stringList.set(3, "Portia"));
        assertEquals("Peeta", stringList.set(1, "Flavius"));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(6, "Coriolanus"));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(-1, "Rue"));

        assertEquals(0, (int) integerList.set(0, -1));
        assertEquals(3, (int) integerList.set(4, 4));
        assertEquals(89, (int) integerList.set(11, 88));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.set(12, 1729));

        assertThrows(IndexOutOfBoundsException.class, () -> floatList.set(0, 6.022140857e23F));
	}
	
	@Test
	void testAddFirst() {
		stringList.addFirst("Cinna");
		assertEquals(7, stringList.size());
		assertEquals("Cinna", stringList.get(0));
		assertEquals("Katniss", stringList.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(7));
		assertThrows(NullPointerException.class, () -> stringList.addFirst(null));
		
		integerList.addFirst(5);
		assertEquals(13, integerList.size());
		assertEquals(5, (int) integerList.get(0));
		assertEquals(89, (int) integerList.get(12));
		assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(13));
		assertThrows(NullPointerException.class, () -> integerList.addFirst(null));
		
		assertThrows(NullPointerException.class, () -> floatList.addFirst(null));
		floatList.addFirst(9.0f);
		assertEquals(9.0f, (float) floatList.get(0));
		floatList.addFirst(2.0f);
		assertEquals(2.0f, (float) floatList.get(0));
		floatList.addFirst(4.0f);
		assertEquals(4.0f, (float) floatList.get(0));
		assertEquals(3, floatList.size());
	}
	
	@Test
	void testAddLast() {
		stringList.addLast("Cinna");
		assertEquals(7, stringList.size());
		assertEquals("Cinna", stringList.get(6));
		assertEquals("Effie", stringList.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(7));
		assertThrows(NullPointerException.class, () -> stringList.addLast(null));
		
		integerList.addLast(5);
		assertEquals(13, integerList.size());
		assertEquals(5, (int) integerList.get(12));
		assertEquals(89, (int) integerList.get(11));
		assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(13));
		assertThrows(NullPointerException.class, () -> integerList.addLast(null));
		
		assertThrows(NullPointerException.class, () -> floatList.addLast(null));
		floatList.addLast(9.0f);
		assertEquals(9.0f, (float) floatList.get(0));
		floatList.addLast(2.0f);
		assertEquals(2.0f, (float) floatList.get(1));
		floatList.addLast(4.0f);
		assertEquals(4.0f, (float) floatList.get(2));
		assertEquals(3, floatList.size());
	}

	@Test
	void testAdd() {
		stringList.add(0, "Buttercup");
        assertEquals(7, stringList.size());
        stringList.add(7, "Seneca");
        assertEquals(8, stringList.size());
        stringList.add(5, "Octavia");
        assertEquals(9, stringList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(10, "Venia"));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(-1, "Venia"));
        assertThrows(NullPointerException.class, () -> stringList.add(0, null));

        integerList.add(0, 0);
        integerList.add(144);
        assertEquals(14, integerList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.add(15, 233));
        assertThrows(NullPointerException.class, () -> integerList.add(4, null));

        assertThrows(IndexOutOfBoundsException.class, () -> floatList.add(1, 3.35988F));
        floatList.add(0, 1.30357F);
        floatList.add(1, 1.41421F);
        floatList.add(1, 1.61803F);
        assertEquals(3, floatList.size());
        assertThrows(NullPointerException.class, () -> floatList.add(3, null));
	}
	
	@Test
	void testRemoveFirst() {
		assertEquals("Katniss", stringList.removeFirst());
		assertEquals("Peeta", stringList.removeFirst());
		assertEquals("Gale", stringList.removeFirst());
		assertEquals("Haymitch", stringList.removeFirst());
		assertEquals("Primrose", stringList.removeFirst());
		assertEquals("Effie", stringList.removeFirst());
		assertThrows(NoSuchElementException.class, () -> stringList.removeFirst());
		assertEquals(0, stringList.size());
		
		for (int i = 0; i < integerList.size(); i++) {
			integerList.set(i, i);
		}
		int i = 0;
		while (integerList.size() > 0) {
			assertEquals(i++, (int) integerList.removeFirst());
		}
		assertThrows(NoSuchElementException.class, () -> integerList.removeFirst());
		assertEquals(0, integerList.size());
		
		assertThrows(NoSuchElementException.class, () -> floatList.removeFirst());
	}
	
	@Test
	void testRemoveLast() {
		assertEquals("Effie", stringList.removeLast());
		assertEquals("Primrose", stringList.removeLast());
		assertEquals("Haymitch", stringList.removeLast());
		assertEquals("Gale", stringList.removeLast());
		assertEquals("Peeta", stringList.removeLast());
		assertEquals("Katniss", stringList.removeLast());
		assertThrows(NoSuchElementException.class, () -> stringList.removeLast());
		assertEquals(0, stringList.size());
		
		for (int i = 0; i < integerList.size(); i++) {
			integerList.set(i, i);
		}
		int i = integerList.size() - 1;
		while (integerList.size() > 0) {
			assertEquals(i--, (int) integerList.removeLast());
		}
		assertThrows(NoSuchElementException.class, () -> integerList.removeLast());
		assertEquals(0, integerList.size());
		
		assertThrows(NoSuchElementException.class, () -> floatList.removeLast());
	}

	@Test
	void testRemove() {
		assertEquals("Katniss", stringList.remove(0));
        assertEquals(5, stringList.size());
        assertEquals("Peeta", stringList.remove(0));
        assertEquals(4, stringList.size());
        assertEquals("Effie", stringList.remove(3));
        assertEquals(3, stringList.size());
        assertEquals("Haymitch", stringList.remove(1));
        assertEquals(2, stringList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(-1));
        
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.remove(60));
        assertNotEquals(0, integerList.size());
        
        assertThrows(IndexOutOfBoundsException.class, () -> floatList.remove(0));
        assertEquals(0, floatList.size());
	}
	
	@Test
	void getFirst() {
		assertEquals("Katniss", stringList.getFirst());
		assertEquals(0, (int) integerList.getFirst());
		assertThrows(NoSuchElementException.class, () -> floatList.getFirst());
	}
	
	@Test
	void getLast() {
		assertEquals("Effie", stringList.getLast());
		assertEquals(89, (int) integerList.getLast());
		assertThrows(NoSuchElementException.class, () -> floatList.getLast());
	}
	
	@Test
	void count() {
		assertEquals(5, integerList.count(1));
		assertEquals(1, integerList.count(13));
	}

	@Test
	void removeFirstOccurrence() {
		assertEquals(true, integerList.removeFirstOccurrence(1));
		assertEquals(false, integerList.removeFirstOccurrence(-1));
	}

	@Test
	void removeLastOccurrence() {
		assertEquals(false, integerList.removeFirstOccurrence(-1));
		assertEquals(true, integerList.removeFirstOccurrence(1));
	}
	

	
}
