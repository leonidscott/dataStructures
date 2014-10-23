package pset4;

public class TestLinkedListObject {

	public static void main(String[] args) throws ListIndexOutOfBoundsException {
		testOurLikedListToString();
	}
	
	private static void testOurLikedListToString() throws ListIndexOutOfBoundsException {
		System.out.println("*** Testing OurLinkedList.toString()");
		OurLinkedList<Integer> test = new OurLinkedList<>();
		
		// testing empty linked list prints to []
		System.out.print("Test 1: ");
		System.out.println("[]".equals(test.toString()));
		
		// testing with one integer prints to []
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
	}

}
