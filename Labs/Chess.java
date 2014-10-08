// lab 3: Lenny, Ben V, Colton
public class Chess {
    public static void main(String[] args) {
	char[][] chessBoard = new char[8][8];
	initialize(chessBoard);

	printChessBoard(chessBoard);
	
	addPiece('P', 'a', '7', chessBoard);
	addPiece('r', 'h', '1', chessBoard);
	addPiece('r', 'a', '1', chessBoard);
	addPiece('R', 'a', '8', chessBoard);
	addPiece('R', 'h', '8', chessBoard);
	addPiece('p', 'd', '1', chessBoard);
	addPiece('r', 'f', '3', chessBoard);
	printChessBoard(chessBoard);
	
	System.out.println("Black a6 to a1 " + rookPossibleMove('a', '1', 'a', '6', false, chessBoard)); //should return true
	System.out.println("Black a8 to h8 " + rookPossibleMove('h', '8', 'a', '8', false, chessBoard)); //should return false
	System.out.println("White a6 to b1 " + rookPossibleMove('b', '1', 'a', '6', true, chessBoard)); //should return false
	System.out.println("Black d3 to d7 " + rookPossibleMove('d', '7', 'd', '3', false, chessBoard)); //should print true
	System.out.println("Black a4 to h4 " + rookPossibleMove('h', '4', 'a', '4', true, chessBoard)); //should print true
	System.out.println("White a1 to a7 " + rookPossibleMove('a', '7', 'a', '1', true, chessBoard)); //should return true
	System.out.println("Black a1 to a7 " + rookPossibleMove('a', '7', 'a', '1', false, chessBoard)); //should return true
	System.out.println("Black a1 to d1 " + rookPossibleMove('d', '1', 'a', '1', false, chessBoard)); //should return false
	System.out.println("White a1 to d1 " + rookPossibleMove('d', '1', 'a', '1', true, chessBoard)); //should return true
	System.out.println("White a1 to h1 " + rookPossibleMove('h', '1', 'a', '1', true, chessBoard)); //should return false
	System.out.println("Black a1 to h1 " + rookPossibleMove('h', '1', 'a', '1', false, chessBoard)); //should return false
	System.out.println("White a8 to h8 " + rookPossibleMove('a', '8', 'a', '8', true, chessBoard)); //should return false 
	
	System.out.println("** Testing moveBlocked() **");
	System.out.println("White f2 to f5 (moving up) " + moveBlocked('f', '5', 'f', '2', chessBoard));// should print true
	System.out.println("White f5 to f2 (moving down) " + moveBlocked('f', '2', 'f', '5', chessBoard));// should print true
	System.out.println("White g6 to g2 (moving down) " + moveBlocked('g', '2', 'g', '6', chessBoard));// should print false
	System.out.println("White f1 to c1 (moving left) " + moveBlocked('c', '1', 'f', '1', chessBoard));// should print true
	System.out.println("White f2 to c2 (moving left) " + moveBlocked('c', '2', 'f', '2', chessBoard));// should print false
	System.out.println("White c1 to f1 (moving right) " + moveBlocked('f', '1', 'c', '1', chessBoard));// should print true
	System.out.println("White c2 to f2 (moving right) " + moveBlocked('f', '2', 'c', '2', chessBoard));// should print false
    }

    /**
       print a chess board
    **/
    public static void printChessBoard(char[][] chessBoard) {
    	    for(int row = 0; row < 8; row++) {
    	    	    for(int col = 0; col < 8; col++) {
    	    	    	    System.out.print(chessBoard[row][col]);
    	    	    }
    	    	    System.out.println();
    	    }
    	    System.out.println();
    }
    
    /**
       This method sets a chessBoard to an empty one
       (characters that do not denote a chess piece)
       White squares are indicated by spaces and
        black squares by +s
    **/
    public static void initialize(char[][] chessBoard) {
    	    for (int row = 0; row < 8; row++) {
    	    	    for (int col = 0; col < 8; col++) {
    	    	    	    chessBoard[row][col] = ((col + row) % 2 == 0) ? ' ' : '+';     
    	    	    }
    	    }
    }



    /**
       This method adds a chess piece to a chessBoard at 
       a given row and column.
    **/
    public static void addPiece(char piece, char column, char row, char[][] chessBoard) {
    	    int rowIndex = '8' - row;
    	    int colIndex = column - 'a';
    	    
    	    chessBoard[rowIndex][colIndex] = piece;
    }
    
