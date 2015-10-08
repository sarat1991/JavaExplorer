package com;

public class ObjectTesting {
	
	static Integer p = new Integer(0) ;
	final class Emp{
		final public int p = 0;
		
		
		
	}

	public static void main(String[] args) {
		
		
		String q = "sam";
		test(p);
		Emp e =  (new ObjectTesting()).new Emp();
		e.set(0);
		System.out.println(p);
		test123(e);
		System.out.println(e.get());
	}
	
	static void test(Integer we){
		
		if(we == p)
			System.out.println("same while passing");
		we  = 10;
		if(p == we )
			System.out.println("different after assigning");
	}

	static void test123(Emp e){
		e.set(10);
	}
}
