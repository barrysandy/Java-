package com.xgb.org.chapter16.eatNood;
/**
* 哲学家吃面--吃面线程
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:01:13
*/
public class EatNoodThread2 extends Thread{
	
	private final String name;
	
	//餐具封装类
	private final TableWarePair tableWarePair;
	
	
	public EatNoodThread2(String name,TableWarePair tableWarePair)
	{
		this.name = name;
		this.tableWarePair = tableWarePair;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			this.eat();
		}
	}
	
	//吃面过程
	private void eat()
	{
		synchronized (tableWarePair) 
		{
			System.out.println(name + " take up " + tableWarePair.getLeftTool()  + "（left）");
			System.out.println(name + " take up " + tableWarePair.getRightTool()  + "（right）");
			System.out.println(name + " is eating now.");
			System.out.println(name + " put down " + tableWarePair.getRightTool()  + "（right）");
			System.out.println(name + " put down " + tableWarePair.getLeftTool()  + "（left）");
		}
	}
	
	
	public static void main(String[] args) {
		Tableware fork = new Tableware("fork");
		Tableware knife = new Tableware("knife");
		TableWarePair tableWarePair = new TableWarePair(fork, knife);
		new EatNoodThread2("A", tableWarePair).start();
		new EatNoodThread2("B", tableWarePair).start();
	}
}
