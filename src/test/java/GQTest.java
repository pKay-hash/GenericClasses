import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GQTest {
	
	static int i;
	GenericQueue<Integer> res;
	
	@BeforeAll
	static void initIterator() {
		i = 0;
	}
	
	@BeforeEach
	void setUpQueue() {//calls constructor for GenericQueue
		res = new GenericQueue<Integer>(7);		
		res.enqueue(8);
		res.enqueue(9);
		
	}
	
	@Test
	void constructor() {//tests if the constructor correctly add a value to the GenericQueue
		assertEquals(7, res.get(0), "Did not add run constructor correctly");
	}
	
	@Test
	void lengthGetTest() {//tests if the getLength function works properly
		assertEquals(3, res.getLength(), "getLength() did not correctly get the length");
	} 
	
	@Test
	void lengthSetTest() {//tests if the setLength function works properly
		res.setLength(2);
		assertEquals(2, res.getLength(), "setLength() did not correctly set the length");
	}
	
	@Test
	void headGetTest() {//tests if the getHead function works properly
		assertEquals(7, res.getHead().getData(), "getHead() did not correctly acquire the head");
	}
	
	@Test
	void headSetTest() {//tests if the setHead function works properly
		res.setHead(res.getHead().getNext());
		assertEquals(8, res.getHead().getData(), "setHead() did not correctly set the head");
	}
	
	@ParameterizedTest
	@ValueSource(ints = {8, 9})
	void enqueue(int val) {//tests if the add function correctly works when there is something else in the list
		i++;
		assertEquals(val, res.get(i), "Did not add correctly");
	}
	
	@Test
	void dequeue() {//tests if the delete function correctly works
		assertEquals(7, res.dequeue(), "Did not delete correctly");
	}
	
	@Test
	void dequeue1() {//tests if the delete function correctly deletes everything in the list
		res.dequeue();//should remove 7
		assertEquals(8, res.dequeue(), "Did not delete 8 correctly");//should remove 8
		assertEquals(9, res.dequeue(), "Did not delete 9 correctly");//should remove 9
		assertEquals(null, res.dequeue(), "Did not delete everything correctly");//shouldn't remove anything
	}
	
	@Test
	void dequeue2() {//tests if the add function correctly works when there is nothing in the list
		res.dequeue();//should remove 7
		res.dequeue();//should remove 8
		res.dequeue();//should remove 9
		res.dequeue();//shouldn't remove anything
		res.enqueue(8);
		assertEquals(8, res.get(0), "Did not add correctly (after dequeuing everything)");
	}
	
	@Test
	void setTest() {//tests if the set function correctly works when overwriting an existing node		
		res.set(1, 8);
		assertEquals(8, res.get(1), "Did not set() correctly");
	}
	
	@Test
	void dumpList() {//tests if the set function correctly works when trying to set over a non-existing node	
		ArrayList<Integer> al = res.dumpList();
		assertEquals(al.get(0), res.get(0), "Did not dumpList() correctly");
		assertEquals(al.get(1), res.get(1), "Did not dumpList() correctly");
		assertEquals(al.get(2), res.get(2), "Did not dumpList() correctly");
	}
	
	@Test
	void printTest() {//visual test for print() function, considering the print() function does not return any value
		res.print();//calls print() function, should print "789"
	}
	
	@Test
	void forEachTest() {//tests if the for each loop is working (using GLLIterator)
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(7);
		al.add(8);
		al.add(9);
		int counter = 0;
		for(Integer i : res) {
			assertEquals(al.get(counter), i, "For Each loop is not working");
			counter++;
		}
	}
	
	@Test
	void reverseIteratorTest() {
		i = 2;
		int arr[] = {7, 8, 9};
		Iterator<Integer> it = res.descendingIterator();
		while(it.hasNext()) {
			assertEquals(arr[i], it.next(), "reverse iterator not working");
			i--;
		}
	}
	
	
}
