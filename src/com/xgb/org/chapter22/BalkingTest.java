package com.xgb.org.chapter22;
/**
* Balking ������
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��10�� ����10:04:25
*/
public class BalkingTest 
{
	public static void main(String[] args) 
	{
		new DocumentEditThread("G:\\", "balking.txt").start();
	}
}
