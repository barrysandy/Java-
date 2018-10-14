package com.xgb.org.chapter23;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
* ģ�����Ա������ͬ�Ľ�ͨ���ߵ���Ŀ�ĵ�
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��13�� ����8:27:57
*/
public class ProgrammaTravel extends Thread{

	//�ŷ�
	private final Latch latch;
	
	//����Ա
	private String programmer;
	
	//��ͨ����
	private String transportation;
	
	public ProgrammaTravel(Latch latch,String programmer ,String transportation)
	{
		this.latch = latch;
		this.programmer = programmer;
		this.transportation = transportation;
	}
	
	@Override
	public void run()
	{
		System.out.println( programmer + " start take the transportation[" + transportation + "]");
		try 
		{
			//����Ա������ͨ���߻�����·�ϵ�ʱ�䣨ʹ���������ģ�⣩
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(programmer + " Arrived by " + transportation);
		
		//���������ʱʹ��������һ
		latch.countDown();
	}
	
}
