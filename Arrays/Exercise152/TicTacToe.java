// nog niet klaar
import java.util.Scanner;

public class TicTacToe
{

	private static char[][] board = new char[3][3];

	public static void main( String[] args )
	{
    Scanner keyboard = new Scanner(System.in);
		int row, column;

		char currentPlayer = 'X';
		boolean won = false;
		boolean tie = false;

		initBoard();
		displayBoard2();
		System.out.print(currentPlayer + ", choose your location (row, column): ");
		row = keyboard.nextInt();
		column = keyboard.nextInt();
		board[row][column] = currentPlayer;

		while (!won || !tie) {
			if (currentPlayer == 'O')
			{
				currentPlayer = 'X';
			}
			else
			{
				currentPlayer = 'O';
			}

			displayBoard2();
			System.out.print(currentPlayer + ", choose your location (row, column): ");
			row = keyboard.nextInt();
			column = keyboard.nextInt();

			board[row][column] = currentPlayer;

			if (winGame('X'))
			{
				won = true;
			}
			else if (winGame('O'))
			{
				won = true;
			}

			won = checkWin();
		}

		System.out.println("\nEnd of game");

	}

	public static void initBoard()
	{
		// fills up the board with blanks
		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}


	public static void displayBoard()
	{
    System.out.println();
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + " |" + board[0][2]);
		System.out.println("    --+--+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + " |" + board[1][2]);
		System.out.println("    --+--+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + " |" + board[2][2]);
		System.out.println("     0 1 2 ");
  	System.out.println();
	}

	public static boolean checkWin()
	{
		System.out.println("checking winner...");
		boolean result = false;

		// horizontal
		for (int r = 0; r < 3; r++)
		{
			if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != ' ')
			{
				result = true;
			}
		}

		return result;
	}

	public static boolean winGame( char player )
	{
		boolean result = false;
		// check horizontal
		for ( int r = 0; r < 3; r++ )
		{
			if ( player == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2] )
				result = true;
		}

		// check vertical
		for ( int c = 0; c < 3; c++ )
		{
			if ( player == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c] )
				result = true;
		}

		// check diagonal
		if ( player == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2] )
				result = true;
		else if ( player == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0] )
				result = true;


		return result;
	}


	public static void displayBoard2()
	{
		System.out.println();
		System.out.println("\t  0 1 2 ");
		for ( int r=0; r<3; r++ )
		{
			System.out.print("\t"+r+" ");
			for ( int c=0; c<3; c++ )
			{
				System.out.print( board[r][c] + " " );
			}
			System.out.println();
		}
		System.out.println();
	}
}
