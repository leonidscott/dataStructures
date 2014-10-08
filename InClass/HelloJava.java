/* Java has two ways to make comments.  This is one of them - everything
   from the slash-asterisk to the asterisk-slash is a comment, and will 
   be ignored, even accross multiple lines. */

// This is the other way to make comments - everything from a double-slash
// to the end of the same line is a comment.



/* Almost all Java code is part of a "class".  For now, just treat this as
   a necessary bit of bowing-and-scraping to the Java gods. Note the opening
   curly brace: the "{".  This is what Java uses to start code blocks.
   Everything in a class is enclosed in a set of curly braces. Also note
   that the name of the class is also the name of the file it is saved in, 
   just with ".java" added. This is not always necessary, but it often is, so
   it is simplest to always follow this naming scheme.*/
class HelloJava {

	/* Every executable Java program must have one "main" method, which 
	   must look exactly like this - well, almost: "args" could be any 
	   legal variable name (more on that later).  The "main" method is
	   where code execution begins for the program. */
	public static void main(String[] args) {

		/* This is a Java statement.  In this particular case, it is
		   simply a method call. */
		System.out.println("Hello, Java!");

		/* Note the semi-colon at the end of the line of code - every
		   Java statement must end with a semi-colon. Java statements
		   can cross multiple lines - the semi-colon is how Java 
		   knows when the statement is finished, because Java more-or-
		   less ignores white space. For example: */
		System.out.println(
						"Hello, Java, again!"
			)
				;
						
		

	}  // This curly brace closes the main method

}  // This curly brace closes the class
Untitled documentUntitled documentUntitled documentUntitled document

