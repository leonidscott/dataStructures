public class Operators {

	
	public static void main(String[] args) {

		/* Java has a variety of operators - built-in symbols
		   take one, two, or three values and act on them to
		   produce a result. This compilation leaves out the
		   various bitwise operators, which are not likely to
		   be used in this course. */


		/*********************************
		   BINARY OPERATORS (two values)
		 *********************************/

		/****
		  = "is set to" or "equals": assigns a value to a variable
		 ****/

		// Note: "equals" is often considered an inappropriate way to say it

		int x = 5;
		System.out.println(x);			// prints 5

		// value can be result of complex expression or method call
		// as well as a literal:
		long time = System.currentTimeMillis();
		System.out.println(time);	// prints current time*

		// *in milliseconds since midnight January 1, 1970




		/****
		  + "plus": adds two numeric values together or concatenates two strings
		 ****/

		System.out.println(5.8 + 7.3);		// prints 13.1
		System.out.println("One" + "Two");	// prints OneTwo


		
		/****
		  - "minus": subtracts a numeric value from another numeric value
		 ****/

		System.out.println(58 - 16);		// prints 42



		/****
		  * "times" or "multiplied by": multiplies two numeric values
		 ****/

		System.out.println(7 * 6);		// prints 42		
		


		/****
		  / "divided by": divides one numeric value by another numeric value
		 ****/

		System.out.println(378 / 9);		// prints 42

		// Be careful with integer-type values: will truncate, not change to
		// floating point type!
		System.out.println(5 / 2);		// prints 2 (not 2.5)



		/****
		  % "mod" or "modulus": gives the remainder after numeric values are divided
		 ****/

		System.out.println(5 % 2);		// prints 1
		System.out.println(9 % 3);		// prints 0
		System.out.println(34 % 8);		// prints 2

		

		/****
		  == "double equals" or "equals": true if the two values are equal, otherwise false
		 ****/
		System.out.println(5 == 5);		// prints true
		

		int z = 7;
		System.out.println(z == 7);		// prints true
		System.out.println(z == 6);		// prints false

		// Note: Be careful using this with object types: it compares the values on the 
		// stack, not the objects themselves!  (This includes Strings!)



		/****
		  != "not equals": false if the two values are equal, otherwise true
		 ****/

		System.out.println(7 != 6);		// prints true

		// Note: See object warning under ==



		/****
		  > "greater than": true if the first value is larger than the second, otherwise false
		  < "less than": true if the first value is smaller than the second, otherwise false
		  >= "greater than or equals": true if first value is larger than or equal to the second
		  <= "less than or equals": true if first value is smaller than or equal to the second
		 ****/

		System.out.println(5 > 4);		// prints true
		System.out.println(4 < 4);		// prints false
		System.out.println(4 >= 4);		// prints true
		System.out.println(5 <= 4);		// prints false



		
		/****
		  && "double and" or "double ampersand": logical AND (short-circuit evaluation)
		  || "double or" or "double bar": logical OR (short-circuit evaluation)
		 ****/

		System.out.println(true && false);	// prints false
		System.out.println(false || true);	// prints true

		// Short circuit evaluation means that if the expression's overall value can be
		// determined from just the first value, the second will never be evaluated:

		System.out.println(3 > 7 && 8 > 6);	 // prints false without determining truth of 8 > 6
		System.out.println(7 == 7 || 5 < 4);	 // prints true without determining truth of 5 < 4



		
		/****
		  += "plus equals" or (rarely) "increased by": adds the two values and stores in the variable on the left
		  -= "minus equals" or (rarely) "decreased by": subtracts the righthand value from the left and stores in the variable on the left
		 ****/
		 
		 // x += 5; is equivalent to x = x + 5; - thus cannot be applied
		 // to a literal value!  7 += 3 doesn't work
		 int k = 37;
		 k += 5;
		 System.out.println(k);		// prints 42
		 
		 // Note that the left side MUST be a variable, not a literal
		 
		 


		/*******************************
		   UNARY OPERATORS (one value)
		 *******************************/

		/**** 
		  ++ "plus plus": increments (adds one to) an integer variable
		 ****/

		// Equivalent to var = var + 1 or var += 1 (but see below) - thus cannot
		// be applied to a literal value! 7++ doesn't work
		
		// Basic example:
		int a = 5;
		a++;
		System.out.println(a); 			// prints 6

		// The ++ operator acts differently when placed before versus 
		// after the variable if it is included in a more complex 
		// statement (which it very often is):

		a = 10;
		System.out.println(a++);		// prints 10
		System.out.println(a);			// prints 11

		// When placed after the variable, ++ increments it only AFTER
		// it has been used!

		// When placed before the variable, ++ increments it BEFORE it
		// gets used:

		a = 10;
		System.out.println(++a);		// prints 11


		
		/****
		  -- "minus minus": decrements (subtracts one from) an integer
				    variable
		 ****/

		// Just like ++, but subtracting:

		int b = 5;
		b--;
		System.out.println(b);			// prints 4

		b = 10;
		System.out.println(b--);		// prints 10
		System.out.println(b);			// prints 9
		
		b = 10;
		System.out.println(--b);		// prints 9



		/****
		  ! "bang" or "not": logical NOT
		 ****/

		// Applies to boolean literals:
		System.out.println(!true);		// prints false
		System.out.println(!false);		// prints true

		// And to boolean variables (or more complex expression):
		boolean t = true;
		System.out.println(!t);			// prints false
		System.out.println(!(5 > 3));		// prints false
		

		/****
		  - "negative" or "minus": as unary, makes a numeric value negative
		 ****/

		double c = 5.23;
		System.out.println(-c);			// prints -5.23

		// Note: technically, + is also a unary operator in that it won't
		// break if placed before a numeric value, but it doesn't do
		// anything, of course.




		/****
		  ^ "caret" or "bitwise XOR": THIS IS NOT HOW TO RAISE TO AN EXPONENT!!!!!
		 ****/

		System.out.println(2 ^ 3);		// does NOT print 8

		// Note: Exponentiation (or to the power of) is done using the Math class,
		//    not an operator

		



		/***********************************
		   TERNARY OPERATOR (three values)
		 ***********************************/

		/****
		  ? : "question mark ... colon" or "ternary"*: if first value is true, second value, otherwise third value
		 ****/

		int m = -7;
		System.out.println(m >= 0 ? m : -m);	// prints 7

		m = 7;
		System.out.println(m >= 0 ? m : -m);	// still prints 7

		// *it's the only ternary operator, so sometimes it's THE ternary operator
	}

}
