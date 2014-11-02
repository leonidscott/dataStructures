// Lenny Scott, Take Home 2: Object
import java.util.Iterator;

import javax.xml.soap.Node;


public class MySortingList<E extends Comparable<E>> implements SortingList<E> {
	// fields
	private boolean isKeyNode = false; //key nodes make up the horizontal branch of the structure
	private int subCount = 0; //subCount indicates how many subNodes belong to any particular node (subCount applies to both key and sub nodes)
	private int compositeCount = 0;
	Node head = null;
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return compositeCount;
	}

	@Override
	public int uniqueValueCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(E item) {
		compositeCount++;
		
		// Sorting through keyNodes
		
	}

	@Override
	public int frequencyOf(E item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		head = null;
		compositeCount = 0;
	}
	
	private Node findNode(int count) {
		Node current = head;
		return null;
	}

	private class Node {
		Node nextKeyNode;
		Node nextSubNode;
		E value;
		boolean isKeyNode;
		
		public Node(Node nextKeyNode, Node nextSuNode, E value, boolean isKeyNode) {
			this.nextKeyNode = nextKeyNode;
			this.nextKeyNode = nextSuNode;
			this.value = value;
			this.isKeyNode = isKeyNode;
		}
	}

}