package pset4Git;

public class TestLinkedListObjectMethods {

	public static void main(String[] args) throws ListIndexOutOfBoundsException {
		testOurLinkedListToString();
		testOurLinkedListEquals();
	}

	private static void testOurLinkedListToString() throws ListIndexOutOfBoundsException {
		System.out.println("*** Testing OurLinkedList.toString()");
		OurLinkedList<Integer> test = new OurLinkedList<>();
		OurLinkedList<String> testWithString = new OurLinkedList<>();
		
		// testing empty linked list prints to []
		System.out.print("Test 1: ");
		System.out.println("[]".equals(test.toString()));
		
		// testing with one integer prints to [integer]
		System.out.print("Test 2: " );
		test.add(0, 1);
		System.out.println("[1]".equals(test.toString()));
		
		// testing that multiple integers will be printed in sequential order with proper formatting
		System.out.print("Test 3: ");
		test = new OurLinkedList<>();
		test.add(0, 5);
		test.add(1, 0);
		test.add(2, 25);
		System.out.println("[5, 0, 25]".equals(test.toString()));
		
		// testing that linkedLists of different types work properly
		System.out.print("Test 4: ");
		testWithString.add(0, "Hello Joe");
		testWithString.add(1, "it works!");
		System.out.println("[Hello Joe, it works!]".equals(testWithString.toString()));
		
	}
	
	private static void testOurLinkedListEquals() throws ListIndexOutOfBoundsException{
		System.out.println("*** Testing OurLinkedList.equal() ***");
		OurLinkedList<Integer> compareOne = new OurLinkedList<>();
		OurLinkedList<Integer> compareTwo = new OurLinkedList<>();
		
		/*
		 * ALL SUBSEQUENT TESTS HAVE THE SAME TYPE AND NO NULLS
		 */
		
		// testing that [] [] = true (testing that to empty linked lists are equal)
		System.out.print("Test 1: ");
		System.out.println(compareOne.equals(compareTwo));
		
		// testing that [1] [] = false (testing that a linked list with something in it, is not equal an empty linked list)
		System.out.print("Test 2: ");
		compareOne.add(0, 1);
		System.out.println(!compareOne.equals(compareTwo));
		
		// testing that [] [1] = false (testing that the order in which you use .equals() doesn't matter)
		System.out.print("Test 3: ");
		System.out.println(!compareTwo.equals(compareOne));
		
		// testing that [1] [1] = true (testing that two linked lists with equal values are equal, more basic than next test)
		System.out.print("Test 4: ");
		compareTwo.add(0, 1);
		System.out.println(compareOne.equals(compareTwo));
		
		// testing that [10, 11, 13, 15] [10, 11, 13, 15] = true (testing that two linked lists with equal values are equal)
		System.out.print("Test 5: ");
		compareOne.clear();
		compareTwo.clear();
		compareOne.add(0, 10);
		compareTwo.add(0, 10);
		compareOne.add(1, 11);
		compareTwo.add(1, 11);
		compareOne.add(2, 13);
		compareTwo.add(2, 13);
		compareOne.add(3, 15);
		compareTwo.add(3, 15);
		System.out.println(compareOne.equals(compareTwo));
		
		// testing that [16, 14, 12] [16, 12, 14] = false (testing that two linked lists with the same values in different order is not equal)
		System.out.print("Test 6: ");
		compareOne.clear();
		compareTwo.clear();
		compareOne.add(0, 16);
		compareOne.add(1, 14);
		compareOne.add(2, 12);
		compareTwo.add(0, 16);
		compareTwo.add(1, 12);
		compareTwo.add(2, 14);
		System.out.println(!compareOne.equals(compareTwo));
		
		// post submitting
		System.out.print("Test 6.5 *POST SUBMIT*: ");
		compareOne.clear();
		compareTwo.clear();
		compareOne.add(0, 16);
		compareTwo.add(0, 16);
		compareOne.add(1, 14);
		compareTwo.add(1, 14);
		compareOne.add(2, 12);
		compareTwo.add(2, 22);
		System.out.println(!compareOne.equals(compareOne));
		
		/*
		 * ALL SUBSEQUENT TESTS HAVE NULLS
		 */
		
		// testing [null] [null] = true (testing that null does not do anything weird)
		System.out.print("Test 7: ");
		compareOne.clear();
		compareTwo.clear();
		compareOne.add(0, null);
		compareTwo.add(0, null);
		System.out.println(compareOne.equals(compareTwo));
		
		// testing [10, null] [10, null] = true (testing that linked lists with null values in addition to regular Integers can be equal)
		System.out.print("Test 8: ");
		compareOne.clear();
		compareTwo.clear();
		compareOne.add(0, 10);
		compareTwo.add(0, 10);
		compareOne.add(1, null);
		compareTwo.add(1, null);
		System.out.println(compareOne.equals(compareTwo));
		
		// testing [15, null] = [null, 15] = false (testing that linked lists with null values and regular Integers can also be not equal)
		System.out.print("Test 9: ");
		compareOne.clear();
		compareTwo.clear();
		compareOne.add(0, 15);
		compareOne.add(1, null);
		compareTwo.add(0, null);
		compareTwo.add(1, 15);
		System.out.println(!compareOne.equals(compareTwo));
		
		/*
		 * ALL SUBSEQUENT TESTS HAVE DIFFERENT TYPES
		 */
		
		OurLinkedList<String> compareString = new OurLinkedList<>();
		
		// testing [1, 2, 3]<Integer> [a, b, c]<String> = false (testing that linked lists of different types are not equal)
		System.out.print("Test 10: ");
		compareOne.clear();
		compareOne.add(0, 1);
		compareOne.add(1, 2);
		compareOne.add(2, 3);
		compareString.add(0, "a");
		compareString.add(1, "b");
		compareString.add(2, "c");
		System.out.println(!compareOne.equals(compareString));
	}
}