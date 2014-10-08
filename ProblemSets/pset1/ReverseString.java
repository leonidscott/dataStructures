public class ReverseString {
	public static void main(String[] args) {
		
		String stringInput = args[0];
		String stringOutput = "";
		
		for(int i = stringInput.length() - 1; i >= 0 ; i--) {
			stringOutput += stringInput.charAt(i);
		}
		
		System.out.println("Reverse string: " + stringOutput);
	}
}
