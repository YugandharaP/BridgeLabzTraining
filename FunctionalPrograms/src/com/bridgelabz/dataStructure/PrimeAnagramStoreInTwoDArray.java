package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramStoreInTwoDArray {
	public static void main(String[] args) {
		MyLinkedList<Integer> mylinkedlist = new MyLinkedList<Integer>();
		MyQueue anagram = new MyQueue();
		MyQueue nonAnagram = new MyQueue();
		for (int i = 0; i <= 1000; i++) {
			if (Utility.isPrime(i)) {
				mylinkedlist.addElement(i);
			}
		}
		for (int i = 0; i < mylinkedlist.size() - 1; i++) {
			for (int j = i + 1; j < mylinkedlist.size(); j++) {
				if (Utility.numAnagramCheck(mylinkedlist.get(i), mylinkedlist.get(j))) 
				{
					if (anagram.search(mylinkedlist.get(i)) == false) {
						anagram.enqueue(mylinkedlist.get(i));
					}
					if (anagram.search(mylinkedlist.get(j)) == false) {
						anagram.enqueue(mylinkedlist.get(j));
					}
				} else {
					if (anagram.search(mylinkedlist.get(i)) == false
							&& nonAnagram.search(mylinkedlist.get(i)) == false) {
						nonAnagram.enqueue(mylinkedlist.get(i));
					}
					if (anagram.search(mylinkedlist.get(j)) == false
							&& nonAnagram.search(mylinkedlist.get(j)) == false) {
						nonAnagram.enqueue(mylinkedlist.get(j));
					}
					
				}
			}
		}
		
		System.out.println(nonAnagram.size());
		Integer[][] array = new Integer[2][nonAnagram.size()];
		int anagramQueueSize = anagram.size();
		
		for (int i = 0; i < anagramQueueSize; i++) {
			array[0][i] = anagram.dequeue();
		}
		int nonAnagramQueueSize = nonAnagram.size();
		
		for (int j = 0; j < nonAnagramQueueSize; j++) {
			array[1][j] = nonAnagram.dequeue();
		}
		System.out.println();
		System.out.println("Array elements are:");
		System.out.println("first row shows anagram numbers and second row shows non anagram numbers");
		Utility.printTwoDArray(array);
	}
}