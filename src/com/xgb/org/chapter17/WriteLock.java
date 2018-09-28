package com.xgb.org.chapter17;
/**
* 写锁
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:53:06
*/
public class WriteLock implements Lock {
	
	private final ReadWriteLockImpl readWriteLock;
	
	WriteLock(ReadWriteLockImpl readWriteLock)
	{
		this.readWriteLock = readWriteLock;
	}

	@Override
	public void lock() throws InterruptedException {
		synchronized (readWriteLock.getMutex()) 
		{
			try {
				//首先使等待获取写入锁的数字加-
				readWriteLock.incrementWaitingWriters();
				//如果此时有其他线程正在进行读操作，或者写操作，那么当前线程将被挂起
				while(readWriteLock.getReadingReader() > 0 || readWriteLock.getWritingWriters() > 0)  
				{
					readWriteLock.getMutex().wait();
				}
			} finally {
				//成功获取到写入锁，使得等待获取写入锁的计数器减-
				this.readWriteLock.decrementWaitingWriters();
			}
			//将正在写入的线程数量加-
			readWriteLock.incrementWritingWriters();
		}

	}

	@Override
	public void unlock() {
		synchronized(readWriteLock.getMutex())
		{
			//减少正在写入锁的线程计数器
			readWriteLock.decrementWritingWriters();
			//将偏好状态修改为false，可以使得读锁被最快的获得
			readWriteLock.changePrefer(false);
			//通知唤醒其他在 Mutext monitor waitset中的线程
			readWriteLock.getMutex().notifyAll();
		}

	}

}
