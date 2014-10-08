//Lenny Scott, take home exam one

import java.util.ArrayList;
import java.util.Stack;

public class TakeHomeOne {
	public static void main(String[] args) {
		testListedIntersection();
		testStackToArray();
		testRemoveAlphebeticallyLast();
	}
	
	public static void testListedIntersection() {
		/*Tests:	arrayListOne	arrayListTwo	Result
			1.	[]		[]		[]
			2.	[]		[1]		[]
			3.	[1]		[1]		[1]
			4.	[1]		[1,1]		[1]
			5.	[1,1]		[1,1]		[1,1]
			6.	[1,2]		[2,2]		[2]
			7.	[1,2,3,4]	[2,3,5]		[2,3]
			8.	[2,3,5]		[1,2,3,4]	[2,3]
		*/
		System.out.println("Listed Intersection");
		//problem 1
		ArrayList<Integer> arrayListOne = new ArrayList<Integer>();
		ArrayList<Integer> arrayListTwo = new ArrayList<Integer>();
		System.out.println("Case 1 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return []
		//problem 2 
		arrayListTwo.add(1);
		System.out.println("Case 2 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [1]
		//problem 3
		arrayListOne.add(1);
		System.out.println("Case 3 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [1]
		//problem 4
		arrayListOne.add(1);
		arrayListTwo.add(1);
		System.out.println("Case 4 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [1]
		//problem 5
		arrayListOne.add(1);
		arrayListOne.add(1);
		System.out.println("Case 5 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [1]
		//problem 6
		arrayListOne.clear();
		arrayListOne.add(1);
		arrayListOne.add(2);
		arrayListTwo.clear();
		arrayListTwo.add(2);
		arrayListTwo.add(2);
		System.out.println("Case 6 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [2]
		//problem 7
		arrayListOne.clear();
		arrayListOne.add(1);
		arrayListOne.add(2);
		arrayListOne.add(3);
		arrayListOne.add(4);
		arrayListTwo.clear();
		arrayListTwo.add(2);
		arrayListTwo.add(3);
		arrayListTwo.add(5);
		System.out.println("Case 7 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [2,3]
		//problem 8 
		arrayListOne.clear();
		arrayListOne.add(2);
		arrayListOne.add(3);
		arrayListOne.add(5);
		arrayListTwo.clear();
		arrayListTwo.add(1);
		arrayListTwo.add(2);
		arrayListTwo.add(3);
		arrayListTwo.add(4);
		System.out.println("Case 8 = " + arrayListOne + ", " + arrayListTwo + ": " + listedIntersection(arrayListOne, arrayListTwo)); //should return [2,3]
		/* 
		All test cases passed
		*/
	}
	
	public static ArrayList<Integer> listedIntersection(ArrayList<Integer> arrayListOne, ArrayList<Integer> arrayListTwo){
		ArrayList<Integer> arrayListResult = new ArrayList<Integer>();
		
		if(arrayListOne.isEmpty() || arrayListTwo.isEmpty()){
			return arrayListResult;
		}
		
		for(int i = 0; i < arrayListTwo.size(); i++) {
			if(arrayListOne.indexOf(arrayListTwo.get(i)) != -1) {
				arrayListResult.add(arrayListTwo.get(i));
				arrayListOne.remove(arrayListOne.indexOf(arrayListTwo.get(i)));
			}
		}
		
		return arrayListResult;
	}
	
	public static void testStackToArray() {
		/*Tests:	Stack	Result
			1.	[]	[]
			2.	[1]	[1]
			3.	[1,2]	[1,2]
			4.	[1,2,3]	[1,2,3]
		*/
		System.out.println("Stack to Array");
		//test 1
		Stack<Integer> testStack = new Stack<Integer>();
		System.out.print("Case 1 = []: ");
		printIntArray(stackToArray(testStack));
		//test 2
		testStack.add(1);
		System.out.print("Case 2 = [1]: ");
		printIntArray(stackToArray(testStack));
		//test 3
		System.out.print("Case 3 = [1,2]: ");
		testStack.add(2);
		printIntArray(stackToArray(testStack));
		//test 4
		System.out.print("Case 4 = [1,2,3]: ");
		testStack.add(3);
		printIntArray(stackToArray(testStack));
		/*
		all tests pass
		*/
	}
	
	public static void printIntArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i]);
			if (i != arr.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

		
	public static int[] stackToArray(Stack<Integer> stack) {
		Stack<Integer> reverseStack = new Stack<Integer>();
		int stackSize = 0;
		int[] baseCase = new int[0];
		
		while(!stack.empty()) {
			reverseStack.push(stack.pop());
			stackSize += 1;
		}
		
		if(!reverseStack.empty()) {
			int[] integerArray = new int[stackSize];
			int reverseStackValue = 0;
			
			for(int i = 0; i < stackSize; i++){	
				reverseStackValue = reverseStack.pop();
				integerArray[i] = reverseStackValue;
				stack.push(reverseStackValue);
			}
			
			return integerArray;
		}
		return baseCase;
	}
	
	public static void testRemoveAlphebeticallyLast() {
		/*Tests:				Result:
			1. {}				{}
			2. {""}				{}
			3. {"", ""}			{}
			4. {"a", "a"}			{}
			5. {"a", "b"}			{"a"}
			6. {"a", "b", "c"}		{"a", "b"}
			7. {"a", "a", "c"}		{"a", "a"}
			8. {"a", "b", "c", "c"}		{"a", "b"}
		*/
		System.out.println("Remove Alphebetically Last ");
		//Test 1
		Stack<String> testSizeOne = new Stack<String>();
		System.out.print("Case 1 = " + testSizeOne + ": ");
		removeAlphebeticallyLast(testSizeOne);
		System.out.println(testSizeOne);
		//Test 2
		testSizeOne.push("");
		System.out.print("Case 2 = " + testSizeOne + ": ");
		removeAlphebeticallyLast(testSizeOne);
		System.out.println(testSizeOne);
		//Test 3
		Stack<String> testSizeTwo = new Stack<String>(); //making more than one stack so any testStack issues are more contained
		testSizeTwo.push("");
		testSizeTwo.push("");
		System.out.print("Case 3 = " + testSizeTwo + ": ");
		removeAlphebeticallyLast(testSizeTwo);
		System.out.println(testSizeTwo);
		//Test 4
		testSizeTwo.push("a");
		testSizeTwo.push("a");
		System.out.print("Case 4 = " + testSizeTwo + ": ");
		removeAlphebeticallyLast(testSizeTwo);
		System.out.println(testSizeTwo);
		//Test 5
		testSizeTwo.push("a");
		testSizeTwo.push("b");
		System.out.print("Case 5 = " + testSizeTwo + ": ");
		removeAlphebeticallyLast(testSizeTwo);
		System.out.println(testSizeTwo);
		//Test 6
		Stack<String> testSizeThree = new Stack<String>();
		testSizeThree.push("a");
		testSizeThree.push("b");
		testSizeThree.push("c");
		System.out.print("Case 6 = " + testSizeThree + ": ");
		removeAlphebeticallyLast(testSizeThree);
		System.out.println(testSizeThree);
		//Test 7
		testSizeThree.pop();
		testSizeThree.push("a");
		testSizeThree.push("c");
		System.out.print("Case 7 = " + testSizeThree + ": ");
		removeAlphebeticallyLast(testSizeThree);
		System.out.println(testSizeThree);
		//Test 8
		testSizeThree.pop();
		testSizeThree.push("b");
		testSizeThree.push("c");
		testSizeThree.push("c");
		System.out.print("Case 8 = " + testSizeThree + ": ");
		removeAlphebeticallyLast(testSizeThree);
		System.out.println(testSizeThree);
		/*
		All tests pass with flying colours!
		*/
	}
	
	public static void removeAlphebeticallyLast(Stack<String> original) {
		Stack<String> reverseStack = new Stack<String>();
		String lastAlph = "";
		
		while(!original.empty()){
			String currentE = original.pop();
			if(currentE.compareTo(lastAlph) > 0){
				lastAlph = currentE;
			}
			reverseStack.push(currentE);
		}
		
		while(!reverseStack.empty()){
			String currentE = reverseStack.pop();
			if(!currentE.equals(lastAlph)){
				original.push(currentE);
			}
		}
	}
}
