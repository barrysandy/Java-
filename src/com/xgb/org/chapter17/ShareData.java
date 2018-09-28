package com.xgb.org.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
* ��д����ʹ��-������Դ��
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��28�� ����8:16:54
*/
public class ShareData {
	
	//���干�����ݣ���Դ��
	private final List<Character> container = new ArrayList<>();
	
	//����readWriteLock
	private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();
	
	//������ȡ��
	private final Lock readLock = readWriteLock.readLock();
	
	//����д����
	private final Lock writeLock = readWriteLock.writeLock();
	
	private final int length;
	
	public ShareData(int length)
	{
		this.length = length;
		for (int i = 0; i < length; i++) 
		{
			container.add(i , 'c');
		}
	}
	
	public char[] read() throws InterruptedException
	{
		try {
			//�����ö������� lock
			readLock.lock();
			char[] newBuffer = new char[length];
			for (int i = 0; i < length; i++) {
				newBuffer[i] = container.get(i);
			}
			slowly();
			return newBuffer;
		} finally {
			readLock.unlock();
		}
		
	}
	
	public void write(char c) throws InterruptedException
	{
		try {
			//ʹ��д������lock
			writeLock.lock();
			for (int i = 0; i < length; i++) {
				this.container.add(i, c);
			}
			slowly();
		} finally {
			writeLock.unlock();
		}
	}

	//��ģ�������ʱ
	private void slowly() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
