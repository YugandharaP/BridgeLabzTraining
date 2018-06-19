package com.bridgelabz.dataStructure;

import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

import com.bridgelabz.utility.Utility;

public class BankingCashCounter {
	static int noOfPeople;
	static int input;
	static int amount;
	static int money;

	public static void main(String[] args) {
		System.out.println("Enter the maximum people stand in Queue : ");
		noOfPeople = Utility.reInteger();
		System.out.println("Enter initial Bank amount: ");
		amount = Utility.reInteger();
	
		for (int i = 0; i < noOfPeople; i++) {
			MyQueue.enqueue(i);
		}
		for (int i = 0; i < noOfPeople; i++) {
			System.out.println("What do you want to do? \n 1. Deposite\t 2. Withdraw");
			System.out.println("Press 1 for Deposite\nPress 2 for Withdraw");
			input = Utility.reInteger();
			switch (input) {
			case 1:
				System.out.println("Enter money to deposite: ");
				money = Utility.reInteger();
				amount += money;
				System.out.println("new bank balance is : " + amount);
				MyQueue.dequeue();
				break;
			case 2:
				System.out.println("Enter money to withdraw: ");
				money = Utility.reInteger();
				amount = isSufficientBalance(money);
				System.out.println("new bank balance is : " + amount);
				MyQueue.dequeue();
				break;
			default:
				System.out.println("choose currect option!");
			}
		}
	}
	public static int isSufficientBalance(int money1) {
		if (amount < money) {
			System.err.println("Insufficient_Balance");
			return amount;
		}
		return amount - money;
	}

}
