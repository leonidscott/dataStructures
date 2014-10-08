import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private static ArrayList<Card> cards = new ArrayList<Card>();
	private static String[] suits = new String[] {"Hearts", "Clubs", "Spades", "Diamonds" };
	private static String[] vals = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private static Stack<Card> deck = new Stack<Card>();
	private static Random rand = new Random();

	public Deck() {
		makeDeck();
		shuffle();
		
	}	
	
	public static void makeDeck(){
		for(int i = 0; i < 4; i++) {	//iterates over suits
			for(int j = 0; j < 13; j++) {	//iterates over the values in each suit
				cards.add(new Card(suits[i], vals[j]));
			}
		}
	}
	
	public static void shuffle(){
		for(int i = 52; i > 0; i--){
			int randIndex = rand.nextInt(i);
			deck.push(cards.remove(randIndex));
		}
	}
	
	
	/* Return the top numCards cards from the deck, in an arraylist.  This can be used to
	   Give a player his/her initial 26 cards all at once */
	public ArrayList<Card> dealCards(int numCards) {
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++){
			hand.add(deck.pop());
		}
		return hand;
	}
}
