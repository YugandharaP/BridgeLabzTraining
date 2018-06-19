/*****************************************************************************************************
 * purpose-To write program for playing TicTacToe game
 * @author Yuga
 * @version 1.0
 * @since   18-05-2018
 ****************************************************************************************************/
package com.bridgelabz.functionalprograms;

import java.util.ArrayList;
import java.util.Random;

import com.bridgelabz.utility.Utility;

/**To write program for playing TicTacToe game
 * @author yuga
 */
public class TicTacToe {

	/**
	 * this function to initialize board
	 * 
	 * @param array
	 *            of board of char type
	 * @return board
	 */
	public static char[] initializeBoard(char[] board) {
		for (int i = 0; i < 9; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/**
	 * this function to print board
	 */
	private static void printBoard(char[] board) {

		System.out.println();
		for (int i = 0; i < 9; i++) {
			int count = 0;
			for (int j = i; j < 9; j++) {
				count++;
				i = j;
				System.out.print("| " + board[i] + " |");

				if (count > 2)
					break;
			}
			System.out.println();
		}
	}

	/**
	 * this function for users turn
	 */
	public static void myTurn(char[] board) {
		ArrayList<Integer> cell = new ArrayList<Integer>();
		System.out.println("Fill your position");
		for (int i = 0; i < 9; i++) {
			if (board[i] == ' ') {
				cell.add(i);
			}
		}
		System.out.println("place you can enter: ");
		for (Integer pos : cell) {
			System.out.print(pos + " ");
		}
		System.out.println();
		System.out.println("enter your position to add 'X' :");
		int position = Utility.reInteger();
		if (board[position] == ' ' && board[position] != 'X') {
			board[position] = 'X';
			if (checkForWin(board)) {
				printBoard(board);
				System.out.println("Congratulations...!!You Win the Match");
				System.exit(0);
			} else if (occupiedPosition(board)) {
				System.out.println("Match Draw....");
			} else {
				printBoard(board);
				System.out.println("Computer's turn");
				computerTurn(board);
			}
		} else {
			System.out.println("Position already occupied!\nenter again");
			myTurn(board);
		}

	}

	/**
	 * this function for computer turn
	 */
	private static void computerTurn(char[] board) {
		Random rand = new Random();
		int position = rand.nextInt(8);

		if (board[position] == ' ' && board[position] != 'O') {
			board[position] = 'O';
			if (checkForWin(board)) {
				System.out.println(" Computer Win.....!!!");
				printBoard(board);
				return;
			} else if (occupiedPosition(board)) {
				System.out.println("Match Draw....");
			} else {
				printBoard(board);
				System.out.println("YOUR turn");
				myTurn(board);
			}
		} else {
			computerTurn(board);
		}
	}

	/**
	 * To check cell positions are occupied or not
	 */
	private static boolean occupiedPosition(char[] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == ' ')
				return false;
		}
		return true;
	}

	/**
	 * To check cells are equal or not either columnwise or rowwise or digonalwise
	 * depend upon parameters value
	 * 
	 * @param c,c1,c2
	 *            to take three character type parameters
	 */
	private static boolean checkEqual(char c, char c1, char c2) {
		return ((c != ' ') && (c == c1) && (c1 == c2));
	}

	/**
	 * To check weather win or not
	 */
	private static boolean checkForWin(char[] board) {
		if (checkRow(board) || checkColmn(board) || checkDiagonal(board) == true)
			return true;
		else
			return false;
	}

	/**
	 * To check equality of diagonal
	 */
	private static boolean checkDiagonal(char[] board) {
		if (checkEqual(board[0], board[5], board[8]) || checkEqual(board[3], board[5], board[6]))
			return true;
		else
			return false;
	}

	/**
	 * To check equality of column
	 */
	private static boolean checkColmn(char[] board) {
		if (checkEqual(board[0], board[3], board[6]) || checkEqual(board[1], board[4], board[7])
				|| checkEqual(board[2], board[5], board[8]))
			return true;
		else
			return false;
	}

	/**
	 * To check equality of row
	 */
	private static boolean checkRow(char[] board) {
		if (checkEqual(board[0], board[1], board[2]) || checkEqual(board[3], board[4], board[5])
				|| checkEqual(board[6], board[7], board[8]))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		char[] board = new char[9];
		initializeBoard(board);
		printBoard(board);
		if (Math.random() > 0.5)
			myTurn(board);
		else
			computerTurn(board);
	}

}
