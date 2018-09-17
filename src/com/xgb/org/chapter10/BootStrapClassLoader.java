package com.xgb.org.chapter10;

public class BootStrapClassLoader {
	
	public static void main(String[] args) {
		System.out.println("Bootstrap£º" + String.class.getClassLoader());
		System.out.println(System.getProperty("sun.boot.class.path"));
	}
}
