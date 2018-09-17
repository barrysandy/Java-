package com.xgb.org.chapter8.threadInterface;

/**
 * Runnable��һ��ʵ�֣���Ҫ�����̳߳��ڲ��������ʹ�õ�RunnableQueue��
 * Ȼ�󲻶ϵش�queue��ȡ��ĳ��runnable��������runnable��run����
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
		//�����ǰ����Ϊrunning��û���жϣ����佫���ϵش�queue�л�ȡrunnableȻ������run����
		while(running && !Thread.currentThread().isInterrupted()) {
			Runnable task = runnableQueue.take();
			task.run();
		}
	}
	
	//ֹͣ��ǰ������Ҫ�����̳߳ص�shutdown������ʹ��
	//һ�����̳߳����ٺ��߳�����ά����ʱ���ʹ�õ��÷���
	public void stop() {
		this.running = false;
	}

}
