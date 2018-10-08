package com.xgb.org.chapter21;

public class ApplicationContext {
	
	private Integer configuration;
	
	private Integer runtimeinfor;
	
	private static Class Holder {
		
		private static ApplicationContext instance = new ApplicationContext();
		
	}
	
	public static ApplicationContext getContext() {
		return Holder.instance;
	}

}
