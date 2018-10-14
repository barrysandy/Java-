package com.xgb.org.chapter23;

import java.util.concurrent.TimeUnit;

/**
* һ�����޵ȴ��ĳ�����Latch
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��13�� ����8:07:03
*/
public abstract class Latch {

	//ͬ�ڿ��ƶ���߳��������ʱ���ܿ�������
	protected int limit;
	
	public Latch(int limit)
	{
		this.limit = limit;
	}
	
	//�÷���ʹ�õ�ǰ�߳�һֱ�ȴ���ֱ�����е��̶߳���ɹ��������������߳��������жϵ�
	public abstract void await() throws InterruptedException;
	
	//���ӿɳ�ʱ�ĳ��󷽷�
	public abstract void await(TimeUnit unti,long time) throws InterruptedException ,WaitTimeOutException;
	
	//�������߳���ɹ���֮����ø÷���ʹ�ü�������һ
	public abstract void countDown();
	
	//��ȡ��ǰ���ж��ٸ��߳�û���������
	public abstract int getUnarrived();
	
	
	
}
