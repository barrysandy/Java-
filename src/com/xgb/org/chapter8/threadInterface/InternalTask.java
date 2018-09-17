package com.xgb.org.chapter8.threadInterface;

/**
 * Runnable的一个实现，主要用于线程池内部，该类会使用到RunnableQueue，
 * 然后不断地从queue中取出某个runnable，并运行runnable的run方法
 * @author XuGongBin
 *
 */
public class InternalTask implements Runnable{
	
	private final RunnableQueue runnableQueue;
	
	private volatile boolean running = true;

	public InternalTask(RunnableQueue runnableQueue) {
		this.runnableQueue = runnableQueue;
	}
	
	@Override
	public void run() {
		//如果当前任务为running并没有中断，则其将不断地从queue中获取runnable然后运行run方法
		while(running && !Thread.currentThread().isInterrupted()) {
			Runnable task = runnableQueue.take();
			task.run();
		}
	}
	
	//停止当前任务，主要会在线程池的shutdown方法中使用
	//一般在线程池销毁和线程数量维护的时候会使用到该方法
	public void stop() {
		this.running = false;
	}

}
