// Ryan McArthur, Lenny, Lemmon
// Lab12

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestRebalancingAVL {
	
	/*
	 * *** SET UP ***
	 */
	
	private AVLTree<Integer, String> testTree = new AVLTree<Integer, String>();
	private AVLTree<Integer, String> sevenNodesTree = new AVLTree<Integer, String>();
	private AVLTree<Integer, String> leftHeavy = new AVLTree<Integer, String>();
	private AVLTree<Integer, String> rightHeavy = new AVLTree<Integer, String>();
	
	@Before
	public void setUp() throws Exception {
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
		leftHeavy.add(6, "f");
		assertEquals(3, leftHeavy.getHeight(7)); // this is root
		assertEquals(2, leftHeavy.getHeight(5));
		assertEquals(2, leftHeavy.getHeight(10));
		assertEquals(1, leftHeavy.getHeight(2));
		assertEquals(1, leftHeavy.getHeight(6));
		assertEquals(1, leftHeavy.getHeight(15));
	}
	
	@Test
	public void testBigLeftRightAddRight() throws Exception {
		leftHeavy.add(8, "f");
		assertEquals(3, leftHeavy.getHeight(7)); // this is root
		assertEquals(2, leftHeavy.getHeight(5));
		assertEquals(2, leftHeavy.getHeight(10));
		assertEquals(1, leftHeavy.getHeight(2));
		assertEquals(1, leftHeavy.getHeight(8));
		assertEquals(1, leftHeavy.getHeight(15));
	}
	
	@Test
	public void testBigLeftLeftAddLeft() throws Exception {
		leftHeavy.add(1, "f");
		assertEquals(3, leftHeavy.getHeight(5)); // this is root
		assertEquals(2, leftHeavy.getHeight(2));
		assertEquals(2, leftHeavy.getHeight(10));
		assertEquals(1, leftHeavy.getHeight(1));
		assertEquals(1, leftHeavy.getHeight(7));
		assertEquals(1, leftHeavy.getHeight(15));
		
	}
	
	@Test
	public void testBigLeftLeftAddRight() throws Exception {
		leftHeavy.add(3, "f");
		assertEquals(3, leftHeavy.getHeight(5)); // this is root
		assertEquals(2, leftHeavy.getHeight(2));
		assertEquals(2, leftHeavy.getHeight(10));
		assertEquals(1, leftHeavy.getHeight(3));
		assertEquals(1, leftHeavy.getHeight(7));
		assertEquals(1, leftHeavy.getHeight(15));
	}
	
	@Test
	public void testBigRightLeftAddLeft() throws Exception {
		rightHeavy.add(11, "f");
		assertEquals(3, rightHeavy.getHeight(12)); // this is root
		assertEquals(2, rightHeavy.getHeight(10));
		assertEquals(2, rightHeavy.getHeight(15));
		assertEquals(1, rightHeavy.getHeight(5));
		assertEquals(1, rightHeavy.getHeight(11));
		assertEquals(1, rightHeavy.getHeight(17));
	}
	
	@Test
	public void testBigRightLeftAddRight() throws Exception {
		rightHeavy.add(13, "f");
		//assertEquals(3, rightHeavy.getHeight(12)); // this is root
		assertEquals(2, rightHeavy.getHeight(10));
		assertEquals(2, rightHeavy.getHeight(15));
		assertEquals(1, rightHeavy.getHeight(5));
		assertEquals(1, rightHeavy.getHeight(13));
		assertEquals(1, rightHeavy.getHeight(17));
	}
	
	@Test
	public void testBigRightRightAddLeft() throws Exception {
		rightHeavy.add(16, "f");
		assertEquals(3, rightHeavy.getHeight(15)); // this is root
		assertEquals(2, rightHeavy.getHeight(10));
		assertEquals(2, rightHeavy.getHeight(17));
		assertEquals(1, rightHeavy.getHeight(5));
		assertEquals(1, rightHeavy.getHeight(12));
		assertEquals(1, rightHeavy.getHeight(16));
	}
	
	@Test
	public void testBigRightRightAddRight() throws Exception {
		rightHeavy.add(18, "f");
		assertEquals(3, rightHeavy.getHeight(15)); // this is root
		assertEquals(2, rightHeavy.getHeight(10));
		assertEquals(2, rightHeavy.getHeight(17));
		assertEquals(1, rightHeavy.getHeight(5));
		assertEquals(1, rightHeavy.getHeight(12));
		assertEquals(1, rightHeavy.getHeight(18));
	}
	
}
