package com.xgb.org.chapter8.threadImpls;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import com.xgb.org.chapter8.threadInterface.DenyPolicy;
import com.xgb.org.chapter8.threadInterface.RunnableQueue;
import com.xgb.org.chapter8.threadInterface.ThreadFactory;
import com.xgb.org.chapter8.threadInterface.ThreadPool;

/**
 * 线程池需要有数量的快照属性、创建线程工厂、任务队列策略等功能
 * @author XuGongBin
 *
 */
public class BasicThreadPool extends Thread implements ThreadPool{
	
	//初始化线程数量
	private final int intSize;
	
	//线程池最大线程数量
	private final int maxSize;
	
	//线程池核心数量
	private final int coreSize;
	
	//当前活跃的线程数量
	private int activeCount;
	
	//创建线程池的所属工厂
	private final ThreadFactory threadFactory;
	
	//任务队列
	private final RunnableQueue runnableQueue;
	
	//线程池是否已经被shutdown
	private volatile boolean isShutdown = false;
	
	private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
	
	private final static DenyPolicy DEFAUT_DENY_POLICY = new DenyPolicy().discardDenyPolicy();
	
	private final static ThreadFactory DEFAUT_THRAD_FACTORY = new DefaultTreadFactory();
	
	private final long keepAliveTime;
	
	private final TimeUnit timeUnit;

	@Override
	public void execute(Runnable runnable) {
		
		
	}

	@Override
	public void shuotdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInitSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoreSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getQueueSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getActiveCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}

}
