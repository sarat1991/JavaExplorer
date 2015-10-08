package com.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputOperation {

	public static void main(String[] args) {
		
		String currentLine;
		
/* BufferedReader example */		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			while((currentLine = br.readLine())!=null){
				System.out.println(currentLine);				
			}
			
		}catch(IOException io){
			io.printStackTrace();
		}
/* Scanner */
		
		Scanner sn = new Scanner(System.in);
		
		while(sn.hasNext()){
			Scanner tokeniser = new Scanner(sn.next());
			tokeniser.useDelimiter("->");
			
			while(tokeniser.hasNext()){
				
			}
			
		}

	}

}
