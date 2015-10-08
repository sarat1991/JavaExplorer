package com.linkedlist;


public class SinglyLinkedList {

	   Node head ;
	   
	   public SinglyLinkedList() {
		super();
	}

	void add(Object data){
		  if(head == null){
			  head = new Node(null, data);
		  }
		  else {
			  Node temp = head;
			  
			  while(temp.next != null){
				  temp = temp.next;
			  }
			
			  temp.next = new Node(null,data);			  			  
		  }
	

	}

	   void print(){
		   Node temp = head;
		   while(temp != null){
			   System.out.print(temp.data);
			   System.out.print("->");
			   temp = temp.next;
		   }
	   }
}
