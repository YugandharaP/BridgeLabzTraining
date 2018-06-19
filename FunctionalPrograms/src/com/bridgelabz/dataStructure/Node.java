package com.bridgelabz.dataStructure;

/**To initialize node type of custructor which will be use in linked list,queue,deque, stack list
 * @author yuga
 */
public class Node <N> {
	Node next;
	N element;
	Node(N element)
	{
		this.element=element;
	}
	Node(N element,Node next)
	{
		this.element=element;
		this.next=next;
	}

}
