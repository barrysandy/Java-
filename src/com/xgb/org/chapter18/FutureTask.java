package com.xgb.org.chapter18;

public class FutureTask<T> implements Future<T> {
	
	//������
	private T result;
	
	//�����Ƿ����
	private boolean isDone = false;
	
	//���������
	private final Object LOCK = new Object();

	@Override
	public T get() throws InterruptedException {
		synchronized(LOCK) 
		{
			//������û���ʱ������get�����ᱻ�������������
			while(!isDone) 
			{
				LOCK.wait();
			}
		}
		//���ؼ�����
		return result;
	}
	
	//finish������Ҫ����ΪFutureTask���ü�����
	protected void finish(T result) 
	{
		synchronized (LOCK) 
		{
			//blacking���ģʽ
			if(isDone)
				return;
			//������ɣ�Ϊresultָ����������ҽ�isDone��Ϊtrue��ͬʱ���������е��߳�
			this.result = result;
			this.isDone = true;
			LOCK.notifyAll();
			
		}
	}

	@Override
	public boolean done() {
		return isDone;
	}

}
