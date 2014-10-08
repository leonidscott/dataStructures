//Lenny Scott Valencia Ingram Lab 2

import java.util.Random;

public class Lab2 {
	
	public static void main(String[] args) {
		//Problem 1 Test
		System.out.println("Problem 1");
		System.out.println(countChar("morris", 'r') == 2);
		System.out.println(countChar("morris", 'x') == 0);
		System.out.println(countChar("morris", 'R') == 0);
		System.out.println(countChar("", 'r') == 0);
		//Problem 2 Test
		System.out.println("Problem 2");
		System.out.println(hasEvenOccurrences("Morris", 'x') == false);
		System.out.println(hasEvenOccurrences("Morris", 'r') == true);
		//Problem 3 Test
		System.out.println("Problem 3");
		printFactors(12); 
		printFactors(1); //Should print 1 and 1
		printFactors(4); //Should print 1 and 4, 2 and 2
		printFactors(12); //Should print 1 and 12, 2 and 6, 3 and 4
		printFactors(100); //Should print 1 and 100, 2 and 50, 4 and 25, 5 and 20, 10 and 10
		//Problem 4 Test
		System.out.println("Problem 4");
		System.out.println(randomProduct(1) == 1); //Should return 1
		System.out.println(randomProduct(2) == 2); //Should return 1, 2, 4
		
		for(int i = 1; i <= 1000; i++){
			System.out.println(randomProduct(i) >0 && randomProduct(i) <= 1000000);
		}
		
	}
	
	public static int countChar(String input, char character) {
		if (input == "") {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == character) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean hasEvenOccurrences(String input, char character) {
		int count = countChar(input, character);
		if (count % 2 == 0) {
			return true;
		}
		return false;		 
	}
	
	public static void printFactors(int input) {
		System.out.println(input + " can be factored as:");
		
		if (input == 1) {
			System.out.println("1 and 1");
		}
		else{
			for (int i = 1; i <= Math.sqrt(input); i++) {
				if(input % i == 0){
					System.out.println( i + " and " + input/i); 
				}
			}
		}		
	}


	public static int randomProduct(int n) {
		Random methodRand = new Random(n);
		int rand1 = methodRand.nextInt(n) + 1;
		int rand2 = methodRand.nextInt(n) + 1;
		return rand1 * rand2;
	}
}
