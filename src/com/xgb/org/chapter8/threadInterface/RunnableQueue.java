package com.xgb.org.chapter8.threadInterface;

/**
 * ��Ҫ���ڴ���ύ��Runnable
 * @author XuGongBin
 *
 */
public interface RunnableQueue {
	
	//�����µ����������ʱ���Ȼ�offer��������
	void offer(Runnable runnable);
	
	//�����߳�ͨ��take������ȡRunnable
	Runnable take();
	
	//��ȡ������������������
	int size();

}
