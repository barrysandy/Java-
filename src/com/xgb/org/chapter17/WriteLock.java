package com.xgb.org.chapter17;
/**
* д��
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:53:06
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
				//����ʹ�ȴ���ȡд���������ּ�-
				readWriteLock.incrementWaitingWriters();
				//�����ʱ�������߳����ڽ��ж�����������д��������ô��ǰ�߳̽�������
				while(readWriteLock.getReadingReader() > 0 || readWriteLock.getWritingWriters() > 0)  
				{
					readWriteLock.getMutex().wait();
				}
			} finally {
				//�ɹ���ȡ��д������ʹ�õȴ���ȡд�����ļ�������-
				this.readWriteLock.decrementWaitingWriters();
			}
			//������д����߳�������-
			readWriteLock.incrementWritingWriters();
		}

	}

	@Override
	public void unlock() {
		synchronized(readWriteLock.getMutex())
		{
			//��������д�������̼߳�����
			readWriteLock.decrementWritingWriters();
			//��ƫ��״̬�޸�Ϊfalse������ʹ�ö��������Ļ��
			readWriteLock.changePrefer(false);
			//֪ͨ���������� Mutext monitor waitset�е��߳�
			readWriteLock.getMutex().notifyAll();
		}

	}

}
