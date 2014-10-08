import java.util.Random;

public class RollToTwenty { 
	public static void main (String[] args) {
		/* 
		Testing: 
			Test RollToTwenty without arguments. 
				Should show value of current roll composite rolls, should stop when result > 20
			Test RollToTwenty without arguments again. 
				Results should differ.
			Test RollToTwenty with input 5
				Should show value of current roll composite rolls, should stop when result > 20
			Test RollToTwenty with input 5 again.
				Results should stay the same
		*/
		
		//initializing stuff
		int seed = 0;
		int rollingOutput = 0;
		int rollDice;
		Random rand = new Random();
		//handelling command line inputs when they occure
		if(args.length > 0) {
			seed = Integer.parseInt(args[0]);
			rand = new Random(seed);
		}
		//rolls die
		while(rollingOutput < 20) {
			rollDice = rand.nextInt(6) + 1;
			rollingOutput += rollDice;
			System.out.println(rollDice + " " + rollingOutput);
		}
	}	
}
