package com.xgb.org.chapter16.eatNood;
/**
* 哲学家吃面-- 改进类
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:11:08
*/
public class TableWarePair {
	private final Tableware leftTool;
	
	private final Tableware rightTool;
	
	public TableWarePair(Tableware leftTool,Tableware rightTool)
	{
		this.leftTool = leftTool;
		this.rightTool = rightTool;
	}
	
	public Tableware getLeftTool()
	{
		return leftTool;
	}
	
	public Tableware getRightTool()
	{
		return rightTool;
	}
}
