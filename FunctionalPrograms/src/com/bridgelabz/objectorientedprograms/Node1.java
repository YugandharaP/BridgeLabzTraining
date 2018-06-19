package com.bridgelabz.objectorientedprograms;

import com.bridgelabz.dataStructure.Node;

public class Node1  <N> {
	Node1 next;
	N element;
	Node1(N element)
	{
		this.element=element;
	}
	Node1(N element,Node1 next)
	{
		this.element=element;
		this.next=next;
	}

}