package com.xgb.org.chapter10;


public class ExtClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("Bootstrap£º" + String.class.getClassLoader());
		String path = System.getProperty("sun.boot.class.path");
		System.out.println(path);
		
		System.out.println(System.getProperty("java.ext.dirs"));
		
		Class<?> personClass = Class.forName("com.xgb.org.jar.Person");
		System.out.println(personClass.getClassLoader());
		
		//sun.misc.Launcher$AppClassLoader@6d06d69c
		
		System.out.println(System.getProperty("java.class.path"));
		//System.out.println(AppClassLoader.class.getClassLoader());
		
	}

}
