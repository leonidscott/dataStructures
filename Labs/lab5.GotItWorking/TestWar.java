public class TestWar {
	public static void main(String[] args) {
		Deck  deck = new Deck();
		Player joe = new Player("joe");
		Player lemmon = new Player("lemmon");
		joe.addCardsToHand(deck.dealCards(26));
		lemmon.addCardsToHand(deck.dealCards(26));
		War.playWar(joe, lemmon);
	}
}
