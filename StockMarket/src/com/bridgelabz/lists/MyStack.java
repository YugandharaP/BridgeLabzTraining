package com.bridgelabz.lists;

/**
 * purpose: To implement Stack using linked list. Stack follows LIFO(last in
 * first out) structure.
 * 
 * @author yuga
 * @since 26-05-2018
 */
public class MyStack<T> {
	private static Node top = null;
	private static Integer count = 0;

	/**
	 * check the stack list is null or not
	 * 
	 * @return boolean value
	 */
	public static boolean isEmpty() {
		return top == null;
	}

	/**
	 * this is push the elements in stack list
	 * 
	 * @param element
	 *            which to be push
	 */
	public static <T> void push(T element) {

		Node node = new Node(element);
		node.next = top;
		top = node;
		count++;
	}

	/**
	 * this function remove and return the element
	 * 
	 * @return pop elements
	 */
	public static <T> T pop() {
		if (isEmpty()) {

			System.out.println("Stack is Empty");

			return null;
		} else {
			T temp = (T) top.element;
			top = top.next;
			count--;
			return temp;
		}
	}

	/**
	 * This function return peak(last) element but don't remove
	 * 
	 * @return peak element
	 */
	public static <T> T peak() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		} else {
			return (T) top.element;
		}
	}

	/**
	 * to count the size of stack list
	 * 
	 * @return the size of stack list
	 */
	public static Integer size() {
		return count;
	}

	/**
	 * To display the elements in stack list
	 */
	public static <T> void displayStack() {
		if (isEmpty()) {
			System.err.println("No recent transactions");
			return;
		}
		Node temp = top;
		while (temp != null) {
			System.out.println("company name: " + temp.element);
			temp = temp.next;
		}
	}

}
