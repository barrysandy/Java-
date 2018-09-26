package com.xgb.org.chapter17;
/**
* 类说明
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:53:06
*/
public class ReadLock implements Lock {
	
	private final ReadWriteLockImpl readWriteLock;
	
	ReadLock(ReadWriteLockImpl readWriteLock)
	{
		this.readWriteLock = readWriteLock;
	}

	@Override
	public void lock() throws InterruptedException {
		synchronized (readWriteLock.getMutex()) 
		{
			//若此时有线程正在进行写操作，或者有线程在等待并且偏好的标识为true时，就会无法获得该锁，只能被挂起
			while(readWriteLock.getWaitingWriters() > 0 || readWriteLock.getWaitingWriters() > 0)
			{
				readWriteLock.getMutex().wait();
			}
			//成功获得该锁，并且使用readingReaders的数量增加
			//readWriteLock.incrementReadingReaders();
		}

	}

	@Override
	public void unlock() {
		synchronized(readWriteLock.getMutex())
		{
			
		}

	}

}
