package com.trail;

public class TestCode {

	public static void main(String[] args) {
		
		float p = 0.75f;
		System.out.println(p);

		char[] value= new String("mas").toCharArray();
		
		int h = 0, f = 0;
		for (int i = 0; i < value.length; i++) {
			System.out.println("h: "+h+" value["+i+"]: "+(int)value[i]);
            h = 31 * h + value[i];
            f = f + value[i]*31^(value.length-i+1);
            
        }
		
		System.out.println(h);
		
		System.out.println(f);
	}

}
