package com.xgb.org.chapter23;

import java.util.concurrent.TimeUnit;

/**
* 一个无限等待的抽象类Latch
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月13日 上午8:07:03
*/
public abstract class Latch {

	//同于控制多个线程完成任务时才能开启阀门
	protected int limit;
	
	public Latch(int limit)
	{
		this.limit = limit;
	}
	
	//该方法使得当前线程一直等待，直到所有的线程都完成工作，有阻塞的线程是允许被中断的
	public abstract void await() throws InterruptedException;
	
	//增加可超时的抽象方法
	public abstract void await(TimeUnit unti,long time) throws InterruptedException ,WaitTimeOutException;
	
	//当任务线程完成工作之后调用该方法使得计数器减一
	public abstract void countDown();
	
	//获取当前还有多少哥线程没有完成任务
	public abstract int getUnarrived();
	
	
	
}
