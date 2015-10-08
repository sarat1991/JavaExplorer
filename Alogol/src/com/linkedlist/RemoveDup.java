package com.linkedlist;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDup {

	public static void main(String[] args) {
		

		Scanner inputRead = new Scanner(System.in);
		Scanner inputBuf = new Scanner(inputRead.next());
		inputBuf.useDelimiter(",");
		SinglyLinkedList input = new SinglyLinkedList();
		
		while(inputBuf.hasNext()){
		
			input.add(inputBuf.next());
		}
		
		HashMap<Object, Boolean> tempBuffer = new HashMap<>();
		Node prev = input.head;
		Node runner = input.head;
		while(runner.next!=null){
			 
			if(tempBuffer.containsKey(runner.getData())){
				prev.next = runner.next;
				runner = runner.next;
			}
			else{
				tempBuffer.put(runner.data,true);
				prev = runner;
				runner = runner.next;
			}			
			
		}
		
		input.print();
		
	}

}
