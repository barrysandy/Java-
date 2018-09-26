package com.xgb.org.chapter17;
/**
* �����ӿ�
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:39:18
*/
public interface ReadWriteLock {
	
	//����reader��
	Lock readLock();
	
	//����write��
	Lock writeLock();
	
	//��ȡ��ǰ�ж��ٸ��߳����ڵȴ���ȡwrite��
	int getWaitingWriters();
	
	//��ȡ��ǰ�ж��ٸ��߳����ڵȴ���ȡreader��
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
