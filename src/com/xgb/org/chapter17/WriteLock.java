package com.xgb.org.chapter17;
/**
* 类说明
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
				while(readWriteLock.getReadingReader() > 0 || readWriteLock.getWritingReaders() > 0)  
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
			
		}

	}

}
