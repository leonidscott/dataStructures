import java.util.Iterator;

public class OurLinkedList<E> implements OurList<E>, Iterable<E> {
	Node head = null;
	int count = 0;
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void add(int index, E item) throws ListIndexOutOfBoundsException {
		checkIndex(index, true);
		count++;
		
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		head = null;
		count = 0;
	}
	
	private void checkIndex(int index, boolean adding) throws ListIndexOutOfBoundsException {
		if(index >= count && !adding) {
			throw new ListIndexOutOfBoundsException("The index: " + index + ", is outside the dimensions of the list");
		}
		else if (index > count && adding) {
			throw new ListIndexOutOfBoundsException("The index: " + index + ", is outside the dimensions of the list");
		}
	}
	
	private Node findNode(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	private class Node {
		Node next;
		E value;
		
		public Node(Node next, E value) {
			this.next = next;
			this.value = value;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
