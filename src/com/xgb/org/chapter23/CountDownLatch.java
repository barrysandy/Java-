package com.xgb.org.chapter23;

import java.util.concurrent.TimeUnit;

/**
* ���޵ȴ�CountDownLatchʵ��
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��13�� ����8:14:05
*/
public class CountDownLatch extends Latch{

	private Runnable runnable;
	
	public CountDownLatch(int limit ,Runnable runnable) 
	{
		super(limit);
		this.runnable = runnable;
	}
	
	@Override
	public void await() throws InterruptedException 
	{
		synchronized (this) 
		{
			//��limit>0ʱ����ǰ�߳̽�������״̬
			while(limit > 0)
			{
				this.wait();
			}
		}
		
	}
	
	@Override
	public void await(TimeUnit unti,long time) throws InterruptedException 
	{
		if(time <= 0)
			throw new IllegalArgumentException("The time is invalid.");
		//��timeת��Ϊ����
		long remainingNanos = unti.toNanos(time);
		//�ȴ�������endNanos�����ʱ
		final long endNanos = System.nanoTime() + remainingNanos;
		synchronized (this) 
		{
			//��limit>0ʱ����ǰ�߳̽�������״̬
			while(limit > 0)
			{
				//�����ʱ�����׳�WaitTimeOutException
				if (TimeUnit.NANOSECONDS.toMillis(remainingNanos) <= 0)
				{
					try 
					{
						throw new WaitTimeOutException("The wait time over specity time.");
					} catch (WaitTimeOutException e) 
					{
						e.printStackTrace();
					}
				}
				this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
					remainingNanos = endNanos - System.nanoTime();
			}
		}
		
		if(null != runnable)
		{
			runnable.run();
		}
		
	}
	
	@Override
	public void countDown() 
	{
		synchronized(this)
		{
			if(limit <= 0)
			{
				try 
				{
					throw new InterruptedException("all of task already arrived");
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
				
			//ʹlimit��һ����֪ͨ�����߳�
			limit--;
			this.notifyAll();
		}
	}
	
	@Override
	public int getUnarrived() 
	{
		return limit;
	}
}
