package com.xgb.org.chapter8.threadInterface;

//�����̵߳Ĺ���
public interface ThreadFactory {
	
	Thread createThread(Runnable runnable);
}
