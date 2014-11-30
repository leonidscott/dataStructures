import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestOrders {
	private BinarySearchTree<Integer, String> emptyTree = new BinarySearchTree<>();
	private BinarySearchTree<Integer, String> specialCaseTree = new BinarySearchTree<Integer, String>();
	private BinarySearchTree<Integer, String> filledTree = new BinarySearchTree<Integer, String>();
	
	private ArrayList<Pair<Integer, String>> empty = new ArrayList<Pair<Integer, String>>();
	private ArrayList<Pair<Integer, String>> specialCaseResults = new ArrayList<Pair<Integer, String>>();
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
		inOrderResults.add(new Pair<Integer, String>(12, "c2"));
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
		assertEquals(emptyTree.preOrder(), empty);
	}
	
	@Test
	public void preOrderOneNode() {
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.preOrder(), specialCaseResults);
	}
	
	@Test
	public void preOrderLeftChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		specialCaseResults.add(new Pair<Integer, String>(8, "b1"));
		
		assertEquals(specialCaseTree.preOrder(), specialCaseResults);
	}
	
	@Test
	public void preOrderRightChildren() {
		specialCaseTree.add(24, "b2");
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		specialCaseResults.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.preOrder(), specialCaseResults);
	}
	
	@Test
	public void preOrderBothChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseTree.add(24, "b2");
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		specialCaseResults.add(new Pair<Integer, String>(8, "b1"));
		specialCaseResults.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.preOrder(), specialCaseResults);
	}
	
	@Test
	public void preOrderOnFilledTree() {
		assertEquals(filledTree.preOrder(), preOrderResults);
	}
	
	/*
	 * 	*** TESTING POST_ORDER *** 
	 */
	
	@Test
	public void postOrderEmpty() {
		assertEquals(emptyTree.postOrder(), empty);
	}
	
	@Test
	public void postOrderOneNode() {
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.postOrder(), specialCaseResults);
	}
	
	@Test
	public void postOrderLeftChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseResults.add(new Pair<Integer, String>(8, "b1"));
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.postOrder(), specialCaseResults);
	}
	
	@Test
	public void postOrderRightChildren() {
		specialCaseTree.add(24, "b2");
		specialCaseResults.add(new Pair<Integer, String>(24, "b2"));
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.postOrder(), specialCaseResults);
	}
	
	@Test
	public void postOrderBothChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseTree.add(24, "b2");
		specialCaseResults.add(new Pair<Integer, String>(8, "b1"));
		specialCaseResults.add(new Pair<Integer, String>(24, "b2"));
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		
		assertEquals(specialCaseTree.postOrder(), specialCaseResults);
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
		assertEquals(emptyTree.inOrder(), empty);
	}
	
	@Test
	public void inOrderOneNode() {
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.inOrder(), specialCaseResults);
	}
	
	@Test
	public void inOrderLeftChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseResults.add(new Pair<Integer, String>(8, "b1"));
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		assertEquals(specialCaseTree.inOrder(), specialCaseResults);
	}
	
	@Test
	public void inOrderRightChildren() {
		specialCaseTree.add(24, "b2");
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		specialCaseResults.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.inOrder(), specialCaseResults);
	}
	
	@Test
	public void inOrderBothChildren() {
		specialCaseTree.add(8, "b1");
		specialCaseTree.add(24, "b2");
		specialCaseResults.add(new Pair<Integer, String>(8, "b1"));
		specialCaseResults.add(new Pair<Integer, String>(16, "a1"));
		specialCaseResults.add(new Pair<Integer, String>(24, "b2"));
		
		assertEquals(specialCaseTree.inOrder(), specialCaseResults);
	}
	
	@Test
	public void inOrderOnFilledTree() {
		System.out.println("Expected Data " + inOrderResults.toString());
		System.out.println("Actual Data " + filledTree.inOrder().toString());
		assertEquals(filledTree.inOrder(), inOrderResults);
	}
	
}
