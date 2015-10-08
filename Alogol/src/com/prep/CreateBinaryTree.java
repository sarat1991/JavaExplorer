package com.prep;

public class CreateBinaryTree {

	public static void main(String[] args) {
		/*
		 *  2 3 4 9 8 10 7
		 * 
		 */
		
		BinaryTree bt = new BinaryTree();
		
		BinaryTree.Node prev ;
		for(int i=0;i<args.length;i++ ){
			
			BinaryTree.Node n = bt.new Node(Integer.parseInt(args[i]));
			if(bt.head == null){
				bt.head = n;
				prev = n;
			}
			
			else if(i%2 == 0)
			{
				
				
			}
			else {
				
			}
		}

	}

}
