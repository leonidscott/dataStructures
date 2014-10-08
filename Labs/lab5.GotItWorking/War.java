public class War {
	public static void main(String args[]) {
		Deck  deck = new Deck();
		Player joe = new Player("joe");
		Player lemmon = new Player("lemmon");
		joe.addCardsToHand(deck.dealCards(26));
		lemmon.addCardsToHand(deck.dealCards(26));
		
		playWar(joe, lemmon);
	}
	
	
	public static Player playWar(Player player1, Player player2){
		Player winningPlayer = new Player("heapspace");
		int count = 0;
		while(player1.cardCount() != 0 && player2.cardCount() != 0) {
			
			Card card1 = player1.playCard();
			Card card2 = player2.playCard();
			
			System.out.println(player1.getName() +  " " + card1.toString());
			System.out.println(player2.getName() + " " + card2.toString());
			
			if(card1.getNumericValue() > card2.getNumericValue()) {
				player1.addCardToHand(card1);
				player1.addCardToHand(card2);
			} 
			else if(card1.getNumericValue() < card2.getNumericValue()) {
				player2.addCardToHand(card1);
				player2.addCardToHand(card2);
			}
			else {
				winningPlayer = warCase(player1, player2, 3);
				if( winningPlayer == player1) 	{
					player1.addCardToHand(card1);
					player1.addCardToHand(card2);
				} else if(winningPlayer == player2) 	{
					player2.addCardToHand(card1);
					player2.addCardToHand(card2);
				}
				else{
					if(player1.cardCount() < player2.cardCount()) { 
						winningPlayer = player2;
						System.out.println(player2.getName() + " won!");
					} else if(player2.cardCount() < player1.cardCount()) {
						winningPlayer = player1;
						System.out.println(player1.getName() + " won!");
					}
					break;	
				}
			
			} 
			
			
			if(!player1.hasCards()) { 
				winningPlayer = player2;
				System.out.println(player2.getName() + " won!");
			} else if(!player2.hasCards()) {
				winningPlayer = player1;
				System.out.println(player1.getName() + " won!");
				
			}
			System.out.println(player1.getName() + " has " + player1.cardCount());
			System.out.println(player2.getName() + " has " + player2.cardCount());
			System.out.println();
			count++;
			if (count == 30000){
				System.out.println("The game is a draw!");
				break;
			}

		}
		return winningPlayer;
		
	}
	
	public static Player warCase(Player player1, Player player2, int index) {
		Player winningPlayer = new Player("someGuy");
		System.out.println("War!");
		System.out.println("before the loop, we have: P1CC = " + player1.cardCount() + " P2CC = " + player2.cardCount());
		
		if(player1.cardCount() < index + 1) {
			//for(int i = 0; i < player1.cardCount() - 1; i++ ) {
			//	player1.playCard();	
			//}
			System.out.println(player1.getName() + " doesn't have enough cards to play war");
		} else if(player2.cardCount() < index + 1) {
			//for(int i = 0; i < player2.cardCount() - 1; i++ ) {
			//	player2.playCard();
			//};
			System.out.println(player2.getName() + " doesn't have enough cards to play war");

		} else {
			Card warCard1 = player1.warCaseCard(index);                                                                  
			Card warCard2 = player2.warCaseCard(index);
			
			System.out.println(player1.getName() +  " " + warCard1.toString());
			System.out.println(player2.getName() +  " " + warCard2.toString());
			
			if(warCard1.getNumericValue() > warCard2.getNumericValue()) {
				winningPlayer = player1;
				player1.addCardToHand(warCard1);
				player1.addCardToHand(warCard2);
				for( int i = index - 1; i >= 0; i--) {
					System.out.println("index: " + index + " i: " + i + " P1CC: " + player1.cardCount() + " P2CC = " + player2.cardCount());
					player1.addCardToHand(player2.warCaseCard(i));
					player1.addCardToHand(player1.warCaseCard(i));
				}
			} 
			else if(warCard1.getNumericValue() < warCard2.getNumericValue()) {
				winningPlayer = player2;
				player2.addCardToHand(warCard1);
				player2.addCardToHand(warCard2);
				for(int i = index - 1; i >= 0; i--) {
					System.out.println("index: " + index + " i: " + i + " P1CC: " + player1.cardCount() + " P2CC " + player2.cardCount());
					player2.addCardToHand(player1.warCaseCard(i));
					player2.addCardToHand(player2.warCaseCard(i));
				}
			}
			else {
				winningPlayer = warCase(player1, player2, index += 4);
				
				if( winningPlayer == player1) 	{
					player1.addCardToHand(warCard1);
					player1.addCardToHand(warCard2);
				} else if(winningPlayer == player2) 	{
					player2.addCardToHand(warCard1);
					player2.addCardToHand(warCard2);
				}
			}	
		}
		System.out.println("after the loop, we have: P1CC = " + player1.cardCount() + " P2CC " + player2.cardCount());
		return winningPlayer;
	}
}
