package com.xgb.org.chapter20;

import java.util.LinkedList;

/**
 * Guarded 挂起、暂停   Suspension 担保
 * 挂起、担保模式，其关键点在于临界值的条件是否满足，当达到设置的临界值时相关线程则会被挂起
 * @author 86581
 *
 */
public class GuardedSuspensionQueue {
	
	//定义存放Integer类型的queue
	private final LinkedList<Integer> queue = new LinkedList<>();
	
	//定义queue的最大容量为100
	private final int LIMIT = 100;
	
	//往queue中插入数据，如果queue中的元素超过了最大容量，则会陷入阻塞
	public void offer(Integer data) throws InterruptedException
	{
		synchronized (this) 
		{
			//判断queue的当前元素是否超过了LIMIT
			while(queue.size() >= LIMIT) 
			{
				//挂起当前线程，使其陷入阻塞
				this.wait();
			}
			//插入元素并且唤醒take线程
			queue.addLast(data);
			this.notifyAll();
		}
	}
	
	//从队列中获取元素，如果队列此时为空，则会使当前线程阻塞
	public Integer take() throws InterruptedException
	{
		synchronized (this) 
		{
			//判断队列为空
			while(queue.isEmpty()) 
			{
				this.wait();
			}
			this.notifyAll();
			return queue.getFirst();
		}
	}
}
