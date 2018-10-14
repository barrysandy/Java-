package com.xgb.org.chapter23;

import java.util.concurrent.TimeUnit;

/**
* 无限等待CountDownLatch实现
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月13日 上午8:14:05
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
			//当limit>0时，当前线程进入阻塞状态
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
		//将time转换为纳秒
		long remainingNanos = unti.toNanos(time);
		//等待任务将在endNanos纳秒后超时
		final long endNanos = System.nanoTime() + remainingNanos;
		synchronized (this) 
		{
			//当limit>0时，当前线程进入阻塞状态
			while(limit > 0)
			{
				//如果超时就是抛出WaitTimeOutException
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
				
			//使limit减一，并通知阻塞线程
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
