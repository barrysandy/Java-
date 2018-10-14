package com.xgb.org.chapter22;
/**
* Balking 测试类
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月10日 下午10:04:25
*/
public class BalkingTest 
{
	public static void main(String[] args) 
	{
		new DocumentEditThread("G:\\", "balking.txt").start();
	}
}
