package com.xgb.org.chapter8.threadImpls;

import java.util.LinkedList;

import com.xgb.org.chapter8.threadInterface.DenyPolicy;
import com.xgb.org.chapter8.threadInterface.RunnableQueue;
import com.xgb.org.chapter8.threadInterface.ThreadPool;

public class LinkedRunnableQueue implements RunnableQueue {
	
	//������е�����������ڹ���ʱ����
	private final int limit;
	
	//����������������Ѿ����ˣ�����Ҫִ�оܾ�����
	private final DenyPolicy denyPolicy;
	
	//�������Ķ���
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
				//�޷������µ�����ʱִ�оܾ�����
				denyPolicy.reject(runnable, threadPool);
			}else {
				//��������뵽����β�������������е��߳�
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
					//������������û�п�ִ�е�������ǰ�̻߳���𣬽���runnableList������minor waitset�еȴ����ѣ��µ�������룩
					runnableList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//���������ͷ�����һ������
			return runnableList.removeFirst();
		}
	}

	@Override
	public int size() {
		synchronized(runnableList) {
			//���ص�ǰ��������е�������
			return runnableList.size();
		}
	}

}
