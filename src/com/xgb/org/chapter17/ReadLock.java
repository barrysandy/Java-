package com.xgb.org.chapter17;
/**
* ��˵��
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:53:06
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
			//����ʱ���߳����ڽ���д�������������߳��ڵȴ�����ƫ�õı�ʶΪtrueʱ���ͻ��޷���ø�����ֻ�ܱ�����
			while(readWriteLock.getWaitingWriters() > 0 || readWriteLock.getWaitingWriters() > 0)
			{
				readWriteLock.getMutex().wait();
			}
			//�ɹ���ø���������ʹ��readingReaders����������
			readWriteLock.incrementReadingReaders();
		}

	}

	@Override
	public void unlock() {
		synchronized(readWriteLock.getMutex())
		{
			//�ͷ����Ĺ��̾���ʹ�õ�ǰreading��������-
			//��preferWriter����Ϊtrue������ʹwriter�̻߳�ø���Ļ���
			//֪ͨ������Mutex����monitor waitset�е��߳�
			readWriteLock.decrementReadingReaders();
			readWriteLock.changePrefer(true);
			readWriteLock.getMutex().notifyAll();
		}

	}

}
