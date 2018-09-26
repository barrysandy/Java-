package com.xgb.org.chapter16.eatNood;
/**
* 哲学家吃面--吃面线程
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:01:13
*/
public class EatNoodThread extends Thread{
	
	private final String name;
	
	//左手变的餐具
	private final Tableware lefeTool;
	
	//右手边的餐具
	private final Tableware rightTool;
	
	public EatNoodThread(String name,Tableware lefeTool,Tableware rightTool)
	{
		this.name = name;
		this.lefeTool = lefeTool;
		this.rightTool = rightTool;
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
		synchronized (lefeTool) 
		{
			System.out.println(name + " take up " + lefeTool  + "（left）");
			synchronized (rightTool) 
			{
				System.out.println(name + " take up " + rightTool  + "（right）");
				System.out.println(name + " is eating now.");
				System.out.println(name + " put down " + rightTool  + "（right）");
			}
			System.out.println(name + " put down " + lefeTool  + "（left）");
		}
	}
	
	
	public static void main(String[] args) {
		Tableware fork = new Tableware("fork");
		Tableware knife = new Tableware("knife");
		new EatNoodThread("A", fork, knife).start();
		new EatNoodThread("B", knife, fork).start();
	}
}
