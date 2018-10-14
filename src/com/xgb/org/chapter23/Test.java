package com.xgb.org.chapter23;

import java.util.concurrent.TimeUnit;

/**
* ������
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��13�� ����10:06:27
*/
public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
		Latch latch = new CountDownLatch(4,null);
		new ProgrammaTravel(latch , "����" , "BUS").start();
		new ProgrammaTravel(latch , "����" , "Walking").start();
		new ProgrammaTravel(latch , "����" , "Subway").start();
		new ProgrammaTravel(latch , "����" , "Bicycle").start();
		
		try 
		{
			latch.await(TimeUnit.SECONDS,5);
		} catch (WaitTimeOutException e) 
		{
			System.out.println("��ʱ��ĳ��...");
			e.printStackTrace();
		}
		
		System.out.println(" == all of programmer arrived ==");
	}
}
