package exam2Study;

import java.util.ArrayList;

public class TypecastingRedux {

	public static void main(String[] args) {
	
		ArrayList<String> stringList = new ArrayList<String>();
		
		// This does not compile because the compiler knows that
		// the variable being cast cannot be cast to the type shown
		/*
		ArrayList<Integer> intList = (ArrayList<Integer>)stringList;
		*/
		
		// This compiles because ArrayList<String> to Object is an upcast
		// and the compiler doesn't know that obj isn't an ArrayList<Integer>
		// It runs because of type erasure: At runtime, both the stringList
		// and intList variables are simply ArrayList instances (containing 
		// Objects) 
		Object obj = stringList;
		ArrayList<Integer> intList = (ArrayList<Integer>)obj;
		
		// Nothing unusual here
		stringList.add("hello");
		stringList.add("world");
		System.out.println("stringList size: " + stringList.size());
		
		// The size() method works, even when called on the intList
		// variable, because size() doesn't do anything with the type
		// of the objects in the list
		System.out.println("intList size: " + intList.size());
		
		// Java nicely boxes the 5 to an Integer for us, and type erasure
		// allows this to work, since at runtime we are simply adding an
		// Integer to an array (internally) of Objects, so it's a simple
		// upcast -- size() continues to work for the reasons above
		intList.add(5);
		System.out.println("stringList size: " + stringList.size());
		
		// We can print the list (and get [hello, world, 5]), because type
		// erasure means that ArrayList's toString method simply calls 
		// toString on each object as an Object
		System.out.println(stringList);
		
		// If we try to print the values individually ourselves, however,
		// we have to use the get method (or a for-each loop)
		
		// These work, becuase the implicit cast to String that the 
		// compile has added (so that the Object being returned by 
		// ArrayList's get() method is being used on objects that actually
		// are strings
		System.out.println(stringList.get(0));
		System.out.println(stringList.get(1));
		
		// This compiles, because get is just returning an object, and 
		// for all the compiler knows that object can be cast to a String.
		// It breaks at run-time, however, because the object that get()
		// returns is in fact an Integer, which cannot be cast to String.
		try {
			System.out.println(stringList.get(2));
		} catch (Exception e) {
			System.out.println(e);	
		}
		
		
		// This compiles for the same reasons as the first working example 
		// at the top of this method.  It fails at runtime, however, 
		// because the run-time types differ (Integer and ArrayList)
		try {
			Integer integer = new Integer(42);
			Object anObject = integer;
			ArrayList<Integer> integerList = (ArrayList<Integer>)anObject;
		} catch (Exception e) {
			System.out.println(e);	
		}
	}
}