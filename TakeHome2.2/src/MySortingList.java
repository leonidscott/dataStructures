// Lenny Scott, Take Home 2: Object

import java.util.Iterator;

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
		
		//Node current = head; if it is not empty, then head already points to something
		int currentCount = 0;
		int totalJump = 0;
		Node current = head;
		
		//System.out.println(current.value);
		//System.out.println(current.nextKeyNode);
		//System.out.println(head.value);

		while (currentCount < compositeCount) {
			// indicates how many spaces will be jumped
			totalJump = current.subCount;

			// ==== DEALS WITH KEY NODES ====

			// if item is less than head.val make item the head that points to old head
			if (current.value.compareTo(item) > 0) {
				//Node toAdd = new Node(head, null, item, true);
				//current = toAdd;
				head = new Node(head, null, item, true);
				
				//head = new Node(head, null, item, true);
				//current = toAdd;
				//Node toAdd = new Node(current, null, item, true);
				//head = toAdd;
				System.out.println("head.val " + current.value);
				System.out.println("head.next.val " + current.nextKeyNode);
				compositeCount++;
				System.out.println(item + " is replacing head: composite count = " + compositeCount);
				return;
				
			}
			// if item is greater than current but less than current.next, stick item in between
			if (current.nextKeyNode != null && current.nextKeyNode.value.compareTo(item) > 0) {
				Node toAdd = new Node(current.nextKeyNode, null, item, true);
				current.nextKeyNode = toAdd;
				compositeCount++;
				System.out.println(item + " is squeezing between to pre-existing nodes: composit count = " + compositeCount);
				return;
			}
			// if item is greater than the last thing in the list than stick it
			// at the end
			if (current.value.compareTo(item) < 0
					&& current.nextKeyNode == null) {
				Node toAdd = new Node(null, null, item, true);
				current.nextKeyNode = toAdd;
				compositeCount++;
				System.out
						.println(item
								+ " is bigger than anything else in the linked List: composit count = "
								+ compositeCount);
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
		int startingIndex = 0;
		Node startingNode = head;
		
		System.out.println("breaking in get");
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
		
		return findNode(index, startingIndex, startingNode);
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
	
	private E findNode(int index, int currentIndex, Node currentNode) throws ListIndexOutOfBoundsException {
		System.out.println("current's value " + currentNode.value);
		System.out.println("current's subCount " + currentNode.subCount);
		System.out.println("current.nextKeyNode " + currentNode.nextKeyNode);
		if (index < currentNode.subCount + currentIndex) {
			for (int i = currentNode.subCount; i > 0; i--) {
				System.out.println("made it past if");
				if (currentIndex == index) {
					return currentNode.value;
				}
				currentIndex++;
				currentNode = currentNode.nextSubNode;
			}
		}
		
		if (currentIndex >= compositeCount -1) {
			throw new ListIndexOutOfBoundsException("the index " + index + " is outside the range of the list");
		}
		System.out.println("next iteration of findNode()");

		currentIndex += currentNode.subCount;
		currentNode = currentNode.nextKeyNode;
		
		return findNode(index, currentIndex, currentNode);
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