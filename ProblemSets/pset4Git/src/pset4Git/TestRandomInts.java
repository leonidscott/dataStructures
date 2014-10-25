package pset4Git;

import java.util.ArrayList;

public class TestRandomInts {

	public static void main(String[] args) {
		testRandomInts();
	}

	private static void testRandomInts() {
		System.out.println("*** Tesing RandomInts() ***");
		RandomInts test;
		ArrayList<Integer> compareOne = new ArrayList<>();
		ArrayList<Integer> compareTwo = new ArrayList<>();


		// testing when max is less than min
		System.out.print("Test 1: ");
		try {
			test = new RandomInts(0, -1, 10, 1);
			System.out.println(false);
		} catch (Exception e) {
			System.out.println(true);
		}
		
		// testing when n is less than zero
		System.out.print("Test 2: ");
		try {
			test = new RandomInts(0, 5, -1, 1);
			System.out.println(false);
		} catch (Exception e) {
			System.out.println(true);
		}
		
		/* testing that using the same randomNumberSeed will 
		 * result in an equal sequence of ints
		 */
		System.out.print("Test 3: ");
		test = new RandomInts(0, 6, 11, 3);
		for (int i : test) {
			compareOne.add(i);
		}
		test = new RandomInts(0, 6, 11, 3);
		for (int i : test) {
			compareTwo.add(i);	
		}
		System.out.println(compareOne.equals(compareTwo));
		
		// testing when n = 0
		System.out.print("Test 4: ");
		compareOne.clear();
		test = new RandomInts(-7, 90, 0, 23);
		System.out.println(0 == compareOne.size());

		// testing that the number of outputs is never greater than n
		System.out.println("Test 5: ");
		
		for (int i = 0; i < 6; i++) {
			compareOne.clear();
			test = new RandomInts(12, 17, 5, i);
			
			for (int j: test) {
				compareOne.add(j);
			}
			
			if (compareOne.size() > 6) {
				System.out.println("  " + false);
			}
			else {
				System.out.println("  " + true);
			}
		}
		
		// testing that the range of outputs is never outside the range of min and max
		System.out.println("Test 6: ");
		boolean inRange = true;
		int min = -5;
		int max = 5;
		
		for (int i = 0; i < 6; i++) {
			compareOne.clear();
			test = new RandomInts(min--, max++, 5, i);
			
			for (int j: test) {
				compareOne.add(j);
			}
			
			for (int j = 0; j < compareOne.size(); j++) {
				if (!(compareOne.get(j) >= min) || !(compareOne.get(j) < max)) {
					inRange = false;
				}
			}
			System.out.println("  " + inRange);
		}
	}

}

