package com.xgb.org.chapter10;

import java.lang.reflect.InvocationTargetException;

public class NameSpace {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		
		ClassLoader classLoader = NameSpace.class.getClassLoader();
		
		Class<?> aClass = classLoader.loadClass("com.xgb.org.chapter10.HelloWorld");
		Class<?> bClass = classLoader.loadClass("com.xgb.org.chapter10.MyClassLoaderTest");
		
		System.err.println(aClass.hashCode());
		System.err.println(bClass.hashCode());
		System.err.println(aClass == bClass);
	}

}
