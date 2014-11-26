import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestRebalancingAVL {
	/*
	 * *** SET UP ***
	 */
	
	private AVLTree<Integer, String> testTree = new AVLTree<Integer, String>();
	private AVLTree<Integer,String> sevenNodesTree = new AVLTree<Integer, String>();
	private AVLTree<Integer, String> leftHeavy = new AVLTree<Integer, String>();
	private AVLTree<Integer, String> rightHeavy = new AVLTree<Integer, String>();
	
	@Before
	public void setUp() throws Exception {
		sevenNodesTree = new AVLTree<Integer, String>();
		sevenNodesTree.add(4, "apple");
		sevenNodesTree.add(2, "banana");
		sevenNodesTree.add(7, "strawberry");
		sevenNodesTree.add(1, "kiwi");
		sevenNodesTree.add(3, "lemon");
		sevenNodesTree.add(6, "lime");
		sevenNodesTree.add(8, "mango");
	}
	
	@Before
	public void setUpLeftHeavy() throws Exception {
		leftHeavy.add(10, "a");
		leftHeavy.add(5, "b");
		leftHeavy.add(15, "c");
		leftHeavy.add(2, "d");
		leftHeavy.add(7, "e");
	}
	
	@Before
	public void setUpRightHeavy() throws Exception {
		rightHeavy.add(10, "a");
		rightHeavy.add(5, "b");
		rightHeavy.add(15, "c");
		rightHeavy.add(12, "d");
		rightHeavy.add(17, "e");
	}
	
	/*
	 * 	*** TEST HEIGHTS ***
	 */
	
	@Test
	public void testHeightRoot() throws Exception {
		testTree.add(10, "a");
		assertEquals(1, testTree.getHeight(10));
	}
	
	@Test
	public void testHeightLeft() throws Exception {
		testTree.add(10, "a");
		testTree.add(5, "b");
		assertEquals(2, testTree.getHeight(10));
		assertEquals(1, testTree.getHeight(5));
	}
	
	@Test
	public void testHeightRight() throws Exception {
		testTree.add(10, "a");
		testTree.add(15, "b");
		assertEquals(2, testTree.getHeight(10));
		assertEquals(1, testTree.getHeight(15));
	}
	
	/*
	 * 	TEST BALANCING
	 */
	
	@Test
	public void testBalanceLeftRight() throws Exception {
		testTree.add(10, "a");
		testTree.add(5, "b");
		testTree.add(7, "c");
		assertEquals(1, testTree.getHeight(10));
		assertEquals(1, testTree.getHeight(5));
		assertEquals(2, testTree.getHeight(7));
	}
	
	@Test
	public void testBalanceLeftLeft() throws Exception {
		testTree.add(10, "a");
		testTree.add(7, "b");
		testTree.add(5, "c");
		assertEquals(1, testTree.getHeight(10));
		assertEquals(2, testTree.getHeight(7));
		assertEquals(1, testTree.getHeight(5));
	}
	
	@Test
	public void testBalanceRightLeft() throws Exception {
		testTree.add(10, "a");
		testTree.add(15, "b");
		testTree.add(12, "c");
		assertEquals(1, testTree.getHeight(10));
		assertEquals(1, testTree.getHeight(15));
		assertEquals(2, testTree.getHeight(12));
	}
	
	@Test
	public void testBalanceRightRight() throws Exception {
		testTree.add(10, "a");
		testTree.add(15, "b");
		testTree.add(17, "c");
		assertEquals(1, testTree.getHeight(10));
		assertEquals(2, testTree.getHeight(15));
		assertEquals(1, testTree.getHeight(17));
	}
	
	/*
	 * 	*** TEST BIG TREES ***
	 */
	
	@Test
	public void testBigLeftRightAddLeft() throws Exception {
		
	}
	
	@Test
	public void testBigLeftRightAddRight() throws Exception {
		
	}
	
	@Test
	public void testBigLeftLeftAddLeft() throws Exception {
		
	}
	
	@Test
	public void testBigLeftLeftAddRight() throws Exception {
		
	}
	
	@Test
	public void testBigRightLeftAddLeft() throws Exception {
		
	}
	
	@Test
	public void testBigRightLeftAddRight() throws Exception {
		
	}
	
	@Test
	public void testBigRightRightAddLeft() throws Exception {
		
	}
	
	@Test
	public void testBigRightRightAddRight() throws Exception {
		
	}
	
}
