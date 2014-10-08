class PrimitivesTwo {

	/* Java has 8 "primitives" or built-in types that are stored on
	   the stack.  (Objects, by contrast, are stored on the heap.) 
	   
	   You'll only regularly use 4 of them, though! */

	public static void main(String[] args) {
		
		/* the int type represents a 32-bit integer, which can hold 
		   values from -2,147,483,648 to 2,147,483,647
		   
		   int is the "standard" integer type - use it unless you
		   have a reason not to */
		
		int i;  //"declaration"
		i = 5;  //"initialization"
	
		int j = 2147483647;
		System.out.println(j);
		j = j + 1;
		System.out.println(j);
		
		/* the byte type represents an 8-bit integer, which can hold
		   values from -128 to 127 */
		byte b = 115;
		
		/* the short type represents a 16-bit integer, which can hold
		   values from -32,768 to 32,767 */   
		short s = -25678;
		
		/* the long type represents a 64-bit integer, which can hold
		   values from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 */
		long y = 1508763578473829434L;	// the L at the end makes the literal a long rather than an int
		
		
		/* within the integer types, Java will make automatic conversions whenever
		   the values move to larger types  */
		short bb = b;
		System.out.println(bb);
		
		/* but not when going the other direction! \
		   even if the actual value would fit! */
		//short ii = i;  // causes an error
		 
		
		
		/* the float type represents a 32-bit floating-point number, which 
		   can hold values from -3.4028235E+38 to 3.4028235E+38, but 
		   CRITICALLY has only about 6 to 9 digits of precision (it depends 
		   on the exponent).  Fractional values can be as small as 1.4E-45 */
		float pi_float = 3.14159265358979f;	// the f at the end makes the literal a float rather than a double
		System.out.println(pi_float);  // prints 3.1415927 because it can't hold more precision
		
		/* the double type represents a 64-bit floating-point number, which
		   can hold values from -1.79769E+308 to 1.79769E+308, and has about 15-17
		   digits of precision.  Fractional values can  be as small as about
		   4.9E-324
		   
		   double is the "standard" floating-point type */
		double pi_double = 3.1415926535897932384626433;
		System.out.println(pi_double); // prints 3.141592653589793 because it can't hold more precision
		
		/* because they are binary, floating point variables are often not exact representations of the 
		   decimal values that are assigned to them */
		double x = 1.1;
		double z = .89;
		System.out.println(x - z);		// "should" print .21    actually prints .210000000000000008
		System.out.println(1.2 - .99);	// "should" print .21    actually prints .209999999999999996
		
		/* NEVER expect the results of calculations with floating point values to come out to some
                   specific value!  */


		
		/* the boolean type holds either true or false  - there is no 
		   direct conversion or equivalence with numeric values */
		boolean boo = true;
		
		
		
		
		/* the char type is a 16-bit value (basically an unsigned short,
		   something we'll talk about more later), which represents a
		   Unicode character (this is not 100% exact, but it will work
		   for now) */
		char c = 'g';
		System.out.println(c);
		
		// WARNING: chars are NOT just short Strings
		System.out.println(c + c);		// prints 206
	}
}
Untitled document

