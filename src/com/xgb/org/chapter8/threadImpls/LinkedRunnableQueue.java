package com.xgb.org.chapter8.threadImpls;

import java.util.LinkedList;

import com.xgb.org.chapter8.threadInterface.DenyPolicy;
import com.xgb.org.chapter8.threadInterface.RunnableQueue;
import com.xgb.org.chapter8.threadInterface.ThreadPool;

public class LinkedRunnableQueue implements RunnableQueue {
	
	//任务队列的最大容量，在构造时传入
	private final int limit;
	
	//若任务队列中任务已经满了，则需要执行拒绝策略
	private final DenyPolicy denyPolicy;
	
	//存放任务的队列
	private final LinkedList<Runnable> runnableList = new LinkedList<>();

	private final ThreadPool threadPool;
	
	public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
		this.limit = limit;
		this.denyPolicy = denyPolicy;
		this.threadPool = threadPool;
	}

	@Override
	public void offer(Runnable runnable) {
		synchronized (runnableList) {
			if(runnableList.size() >= limit) {
				//无法容纳新的任务时执行拒绝策略
				denyPolicy.reject(runnable, threadPool);
			}else {
				//将任务加入到队列尾，并唤醒阻塞中的线程
				runnableList.addLast(runnable);
				runnableList.notifyAll();
			}
		}

	}

	@Override
	public Runnable take() {
		synchronized (runnableList) {
			while(runnableList.isEmpty()) {
				try {
					//如果任务队列中没有可执行的任务，则当前线程会挂起，进入runnableList关联的minor waitset中等待唤醒（新的任务加入）
					runnableList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//从任务队列头部溢出一个任务
			return runnableList.removeFirst();
		}
	}

	@Override
	public int size() {
		synchronized(runnableList) {
			//返回当前任务队列中的任务数
			return runnableList.size();
		}
	}

}
