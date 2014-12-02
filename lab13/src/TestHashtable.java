import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestHashtable {
	OurHashtable<Integer, String> emptyTable = new HashtableSeparateChaining<Integer, String>();
	OurHashtable<Integer, String> fourElementTable = new HashtableSeparateChaining<Integer, String>();
	OurHashtable<Integer, String> repeatedKeysTable = new HashtableSeparateChaining<Integer, String>();
	OurHashtable<Integer, Integer> sizeFiveTable = new HashtableSeparateChaining<Integer, Integer>(5);
	@Before
	public void setUp() {
		// setting up fourElement table, no repeats
		fourElementTable.put(4, "apple");
		fourElementTable.put(6, "banana");
		fourElementTable.put(1, "strawberry");
		fourElementTable.put(3, "kiwi");

		// setting up repeatedKeysTable, assuming 20 buckets
		repeatedKeysTable.put(4, "apple");
		repeatedKeysTable.put(3, "banana");
		repeatedKeysTable.put(27, "grape");
		repeatedKeysTable.put(33, "orange");
		repeatedKeysTable.put(10, "pomegranate");
		repeatedKeysTable.put(45, "grapefruit");
		repeatedKeysTable.put(17, "clementine");
		repeatedKeysTable.put(44, "strawberry"); // these two should
		repeatedKeysTable.put(23, "kiwi");		 // cause hash collisions
			
	}
	
	@Test
	public void TestSizeAndEmptyWithEmptyTable() {
		assertTrue(emptyTable.isEmpty());
		assertEquals(0, emptyTable.size());
	}
	
	@Test
	public void TestSizeAndEmptyWithNonEmptyTable() {
		assertFalse(fourElementTable.isEmpty());
		assertFalse(repeatedKeysTable.isEmpty());
		
		assertEquals(4, fourElementTable.size());
		assertEquals(9, repeatedKeysTable.size());
	}
	
	@Test
	public void TestClear() {
		emptyTable.clear();
		assertEquals(emptyTable.size(), 0);
		
		repeatedKeysTable.clear();
		assertEquals(repeatedKeysTable.size(), 0);
		repeatedKeysTable.clear();
		assertEquals(repeatedKeysTable.size(), 0);
	}
	
	@Test
	public void TestPushOnEmpty(){
		sizeFiveTable.put(0, 4);		
		assertEquals(new Integer(4), sizeFiveTable.get(0));
	}
	
	@Test
	public void TestPut(){
		
		sizeFiveTable.put(0, 4);
		sizeFiveTable.put(1, 3);
		sizeFiveTable.put(2, 2);
		sizeFiveTable.put(3, 1);
		sizeFiveTable.put(4, 0);
		
		assertEquals(new Integer(3), sizeFiveTable.get(1));
		assertEquals(new Integer(2), sizeFiveTable.get(2));
		assertEquals(new Integer(1), sizeFiveTable.get(3));
		assertEquals(new Integer(0), sizeFiveTable.get(4));
	}
	
	@Test
	public void TestPutWithCollisions(){
		
		sizeFiveTable.put(0, 4);
		sizeFiveTable.put(1, 3);
		sizeFiveTable.put(2, 2);
		sizeFiveTable.put(3, 1);
		sizeFiveTable.put(2, 5);   	//Should cause a collision
		
		assertEquals(new Integer(2), sizeFiveTable.get(2));
		
		sizeFiveTable.put(8, 6);   	//Should cause a collision
		
		assertEquals(new Integer(6), sizeFiveTable.get(8));
		
		sizeFiveTable.put(9, 9001);
		
		assertEquals(new Integer(9001), sizeFiveTable.get(9));
	}

	@Test
	public void TestGetNotThere(){
		assertNull(repeatedKeysTable.get(500));
	}

	@Test(expected=NullPointerException.class)
	public void TestGetNull() {
		repeatedKeysTable.get(null);
	}

	@Test
	public void TestGetWithoutModdedKeys() {
		assertEquals("pomegranate", repeatedKeysTable.get(10));
		assertEquals("clementine", repeatedKeysTable.get(17));
	}
	
	@Test
	public void TestGetWithModdedKeys() {
		assertEquals("grape", repeatedKeysTable.get(27));
		assertEquals("orange", repeatedKeysTable.get(33));
	}
	
	@Test
	public void TestGetWithCollision(){
		assertEquals("apple", repeatedKeysTable.get(4));
		assertEquals("banana", repeatedKeysTable.get(3));
		assertEquals("strawberry", repeatedKeysTable.get(44));
	}
	
	
	
}