//package com.xgb.org.chapter8.threadImpls;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.concurrent.TimeUnit;
//
//import com.xgb.org.chapter8.threadInterface.DenyPolicy;
//import com.xgb.org.chapter8.threadInterface.RunnableQueue;
//import com.xgb.org.chapter8.threadInterface.ThreadFactory;
//import com.xgb.org.chapter8.threadInterface.ThreadPool;
//
///**
// * �̳߳���Ҫ�������Ŀ������ԡ������̹߳�����������в��Եȹ���
// * @author XuGongBin
// *
// */
//public class BasicThreadPool extends Thread implements ThreadPool{
//	
//	//��ʼ���߳�����
//	private final int intSize;
//	
//	//�̳߳�����߳�����
//	private final int maxSize;
//	
//	//�̳߳غ�������
//	private final int coreSize;
//	
//	//��ǰ��Ծ���߳�����
//	private int activeCount;
//	
//	//�����̳߳ص���������
//	private final ThreadFactory threadFactory;
//	
//	//�������
//	private final RunnableQueue runnableQueue;
//	
//	//�̳߳��Ƿ��Ѿ���shutdown
//	private volatile boolean isShutdown = false;
//	
//	private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
//	
//	private final static DenyPolicy DEFAUT_DENY_POLICY = new DenyPolicy().discardDenyPolicy();
//	
//	private final static ThreadFactory DEFAUT_THRAD_FACTORY = new DefaultTreadFactory();
//	
//	private final long keepAliveTime;
//	
//	private final TimeUnit timeUnit;
//
//	@Override
//	public void execute(Runnable runnable) {
//		
//		
//	}
//
//	@Override
//	public void shuotdown() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int getInitSize() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getMaxSize() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getCoreSize() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getQueueSize() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getActiveCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean isShutdown() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
