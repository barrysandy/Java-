package org.xgb.com;

public class OTime {

	public static void main(String[] args) {
		int count = 0;
		int n = 8;
		for(int i = 1;i <= n ; i*= 2) {
			//System.err.println(" for i : " + i);
			count++;
		}
		
		//System.err.println("count : " + count);
		
		System.out.println(gcd(91,49));
	}
	
	public static int gcd(int a ,int b) {
		while(b != 0) {
			int temp = a % b;
			System.out.println(temp);
			a = b;
			b = temp;
		}
		return a;
	}

}
