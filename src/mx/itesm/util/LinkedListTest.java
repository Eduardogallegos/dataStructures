package mx.itesm.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LinkedListTest {
	
	private LinkedList<String> stringList;
	
	@BeforeEach
	void setUp() {
		stringList = new LinkedList<String> ("Katniss", "Petta", "Gale", "Haymitch", "Primrose", "Effie");
	}

	@Test
	void testSize() {
		assertEquals(6, stringList.size());
	}
	
	@Test
	void testGet() {
		assertEquals("Katniss", stringList.get(0));
	}

}
