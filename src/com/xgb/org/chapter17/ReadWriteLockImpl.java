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
	 * ��ȡ������
	 * @return
	 */
	Object getMutex()
	{
		return this.MUTEX;
	}

}
