// Lenny Scott: pset6

import java.util.Arrays;
import java.util.Random;


public class TestHashes {

	public static void main(String[] args) {
		Integer[] hundredRandomInts = new Integer[101];
		fillArray(hundredRandomInts);
		
		System.out.println("*** RANDOM ARRAY ***");
		System.out.println(Arrays.toString(hundredRandomInts));
		System.out.println();
		
		OpenAddressHashtable<Integer, Integer> linear = new LinearProbingHashtable<>();
		OpenAddressHashtable<Integer, Integer> quadratic = new QuadraticProbingHashtable<>();
		OpenAddressHashtable<Integer, Integer> doubleHash = new DoubleHashingHashtable<>();
		
		// Load Factor .25
		System.out.println("*** LOAD FACTOR APROX .25 ***");
		System.out.println("Linear Probing");
		loadUpHashTable(linear, hundredRandomInts, .25);
		System.out.println("Quadratic Probing");
		loadUpHashTable(quadratic, hundredRandomInts, .25);
		System.out.println("Double Hashing");
		loadUpHashTable(doubleHash, hundredRandomInts, .25);
		System.out.println();
		
		// Load Factor .5
		System.out.println("*** LOAD FACTOR APROX .5 ***");
		System.out.println("Linear Probing");
		loadUpHashTable(linear, hundredRandomInts, .5);
		System.out.println("Quadratic Probing");
		loadUpHashTable(quadratic, hundredRandomInts, .5);
		System.out.println("Double Hashing");
		loadUpHashTable(doubleHash, hundredRandomInts, .5);
		System.out.println();
		
		// Load Factor .75
		System.out.println("*** LOAD FACTOR APROX .75 ***");
		System.out.println("Linear Probing");
		loadUpHashTable(linear, hundredRandomInts, .75);
		System.out.println("Quadratic Probing");
		loadUpHashTable(quadratic, hundredRandomInts, .75);
		System.out.println("Double Hashing");
		loadUpHashTable(doubleHash, hundredRandomInts, .75);
		System.out.println();
		
		// Load Factor 1
		System.out.println("*** LOAD FACTOR EXACTLY 1.0 ***");
		System.out.println("Linear Probing");
		loadUpHashTable(linear, hundredRandomInts, 1);
		System.out.println("Quadratic Probing");
		loadUpHashTable(quadratic, hundredRandomInts, 1);
		System.out.println("Double Hashing");
		loadUpHashTable(doubleHash, hundredRandomInts, 1);
		System.out.println();
	}
	
	private static void fillArray(Integer[] hundredRandomInts) {
		Random randomDataGenerator = new Random();
		for (int i = 0; i < hundredRandomInts.length; i++) {
			hundredRandomInts[i] = Math.abs(randomDataGenerator.nextInt());
		}
	}



	private static void loadUpHashTable(OpenAddressHashtable<Integer, Integer> hashTableType, Integer[] hundredRandomInts, double loadFactor) {
		hashTableType.clear();
		for (int i = 0; i < 101 * loadFactor; i++) {
			try {
				hashTableType.put(hundredRandomInts[i], 1);
			} catch (Exception HashtableFullException) {
				System.out.println("  @JoeBeaverIBrokeIt: Failed at size " + hashTableType.size() + " after " + hashTableType.getCollisionCount() + " collisions");
				return;
			}
		}
		System.out.println("  Load Factor: " + hashTableType.getLoadFactor());
		System.out.println("  Collisions: " + hashTableType.getCollisionCount());
	}

}
