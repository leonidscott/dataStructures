//Preston Miller, Ben Villano, Lenny Scott
public class CardException extends Exception {
	String errorVal;
	String errorVar;
	
	public CardException(String errorVal, String errorVar) {
		this.errorVal = errorVal;
		this.errorVar = errorVar;
	}
	
	public String toString() {
		return "Invalid Card: " + errorVal + " is not a valid argument for " + errorVar;	
	}
}