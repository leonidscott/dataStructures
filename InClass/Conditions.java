public class Conditions {
	public static void main(String [] args) {
		int n = 5;
		// check if n is between 1 and 6
		if (n >= 1 && n <= 6) {
			System.out.println(n + " is in the range from 1 to 6");
		} else {
			System.out.println(n + " is outside of the range from 1 to 6");
		}

		
		// if doesn't have to have an else
		// check if n is not equal to 10:
		if (n != 10) { // you can also write if (!(n == 10))
			System.out.println(n + " is not equal to 10");	
		}
			
		
		// check if n is divisible by 2 or 5:
		if (n % 2 == 0 || n % 5 == 0) {
			System.out.println(n + " is divisible by 2 or 5");	
		}
		
	
		
		// check if n is divisible by 2 or 5 but not by both
		if (n % 2 == 0 ^ n % 5 == 0) {
			System.out.println(n + " is divisible by 2 or 5, but not both");
		}
	
		// cascading if/else is just a sequence of if/elses:
		if (n < 0) {
			System.out.println(n + " is negative");	
		} else if (n == 0) {
			System.out.println("n is 0");	
		} else { // no more checks are needed: no other possibilities
			System.out.println(n + " is positive");	
		}
		
	}
}

