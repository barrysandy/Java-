package com.xgb.org.chapter17;
/**
* ��˵��
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:46:34
*/
public class ReadWriteLockImpl implements ReadWriteLock {
	
	//���������
	private final Object MUTEX = new Object();
	
	//��ǰ�ж��ٸ��߳�����д��
	private int writingWriters = 0;
	
	//��ǰ�ж��ٸ��߳����ڵȴ�
	private int waitingWriters = 0;
	
	//��ǰ�ж��ٸ������߳�
	private int readingReaders = 0;
	
	//read��write��ƫ������
	private boolean preferWriter;
	
	//Ĭ�������preferWriterΪ true
	public ReadWriteLockImpl()
	{
		this(true);
	}
	public ReadWriteLockImpl(boolean preferWriter)
	{
		this.preferWriter = preferWriter;
	}
	
	
	@Override
	//����read lock
	public Lock readLock() {
		return new ReadLock(this);
	}

	@Override
	public Lock writeLock() {
		return new WriteLock(this);
	}
	
	//ʹд���߳���������
	void incrementWritingWriters() 
	{
		this.writingWriters++;
	}

	//ʹ�ȴ����߳�����
	void incrementWaitingWriters()
	{
		this.waitingWriters++;
	}
	
	//ʹ���߳���������
	void incrementReadingReaders() 
	{
		this.readingReaders++;
	}
	
	//ʹд���߳���������
	void decrementWritingWriters() 
	{
		this.writingWriters--;
	}
	
	//ʹ�ȴ����߳���������
	void decrementWaitingWriters() 
	{
		this.waitingWriters--;
	}
	
	//ʹ�����߳���������
	void decrementReadingReaders() 
	{
		this.readingReaders--;
	}
	
	//��ȡ��ǰ�ж��ٸ��߳����ڽ���д�Ĳ���
	public int getWritingWriters() 
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
	 * ��ȡ������
	 * @return
	 */
	Object getMutex()
	{
		return this.MUTEX;
	}
	
	//��ȡ��ǰ�Ƿ�ƫ��д��
	boolean getPreferWriter() 
	{
		return this.preferWriter;
	}
	
	//����д��ƫ��
	void changePrefer(boolean preferWriter) 
	{
		this.preferWriter = preferWriter;
	}

}
