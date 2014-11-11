//Preston Miller, Ben Villano, Lenny Scott
import java.util.Random;

public class TestGeneralizedCountingSort {

	public static void main(String[] args) throws CardException {
		
		NewCard[] cardsToSort = new NewCard[10];
		
		/**** TO-DO: Randomly fill the array with cards ****/
		fillCardArray(cardsToSort);
		
		CountingSorter.countingSort(cardsToSort);

		/**** TO-DO: Print out the (hopefully) newly sorted array ****/
		printCardArray(cardsToSort);

		/**** TO-DO: Add automated test of larger arrays ****/
		NewCard[] newCards = new NewCard[10000000];
		
		fillCardArray(newCards);
		
		CountingSorter.countingSort(cardsToSort);
		System.out.println();
		System.out.println(checkCardArray(cardsToSort));
	}

	/**
	 * @param cardsToSort
	 * @throws CardException
	 */
	private static void fillCardArray(NewCard[] cardsToSort)
			throws CardException {
		for(int i = 0; i < cardsToSort.length; i++){
			cardsToSort[i] = new NewCard(randomCard("Suit"), randomCard("value"));
		}
	}
	
	public static String randomCard(String type){
		Random rand = new Random();
		if(type.equals("Suit")){
			switch(rand.nextInt(4)){
				case 0:
					return "Hearts";
				case 1:
					return "Diamonds";
				case 2: 
					return "Spades";
				case 3:
					return "Clubs";
			}
		}
		int value = rand.nextInt(13)+2;
		switch(value){
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13: 
				return "K";
			case 14:
				return "A";
			default:
				return ""+value;
			
		}
	}
	
	public static void printCardArray(NewCard[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + (i == array.length-1 ? "" : ", "));
		}
	}
	
	public static boolean checkCardArray(NewCard[] array){
		for(int i = 0; i < array.length - 1; i++){
			if(array[i+1].getNumericValue() < array[i].getNumericValue()){
				return false;
			}
		}
		return true;
	}
}