    public static boolean rookPossibleMove(char destCol, char destRow, char currentCol, char currentRow, boolean isWhite, char[][] chessBoard){
    	    if(destCol == currentCol && !moveBlocked(destCol, destRow, currentCol, currentRow, chessBoard)){
    	    	    //moving up and down
    	    	    return (canTake(destCol, destRow, currentCol, currentRow, isWhite, chessBoard));    
    	    }
    	    else if(destRow == currentRow && !moveBlocked(destCol, destRow, currentCol, currentRow, chessBoard)){
    	    	    //moving side to side
    	    	    return (canTake(destCol, destRow, currentCol, currentRow, isWhite, chessBoard));
    	    }
    	    return false;  
    }
    
    public static boolean canTake(char destCol, char destRow, char currentCol, char currentRow, boolean isWhite, char[][] chessBoard){
    	    int convertedDestCol = destCol - 'a';
    	    int convertedDestRow = (destRow - '8') * (-1);
    	    if ( chessBoard[convertedDestRow] [convertedDestCol] != ' ' && chessBoard[convertedDestRow] [convertedDestCol] != '+'){
    	    	    if (isWhite && Character.isUpperCase(chessBoard[convertedDestRow][convertedDestCol])) {
    	    	    	    return true;
    	    	    } else if (isWhite && !Character.isUpperCase(chessBoard[convertedDestRow][convertedDestCol])) {
    	    	    	    return false;
    	    	    }
    	    	    
    	    	    if (!isWhite && !Character.isUpperCase(chessBoard[convertedDestRow][convertedDestCol])) {
    	    	    	    return true;
    	    	    } else if (!isWhite && Character.isUpperCase(chessBoard[convertedDestRow][convertedDestCol])) {
    	    	    	    return false;
    	    	    }
    	    }
    	    return true;
    	     
    }
    
    public static boolean moveBlocked(char destCol, char destRow, char currentCol, char currentRow, char[][] chessBoard) {
    	    int convertedDestCol = destCol - 'a';
    	    int convertedDestRow = (destRow - '8') * (-1);
    	    int convertedCurrentCol = currentCol - 'a';
    	    int convertedCurrentRow = (currentRow - '8') * (-1);
    	    boolean isMoveBlocked = false;
    	    //iterates over all of the spots from start to finish EXCEPT the last spot
    	    //moving up
    	    if(convertedCurrentRow > convertedDestRow) {
    	    	    for(int i = convertedCurrentRow; i > (convertedDestRow + 1); i--) {
    	    	    	    if(chessBoard[i][convertedDestCol] != ' ' && chessBoard[i][convertedDestCol] != '+') {
    	    	    	    	    isMoveBlocked = true;
    	    	    	    }
    	    	    	    else {
    	    	    	    	isMoveBlocked = false;	    
    	    	    	    }
    	    	    }
    	    }
    	    //moving down
    	    if(convertedCurrentRow < convertedDestRow) {
    	    	    for(int i = convertedCurrentRow; i < convertedDestRow - 1; i++) {
    	    	    	    if(chessBoard[i][convertedDestCol] != ' ' && chessBoard[i][convertedDestCol] != '+') {
    	    	    	    	isMoveBlocked = true;	    
    	    	    	    }
    	    	    	    else {
    	    	    	    	isMoveBlocked = false;	    
    	    	    	    }
    	    	    }
    	    }
    	    //moving left
    	    if(convertedCurrentCol > convertedDestCol) {
    	    	    for(int i = convertedCurrentCol; i > convertedDestCol + 1; i--) {
    	    	    	   if(chessBoard[convertedDestRow][i] != ' ' && chessBoard[convertedDestRow][i] != '+') { 
    	    	    	   	isMoveBlocked = true;	   
    	    	    	   }
    	    	    	   else {
    	    	    	    	isMoveBlocked = false;	    
    	    	    	   }
    	    	    }
    	    }
    	    //moving right
    	    if(convertedCurrentCol < convertedDestCol) {
    	    	  for(int i = convertedCurrentCol; i < convertedDestCol - 1; i++) {
    	    	  	  if(chessBoard[convertedDestRow][i] != ' ' && chessBoard[convertedDestRow][i] != '+') { 
    	    	    	   	isMoveBlocked = true;	   
    	    	    	  }  
    	    	    	  else {
    	    	    	    	isMoveBlocked = false;	    
    	    	    	  }
    	    	  }
    	    }
    	    return isMoveBlocked;
    	    
    }

}
