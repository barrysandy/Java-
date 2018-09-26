package com.xgb.org.chapter16.eatNood;
/**
* ��ѧ�ҳ���--�����߳�
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:01:13
*/
public class EatNoodThread2 extends Thread{
	
	private final String name;
	
	//�;߷�װ��
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
	
	//�������
	private void eat()
	{
		synchronized (tableWarePair) 
		{
			System.out.println(name + " take up " + tableWarePair.getLeftTool()  + "��left��");
			System.out.println(name + " take up " + tableWarePair.getRightTool()  + "��right��");
			System.out.println(name + " is eating now.");
			System.out.println(name + " put down " + tableWarePair.getRightTool()  + "��right��");
			System.out.println(name + " put down " + tableWarePair.getLeftTool()  + "��left��");
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
