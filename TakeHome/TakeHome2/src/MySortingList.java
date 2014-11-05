// Lenny Scott, Take Home 2: Object

import java.util.Iterator;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MySortingList<E extends Comparable<E>> implements SortingList<E> {
	// fields
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
		
		// If the linked List is empty, the node we add becomes the head
		if(isEmpty()) {
			head = new Node(null, null, item, true);
			compositeCount++;
			System.out.println("head is null: composite = " + compositeCount + " item = " + item);
			return;
		}
		
		/* SUBSEQUENT IF COPIED FROM INSIDE WHILE LOOP IN ORDER TO ISOLATE IT FROM CURRENT */
		// if item is less than head.val make item the head that points to old head
		if (head.value.compareTo(item) > 0) {
			head = new Node(head, null, item, true);
			
			compositeCount++;
			System.out.println("head.val " + head.value);
			System.out.println(item + " is replacing head: composite count = " + compositeCount);
			System.out.println(item + " points to = " + head.nextKeyNode);
			return;
		}
		
		//Node current = head; if it is not empty, then head already points to something
		int currentCount = 0; //the current index we are at
		int totalJump = 0; //since we don't look into sub trees if we don't have so we add number of elements in a subTree 
		Node current = head;

		while (currentCount < compositeCount) {
			// indicates how many spaces will be jumped
			totalJump = current.subCount;

			// ==== DEALS WITH KEY NODES ====

			// if item is less than head.val make item the head that points to old head
			if (head.value.compareTo(item) > 0) {
				head = new Node(head, null, item, true);
				//current = head;

				System.out.println("head.val " + head.value);
				System.out.println("head.next.val " + head.nextKeyNode);
				System.out.println(item + " is replacing head: composite count = " + compositeCount);
				System.out.println(item + " points to = " + head.nextKeyNode);
				compositeCount++;
				return;
				
			}
			// if item is greater than current but less than current.next, stick item in between
			if (current.nextKeyNode != null && current.nextKeyNode.value.compareTo(item) > 0) {
				Node toAdd = new Node(current.nextKeyNode, null, item, true);
				current.nextKeyNode = toAdd;
				compositeCount++;
				System.out.println(item + " is squeezing between two pre-existing nodes: composit count = " + compositeCount);
				return;
			}
			// if item is greater than the last thing in the list than stick it at the end
			if (current.value.compareTo(item) < 0 && current.nextKeyNode == null) {
				Node toAdd = new Node(null, null, item, true);
				current.nextKeyNode = toAdd;
				compositeCount++;
				System.out.println(item + " is bigger than anything else in the linked List: composit count = " + compositeCount);
				return;
			}

			// === DEALS WITH SUB NODES ===

			// if item is the same as current, iterate through all current's
			// subNodes, once at the end, add item
			if (current.value.compareTo(item) == 0) {
				for (int i = current.subCount; i > 1; i--) {
					current = current.nextSubNode;
					current.subCount++;
				}
				Node toAdd = new Node(null, null, item, false);
				current.nextSubNode = toAdd;
				compositeCount++;
				System.out.println("composite count " + compositeCount
						+ "Item = " + item);
				return;
			}

			// move to the next key node
			current = current.nextKeyNode;
			currentCount += totalJump;
			System.out.println("moving to next key Node");

		}
	}

	@Override
	public int frequencyOf(E item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		int currentIndex = 0;
		Node currentNode = head;
		//System.out.println("head points to " + currentNode.value);
		//System.out.println("head.next points to " + currentNode.nextKeyNode);
		
		if (index < 0) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is less than zero");
		}
		if (index > compositeCount) {
			System.out.println("composite count " + compositeCount);
			throw new ListIndexOutOfBoundsException("the index " + index + "is greater than the size of the linked list");
		}
		if (isEmpty()) {
			throw new ListIndexOutOfBoundsException("the linked list is empty");
		}
		
		return findNode(index, currentIndex, currentNode);
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
	
	private E findNode(int targetIndex, int currentIndex, Node currentNode) throws ListIndexOutOfBoundsException {
		if ((currentIndex + currentNode.subCount - 1) >= targetIndex) {
			for (int i = 0; i < currentNode.subCount; i++) {
				System.out.println("gets past for loop");
				if (currentIndex == targetIndex) {
					return currentNode.value;
				}
				currentIndex++;
				currentNode = currentNode.nextSubNode;
			}
		}
		
		if (currentIndex >= compositeCount -1) {
			throw new ListIndexOutOfBoundsException("the index " + targetIndex + " is outside the range of the list");
		}

		currentIndex += currentNode.subCount;
		currentNode = currentNode.nextKeyNode;
		
		return findNode(targetIndex, currentIndex, currentNode);
	}

	private class Node {
		Node nextKeyNode;
		Node nextSubNode;
		E value;
		boolean isKeyNode;
		int subCount = 1;
		
		public Node(Node nextKeyNode, Node nextSuNode, E value, boolean isKeyNode) {
			this.nextKeyNode = nextKeyNode;
			this.nextKeyNode = nextSuNode;
			this.value = value;
			this.isKeyNode = isKeyNode;
		}
	}

}