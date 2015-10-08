package com.linkedlist;

public class Node {

	Node next;
	Object data;
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setData(Object data) {
		this.data = data;
	}

	Node(Node next, Object data){
		this.next = next;
		this.data = data;
	}
	
	Object getData(){
		return this.data;
	}

}
