package com.xgb.org.chapter23;

import java.util.concurrent.TimeUnit;

/**
* 测试类
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月13日 上午10:06:27
*/
public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
		Latch latch = new CountDownLatch(4,null);
		new ProgrammaTravel(latch , "李丽" , "BUS").start();
		new ProgrammaTravel(latch , "凯文" , "Walking").start();
		new ProgrammaTravel(latch , "杰西" , "Subway").start();
		new ProgrammaTravel(latch , "洛瑶" , "Bicycle").start();
		
		try 
		{
			latch.await(TimeUnit.SECONDS,5);
		} catch (WaitTimeOutException e) 
		{
			System.out.println("超时做某事...");
			e.printStackTrace();
		}
		
		System.out.println(" == all of programmer arrived ==");
	}
}
