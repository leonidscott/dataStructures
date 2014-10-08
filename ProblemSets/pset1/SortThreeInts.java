// Lenny Scott. Problem Set 1: Question 1
/* Data Tested:
	1, 2, 3
	2, 3, 1
	3, 1, 2
	2, 1, 3
	1, 3, 2
	3, 2, 1
*/

public class SortThreeInts {
	public static void main(String[] args) {
		//getting ints from command line
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		//passing off varibles to other function
		sorter(n1, n2, n3);
	}

	public static void sorter( int n1, int n2, int n3) {
		if (n1 > n2 && n1 > n3) {
			if (n2 > n3) {
				System.out.println(n3 + "\n" + n2 + "\n" + n1);	
			}
			else{
				System.out.println(n2 + "\n" + n3 + "\n" + n1);	
			}
		}
		else{
			sorter(n2, n3, n1);
			// rotate inputs and try again
		}
	}
}
