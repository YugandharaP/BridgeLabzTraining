package com.bridgelabz.dataStructure;

/**purpose: To implement Singly linked list. linK list can create a node to store the data and a 
 * node having to parts one holds the data and another  one holds the address of the next element
 *@author Yuga
 *@since   24-05-2018
 */
public class MyLinkedList<T> {
	private static Node head;
	private static Node last;
	private static int count;

	/**
	 * check the linked list is null or not
	 */
	public static boolean isEmpty() {
		return count == 0;
	}
	/**
	 * To add element in linked list at last
	 */
	public static <T> void addElement(T element) {
		if (isEmpty()) {
			head = new Node(element);
			last = head;
			count++;
			return;
		}
		last.next = new Node(element);
		last = last.next;
		count++;
		
	}
	/**
	 * To add element in linked list in particular position
	 */
	public static <T> void addElementOnIndex(int index, T element) {
		/*if (index >= size())
			throw new IndexOutOfBoundsException("index not fount");*/
	 if (index == 0) {
			head = new Node(element, head);
			count++;
			return;
		}
		Node node = head;
		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		node.next = new Node(element, node.next);
		count++;
	}

	/** It retuns size of the linked list
	 */
	public static int size() {

		return count;
	}
	/**
	 * Fetch element from particular index
	 */
	public static <T> T getElement(int index) {
		if (index >= size())
			throw new IndexOutOfBoundsException("Index Not Found");
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return (T) node.element;
	}

	/**
	 * This function is used to search element
	 */
	public static <T> boolean searchElement(T element) {

		if (head.element.equals(element)) {
			return true;
		}
		Node node = head;
		while (node != null) {
			if (node.element.equals(element))
				return true;
			node = node.next;
		}
		return false;
	}

	/**
	 * This function used to remove element from particular index
	 */
	public static <T> void removeAt(int index) {
		if (index >= size())
			throw new IndexOutOfBoundsException("index not found");
		if (index == 0) {
			head = head.next;
			count--;
			return;
		}
		Node node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}
		node.next = (node.next).next;
		count--;
	}

	/**
	 * this function remove the element based on users demands
	 * 
	 * @param element
	 */
	public static <T extends Comparable<T>> void removeElement(T element) {
		if (head.element.equals(element)) {
			T temp = (T) head.element;
			head = head.next;
			count--;
		} else {
			Node node = head;
			Node previous = null;
			while (!node.element.equals(element)) {
				previous = node;
				node = node.next;
			}
			T temp = (T) node.element;
			previous.next = node.next;
			count--;
		}
	}

	/**
	 * This function pop the element from particular index and remove that element
	 * 
	 * @param index
	 *            which element to be pop
	 * @return the popped element
	 */
	public static <T> T popAtPosition(int index) {
		if (index >= size())
			throw new IndexOutOfBoundsException("index not found");
		if (index == 0) {
			T temp = (T) head.element;
			head = head.next;
			count--;
			return temp;
		}
		Node node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}
		T temp = (T) (node.next).element;
		node.next = (node.next).next;
		count--;
		return temp;
	}

	/**
	 * pop the last element and remove it
	 * 
	 * @return popped element
	 */
	public static <T> T pop() {
		Node node = head;
		Node previous = null;
		while (node.next != null) {
			previous = node;
			node = node.next;
		}
		T element = (T) node.element;
		previous.next = null;
		count--;
		return element;
	}
	/**
	 * display the elements from Linked List
	 */
	public static void display() {
		if (isEmpty()) {
			System.out.println("List is empty!");
			return;
		}
		for (int i = 0; i < size(); i++) {
			System.out.println("elements  at index " + i + ": " + getElement(i));
		}
	}
	
	public void display1() {
		if(isEmpty()) {
			System.out.println("empty");
			return;
		}
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(" "+temp.element+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	 public T get(int index)
	    {
	        if(index>=size())
	        {
	            throw new IndexOutOfBoundsException();
	        }
	        Node<T> temp=head;
	        for(int i=0;i<index;i++)
	        {
	            temp=temp.next;
	        }
	        return temp.element;
	    }
	 
	 
	 
}
