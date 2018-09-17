package com.xgb.org.chapter8.threadInterface;

/**
 * ��Ҫ������һ���̳߳�Ӧ�þ߱��Ļ��������ͷ���
 * @author XuGongBin
 *
 */
public interface ThreadPool {

	//�ύ�����̳߳�
	void execute(Runnable runnable);
	
	//�ر��̳߳�
	void shuotdown();
	
	//��ȡ�̳߳صĳ�ʼ����С
	int getInitSize();
	
	//��ȡ�̳߳ص������߳���
	int getMaxSize();
	
	//��ȡ�̳߳صĺ����̵߳�����
	int getCoreSize();
	
	//��ȡ�̳߳������ڻ���������еĴ�С
	int getQueueSize();
	
	//��ȡ�̳߳��л�Ծ�̵߳�����
	int getActiveCount();
	
	//�鿴�߳��Ƿ�shutdown
	boolean isShutdown();
}
