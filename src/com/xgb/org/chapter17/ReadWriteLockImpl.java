package com.xgb.org.chapter17;
/**
* 类说明
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:46:34
*/
public class ReadWriteLockImpl implements ReadWriteLock {
	
	//定义对象锁
	private final Object MUTEX = new Object();
	
	//当前有多少个线程正在写入
	private int writingWriters = 0;
	
	//当前有多少个线程正在等待
	private int waitingWriters = 0;
	
	//当前有多少个读的线程
	private int readingReaders = 0;
	
	//read和write的偏好设置
	private boolean preferWriter;
	
	//默认情况下preferWriter为 true
	public ReadWriteLockImpl()
	{
		this(true);
	}
	public ReadWriteLockImpl(boolean preferWriter)
	{
		this.preferWriter = preferWriter;
	}
	
	
	@Override
	//创建read lock
	public Lock readLock() {
		return new ReadLock(this);
	}

	@Override
	public Lock writeLock() {
		return new WriteLock(this);
	}
	
	//使写的线程数量增加
	void incrementWritingWriters() 
	{
		this.writingWriters++;
	}

	//使等待的线程增加
	void incrementWaitingWriters()
	{
		this.waitingWriters++;
	}
	
	//使读线程数量增加
	void incrementReadingReaders() 
	{
		this.readingReaders++;
	}
	
	//使写的线程数量减少
	void decrementWritingWriters() 
	{
		this.writingWriters--;
	}
	
	//使等待的线程数量减少
	void decrementWaitingWriters() 
	{
		this.waitingWriters--;
	}
	
	//使读的线程数量减少
	void decrementReadingReaders() 
	{
		this.readingReaders--;
	}
	
	//获取当前有多少个线程正在进行写的操作
	public int getWritingReaders() 
	{
		return this.writingWriters;
	}
	
	@Override
	public int getWaitingWriters() 
	{
		return this.writingWriters;
	}

	@Override
	public int getReadingReader() 
	{
		return this.readingReaders;
	}
	
	
	
	/**
	 * 获取对象锁
	 * @return
	 */
	Object getMutex()
	{
		return this.MUTEX;
	}
	
	//获取当前是否偏向写锁
	boolean getPreferWriter() 
	{
		return this.preferWriter;
	}
	
	//设置写锁偏好
	void changePrefer(boolean preferWriter) 
	{
		this.preferWriter = preferWriter;
	}

}
