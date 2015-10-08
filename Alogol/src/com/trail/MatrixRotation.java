package com.trail;

import java.util.Scanner;

public class MatrixRotation {

	public static void main(String[] args) {
	  
		int inputSize = 0; int count = 1;
		Scanner inputRead = new Scanner(System.in);
		
		
			inputSize = inputRead.nextInt();
		inputRead.close();

		int[][] inputArray = new int[inputSize][inputSize+1];
		System.out.println(inputArray.length);
		System.out.println(inputArray[0].length);
		for(int i = 0;i<inputSize;i++){
			for(int j=0;j<inputSize;j++){
				inputArray[i][j] = count;
				count++;
			}
		}
		//printArray(inputArray, inputSize);
		
		int start = 0; int i=0; int prev = 0; int next = 0;
		for(i=inputSize,start=0;i>1;i-=2,start+=1){
			 int rotationCount = 1;
	    while(rotationCount++<= i-1 ){
			prev = inputArray[start][start];
			
		for(int j = start+1;j<(i+start);j++){
			  // left to right	
				next = inputArray[start][j];
				inputArray[start][j] = prev;
				prev = next;
			}
		  // printArray(inputArray, inputSize);
		
			for(int j= start+1;j<(i+start);j++){
			  // right to down
				next = inputArray[j][i+start-1];
				inputArray[j][i+start-1] = prev;
				prev = next;
			}
			
			//printArray(inputArray, inputSize);	
			
			for(int j= (i+start-2);j>=start;j-- ){
				// right to left
				next = inputArray[i+start-1][j];
				inputArray[i+start-1][j]=prev;
				prev = next; 				
			}
			
			//printArray(inputArray, inputSize);
			
			for(int j=(i+start-2);j>=start;j--){
				//down to up
				next = inputArray[j][start];
				inputArray[j][start] = prev;
				prev = next;				
			}
			//printArray(inputArray, inputSize);
		}
		
		//printArray(inputArray,inputSize);
		}
//		for(int k = 0; k<inputSize; k++){
//			for(int j = 0;j<inputSize; j++){
//				System.out.print(inputArray[k][j]);
//				System.out.print("\t");
//			}
//			System.out.print("\n");
		
		printArray(inputArray,inputSize);
	

	
}

private static void  printArray(int[][] inputArray,int inputSize){
	
	for(int k = 0; k<inputSize; k++){
		for(int j = 0;j<inputSize; j++){
			System.out.print(inputArray[k][j]);
			System.out.print("\t");
		}
		System.out.print("\n");
	}
	
	System.out.println("");
}
}
