// Lenny Scott, Take Home 2: Tests
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class TestSortingList {
	SortingList<Integer> empty = new MySortingList<Integer>();
	SortingList<Integer> filled = new MySortingList<Integer>();	
	SortingList<Integer> removeFromFilled = filled; //for remove with subNodes
	
	/*
	 * TESTING INDIVDUAL FUNCTIONALITY
	 * Note: Testing by order of importance 
	 * (to test fully test clear(), you have to have added elements first)
	 */
	
	//========= add() and get() =========
	
	/*
	 * ADD/GET: EDGE CASE
	 */
	@Test (expected = ListIndexOutOfBoundsException.class)
	public void getFromNonExistantIndex() throws ListIndexOutOfBoundsException {
		// Tests getting from a place that doesn't exist
		empty.get(5);
	}
	
	/*
	 * ADD/GET: KEY NODES
	 */
	@Test
	public void addAndGetKeyNodesIsPossible() throws ListIndexOutOfBoundsException {
		// Tests adding and getting at element 0
		filled.add(5);
		assertEquals(new Integer(5), filled.get(0));
			
		// Non progressive test
		filled.add(7);
		assertEquals(new Integer(7), filled.get(1));
		
		filled.add(14);
		assertEquals(new Integer(14), filled.get(2));
		
	}
	@Test
	public void addedKeyNodesAreSorted() throws ListIndexOutOfBoundsException {
		filled.add(5);
		System.out.println("===== added 5 =====");
		assertEquals(new Integer(5), filled.get(0));
		filled.add(7);
		System.out.println("===== added 7=====");
		assertEquals(new Integer(7), filled.get(1));
		filled.add(6);
		System.out.println("===== added 6=====");
		assertEquals(new Integer(6), filled.get(2));
	}
	
	@Test
	public void addAndGetKeyNodesAreSorted() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		
		// Tests elements are put in increasing order
		filled.add(3);
		System.out.println("*** First Test ****");
		assertEquals(new Integer(3), filled.get(0));
		System.out.println("get at 0 " + filled.get(0));
		System.out.println("*** Second Test ****");
		assertEquals(new Integer(5), filled.get(1));

		filled.add(7);
		assertEquals(new Integer(7), filled.get(2));
	}
	
	/*
	 * ADD/GET: SUB NODES
	 */
	@Test
	public void addAndGetSubNode() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		
		// Tests adding to create a subNode
		filled.add(5);
		assertEquals(new Integer(5), filled.get(2));
		assertEquals(new Integer(7), filled.get(3)); // checks if adding subNodes shifts keyNodes
		
		filled.add(5);
		assertEquals(new Integer(3), filled.get(3));
		assertEquals(new Integer(7), filled.get(4)); // checks if adding subNodes shifts keyNodes
	}
	
	@Test
	public void addAndGetSubNodesPossible() throws ListIndexOutOfBoundsException {
		filled.add(5);
		filled.add(5);
		assertEquals(new Integer(5), filled.get(1));
	}
	
	@Test
	public void addAndGetKeyNodesWithSubNodes() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);

		// Tests adding keyNodes does not screw up subNodes
		filled.add(6);
		filled.add(4);
		assertEquals(new Integer(4), filled.get(1));
		assertEquals(new Integer(5), filled.get(4));
		assertEquals(new Integer(6), filled.get(5));
		assertEquals(new Integer(7), filled.get(6));
	}
	
	@Test
	public void addAndGetAdjacentSubNodes() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
				
		// Increasing Complexity
		filled.add(3);
		assertEquals(new Integer(3), filled.get(1));
		assertEquals(new Integer(4), filled.get(4));
		assertEquals(new Integer(7), filled.get(7));

		// Tests that two adjacent subNodes don't interfere with each other
		filled.add(6);
		filled.add(6);
		assertEquals(new Integer(6), filled.get(7));
		assertEquals(new Integer(7), filled.get(8));
		assertEquals(new Integer(7), filled.get(9));
	}
	
	//========= isEmpty() =========
	@Test
	public void isEmpty() {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		
		assertTrue(empty.isEmpty());
		assertTrue(!filled.isEmpty());
	}
	
	// ========= size() =========
	@Test
	public void size() {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
				
		SortingList<Integer> addable = new MySortingList<Integer>();
		
		assertTrue(empty.size() == 0);
		assertTrue(filled.size() == 10);
		assertTrue(addable.size() == 0);
		
		addable.add(10);
		
		assertTrue(addable.size() == 1);
	}
	
	// ========= uniqueValueCount() =========
	@Test
	public void uniqueValueCount() {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		
		SortingList<Integer> subListed = new MySortingList<Integer>();
		subListed.add(5);
		subListed.add(5);
		
		assertEquals(0, empty.uniqueValueCount());
		assertEquals(1, subListed.uniqueValueCount());
		assertEquals(5, filled.uniqueValueCount());
	}
	
	// ========= clear() =========
	@Test
	public void clear() {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		
		SortingList<Integer> copy = filled;
		
		empty.clear();
		assertEquals(0, empty.size());
		copy.clear();
		assertEquals(0, filled.size());
	}
	
	// ========= remove() =========
	
	/*
	 * REMOVE: EDGE CASES
	 */
	@Test (expected = ListIndexOutOfBoundsException.class)
	public void removeFromEmpty() throws ListIndexOutOfBoundsException {
		// Test removing from an an empty list
		empty.remove(0);
	}
	
	@Test (expected = ListIndexOutOfBoundsException.class)
	public void removeFromBadIndex() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		
		SortingList<Integer> copy = filled;
		
		// Test removing from an unsupported index
			copy.remove(13);
		
		// Test removing from a non-existant index
			copy.remove(-1);
	}
	
	/*
	 * REMOVE: KEY NODES
	 */
	@Test
	public void removeKeyNodes() throws ListIndexOutOfBoundsException {
		
		SortingList<Integer> keyNodes = new MySortingList<Integer>(); // for testing remove
		keyNodes.add(-10);
		keyNodes.add(-5);
		keyNodes.add(0);
		keyNodes.add(5);
		keyNodes.add(10);
		
		// Test basic remove of keyNode without subNode
		keyNodes.remove(1);
		assertEquals(4, keyNodes.size());
		assertEquals(new Integer(-10), keyNodes.get(0));
		assertEquals(new Integer(0), keyNodes.get(1));
		
		// Test remove of the element zero
		keyNodes.remove(0);
		assertEquals(3, keyNodes.size());
		assertEquals(new Integer(0), keyNodes.get(0));
		
		// Test remove of the last keyNode without subNode
		keyNodes.remove(2);
		assertEquals(2, keyNodes.size());
		assertEquals(new Integer(5), keyNodes.get(1));
	}
	
	/*
	 * REMOVE: SUB NODES
	 */
	@Test
	public void removeKeyNodeNearSubNode() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);

		
		// Test makes sure that removing a keyNode near subNodes does not shift anything badly
		filled.remove(2);
		assertEquals(9, filled.size());
		assertEquals(new Integer(5), filled.get(2));
	}
	
	@Test
	public void removeSubNodeMiddle() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		filled.remove(2);
		
		// Test removes from a middle point of a list of SubNodes
		filled.remove(3);
		assertEquals(8, filled.size());
		assertEquals(new Integer(5), filled.get(2));
		assertEquals(new Integer(5), filled.get(3));
	}
	
	@Test
	public void removeSubNodeLast() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		filled.remove(2);
		filled.remove(3);
		
		// Test removes from the last point of a list of SubNodes
		removeFromFilled.remove(3);
		assertEquals(7, removeFromFilled.size());
		assertEquals(new Integer(5), removeFromFilled.get(2));
		assertEquals(new Integer(6), removeFromFilled.get(3));
	}
	
	@Test
	public void removeKeyNodeOfSubNode() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		filled.remove(2);
		filled.remove(3);
		filled.remove(3);
		
		removeFromFilled = filled;
		
		// Test removes from the keyNode while there are subNodes attached to it
		removeFromFilled.remove(3);
		assertEquals(6, removeFromFilled.size());
		assertEquals(new Integer(5), removeFromFilled.get(2));
		assertEquals(new Integer(6), removeFromFilled.get(3));
		assertEquals(new Integer(7), removeFromFilled.get(5));
	}
	
	@Test
	public void removeHeadWithSubNode() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		filled.remove(2);
		filled.remove(3);
		filled.remove(3);
		filled.remove(3);
		removeFromFilled = filled;
		
		// Test removing the head while it has subNodes and letting the new keyNode appropriately take its place
		removeFromFilled.remove(0);
		assertEquals(5, removeFromFilled.size());
		assertEquals(new Integer(3), removeFromFilled.get(0));
		assertEquals(new Integer(5), removeFromFilled.get(1));
	}
	
	@Test
	public void removeLastKeyNodeWithSubNode() throws ListIndexOutOfBoundsException {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		filled.remove(2);
		filled.remove(3);
		filled.remove(3);
		filled.remove(3);
		filled.remove(0);
		removeFromFilled = filled;
		
		// Test removing the last keyNode while it has subNodes and letting the new keyNode appropriately take its place
		removeFromFilled.remove(3);
		assertEquals(4, removeFromFilled.size());
		assertEquals(new Integer(7), removeFromFilled.get(3));
		assertEquals(new Integer(6), removeFromFilled.get(2));
	}
	
	@Test
	public void iteratorWorks () {
		// Progressive set up
		filled.add(5);
		filled.add(3);
		filled.add(7);
		filled.add(5);
		filled.add(5);
		filled.add(6);
		filled.add(4);
		filled.add(3);
		filled.add(6);
		filled.add(6);
		
		// Test iterator provides values in the sorted order dictated by the rules of the data structure
		Integer[] someIntegers = new Integer[10];
		Integer[] correctOutPutArrayList = {3, 3, 4, 5, 5, 5, 6, 6, 6, 7};
		
		int index = 0;
		
		for (Integer i : filled) {
			someIntegers[index] = i;
		}
		
		assertArrayEquals(correctOutPutArrayList, someIntegers);
	}
}
