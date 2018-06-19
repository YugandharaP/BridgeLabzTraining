package com.bridgelabz.dataStructure;

/**purpose: To implement Dequeue using linked list. Dequeue means we can add and remove
 * both(front and rear) sides of linked list
 * @author Yuga
 *@since   25-05-2018
 */
public class MyDeque<T> {
	private static Node front;
	private static Node rear;
	private static int count;

	/**
	 * check the Queue list is null or not
	 * @return boolean value
	 */
	public static boolean isEmpty() {
		return count == 0;
	}

	/**
	 * To add element in DeQueue list at front
	 */
	public static <T> void addFront(T element) {
		if (isEmpty()) {
			front = new Node(element);
			rear = front;
			count++;
			return;
		}
		Node current = front;
		front = new Node(element);
		front.next = current;
		count++;
	}

	/**
	 * this function add the element from rear side
	 */
	public static <T> void addRaer(T element) {
		if (isEmpty()) {
			front = new Node(element);
			rear = front;
			count++;
			return;
		}
		Node current = rear;
		rear = new Node(element);
		current.next = rear;
		count++;
	}

	/**
	 * This function remove the element from front side
	 */
	public static <T> T removeFront() {
		if (isEmpty()) {
			System.out.println("queue is empty!");
		}
		T temp = (T) front.element;
		front = front.next;
		count--;
		return temp;
	}

	/**
	 * this will remove the element from rear side
	 */
	public static <T> T removeRaer() {
		if (isEmpty()) {
			System.out.println("queue is empty!");
			return null;
		} else {
			Node current = front;
			Node previous = null;
			while (current.next != null) {
				previous = current;
				current = current.next;
			}
			T temp = (T) current.element;
			previous.next = null;
			count--;
			return temp;
		}

	}

	/**
	 * To display the DeQueue list elements
	 */
	public static <T> void display() {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return;
		}
		Node temp = front;
		for (int i = 0; i < size(); i++) {
			System.out.println("elements are: " + temp.element);
			temp = temp.next;
		}
	}
	/**
	 * It returns size of dequeue list
	 */
	public static <T> Integer size() {
		return count;
	}
}
