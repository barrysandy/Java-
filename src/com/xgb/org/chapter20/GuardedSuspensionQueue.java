package com.xgb.org.chapter20;

import java.util.LinkedList;

/**
 * Guarded ������ͣ   Suspension ����
 * ���𡢵���ģʽ����ؼ��������ٽ�ֵ�������Ƿ����㣬���ﵽ���õ��ٽ�ֵʱ����߳���ᱻ����
 * @author 86581
 *
 */
public class GuardedSuspensionQueue {
	
	//������Integer���͵�queue
	private final LinkedList<Integer> queue = new LinkedList<>();
	
	//����queue���������Ϊ100
	private final int LIMIT = 100;
	
	//��queue�в������ݣ����queue�е�Ԫ�س�������������������������
	public void offer(Integer data) throws InterruptedException
	{
		synchronized (this) 
		{
			//�ж�queue�ĵ�ǰԪ���Ƿ񳬹���LIMIT
			while(queue.size() >= LIMIT) 
			{
				//����ǰ�̣߳�ʹ����������
				this.wait();
			}
			//����Ԫ�ز��һ���take�߳�
			queue.addLast(data);
			this.notifyAll();
		}
	}
	
	//�Ӷ����л�ȡԪ�أ�������д�ʱΪ�գ����ʹ��ǰ�߳�����
	public Integer take() throws InterruptedException
	{
		synchronized (this) 
		{
			//�ж϶���Ϊ��
			while(queue.isEmpty()) 
			{
				this.wait();
			}
			this.notifyAll();
			return queue.getFirst();
		}
	}
}
