package com.bridgelabz.objectorientedprograms;

import java.util.Random;

import com.bridgelabz.dataStructure.MyLinkedList;
import com.bridgelabz.utility.Utility;

/**purpose-Shuffle the cards using Random method and then distribute 9 Cards to 4 Players and Print the Cards the received by the 4 Players
using 2D Array
 *@author yuga
 *@version 1.0
 *@since   02-06-2018
 */
public class DeckOfCards {
	static String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	static MyLinkedList<String> cards = new MyLinkedList<String>();
	static String[][] players = new String[4][9];

	/**this function distribute the cards to the 4 players using random method
	 * @param cards
	 * @param players array
	 * @return player array
	 */
	@SuppressWarnings("static-access")
	public static String[][] cardsDistribution(MyLinkedList<String> cards, String[][] players) {
		int currentCardsNumber = 52;
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			players[0][i] = cards.popAtPosition(random.nextInt(currentCardsNumber--));
			players[1][i] = cards.popAtPosition(random.nextInt(currentCardsNumber--));
			players[2][i] = cards.popAtPosition(random.nextInt(currentCardsNumber--));
			players[3][i] = cards.popAtPosition(random.nextInt(currentCardsNumber--));
		}
		return players;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				cards.addElement(suit[i] + rank[j]);
			}
		}
		System.out.println("Enter number between [0-51] to suffle the cards: ");
		int number = Utility.reInteger();
		players = cardsDistribution(cards, players);
		System.out.println(
				"1st row cards for player1\t2nd row cards for player2\n3rd row cards for player3\t4th row cards for player4\n");
		Utility.printTwoDArray(players);
	}

}
