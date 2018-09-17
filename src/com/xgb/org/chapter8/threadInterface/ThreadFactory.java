package com.xgb.org.chapter8.threadInterface;

//创建线程的工厂
public interface ThreadFactory {
	
	Thread createThread(Runnable runnable);
}
