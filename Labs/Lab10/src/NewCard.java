//Preston Miller, Ben Villano, Lenny Scott
public class NewCard extends CountingSortable {
	private String suit;
	private String value;
	private int numericValue;
	
	/* This is what's known as a "static constructor". It lets you set the static fields
	 * that the class inherits from its superclass. */
	static {
		keyMin = 2;
		keyMax = 14;
	}
	
	public NewCard(String cardSuit, String cardValue) throws CardException {
		if (!cardSuit.equals("Hearts") && !cardSuit.equals("Diamonds") && !cardSuit.equals("Spades") && !cardSuit.equals("Clubs")) {
			throw new CardException(cardSuit, "cardSuit");
		}
		suit = cardSuit;
		value = cardValue;
		numericValue = getNumeric(cardValue);
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getValue() {
		return value;	
	}
	
	public int getNumericValue() {
		return numericValue;	
	}
	
	@Override
	public int key() {
		return numericValue;	
	}
	
	
	private int getNumeric(String value) throws CardException {
		if(value == "A"){
			return 14;
		}
		if(value == "K"){
			return 13;
		}
		if(value == "Q"){
			return 12;
		}
		if(value == "J"){
			return 11;
		}
		
		try {
			int val = Integer.parseInt(value);
			if (val < 2 || val > 10) {
				throw new CardException(value, "cardValue");	
			}
			return val;
		} catch (NumberFormatException e) {
			throw new CardException(value, "cardValue");
		}
		
	}

	public String toString() {
		return value + " of " + suit;
	}
	
	public int compareTo(NewCard other) {
		return numericValue - other.numericValue;
	}
}