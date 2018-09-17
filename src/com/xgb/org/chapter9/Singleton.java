package com.xgb.org.chapter9;

public class Singleton {
	
	//2
	private static Singleton instance = new Singleton(); 
		
	//1
	private static int x = 0;
	
	private static int y;
	
	
	
	private Singleton() {
		x++;
		y++;
	}

	private static Singleton getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		
		System.err.println(singleton.x);
		System.err.println(singleton.y);
	}
}
