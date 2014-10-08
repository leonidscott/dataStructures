//Lenny Scott, ProblemSet2
import java.util.Stack;
import java.util.Random;

public class ProblemSet2 {
	
	public static void main(String args[]) {
		//problem 1
		Stack<Integer> firstStack = new Stack<Integer>();
		Stack<Integer> secondStack = new Stack<Integer>();
		stacksEqual(firstStack, secondStack);
		//problem 1 tests
		//stackEqualsTest();
		
		//problem 2
		String[] articles = {"", "", "", "", ""};
		String[] adjectives = {"", "", "", "", ""};
		String[] nouns = {"", "", "", "", ""};
		String[] verbs = {"", "", "", "", ""};
		randomSentence(articles, adjectives, nouns, verbs);
		//problem 2 test
		//randomSentenceTest();
		
		//problem 3 
		diceRollDistribution();
		//diceRollDistributionTest();
	}
	
	public static boolean stacksEqual(Stack<Integer> firstStack, Stack<Integer> secondStack){
		Stack<Integer> firstStackTemp = new Stack<Integer>();
		Stack<Integer> secondStackTemp = new Stack<Integer>();
		int firstStackVal;
		int secondStackVal;
		boolean areEqual = true;
		
		if(firstStack.empty() && secondStack.empty()){
			areEqual = true;	
		}
		while(!firstStack.empty() && !secondStack.empty()){
			firstStackVal = firstStack.peek();
			secondStackVal = secondStack.peek();
			
			firstStackTemp.push(firstStack.pop());
			secondStackTemp.push(secondStack.pop());
			
			if(firstStackVal != secondStackVal){
				areEqual = false;
				break;
			}
		}
		if(firstStack.empty() != secondStack.empty()){
			areEqual = false;	
		}
		
		cleanStack(firstStack, firstStackTemp);
		cleanStack(secondStack, secondStackTemp);
		return areEqual; 
	}
	
	public static void cleanStack(Stack<Integer> originalStack, Stack<Integer> tempStack){
		while(!tempStack.empty()){
			originalStack.push(tempStack.pop());	
		}
	}
	
	public static void stackEqualsTest(){
		// I CANNOT WAIT UNTIL J-UNIT!!
		/* Test Cases: first  second	result
			1	[]	[]	true 
			2.	[]	[1,1]	false
			3.	[1,1]	[]	false
			4.	[1,1]	[1,1]	true
			5.	[1,2]	[1,2]	true
			6.	[1,2]	[2,1]	false
			7.	[1,2]	[1,3]	false
			8.	[2,1]	[3,1]	false
			9.	[1]	[1,1]	false
			**after every test case there will have to be a test to make sure the stack was maintained**
		*/
		//intializing test stacks
		Stack<Integer> firstStack = new Stack<Integer>();
		Stack<Integer> secondStack = new Stack<Integer>();
		//base case
		System.out.println("*BASE CASE*: first stack: " + firstStack + ", second stack: " + secondStack);
		//test 1
		System.out.println("1: [], []: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]"); 
		//test 2
		secondStack.push(1);
		secondStack.push(1);
		System.out.println("2: [], [1,1]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]"); 
		//test 3
		secondStack.pop();
		secondStack.pop();
		firstStack.push(1);
		firstStack.push(1);
		System.out.println("3: [1,1], []: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
		//test 4
		secondStack.push(1);
		secondStack.push(1);
		System.out.println("4: [1,1], [1,1]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
		//test 5
		firstStack.pop();
		firstStack.pop();
		firstStack.push(1);
		firstStack.push(2);
		secondStack.pop();
		secondStack.pop();
		secondStack.push(1);
		secondStack.push(2);
		System.out.println("5: [1,2], [1,2]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
		//test 6
		secondStack.pop();
		secondStack.pop();
		secondStack.push(2);
		secondStack.push(1);
		System.out.println("6: [1,2], [2,1]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
		//test 7
		secondStack.pop();
		secondStack.pop();
		secondStack.push(1);
		secondStack.push(3);
		System.out.println("7: [1,2], [1,3]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
		//test 8 
		firstStack.pop();
		firstStack.pop();
		firstStack.push(2);
		firstStack.push(1);
		secondStack.pop();
		secondStack.pop();
		secondStack.push(3);
		secondStack.push(1);
		System.out.println("8: [2,1], [3,1]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
		//test 9
		firstStack.pop();
		firstStack.pop();
		firstStack.push(1);
		secondStack.pop();
		secondStack.pop();
		secondStack.push(1);
		secondStack.push(1);
		System.out.println("9: [1], [1,1]: " + stacksEqual(firstStack, secondStack));
		System.out.println("output: [" + firstStack + "] [" + secondStack + "]");
	}
	
	public static String randomSentence(String[] articles, String[] adjectives, String[] nouns, String[] verbs){
		Random randomElement = new Random();
		
		int articlesIndex = randomElement.nextInt(articles.length);
		int adjectivesIndex = randomElement.nextInt(adjectives.length);
		int nounsIndex = randomElement.nextInt(nouns.length);
		int verbsIndex = randomElement.nextInt(verbs.length);
		
		String randomSentence = articles[articlesIndex] + " " + adjectives[adjectivesIndex] + " " + nouns[nounsIndex] + " " + verbs[verbsIndex] + ".";
		return randomSentence;
	}
	
	public static void randomSentenceTest(){
		/*Test Case:
			1. Same size array
			2. Different size array
		*/
		//test 1
		String[] articles = {"To the", "so", "your", "you", "it"};
		String[] adjectives = {"limping", "decisive", "insidious", "tricky", "guess what"};
		String[] nouns = {"digestion", "list", "snow", "@Joebeaver", "java"};
		String[] verbs = {"we broke it", "elicit", "justify", "witness", "compose"};
		
		for(int i = 0; i<10000; i++){
			System.out.println(randomSentence(articles, adjectives, nouns, verbs));
			// should print random sentences with only one word from each array	
		}
		//test 2
		String[] articlesTwo = {"To the", "so", "your", "you"};
		String[] adjectivesTwo = {"limping", "decisive", "insidious", "tricky", "guess what"};
		String[] nounsTwo = {"digestion", "@Joebeaver", "java"};
		String[] verbsTwo = {"we broke it", "elicit", "justify", "witness", "compose"};
		
		for(int i = 0; i<10000; i++){
			System.out.println(randomSentence(articlesTwo, adjectivesTwo, nounsTwo, verbsTwo));	
			// should print random sentences with only one word from each array
		}
	}
	
	public static int[] diceRollDistribution(){
		Random die = new Random();
		int[] distribution = new int[11];
		int dieOne;
		int dieTwo;
		int numberOfRolls = 0;
		
		while(numberOfRolls < 10000){
			dieOne = die.nextInt(6) + 1;
			dieTwo = die.nextInt(6) + 1;
			distribution[(dieOne + dieTwo)- 2] += 1;
			numberOfRolls += 1;
		}
		return distribution;
	}
	
	public static void printArray(int[] array){
		System.out.print("[");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
			if(i != array.length - 1){
				System.out.print(", ");	
			}
		}
		System.out.println("]");
	}
	
	public static void diceRollDistributionTest(){
		/*Test Case:
			1.Test a lot
		*/
		for(int i = 0; i<1000; i++){
			printArray(diceRollDistribution());
			//should return the an array 11 elements
		}
	}
}