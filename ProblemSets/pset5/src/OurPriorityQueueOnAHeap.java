// Lenny Scott, pset 5

/*
 * This is a min-priority queue, meaning that smaller numbers 
 * have higher priority. For instance, if the queue contains 
 * 2, 4, 1, then 1 is returned first, then 2, then 4. 
 * 
 * The smallest element in the queue is called the head of the queue. 
 * If the queue contains several elements with the same minimal value,
 * any one of them may play the role of the head. 
 *  
 * Elements inserted in the the queue must implement the Comparable 
 * interface. (They are ordered based on the ordering determined by their 
 * compareTo method.)
 *  
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OurPriorityQueueOnAHeap<E extends Comparable<E>> implements OurQueue<E> {

	private ArrayList<E> dataTree = new ArrayList<E>();
	
	public OurPriorityQueueOnAHeap() {
		//adding constructor fixed issues with generics 
	}
	
	@Override
	public int size() {
		return dataTree.size();
	}

	@Override
	public boolean isEmpty() {
		return dataTree.size() == 0;
	}

	@Override
	public E head(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return dataTree.get(0);		
	}

	@Override
	public void enqueue(E element) {
		dataTree.add(element);
		if (dataTree.size() > 1) {
			enqueueRebalance(dataTree.size() - 1);
		}
	}

	@Override
	public E dequeue() {
		
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		E toReturn = dataTree.get(0);
		swap(dataTree.size() -1, 0);
		dataTree.remove(dataTree.size() - 1);
		dequeueRebalance(0);
		return toReturn;
	}

	@Override
	public void clear() {
		dataTree.clear();
	}
	
	/* Helper methods that will make the public methods MUCH easier to write 
	 * These are not required, but it is highly recommended that you figure them
	 * out and use them. */

	// swaps the values in two nodes of the heap, given their indices in the ArrayList
	private void swap(int index1, int index2) {
		E temp = dataTree.get(index1);
		dataTree.set(index1, dataTree.get(index2));
		dataTree.set(index2, temp);
	}

	// determines the index of a node's parent from the child node's index
	private int findParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	// determines the index of a node's left child from the parent node's index
	private int findLeftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}

	// determines the index of a node's right child from the parent node's index
	private int findRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}
	
	private boolean leftChildExists(int parentIndex) {
		return findLeftChildIndex(parentIndex) < dataTree.size();
	}
	
	private boolean rightChildExists(int parentIndex) {
		return findRightChildIndex(parentIndex) < dataTree.size();
	}
	
	private int findFittestChild(int parentIndex) {
		if (!leftChildExists(parentIndex)) {
			return findRightChildIndex(parentIndex);
		}
		
		if (!rightChildExists(parentIndex)) {
			return findLeftChildIndex(parentIndex);
		}
		
		if (dataTree.get(findLeftChildIndex(parentIndex)).compareTo(dataTree.get(findRightChildIndex(parentIndex))) > 0) {
			return findRightChildIndex(parentIndex);
		}
		
		return findLeftChildIndex(parentIndex);
	}

	private void dequeueRebalance(int localRootIndex) {
		if (!leftChildExists(localRootIndex) && !rightChildExists(localRootIndex)) {
			return;
		}
		
		int fittestChildIndex = findFittestChild(localRootIndex);
		
		if (dataTree.get(localRootIndex).compareTo(dataTree.get(fittestChildIndex)) > 0) {
			swap(localRootIndex, fittestChildIndex);
			dequeueRebalance(fittestChildIndex);
		}
	}

	private void enqueueRebalance(int range) {
		E element = dataTree.get(range);
		E parent = dataTree.get(findParentIndex(range));
		
		if (element.compareTo(parent) < 0) {
			swap(range, findParentIndex(range));
			enqueueRebalance(findParentIndex(range));
		}
	}
}