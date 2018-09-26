package com.xgb.org.chapter17;
/**
* 读锁接口
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:39:18
*/
public interface ReadWriteLock {
	
	//创建reader锁
	Lock readLock();
	
	//创建write锁
	Lock writeLock();
	
	//获取当前有多少个线程正在等待获取write锁
	int getWaitingWriters();
	
	//获取当前有多少个线程正在等待获取reader锁
	int getReadingReader();
	
	static ReadWriteLock readWriteLock()
	{
		return new ReadWriteLockImpl();
	}
	
	static ReadWriteLock readWriteLock(boolean preferWrite)
	{
		return new ReadWriteLockImpl(preferWrite);
	}
}
