import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestOrders {
	private BinarySearchTree<Integer, String> specialCaseTree = new BinarySearchTree<Integer, String>();
	private BinarySearchTree<Integer, String> filledTree = new BinarySearchTree<Integer, String>();
	
	private ArrayList<Pair<Integer, String>> empty = new ArrayList<Pair<Integer, String>>();
	private ArrayList<Pair<Integer, String>> onePair = new ArrayList<Pair<Integer, String>>();
	private ArrayList<Pair<Integer, String>> preOrderResults = new ArrayList<Pair<Integer, String>>();
	private ArrayList<Pair<Integer, String>> postOrderResults = new ArrayList<Pair<Integer, String>>();
	private ArrayList<Pair<Integer, String>> inOrderResults = new ArrayList<Pair<Integer, String>>();
	
	@Before
	public void setUpSpecialCaseTree() {
		specialCaseTree.add(16, "a1");
	}
	
	@Before
	public void setUpFilledBST() throws Exception {
		filledTree.add(16, "a1");
		filledTree.add(24, "b2");
		filledTree.add(8, "b1");
		filledTree.add(28, "c4");
		filledTree.add(20, "c3");
		filledTree.add(12, "c2");
		filledTree.add(4, "c1");
		filledTree.add(30, "d4");
		filledTree.add(26, "d3");
		filledTree.add(22, "d2");
		filledTree.add(10, "d1");
	}
	
	@Before
	public void setUpPreOrderResults() {
		preOrderResults.add(new Pair<Integer, String>(16, "a1"));
		preOrderResults.add(new Pair<Integer, String>(8, "b1"));
		preOrderResults.add(new Pair<Integer, String>(4, "c1"));
		preOrderResults.add(new Pair<Integer, String>(12, "c2"));
		preOrderResults.add(new Pair<Integer, String>(10, "d1"));
		preOrderResults.add(new Pair<Integer, String>(24, "b2"));
		preOrderResults.add(new Pair<Integer, String>(20, "c3"));
		preOrderResults.add(new Pair<Integer, String>(22, "d2"));
		preOrderResults.add(new Pair<Integer, String>(28, "c4"));
		preOrderResults.add(new Pair<Integer, String>(26, "d3"));
		preOrderResults.add(new Pair<Integer, String>(30, "d4"));
	}
	
	@Before
	public void setUpPostOrderResults() {
		postOrderResults.add(new Pair<Integer, String>(4, "c1"));
		postOrderResults.add(new Pair<Integer, String>(10, "d1"));
		postOrderResults.add(new Pair<Integer, String>(12, "c2"));
		postOrderResults.add(new Pair<Integer, String>(8, "b1"));
		postOrderResults.add(new Pair<Integer, String>(22, "d2"));
		postOrderResults.add(new Pair<Integer, String>(20, "c3"));
		postOrderResults.add(new Pair<Integer, String>(26, "d3"));
		postOrderResults.add(new Pair<Integer, String>(30, "d4"));
		postOrderResults.add(new Pair<Integer, String>(28, "c4"));
		postOrderResults.add(new Pair<Integer, String>(24, "b2"));
		postOrderResults.add(new Pair<Integer, String>(16, "a1"));
	}
	
	@Before
	public void setUpInOrderResults() {
		inOrderResults.add(new Pair<Integer, String>(4, "c1"));
		inOrderResults.add(new Pair<Integer, String>(8, "b1"));
		inOrderResults.add(new Pair<Integer, String>(10, "d1"));
		inOrderResults.add(new Pair<Integer, String>(12, "b2"));
		inOrderResults.add(new Pair<Integer, String>(16, "a1"));
		inOrderResults.add(new Pair<Integer, String>(20, "c3"));
		inOrderResults.add(new Pair<Integer, String>(22, "d2"));
		inOrderResults.add(new Pair<Integer, String>(24, "b2"));
		inOrderResults.add(new Pair<Integer, String>(26, "d3"));
		inOrderResults.add(new Pair<Integer, String>(28, "c4"));
		inOrderResults.add(new Pair<Integer, String>(30, "d4"));
	}

	/*
	 * 	*** TESTING PRE_ORDER ***
	 */
	
	@Test
	public void preOrderEmpty() {
		assertEquals(specialCaseTree.preOrder(), empty);
	}
	
	@Test
	public void preOrderOneNode() {
		onePair.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.preOrder(), onePair);
	}
	
	@Test
	public void preOrderLeftChildren() {
		specialCaseTree.add(8, "b1");
		onePair.add(new Pair<Integer, String>(16, "a1"));
		onePair.add(new Pair<Integer, String>(8, "b1"));
		
		assertEquals(specialCaseTree.preOrder(), onePair);
	}
	
	@Test
	public void preOrderRightChildren() {
		specialCaseTree.add(24, "b2");
		onePair.add(new Pair<Integer, String>(16, "a1"));
		onePair.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.preOrder(), onePair);
	}
	
	@Test
	public void preOrderBothChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseTree.add(24, "b2");
		onePair.add(new Pair<Integer, String>(16, "a1"));
		onePair.add(new Pair<Integer, String>(8, "b1"));
		onePair.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.preOrder(), onePair);
	}
	
	@Test
	public void preOrderOnFilledTree() {
		assertEquals(specialCaseTree.preOrder(), preOrderResults);
	}
	
	/*
	 * 	*** TESTING POST_ORDER *** 
	 */
	
	@Test
	public void postOrderEmpty() {
		assertEquals(specialCaseTree.postOrder(), empty);
	}
	
	@Test
	public void postOrderOneNode() {
		onePair.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.postOrder(), onePair);
	}
	
	@Test
	public void postOrderLeftChildren() {
		specialCaseTree.add(8, "b1");
		onePair.add(new Pair<Integer, String>(8, "b1"));
		onePair.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.postOrder(), onePair);
	}
	
	@Test
	public void postOrderRightChildren() {
		specialCaseTree.add(24, "b2");
		onePair.add(new Pair<Integer, String>(24, "b2"));
		onePair.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.postOrder(), onePair);
	}
	
	@Test
	public void postOrderBothChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseTree.add(24, "b2");
		onePair.add(new Pair<Integer, String>(8, "b1"));
		onePair.add(new Pair<Integer, String>(24, "b2"));
		onePair.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.postOrder(), onePair);
	}
	
	@Test
	public void postOrderOnFilledTree() {
		assertEquals(filledTree.postOrder(), postOrderResults);
	}
	
	
	/*
	 * 	*** TESTING IN_ORDER ****
	 */
	
	@Test
	public void inOrderEmpty() {
		assertEquals(specialCaseTree.inOrder(), empty);
	}
	
	@Test
	public void inOrderOneNode() {
		onePair.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.inOrder(), onePair);
	}
	
	@Test
	public void inOrderLeftChildren() {
		specialCaseTree.add(8, "b1");
		onePair.add(new Pair<Integer, String>(8, "b1"));
		onePair.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.inOrder(), onePair);
	}
	
	@Test
	public void inOrderRightChildren() {
		specialCaseTree.add(24, "b2");
		onePair.add(new Pair<Integer, String>(16, "a1"));
		onePair.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.inOrder(), onePair);
	}
	
	@Test
	public void inOrderBothChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseTree.add(24, "b2");
		onePair.add(new Pair<Integer, String>(8, "b1"));
		onePair.add(new Pair<Integer, String>(16, "a1"));
		onePair.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.inOrder(), onePair);
	}
	
	@Test
	public void inOrderOnFilledTree() {
		assertEquals(filledTree.inOrder(), inOrderResults);
	}
	
}
