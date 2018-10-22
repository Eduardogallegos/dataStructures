package mx.itesm.exercises;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Exam2Test {
/*
	@Test
	void testMaxSymbolDepth() {
		assertEquals(0, Exam2.maxSymbolDepth("", '(', ')'));
		assertEquals(1, Exam2.maxSymbolDepth("a(b)c", '(', ')'));
		assertEquals(3, Exam2.maxSymbolDepth(")))a(((", ')', '('));
		assertEquals(4, Exam2.maxSymbolDepth("a(b(c(de(f/g/  /h/i((/j/", '(', '/'));
		assertEquals(-1, Exam2.maxSymbolDepth("a%b%cde%f$g$  $h$i%%$j$", '%', '$'));
		assertEquals(-1, Exam2.maxSymbolDepth("((", '(', '('));
		assertEquals(-1, Exam2.maxSymbolDepth("()", '(', ']'));
		assertEquals(-1, Exam2.maxSymbolDepth("(()", '(', ')'));
	}
	*/
	@Test
    public void testMax() {
        List<Integer> empty = Arrays.asList();
        List<Integer> a = Arrays.asList(16, 23, 4, 42, 8, 15);
        List<Integer> b = Arrays.asList(-16, -23, -4, -42, -8, -15);
        List<Integer> c = Arrays.asList(780, 560, 726, 524,
                794, 454, 628, 335, 786, 992, 559, 798, 427,
                382, 900, 391, 981, 432, 963, 727, 863, 861,
                38, 567, 29, 805, 711, 926, 902, 97, 469,
                644, 687, 605, 503, 530, 145, 161, 425, 417,
                410, 963, 729, 899, 57, 366, 600, 721, 536,
                125, 491, 192, 961, 749, 785, 271, 660, 646,
                73, 894, 74, 574, 993, 239, 384, 347, 390,
                695, 469, 965, 685, 865, 605, 518, 572, 380,
                895, 625, 410, 804, 681, 190, 351, 889, 155,
                389, 289, 984, 950, 694, 953, 222, 372, 752,
                367, 771, 386, 645, 614, 93, 386, 21, 444,
                123, 332, 236, 227, 57, 896, 321, 428, 978,
                726, 598, 516, 539, 316, 461, 288, 930, 806,
                480, 197, 111, 206, 86, 875, 254, 936, 156,
                566, 719, 244, 662, 133, 860, 654, 445, 479,
                755, 37, 57, 208, 383, 502, 794, 538, 742,
                760, 355, 52, 530, 128, 359, 298, 847, 794,
                660, 721, 84, 498, 225, 296, 60, 511, 427,
                905, 118, 542, 572, 708, 334, 377, 648, 983,
                327, 127, 578, 756, 113, 936, 737, 950, 982,
                905, 317, 372, 745, 83, 169, 134, 552, 850,
                198, 707, 680, 977, 599, 276, 714);
        assertEquals(Integer.MIN_VALUE, (int) Exam2.max(empty));
        assertEquals(42, (int) Exam2.max(a));
        assertEquals(-4, (int) Exam2.max(b));
        assertEquals(993, (int) Exam2.max(c));
    }
	
	@Test
    public void testToBinary() {
        assertArrayEquals("".toCharArray(), Exam2.toBinary(0).toCharArray());
        assertArrayEquals("1".toCharArray(), Exam2.toBinary(1).toCharArray());
        assertArrayEquals("101".toCharArray(), Exam2.toBinary(5).toCharArray());
        assertArrayEquals("11111".toCharArray(), Exam2.toBinary(31).toCharArray());
        assertArrayEquals("100000".toCharArray(), Exam2.toBinary(32).toCharArray());
        assertArrayEquals("1010011010".toCharArray(), Exam2.toBinary(666).toCharArray());
        assertArrayEquals("1010101010101".toCharArray(), Exam2.toBinary(5461).toCharArray());
    }
}
