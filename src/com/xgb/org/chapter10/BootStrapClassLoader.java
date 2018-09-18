package com.xgb.org.chapter10;

public class BootStrapClassLoader {
	
	public static void main(String[] args) {
		System.out.println("Bootstrap£º" + String.class.getClassLoader());
		String path = System.getProperty("sun.boot.class.path");
		System.out.println(path);
	}
}
