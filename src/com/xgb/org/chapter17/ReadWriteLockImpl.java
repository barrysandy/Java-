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
		return null;
	}

	@Override
	public Lock writeLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWaitingWriters() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReadingReader() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 获取对象锁
	 * @return
	 */
	Object getMutex()
	{
		return this.MUTEX;
	}

}
