package com.xgb.org.chapter8.threadInterface;

/**
 * 主要用于存放提交的Runnable
 * @author XuGongBin
 *
 */
public interface RunnableQueue {
	
	//当有新的任务进度来时首先会offer到队列中
	void offer(Runnable runnable);
	
	//工作线程通过take方法获取Runnable
	Runnable take();
	
	//获取任务队列中任务的数量
	int size();

}
