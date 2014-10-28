package exam2Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Typecasting {

	/**
	 * The program demonstrates instanceof and typecasting
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		Stack<Integer> list2 = new Stack<Integer>();
		
		someMethod(list1, list2);
	}

	private static void someMethod(List<Integer> list1, List<Integer> list2) {	
	
		
		if (list1 instanceof List) { //Note: list1 instanceof List<Integer>
						// doesn't compile: cannot use generics 
						// in instanceof
			System.out.println("list1 is an instance of List");
		} else {
			System.out.println("list1 is not an instance of List");
		}
		
		if (list2 instanceof List) {
			System.out.println("list2 is an instance of List");
		} else {
			System.out.println("list2 is not an instance of List");
		}
		
		if (list1 instanceof ArrayList) {
			System.out.println("list1 is an instance of ArrayList");
		} else {
			System.out.println("list1 is not an instance of ArrayList");
		}
		
		if (list2 instanceof ArrayList) {
			System.out.println("list2 is an instance of ArrayList");
		} else {
			System.out.println("list2 is not an instance of ArrayList");
		}
		
		// typecasting: 
		// list2.push(2); //doesn't compile since list2 is of type List and 
		// doesn't have push() method. Need to typecast in order to call push():
		
		Stack<Integer> theStack = (Stack<Integer>)list2;  
		// note that <Integer> in the cast
		// is required but the type doesn't actually get checked
		
		theStack.push(2);
		// or you can avoid using a variable:
		((Stack<Integer>) list2).push(5);
		
		// checking that the elements are actually in list2:
		System.out.println(list2);
		
		Stack<Integer> anotherStack; // declaring a stack outside of try/catch
				                     // to avoid variable scope issues 
		// if the object is of the wrong type, typecasting throws an exception:
		try {
			anotherStack = (Stack<Integer>)list1; 
		} catch (ClassCastException e) {
			System.out.println(e);
		}
		
		// if you are not sure whether a given object is of the right type,
		// use instanceof before typecasting:
		if (list1 instanceof Stack) {
			anotherStack = (Stack<Integer>)list1; 
		} else {
			System.out.println("Cannot cast list1 to Stack");
		}
	}
}
