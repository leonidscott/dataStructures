// Aaron Lemmon && Lenny Scott

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class IntStack implements IntStackInterface {

	private int[] intArray = new int[1];
	private int nextIndex = 0;
	
	@Override
	public boolean empty() {
		return (nextIndex == 0);
	}

	@Override
	public void push(int value) {
		ensureCapacity();
		intArray[nextIndex] = value;
		nextIndex++;
	}

	@Override
	public int peek() throws EmptyStackException {
		if(nextIndex <= 0){
			throw new EmptyStackException();
		}
		return intArray[nextIndex - 1];
	}

	@Override
	public int pop() throws EmptyStackException {
		nextIndex--;
		if (nextIndex < 0) {
			throw new EmptyStackException();
		}
		int popElement = intArray[nextIndex];
		return popElement;
	}

	@Override
	public void clear() {
		nextIndex = 0;
	}

	@Override
	public int size() {
		return nextIndex;
	}

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

	@Override
	public ArrayList<Integer> convertToArrayList() {
		ArrayList<Integer> newArrayList = new ArrayList<Integer>();
		for(int i = 0; i < nextIndex; i++) {
			newArrayList.add(intArray[i]);
		}
		return newArrayList;
	}

	@Override
	public IntStackInterface copy() {
		IntStack copy = new IntStack();
		copy.nextIndex = this.nextIndex;
		copy.intArray = this.intArray.clone();
		return copy;
	}
	
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
