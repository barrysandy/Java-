package com.xgb.org.chapter17;
/**
* Lock�ӿ�
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:37:17
*/
public interface Lock {
	
	//��ȡ��ʾ����û�л�������̱߳�����
	void lock() throws InterruptedException;
	
	//�ͷŻ�ȡ����
	void unlock();
}
