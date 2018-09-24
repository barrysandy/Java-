package com.xgb.org.chapter10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//ClassLoader extClassLoader = MyClassLoaderTest.class.getClassLoader().getParent();
		
		//ÉùÃ÷Ò»¸öClassLoader
		MyClassLoader classLoader = new MyClassLoader("G:\\classloader1" , null);
		
		Class<?> aClass = classLoader.loadClass("com.xgb.org.chapter10.HelloWorld");
		
		System.out.println(aClass);
		System.out.println(aClass.getClassLoader());
		
		//1×¢ÊÍ
		Object helloWorld = aClass.newInstance();
		System.out.println("helloWorld£º" + helloWorld);
		Method wellcomMethod = aClass.getMethod("welcome");
		String result = (String) wellcomMethod.invoke(wellcomMethod);
		System.err.println("Result: " + result);
		
//		MyClassLoader classLoader = new MyClassLoader("G:\\classloader1" , null);
//		
//		Class<?> aClass = classLoader.loadClass("com.xgb.org.chapter10.HelloWorld");
//		Class<?> bClass = classLoader.loadClass("com.xgb.org.chapter10.MyClassLoaderTest");
//		
//		System.err.println(aClass.hashCode());
//		System.err.println(bClass.hashCode());
//		System.err.println(aClass == bClass);
	}

}
