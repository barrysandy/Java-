package com.xgb.org.chapter23;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
* 模拟程序员乘坐不同的交通工具到达目的地
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月13日 上午8:27:57
*/
public class ProgrammaTravel extends Thread{

	//门阀
	private final Latch latch;
	
	//程序员
	private String programmer;
	
	//交通工具
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
			//程序员乘坐交通工具花费在路上的时间（使用随机数字模拟）
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(programmer + " Arrived by " + transportation);
		
		//当任务完成时使计数器减一
		latch.countDown();
	}
	
}
