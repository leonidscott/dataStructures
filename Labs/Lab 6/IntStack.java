// Aaron Lemmon && Lenny Scott

import java.util.ArrayList;
import java.util.EmptyStackException;

public class IntStack implements IntStackInterface {
	/* It was really nice how eclipse made method stubs for us as soon as we implemented IntStackInterface.
	 * This was very convenient.
	 */

	private int[] intArray = new int[1];
	private int nextIndex = 0;
	
	
	/**
	 * Returns true if and only if the stack is empty.
	 */
	@Override
	public boolean empty() {
		return (nextIndex == 0);
		/* we referenced nextIndex before it was declared and Eclipse offered to make it a field with ctrl+1 */
	}
	
	/**
	 * Adds the given value to the top of the stack.
	 */
	@Override
	public void push(int value) {
		ensureCapacity();
		intArray[nextIndex] = value;
		nextIndex++;
	}

	/**
	 * Returns the top value of the stack without removing it.
	 */
	@Override
	public int peek() throws EmptyStackException {
		if(nextIndex <= 0){
			throw new EmptyStackException();
		}
		return intArray[nextIndex - 1];
	}

	/**
	 * Returns AND removes the top element from the stack.
	 */
	@Override
	public int pop() throws EmptyStackException {
		nextIndex--;
		if (nextIndex < 0) {
			throw new EmptyStackException();
		}
		int popElement = intArray[nextIndex];
		return popElement;
	}

	/**
	 * Removes all elements from the stack.
	 */
	@Override
	public void clear() {
		nextIndex = 0;
	}

	/**
	 * Returns the number of elements in the stack.
	 */
	@Override
	public int size() {
		return nextIndex;
	}
	
	/**
	 * Returns a new IntStackInterface with the same values as "this" but in
	 * reverse order.
	 */
	@Override
	public IntStackInterface invert() {
		IntStack inverse = new IntStack();
		inverse.nextIndex = this.nextIndex;
		inverse.intArray = new int[intArray.length];
		for(int i = 0; i < nextIndex; i++) {
			inverse.intArray[i] = this.intArray[nextIndex - 1 - i];
		}
		return inverse;
	}

	/**
	 * Returns an arrayList with the same values as "this" in their same order.
	 */
	@Override
	public ArrayList<Integer> convertToArrayList() {
		ArrayList<Integer> newArrayList = new ArrayList<Integer>();
		for(int i = 0; i < nextIndex; i++) {
			newArrayList.add(intArray[i]);
		}
		return newArrayList;
	}

	/**
	 * Returns a new IntStackInterface with the same values as "this" in their
	 * same order.
	 */
	@Override
	public IntStackInterface copy() {
		IntStack copy = new IntStack();
		copy.nextIndex = this.nextIndex;
		copy.intArray = this.intArray.clone();
		return copy;
	}
	
	/**
	 * Returns a string representation of "this" IntStack.
	 */
	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < nextIndex; i++) {
			result += intArray[i];
			if (i < nextIndex - 1) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
	
	/**
	 * Internal method.
	 * Dynamically "increases" the size of the array as more space is needed.
	 */
	/* doubles length of the array on the fly as needed*/
	private void ensureCapacity() {
		if (nextIndex >= intArray.length) {
			int[] doubledArray = new int[intArray.length * 2];
			for (int i = 0; i < intArray.length; i++) {
				doubledArray[i] = intArray[i];
			}
			intArray = doubledArray;
		}
	}

/* We wrote this under the notion that it would use lower level operations and thus be 
 * lickity split but alas... @joeBeaverWeBrokeIt*/
//	
//	@Override
//	public boolean equals(Object obj) {
//		IntStack comparison = (IntStack) obj;
//		int[] relevantRangeCurrent = Arrays.copyOfRange(this.intArray, 0, this.nextIndex);
//		int[] relevantRangeComparison = Arrays.copyOfRange(comparison.intArray, 0, comparison.nextIndex);
//		return relevantRangeCurrent.equals(relevantRangeComparison) && super.equals(obj);
//	}
//	
}
