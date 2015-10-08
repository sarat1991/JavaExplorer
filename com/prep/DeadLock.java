package com.prep;

public class DeadLock {

	String s1 = "Hello";
	String s2 ="World";
	
	Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			t1.setName("Thread 1");
			synchronized(s1){
				System.out.println(t1.getName()+" obtained s1 lock.");
				synchronized(s2){
					System.out.println(t1.getName()+" obtained s2 lock.");

					System.out.println(s1+s2);
				}
			}
			
		}
	});
	
	Thread t2 = new Thread(new Runnable(){

		@Override
		public void run() {
			t2.setName("Thread 2");
			synchronized(s2){
				System.out.println(t2.getName()+" obtained s2 lock.");
				synchronized(s1){

					System.out.println(s1+s2);
				}
			
		}
		}
		
	});
	
	
	public static void main(String[] args){
		
		DeadLock d = new DeadLock();
		d.t1.start();
		d.t2.start();
	}
	
	
}
