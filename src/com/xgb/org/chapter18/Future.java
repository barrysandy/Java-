package com.xgb.org.chapter18;


public interface Future<T> 
{

	//���ؼ����Ľ�����÷�������������״̬
	T get() throws InterruptedException;
	
	//�ж������Ƿ��Ѿ���ִ��
	boolean done();
}
