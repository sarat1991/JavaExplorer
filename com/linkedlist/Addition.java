package com.linkedlist;

import java.io.InputStream;
import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		
		Scanner inputBuffer = new Scanner(System.in);
		Scanner inputString1 = new Scanner(inputBuffer.nextLine());
		inputString1.useDelimiter(",");
		Scanner inputString2 = new Scanner(inputBuffer.nextLine());
		inputString2.useDelimiter(",");
		SinglyLinkedList inputlist1 = new SinglyLinkedList();
		
		while(inputString1.hasNext()){
			inputlist1.add(Integer.parseInt(inputString1.next()));
		}
		
		SinglyLinkedList inputlist2 = new SinglyLinkedList();
		while(inputString2.hasNext()){
			inputlist2.add(Integer.parseInt(inputString2.next()));
		}
		
		int string1Length = checkLength(inputlist1);
		int string2Length = checkLength(inputlist2);
		
		
		
		if(string1Length<string2Length){
		 inputlist1.head = addZeros(inputlist1.head,(string2Length - string1Length));	
		}else if(string1Length>string2Length){
			inputlist2.head = addZeros(inputlist2.head,(string1Length -string2Length));
		}
			
		
		Addition.PartialSum tempData = new Addition.PartialSum(0,0);		
	   
		Node answerWithoutCarry = add(inputlist1.head, inputlist2.head, tempData);
		
		Node runner = answerWithoutCarry;
		Node answer = null;
		if(tempData.carry != 0){
			answer = new Node(answerWithoutCarry,tempData.carry);
			runner = answer;
		}
				
		while(runner!=null){
			System.out.print(runner.data);
			if(runner.next!=null)
				System.out.print("->");
			runner = runner.next;
		}
		
	}
	
	 

	private static Node addZeros(Node head, int i) {
		while(i!=0){
			Node temp = new Node(head,0);
			head = temp;
			i--;
		}
		return head;
	}



	private static int checkLength(SinglyLinkedList inputlist1) {
		int count = 0;
		Node runner = inputlist1.head;
		while(runner!=null)
		{
			count++;
			runner=runner.next;
		}
		
		return count;
	}

	static class PartialSum{
		int sum;
		int carry;
		
		public PartialSum(int sum, int carry){
			this.sum = sum;
			this.carry = carry;
		}
	}
	
	static Node add(Node input1, Node input2, PartialSum tempData){
		
		Node last = null;
		if(input1.next!= null)			
			last = add(input1.next,input2.next, tempData);
			
		tempData.sum = (Integer)input1.data + (Integer)input2.data + tempData.carry;
		
		tempData.carry = tempData.sum/10;
		
		Node temp = new Node(last,(tempData.sum)%10);
		
		return temp;
	}
	
}
