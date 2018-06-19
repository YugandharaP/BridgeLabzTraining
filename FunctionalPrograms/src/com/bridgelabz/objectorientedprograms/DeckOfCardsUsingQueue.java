/*package com.bridgelabz.objectorientedprograms;

import com.bridgelabz.dataStructure.MyQueue;
import com.bridgelabz.utility.Utility;

public class DeckOfCardsUsingQueue {
	static String[] SUIT = { "club", "diamond", "heart", "spades" };
	static String[] RANK = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };
	static String[][] players = new String[4][9];
	static int index = 0;

	public static void main(String[] args) {
		MyQueue[] cards = new MyQueue[52];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new MyQueue();
		}
		for (int i = 0; i < SUIT.length; i++) {
			for (int j = 0; j < RANK.length; j++) {
				cards[index++].enqueue(RANK[j] + " " + SUIT[i]);
			}
		}
		//String[][] player = Utility.shuffleCards(cards, SUIT.length, RANK.length);
		MyQueue[] queue = Utility.distribute(players);
		sortPlayer(queue);
	}

	

	public static void sortPlayer(MyQueue[] elements) {
		for (int i = 0; i < 4; i++) {
			System.out.println("** Person " + (i + 1) + " **");
			for (int j = 0; j < 9; j++) {
				System.out.println(elements[i].pop(0));
			}
			System.out.println();
		}
	}

	*//**
	 * @param player
	 * @return QueueUsingLinkedlist[]
	 *//*
	public static MyQueue[] distribute(String[][] player) {
		MyQueue[] elements = new MyQueue[52];
		for (int i = 0; i < 4; i++) {
			elements[i] = new MyQueue();
			for (int j = 0; j < 9; j++) {
				elements[i].addSort(player[i][j]);
			}
		}
		return elements;
	}

public void addSort(String data) {
        Node1 node1 = new Node1(data);
        Node1 current = null;
        if (front == null || ((Comparable<T>) front.data).compareTo((T) node1.data) > 0) {
            node1.next = front;
            front = node1;
            size++;
            // System.out.println(item + " added successfully");
            return;
        } else {
            current = front;
            rear = front;
            while (current.next != null && ((Comparable<T>) current.next.data).compareTo((T) node1.data) < 0) {
                current = current.next;
            }
            node1.next = current.next;
            current.next = node1;
            size++;
            // System.out.println(item + " added successfully");
            while (rear.next != null) {
                rear = rear.next;
            }
            return;
        }

	
	
}
*/