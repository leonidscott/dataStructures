import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBST {
	private BinarySearchTree<Integer,String> emptyTree;
	private BinarySearchTree<Integer,String> eightNodesTree;
	
	@Before
	public void setUp() {
		emptyTree = new BinarySearchTree<Integer,String>();
		eightNodesTree = new BinarySearchTree<Integer,String>();
		eightNodesTree.add(4, "apple");
		eightNodesTree.add(6, "banana");
		eightNodesTree.add(1, "strawberry");
		eightNodesTree.add(3, "kiwi");
		eightNodesTree.add(7, "lemon");
		eightNodesTree.add(10, "lime");
		eightNodesTree.add(5, "mango");
		eightNodesTree.add(8, "pear");
	}
	

	@Test
	public void TestEmpty() {
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test
	public void TestNonEmpty() {
		emptyTree.add(4, "apple");
		assertFalse(emptyTree.isEmpty());
	}
	
	@Test (expected=DuplicateKeyException.class)
	public void TestDuplicateKey() {
		eightNodesTree.add(7, "guava");
	}

	@Test
	public void TestAddGetRoot() {
		emptyTree.add(4, "apple");
		assertEquals("apple", emptyTree.get(4));
	}
	
	@Test (expected=NullPointerException.class)
	public void TestNullAdd() {
		eightNodesTree.add(null, "wussup");
	}
	
	@Test
	public void TestGetFromEmpty() {
		assertNull(emptyTree.get(4));
	}	
	
	@Test
	public void TestGet() {
		assertEquals("strawberry", eightNodesTree.get(1));
		assertEquals("lemon", eightNodesTree.get(7));
		assertEquals("mango", eightNodesTree.get(5));
		assertEquals("pear", eightNodesTree.get(8));
		assertEquals("kiwi", eightNodesTree.get(3));
	}	
	
	@Test
	public void TestGetNotThere() {
		assertNull(eightNodesTree.get(2));
	}	
	
	@Test (expected=NullPointerException.class)
	public void TestNullKey() {
		assertNull(eightNodesTree.get(null));
	}
	
	@Test
	public void TestClear() {
		eightNodesTree.clear();
		assertTrue(eightNodesTree.isEmpty());
		assertNull(eightNodesTree.get(4));
	}	
	
	// to-do: tests for remove
	@Test (expected=NullPointerException.class)
	public void TestNullRemove() {
		assertNull(eightNodesTree.remove(null));
	}
	
	// remove from empty
	@Test
	public void removeEmpty() {
		assertNull(emptyTree.remove(6));
		assertTrue(emptyTree.isEmpty());
	}
	// remove from root
	@Test
	public void removeRoot() {
		assertEquals("apple", eightNodesTree.remove(4));
		assertNull(eightNodesTree.get(4));
	}
	// remove mango
	@Test
	public void removeLeftLeaf() {
		assertEquals("mango", eightNodesTree.remove(5));
		assertNull(eightNodesTree.get(5));
	}
	// remove kiwi
	@Test
	public void removeRightLeaf() {
		assertEquals("kiwi", eightNodesTree.remove(4));
		assertNull(eightNodesTree.get(4));
	}
	// remove strawberry
	@Test
	public void removeNodeWithRightChild() {
		assertEquals("strawberry", eightNodesTree.remove(1));
		assertNull(eightNodesTree.get(1));
	}
	// remove lime
	@Test
	public void removeNodeWithLeftChild() {
		assertEquals("lime", eightNodesTree.remove(10));
		assertNull(eightNodesTree.get(10));
	}
	// remove banana
	@Test
	public void removeNodeWithTwoChildren() {
		assertEquals("banana", eightNodesTree.remove(6));
		assertNull(eightNodesTree.get(6));
	}
}