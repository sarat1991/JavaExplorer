package com.prep;

public class BinaryTree {

	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public void addLeft(Node currentNode, Node newNode){
			
			currentNode.left = newNode;
			
			
		}
		
		public void addRight(Node currentNode, Node newNode){
			currentNode.right = newNode;
		}
	}
	
	Node head;
	
 
}
