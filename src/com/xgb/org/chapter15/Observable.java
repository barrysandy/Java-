package com.xgb.org.chapter15;

public interface Observable {

	//�����������ڵȴ�ö������
	enum Cycle
	{
		STARTRD , RUNING ,DENO ,ERROR 
	}
	
	//��ȡ��ǰ�������������
	Cycle getCycle();
	
	//���������̵߳ķ�������Ҫ������Ϊ������Thread����������
	void start();
	
	//�����̵߳Ĵ�Ϸ�����������start����һ����Ҳ��Ϊ������Thread����������
	void interrupt();
}
