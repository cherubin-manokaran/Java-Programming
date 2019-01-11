/* Tic-Tac-Toe in Java
 * Cherubin Manokaran
 * CS 11A Final Project
 */
import java.util.Scanner;

public class TicTacToe {
	static Scanner input = new Scanner(System.in);
	static int rows;
	static int columns;
	static String[][] board;

	public static void main(String[] args) {
		System.out.println("Play Tic-Tac-Toe with boards of any size!");
		System.out.print("Enter board dimensions: ");
		rows = input.nextInt();
		columns = rows;
		board = createBoard();
		printBoard();
		
		boolean over = false;
		int player = 1;
		int moves = 1;
		do {
			play(player);
			
			// Checks if player made a winning move when winning is possible
			if (moves >= ((rows+columns)-1))
				over = won();
						
			if (over)
				System.out.print("Game over. Player " + player + " won.");
			
			if (player == 1)
				player = 2;
			else
				player = 1;
			
			// Determines if game is a draw based on number of moves
			if (moves == (rows*columns)) {
				System.out.print("Game over. It's a draw.");
				over = true;
			}
						
			printBoard();
			
			moves++;
		} while (!over);

	}
	public static String[][] createBoard(){
		String[][] board = new String[rows][columns];
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				board[i][j] = "-";
			}
		}
		return board;
	}
	// Neatly prints tic-tac-toe board using a formatted string
	public static void printBoard(){
		String formattedBoard = "\n";
		for (int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				formattedBoard = String.format("%s\t%s", formattedBoard, board[i][j]);
			}
			formattedBoard = String.format("%s\n", formattedBoard);
		}
		System.out.print(formattedBoard);
	}
	public static void play(int player){
		boolean invalidInput;
		System.out.print("\nPlayer " + player + ", enter your move!");
		do {
			invalidInput = true;

			System.out.print("\nRow: ");
			int row = input.nextInt();

			System.out.print("Column: ");
			int column = input.nextInt();
			
			if ((row < 1) || (row > rows))
				System.out.println("Invalid input for row.");
			else if ((column < 1) || (column > columns))
				System.out.println("Invalid input for column.");
			else if (!board[row-1][column-1].equals("-"))
				System.out.println("Spot unavailable");
			else {
				if (player == 1)
					board[row-1][column-1] = "X";
				else
					board[row-1][column-1] = "O";
				invalidInput = false;
			}
		} while (invalidInput);
	}
	// Returns true if there is a winning row, column or diagonal after a player's move
	public static boolean won(){
		// Two ways of winning diagonally
		boolean firstWinningDiagonal = true;
		boolean secondWinningDiagonal = true;

		// Instead of finding a winning row or column separately
		// the following implementation finds them simultaneously
	    for(int i = 0; i < rows; i++){
	        boolean winningColumn = true;
	        boolean winningRow = true;
	        for(int j = 0; j < rows-1; j++){
	        	// Checks if both previous and next square are the same in a single row
	            if (winningRow && !board[i][j].equals("-"))
	            	winningRow = board[i][j].equals(board[i][j+1]);
	            else
	            	winningRow = false;
	            
	            // Checks if both previous and next square are the same in a single column	            
	            if (winningColumn && !board[j][i].equals("-"))
	            	winningColumn = board[j][i].equals(board[j+1][i]);
	            else
	            	winningColumn = false;
	        }
	        
	        if (winningRow || winningColumn){
	            return true;
	        }
	        
	        // Implementation for diagonals is similar to columns and rows
	        if (i < (rows-1)){
	        	if (firstWinningDiagonal){
		        	if (board[i][i].equals(board[i+1][i+1]) && !board[i][i].equals("-"))
		        		firstWinningDiagonal = true;
		        	else 
		        		firstWinningDiagonal = false;
	        	}
	        
		        if (secondWinningDiagonal){
		        	if (board[i][(rows-1)-i].equals(board[i+1][(rows-2)-i]) && !board[i][(rows-1)-i].equals("-"))
		        		secondWinningDiagonal = true;
		        	else 
		        		secondWinningDiagonal = false;
		        }
	        }
	    }
	    
	    if (firstWinningDiagonal || secondWinningDiagonal)
	    	return true;
	    else
	    	return false;
	}
}
