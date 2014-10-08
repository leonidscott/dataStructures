//lenny scott problem set 3
import java.util.ArrayList;

public class ProblemSet3 {
	public static void main(String args[]) {
		String[] exampleArray = {"badger", "badger", "badger", "badger", "badger", "badger",
					"mushroom!", "mushroom!"};
		//System.out.println(mostFrequentElement(exampleArray));
		//mostFrequentElementTest();
		//stringsEqualTest();
	}
	
	public static String mostFrequentElement(String[] stringArray) {
		ArrayList<String> stringHolder = new ArrayList<String>();
		ArrayList<Integer> metaHolder = new ArrayList<Integer>();

		for(int i = 0; i < stringArray.length; i++){
			if(stringHolder.size() == 0){
				stringHolder.add(stringArray[i]);
				metaHolder.add(1);
			}
			for(int j = 0; j < stringHolder.size(); j++){
				if(stringsEqual(stringArray[i], stringHolder.get(j))){
					int metaHolderVal = metaHolder.get(j);
					metaHolder.set(j, metaHolderVal + 1);
				}
				else{
					stringHolder.add(stringArray[i]);
					metaHolder.add(1);
				}
			}
		}
		return stringHolder.get(highestValue(metaHolder));
	}
	
	public static boolean stringsEqual(String originalString, String compareTo){
		boolean isEqual = true;
		int index = 0;
		while(isEqual){
			if(originalString.length() == index && compareTo.length() == index){
				break;
			}
			if(originalString.length() == index || compareTo.length() == index){
				isEqual = false;
			}
			else if(originalString.charAt(index) != compareTo.charAt(index)){
				isEqual = false;
			}
			index++;
		}
		return isEqual;
	}
	
	public static int highestValue(ArrayList<Integer> numberedList){
		int highestVal = 0;
		int highestIndex = 0;
		for(int i = 0; i < numberedList.size(); i++){
			int numberedListVal = numberedList.get(i);
			if(numberedListVal > highestVal){
				highestVal = numberedListVal;
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	public static void mostFrequentElementTest() {
		/*Test:
			1.{null}				should return empty string
			2.{"badger"}				should return badger
			3.{"badger", "badger"}			should return badger
			4.{"badger", mushroom"}			should return badger
			5.{null, null, null}			should return empty string
			6.{"badger", null, null}		should return badger
			7.{"badger", "badger", null}		should return badger
			8.{"badger", "mushroom!", null} 	should return badger
			9.{"badger", "badger", "mushroom!"}	should return badger
		*/
		//test 1
		String[] testArrayOneElement = new String[1];
		//System.out.println("input1 = {}: " + mostFrequentElement(testArrayOneElement).equals("I'm sorry Joe, i'm afraid I can't do that: no elements to search through"));
		//test 2
		testArrayOneElement[0] = "badger";
		System.out.println("input2 = {badger}: " + mostFrequentElement(testArrayOneElement).equals("badger"));
		//test 3
		String[] testArrayTwoElement = {"badger", "badger"};
		System.out.println("input3 = {badger, badger}: " + mostFrequentElement(testArrayTwoElement).equals("badger"));
		//test 4
		testArrayTwoElement[1] = "mushroom!";
		System.out.println("input4 = {badger, mushroom!}: " + mostFrequentElement(testArrayTwoElement).equals("badger"));
		//test 5
		String[] testArrayThreeElement = new String[3];
		//System.out.println("input5 = {}: " + mostFrequentElement(testArrayThreeElement).equals("I'm sorry Joe, i'm afriad I can't do that: no elements to search through"));
		//test 6
		testArrayThreeElement[0] = "badger";
		//System.out.println("input6 = {badger}: " + mostFrequentElement(testArrayThreeElement).equals("badger"));
		//test 7
		//testArrayThreeElement[1] = "badger";
		//System.out.println("input7 = {badger, badger}: " + mostFrequentElement(testArrayThreeElement).equals("badger"));
		//test 8
		//testArrayThreeElement[1] = "mushroom!";
		//System.out.println("input8 = {badger, mushroom!}: " + mostFrequentElement(testArrayThreeElement).equals("badger"));
		//test 9 
		testArrayThreeElement[0] = "badger";
		testArrayThreeElement[1] = "mushroom!";
		testArrayThreeElement[2] = "mushroom!";
		System.out.println("input9 = {badger, mushroom!, mushroom!}: " + mostFrequentElement(testArrayThreeElement).equals("badger"));
	}
	
	public static void stringsEqualTest(){
		/* Test stringsEqual();
			1. {}		{}
			2. {"badger"}	{}
			3. {}		{"badger"}
			4. {"badger"}	{"badger"}
			5. {"badger"}	{"mushroom!"}
			6. {"badger"}	{"badg"}
		*/
		
		System.out.println("case1 = {}{}: " + stringsEqual("", "")); //test 1
		System.out.println("case2 = {badger}{}: " + stringsEqual("badger", "")); //test 2
		System.out.println("case3 = {}{badger}: " + stringsEqual("", "badger")); //test 3
		System.out.println("case4 = {badger}{badger}: " + stringsEqual("badger", "badger")); //test 4
		System.out.println("case5 = {badger}{mushroom!}: " + stringsEqual("badger", "mushroom!")); //test 5
		System.out.println("case6 = {badger}{badge}: " + stringsEqual("badger", "badge")); //test 6
	}
}
