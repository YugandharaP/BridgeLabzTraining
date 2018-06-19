package com.bridgelabz.dataStructure;
/**purpose: To implement Queue using linked list. queue follows  FIFO(first In first Out) structure.
 *@author Yuga
 *@since   25-05-2018
 */
public class MyQueue <T>{
	
	private static Node front;
	private static Node rear;
	private static int count;
	
    /**check the Queue list is null or not
     */
    public static <T>boolean isEmpty()
    {
    	return count==0;
    }
	
	/**To add element in Queue list at rear
	 */
	public static <T>void enqueue(T element)
	{
		if(isEmpty())
		{
			front=new Node(element);
			rear=front;
			count++;
			return;
		}
		rear.next=new Node(element);
		rear=rear.next;
		count++;
		//MyLinkedList.addElement(element);
	}
	/**It retuns size of the queue list
	 */
	public static Integer size() {
	
		return count;
	}
	/**to remove the the elements in FIFO manner
	 * @return element
	 */
	public static<T> T dequeue() {
		if(isEmpty())
		{
			System.out.println("queue is empty!");
		}
		T temp=(T) front.element;
		front=front.next;
		count--;
		return temp;
	}
	
	/**
	 * This function is used to search element
	 */
	public static <T> boolean searchElement(T element) {

		if (front.element.equals(element)) {
			return true;
		}
		Node node = front;
		while (node != null) {
			if (node.element.equals(element))
				return true;
			node = node.next;
		}
		return false;
	}
	
	/**
	 * To display Queue elements
	 */
	public static <T> void display() {
		if(isEmpty())
		{
			System.out.println("List is empty!");
			return;
		}
		Node temp=front;
		for(int i=0;i<size();i++)
		{
			System.out.println("element: " +temp.element);
			temp=temp.next;
		}
	}
	
	
	
	public boolean search(T searchElement)
	{
		Node<T> temp=front;
		for(int i=0;i<size();i++)
		{
			if(temp.element.equals(searchElement))
			{
				return true;
			}
			temp=temp.next;
		}
		return false;
	}

	/*public char[] pop(int i) {
		
		if(isEmpty())
		{
			System.out.println("queue is empty!");
		}
		T temp=(T) front.element;
		front=front.next;
		count--;
		return temp;
	}*/

}
