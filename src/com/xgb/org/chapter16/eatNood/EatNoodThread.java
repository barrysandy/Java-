package com.xgb.org.chapter16.eatNood;
/**
* ��ѧ�ҳ���--�����߳�
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:01:13
*/
public class EatNoodThread extends Thread{
	
	private final String name;
	
	//���ֱ�Ĳ;�
	private final Tableware lefeTool;
	
	//���ֱߵĲ;�
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
	
	//�������
	private void eat()
	{
		synchronized (lefeTool) 
		{
			System.out.println(name + " take up " + lefeTool  + "��left��");
			synchronized (rightTool) 
			{
				System.out.println(name + " take up " + rightTool  + "��right��");
				System.out.println(name + " is eating now.");
				System.out.println(name + " put down " + rightTool  + "��right��");
			}
			System.out.println(name + " put down " + lefeTool  + "��left��");
		}
	}
	
	
	public static void main(String[] args) {
		Tableware fork = new Tableware("fork");
		Tableware knife = new Tableware("knife");
		new EatNoodThread("A", fork, knife).start();
		new EatNoodThread("B", knife, fork).start();
	}
}
