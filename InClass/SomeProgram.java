public class SomeProgram {

	/* The String array args holds any command-line arguments provided to a program.  
	   Arguments are separated by spaces, so to treat several words as a single string, 
	   enclose them in quotes or escape the spaces by putting a backslash (\) in front of
           them.  */
	public static void main(String[] args) {

		/* To treat numbers entered as command-line arguments as integers (or any
		   non-String type), you have to parse the string version, and store the result
		   in a variable of type int. */
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
	
		System.out.println(n1 * n2);
	}
}
