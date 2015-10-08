package com.linkedlist;

import java.util.Scanner;

public class LinkedlistProg {

	private static Scanner eachNode;
	private static Scanner sn;

	public static void main(String[] args) {
		
		sn = new Scanner(System.in);
		while(sn.hasNext()){
			eachNode = new Scanner(sn.next());
			eachNode.useDelimiter("->");
			 SinglyLinkedList linkedlist1 = new SinglyLinkedList();
		     while(eachNode.hasNext()){
		    	 linkedlist1.add(eachNode.next());
		     }
			 linkedlist1.print();
		}

	}

}
