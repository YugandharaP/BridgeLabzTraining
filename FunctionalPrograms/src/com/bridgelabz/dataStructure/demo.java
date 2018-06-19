package com.bridgelabz.dataStructure;

public class demo {
public static <T> void main(String[] args) {
	/*
	MyStack stack=new MyStack<>();
	//stack.displayStack();
	//T option=stack.pop();
	//System.out.println(option);
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	stack.displayStack();
	System.out.println("***");
	T ans=stack.pop();
	System.out.println(ans+"pop elemenet");
	stack.displayStack();
	System.out.println(stack.size());
	T res=stack.peak();
	System.out.println(res);
	*/
	
	//System.out.println("size: "+stack.size());
	/*MyLinkedList list=new MyLinkedList();
	list.addElement(10);
	list.addElement(30);
	list.addElement(40);
	list.addElement(50);
	list.addElement(60);
	
	list.display();
	list.addElementOnIndex(3, 70);
	list.display();
	//System.out.println("search elemnt "+ list.searchElement(30));
	//list.removeElement(50);
	System.out.println("************");
	//list.display();
	//System.out.println("pop elemnt"+list.pop());
	
	//System.out.println("pop at index at 2"+list.popAtPosition(2));
	list.display();
	*/

	MyQueue.enqueue(10);
	MyQueue.enqueue(20);
	MyQueue.enqueue(30);
	MyQueue.enqueue(40);
	MyQueue.enqueue(50);
	System.out.println("after add");
	MyQueue.display();
	//MyQueue.dequeue();
	System.out.println("after delete");
	MyQueue.display();


	/*MyDeque.addFront(20);
	MyDeque.addFront(10);
	MyDeque.display();
	System.out.println("***addFront complete****");
	MyDeque.addRaer(30);
	MyDeque.addRaer(40);
	MyDeque.display();
	System.out.println("***addRaer complete****");
	T ele=MyDeque.removeFront();
	System.out.println(ele);
	MyDeque.display();
	System.out.println("***removeFront complete****");
	
	T eleR=MyDeque.removeRaer();
	System.out.println(eleR);
	MyDeque.display();
	System.out.println("***removeRear complete****");*/
}


}
