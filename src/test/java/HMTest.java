import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HMTest{

	MyHashMap<Integer> hm;
	
	//Constructed hashmap and initialized it with a couple of values
	@BeforeEach
	void constructor(){
		hm = new MyHashMap<Integer>("Walter White", 23);
		hm.put("Jesse Pinkman", 3);
		hm.put("Hank Schrader", 6);
	}
	
	//test for contain() function
	@Test
	void contains() {
		assertTrue(hm.contains("Walter White"), "contains() function not working correctly");
	}
	
	//test for get() function
	@Test
	void get() {
		assertEquals(3, hm.get("Jesse Pinkman"), "get() function not working correctly");
	}
	
	//tests for size and isEmpty() functions
	@Test
	void size() {
		assertEquals(3, hm.size(), "size() function not working correctly");
	}
	
	@Test
	void isEmpty() {
		assertEquals(false, hm.isEmpty(), "isEmpty() is not detecting correctly");
	}
	
	
	//tests if the hashmap properly replaces the value of a given key
	@Test
	void replace() {
		hm.replace("Walter White", 7);
		assertEquals(7, hm.get("Walter White"), "Replace() is not working correctly");
	}
	

	//Tests if the iterator is working properly
	@Test
	void iterator() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(3);
		al.add(6);
		al.add(23);
		int count = 0;
		for(Integer i : hm) {
			assertEquals(al.get(count), i, "Wrong Value");
			count++;
		}
	}
	
}