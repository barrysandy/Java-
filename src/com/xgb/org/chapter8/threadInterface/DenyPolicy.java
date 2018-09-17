package com.xgb.org.chapter8.threadInterface;

/**
 * �ܾ�����
 * @author XuGongBin
 *
 */
@FunctionalInterface
public interface DenyPolicy {
	
	//�ܾ�����
	void reject(Runnable runnable,ThreadPool threadPool);
	
	//�þܾ����Ի�ֱ�ӽ�������
	class DiscardDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			//do nothing
			
		}
		
	}
	
	//�þܾ����Ի��������ύ���׳��쳣
	class AbortDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			throw new RunnableDenyException("The Runnable " + runnable + " will abort." );
		}
		
	}
	
	
	//�þܾ����Ի�ʹ�������ύ�����ڵ��߳���ִ������
	class RunnableDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			if(!threadPool.isShutdown()) {
				runnable.run();
			}
			
		}
		
	}
	
	
}
